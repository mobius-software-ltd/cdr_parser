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
LocationRoutingNumberQueryStatus ::= INTEGER
{
 successfulQuery (1),
 noQueryResponseMsg (2),
 queryProtocolErr (4),
 queryResponseDataErr (5),
 queryRejected (6),
 queryNotPerformed (9),
 queryUnsuccessful (99)
} 
 */
/**
 * @author yulian.oifa
 *
 */
public enum LocationRoutingNumberQueryStatus 
{
	successfulQuery (1),
	noQueryResponseMsg (2),
	queryProtocolErr(4),
	queryResponseDataErr(5),
	queryRejected (6),
	queryNotPerformed(9),
	queryUnsuccessful(99);
	
	private int code;

	private LocationRoutingNumberQueryStatus(int code) 
	{
		this.code = code;
	}

	public int getCode() 
	{
		return this.code;
	}

	public static LocationRoutingNumberQueryStatus getCode(int code) 
	{
		switch (code) 
		{
			case 1:
				return successfulQuery;
			case 2:
				return noQueryResponseMsg;
			case 4:
				return queryProtocolErr;
			case 5:
				return queryResponseDataErr;
			case 6:
				return queryRejected;
			case 9:
				return queryNotPerformed;
			case 99:
				return queryUnsuccessful;
			default:
				return null;
		}
	}
}