package com.mobius.software.cdr.parser.cs;
import org.restcomm.protocols.ss7.map.api.primitives.AddressStringImpl;
import org.restcomm.protocols.ss7.map.api.service.callhandling.CallReferenceNumberImpl;
import org.restcomm.protocols.ss7.map.api.service.mobility.subscriberInformation.RouteingNumberImpl;
import org.restcomm.protocols.ss7.map.api.service.sms.SM_RP_SMEAImpl;

import com.mobius.software.cdr.parser.primitives.ASNBasicService;
import com.mobius.software.cdr.parser.primitives.ASNCauseForRecClosing;
import com.mobius.software.cdr.parser.primitives.ASNLocationRoutingNumberQueryStatus;
import com.mobius.software.cdr.parser.primitives.ASNLocationRoutingNumberSourceIndicator;
import com.mobius.software.cdr.parser.primitives.ASNRecordType;
import com.mobius.software.cdr.parser.primitives.BasicService;
import com.mobius.software.cdr.parser.primitives.CauseForRecClosing;
import com.mobius.software.cdr.parser.primitives.Diagnostics;
import com.mobius.software.cdr.parser.primitives.LocationRoutingNumberQueryStatus;
import com.mobius.software.cdr.parser.primitives.LocationRoutingNumberSourceIndicator;
import com.mobius.software.cdr.parser.primitives.RecordType;
import com.mobius.software.cdr.parser.primitives.TimeStamp;
import com.mobius.software.cdr.parser.primitives.TrunkGroup;
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
TransitCallRecord ::= SET
{
 recordType [0] RecordType,
 recordingEntity [1] RecordingEntity,
 mscIncomingTKGP [2] TrunkGroup OPTIONAL,
 mscOutgoingTKGP [3] TrunkGroup OPTIONAL,
 callingNumber [4] CallingNumber OPTIONAL,
 calledNumber [5] CalledNumber,
 isdnBasicService [6] BasicService OPTIONAL,
 seizureTimestamp [7] TimeStamp OPTIONAL,
 answerTimestamp [8] TimeStamp OPTIONAL,
 releaseTimestamp [9] TimeStamp OPTIONAL,
 callDuration [10] CallDuration,
 dataVolume [11] DataVolume OPTIONAL,
 causeForTerm [12] CauseForTerm,
 diagnostics [13] Diagnostics OPTIONAL,
 callReference [14] CallReferenceNumber,
 sequenceNumber [15] INTEGER OPTIONAL,
 recordExtensions [16] ManagementExtensions OPTIONAL,
 locationRoutNum [17] LocationRoutingNumber OPTIONAL,
 lrnSoInd [18] LocationRoutingNumberSourceIndicator OPTIONAL,
 lrnQuryStatus [19] LocationRoutingNumberQueryStatus OPTIONAL,
 jIPPara [20] JurisdictionInformationParameter OPTIONAL,
 jIPSoInd [21] JurisdictionInformationParameterSourceIndicator OPTIONAL,
 jIPQuryStatus [22] JurisdictionInformationParameterQueryStatus OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = true,lengthIndefinite = false)
public class TransitRecord 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNRecordType recordType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private AddressStringImpl recordingEntity;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = true,index = -1)
	private TrunkGroup mscIncomingTKGP;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = true,index = -1)
	private TrunkGroup mscOutgoingTKGP;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private SM_RP_SMEAImpl callingNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private SM_RP_SMEAImpl calledNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private ASNBasicService isdnBasicService;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private TimeStamp seizureTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private TimeStamp answerTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = false,index = -1)
	private TimeStamp releaseTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 10,constructed = false,index = -1)
	private ASNInteger callDuration;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 11,constructed = false,index = -1)
	private ASNInteger dataVolume;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 12,constructed = false,index = -1)
	private ASNCauseForRecClosing causeForTerm;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 13,constructed = true,index = -1)
	private Diagnostics diagnostics;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 14,constructed = false,index = -1)
	private CallReferenceNumberImpl callReferenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 15,constructed = false,index = -1)
	private ASNInteger sequenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 16,constructed = true,index = -1)
	private ASNOctetString recordExtensions;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 17,constructed = false,index = -1)
	private RouteingNumberImpl locationRoutNum;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 18,constructed = false,index = -1)
	private ASNLocationRoutingNumberSourceIndicator locationRoutingNumberSourceIndicator;	
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 19,constructed = false,index = -1)
	private ASNLocationRoutingNumberQueryStatus locationRoutingNumberQueryStatus;	
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 20,constructed = false,index = -1)
	private RouteingNumberImpl jIPPara;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 21,constructed = false,index = -1)
	private ASNLocationRoutingNumberSourceIndicator jIPSoInd;	
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 22,constructed = false,index = -1)
	private ASNLocationRoutingNumberQueryStatus jIPQuryStatus;	
	
	public TransitRecord()
	{
		
	}
	
	public TransitRecord(RecordType recordType,AddressStringImpl recordingEntity,TrunkGroup mscIncomingTKGP,TrunkGroup mscOutgoingTKGP,SM_RP_SMEAImpl callingNumber,SM_RP_SMEAImpl calledNumber,BasicService isdnBasicService,TimeStamp seizureTime,TimeStamp answerTime,TimeStamp releaseTime,Integer callDuration,Integer dataVolume,CauseForRecClosing causeForTerm,Diagnostics diagnostics,CallReferenceNumberImpl callReferenceNumber,Integer sequenceNumber,byte[] recordExtensions,RouteingNumberImpl locationRoutNum,LocationRoutingNumberSourceIndicator locationRoutingNumberSourceIndicator,LocationRoutingNumberQueryStatus locationRoutingNumberQueryStatus,RouteingNumberImpl jIPPara,LocationRoutingNumberSourceIndicator jIPSoInd,LocationRoutingNumberQueryStatus jIPQuryStatus)
	{
		if(recordType!=null)
		{
			this.recordType=new ASNRecordType(); 
			this.recordType.setType(recordType);
		}
		
		this.recordingEntity=recordingEntity;
		this.mscIncomingTKGP=mscIncomingTKGP;
		this.mscOutgoingTKGP=mscOutgoingTKGP;
		this.callingNumber=callingNumber;
		this.calledNumber=calledNumber;
		
		if(isdnBasicService!=null)
		{
			this.isdnBasicService=new ASNBasicService();
			this.isdnBasicService.setType(isdnBasicService);
		}
		
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
		
		if(causeForTerm!=null)
		{
			this.causeForTerm=new ASNCauseForRecClosing();
			this.causeForTerm.setType(causeForTerm);
		}
		
		this.diagnostics=diagnostics;
		this.callReferenceNumber=callReferenceNumber;
		
		if(sequenceNumber!=null)
		{
			this.sequenceNumber=new ASNInteger();
			this.sequenceNumber.setValue(sequenceNumber.longValue());
		}
		
		if(recordExtensions!=null)
		{
			this.recordExtensions=new ASNOctetString();
			this.recordExtensions.setValue(Unpooled.wrappedBuffer(recordExtensions));
		}
		
		this.locationRoutNum=locationRoutNum;
		
		if(locationRoutingNumberSourceIndicator!=null)
		{
			this.locationRoutingNumberSourceIndicator= new ASNLocationRoutingNumberSourceIndicator();
			this.locationRoutingNumberSourceIndicator.setType(locationRoutingNumberSourceIndicator);
		}
		
		if(locationRoutingNumberQueryStatus!=null)
		{
			this.locationRoutingNumberQueryStatus=new ASNLocationRoutingNumberQueryStatus();
			this.locationRoutingNumberQueryStatus.setType(locationRoutingNumberQueryStatus);
		}
		
		this.jIPPara=jIPPara;
		
		if(jIPSoInd!=null)
		{
			this.jIPSoInd=new ASNLocationRoutingNumberSourceIndicator();
			this.jIPSoInd.setType(jIPSoInd);
		}
		
		if(jIPQuryStatus!=null)
		{
			this.jIPQuryStatus=new ASNLocationRoutingNumberQueryStatus();
			this.jIPQuryStatus.setType(jIPQuryStatus);
		}
	}

	public RecordType getRecordType() 
	{
		if(recordType==null)
			return null;
		
		return recordType.getType();
	}

	public AddressStringImpl getRecordingEntity() 
	{
		return recordingEntity;
	}

	public TrunkGroup getMscIncomingTKGP() 
	{
		return mscIncomingTKGP;
	}

	public TrunkGroup getMscOutgoingTKGP() 
	{
		return mscOutgoingTKGP;
	}

	public SM_RP_SMEAImpl getCallingNumber() 
	{
		return callingNumber;
	}

	public SM_RP_SMEAImpl getCalledNumber() 
	{
		return calledNumber;
	}

	public BasicService getIsdnBasicService() 
	{
		if(isdnBasicService==null)
			return null;
		
		return isdnBasicService.getType();
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

	public CauseForRecClosing getCauseForTerm() 
	{
		if(causeForTerm==null)
			return null;
		
		return causeForTerm.getType();
	}

	public Diagnostics getDiagnostics() 
	{
		return diagnostics;
	}

	public CallReferenceNumberImpl getCallReferenceNumber() 
	{
		return callReferenceNumber;
	}

	public Integer getSequenceNumber() 
	{
		if(sequenceNumber==null || sequenceNumber.getValue()==null)
			return null;
		
		return sequenceNumber.getValue().intValue();
	}

	public byte[] getRecordExtensions() 
	{
		if(recordExtensions==null)
			return null;
		
		ByteBuf value=recordExtensions.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public RouteingNumberImpl getLocationRoutNum() 
	{
		return locationRoutNum;
	}

	public LocationRoutingNumberSourceIndicator getLocationRoutingNumberSourceIndicator() 
	{
		if(locationRoutingNumberSourceIndicator==null)
			return null;
		
		return locationRoutingNumberSourceIndicator.getType();
	}

	public LocationRoutingNumberQueryStatus getLocationRoutingNumberQueryStatus() 
	{
		if(locationRoutingNumberQueryStatus==null)
			return null;
		
		return locationRoutingNumberQueryStatus.getType();
	}

	public RouteingNumberImpl getjIPPara() 
	{
		if(jIPPara==null)
			return null;
		
		return jIPPara;
	}

	public LocationRoutingNumberSourceIndicator getjIPSoInd() 
	{
		if(jIPSoInd==null)
			return null;
		
		return jIPSoInd.getType();
	}

	public LocationRoutingNumberQueryStatus getjIPQuryStatus() 
	{
		if(jIPQuryStatus==null)
			return null;
		
		return jIPQuryStatus.getType();
	}
	
	@Override
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("TransitRecord");
        sb.append(" [");

        if(recordType!=null && recordType.getValue()!=null)
        {
	        sb.append("recordType=[");
	        sb.append(this.recordType.getType());
	        sb.append("]");
        }
        
        if(recordingEntity!=null)
        {
	        sb.append(", recordingEntity=[");
	        sb.append(this.recordingEntity);
	        sb.append("]");
        }
        
        if(mscIncomingTKGP!=null)
        {
	        sb.append(", mscIncomingTKGP=[");
	        sb.append(this.mscIncomingTKGP);
	        sb.append("]");
        }
        
        if(mscOutgoingTKGP!=null)
        {
	        sb.append(", mscOutgoingTKGP=[");
	        sb.append(this.mscOutgoingTKGP);
	        sb.append("]");
        }
        
        if(callingNumber!=null)
        {
	        sb.append(", callingNumber=[");
	        sb.append(this.callingNumber);
	        sb.append("]");
        }
        
        if(calledNumber!=null)
        {
	        sb.append(", calledNumber=[");
	        sb.append(this.calledNumber);
	        sb.append("]");
        }
        
        if(isdnBasicService!=null && isdnBasicService.getType()!=null)
        {
            sb.append(", isdnBasicService=[");
	        sb.append(this.isdnBasicService.getType());
	        sb.append("]");
        }
        
        if(seizureTime!=null)
        {
	        sb.append(", seizureTime=[");
	        sb.append(this.seizureTime);
	        sb.append("]");
        }
        
        if(answerTime!=null)
        {
	        sb.append(", answerTime=[");
	        sb.append(this.answerTime);
	        sb.append("]");
        }
        
        if(releaseTime!=null)
        {
	        sb.append(", releaseTime=[");
	        sb.append(this.releaseTime);
	        sb.append("]");
        }
        
        if(callDuration!=null && callDuration.getValue()!=null)
        {
	        sb.append(", callDuration=[");
	        sb.append(this.callDuration.getValue());
	        sb.append("]");
        }
        
        if(dataVolume!=null && dataVolume.getValue()!=null)
        {
	        sb.append(", dataVolume=[");
	        sb.append(this.dataVolume.getValue());
	        sb.append("]");
        }
        
        if(causeForTerm!=null && causeForTerm.getType()!=null)
        {
	        sb.append(", causeForTerm=[");
	        sb.append(this.causeForTerm.getType());
	        sb.append("]");
        }
        
        if(diagnostics!=null)
        {
	        sb.append(", diagnostics=[");
	        sb.append(this.diagnostics);
	        sb.append("]");
        }
        
        if(callReferenceNumber!=null)
        {
	        sb.append(", callReferenceNumber=[");
	        sb.append(this.callReferenceNumber);
	        sb.append("]");
        }
        
        if(sequenceNumber!=null && sequenceNumber.getValue()!=null)
        {
	        sb.append(", sequenceNumber=[");
	        sb.append(this.sequenceNumber.getValue());
	        sb.append("]");
        }
        
        if(recordExtensions!=null && recordExtensions.getValue()!=null)
        {
	        sb.append(", recordExtensions=[");
	        sb.append(ASNOctetString.printDataArr(getRecordExtensions()));
	        sb.append("]");
        }
        
        if(locationRoutNum!=null)
        {
	        sb.append(", locationRoutNum=[");
	        sb.append(this.locationRoutNum);
	        sb.append("]");
        }
        
        if(locationRoutingNumberSourceIndicator!=null && locationRoutingNumberSourceIndicator.getType()!=null)
        {
	        sb.append(", duration=[");
	        sb.append(this.locationRoutingNumberSourceIndicator.getType());
	        sb.append("]");
        }
        
        if(locationRoutingNumberQueryStatus!=null && locationRoutingNumberQueryStatus.getType()!=null)
        {
	        sb.append(", locationRoutingNumberQueryStatus=[");
	        sb.append(this.locationRoutingNumberQueryStatus.getType());
	        sb.append("]");
        }
        
        if(jIPPara!=null)
        {
	        sb.append(", jIPPara=[");
	        sb.append(this.jIPPara);
	        sb.append("]");
        }
        
        if(jIPSoInd!=null && jIPSoInd.getType()!=null)
        {
	        sb.append(", jIPSoInd=[");
	        sb.append(this.jIPSoInd.getType());
	        sb.append("]");
        }
        
        if(jIPQuryStatus!=null && jIPQuryStatus.getType()!=null)
        {
	        sb.append(", jIPQuryStatus=[");
	        sb.append(this.jIPQuryStatus.getType());
	        sb.append("]");
        }
        
        sb.append("]");
        return sb.toString();
    }
}