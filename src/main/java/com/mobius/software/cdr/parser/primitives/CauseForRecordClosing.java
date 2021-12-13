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
CauseForRecordClosing ::= ENUMERATED
{
 serviceDeliveryEndSuccessfully (0),
 unSuccessfulServiceDelivery (1),
 timeLimit (3),
 serviceChange (4), -- e.g. change in media due to Re-Invite,
 -- Access Transfer
 managementIntervention (5) -- partial record generation reasons to be added
 -- Additional codes are for further study
} 
 */
/**
 * @author yulian.oifa
 *
 */
public enum CauseForRecordClosing 
{
	serviceDeliveryEndSuccessfully (0),
	unSuccessfulServiceDelivery (1),
	timeLimit(3),
	serviceChange(4),
	managementIntervention(5);
	
	private int code;

	private CauseForRecordClosing(int code) 
	{
		this.code = code;
	}

	public int getCode() 
	{
		return this.code;
	}

	public static CauseForRecordClosing getCause(int code) 
	{
		switch (code) 
		{
			case 0:
				return serviceDeliveryEndSuccessfully;
			case 1:
				return unSuccessfulServiceDelivery;
			case 3:
				return timeLimit;
			case 4:
				return serviceChange;
			case 5:
				return managementIntervention;
			default:
				return null;
		}
	}
}