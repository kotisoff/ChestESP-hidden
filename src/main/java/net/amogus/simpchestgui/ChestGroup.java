/*
 * Copyright (c) 2023 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.amogus.simpchestgui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import me.shedaniel.autoconfig.ConfigHolder;
import net.minecraft.util.math.Box;

public abstract class ChestGroup
{
	private final ConfigHolder<ChestConfig> configHolder;
	private final ToIntFunction<ChestConfig> color;
	private final Predicate<ChestConfig> enabled;
	
	protected final ArrayList<Box> boxes = new ArrayList<>();
	
	/**
	 * Creates a new ChestGroup controlled by the given settings. If
	 * <code>enabled</code> is <code>null</code>, the group will always be
	 * enabled.
	 */
	public ChestGroup(ConfigHolder<ChestConfig> configHolder,
					  ToIntFunction<ChestConfig> color, Predicate<ChestConfig> enabled)
	{
		this.configHolder = Objects.requireNonNull(configHolder);
		this.color = Objects.requireNonNull(color);
		this.enabled = enabled;
	}
	
	public void clear()
	{
		boxes.clear();
	}
	
	public boolean isEnabled()
	{
		return enabled == null || enabled.test(configHolder.get());
	}
	
	public float[] getColorF()
	{
		int colorI = color.applyAsInt(configHolder.get());
		float red = (colorI >> 16 & 0xFF) / 255F;
		float green = (colorI >> 8 & 0xFF) / 255F;
		float blue = (colorI & 0xFF) / 255F;
		return new float[]{red, green, blue};
	}
	
	public List<Box> getBoxes()
	{
		return Collections.unmodifiableList(boxes);
	}
}
