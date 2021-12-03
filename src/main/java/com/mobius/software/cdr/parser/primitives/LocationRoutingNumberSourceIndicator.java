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
LocationRoutingNumberSourceIndicator ::= INTEGER
{
 lRN-NP-Database (1),
 switchingSystemData (2),
 incomingsignaling (3),
 unknown (9)
} 
 */
/**
 * @author yulian.oifa
 *
 */
public enum LocationRoutingNumberSourceIndicator 
{
	lrnNPDatabase (1),
	switchingSystemData (2),
	incomingsignaling(3),
	unknown(9);
	
	private int code;

	private LocationRoutingNumberSourceIndicator(int code) 
	{
		this.code = code;
	}

	public int getCode() 
	{
		return this.code;
	}

	public static LocationRoutingNumberSourceIndicator getCode(int code) 
	{
		switch (code) 
		{
			case 1:
				return lrnNPDatabase;
			case 2:
				return switchingSystemData;
			case 3:
				return incomingsignaling;
			case 9:
				return unknown;
			default:
				return null;
		}
	}
}