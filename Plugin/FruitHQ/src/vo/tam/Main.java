package vo.tam;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin implements Listener{

	
	//Fires when plugin is enabled
	@Override
	public void onEnable(){
		System.out.print("Jordan is a bean");
		Bukkit.getServer().getPluginManager().registerEvents(new BedDetection(), this);
	}
	
	//Fires when plugin is disabled
	@Override
	public void onDisable() {
		System.out.print("System is disabled");
		
	}
	
	
	
	

	

	
	
	
}
