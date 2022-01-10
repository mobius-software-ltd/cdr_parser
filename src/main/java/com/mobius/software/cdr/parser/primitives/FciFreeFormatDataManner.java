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
Fci-Free-Format-Data-Manner ::= ENUMERATED
{
	OVERRIDE (0),
	APPEND (1)
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum FciFreeFormatDataManner 
{
	OVERRIDE (0),
	APPEND (1);

	private int type;

	private FciFreeFormatDataManner(int type) 
	{
		this.type = type;
	}

	public int getType() 
	{
		return this.type;
	}

	public static FciFreeFormatDataManner getType(int type) 
	{
		switch (type) 
		{
			case 0:
				return OVERRIDE;
			case 1:
				return APPEND;			
			default:
				return null;
		}
	}
}