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
import java.util.List;

import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;

/*
EventBasedChargingInformation ::= SEQUENCE
{
numberOfEvents [1] INTEGER,
eventTimeStamps [2] SEQUENCE OF TimeStamp OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class EventBasedChargingInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNInteger numberOfEvents;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private List<TimeStamp> eventTimeStamps;
	
	public EventBasedChargingInformation()
	{
		
	}
	
	public EventBasedChargingInformation(Integer numberOfEvents,List<TimeStamp> eventTimeStamps)
	{
		if(numberOfEvents!=null)
		{
			this.numberOfEvents=new ASNInteger();
			this.numberOfEvents.setValue(numberOfEvents.longValue());
		}
		
		this.eventTimeStamps=eventTimeStamps;
	}

	public Integer getNumberOfEvents() 
	{
		if(numberOfEvents==null || numberOfEvents.getValue()==null)
			return null;
		
		return numberOfEvents.getValue().intValue();
	}

	public List<TimeStamp> getEventTimeStamps() 
	{
		return eventTimeStamps;
	}
	
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("EventBasedChargingInformation");
        sb.append(" [");

        if(numberOfEvents!=null && numberOfEvents.getValue()!=null)
        {
	        sb.append("numberOfEvents=[");
	        sb.append(this.numberOfEvents.getValue());
	        sb.append("]");
        }
        
        if(eventTimeStamps!=null && eventTimeStamps.size()>0)
        {
	        sb.append(", eventTimeStamps=[");
	        int index=0;
	        for(TimeStamp curr:eventTimeStamps)
	        {
	        	if(index!=0)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}