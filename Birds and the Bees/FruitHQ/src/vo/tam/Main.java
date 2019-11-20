package vo.tam;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin{

	


	
	//Fires when plugin is enabled
	@Override
	public void onEnable(){
		System.out.print("Jordan is a beany");
		Bukkit.getServer().getPluginManager().registerEvents(new BedDetection(), this);
		//Bukkit.getServer().getPluginManager().registerEvents(new Realistic_Damage(), this); disabled due to using a scheduler
		new Realistic_Damage(this);
	}
	
	//Fires when plugin is disabled
	@Override
	public void onDisable() {
		System.out.print("System is disabled");
		
	}
	
	
	
	

	

	
	
	
}
