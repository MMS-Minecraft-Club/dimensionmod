package mms.forge.dimensionmod.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import com.ibm.icu.util.BytesTrie.Iterator;

import mms.forge.dimensionmod.events.DimensionSwitchEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerManager;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

public class DimensionCommand implements ICommand {
	private List<String> aliases;

	public DimensionCommand() {
		this.aliases = new ArrayList<String>();
		this.aliases.add("dimension");
		this.aliases.add("dim");
	}

	@Override
	public String getCommandName() {
		return "dimension";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "dimension <testname>";
	}
	
	
	
	@Override
	public List<String> getCommandAliases() {
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) throws NumberInvalidException {
		if (astring.length == 0) {
			icommandsender.addChatMessage(new ChatComponentText("dimension <test>"));
			
			return;
		}
		/*registerProviderType( 0, WorldProviderSurface.class, true);
        registerProviderType(-1, WorldProviderHell.class,    true);
        registerProviderType( 1, WorldProviderEnd.class,     false);
        registerDimension( 0,  0);
        registerDimension(-1, -1);
        registerDimension( 1,  1);
        */
		DimensionManager manager = new DimensionManager();
		
//		PlayerManager pm = new PlayerManager(null);
		if(astring[0].compareTo("list") == 0) {
			Integer[] ids = manager.getIDs();
			for (int i = 0; i<ids.length; i++) {
				System.out.println("Loaded Dimension: " + ids[i].toString());
			}
		} else if(astring[0].compareTo("create") == 0) {
			WorldProvider wp = new WorldProviderSurface();
			
			Block block = CommandBase.getBlockByText(icommandsender, "grass");
			World world = icommandsender.getEntityWorld();
			
			DimensionManager.registerProviderType(2, WorldProviderSurface.class, true);
			DimensionManager.registerDimension(2, 2);
			DimensionManager.initDimension(2);

			icommandsender.addChatMessage(new ChatComponentText("Dimension: [" + astring[0] + "]"));
		} else if (astring[0].compareTo("change") == 0) {
			WorldServer ws = DimensionManager.getWorld(2);
			ArrayList<EntityPlayerMP> allp = new ArrayList<EntityPlayerMP>();
			System.out.println(manager.getWorlds().length);
			ListIterator<EntityPlayer> itl;
			
			for(int i = 0; i<MinecraftServer.getServer().worldServers.length; i++) {
				System.out.println("I" + i);
				ArrayList<EntityPlayer> aPlayers = new ArrayList<EntityPlayer>();
				MinecraftServer aServer = MinecraftServer.getServer();
				List<EntityPlayer> sPlayers = aServer.worldServers[i].playerEntities;
				
				itl = (ListIterator<EntityPlayer>) sPlayers.listIterator();
				System.out.println("I" + i);
				while(itl.hasNext()) {
					EntityPlayerMP player = (EntityPlayerMP)itl.next();
					try {
						int dim = Integer.parseInt(astring[1]);
						System.out.println(dim);
						MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension(player,Integer.parseInt(astring[1]), new Teleporter(player.getServerForPlayer()));
					} catch (Exception ex) {
						
					}
					MinecraftForge.EVENT_BUS.post((Event) new DimensionSwitchEvent());
					System.out.println(player.toString());
				}
				
			}
		}
		
		
//		BiomeGenBase biome1 = new BiomeGenHills(50, false);
		
		

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		return true;
	}

//	List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos);

//	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		return false;
	}

//	@Override
//	public int compareTo(Object o) {
//		return 0;
//	}

	@Override
	public int compareTo(ICommand o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}
}