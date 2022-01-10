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
TADS-Indication ::= ENUMERATED
{
 cs (0),
 lte (1),
 wifi (2),
 ps (3),
 ics (4),
 svc_eics (5),
 five_g (6)
} 
 */
/**
 * @author yulian.oifa
 *
 */
public enum TADSIndication 
{
	CS (0),
	LTE (1),
	WIFI (2),
	PS (3),
	ICS (4),
	SVC_EICS (5),
	FIVE_G (6);

	private int tad;

	private TADSIndication(int tad) 
	{
		this.tad = tad;
	}

	public int getTAD() 
	{
		return this.tad;
	}

	public static TADSIndication getTAD(int tad) 
	{
		switch (tad) 
		{
			case 0:
				return CS;
			case 1:
				return LTE;
			case 2:
				return WIFI;
			case 3:
				return PS;
			case 4:
				return ICS;
			case 5:
				return SVC_EICS;
			case 6:
				return FIVE_G;
			default:
				return null;
		}
	}
}