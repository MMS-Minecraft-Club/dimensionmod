package mms.forge.dimensionmod.Generators;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;




public class BasicGenerator implements IWorldGenerator { 

		@Override
        public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
			chunkGenerator.populate(chunkProvider, chunkX, chunkZ);
			switch (world.provider.getDimensionId()) {
		    case 0: //Overworld

		        break;
		    case -1: //Nether

		        break;
		    case 1: //End

		        break;
		    default: 
		    		
		    	break;
		    }
//			generateOverworld(world, random, chunkX, chunkZ);
        }
		
//		
}