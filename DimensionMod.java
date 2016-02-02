package mms.forge.dimensionmod;

import mms.forge.dimensionmod.Commands.*;
import mms.forge.dimensionmod.Generators.*;
import mms.forge.dimensionmod.events.DimensionSwitchEvent;
import mms.forge.dimensionmod.events.DimensionSwitchEventHandler;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = DimensionMod.MODID, version = DimensionMod.VERSION)
public class DimensionMod
{
    public static final String MODID = "DimensionMod";
    public static final String VERSION = "1.0";
    
//    @Instance(ID)
    public static DimensionMod instance;

    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
//    	GameRegistry.registerWorldGenerator((IWorldGenerator) new BasicGenerator(), 2);
    	MinecraftForge.EVENT_BUS.register(new DimensionSwitchEventHandler());
    }
    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
      event.registerServerCommand(new DimensionCommand());
    }
}