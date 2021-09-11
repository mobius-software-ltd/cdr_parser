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
SubscriptionIDType ::= ENUMERATED
{
eND-USER-E164 (0),
eND-USER-IMSI (1),
eND-USER-SIP-URI (2),
eND-USER-NAI (3),
eND-USER-PRIVATE (4)
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum SubscriptionIDType 
{
	E164 (0),
	IMSI (1),
	SIPURI (2),
	NAI (3),
	PRIVATE (4);

	private int type;

	private SubscriptionIDType(int type) 
	{
		this.type = type;
	}

	public int getType() 
	{
		return this.type;
	}

	public static SubscriptionIDType getType(int type) 
	{
		switch (type) 
		{
			case 0:
				return E164;
			case 1:
				return IMSI;
			case 2:
				return SIPURI;
			case 3:
				return NAI;
			case 4:
				return PRIVATE;		
			default:
				return null;
		}
	}
}