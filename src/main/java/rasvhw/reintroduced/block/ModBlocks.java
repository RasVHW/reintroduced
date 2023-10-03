package rasvhw.reintroduced.block;

import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import rasvhw.reintroduced.ReIntroduced;
import rasvhw.reintroduced.block.custom.NetherReactor;
import turniplabs.halplibe.helper.BlockBuilder;
import static rasvhw.reintroduced.ReIntroduced.MOD_ID;

public class ModBlocks {
    //Blocks
    //Nether Reactor(s)
    public static final Block netherreactor = new BlockBuilder(MOD_ID)
            .setBlockSound(BlockSounds.STONE)
            .setHardness(2.0f)
            .setResistance(2.0f)
            .setTextures("netherreactor.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new NetherReactor("netherreactor",1200, Material.metal));
    public static final Block activatednetherreactor = new BlockBuilder(MOD_ID)
            .setBlockSound(BlockSounds.STONE)
            .setHardness(2.0f)
            .setResistance(2.0f)
            .setTextures("activatednetherreactor.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("activatednetherreactor",1201,Material.metal));
    public static final Block finishednetherreactor = new BlockBuilder(MOD_ID)
            .setBlockSound(BlockSounds.STONE)
            .setHardness(2.0f)
            .setResistance(2.0f)
            .setTextures("finishednetherreactor.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .build(new Block("finishednetherreactor",1202,Material.metal));

    //Glowing Obsidian(s)
    public static final Block glowingobsidian = new BlockBuilder(MOD_ID)
            .setBlockSound(BlockSounds.STONE)
            .setHardness(50.0f)
            .setResistance(1200.0f)
            .setTextures("glowingobsidian.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .setLuminance(12)
            .build(new Block("glowingobsidian",1203,Material.stone));
    public static final Block glowingobsidiantiles = new BlockBuilder(MOD_ID)
            .setBlockSound(BlockSounds.STONE)
            .setHardness(50.0f)
            .setResistance(1200.0f)
            .setTextures("glowing_obsidian_tiles.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .setLuminance(12)
            .build(new Block("glowingobsidiantiles",1204,Material.stone));
    public static final Block glowingobsidianbricks = new BlockBuilder(MOD_ID)
            .setBlockSound(BlockSounds.STONE)
            .setHardness(50.0f)
            .setResistance(1200.0f)
            .setTextures("glowing_obsidian_bricks.png")
            .setTags(BlockTags.MINEABLE_BY_PICKAXE)
            .setLuminance(12)
            .build(new Block("glowingobsidianbricks",1205,Material.stone));

    public static void register() {
        ItemToolPickaxe.miningLevels.put(ModBlocks.glowingobsidian,3);

        ReIntroduced.LOGGER.info("Registering ModBlocks for " + ReIntroduced.MOD_ID);
    }
}
