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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/*
AFRecordInformation ::= SEQUENCE
{
aFChargingIdentifier [1] AFChargingIdentifier,
flows [2] Flows OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class AFRecordInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNOctetString aFChargingIdentifier;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = true,index = -1)
	private Flows flows;
	
	public AFRecordInformation()
	{
		
	}
	
	public AFRecordInformation(byte[] aFChargingIdentifier,Flows flows)
	{
		if(aFChargingIdentifier!=null)
			this.aFChargingIdentifier=new ASNOctetString(Unpooled.wrappedBuffer(aFChargingIdentifier),null,null,null,false);
		
		this.flows=flows;
	}

	public byte[] getaFChargingIdentifier() 
	{
		if(aFChargingIdentifier==null)
			return null;
		
		ByteBuf value=aFChargingIdentifier.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public Flows getFlows() 
	{
		return flows;
	}
	
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("AFRecordInformation");
        sb.append(" [");

        if(aFChargingIdentifier!=null && aFChargingIdentifier.getValue()!=null)
        {
	        sb.append("AF Charging Identifier=[");
	        sb.append(aFChargingIdentifier.printDataArr());
	        sb.append("]");
        }
        
        if(flows!=null)
        {
	        sb.append("Flows=[");
	        sb.append(this.flows);
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}
