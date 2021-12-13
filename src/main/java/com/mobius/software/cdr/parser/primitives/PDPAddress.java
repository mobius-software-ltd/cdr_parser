package com.mobius.software.cdr.parser.primitives;

import org.restcomm.protocols.ss7.map.primitives.AddressStringImpl;

import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;

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
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class PDPAddress 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = true,index = -1)
	private IPAddress ipAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = true,index = -1)
	private AddressStringImpl eTSIAddress;
	
	public PDPAddress()
	{
		
	}
	
	public PDPAddress(IPAddress ipAddress,AddressStringImpl eTSIAddress)
	{
		this.ipAddress=ipAddress;
		this.eTSIAddress=eTSIAddress;
	}

	public IPAddress getIPAddress() 
	{
		return ipAddress;
	}

	public AddressStringImpl getETSIAddress() 
	{
		return eTSIAddress;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IPAddress");
        sb.append(" [");

        if(ipAddress!=null)
        {
	        sb.append(", ipAddress=[");
	        sb.append(this.ipAddress);
	        sb.append("]");
        }
        
        if(eTSIAddress!=null)
        {
	        sb.append(", eTSIAddress=[");
	        sb.append(this.eTSIAddress);
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}