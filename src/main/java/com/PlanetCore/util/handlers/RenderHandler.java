package com.PlanetCore.util.handlers;

import com.PlanetCore.entity.*;
import com.PlanetCore.entity.render.*;
import com.PlanetCore.init.ModBlocks;

import com.PlanetCore.items.arrows.EntityEmeraldArrow;
import com.PlanetCore.items.arrows.RenderEmeraldArrow;
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
import org.lwjgl.opengl.GL11;

public class RenderHandler
	{

		public static void registerEntityRenders() {
			//Demon
			RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, new IRenderFactory<EntityDemon>() {

				@Override
				public Render<? super EntityDemon> createRenderFor(RenderManager manager) {
					return new RenderDemon(manager);
				}
			});

			//Core Demon
			RenderingRegistry.registerEntityRenderingHandler(EntityCoreDemon.class, new IRenderFactory<EntityCoreDemon>() {
				@Override
				public Render<? super EntityCoreDemon> createRenderFor(RenderManager manager) {
					return new RenderCoreDemon(manager);
				}
			});

			//Ghoul
			RenderingRegistry.registerEntityRenderingHandler(EntityGhoul.class, new IRenderFactory<EntityGhoul>() {

				@Override
				public Render<? super EntityGhoul> createRenderFor(RenderManager manager) {
					return new RenderGhoul(manager);
				}
			});
			//HellHound
			RenderingRegistry.registerEntityRenderingHandler(EntityHellHound.class, new IRenderFactory<EntityHellHound>() {

				@Override
				public Render<? super EntityHellHound> createRenderFor(RenderManager manager) {
					return new RenderHellHound(manager);
				}
			});

			//Death Enderman
			RenderingRegistry.registerEntityRenderingHandler(EntityDeathEnderman.class, new IRenderFactory<EntityDeathEnderman>() {

				@Override
				public Render<? super EntityDeathEnderman> createRenderFor(RenderManager manager) {
					return new RenderDeathEnderman(manager);
				}
			});
			RenderingRegistry.registerEntityRenderingHandler(EntityCoreBlaze.class, manager -> new RenderCoreBlaze(manager));
			RenderingRegistry.registerEntityRenderingHandler(EntityHotBlaze.class, manager -> new RenderHotBlaze(manager));
			RenderingRegistry.registerEntityRenderingHandler(EntityCoreBlaze.class, manager -> new RenderCoreBlaze(manager));
			RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldArrow.class, manager -> new RenderEmeraldArrow(manager));


		}
	
	public static void registerCustomMeshesAndStates()
		{
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.IRON_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:amazonite_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.IRON_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:iron_lava", "fluid");
				}
			});

			/** aluminium lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.ALUMINIUM_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:aluminium_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.ALUMINIUM_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:aluminium_lava", "fluid");
				}
			});

			/** tin lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.TIN_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:tin_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.TIN_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:tin_lava", "fluid");
				}
			});

			/** copper lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.COPPER_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:copper_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.COPPER_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:copper_lava", "fluid");
				}
			});

			/** silver lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.SILVER_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:silver_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.SILVER_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:silver_lava", "fluid");
				}
			});

			/** gold lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.GOLD_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:gold_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.GOLD_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:gold_lava", "fluid");
				}
			});

			/** platinum lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.PLATINUM_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:platinum_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.PLATINUM_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:platinum_lava", "fluid");
				}
			});

			/** titanium lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.TITANIUM_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:titanium_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.TITANIUM_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:titanium_lava", "fluid");
				}
			});

			/** uranium lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.URANIUM_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:uranium_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.URANIUM_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:uranium_lava", "fluid");
				}
			});

			/** tungsten lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.TUNGSTEN_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:tungsten_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.TUNGSTEN_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:tungsten_lava", "fluid");
				}
			});

			/** emerald lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.EMERALD_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:emerald_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.EMERALD_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:emerald_lava", "fluid");
				}
			});

			/** ruby lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.RUBY_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:ruby_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.RUBY_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:ruby_lava", "fluid");
				}
			});

			/** sapphire lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.SAPPHIRE_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:sapphire_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.SAPPHIRE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:sapphire_lava", "fluid");
				}
			});

			/** diamond lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.DIAMOND_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:diamond_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.DIAMOND_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:diamond_lava", "fluid");
				}
			});

			/** olivine lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.OLIVINE_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:olivine_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.OLIVINE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:olivine_lava", "fluid");
				}
			});

			/** wadsleyite lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.WADSLEYITE_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:wadsleyite_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.WADSLEYITE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:wadsleyite_lava", "fluid");
				}
			});

			/** ringwoodite lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.RINGWOODITE_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:ringwoodite_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.RINGWOODITE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:ringwoodite_lava", "fluid");
				}
			});

			/** brigmanite lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.BRIGMANITE_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:brigmanite_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.BRIGMANITE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:brigmanite_lava", "fluid");
				}
			});

			/** majorite lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.MAJORITE_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:majorite_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.MAJORITE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:majorite_lava", "fluid");
				}
			});

			/** amazonite lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.AMAZONITE_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:amazonite_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.AMAZONITE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:amazonite_lava", "fluid");
				}
			});

			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.ACTIVE_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:active_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.ACTIVE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:active_lava", "fluid");
				}
			});

		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.CORE_LAVA_FLUID), new ItemMeshDefinition() {

			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {

				return new ModelResourceLocation("planetcore:core_lava", "fluid");

			}
		});

		ModelLoader.setCustomStateMapper(ModBlocks.CORE_LAVA_FLUID, new StateMapperBase() {

			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

				return new ModelResourceLocation("planetcore:core_lava", "fluid");
			}
		});

			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.CENTERCORE_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:centercore_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.CENTERCORE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:centercore_lava", "fluid");
				}
			});


			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.SULFURIC_ACID_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:sulfuric_acid", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.SULFURIC_ACID_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:sulfuric_acid", "fluid");
				}
			});

			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.ONYX_LAVA_FLUID), new ItemMeshDefinition() {

				@Override
				public ModelResourceLocation getModelLocation(ItemStack stack) {

					return new ModelResourceLocation("planetcore:onyx_lava", "fluid");

				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.ONYX_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:onyx_lava", "fluid");
				}
			});
	}


}
