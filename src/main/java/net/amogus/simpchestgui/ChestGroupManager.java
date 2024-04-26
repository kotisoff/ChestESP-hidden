/*
 * Copyright (c) 2023 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.amogus.simpchestgui;

import java.util.Arrays;
import java.util.List;

import me.shedaniel.autoconfig.ConfigHolder;

public final class ChestGroupManager
{
	public final ChestBlockGroup basicChests;
	public final ChestBlockGroup trapChests;
	public final ChestBlockGroup enderChests;
	public final ChestEntityGroup chestCarts;
	public final ChestEntityGroup chestBoats;
	public final ChestBlockGroup barrels;
	public final ChestBlockGroup shulkerBoxes;
	public final ChestBlockGroup hoppers;
	public final ChestEntityGroup hopperCarts;
	public final ChestBlockGroup droppers;
	public final ChestBlockGroup dispensers;
	public final ChestBlockGroup furnaces;
	
	public final List<ChestGroup> allGroups;
	public final List<ChestEntityGroup> entityGroups;
	
	public ChestGroupManager(ConfigHolder<ChestConfig> ch)
	{
		basicChests = new ChestBlockGroup(ch, c -> c.chest_color, null);
		trapChests = new ChestBlockGroup(ch, c -> c.trap_chest_color,
			c -> c.include_trap_chests);
		enderChests = new ChestBlockGroup(ch, c -> c.ender_chest_color,
			c -> c.include_ender_chests);
		chestCarts = new ChestEntityGroup(ch, c -> c.chest_cart_color,
			c -> c.include_chest_carts);
		chestBoats = new ChestEntityGroup(ch, c -> c.chest_boat_color,
			c -> c.include_chest_boats);
		barrels = new ChestBlockGroup(ch, c -> c.barrel_color,
			c -> c.include_barrels);
		shulkerBoxes = new ChestBlockGroup(ch, c -> c.shulker_box_color,
			c -> c.include_shulker_boxes);
		hoppers = new ChestBlockGroup(ch, c -> c.hopper_color,
			c -> c.include_hoppers);
		hopperCarts = new ChestEntityGroup(ch, c -> c.hopper_cart_color,
			c -> c.include_hopper_carts);
		droppers = new ChestBlockGroup(ch, c -> c.dropper_color,
			c -> c.include_droppers);
		dispensers = new ChestBlockGroup(ch, c -> c.dispenser_color,
			c -> c.include_dispensers);
		furnaces = new ChestBlockGroup(ch, c -> c.furnace_color,
			c -> c.include_furnaces);
		
		allGroups = Arrays.asList(basicChests, trapChests, enderChests,
			chestCarts, chestBoats, barrels, shulkerBoxes, hoppers, hopperCarts,
			droppers, dispensers, furnaces);
		entityGroups = Arrays.asList(chestCarts, chestBoats, hopperCarts);
	}
}
