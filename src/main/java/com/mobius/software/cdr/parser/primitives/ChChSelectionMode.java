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
ChChSelectionMode ::= ENUMERATED
{
servingNodeSupplied (0), -- For S-GW/P-GW
subscriptionSpecific (1), -- For SGSN only
aPNSpecific (2), -- For SGSN only
homeDefault (3), -- For SGSN, S-GW and P-GW
roamingDefault (4), -- For SGSN, S-GW and P-GW
visitingDefault (5) -- For SGSN, S-GW and P-GW
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum ChChSelectionMode 
{
	servingNodeSupplied (0),
	subscriptionSpecific (1),
	aPNSpecific (2),
	homeDefault (3),
	roamingDefault (4),
	visitingDefault (5);

	private int code;

	private ChChSelectionMode(int code) 
	{
		this.code = code;
	}

	public int getCode() 
	{
		return this.code;
	}

	public static ChChSelectionMode getMode(int code) 
	{
		switch (code) 
		{
			case 0:
				return servingNodeSupplied;
			case 1:
				return subscriptionSpecific;
			case 2:
				return aPNSpecific;
			case 3:
				return homeDefault;
			case 4:
				return roamingDefault;
			case 5:
				return visitingDefault;
			default:
				return null;
		}
	}
}