package com.mobius.software.cdr.parser.primitives;
/*
 * Mobius Software LTD
 * Copyright 2021, Mobius Software LTD and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
/*
SessionPriority ::= ENUMERATED
--
-- PRIORITY-0 is the highest priority and Priority-4 is the lowest priority. See TS 29.229[232]
--
{
pRIORITY-0 (0),
pRIORITY-1 (1),
pRIORITY-2 (2),
pRIORITY-3 (3),
pRIORITY-4 (4)
} 
 */
/**
 * @author yulian.oifa
 *
 */
public enum SessionPriority 
{
	priority0 (0),
	priority1 (1),
	priority2 (2),
	priority3 (3),
	priority4 (4);
	
	private int priority;

	private SessionPriority(int priority) 
	{
		this.priority = priority;
	}

	public int getPriority() 
	{
		return this.priority;
	}

	public static SessionPriority fromPriority(int priority) 
	{
		switch (priority) 
		{
			case 0:
				return priority0;
			case 1:
				return priority1;
			case 2:
				return priority2;
			case 3:
				return priority3;
			case 4:
				return priority4;
			default:
				return null;
		}
	}
}