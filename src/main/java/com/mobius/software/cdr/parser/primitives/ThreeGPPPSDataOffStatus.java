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
ThreeGPPPSDataOffStatus ::= ENUMERATED
{
 active (0),
 inactive (1)
} 
 */
/**
 * @author yulian.oifa
 *
 */
public enum ThreeGPPPSDataOffStatus 
{
	active (0),
	inactive (1);
	
	private int status;

	private ThreeGPPPSDataOffStatus(int status) 
	{
		this.status = status;
	}

	public int getStatus() 
	{
		return this.status;
	}

	public static ThreeGPPPSDataOffStatus fromStatus(int status) 
	{
		switch (status) 
		{
			case 0:
				return active;
			case 1:
				return inactive;
			default:
				return null;
		}
	}
}