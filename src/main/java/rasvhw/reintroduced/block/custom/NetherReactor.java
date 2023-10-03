package rasvhw.reintroduced.block.custom;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.world.World;

public class NetherReactor extends Block {
    public NetherReactor(String key, int id, Material material) {
        super(key, id, material);
    }

    @Override
    public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
        if(!player.isSneaking()&&shrineBuilt(world,x,y,z)){
            activateShrine(world, x, y, z);
            generateSpire(world, x, y, z);
        }
        return true;
    }

    private boolean shrineBuilt(World world, int x, int y, int z) {
        return topLevel(world, x, y, z) && middleLevel(world, x, y, z) && bottomLevel(world, x, y, z);
    }
    private boolean topLevel(World world, int x, int y, int z){
        return world.getBlock(x, y + 1, z) == Block.cobbleStone &&
                world.getBlock(x + 1, y + 1, z) == Block.cobbleStone &&
                world.getBlock(x - 1, y + 1, z) == Block.cobbleStone &&
                world.getBlock(x, y + 1, z + 1) == Block.cobbleStone &&
                world.getBlock(x, y + 1, z - 1) == Block.cobbleStone;
    }
    private boolean middleLevel(World world, int x, int y, int z){
        return world.getBlock(x + 1, y, z + 1) == Block.cobbleStone &&
                world.getBlock(x + 1, y, z - 1) == Block.cobbleStone &&
                world.getBlock(x - 1, y, z + 1) == Block.cobbleStone &&
                world.getBlock(x - 1, y, z - 1) == Block.cobbleStone;
    }
    private boolean bottomLevel(World world, int x, int y, int z){
        return world.getBlock(x, y - 1, z) == Block.cobbleStone &&
                world.getBlock(x + 1, y - 1, z) == Block.cobbleStone &&
                world.getBlock(x - 1, y - 1, z) == Block.cobbleStone &&
                world.getBlock(x, y - 1, z + 1) == Block.cobbleStone &&
                world.getBlock(x, y - 1, z - 1) == Block.cobbleStone &&
                world.getBlock(x + 1, y - 1, z + 1) == Block.blockGold &&
                world.getBlock(x + 1, y - 1, z - 1) == Block.blockGold &&
                world.getBlock(x - 1, y - 1, z + 1) == Block.blockGold &&
                world.getBlock(x - 1, y - 1, z - 1) == Block.blockGold;
    }
    private void activateShrine(World world, int x, int y, int z){
        world.setBlockWithNotify(x,y,z,1201);
        //Top level
        world.setBlockWithNotify(x,y+1,z,1203);
        world.setBlockWithNotify(x+1,y+1,z,1203);
        world.setBlockWithNotify(x-1,y+1,z,1203);
        world.setBlockWithNotify(x,y+1,z+1,1203);
        world.setBlockWithNotify(x,y+1,z-1,1203);
        //Middle level
        world.setBlockWithNotify(x+1,y,z+1,1203);
        world.setBlockWithNotify(x+1,y,z-1,1203);
        world.setBlockWithNotify(x-1,y,z+1,1203);
        world.setBlockWithNotify(x-1,y,z-1,1203);
        //Bottom Level
        world.setBlockWithNotify(x,y-1,z,1203);
        world.setBlockWithNotify(x+1,y-1,z,1203);
        world.setBlockWithNotify(x-1,y-1,z,1203);
        world.setBlockWithNotify(x,y-1,z+1,1203);
        world.setBlockWithNotify(x,y-1,z-1,1203);
        world.setBlockWithNotify(x+1,y-1,z+1,1203);
        world.setBlockWithNotify(x+1,y-1,z-1,1203);
        world.setBlockWithNotify(x-1,y-1,z+1,1203);
        world.setBlockWithNotify(x-1,y-1,z-1,1203);
    }
    private void generateSpire(World world, int x, int y, int z){
        for(int i = -9; i<=9;i++){ //Bottom Floor
            for(int c = -9;c<=9;c++){
                world.setBlockWithNotify(x+i,y-2,z+c, netherrack.id);
            }
        }
        for(int i=-9;i<=9;i++){ //Walls up to roof
            for(int c=-1;c<=2;c++) {
                world.setBlockWithNotify(x+i,y+c,z+9, netherrack.id);
                world.setBlockWithNotify(x+i,y+c,z-9, netherrack.id);
                world.setBlockWithNotify(x+9,y+c,z+i, netherrack.id);
                world.setBlockWithNotify(x-9,y+c,z+i, netherrack.id);
            }
        }
        for(int i = -9; i<=9;i++){ //Roof
            for(int c = -9;c<=9;c++){
                world.setBlockWithNotify(x+i,y+3,z+c, netherrack.id);
            }
        }
        for(int i=-9;i<=9;i++){ //Walls of outer spire
            for(int c=4;c<=5;c++) {
                world.setBlockWithNotify(x+i,y+c,z+9, netherrack.id);
                world.setBlockWithNotify(x+i,y+c,z-9, netherrack.id);
                world.setBlockWithNotify(x+9,y+c,z+i, netherrack.id);
                world.setBlockWithNotify(x-9,y+c,z+i, netherrack.id);
            }
        }

        //Positive Z Spiral
        //1st
        for(int i=-8;i<=9;i++){
            world.setBlockWithNotify(x+i,y+6,z+9, netherrack.id);
        }
        for(int i=-6;i<=9;i++) {
            world.setBlockWithNotify(x+i,y+7,z+9,netherrack.id);
        }
        for(int i=-4;i<=9;i++){
            world.setBlockWithNotify(x+i,y+8,z+9,netherrack.id);
        }
        for(int i=-2;i<=9;i++){
            world.setBlockWithNotify(x+i,y+9,z+9,netherrack.id);
        }
        for(int i=0;i<=9;i++){
            world.setBlockWithNotify(x+i,y+10,z+9,netherrack.id);
        }
        for(int i=2;i<=9;i++){
            world.setBlockWithNotify(x+i,y+11,z+9,netherrack.id);
        }
        for(int i=4;i<=9;i++){
            world.setBlockWithNotify(x+i,y+12,z+9,netherrack.id);
        }
        for(int i=6;i<=9;i++){
            world.setBlockWithNotify(x+i,y+13,z+9,netherrack.id);
        }
        for(int i=8;i<=9;i++){
            world.setBlockWithNotify(x+i,y+14,z+9,netherrack.id);
        }

        //2nd
        for(int i=-9;i<=9;i++){
            world.setBlockWithNotify(x+i,y+6,z+8, netherrack.id);
        }
        for(int i=-7;i<=9;i++) {
            world.setBlockWithNotify(x+i,y+7,z+8,netherrack.id);
        }
        for(int i=-5;i<=9;i++){
            world.setBlockWithNotify(x+i,y+8,z+8,netherrack.id);
        }
        for(int i=-3;i<=9;i++){
            world.setBlockWithNotify(x+i,y+9,z+8,netherrack.id);
        }
        for(int i=-1;i<=9;i++){
            world.setBlockWithNotify(x+i,y+10,z+8,netherrack.id);
        }
        for(int i=1;i<=9;i++){
            world.setBlockWithNotify(x+i,y+11,z+8,netherrack.id);
        }
        for(int i=3;i<=9;i++){
            world.setBlockWithNotify(x+i,y+12,z+8,netherrack.id);
        }
        for(int i=5;i<=9;i++){
            world.setBlockWithNotify(x+i,y+13,z+8,netherrack.id);
        }
        for(int i=7;i<=9;i++){
            world.setBlockWithNotify(x+i,y+14,z+8,netherrack.id);
        }

        //3rd
        for(int i=-9;i<=9;i++){
            world.setBlockWithNotify(x+i,y+6,z+7, netherrack.id);
        }
        for(int i=-8;i<=9;i++) {
            world.setBlockWithNotify(x+i,y+7,z+7,netherrack.id);
        }
        for(int i=-6;i<=9;i++){
            world.setBlockWithNotify(x+i,y+8,z+7,netherrack.id);
        }
        for(int i=-4;i<=9;i++){
            world.setBlockWithNotify(x+i,y+9,z+7,netherrack.id);
        }
        for(int i=-2;i<=9;i++){
            world.setBlockWithNotify(x+i,y+10,z+7,netherrack.id);
        }
        for(int i=0;i<=9;i++){
            world.setBlockWithNotify(x+i,y+11,z+7,netherrack.id);
        }
        for(int i=2;i<=9;i++){
            world.setBlockWithNotify(x+i,y+12,z+7,netherrack.id);
        }
        for(int i=4;i<=9;i++){
            world.setBlockWithNotify(x+i,y+13,z+7,netherrack.id);
        }
        for(int i=6;i<=9;i++){
            world.setBlockWithNotify(x+i,y+14,z+7,netherrack.id);
        }

        //Negative X Spiral
        //1st
        for(int i=-8;i<=9;i++){
            world.setBlockWithNotify(x-9,y+6,z-i, netherrack.id);
        }
        for(int i=-6;i<=9;i++) {
            world.setBlockWithNotify(x-9,y+7,z-i,netherrack.id);
        }
        for(int i=-4;i<=9;i++){
            world.setBlockWithNotify(x-9,y+8,z-i,netherrack.id);
        }
        for(int i=-2;i<=9;i++){
            world.setBlockWithNotify(x-9,y+9,z-i,netherrack.id);
        }
        for(int i=0;i<=9;i++){
            world.setBlockWithNotify(x-9,y+10,z-i,netherrack.id);
        }
        for(int i=2;i<=9;i++){
            world.setBlockWithNotify(x-9,y+11,z-i,netherrack.id);
        }
        for(int i=4;i<=9;i++){
            world.setBlockWithNotify(x-9,y+12,z-i,netherrack.id);
        }
        for(int i=6;i<=9;i++){
            world.setBlockWithNotify(x-9,y+13,z-i,netherrack.id);
        }
        for(int i=8;i<=9;i++){
            world.setBlockWithNotify(x-9,y+14,z-i,netherrack.id);
        }

        //2nd
        for(int i=-9;i<=9;i++){
            world.setBlockWithNotify(x-8,y+6,z-i, netherrack.id);
        }
        for(int i=-7;i<=9;i++) {
            world.setBlockWithNotify(x-8,y+7,z-i,netherrack.id);
        }
        for(int i=-5;i<=9;i++){
            world.setBlockWithNotify(x-8,y+8,z-i,netherrack.id);
        }
        for(int i=-3;i<=9;i++){
            world.setBlockWithNotify(x-8,y+9,z-i,netherrack.id);
        }
        for(int i=-1;i<=9;i++){
            world.setBlockWithNotify(x-8,y+10,z-i,netherrack.id);
        }
        for(int i=1;i<=9;i++){
            world.setBlockWithNotify(x-8,y+11,z-i,netherrack.id);
        }
        for(int i=3;i<=9;i++){
            world.setBlockWithNotify(x-8,y+12,z-i,netherrack.id);
        }
        for(int i=5;i<=9;i++){
            world.setBlockWithNotify(x-8,y+13,z-i,netherrack.id);
        }
        for(int i=7;i<=9;i++){
            world.setBlockWithNotify(x-8,y+14,z-i,netherrack.id);
        }

        //3rd
        for(int i=-9;i<=9;i++){
            world.setBlockWithNotify(x-7,y+6,z-i, netherrack.id);
        }
        for(int i=-8;i<=9;i++) {
            world.setBlockWithNotify(x-7,y+7,z-i,netherrack.id);
        }
        for(int i=-6;i<=9;i++){
            world.setBlockWithNotify(x-7,y+8,z-i,netherrack.id);
        }
        for(int i=-4;i<=9;i++){
            world.setBlockWithNotify(x-7,y+9,z-i,netherrack.id);
        }
        for(int i=-2;i<=9;i++){
            world.setBlockWithNotify(x-7,y+10,z-i,netherrack.id);
        }
        for(int i=0;i<=9;i++){
            world.setBlockWithNotify(x-7,y+11,z-i,netherrack.id);
        }
        for(int i=2;i<=9;i++){
            world.setBlockWithNotify(x-7,y+12,z-i,netherrack.id);
        }
        for(int i=4;i<=9;i++){
            world.setBlockWithNotify(x-7,y+13,z-i,netherrack.id);
        }
        for(int i=6;i<=9;i++){
            world.setBlockWithNotify(x-7,y+14,z-i,netherrack.id);
        }

        //-z and +x walls
        for(int i=-9;i<=9;i++){
            for(int c=6;c<=14;c++){
                world.setBlockWithNotify(x+9,y+c,z+i,netherrack.id);
                world.setBlockWithNotify(x+i,y+c,z-9,netherrack.id);
            }
        }

        //Negative Z Spiral
        //1st
        for(int i=-8;i<=9;i++){
            world.setBlockWithNotify(x+i,y+15,z-9,netherrack.id);
        }
        for(int i=-6;i<=9;i++){
            world.setBlockWithNotify(x+i,y+16,z-9,netherrack.id);
        }
        for(int i=-4;i<=9;i++){
            world.setBlockWithNotify(x+i,y+17,z-9,netherrack.id);
        }
        for(int i=-2;i<=9;i++){
            world.setBlockWithNotify(x+i,y+18,z-9,netherrack.id);
        }
        for(int i=0;i<=9;i++){
            world.setBlockWithNotify(x+i,y+19,z-9,netherrack.id);
        }
        for(int i=2;i<=9;i++){
            world.setBlockWithNotify(x+i,y+20,z-9,netherrack.id);
        }
        for(int i=4;i<=9;i++){
            world.setBlockWithNotify(x+i,y+21,z-9,netherrack.id);
        }
        for(int i=6;i<=9;i++){
            world.setBlockWithNotify(x+i,y+22,z-9,netherrack.id);
        }
        for(int i=8;i<=9;i++){
            world.setBlockWithNotify(x+i,y+23,z-9,netherrack.id);
        }
        //2nd
        for(int i=-7;i<=9;i++){
            world.setBlockWithNotify(x+i,y+15,z-8,netherrack.id);
        }
        for(int i=-5;i<=9;i++){
            world.setBlockWithNotify(x+i,y+16,z-8,netherrack.id);
        }
        for(int i=-3;i<=9;i++){
            world.setBlockWithNotify(x+i,y+17,z-8,netherrack.id);
        }
        for(int i=-1;i<=9;i++){
            world.setBlockWithNotify(x+i,y+18,z-8,netherrack.id);
        }
        for(int i=1;i<=9;i++){
            world.setBlockWithNotify(x+i,y+19,z-8,netherrack.id);
        }
        for(int i=3;i<=9;i++){
            world.setBlockWithNotify(x+i,y+20,z-8,netherrack.id);
        }
        for(int i=5;i<=9;i++){
            world.setBlockWithNotify(x+i,y+21,z-8,netherrack.id);
        }
        for(int i=7;i<=9;i++){
            world.setBlockWithNotify(x+i,y+22,z-8,netherrack.id);
        }
        for(int i=9;i<=9;i++){
            world.setBlockWithNotify(x+i,y+23,z-8,netherrack.id);
        }
        //3rd
        for(int i=-6;i<=9;i++){
            world.setBlockWithNotify(x+i,y+15,z-7,netherrack.id);
        }
        for(int i=-4;i<=9;i++){
            world.setBlockWithNotify(x+i,y+16,z-7,netherrack.id);
        }
        for(int i=-2;i<=9;i++){
            world.setBlockWithNotify(x+i,y+17,z-7,netherrack.id);
        }
        for(int i=0;i<=9;i++){
            world.setBlockWithNotify(x+i,y+18,z-7,netherrack.id);
        }
        for(int i=2;i<=9;i++){
            world.setBlockWithNotify(x+i,y+19,z-7,netherrack.id);
        }
        for(int i=4;i<=9;i++){
            world.setBlockWithNotify(x+i,y+20,z-7,netherrack.id);
        }
        for(int i=6;i<=9;i++){
            world.setBlockWithNotify(x+i,y+21,z-7,netherrack.id);
        }
        for(int i=8;i<=9;i++){
            world.setBlockWithNotify(x+i,y+22,z-7,netherrack.id);
        }

        //Positive X Spiral
        //1st
        for(int i=-8;i<=9;i++){
            world.setBlockWithNotify(x+9,y+15,z-i,netherrack.id);
        }
        for(int i=-6;i<=9;i++){
            world.setBlockWithNotify(x+9,y+16,z-i,netherrack.id);
        }
        for(int i=-4;i<=9;i++){
            world.setBlockWithNotify(x+9,y+17,z-i,netherrack.id);
        }
        for(int i=-2;i<=9;i++){
            world.setBlockWithNotify(x+9,y+18,z-i,netherrack.id);
        }
        for(int i=0;i<=9;i++){
            world.setBlockWithNotify(x+9,y+19,z-i,netherrack.id);
        }
        for(int i=2;i<=9;i++){
            world.setBlockWithNotify(x+9,y+20,z-i,netherrack.id);
        }
        for(int i=4;i<=9;i++){
            world.setBlockWithNotify(x+9,y+21,z-i,netherrack.id);
        }
        for(int i=6;i<=9;i++){
            world.setBlockWithNotify(x+9,y+22,z-i,netherrack.id);
        }
        for(int i=8;i<=9;i++){
            world.setBlockWithNotify(x+9,y+23,z-i,netherrack.id);
        }
        //2nd
        for(int i=-7;i<=9;i++){
            world.setBlockWithNotify(x+8,y+15,z-i,netherrack.id);
        }
        for(int i=-5;i<=9;i++){
            world.setBlockWithNotify(x+8,y+16,z-i,netherrack.id);
        }
        for(int i=-3;i<=9;i++){
            world.setBlockWithNotify(x+8,y+17,z-i,netherrack.id);
        }
        for(int i=-1;i<=9;i++){
            world.setBlockWithNotify(x+8,y+18,z-i,netherrack.id);
        }
        for(int i=1;i<=9;i++){
            world.setBlockWithNotify(x+8,y+19,z-i,netherrack.id);
        }
        for(int i=3;i<=9;i++){
            world.setBlockWithNotify(x+8,y+20,z-i,netherrack.id);
        }
        for(int i=5;i<=9;i++){
            world.setBlockWithNotify(x+8,y+21,z-i,netherrack.id);
        }
        for(int i=7;i<=9;i++){
            world.setBlockWithNotify(x+8,y+22,z-i,netherrack.id);
        }
        for(int i=9;i<=9;i++){
            world.setBlockWithNotify(x+8,y+23,z-i,netherrack.id);
        }
        //3rd
        for(int i=-6;i<=9;i++){
            world.setBlockWithNotify(x+7,y+15,z-i,netherrack.id);
        }
        for(int i=-4;i<=9;i++){
            world.setBlockWithNotify(x+7,y+16,z-i,netherrack.id);
        }
        for(int i=-2;i<=9;i++){
            world.setBlockWithNotify(x+7,y+17,z-i,netherrack.id);
        }
        for(int i=0;i<=9;i++){
            world.setBlockWithNotify(x+7,y+18,z-i,netherrack.id);
        }
        for(int i=2;i<=9;i++){
            world.setBlockWithNotify(x+7,y+19,z-i,netherrack.id);
        }
        for(int i=4;i<=9;i++){
            world.setBlockWithNotify(x+7,y+20,z-i,netherrack.id);
        }
        for(int i=6;i<=9;i++){
            world.setBlockWithNotify(x+7,y+21,z-i,netherrack.id);
        }
        for(int i=8;i<=9;i++){
            world.setBlockWithNotify(x+7,y+22,z-i,netherrack.id);
        }

        //+z and -x walls
        for(int i=-6;i<=6;i++){
            for(int c=5;c<=20;c++){
                world.setBlockWithNotify(x-6,y+c,z+i,netherrack.id);
                world.setBlockWithNotify(x+i,y+c,z+6,netherrack.id);
            }
        }
        //-z and +x walls
        for(int i=-6;i<=6;i++){
            for(int c=5;c<=14;c++){
                world.setBlockWithNotify(x+6,y+c,z+i,netherrack.id);
                world.setBlockWithNotify(x+i,y+c,z-6,netherrack.id);
            }
        }

        //-Z Spiral
        //1st
        for(int i=-5;i<=6;i++){
            world.setBlockWithNotify(x-i,y+15,z-6,netherrack.id);
        }
        for(int i=-3;i<=6;i++){
            world.setBlockWithNotify(x-i,y+16,z-6,netherrack.id);
        }
        for(int i=-1;i<=6;i++){
            world.setBlockWithNotify(x-i,y+17,z-6,netherrack.id);
        }
        for(int i=1;i<=6;i++){
            world.setBlockWithNotify(x-i,y+18,z-6,netherrack.id);
        }
        for(int i=3;i<=6;i++){
            world.setBlockWithNotify(x-i,y+19,z-6,netherrack.id);
        }
        for(int i=5;i<=6;i++){
            world.setBlockWithNotify(x-i,y+20,z-6,netherrack.id);
        }
        //2nd
        for(int i=-6;i<=6;i++){
            world.setBlockWithNotify(x-i,y+15,z-5,netherrack.id);
        }
        for(int i=-4;i<=6;i++){
            world.setBlockWithNotify(x-i,y+16,z-5,netherrack.id);
        }
        for(int i=-2;i<=6;i++){
            world.setBlockWithNotify(x-i,y+17,z-5,netherrack.id);
        }
        for(int i=0;i<=6;i++){
            world.setBlockWithNotify(x-i,y+18,z-5,netherrack.id);
        }
        for(int i=2;i<=6;i++){
            world.setBlockWithNotify(x-i,y+19,z-5,netherrack.id);
        }
        for(int i=4;i<=6;i++){
            world.setBlockWithNotify(x-i,y+20,z-5,netherrack.id);
        }

        //+X Spiral
        //1st
        for(int i=-5;i<=6;i++){
            world.setBlockWithNotify(x+6,y+15,z+i,netherrack.id);
        }
        for(int i=-3;i<=6;i++){
            world.setBlockWithNotify(x+6,y+16,z+i,netherrack.id);
        }
        for(int i=-1;i<=6;i++){
            world.setBlockWithNotify(x+6,y+17,z+i,netherrack.id);
        }
        for(int i=1;i<=6;i++){
            world.setBlockWithNotify(x+6,y+18,z+i,netherrack.id);
        }
        for(int i=3;i<=6;i++){
            world.setBlockWithNotify(x+6,y+19,z+i,netherrack.id);
        }
        for(int i=5;i<=6;i++){
            world.setBlockWithNotify(x+6,y+20,z+i,netherrack.id);
        }
        //2nd
        for(int i=-6;i<=6;i++){
            world.setBlockWithNotify(x+5,y+15,z+i,netherrack.id);
        }
        for(int i=-4;i<=6;i++){
            world.setBlockWithNotify(x+5,y+16,z+i,netherrack.id);
        }
        for(int i=-2;i<=6;i++){
            world.setBlockWithNotify(x+5,y+17,z+i,netherrack.id);
        }
        for(int i=0;i<=6;i++){
            world.setBlockWithNotify(x+5,y+18,z+i,netherrack.id);
        }
        for(int i=2;i<=6;i++){
            world.setBlockWithNotify(x+5,y+19,z+i,netherrack.id);
        }
        for(int i=4;i<=6;i++){
            world.setBlockWithNotify(x+5,y+20,z+i,netherrack.id);
        }

        //+Z Spiral
        //1st
        for(int i=-4;i<=6;i++){
            world.setBlockWithNotify(x-i,y+21,z+6,netherrack.id);
        }
        for(int i=-2;i<=6;i++){
            world.setBlockWithNotify(x-i,y+22,z+6,netherrack.id);
        }
        for(int i=0;i<=6;i++){
            world.setBlockWithNotify(x-i,y+23,z+6,netherrack.id);
        }
        for(int i=2;i<=6;i++){
            world.setBlockWithNotify(x-i,y+24,z+6,netherrack.id);
        }
        for(int i=4;i<=6;i++){
            world.setBlockWithNotify(x-i,y+25,z+6,netherrack.id);
        }
        for(int i=6;i<=6;i++){
            world.setBlockWithNotify(x-i,y+26,z+6,netherrack.id);
        }
        //2nd
        for(int i=-5;i<=6;i++){
            world.setBlockWithNotify(x-i,y+20,z+5,netherrack.id);
        }
        for(int i=-3;i<=6;i++){
            world.setBlockWithNotify(x-i,y+21,z+5,netherrack.id);
        }
        for(int i=-1;i<=6;i++){
            world.setBlockWithNotify(x-i,y+22,z+5,netherrack.id);
        }
        for(int i=1;i<=6;i++){
            world.setBlockWithNotify(x-i,y+23,z+5,netherrack.id);
        }
        for(int i=3;i<=6;i++){
            world.setBlockWithNotify(x-i,y+24,z+5,netherrack.id);
        }
        for(int i=5;i<=6;i++){
            world.setBlockWithNotify(x-i,y+25,z+5,netherrack.id);
        }

        //-X Spiral
        //1st
        for(int i=-4;i<=6;i++){
            world.setBlockWithNotify(x-6,y+21,z+i,netherrack.id);
        }
        for(int i=-2;i<=6;i++){
            world.setBlockWithNotify(x-6,y+22,z+i,netherrack.id);
        }
        for(int i=0;i<=6;i++){
            world.setBlockWithNotify(x-6,y+23,z+i,netherrack.id);
        }
        for(int i=2;i<=6;i++){
            world.setBlockWithNotify(x-6,y+24,z+i,netherrack.id);
        }
        for(int i=4;i<=6;i++){
            world.setBlockWithNotify(x-6,y+25,z+i,netherrack.id);
        }
        for(int i=6;i<=6;i++){
            world.setBlockWithNotify(x-6,y+26,z+i,netherrack.id);
        }
        //2nd
        for(int i=-5;i<=6;i++){
            world.setBlockWithNotify(x-5,y+20,z+i,netherrack.id);
        }
        for(int i=-3;i<=6;i++){
            world.setBlockWithNotify(x-5,y+21,z+i,netherrack.id);
        }
        for(int i=-1;i<=6;i++){
            world.setBlockWithNotify(x-5,y+22,z+i,netherrack.id);
        }
        for(int i=1;i<=6;i++){
            world.setBlockWithNotify(x-5,y+23,z+i,netherrack.id);
        }
        for(int i=3;i<=6;i++){
            world.setBlockWithNotify(x-5,y+24,z+i,netherrack.id);
        }
        for(int i=5;i<=6;i++){
            world.setBlockWithNotify(x-5,y+25,z+i,netherrack.id);
        }

        //Final Pillar
        for(int i=-4;i<=4;i++){
            for(int c=-4;c<=4;c++){
                for(int h=14;h<=34;h++) {
                    world.setBlockWithNotify(x + i, y + h, z + c, netherrack.id);
                }
            }
        }
        //Final Slope
        //1
        world.setBlockWithNotify(x-4,y+28,z+4,0);
        //2
        for(int c=4;c>=2;c--) {
            for (int i = -4; i <= c-6; i++) {
                world.setBlockWithNotify(x + i, y + 29, z + c, 0);
            }
        }
        //3
        for(int c=4;c>=-1;c--) {
            for (int i = -4; i <= c-4; i++) {
                world.setBlockWithNotify(x + i, y + 30, z + c, 0);
            }
        }
        //4
        for(int c=4;c>=-4;c--){
            for(int i=-4;i<=c-2;i++){
                world.setBlockWithNotify(x+i,y+31,z+c,0);
            }
        }
        //5
        for(int c=4;c>=-6;c--){
            for(int i=-4;i<=c+1;i++){
                world.setBlockWithNotify(x+i,y+32,z+c,0);
            }
        }
        //6
        for(int c=4;c>=-9;c--){
            for(int i=-4;i<=c+3;i++){
                world.setBlockWithNotify(x+i,y+33,z+c,0);
            }
        }
        //7
        for(int c=4;c>=-12;c--){
            for(int i=-4;i<=c+5;i++){
                world.setBlockWithNotify(x+i,y+34,z+c,0);
            }
        }
    }
}