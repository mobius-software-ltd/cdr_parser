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
PartialRecordType ::= ENUMERATED
{
 timeLimit (0),
 serviceChange (1),
 locationChange (2),
 classmarkChange (3),
 aocParmChange (4),
 radioChannelChange (5),
 hSCSDParmChange (6),
 changeOfCAMELDestination (7)
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum PartialRecordType 
{
	timeLimit (0),
	serviceChange (1),
	locationChange (2),
	classmarkChange(3),
	aocParmChange(4),
	radioChannelChange(5),
	hSCSDParmChange(6),
	changeOfCAMELDestination(7);
	
	private int type;

	private PartialRecordType(int type) 
	{
		this.type = type;
	}

	public int getType() 
	{
		return this.type;
	}

	public static PartialRecordType getType(int type) 
	{
		switch (type) 
		{
			case 0:
				return timeLimit;
			case 1:
				return serviceChange;
			case 2:
				return locationChange;
			case 3:
				return classmarkChange;
			case 4:
				return aocParmChange;
			case 5:
				return radioChannelChange;
			case 6:
				return hSCSDParmChange;
			case 7:
				return changeOfCAMELDestination;
			default:
				return null;
		}
	}
}