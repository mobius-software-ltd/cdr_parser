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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNGraphicString;
/*
NodeAddress ::= CHOICE
{
 iPAddress [0] IPAddress,
 domainName [1] GraphicString
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class NodeAddress 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = true,index = -1)
	private IPAddress ipAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNGraphicString domainName;
	
	public NodeAddress()
	{
		
	}
	
	public NodeAddress(IPAddress ipAddress,String domainName)
	{
		this.ipAddress = ipAddress;
		
		if(domainName!=null)
			this.domainName=new ASNGraphicString(domainName,null,null,null,false);		
	}

	public IPAddress getIPAddress() 
	{
		return ipAddress;
	}

	public String getDomainName() 
	{
		if(domainName==null)
			return null;
		
		return domainName.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NodeAddress");
        sb.append(" [");

        if(ipAddress!=null)
        {
	        sb.append("ipAddress=[");
	        sb.append(ipAddress);
	        sb.append("]");
        }
        
        if(domainName!=null && domainName.getValue()!=null)
        {
	        sb.append("domainName=[");
	        sb.append(domainName.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}