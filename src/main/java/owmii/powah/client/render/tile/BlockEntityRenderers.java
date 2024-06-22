package owmii.powah.client.render.tile;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import owmii.powah.block.Tiles;

public class BlockEntityRenderers {
    public static void register(EntityRenderersEvent.RegisterRenderers e) {
        e.registerBlockEntityRenderer(Tiles.CABLE.get(), CableRenderer::new);
        e.registerBlockEntityRenderer(Tiles.ENERGIZING_ORB.get(), EnergizingOrbRenderer::new);
        e.registerBlockEntityRenderer(Tiles.ENERGIZING_ROD.get(), EnergizingRodRenderer::new);
        e.registerBlockEntityRenderer(Tiles.FURNATOR.get(), FurnatorRenderer::new);
        e.registerBlockEntityRenderer(Tiles.MAGMATOR.get(), MagmatorRenderer::new);
        e.registerBlockEntityRenderer(Tiles.REACTOR.get(), ReactorRenderer::new);
        e.registerBlockEntityRenderer(Tiles.REACTOR_PART.get(), ReactorPartRenderer::new);
    }
}
