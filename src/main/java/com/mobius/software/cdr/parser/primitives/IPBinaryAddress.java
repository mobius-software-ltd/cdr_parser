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
import java.net.InetAddress;

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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class IPBinaryAddress 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNOctetString iPV4Address;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNOctetString iPV6Address;
	
	public IPBinaryAddress()
	{
		
	}
	
	public IPBinaryAddress(byte[] data,Boolean isIPV6)
	{
		if(isIPV6==null || !isIPV6)
		{
			if(data!=null)
				this.iPV4Address=new ASNOctetString(Unpooled.wrappedBuffer(data),null,null,null,false);			
		}
		else
		{
			if(data!=null)
				this.iPV6Address=new ASNOctetString(Unpooled.wrappedBuffer(data),null,null,null,false);			
		}
	}

	public String getIPV4Address() 
	{
		if(iPV4Address==null)
			return null;
		
		ByteBuf value=iPV4Address.getValue();
		if(value==null || value.readableBytes()!=4)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		try 
		{
			InetAddress address=InetAddress.getByAddress(data);
			if(address!=null)
				return address.toString();
		}
		catch(Exception ex)
		{
			
		}
		
		return iPV4Address.printDataArr();
	}

	public String getIPV6Address() 
	{
		if(iPV6Address==null)
			return null;
		
		ByteBuf value=iPV6Address.getValue();
		if(value==null || value.readableBytes()!=16)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		try 
		{
			InetAddress address=InetAddress.getByAddress(data);
			if(address!=null)
				return address.toString();
		}
		catch(Exception ex)
		{
			
		}
		
		return iPV6Address.printDataArr();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IPTextRepresentedAddress");
        sb.append(" [");

        if(iPV4Address!=null && iPV4Address.getValue()!=null)
        {
	        sb.append(", IPV4=[");
	        sb.append(this.getIPV4Address());
	        sb.append("]");
        }
        
        if(iPV6Address!=null && iPV6Address.getValue()!=null)
        {
	        sb.append(", IPV6=[");
	        sb.append(this.getIPV6Address());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}