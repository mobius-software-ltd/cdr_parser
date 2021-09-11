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
APNSelectionMode::= ENUMERATED
--
-- See Information Elements TS 29.060 [215], TS 29.274 [223] or TS 29.275 [224]
--
{
mSorNetworkProvidedSubscriptionVerified (0),
mSProvidedSubscriptionNotVerified (1),
networkProvidedSubscriptionNotVerified (2)
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum APNSelectionMode 
{
	mSorNetworkProvidedSubscriptionVerified (0),
	mSProvidedSubscriptionNotVerified (1),
	networkProvidedSubscriptionNotVerified (2);

	private int code;

	private APNSelectionMode(int code) 
	{
		this.code = code;
	}

	public int getCode() 
	{
		return this.code;
	}

	public static APNSelectionMode getMode(int code) 
	{
		switch (code) 
		{
			case 0:
				return mSorNetworkProvidedSubscriptionVerified;
			case 1:
				return mSProvidedSubscriptionNotVerified;
			case 2:
				return networkProvidedSubscriptionNotVerified;
			default:
				return null;
		}
	}
}