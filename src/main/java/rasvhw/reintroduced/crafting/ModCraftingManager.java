package rasvhw.reintroduced.crafting;

import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.CraftingManager;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import rasvhw.reintroduced.ReIntroduced;
import rasvhw.reintroduced.block.ModBlocks;

public class ModCraftingManager {
    public static void register(){
        //add recipes
        CraftingManager craftingManager = CraftingManager.getInstance();
        craftingManager.addRecipe(
                new ItemStack(ModBlocks.netherreactor, 1),
                "ABA", "ABA", "ABA",
                Character.valueOf('A'),
                new ItemStack(Item.ingotIron),
                Character.valueOf('B'),
                new ItemStack(Item.diamond)
        );
        craftingManager.addRecipe(
                new ItemStack(ModBlocks.glowingobsidian, 3),
                "AAA","ABA","AAA",
                Character.valueOf('A'),
                new ItemStack(Item.dustGlowstone),
                Character.valueOf('B'),
                new ItemStack(Block.obsidian)
        );

        ReIntroduced.LOGGER.info("Registering ModCraftingManager for " + ReIntroduced.MOD_ID);
    }
}
