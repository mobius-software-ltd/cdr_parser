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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/*
ISUPCause ::= SEQUENCE
{
 iSUPCauseLocation [0] INTEGER OPTIONAL,
 iSUPCauseValue [1] INTEGER OPTIONAL,
 iSUPCauseDiagnostics [2] OCTET STRING OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class ISUPCause 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNInteger isupCauseLocation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNInteger isupCauseValue;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNOctetString isupCauseDiagnostics;
	
	public ISUPCause(Integer isupCauseLocation,Integer isupCauseValue,byte[] isupCauseDiagnostics)
	{
		if(isupCauseLocation!=null) {
			this.isupCauseLocation=new ASNInteger();
			this.isupCauseLocation.setValue(isupCauseLocation.longValue());
		}
		
		if(isupCauseValue!=null) {
			this.isupCauseValue=new ASNInteger();
			this.isupCauseValue.setValue(isupCauseValue.longValue());
		}
		
		if(isupCauseDiagnostics!=null) {
			this.isupCauseDiagnostics=new ASNOctetString();
			this.isupCauseDiagnostics.setValue(Unpooled.wrappedBuffer(isupCauseDiagnostics));
		}
	}

	public Integer getISUPCauseLocation() 
	{
		if(isupCauseLocation==null || isupCauseLocation.getValue()==null)
			return null;
		
		return isupCauseLocation.getValue().intValue();
	}

	public Integer getISUPCauseValue() 
	{
		if(isupCauseValue==null || isupCauseValue.getValue()==null)
			return null;
		
		return isupCauseValue.getValue().intValue();
	}

	public byte[] getISUPCauseDiagnostics() 
	{
		if(isupCauseDiagnostics==null || isupCauseDiagnostics.getValue()==null)
			return null;
		
		ByteBuf value=isupCauseDiagnostics.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ISUPCause");
        sb.append(" [");

        if(isupCauseLocation!=null && isupCauseLocation.getValue()!=null)
        {
	        sb.append("isupCauseLocation=[");
	        sb.append(isupCauseLocation.getValue());
	        sb.append("]");
        }
        
        if(isupCauseValue!=null && isupCauseValue.getValue()!=null)
        {
	        sb.append("isupCauseValue=[");
	        sb.append(isupCauseValue.getValue());
	        sb.append("]");
        }
        
        if(isupCauseDiagnostics!=null && isupCauseDiagnostics.getValue()!=null)
        {
        	sb.append("isupCauseDiagnostics=[");
	        sb.append(ASNOctetString.printDataArr(getISUPCauseDiagnostics()));
	        sb.append("]");
        }
        
        sb.append("]");
        return sb.toString();
    }
}