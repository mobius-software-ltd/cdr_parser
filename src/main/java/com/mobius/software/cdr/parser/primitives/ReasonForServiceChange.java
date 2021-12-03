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
ReasonForServiceChange ::= ENUMERATED
{
 msubInitiated (0),
 mscInitiated (1),
 callSetupFallBack (2),
 callSetupChangeOrder (3)
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum ReasonForServiceChange 
{
	msubInitiated (0),
	mscInitiated (1),
	callSetupFallBack(2),
	callSetupChangeOrder(3);
	
	private int code;

	private ReasonForServiceChange(int code) 
	{
		this.code = code;
	}

	public int getCode() 
	{
		return this.code;
	}

	public static ReasonForServiceChange getCode(int code) 
	{
		switch (code) 
		{
			case 0:
				return msubInitiated;
			case 1:
				return mscInitiated;
			case 2:
				return callSetupFallBack;
			case 3:
				return callSetupChangeOrder;
			default:
				return null;
		}
	}
}