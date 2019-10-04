package vo.tam;

import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Realistic_Damage implements Listener {

	@EventHandler
	public static void FallDamage(EntityDamageEvent event) {
		if(event.getCause() == DamageCause.FALL) {
			event.getEntity();
			double damage = event.getDamage()*2;
			event.setDamage(damage);
			
			if (event.getEntity()instanceof LivingEntity)
			((LivingEntity)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 30, 2));
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
			((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 800, 0));
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
	
}
