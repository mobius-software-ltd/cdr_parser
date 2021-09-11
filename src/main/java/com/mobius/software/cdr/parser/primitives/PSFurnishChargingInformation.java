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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class PSFurnishChargingInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNOctetString pSFreeFormatData;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNBoolean pSFFDAppendIndicator;
	
	public PSFurnishChargingInformation(byte[] freeFormData,Boolean pSFFDAppendIndicator)
	{
		if(freeFormData!=null)
		{
			this.pSFreeFormatData=new ASNOctetString();
			this.pSFreeFormatData.setValue(Unpooled.wrappedBuffer(freeFormData));
		}
		
		if(pSFFDAppendIndicator!=null)
		{
			this.pSFFDAppendIndicator=new ASNBoolean();
			this.pSFFDAppendIndicator.setValue(pSFFDAppendIndicator);
		}
	}

	public byte[] getpSFreeFormatData() 
	{
		if(pSFreeFormatData==null)
			return null;
		
		ByteBuf value=pSFreeFormatData.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public Boolean getpSFFDAppendIndicator() 
	{
		if(pSFFDAppendIndicator==null)
			return null;
		
		return pSFFDAppendIndicator.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PSFurnishChargingInformation");
        sb.append(" [");

        if(pSFreeFormatData!=null && pSFreeFormatData.getValue()!=null)
        {
	        sb.append("freeFormData=[");
	        sb.append(this.pSFreeFormatData.printDataArr(getpSFreeFormatData()));
	        sb.append("]");
        }
        
        if(pSFFDAppendIndicator!=null && pSFFDAppendIndicator.getValue()!=null)
        {
	        sb.append(", FFD Append Indicator=[");
	        sb.append(this.pSFFDAppendIndicator.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}