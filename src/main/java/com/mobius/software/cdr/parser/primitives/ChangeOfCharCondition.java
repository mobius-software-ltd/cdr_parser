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
ChangeOfCharCondition ::= SEQUENCE
--
-- qosRequested and qosNegotiated are used in S-CDR only
-- ePCQoSInformation used in SGW-CDR only
--
{
qosRequested [1] QoSInformation OPTIONAL,
qosNegotiated [2] QoSInformation OPTIONAL,
dataVolumeGPRSUplink [3] DataVolumeGPRS OPTIONAL,
dataVolumeGPRSDownlink [4] DataVolumeGPRS OPTIONAL,
changeCondition [5] ChangeCondition,
changeTime [6] TimeStamp,
userLocationInformation [8] OCTET STRING OPTIONAL,
ePCQoSInformation [9] EPCQoSInformation OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class ChangeOfCharCondition 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNOctetString qosRequested;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNOctetString qosNegotiated;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNInteger dataVolumeGPRSUplink;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNInteger dataVolumeGPRSDownlink;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private ASNChangeCondition changeCondition;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private TimeStamp changeTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private ASNOctetString userLocationInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = true,index = -1)
	private EPCQoSInformation ePCQoSInformation;
	
	public ChangeOfCharCondition()
	{
		
	}
	
	public ChangeOfCharCondition(byte[] qosRequested,byte[] qosNegotiated,Integer dataVolumeGPRSUplink,Integer dataVolumeGPRSDownlink,
			ChangeCondition changeCondition,TimeStamp changeTime,byte[] userLocationInformation,EPCQoSInformation ePCQoSInformation)
	{
		if(qosRequested!=null)
			this.qosRequested=new ASNOctetString(Unpooled.wrappedBuffer(qosRequested),null,null,null,false);
		
		if(qosNegotiated!=null)
			this.qosNegotiated=new ASNOctetString(Unpooled.wrappedBuffer(qosNegotiated),null,null,null,false);
		
		if(dataVolumeGPRSUplink!=null)
			this.dataVolumeGPRSUplink=new ASNInteger(dataVolumeGPRSUplink.longValue(),null,null,null,false);
		
		if(dataVolumeGPRSDownlink!=null)
			this.dataVolumeGPRSDownlink=new ASNInteger(dataVolumeGPRSDownlink.longValue(),null,null,null,false);
		
		if(changeCondition!=null)
			this.changeCondition=new ASNChangeCondition(changeCondition);
		
		this.changeTime=changeTime;
		
		if(userLocationInformation!=null)
			this.userLocationInformation=new ASNOctetString(Unpooled.wrappedBuffer(userLocationInformation),null,null,null,false);		
		
		this.ePCQoSInformation=ePCQoSInformation;
	}

	public byte[] getQOSRequested() 
	{
		if(qosRequested==null)
			return null;
		
		ByteBuf value=qosRequested.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public byte[] getQOSNegotiated() 
	{
		if(qosNegotiated==null)
			return null;
		
		ByteBuf value=qosRequested.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public Integer getDataVolumeGPRSUplink() 
	{
		if(dataVolumeGPRSUplink==null || dataVolumeGPRSUplink.getValue()==null)
			return null;
		
		return dataVolumeGPRSUplink.getValue().intValue();
	}

	public Integer getDataVolumeGPRSDownlink() 
	{
		if(dataVolumeGPRSDownlink==null || dataVolumeGPRSDownlink.getValue()==null)
			return null;
		
		return dataVolumeGPRSDownlink.getValue().intValue();
	}

	public ChangeCondition getChangeCondition() 
	{
		if(changeCondition==null)
			return null;
		
		return changeCondition.getCondition();
	}

	public TimeStamp getChangeTime() 
	{
		return changeTime;
	}

	public byte[] getUserLocationInformation() 
	{
		if(userLocationInformation==null)
			return null;
		
		ByteBuf value=userLocationInformation.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public EPCQoSInformation getEPCQoSInformation() 
	{
		return ePCQoSInformation;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChangeOfCharCondition");
        sb.append(" [");

        if(qosRequested!=null && qosRequested.getValue()!=null)
        {
	        sb.append("qosRequested=[");
	        sb.append(qosRequested.printDataArr());
	        sb.append("]");
        }
        
        if(qosNegotiated!=null && qosNegotiated.getValue()!=null)
        {
	        sb.append("qosNegotiated=[");
	        sb.append(qosNegotiated.printDataArr());
	        sb.append("]");
        }
        
        if(dataVolumeGPRSUplink!=null && dataVolumeGPRSUplink.getValue()!=null)
        {
	        sb.append(", dataVolumeGPRSUplink=[");
	        sb.append(this.dataVolumeGPRSUplink.getValue());
	        sb.append("]");
        }
        
        if(dataVolumeGPRSDownlink!=null && dataVolumeGPRSDownlink.getValue()!=null)
        {
	        sb.append(", dataVolumeGPRSDownlink=[");
	        sb.append(this.dataVolumeGPRSDownlink.getValue());
	        sb.append("]");
        }
        
        if(changeCondition!=null && changeCondition.getValue()!=null)
        {
	        sb.append(", changeCondition=[");
	        sb.append(this.changeCondition.getCondition());
	        sb.append("]");
        }
        
        if(changeTime!=null)
        {
	        sb.append(", changeTime=[");
	        sb.append(this.changeTime);
	        sb.append("]");
        }
        
        if(userLocationInformation!=null && userLocationInformation.getValue()!=null)
        {
	        sb.append("userLocationInformation=[");
	        sb.append(userLocationInformation.printDataArr());
	        sb.append("]");
        }
        
        if(ePCQoSInformation!=null)
        {
	        sb.append(", ePCQoSInformation=[");
	        sb.append(this.ePCQoSInformation);
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}