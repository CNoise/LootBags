package mal.lootbags.handler;

import java.util.Random;

import mal.lootbags.LootBags;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * Adds the loot bag to mob drops, configurable through config
 * 
 * @author Mal
 * 
 */
public class MobDropHandler {

	public static Random random = new Random();

	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		int chance = random.nextInt(1000);
		boolean bagdrop = false;
		if(LootBags.LIMITONEBAGPERDROP)
		{
			if (event.entityLiving instanceof EntityPlayer)
			{
				//try a weighting system instead so there is a better distribution of bags
				int totalweight = LootBags.LPLAYERDROPCHANCE+LootBags.EPLAYERDROPCHANCE+LootBags.RPLAYERDROPCHANCE+LootBags.UPLAYERDROPCHANCE+LootBags.CPLAYERDROPCHANCE;
				
				if(chance < totalweight)//getting a bag
				{
					if(chance < LootBags.CPLAYERDROPCHANCE && LootBags.CPLAYERDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 0), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.CPLAYERDROPCHANCE > 0)
						chance -= LootBags.CPLAYERDROPCHANCE;
					
					if(chance < LootBags.UPLAYERDROPCHANCE && LootBags.UPLAYERDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 1), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.UPLAYERDROPCHANCE > 0)
						chance -= LootBags.UPLAYERDROPCHANCE;
					
					if(chance < LootBags.RPLAYERDROPCHANCE && LootBags.RPLAYERDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 2), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.RPLAYERDROPCHANCE > 0)
						chance -= LootBags.RPLAYERDROPCHANCE;
					
					if(chance < LootBags.EPLAYERDROPCHANCE && LootBags.EPLAYERDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 3), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.EPLAYERDROPCHANCE > 0)
						chance -= LootBags.EPLAYERDROPCHANCE;
					
					if(chance < LootBags.LPLAYERDROPCHANCE && LootBags.LPLAYERDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 4), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.LPLAYERDROPCHANCE > 0)
						chance -= LootBags.LPLAYERDROPCHANCE;
				}
			}
			if (event.entityLiving instanceof EntityAnimal)
			{
				int totalweight = LootBags.LPASSIVEDROPCHANCE+LootBags.EPASSIVEDROPCHANCE+LootBags.RPASSIVEDROPCHANCE+LootBags.UPASSIVEDROPCHANCE+LootBags.CPASSIVEDROPCHANCE;
				
				if(chance < totalweight)//getting a bag
				{
					if(chance < LootBags.CPASSIVEDROPCHANCE && LootBags.CPASSIVEDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 0), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.CPASSIVEDROPCHANCE > 0)
						chance -= LootBags.CPASSIVEDROPCHANCE;
					
					if(chance < LootBags.UPASSIVEDROPCHANCE && LootBags.UPASSIVEDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 1), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.UPASSIVEDROPCHANCE > 0)
						chance -= LootBags.UPASSIVEDROPCHANCE;
					
					if(chance < LootBags.RPASSIVEDROPCHANCE && LootBags.RPASSIVEDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 2), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.RPASSIVEDROPCHANCE > 0)
						chance -= LootBags.RPASSIVEDROPCHANCE;
					
					if(chance < LootBags.EPASSIVEDROPCHANCE && LootBags.EPASSIVEDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 3), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.EPASSIVEDROPCHANCE > 0)
						chance -= LootBags.EPASSIVEDROPCHANCE;
					
					if(chance < LootBags.LPASSIVEDROPCHANCE && LootBags.LPASSIVEDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 4), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.LPASSIVEDROPCHANCE > 0)
						chance -= LootBags.LPASSIVEDROPCHANCE;
				}
			}
			if (event.entityLiving instanceof EntityMob)
			{
				int totalweight = LootBags.LMONSTERDROPCHANCE+LootBags.EMONSTERDROPCHANCE+LootBags.RMONSTERDROPCHANCE+LootBags.UMONSTERDROPCHANCE+LootBags.CMONSTERDROPCHANCE;
				//System.out.println(chance + "/" + totalweight);
				
				if(chance < totalweight)//getting a bag
				{
					if(chance < LootBags.CMONSTERDROPCHANCE && LootBags.CMONSTERDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 0), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.CMONSTERDROPCHANCE > 0)
						chance -= LootBags.CMONSTERDROPCHANCE;
					
					if(chance < LootBags.UMONSTERDROPCHANCE && LootBags.UMONSTERDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 1), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.UMONSTERDROPCHANCE > 0)
						chance -= LootBags.UMONSTERDROPCHANCE;
					
					if(chance < LootBags.RMONSTERDROPCHANCE && LootBags.RMONSTERDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 2), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.RMONSTERDROPCHANCE > 0)
						chance -= LootBags.RMONSTERDROPCHANCE;
					
					if(chance < LootBags.EMONSTERDROPCHANCE && LootBags.EMONSTERDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 3), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.EMONSTERDROPCHANCE > 0)
						chance -= LootBags.EMONSTERDROPCHANCE;
					
					if(chance < LootBags.LMONSTERDROPCHANCE && LootBags.LMONSTERDROPCHANCE > 0)
					{
						event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 4), random.nextInt(2) + 1);
						return;
					}
					else if(LootBags.LMONSTERDROPCHANCE > 0)
						chance -= LootBags.LMONSTERDROPCHANCE;
				}
			}
		}
		else
		{
			if (event.entityLiving instanceof EntityPlayer)
			{
				if(!bagdrop && chance < LootBags.CPLAYERDROPCHANCE && LootBags.CPLAYERDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 0), random.nextInt(2) + 1);
				}
				chance = random.nextInt(1000);
				if(!bagdrop && chance < LootBags.UPLAYERDROPCHANCE && LootBags.UPLAYERDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 1), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
				chance = random.nextInt(1000);
				if(!bagdrop && chance < LootBags.RPLAYERDROPCHANCE && LootBags.RPLAYERDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 2), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
				chance = random.nextInt(1000);
				if(!bagdrop && chance < LootBags.EPLAYERDROPCHANCE && LootBags.EPLAYERDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 3), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
				chance = random.nextInt(1000);
				if(chance < LootBags.LPLAYERDROPCHANCE && LootBags.LPLAYERDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 4), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
			}
			if (event.entityLiving instanceof EntityAnimal)
			{
				if(!bagdrop && chance < LootBags.CPASSIVEDROPCHANCE && LootBags.CPASSIVEDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 0), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
				chance = random.nextInt(1000);
				if(!bagdrop && chance < LootBags.UPASSIVEDROPCHANCE && LootBags.UPASSIVEDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 1), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
				chance = random.nextInt(1000);
				if(!bagdrop && chance < LootBags.RPASSIVEDROPCHANCE && LootBags.RPASSIVEDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 2), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
				chance = random.nextInt(1000);
				if(!bagdrop && chance < LootBags.EPASSIVEDROPCHANCE && LootBags.EPASSIVEDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 3), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
				chance = random.nextInt(1000);
				if(chance < LootBags.LPASSIVEDROPCHANCE && LootBags.LPASSIVEDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 4), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
			}
			if (event.entityLiving instanceof EntityMob)
			{
				if(!bagdrop && chance < LootBags.CMONSTERDROPCHANCE && LootBags.CMONSTERDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 0), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
				chance = random.nextInt(1000);
				if(!bagdrop && chance < LootBags.UMONSTERDROPCHANCE && LootBags.UMONSTERDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 1), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
				chance = random.nextInt(1000);
				if(!bagdrop && chance < LootBags.RMONSTERDROPCHANCE && LootBags.RMONSTERDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 2), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
				chance = random.nextInt(1000);
				if(!bagdrop && chance < LootBags.EMONSTERDROPCHANCE && LootBags.EMONSTERDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 3), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
				chance = random.nextInt(1000);
				if(chance < LootBags.LMONSTERDROPCHANCE && LootBags.LMONSTERDROPCHANCE > 0)
				{
					event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 4), random.nextInt(2) + 1);
					chance = random.nextInt(1000);
				}
			}
		}

		if(event.entityLiving instanceof EntityLiving && chance < 250)
		{
			if(((EntityLiving)event.entityLiving).getCustomNameTag().equalsIgnoreCase("bacon_donut"))
				event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 5), random.nextInt(2) + 1);
			if(((EntityLiving)event.entityLiving).getCustomNameTag().equalsIgnoreCase("soaryn"))
				event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 7), random.nextInt(2) + 1);
			if(((EntityLiving)event.entityLiving).getCustomNameTag().equalsIgnoreCase("wyld"))
				event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 8), random.nextInt(2) + 1);
			if(((EntityLiving)event.entityLiving).getCustomNameTag().equalsIgnoreCase("giantwaffle"))
				event.entityLiving.entityDropItem(new ItemStack(LootBags.lootbag, 1, 9), random.nextInt(2) + 1);
		}
	}
}
/*******************************************************************************
 * Copyright (c) 2014 Malorolam.
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the included license.
 * 
 *********************************************************************************/
