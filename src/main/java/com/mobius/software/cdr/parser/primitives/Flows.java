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
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;

/*
Flows ::= SEQUENCE
--
-- See Flows AVP as defined in TS 29.214 [221]
--
{
mediaComponentNumber [1] INTEGER,
flowNumber [2] SEQUENCE OF INTEGER OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class Flows 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNInteger mediaComponentNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private List<ASNInteger> flowNumber;
	
	public Flows()
	{
		
	}
	
	public Flows(Integer mediaComponentNumber,List<Integer> flowNumber)
	{
		if(mediaComponentNumber!=null)
			this.mediaComponentNumber=new ASNInteger(mediaComponentNumber.longValue());
		
		if(flowNumber!=null)
		{
			this.flowNumber=new ArrayList<ASNInteger>();
			for(Integer curr:flowNumber)
			{
				ASNInteger currValue=new ASNInteger(curr.longValue());
				this.flowNumber.add(currValue);
			}
		}
	}

	public Integer getMediaComponentNumber() 
	{
		if(mediaComponentNumber==null || mediaComponentNumber.getValue()==null)
			return null;
		
		return mediaComponentNumber.getValue().intValue();
	}

	public List<Integer> getFlowNumber() 
	{
		if(flowNumber==null)
			return null;
		
		List<Integer> result=new ArrayList<Integer>();
		for(ASNInteger curr:flowNumber)
			result.add(curr.getValue().intValue());
		
		return result;
	}
	
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("Flows");
        sb.append(" [");

        if(mediaComponentNumber!=null && mediaComponentNumber.getValue()!=null)
        {
	        sb.append("mediaComponentNumber=[");
	        sb.append(this.mediaComponentNumber.getValue());
	        sb.append("]");
        }
        
        if(flowNumber!=null && flowNumber.size()!=0)
        {
	        sb.append(", Flow Number=[");
	        int index=0;
	        for(ASNInteger curr:flowNumber)
	        {
	        	if(index!=0)
	        		sb.append(",");
	        	
	        	sb.append(curr.getValue());
	        	index++;
	        }
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}