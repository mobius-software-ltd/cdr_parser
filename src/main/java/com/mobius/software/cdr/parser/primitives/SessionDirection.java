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
SessionDirection ::= ENUMERATED
{
 inbound (0),
 outbound (1)
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum SessionDirection 
{
	inbound (0),
	outbound (1);

	private int direction;

	private SessionDirection(int direction) 
	{
		this.direction = direction;
	}

	public int getDirection() 
	{
		return this.direction;
	}

	public static SessionDirection getDirection(int direction) 
	{
		switch (direction) 
		{
			case 0:
				return inbound;
			case 1:
				return outbound;
			default:
				return null;
		}
	}
}