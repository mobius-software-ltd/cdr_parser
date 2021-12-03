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
Fnur ::= ENUMERATED
--
-- See Bearer Capability TS 24.008 [208]
--
{
 fnurNotApplicable (0),
 fnur9600-BitsPerSecond (1),
 fnur14400BitsPerSecond (2),
 fnur19200BitsPerSecond (3),
 fnur28800BitsPerSecond (4),
 fnur38400BitsPerSecond (5),
 fnur48000BitsPerSecond (6),
 fnur56000BitsPerSecond (7),
 fnur64000BitsPerSecond (8),
 fnur33600BitsPerSecond (9),
 fnur32000BitsPerSecond (10),
 fnur31200BitsPerSecond (11)
} 
 */
/**
 * @author yulian.oifa
 *
 */
public enum Fnur 
{
	fnurNotApplicable (0),
	fnur9600 (1),
	fnur14400(2),
	fnur19200(3),
	fnur28800(4),
	fnur38400(5),
	fnur48000(6),
	fnur56000(7),
	fnur64000(8),
	fnur33600(9),
	fnur32000(10),
	fnur31200(11);
	
	private int code;

	private Fnur(int code) 
	{
		this.code = code;
	}

	public int getCode() 
	{
		return this.code;
	}

	public static Fnur fromCode(int code) 
	{
		switch (code) 
		{
			case 0:
				return fnurNotApplicable;
			case 1:
				return fnur9600;
			case 2:
				return fnur14400;
			case 3:
				return fnur19200;
			case 4:
				return fnur28800;
			case 5:
				return fnur38400;
			case 6:
				return fnur48000;
			case 7:
				return fnur56000;
			case 8:
				return fnur64000;
			case 9:
				return fnur33600;
			case 10:
				return fnur32000;
			case 11:
				return fnur31200;
			default:
				return null;
		}
	}
}