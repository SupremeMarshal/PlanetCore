package com.PlanetCore.proxy;

import com.PlanetCore.Main;
import com.PlanetCore.anvils.generic.BlockGenericAnvil;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Iterator;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerModel(Item item, int metadata) 
	{
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));

	}

	//Extra Anvils -- Client Proxy
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		Iterator var1 = Main.anvils.iterator();

		while(var1.hasNext()) {
			BlockGenericAnvil anvil = (BlockGenericAnvil)var1.next();
			anvil.registerModel();
		}

	}
	//---
	
	
}


