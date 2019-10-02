package vo.tam;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;


public class BedDetection implements Listener{
	
	
	@EventHandler
	public void Detection(PlayerBedLeaveEvent event) {
		Location player = event.getPlayer().getLocation();
		Location bed = event.getBed().getLocation();
		Location bed2 = bed.add(1, 0, 0);
		String bed2M = bed2.getBlock().getType().toString();
	

		System.out.println(bed2M);
		
		

	    
	    if((bed2M.contains("BED"))&&(bed2.getBlock().getType()!=Material.BEDROCK)) {
	          Villager villager = (Villager) player.getWorld().spawnEntity(player, EntityType.VILLAGER);
	  	      villager.setBaby();
	    }
	}
	
	
}
