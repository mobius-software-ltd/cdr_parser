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
CauseForRecClosing ::= INTEGER
--
-- In PGW-CDR and SGW-CDR the value servingNodeChange is used for partial record
-- generation due to Serving Node Address list Overflow
-- In SGSN servingNodeChange indicates the SGSN change
--
-- LCS related causes belong to the MAP error causes acc. TS 29.002 [214]
--
-- cause codes 0 to 15 are defined 'CauseForTerm' (cause for termination)
--
{
normalRelease (0),
abnormalRelease (4),
cAMELInitCallRelease (5),
volumeLimit (16),
timeLimit (17),
servingNodeChange (18),
maxChangeCond (19),
managementIntervention (20),
intraSGSNIntersystemChange (21),
rATChange (22),
mSTimeZoneChange (23),
sGSNPLMNIDChange (24),
unauthorizedRequestingNetwork (52),
unauthorizedLCSClient (53),
positionMethodFailure (54),
unknownOrUnreachableLCSClient (58),
listofDownstreamNodeChange (59)
}

CauseForTerm ::= INTEGER
--
-- Cause codes from 16 up to 31 are defined in GSM12.15 as „CauseForRecClosing‟
-- (cause for record closing).
-- There is no direct correlation between these two types.
-- LCS related causes belong to the MAP error causes acc. TS 29.002 [214].
--
{
normalRelease (0),
partialRecord (1),
partialRecordCallReestablishment (2),
unsuccessfulCallAttempt (3),
stableCallAbnormalTermination (4),
cAMELInitCallRelease (5),
unauthorizedRequestingNetwork (52),
unauthorizedLCSClient (53),
positionMethodFailure (54),
unknownOrUnreachableLCSClient (58)
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum CauseForRecClosing 
{
	normalRelease (0),
	partialRecord (1),
	partialRecordCallReestablishment (2),
	unsuccessfulCallAttempt (3),
	abnormalRelease (4),
	cAMELInitCallRelease (5),
	volumeLimit (16),
	timeLimit (17),
	servingNodeChange (18),
	maxChangeCond (19),
	managementIntervention (20),
	intraSGSNIntersystemChange (21),
	rATChange (22),
	mSTimeZoneChange (23),
	sGSNPLMNIDChange (24),
	unauthorizedRequestingNetwork (52),
	unauthorizedLCSClient (53),
	positionMethodFailure (54),
	unknownOrUnreachableLCSClient (58),
	listofDownstreamNodeChange (59);

	private int code;

	private CauseForRecClosing(int code) 
	{
		this.code = code;
	}

	public int getCode() 
	{
		return this.code;
	}

	public static CauseForRecClosing getCause(int code) 
	{
		switch (code) 
		{
			case 0:
				return normalRelease;
			case 1:
				return partialRecord;
			case 2:
				return partialRecordCallReestablishment;
			case 3:
				return unsuccessfulCallAttempt;
			case 4:
				return abnormalRelease;
			case 5:
				return cAMELInitCallRelease;
			case 16:
				return volumeLimit;
			case 17:
				return timeLimit;
			case 18:
				return servingNodeChange;
			case 19:
				return maxChangeCond;
			case 20:
				return managementIntervention;
			case 21:
				return intraSGSNIntersystemChange;
			case 22:
				return rATChange;
			case 23:
				return mSTimeZoneChange;
			case 24:
				return sGSNPLMNIDChange;
			case 52:
				return unauthorizedRequestingNetwork;
			case 53:
				return unauthorizedLCSClient;
			case 54:
				return positionMethodFailure;
			case 58:
				return unknownOrUnreachableLCSClient;
			case 59:
				return listofDownstreamNodeChange;
			default:
				return null;
		}
	}
}