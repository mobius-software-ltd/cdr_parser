package com.mobius.software.cdr.parser.huawei;
import org.restcomm.protocols.ss7.commonapp.primitives.AddressStringImpl;

import com.mobius.software.cdr.parser.primitives.TimeStamp;
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
TrailerRecord            ::= SEQUENCE
{
    productionDateTime      [0] TimeStamp,
    recordingEntity         [1] RecordingEntity,
    firstCallDateTime       [2] TimeStamp,
    lastCallDateTime        [3] TimeStamp,
    noOfRecords             [4] INTEGER,
    extensions              [5] ManagementExtensions
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class TrailerRecord 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = true,index = -1)
	private TimeStamp productionDateTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private AddressStringImpl recordingEntity;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = true,index = -1)
	private TimeStamp firstCallDateTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = true,index = -1)
	private TimeStamp lastCallDateTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNInteger noOfRecords;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = true,index = -1)
	private ASNOctetString extensions;
	
	public TrailerRecord()
	{
		
	}
	
	public TrailerRecord(TimeStamp productionDateTime,AddressStringImpl recordingEntity,TimeStamp firstCallDateTime,TimeStamp lastCallDateTime,Integer noOfRecords,byte[] extensions)
	{
		this.productionDateTime=productionDateTime;
		this.recordingEntity=recordingEntity;
		this.firstCallDateTime=firstCallDateTime;
		this.lastCallDateTime=lastCallDateTime;
		
		if(noOfRecords!=null)
		{
			this.noOfRecords=new ASNInteger();
			this.noOfRecords.setValue(noOfRecords.longValue());
		}
		
		if(extensions!=null)
		{
			this.extensions=new ASNOctetString();
			this.extensions.setValue(Unpooled.wrappedBuffer(extensions));
		}
	}
	
	public TimeStamp getProductionDateTime() 
	{
		return productionDateTime;
	}

	public AddressStringImpl getRecordingEntity() 
	{
		return recordingEntity;
	}

	public TimeStamp getFirstCallDateTime() 
	{
		return firstCallDateTime;
	}

	public TimeStamp getLastCallDateTime() 
	{
		return lastCallDateTime;
	}

	public Integer getNoOfRecords() 
	{
		if(noOfRecords==null || noOfRecords.getValue()==null)
			return null;
		
		return noOfRecords.getValue().intValue();
	}

	public byte[] getExtensions() 
	{
		if(extensions==null || extensions.getValue()==null)
			return null;
		
		ByteBuf value=extensions.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("HeaderRecord");
        sb.append(" [");

        if(productionDateTime!=null)
        {
	        sb.append("productionDateTime=[");
	        sb.append(productionDateTime);
	        sb.append("]");
        }
        
        if(recordingEntity!=null)
        {
	        sb.append("recordingEntity=[");
	        sb.append(recordingEntity);
	        sb.append("]");
        }
        
        if(firstCallDateTime!=null)
        {
	        sb.append("firstCallDateTime=[");
	        sb.append(firstCallDateTime);
	        sb.append("]");
        }
        
        if(lastCallDateTime!=null)
        {
	        sb.append("lastCallDateTime=[");
	        sb.append(lastCallDateTime);
	        sb.append("]");
        }
        
        if(noOfRecords!=null && noOfRecords.getValue()!=null)
        {
	        sb.append("noOfRecords=[");
	        sb.append(noOfRecords.getValue());
	        sb.append("]");
        }
        
        if(extensions!=null && extensions.getValue()!=null)
        {
	        sb.append("extensions=[");
	        sb.append(ASNOctetString.printDataArr(getExtensions()));
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}