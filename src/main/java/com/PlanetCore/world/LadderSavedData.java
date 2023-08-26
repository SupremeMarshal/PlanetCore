package com.PlanetCore.world;

import com.PlanetCore.util.Reference;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class LadderSavedData extends WorldSavedData {

    private final List<Pillar> pillars = new ArrayList<>();

    public static final String ID = Reference.MOD_ID+"_ladders";

    public LadderSavedData(String name) {
        super(name);
    }

    public LadderSavedData() {
        super(ID);
    }

    public List<Pillar> getPillars() {
        return pillars;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        pillars.clear();
        NBTTagList nbtTagList = nbt.getTagList("ladders", Constants.NBT.TAG_COMPOUND);
        for (NBTBase nbtBase : nbtTagList) {
            NBTTagCompound nbtTagCompound = (NBTTagCompound) nbtBase;
            int[] ints = nbtTagCompound.getIntArray("pos");
            BlockPos pos = new BlockPos(ints[0], ints[1], ints[2]);
            int height = nbtTagCompound.getInteger("height");
            pillars.add(Pillar.of(pos, height));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagList nbtTagList = new NBTTagList();
        for (Pillar entry : pillars) {
            BlockPos pos = entry.getBase();
            int height = entry.getHeight();
            if (height > 0) {
                NBTTagCompound nbtTagCompound = new NBTTagCompound();
                nbtTagCompound.setIntArray("pos", new int[]{pos.getX(), pos.getY(), pos.getZ()});
                nbtTagCompound.setInteger("height", height);
                nbtTagList.appendTag(nbtTagCompound);
            }
        }
        compound.setTag("ladders", nbtTagList);
        return compound;
    }

    public void addPos(BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        boolean addedToExistingPillar = false;

        boolean checkBelowForMerge = false;
        boolean checkAboveForMerge = false;
        Pillar main = null;

        //look for existing pillars to merge with
        for (Pillar pillar : pillars) {
            BlockPos base = pillar.getBase();
            BlockPos top = pillar.getTop();
            if (base.getX() == x && base.getZ() == z) {
                //there's 5 cases
                //case 1, the position is below existing pillar, continue searching
                if (y < base.getY() - 1) {
                    continue;
                    //case 2, the position is at the bottom of existing pillar, move down, add 1 to height
                } else if (y == base.getY() - 1) {
                    pillar.setBase(base.down());
                    pillar.setHeight(pillar.getHeight() + 1);
                    addedToExistingPillar = true;
                    checkBelowForMerge = true;
                    main = pillar;
                    break;
                    //case 3, the new position is in the middle of existing pillar, stop searching and return
                } else if (y >= base.getY() && y <= top.getY()) {
                    return;
                    //case 4, the new position is on top of existing pillar, add one to height
                } else if (y == top.getY() + 1) {
                    pillar.setHeight(pillar.getHeight() + 1);
                    addedToExistingPillar = true;
                    checkAboveForMerge = true;
                    main = pillar;
                    break;
                    //case 5, the position is above existing pillar, continue searching
                } else {
                    continue;
                }
            } else {
                //it's not in the same column, keep looking
            }
        }

        if (checkBelowForMerge) {
            Pillar pillarBelow = findPillarAt(pos.down());
            if (pillarBelow != null) {
                pillarBelow.setHeight(pillarBelow.getHeight() + main.getHeight());
                main.setHeight(0);
            }
        }

        if (checkAboveForMerge) {
            Pillar pillarAbove = findPillarAt(pos.up());
            if (pillarAbove != null) {
                main.setHeight(pillarAbove.getHeight() + main.getHeight());
                pillarAbove.setHeight(0);
            }
        }

        pillars.removeIf(pillar -> pillar.getHeight() <= 0);

        if (!addedToExistingPillar) {
            pillars.add(Pillar.of(pos, 1));
        }
        markDirty();
    }

    public void removePos(BlockPos pos) {

        Pillar pillarToBreak = null;

        for (Pillar p : pillars) {
            if (p.containsPos(pos)) {
                pillarToBreak = p;
                break;
            }
        }

        if (pillarToBreak != null) {
            int height = pillarToBreak.getHeight();
            if (height < 2) {
                pillars.remove(pillarToBreak);
            } else {
                int diff = pos.getY() - pillarToBreak.getBase().getY();
                //breaking the base, shift base up by 1 and decrease height by 1
                if (diff == 0) {
                    pillarToBreak.setBase(pillarToBreak.getBase().up());
                    pillarToBreak.setHeight(pillarToBreak.getHeight() - 1);
                } else {

                    //breaking the top
                    if (pillarToBreak.getTop().equals(pos)) {
                        pillarToBreak.setHeight(pillarToBreak.getHeight() - 1);
                        //the middle
                    } else {
                        int newHeight = pos.getY() - pillarToBreak.getBase().getY();
                        pillarToBreak.setHeight(newHeight);

                        Pillar pillar2 = Pillar.of(pos.up(),height - newHeight - 1);
                        pillars.add(pillar2);
                    }
                }
            }

            markDirty();
        }
    }

    public Pillar findPillarAt(BlockPos pos) {
        for (Pillar pillar : pillars) {
            if (pillar.containsPos(pos)) {
                return pillar;
            }
        }
        return null;
    }
}
