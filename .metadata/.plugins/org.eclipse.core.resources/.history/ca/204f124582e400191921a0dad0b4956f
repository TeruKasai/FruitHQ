package vo.tam;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.entity.*;


public class BedDetection implements Listener{
	
	@EventHandler
	public void Detection(PlayerBedLeaveEvent event) {
		Location bed = event.getPlayer().getLocation();
		Player player = event.getPlayer();
	    Villager villager = (Villager) bed.getWorld().spawnEntity(bed, EntityType.VILLAGER);
	    villager.setBaby();
	}
	
	
}
