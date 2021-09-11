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
import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;

/*
TimeQuotaMechanism ::= SEQUENCE
{
timeQuotaType [1] TimeQuotaType,
baseTimeInterval [2] Integer
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class TimeQuotaMechanism 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNTimeQuotaType timeQuotaType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNInteger baseTimeInterval;
	
	public TimeQuotaMechanism()
	{
		
	}
	
	public TimeQuotaMechanism(TimeQuotaType timeQuotaType,Integer baseTimeInterval)
	{
		if(timeQuotaType!=null)
		{
			this.timeQuotaType=new ASNTimeQuotaType();
			this.timeQuotaType.setType(timeQuotaType);
		}
		
		if(baseTimeInterval!=null)
		{
			this.baseTimeInterval=new ASNInteger();
			this.baseTimeInterval.setValue(baseTimeInterval.longValue());
		}
	}

	public TimeQuotaType getTimeQuotaType() 
	{
		if(timeQuotaType==null)
			return null;
		
		return timeQuotaType.getType();
	}

	public Integer getBaseTimeInterval() 
	{
		if(baseTimeInterval==null || baseTimeInterval.getValue()==null)
			return null;
		
		return baseTimeInterval.getValue().intValue();
	}
	
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("TimeQuotaMechanism");
        sb.append(" [");

        if(timeQuotaType!=null)
        {
	        sb.append("timeQuotaType=[");
	        sb.append(this.timeQuotaType.getType());
	        sb.append("]");
        }
        
        if(baseTimeInterval!=null && baseTimeInterval.getValue()!=null)
        {
	        sb.append("baseTimeInterval=[");
	        sb.append(this.baseTimeInterval.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}