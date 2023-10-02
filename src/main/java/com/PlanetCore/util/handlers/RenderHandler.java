package com.PlanetCore.util.handlers;

import com.PlanetCore.entity.*;
import com.PlanetCore.entity.render.*;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.items.Drills.DrillRender;
import com.PlanetCore.items.arrows.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler
	{

		public static void registerEntityRenders() {
			ModItems.IRON_DRILL.setTileEntityItemStackRenderer(new DrillRender("iron_drill"));
			ModItems.DIAMOND_DRILL.setTileEntityItemStackRenderer(new DrillRender("diamond_drill"));
			ModItems.TITANIUM_DRILL.setTileEntityItemStackRenderer(new DrillRender("titanium_drill"));
			ModItems.URANIUM_DRILL.setTileEntityItemStackRenderer(new DrillRender("uranium_drill"));
			ModItems.TUNGSTEN_DRILL.setTileEntityItemStackRenderer(new DrillRender("tungsten_drill"));
			ModItems.RUBY_DRILL.setTileEntityItemStackRenderer(new DrillRender("ruby_drill"));
			ModItems.SAPPHIRE_DRILL.setTileEntityItemStackRenderer(new DrillRender("sapphire_drill"));
			ModItems.MAJORITE_DRILL.setTileEntityItemStackRenderer(new DrillRender("majorite_drill"));
			ModItems.AMAZONITE_DRILL.setTileEntityItemStackRenderer(new DrillRender("amazonite_drill"));
			ModItems.ONYX_DRILL.setTileEntityItemStackRenderer(new DrillRender("onyx_drill"));

			//Demon
			RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, RenderDemon::new);

			RenderingRegistry.registerEntityRenderingHandler(EntityDemon.class, RenderDemon::new);

			//Core Demon
			RenderingRegistry.registerEntityRenderingHandler(EntityCoreDemon.class, RenderCoreDemon::new);

			//Onyx Demon
			RenderingRegistry.registerEntityRenderingHandler(EntityOnyxDemon.class, RenderOnyxDemon::new);

			//Ghoul
			RenderingRegistry.registerEntityRenderingHandler(EntityGhoul.class, RenderGhoul::new);
			//HellHound
			RenderingRegistry.registerEntityRenderingHandler(EntityHellHound.class, RenderHellHound::new);

			//Death Enderman
			RenderingRegistry.registerEntityRenderingHandler(EntityDeathEnderman.class, RenderDeathEnderman::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityVeryHotMagmaCube.class, RenderVeryHotMagmaCube::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityHotMagmaCube.class, RenderHotMagmaCube::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityMagmaZombie.class, RenderMagmaZombie::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityCoreBlaze.class, RenderCoreBlaze::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityHotBlaze.class, RenderHotBlaze::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityCoreBlaze.class, RenderCoreBlaze::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityDiamondArrow.class, RenderDiamondArrow::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityRubyArrow.class, RenderRubyArrow::new);
			RenderingRegistry.registerEntityRenderingHandler(EntitySapphireArrow.class, RenderSapphireArrow::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityMajoriteArrow.class, RenderMajoriteArrow::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityAmazoniteArrow.class, RenderAmazoniteArrow::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityOnyxArrow.class, RenderOnyxArrow::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityOnyxArrowII.class, RenderOnyxArrowII::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityOnyxArrowIII.class, RenderOnyxArrowIII::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityOnyxArrowIV.class, RenderOnyxArrowIV::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityOnyxArrowV.class, RenderOnyxArrowV::new);
			RenderingRegistry.registerEntityRenderingHandler(EntityCoreLargeFireball.class, manager -> new RenderCoreLargeFireball(manager, 1));
			RenderingRegistry.registerEntityRenderingHandler(EntityOnyxFireball.class, manager -> new RenderOnyxFireball(manager, 1));


		}
	
	public static void registerCustomMeshesAndStates()
		{
			/** iron lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.IRON_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:iron_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.IRON_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:iron_lava", "fluid");
				}
			});

			/** superheated lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.SUPERHEATED_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:superheated_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.SUPERHEATED_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:superheated_lava", "fluid");
				}
			});

			/** redstone lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.REDSTONE_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:redstone_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.REDSTONE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:redstone_lava", "fluid");
				}
			});

			/** silver lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.SILVER_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:silver_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.SILVER_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:silver_lava", "fluid");
				}
			});

			/** gold lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.GOLD_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:gold_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.GOLD_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:gold_lava", "fluid");
				}
			});

			/** diamond lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.DIAMOND_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:diamond_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.DIAMOND_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:diamond_lava", "fluid");
				}
			});

			/** titanium lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.TITANIUM_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:titanium_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.TITANIUM_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:titanium_lava", "fluid");
				}
			});

			/** uranium lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.URANIUM_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:uranium_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.URANIUM_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:uranium_lava", "fluid");
				}
			});

			/** tungsten lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.TUNGSTEN_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:tungsten_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.TUNGSTEN_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:tungsten_lava", "fluid");
				}
			});

			/** ruby lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.RUBY_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:ruby_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.RUBY_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:ruby_lava", "fluid");
				}
			});

			/** sapphire lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.SAPPHIRE_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:sapphire_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.SAPPHIRE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:sapphire_lava", "fluid");
				}
			});

			/** majorite lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.MAJORITE_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:majorite_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.MAJORITE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:majorite_lava", "fluid");
				}
			});

			/** amazonite lava */
			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.AMAZONITE_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:amazonite_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.AMAZONITE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:amazonite_lava", "fluid");
				}
			});

			ModelLoader.setCustomStateMapper(ModBlocks.ONYX_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:onyx_lava", "fluid");
				}
			});

			ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.PAINITE_LAVA_FLUID), stack -> new ModelResourceLocation("planetcore:painite_lava", "fluid"));

			ModelLoader.setCustomStateMapper(ModBlocks.PAINITE_LAVA_FLUID, new StateMapperBase() {

				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {

					return new ModelResourceLocation("planetcore:painite_lava", "fluid");
				}
			});
	}


}
