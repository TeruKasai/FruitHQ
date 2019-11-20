package vo.tam;


import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Realistic_Damage implements Listener {
	
	
	@EventHandler
	public static void FallDamage(EntityDamageEvent event) {
		if(event.getCause() == DamageCause.FALL) {
			event.getEntity();
			double damage = event.getDamage()*1.5;
			event.setDamage(damage);
			
			if(event.getDamage() <= 10) {
			if (event.getEntity()instanceof LivingEntity)
			((LivingEntity)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 2));
			}
			}
	}
	@EventHandler
	public static void Bleeding(EntityDamageEvent event) {
		if(event.getCause() == (DamageCause.ENTITY_ATTACK));
		event.getEntity();
		if (event.getEntity() instanceof LivingEntity) {
			double RNG = Math.random();
			System.out.println(RNG);
			if(RNG <= 0.1) {
			((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 400, 0));
			if(event.getEntity() instanceof Player) {
				((Player) event.getEntity()).sendMessage("You're Bleeding!");
			}
			}
		}
	}
	@EventHandler
	public static void SpiderBite(EntityDamageByEntityEvent event) {
		
		
		event.getDamager();
		System.out.println(event);
		event.getEntity();
		System.out.println(event);
		
		
		
		if(event.getDamager() instanceof Spider) {
			if (event.getEntity() instanceof Player) {
				((Player) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0));
						}
		}
		else {
			if((event.getDamager() instanceof CaveSpider)&&(event.getEntity() instanceof Player)) {
				((Player) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 400, 0));
			}
		}
	}
	
	//Initializes an object Main called main which is currently set to null (not created)
   private final Main main;
	//private final Main plugin; another way to create it
   //Method CREATES a local Main object called plugin
	public Realistic_Damage(Main plugin) {
		/*main is then inheriting the values of plugin, this can also be done by instead editing the private final with = new Main();
		The reason we do this is because we want to actually create the object, because main as of current is null,
		but it can also be done with = new main(); */
		main = plugin;
		//registers the events of this class, with the main class. Allowing the methods in this class to pretty much work.
		main.getServer().getPluginManager().registerEvents(this, main);
	}
	
	
	@EventHandler
	public void RespawnNerf(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		int PlayerExp = player.getLevel();
		player.setLevel((int) (PlayerExp * 0.8));
		new BukkitRunnable() {
			@Override
			public void run() {
				System.out.println("Setting food level");
				player.getFoodLevel();
				player.setFoodLevel(8);
			}
		}.runTaskLater(main, 20);

	}
}

