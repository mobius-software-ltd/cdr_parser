package com.mobius.software.cdr.parser.primitives;
import org.restcomm.protocols.ss7.cap.service.circuitSwitchedCall.primitive.DestinationRoutingAddressImpl;
import org.restcomm.protocols.ss7.map.service.sms.SM_RP_SMEAImpl;

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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/*
CAMELInformation ::= SET
{
 cAMELDestinationNumber [1] CAMELDestinationNumber OPTIONAL,
 connectedNumber [2] ConnectedNumber OPTIONAL,
 roamingNumber [3] RoamingNumber OPTIONAL,
 mscOutgoingTKGP [4] TrunkGroup OPTIONAL,
 seizureTime [5] TimeStamp OPTIONAL,
 answerTime [6] TimeStamp OPTIONAL,
 releaseTime [7] TimeStamp OPTIONAL,
 callDuration [8] CallDuration OPTIONAL,
 dataVolume [9] DataVolume OPTIONAL,
 cAMELInitCFIndicator [10] CAMELInitCFIndicator OPTIONAL,
 causeForTerm [11] CauseForTerm OPTIONAL,
 cAMELModification [12] ChangedParameters OPTIONAL,
 freeFormatData [13] FreeFormatData OPTIONAL,
 diagnostics [14] Diagnostics OPTIONAL,
 freeFormatDataAppend [15] BOOLEAN OPTIONAL,
 freeFormatData-2 [16] FreeFormatData OPTIONAL,
 freeFormatDataAppend-2 [17] BOOLEAN OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class CAMELInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = true,index = -1)
	private DestinationRoutingAddressImpl camelDestinationNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private SM_RP_SMEAImpl connectedNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private SM_RP_SMEAImpl roamingNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = true,index = -1)
	private TrunkGroup mscOutgoingTKGP;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private TimeStamp seizureTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private TimeStamp answerTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private TimeStamp releaseTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private ASNInteger callDuration;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = false,index = -1)
	private ASNInteger dataVolume;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 10,constructed = false,index = -1)
	private ASNCAMELInitCFIndicator camelInitCFIndicator;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 11,constructed = false,index = -1)
	private ASNCauseForRecClosing causeForTerm;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 12,constructed = true,index = -1)
	private ChangeParameters changeParameters;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 13,constructed = false,index = -1)
	private ASNOctetString freeFormatData;
		
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 14,constructed = true,index = -1)
	private Diagnostics diagnostics;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 15,constructed = false,index = -1)
	private ASNBoolean freeFormatDataAppend;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 16,constructed = false,index = -1)
	private ASNOctetString freeFormatData2;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 17,constructed = false,index = -1)
	private ASNBoolean freeFormatDataAppend2;
	
	public CAMELInformation(DestinationRoutingAddressImpl camelDestinationNumber,SM_RP_SMEAImpl connectedNumber,SM_RP_SMEAImpl roamingNumber,TrunkGroup mscOutgoingTKGP,TimeStamp seizureTime,TimeStamp answerTime,TimeStamp releaseTime,Integer callDuration,Integer dataVolume,CAMELInitCFIndicator camelInitCFIndicator,CauseForRecClosing causeForTerm,ChangeParameters changeParameters,byte[] freeFormatData,Diagnostics diagnostics,Boolean freeFormatDataAppend,byte[] freeFormatData2,Boolean freeFormatDataAppend2)
	{
		this.camelDestinationNumber=camelDestinationNumber;
		this.connectedNumber=connectedNumber;
		this.roamingNumber=roamingNumber;
		this.mscOutgoingTKGP=mscOutgoingTKGP;
		this.seizureTime=seizureTime;
		this.answerTime=answerTime;
		this.releaseTime=releaseTime;
		
		if(callDuration!=null)
		{
			this.callDuration=new ASNInteger();
			this.callDuration.setValue(callDuration.longValue());
		}
		
		if(dataVolume!=null)
		{
			this.dataVolume=new ASNInteger();
			this.dataVolume.setValue(dataVolume.longValue());
		}
		
		if(camelInitCFIndicator!=null)
		{
			this.camelInitCFIndicator=new ASNCAMELInitCFIndicator();
			this.camelInitCFIndicator.setType(camelInitCFIndicator);
		}
		
		if(causeForTerm!=null)
		{
			this.causeForTerm=new ASNCauseForRecClosing();
			this.causeForTerm.setType(causeForTerm);
		}
		
		this.changeParameters=changeParameters;
		
		if(freeFormatData!=null)
		{
			this.freeFormatData=new ASNOctetString();
			this.freeFormatData.setValue(Unpooled.wrappedBuffer(freeFormatData));
		}
		
		this.diagnostics=diagnostics;
		
		if(freeFormatDataAppend!=null)
		{
			this.freeFormatDataAppend=new ASNBoolean();
			this.freeFormatDataAppend.setValue(freeFormatDataAppend);
		}
		
		if(freeFormatData2!=null)
		{
			this.freeFormatData2=new ASNOctetString();
			this.freeFormatData2.setValue(Unpooled.wrappedBuffer(freeFormatData2));
		}
		
		if(freeFormatDataAppend2!=null)
		{
			this.freeFormatDataAppend2=new ASNBoolean();
			this.freeFormatDataAppend2.setValue(freeFormatDataAppend2);
		}				
	}

	public DestinationRoutingAddressImpl getCamelDestinationNumber() 
	{
		return camelDestinationNumber;
	}

	public SM_RP_SMEAImpl getConnectedNumber() 
	{
		return connectedNumber;
	}

	public SM_RP_SMEAImpl getRoamingNumber() 
	{
		return roamingNumber;
	}

	public TrunkGroup getMscOutgoingTKGP() 
	{
		return mscOutgoingTKGP;
	}

	public TimeStamp getSeizureTime() 
	{
		return seizureTime;
	}

	public TimeStamp getAnswerTime() 
	{
		return answerTime;
	}

	public TimeStamp getReleaseTime() 
	{
		return releaseTime;
	}

	public Integer getCallDuration() 
	{
		if(callDuration==null || callDuration.getValue()==null)
			return null;
		
		return callDuration.getValue().intValue();
	}

	public Integer getDataVolume() 
	{
		if(dataVolume==null || dataVolume.getValue()==null)
			return null;
		
		return dataVolume.getValue().intValue();
	}

	public CAMELInitCFIndicator getCAMELInitCFIndicator() 
	{
		if(camelInitCFIndicator==null)
			return null;
		
		return camelInitCFIndicator.getCode();
	}

	public CauseForRecClosing getCauseForTerm() 
	{
		if(causeForTerm==null)
			return null;
		
		return causeForTerm.getType();
	}

	public ChangeParameters getChangeParameters() 
	{
		return changeParameters;
	}

	public byte[] getFreeFormatData() 
	{
		if(freeFormatData==null)
			return null;
		
		ByteBuf value = freeFormatData.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public Diagnostics getDiagnostics() 
	{
		return diagnostics;
	}
	
	public Boolean getFreeFormatDataAppend() 
	{
		if(freeFormatDataAppend==null)
			return null;
		
		return freeFormatDataAppend.getValue();
	}

	public byte[] getFreeFormatData2() 
	{
		if(freeFormatData2==null)
			return null;
		
		ByteBuf value = freeFormatData2.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public Boolean getFreeFormatDataAppend2() 
	{
		if(freeFormatDataAppend2==null)
			return null;
		
		return freeFormatDataAppend2.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CAMELInformation");
        sb.append(" [");

        if(camelDestinationNumber!=null)
        {
	        sb.append("camelDestinationNumber=[");
	        sb.append(camelDestinationNumber);
	        sb.append("]");
        }
        
        if(connectedNumber!=null)
        {
	        sb.append("connectedNumber=[");
	        sb.append(connectedNumber);
	        sb.append("]");
        }
        
        if(roamingNumber!=null)
        {
	        sb.append("roamingNumber=[");
	        sb.append(roamingNumber);
	        sb.append("]");
        }
        
        if(mscOutgoingTKGP!=null)
        {
	        sb.append("mscOutgoingTKGP=[");
	        sb.append(mscOutgoingTKGP);
	        sb.append("]");
        }
        
        if(seizureTime!=null)
        {
	        sb.append("seizureTime=[");
	        sb.append(seizureTime);
	        sb.append("]");
        }
        
        if(answerTime!=null)
        {
	        sb.append("answerTime=[");
	        sb.append(answerTime);
	        sb.append("]");
        }
        
        if(releaseTime!=null)
        {
	        sb.append("releaseTime=[");
	        sb.append(releaseTime);
	        sb.append("]");
        }
        
        if(callDuration!=null && callDuration.getValue()!=null)
        {
	        sb.append("callDuration=[");
	        sb.append(callDuration.getValue());
	        sb.append("]");
        }
        
        if(dataVolume!=null && dataVolume.getValue()!=null)
        {
	        sb.append("dataVolume=[");
	        sb.append(dataVolume.getValue());
	        sb.append("]");
        }
        
        if(camelInitCFIndicator!=null && camelInitCFIndicator.getValue()!=null)
        {
	        sb.append("camelInitCFIndicator=[");
	        sb.append(camelInitCFIndicator.getCode());
	        sb.append("]");
        }
        
        if(causeForTerm!=null && causeForTerm.getValue()!=null)
        {
	        sb.append("causeForTerm=[");
	        sb.append(causeForTerm.getType());
	        sb.append("]");
        }
        
        if(changeParameters!=null)
        {
	        sb.append("changeParameters=[");
	        sb.append(changeParameters);
	        sb.append("]");
        }
        
        if(freeFormatData!=null && freeFormatData.getValue()!=null)
        {
	        sb.append("freeFormatData=[");
	        sb.append(ASNOctetString.printDataArr(getFreeFormatData()));
	        sb.append("]");
        }
        
        if(diagnostics!=null)
        {
	        sb.append("diagnostics=[");
	        sb.append(diagnostics);
	        sb.append("]");
        }
        
        if(freeFormatDataAppend!=null && freeFormatDataAppend.getValue()!=null)
        {
	        sb.append("freeFormatDataAppend=[");
	        sb.append(freeFormatDataAppend.getValue());
	        sb.append("]");
        }
        
        if(freeFormatData2!=null && freeFormatData2.getValue()!=null)
        {
	        sb.append("freeFormatData2=[");
	        sb.append(ASNOctetString.printDataArr(getFreeFormatData2()));
	        sb.append("]");
        }
        
        if(freeFormatDataAppend2!=null && freeFormatDataAppend2.getValue()!=null)
        {
	        sb.append("freeFormatDataAppend2=[");
	        sb.append(freeFormatDataAppend2.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}