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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNIA5String;
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class IPTextRepresentedAddress 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNIA5String iPTextV4Address;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNIA5String iPTextV6Address;
	
	public IPTextRepresentedAddress()
	{
		
	}
	
	public IPTextRepresentedAddress(String iPTextAddress,Boolean isIPV6)
	{
		if(isIPV6==null || !isIPV6)
		{
			if(iPTextAddress!=null)
			{
				this.iPTextV4Address=new ASNIA5String();
				this.iPTextV4Address.setValue(iPTextAddress);
			}
		}
		else
		{
			if(iPTextAddress!=null)
			{
				this.iPTextV6Address=new ASNIA5String();
				this.iPTextV6Address.setValue(iPTextAddress);
			}
		}
	}

	public String getIPV4Address() 
	{
		if(iPTextV4Address==null)
			return null;
		
		return iPTextV4Address.getValue();
	}

	public String getIPV6Address() 
	{
		if(iPTextV6Address==null)
			return null;
		
		return iPTextV6Address.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IPTextRepresentedAddress");
        sb.append(" [");

        if(iPTextV4Address!=null && iPTextV4Address.getValue()!=null)
        {
	        sb.append(", IPV4=[");
	        sb.append(this.iPTextV4Address.getValue());
	        sb.append("]");
        }
        
        if(iPTextV6Address!=null && iPTextV6Address.getValue()!=null)
        {
	        sb.append(", IPV6=[");
	        sb.append(this.iPTextV6Address.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}