package com.PlanetCore.util.handlers;

import com.PlanetCore.entity.EntityBlackDemon;
import com.PlanetCore.entity.EntityDemon;
import com.PlanetCore.entity.EntityGhoul;
import com.PlanetCore.entity.EntityHellHound;
import com.PlanetCore.entity.render.RenderBlackDemon;
import com.PlanetCore.entity.render.RenderDemon;
import com.PlanetCore.entity.render.RenderGhoul;
import com.PlanetCore.entity.render.RenderHellHound;
import com.PlanetCore.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
	{

		public static void registerEntityRenders()
		{
		//Demon
		RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, new IRenderFactory<EntityDemon>()
		{

			@Override
			public Render<? super EntityDemon> createRenderFor(RenderManager manager) {
				return new RenderDemon(manager);
			}
		});
		//Black demon
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackDemon.class, new IRenderFactory<EntityBlackDemon>()
		{
		
		@Override
		public Render<? super EntityBlackDemon> createRenderFor(RenderManager manager) {
			return new RenderBlackDemon(manager);
			}
		});
		//Ghoul
		RenderingRegistry.registerEntityRenderingHandler(EntityGhoul.class, new IRenderFactory<EntityGhoul>()
		{
		
		@Override
		public Render<? super EntityGhoul> createRenderFor(RenderManager manager) {
			return new RenderGhoul(manager);
			}
		});
		//HellHound
		RenderingRegistry.registerEntityRenderingHandler(EntityHellHound.class, new IRenderFactory<EntityHellHound>()
		{
				
		@Override
		public Render<? super EntityHellHound> createRenderFor(RenderManager manager) {
			return new RenderHellHound(manager);
			}
		});
	}
	
	public static void registerCustomMeshesAndStates()
		{
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.HOT_LAVA_BLOCK), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:hot_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.HOT_LAVA_BLOCK, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:hot_lava", "fluid");
				}
			});

		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.CORE_LAVA_BLOCK), new ItemMeshDefinition() {

			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {

				return new ModelResourceLocation("planetcore:core_lava", "fluid");

			}
		});

		ModelLoader.setCustomStateMapper(ModBlocks.CORE_LAVA_BLOCK, new StateMapperBase() {

			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

				return new ModelResourceLocation("planetcore:core_lava", "fluid");
			}
		});

			ModelLoader.setCustomStateMapper(ModBlocks.SULFURIC_ACID_BLOCK, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:sulfuric_acid", "fluid");
				}
			});
	}


}
