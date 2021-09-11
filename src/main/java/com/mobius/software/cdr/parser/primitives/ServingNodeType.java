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
ServingNodeType ::= ENUMERATED
{
sGSN (0),
pMIPSGW (1),
gTPSGW (2),
ePDG (3),
hSGW (4),
mME (5)
}

 */
/**
 * @author yulian.oifa
 *
 */
public enum ServingNodeType 
{
	sGSN (0),
	pMIPSGW (1),
	gTPSGW (2),
	ePDG (3),
	hSGW (4),
	mME (5);

	private int type;

	private ServingNodeType(int type) 
	{
		this.type = type;
	}

	public int getType() 
	{
		return this.type;
	}

	public static ServingNodeType getType(int type) 
	{
		switch (type) 
		{
			case 0:
				return sGSN;
			case 1:
				return pMIPSGW;
			case 2:
				return gTPSGW;
			case 3:
				return ePDG;
			case 4:
				return hSGW;
			case 5:
				return mME;			
			default:
				return null;
		}
	}
}