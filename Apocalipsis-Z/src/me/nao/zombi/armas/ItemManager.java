package me.nao.zombi.armas;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class ItemManager {

	
	
	
	
	//agrega
	public static ItemStack Item1;

	
	//agrega 
	public static void init() {
		createWand();

		
	}
	
	//agrega
	private static void createWand() {
		
		ItemStack item = new ItemStack(Material.BLAZE_ROD,/*CANTIDAD*/1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(""+ChatColor.GOLD+ChatColor.BOLD+"["+ChatColor.RED+ChatColor.BOLD+"PALO DE FUEGO"+ChatColor.GOLD+ChatColor.BOLD+"]");
		List<String> lore = new ArrayList<>();
		lore.add(""+ChatColor.GREEN+"[Te servira para lanzar bolas de fuego]");
		lore.add(""+ChatColor.GOLD+ChatColor.BOLD+"Da click derecho "+ChatColor.GREEN+ChatColor.BOLD+"Para usar la habilidad");
		lore.add(""+ChatColor.YELLOW+ChatColor.BOLD+"CATEGORIA:"+ChatColor.BLUE+"[RARO]");
		meta.setLore(lore);
		meta.addEnchant(Enchantment.LUCK, 1, true);
		meta.addEnchant(Enchantment.KNOCKBACK, 20, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		Item1=item;
	}
	

	
}
