package com.PlanetCore.proxy;



import com.PlanetCore.Main;
import com.PlanetCore.anvils.EntityFallingAnvil;

import com.PlanetCore.anvils.EnumVariants;
import com.PlanetCore.anvils.GuiHandler;
import com.PlanetCore.anvils.PacketHandler;
import com.PlanetCore.anvils.generic.BlockGenericAnvil;
import net.minecraft.item.Item;

		import net.minecraft.util.ResourceLocation;
		import net.minecraftforge.event.RegistryEvent.Register;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
		import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.Iterator;


public class CommonProxy {



	public void registerModel(Item item, int metadata) {}

	public void init(FMLInitializationEvent e) {
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
		Iterator var2 = Main.anvils.iterator();

		while(var2.hasNext()) {
			BlockGenericAnvil anvil = (BlockGenericAnvil)var2.next();
			switch(anvil.variant) {
				case NORMAL:
					Main.anvilDamageMap.put(anvil, (BlockGenericAnvil) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(anvil.getRegistryName() + "_chipped")));
					break;
				case CHIPPED:
					Main.anvilDamageMap.put(anvil, (BlockGenericAnvil)ForgeRegistries.BLOCKS.getValue(new ResourceLocation(anvil.getRegistryName().toString().replace(EnumVariants.CHIPPED.getString(), "") + EnumVariants.DAMAGED.getString())));
					break;
				case DAMAGED:
					Main.anvilDamageMap.put(anvil, null);
			}
		}

	}

	public void preInit(FMLPreInitializationEvent e) {
		PacketHandler.registerMessages("planetcore1");
	}
}
