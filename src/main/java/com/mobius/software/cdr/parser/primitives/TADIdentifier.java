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
TADIdentifier ::= ENUMERATED
{
 cS (0),
 pS (1)
} 
 */
/**
 * @author yulian.oifa
 *
 */
public enum TADIdentifier 
{
	cs (0),
	ps (1);

	private int tad;

	private TADIdentifier(int tad) 
	{
		this.tad = tad;
	}

	public int getTAD() 
	{
		return this.tad;
	}

	public static TADIdentifier getTAD(int tad) 
	{
		switch (tad) 
		{
			case 0:
				return cs;
			case 1:
				return ps;
			default:
				return null;
		}
	}
}