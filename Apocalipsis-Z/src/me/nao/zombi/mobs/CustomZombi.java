package me.nao.zombi.mobs;

import org.bukkit.ChatColor;
import org.bukkit.Location;

import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;


import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityGiantZombie;
import net.minecraft.server.v1_16_R3.EntityHuman;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import net.minecraft.server.v1_16_R3.EntityTurtle;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityVillager;
import net.minecraft.server.v1_16_R3.GenericAttributes;

import net.minecraft.server.v1_16_R3.PathfinderGoalAvoidTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalFloat;
import net.minecraft.server.v1_16_R3.PathfinderGoalHurtByTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalLookAtPlayer;
import net.minecraft.server.v1_16_R3.PathfinderGoalMeleeAttack;
import net.minecraft.server.v1_16_R3.PathfinderGoalMoveThroughVillage;
import net.minecraft.server.v1_16_R3.PathfinderGoalMoveTowardsRestriction;
import net.minecraft.server.v1_16_R3.PathfinderGoalNearestAttackableTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomStroll;

public class CustomZombi extends EntityGiantZombie{

	
	public CustomZombi (Location loc) {
		super(EntityTypes.GIANT,((CraftWorld) loc.getWorld()).getHandle());
		this.setPosition(loc.getBlockX(),loc.getY(),loc.getBlockZ());
		this.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).setValue(50);
		this.setCustomName(new ChatComponentText(ChatColor.GOLD+"[TITAN]"));
		this.setCustomNameVisible(true);
	
	
	
		
	}

	

	@Override
	public void initPathfinder() {
		
		this.goalSelector.a(0, new PathfinderGoalFloat(this));
		
		this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, 1.0D ,true));
		this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 0.2D));
		this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this,0.2D,false,1,null));
		this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 0.2D));
		this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
		this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
		
		this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this));
		this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget <EntityPlayer>(this, EntityPlayer.class,true));
		this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget <EntityVillager>(this, EntityVillager.class, true));
		this.targetSelector.a(3, new PathfinderGoalAvoidTarget <EntityTurtle>(this,EntityTurtle.class,20,1.0D,1.0D));
		
	 }
		
	}
	

