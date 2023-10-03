package rasvhw.reintroduced;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rasvhw.reintroduced.block.ModBlocks;
import rasvhw.reintroduced.crafting.ModCraftingManager;


public class ReIntroduced implements ModInitializer {
    public static final String MOD_ID = "reintroduced";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModBlocks.register();
        ModCraftingManager.register();

        LOGGER.info("ReIntroduced initialized.");
    }
}
