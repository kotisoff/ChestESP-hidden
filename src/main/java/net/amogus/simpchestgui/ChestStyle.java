/*
 * Copyright (c) 2023 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.amogus.simpchestgui;

public enum ChestStyle
{
	BOXES(true, false),
	LINES(false, true),
	LINES_AND_BOXES(true, true);
	
	private final boolean boxes;
	private final boolean lines;
	
	private ChestStyle(boolean boxes, boolean lines)
	{
		this.boxes = boxes;
		this.lines = lines;
	}
	
	public boolean hasBoxes()
	{
		return boxes;
	}
	
	public boolean hasLines()
	{
		return lines;
	}
	
	@Override
	public String toString()
	{
		return "text.autoconfig.simpchestgui.option.style." + name().toLowerCase();
	}
}
