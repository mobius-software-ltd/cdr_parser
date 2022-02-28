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
TransmissionMedium ::= SEQUENCE
{
 tMR [0] OCTET STRING (SIZE (1)) OPTIONAL, -- required TM, refer to Q.763
 tMU [1] OCTET STRING (SIZE (1)) OPTIONAL -- used TM, refer to Q.763
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class TransmissionMedium 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNOctetString tmr;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNOctetString tmu;
	
	public TransmissionMedium(byte[] tmr,byte[] tmu)
	{
		if(tmr!=null)
			this.tmr=new ASNOctetString(Unpooled.wrappedBuffer(tmr),null,null,null,false);
		
		if(tmu!=null)
			this.tmu=new ASNOctetString(Unpooled.wrappedBuffer(tmu),null,null,null,false);		
	}

	public byte[] getTMR() 
	{
		if(tmr==null || tmr.getValue()==null)
			return null;
		
		ByteBuf value=tmr.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public byte[] getTMU() 
	{
		if(tmu==null || tmu.getValue()==null)
			return null;
		
		ByteBuf value=tmu.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransmissionMedium");
        sb.append(" [");

        if(tmr!=null && tmr.getValue()!=null)
        {
	        sb.append("tmr=[");
	        sb.append(tmr.printDataArr());
	        sb.append("]");
        }
        
        if(tmu!=null && tmu.getValue()!=null)
        {
	        sb.append("tmu=[");
	        sb.append(tmu.printDataArr());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}