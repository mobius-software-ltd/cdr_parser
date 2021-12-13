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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNBoolean;
/*
Incomplete-CDR-Indication ::= SET
{
 aCRStartLost [0] BOOLEAN, -- TRUE if ACR[Start] was lost, FALSE otherwise
 aCRInterimLost [1] ACRInterimLost,
 aCRStopLost [2] BOOLEAN -- TRUE if ACR[Stop] was lost, FALSE otherwise
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class IncompleteCDRIndication 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNBoolean acrStartLost;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNACRInterimLost acrInterimLost;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNBoolean acrStopLost;
	
	public IncompleteCDRIndication()
	{
		
	}
	
	public IncompleteCDRIndication(Boolean acrStartLost,ACRInterimLost acrInterimLost,Boolean acrStopLost)
	{
		if(acrStartLost!=null)
		{
			this.acrStartLost=new ASNBoolean();
			this.acrStartLost.setValue(acrStartLost);
		}
		
		if(acrInterimLost!=null)
		{
			this.acrInterimLost=new ASNACRInterimLost();
			this.acrInterimLost.setType(acrInterimLost);
		}
		
		if(acrStopLost!=null)
		{
			this.acrStopLost=new ASNBoolean();
			this.acrStopLost.setValue(acrStopLost);
		}				
	}

	public Boolean getACRStartLost() 
	{
		if(acrStartLost==null || acrStartLost.getValue()==null)
			return null;
		
		return acrStartLost.getValue();
	}

	public ACRInterimLost getACRInterimLost() 
	{
		if(acrInterimLost==null)
			return null;
		
		return acrInterimLost.getType();
	}
	
	public Boolean getACRStopLost() 
	{
		if(acrStopLost==null || acrStopLost.getValue()==null)
			return null;
		
		return acrStopLost.getValue();
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IncompleteCDRIndication");
        sb.append(" [");

        if(acrInterimLost!=null && acrInterimLost.getValue()!=null)
        {
	        sb.append("acrInterimLost=[");
	        sb.append(acrInterimLost.getValue());
	        sb.append("]");
        }
        
        if(acrStartLost!=null && acrStartLost.getValue()!=null)
        {
	        sb.append("acrStartLost=[");
	        sb.append(acrStartLost.getValue());
	        sb.append("]");
        }
        
        if(acrStopLost!=null && acrStopLost.getValue()!=null)
        {
	        sb.append("acrStopLost=[");
	        sb.append(acrStopLost.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}