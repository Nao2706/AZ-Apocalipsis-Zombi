package me.nao.zombi.evento;


import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;

import org.bukkit.entity.Blaze;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;

import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;

import me.nao.zombi.Main;

public class DamagedEffect implements Listener{
	
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public DamagedEffect(Main plugin) {
		this.plugin = plugin;
	}
	
	

	@EventHandler  //METODO
    public void alpvp(EntityDamageByEntityEvent e){
       
		Entity entidad = e.getDamager();
		Entity entidadAtacada = e.getEntity();
		
		
		 Random random = new Random();
		 int n = random.nextInt(100);		
		
				if(entidad.getType() == EntityType.ZOMBIE && entidadAtacada.getType() == EntityType.PLAYER) {
				 Player player = (Player) entidadAtacada;
			
				 
				
				 if(n == 0) {
					PotionEffect veneno = new PotionEffect(PotionEffectType.POISON,/*duration*/1200,/*amplifier:*/20, true ,true,true );
				      player.addPotionEffect(veneno);
					 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi te infecto con Veneno");
				 }else if(n == 1) {
					PotionEffect nausea = new PotionEffect(PotionEffectType.CONFUSION,/*duration*/1200,/*amplifier:*/20, true ,true,true );
				       player.addPotionEffect(nausea);
					 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi te infecto con Mareos");
				 }else if(n == 2) {
					PotionEffect lento = new PotionEffect(PotionEffectType.SLOW,/*duration*/1200,/*amplifier:*/20, true ,true,true );
				      player.addPotionEffect(lento);
					 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi te infecto con Lentitud");
				 }else if(n == 3) {
					
					
					   //  player.setVelocity(new Vector(0,5,0));
					
					player.setVelocity(player.getLocation().getDirection().multiply(-20).setY(5));
				    player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi te mando a volar");
						 
				    Location loc = player.getLocation();
					player.getWorld().createExplosion(loc.getX(),loc.getY(),loc.getZ(),0,false,true);
					 
				 }
				
		     			
			
		     		
			   }
				 else if(entidad.getType() == EntityType.PLAYER && entidadAtacada.getType() == EntityType.ZOMBIE) {
					 Player player = (Player) entidad;
					 
					 
				
							
							
							
					 if(n == 0) {
						 Location loc = player.getLocation();
							player.getWorld().createExplosion(loc.getX(),loc.getY(),loc.getZ(),15,false,true);
							player.setVelocity(player.getLocation().getDirection().multiply(-20).setY(5));
							 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[F]:"+ChatColor.DARK_GREEN+" Golpeaste a un Zombi y Exploto");
							 player.playSound(player.getLocation(),Sound.ENTITY_GHAST_HURT ,50.0F , 1F  );
						 }else if(n == 1) {
							 for(int i = 0 ; i < 10 ; i++) {
								 LivingEntity entidad99 = (LivingEntity) player.getWorld().spawnEntity(entidadAtacada.getLocation(), EntityType.ZOMBIE);
									Zombie zombi9 = (Zombie) entidad99;

									PotionEffect rapido6 = new PotionEffect(PotionEffectType.SPEED,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
								    zombi9.addPotionEffect(rapido6);
								    PotionEffect salto6= new PotionEffect(PotionEffectType.JUMP,/*duration*/ 99999,/*amplifier:*/5, true ,true,true );
									zombi9.addPotionEffect(salto6);
							 }
							
							     player.playSound(player.getLocation(),Sound.ENTITY_GHAST_HURT ,50.0F , 1F  );
								 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi se multiplico");
							 }
					 
				 }
				 else if(entidad.getType() == EntityType.PLAYER && entidadAtacada.getType() == EntityType.ENDER_DRAGON) {
					 Player player = (Player) entidad;
				
					 
					 
					 if(n == 0) {
						 Location loc = player.getLocation();
							player.getWorld().createExplosion(loc.getX(),loc.getY(),loc.getZ(),5,false,true);
							player.setVelocity(player.getLocation().getDirection().multiply(-20).setY(5));
							 player.sendMessage(""+ChatColor.DARK_PURPLE+ChatColor.BOLD+"[ENDER DRAGON]:"+ChatColor.DARK_GREEN+" A volar Master");
							 player.playSound(player.getLocation(),Sound.ENTITY_ENDER_DRAGON_GROWL ,50.0F , 1F  );
						 }else if(n == 1) {
							
							
							     player.playSound(player.getLocation(),Sound.ENTITY_GHAST_HURT ,50.0F , 1F  );
								 player.sendMessage(""+ChatColor.DARK_RED+ChatColor.BOLD+"[PELIGRO]:"+ChatColor.DARK_GREEN+" Un Zombi se multiplico");
							 } else if(n == 2) {
								 									 player.sendMessage(""+ChatColor.DARK_PURPLE+ChatColor.BOLD+"[ENDER DRAGON]:"+ChatColor.DARK_GREEN+" A volar Master");
									 player.playSound(player.getLocation(),Sound.ENTITY_ENDER_DRAGON_GROWL ,50.0F , 1F  );
								 }
					 
				 }	 else if(entidad.getType() == EntityType.ARROW && entidadAtacada.getType() == EntityType.ENDER_DRAGON) {
					 Player player = (Player) entidad;
					 
					 LivingEntity entidad9 = (LivingEntity) player.getWorld().spawnEntity(entidadAtacada.getLocation(), EntityType.BLAZE);
						Blaze blaze = (Blaze) entidad9;
						
						LivingEntity entidad10 = (LivingEntity) player.getWorld().spawnEntity(entidadAtacada.getLocation(), EntityType.GHAST);
						Ghast ghast = (Ghast) entidad10;
						
						Location loc = entidadAtacada.getLocation();
						Entity h = loc.getWorld().spawnEntity(loc.add(0,50,0), EntityType.MINECART_TNT);
						h.setVelocity(loc.getDirection().multiply(3)); 
					
						
							
							
							blaze.attack(player);
							ghast.attack(player);
					 
					 
				 }
     			return;
	}
	@EventHandler
	public void shoot(ProjectileHitEvent e) {
		
		ProjectileSource atacante = e.getEntity().getShooter();
		Entity atacado = e.getHitEntity();
		EntityType proyectile = e.getEntityType();
			 if(!(atacante instanceof HumanEntity)) {
				 return;
			 }else {
				try { 
					 Player player = (Player) atacante;
					// player.sendMessage("Atacaste a "+ atacado);
					 
					if(atacado.getType() == EntityType.ZOMBIE && proyectile  == EntityType.ARROW) {
						 player.sendMessage(player.getName()+" le diste a un "+atacado.getName());
					}else if(atacado.getType() == EntityType.PLAYER) {
						 player.sendMessage(player.getName()+" le diste a un "+atacado.getName());
					}
					
				}
				catch(NullPointerException ex) {
					return;
				}
		    }
	}
	
	
	
	
	
	

}
