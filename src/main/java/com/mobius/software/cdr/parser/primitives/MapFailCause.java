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
MapFailCause ::= ENUMERATED
{
 unknownSubscriber (1),
 unidentifiedSubscriber (5),
 absentSubscriberSM (6),
 illegalSubscriber (9),
 teleserviceNotProvisioned (11),
 illegalEquipment (12),
 callBarred (13),
 facilityNotSupported (21),
 subscriberBusyForMT-SMS (31),
 sm-DeliveryFailure (32),
 messageWaitingListFull (33),
 systemFailure (34),
 dataMissing (35),
 unexpectedDataValue (36),
 unknownAlphabet (71)
} 
 */
/**
 * @author yulian.oifa
 *
 */
public enum MapFailCause 
{
	unknownSubscriber (1),
	unidentifiedSubscriber (5),
	absentSubscriberSM (6),
	illegalSubscriber (9),
	teleserviceNotProvisioned (11),
	illegalEquipment (12),
	callBarred (13),
	facilityNotSupported (21),
	subscriberBusyForMTSMS (31),
	smDeliveryFailure (32),
	messageWaitingListFull (33),
	systemFailure (34),
	dataMissing (35),
	unexpectedDataValue (36),
	unknownAlphabet (71);
	
	private int type;

	private MapFailCause(int type) 
	{
		this.type = type;
	}

	public int getType() 
	{
		return this.type;
	}

	public static MapFailCause fromType(int type) 
	{
		switch (type) 
		{
			case 1:
				return unknownSubscriber;
			case 5:
				return unidentifiedSubscriber;
			case 6:
				return absentSubscriberSM;
			case 9:
				return illegalSubscriber;
			case 11:
				return teleserviceNotProvisioned;
			case 12:
				return illegalEquipment;
			case 13:
				return callBarred;
			case 21:
				return facilityNotSupported;
			case 31:
				return subscriberBusyForMTSMS;
			case 32:
				return smDeliveryFailure;
			case 33:
				return messageWaitingListFull;
			case 34:
				return systemFailure;
			case 35:
				return dataMissing;
			case 36:
				return unexpectedDataValue;
			case 71:
				return unknownAlphabet;
			default:
				return null;
		}
	}
}