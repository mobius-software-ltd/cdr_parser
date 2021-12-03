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
BasicService ::= ENUMERATED {
 allServices (0),
 speech (1),
 unrestrictedDigitalInformation (2),
 audio3k1Hz (3),
 unrestrictedDigitalInformationWithTonesAndAnnouncements (4),
 telephony3k1Hz (32),
 teletex (33),
 telefaxGroup4Class1 (34),
 videotexSyntaxBased (35),
 videotelephony (36),
 telefaxGroup2-3 (37),
 telephony7kHz (38)}
 */
/**
 * @author yulian.oifa
 *
 */
public enum BasicService 
{
	allServices (0),
	speech (1),
	unrestrictedDigitalInformation(2),
	audio3k1Hz(3),
	unrestrictedDigitalInformationWithTonesAndAnnouncements (4),
	telephony3k1Hz(32),
	teletex (33),
	telefaxGroup4Class1 (34),
	videotexSyntaxBased(35),
	videotelephony(36),
	telefaxGroup2_3 (37),
	telephony7kHz(38);
	
	private int code;

	private BasicService(int code) 
	{
		this.code = code;
	}

	public int getCode() 
	{
		return this.code;
	}

	public static BasicService getCode(int code) 
	{
		switch (code) 
		{
			case 0:
				return allServices;
			case 1:
				return speech;
			case 2:
				return unrestrictedDigitalInformation;
			case 3:
				return audio3k1Hz;
			case 4:
				return unrestrictedDigitalInformationWithTonesAndAnnouncements;
			case 32:
				return telephony3k1Hz;
			case 33:
				return teletex;
			case 34:
				return telefaxGroup4Class1;
			case 35:
				return videotexSyntaxBased;
			case 36:
				return videotelephony;
			case 37:
				return telefaxGroup2_3;
			case 38:
				return telephony7kHz;
			default:
				return null;
		}
	}
}