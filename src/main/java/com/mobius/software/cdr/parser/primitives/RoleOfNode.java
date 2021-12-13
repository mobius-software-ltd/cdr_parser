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
Role-of-Node
::= ENUMERATED
{
originating (0),
terminating (1)
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum RoleOfNode 
{
	originating (0),
	terminating (1);
	
	private int code;

	private RoleOfNode(int code) 
	{
		this.code = code;
	}

	public int getCode() 
	{
		return this.code;
	}

	public static RoleOfNode fromCode(int code) 
	{
		switch (code) 
		{
			case 0:
				return originating;
			case 1:
				return terminating;
			default:
				return null;
		}
	}
}