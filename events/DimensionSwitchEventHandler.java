package mms.forge.dimensionmod.events;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DimensionSwitchEventHandler
{

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void helloWorld(DimensionSwitchEvent event)
	{
		System.out.println("Hello World");
	}
}


