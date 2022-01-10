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
camel-Destination-Number-Type ::= ENUMERATED
{
	Reserved (0),
	User_Number (1),
	Unknown_number (2),
	National_number (3),
	International_number (4),
	Specific_number (5)
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum CamelDestinationNumberType 
{
	Reserved (0),
	User_Number (1),
	Unknown_number (2),
	National_number (3),
	International_number (4),
	Specific_number (5);

	private int type;

	private CamelDestinationNumberType(int type) 
	{
		this.type = type;
	}

	public int getType() 
	{
		return this.type;
	}

	public static CamelDestinationNumberType getType(int type) 
	{
		switch (type) 
		{
			case 0:
				return Reserved;
			case 1:
				return User_Number;			
			case 2:
				return Unknown_number;
			case 3:
				return National_number;			
			case 4:
				return International_number;
			case 5:
				return Specific_number;			
			default:
				return null;
		}
	}
}