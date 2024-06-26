/*
 * Copyright (c) 2023 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.amogus.simpchestgui;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import me.shedaniel.autoconfig.ConfigHolder;
import net.minecraft.entity.Entity;

public final class ChestEntityGroup extends ChestGroup
{
	private final ArrayList<Entity> entities = new ArrayList<>();
	
	public ChestEntityGroup(ConfigHolder<ChestConfig> configHolder,
							ToIntFunction<ChestConfig> color, Predicate<ChestConfig> enabled)
	{
		super(configHolder, color, enabled);
	}
	
	public void add(Entity e)
	{
		entities.add(e);
	}
	
	@Override
	public void clear()
	{
		entities.clear();
		super.clear();
	}
	
	public void updateBoxes(float partialTicks)
	{
		boxes.clear();
		
		for(Entity e : entities)
		{
			double offsetX = -(e.getX() - e.lastRenderX)
				+ (e.getX() - e.lastRenderX) * partialTicks;
			double offsetY = -(e.getY() - e.lastRenderY)
				+ (e.getY() - e.lastRenderY) * partialTicks;
			double offsetZ = -(e.getZ() - e.lastRenderZ)
				+ (e.getZ() - e.lastRenderZ) * partialTicks;
			
			boxes.add(e.getBoundingBox().offset(offsetX, offsetY, offsetZ));
		}
	}
}
