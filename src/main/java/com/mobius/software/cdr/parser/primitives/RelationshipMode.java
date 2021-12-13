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
RelationshipMode ::= ENUMERATED
{
 trusted (0),
 non-trusted (1)
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum RelationshipMode 
{
	trusted (0),
	nonTrusted (1);

	private int mode;

	private RelationshipMode(int mode) 
	{
		this.mode = mode;
	}

	public int getMode() 
	{
		return this.mode;
	}

	public static RelationshipMode getMode(int mode) 
	{
		switch (mode) 
		{
			case 0:
				return trusted;
			case 1:
				return nonTrusted;
			default:
				return null;
		}
	}
}