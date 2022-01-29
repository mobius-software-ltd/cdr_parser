package com.mobius.software.cdr.parser.primitives;

import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

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
AccessNetworkInfoChange ::= SEQUENCE
{
 accessNetworkInformation [0] OCTET STRING OPTIONAL,
 additionalAccessNetworkInformation [1] OCTET STRING OPTIONAL,
 accessChangeTime [2] TimeStamp OPTIONAL,
 cellularNetworkInformation [3] OCTET STRING OPTIONAL
} 
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class AccessNetworkInfoChange 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNOctetString accessNetworkInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNOctetString additionalAccessNetworkInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private TimeStamp accessChangeTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNOctetString cellularNetworkInformation;
	
	public AccessNetworkInfoChange(byte[] accessNetworkInformation,byte[] additionalAccessNetworkInformation,TimeStamp accessChangeTime,byte[] cellularNetworkInformation)
	{
		if(accessNetworkInformation!=null)
			this.accessNetworkInformation=new ASNOctetString(Unpooled.wrappedBuffer(accessNetworkInformation));
		
		if(additionalAccessNetworkInformation!=null)
			this.additionalAccessNetworkInformation=new ASNOctetString(Unpooled.wrappedBuffer(additionalAccessNetworkInformation));
		
		this.accessChangeTime=accessChangeTime;
		
		if(cellularNetworkInformation!=null)
			this.cellularNetworkInformation=new ASNOctetString(Unpooled.wrappedBuffer(cellularNetworkInformation));		
	}

	public byte[] getAccessNetworkInformation() 
	{
		if(accessNetworkInformation==null)
			return null;
		
		ByteBuf value=accessNetworkInformation.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}
	
	public byte[] getAdditionalAccessNetworkInformation() 
	{
		if(additionalAccessNetworkInformation==null)
			return null;
		
		ByteBuf value=additionalAccessNetworkInformation.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}
	
	public TimeStamp getAccessChangeTime() 
	{
		return accessChangeTime;
	}
	
	public byte[] getCellularNetworkInformation() 
	{
		if(cellularNetworkInformation==null)
			return null;
		
		ByteBuf value=cellularNetworkInformation.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AccessNetworkInfoChange");
        sb.append(" [");

        if(accessNetworkInformation!=null && accessNetworkInformation.getValue()!=null)
        {
	        sb.append("accessNetworkInformation=[");
	        sb.append(accessNetworkInformation.printDataArr());
	        sb.append("]");
        }
        
        if(additionalAccessNetworkInformation!=null && additionalAccessNetworkInformation.getValue()!=null)
        {
	        sb.append("additionalAccessNetworkInformation=[");
	        sb.append(additionalAccessNetworkInformation.printDataArr());
	        sb.append("]");
        }
        
        if(cellularNetworkInformation!=null && cellularNetworkInformation.getValue()!=null)
        {
	        sb.append("cellularNetworkInformation=[");
	        sb.append(cellularNetworkInformation.printDataArr())	;
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}