package vo.tam;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import net.minecraft.server.v1_14_R1.BlockBed;

import org.bukkit.entity.*;
import org.bukkit.block.data.type.*;


public class BedDetection implements Listener{
	double x;
	double z;
	
	
	@EventHandler
	public void Detection(PlayerBedLeaveEvent event) {
		Location player = event.getPlayer().getLocation();
		Location bed = event.getBed().getLocation();
		Location bed2 = bed.add(1, 0, 0);
		Material bed2M = bed2.getBlock().getType();

		
		
		
		

	    
	    if((bed2M == Material.WHITE_BED)) {
	          Villager villager = (Villager) player.getWorld().spawnEntity(player, EntityType.VILLAGER);
	  	      villager.setBaby();
	    }
	}
	
	
}
