package com.mobius.software.cdr.parser.cs;
import org.restcomm.protocols.ss7.commonapp.callhandling.CallReferenceNumberImpl;
import org.restcomm.protocols.ss7.commonapp.primitives.AddressStringImpl;
import org.restcomm.protocols.ss7.commonapp.primitives.IMEIImpl;
import org.restcomm.protocols.ss7.commonapp.primitives.IMSIImpl;
import org.restcomm.protocols.ss7.commonapp.primitives.ISDNAddressStringImpl;

import com.mobius.software.cdr.parser.primitives.ASNBasicService;
import com.mobius.software.cdr.parser.primitives.ASNCauseForRecClosing;
import com.mobius.software.cdr.parser.primitives.ASNPartialRecordType;
import com.mobius.software.cdr.parser.primitives.ASNRecordType;
import com.mobius.software.cdr.parser.primitives.BCDDirectoryNumber;
import com.mobius.software.cdr.parser.primitives.BasicService;
import com.mobius.software.cdr.parser.primitives.CauseForRecClosing;
import com.mobius.software.cdr.parser.primitives.Diagnostics;
import com.mobius.software.cdr.parser.primitives.PartialRecordType;
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
--
-- MTRF RECORD
--
MTRFRecord ::= SET
{
 recordType [0] RecordType,
 servedIMSI [1] IMSI,
 servedIMEI [2] IMEI OPTIONAL,
 servedMSISDN [3] CalledNumber OPTIONAL,
 callingNumber [4] CallingNumber OPTIONAL,
 roamingNumber [5] RoamingNumber OPTIONAL,
 recordingEntity [6] RecordingEntity,
 mscIncomingTKGP [7] TrunkGroup OPTIONAL,
 mscOutgoingTKGP [8] TrunkGroup OPTIONAL,
 basicService [9] BasicServiceCode OPTIONAL,
 seizureTime [10] TimeStamp OPTIONAL,
 answerTime [11] TimeStamp OPTIONAL,
 releaseTime [12] TimeStamp OPTIONAL,
 callDuration [13] CallDuration,
 causeForTerm [14] CauseForTerm,
 diagnostics [15] Diagnostics OPTIONAL,
 callReference [16] CallReferenceNumber,
 sequenceNumber [17] INTEGER OPTIONAL,
 recordExtensions [18] ManagementExtensions OPTIONAL,
 partialRecordType [19] PartialRecordType OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 21,constructed = true,lengthIndefinite = false)
public class MMTRFRecord 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNRecordType recordType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private IMSIImpl servedIMSI;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private IMEIImpl servedIMEI;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ISDNAddressStringImpl servedMSISDN;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private BCDDirectoryNumber callingNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private BCDDirectoryNumber roamingNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private AddressStringImpl recordingEntity;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = true,index = -1)
	private TrunkGroup mscIncomingTKGP;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = true,index = -1)
	private TrunkGroup mscOutgoingTKGP;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = false,index = -1)
	private ASNBasicService isdnBasicService;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 10,constructed = false,index = -1)
	private TimeStamp seizureTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 11,constructed = false,index = -1)
	private TimeStamp answerTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 12,constructed = false,index = -1)
	private TimeStamp releaseTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 13,constructed = false,index = -1)
	private ASNInteger callDuration;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 14,constructed = false,index = -1)
	private ASNCauseForRecClosing causeForTerm;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 15,constructed = true,index = -1)
	private Diagnostics diagnostics;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 16,constructed = false,index = -1)
	private CallReferenceNumberImpl callReferenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 17,constructed = false,index = -1)
	private ASNInteger sequenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 18,constructed = true,index = -1)
	private ASNOctetString recordExtensions;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 19,constructed = false,index = -1)
	private ASNPartialRecordType partialRecordType;
	
	public MMTRFRecord() 
	{		
	}
	
	public MMTRFRecord(RecordType recordType,IMSIImpl servedIMSI,IMEIImpl servedIMEI,ISDNAddressStringImpl servedMSISDN,BCDDirectoryNumber callingNumber,BCDDirectoryNumber roamingNumber,AddressStringImpl recordingEntity,TrunkGroup mscIncomingTKGP,TrunkGroup mscOutgoingTKGP,BasicService isdnBasicService,TimeStamp seizureTime,TimeStamp answerTime,TimeStamp releaseTime, Integer callDuration,CauseForRecClosing causeForTerm,Diagnostics diagnostics,CallReferenceNumberImpl callReferenceNumber,Integer sequenceNumber,byte[] recordExtensions,PartialRecordType partialRecordType)
	{
		if(recordType!=null)
		{
			this.recordType=new ASNRecordType(); 
			this.recordType.setType(recordType);
		}
		
		this.servedIMSI=servedIMSI;
		this.servedIMEI=servedIMEI;
		this.servedMSISDN=servedMSISDN;		
		this.callingNumber=callingNumber;
		this.roamingNumber=roamingNumber;
		this.recordingEntity=recordingEntity;
		this.mscIncomingTKGP=mscIncomingTKGP;
		this.mscOutgoingTKGP=mscOutgoingTKGP;
		
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
		
		if(partialRecordType!=null)
		{
			this.partialRecordType=new ASNPartialRecordType();
			this.partialRecordType.setType(partialRecordType);
		}
	}

	public RecordType getRecordType() 
	{
		if(recordType==null)
			return null;
		
		return recordType.getType();
	}

	public IMSIImpl getServedIMSI() 
	{
		return servedIMSI;
	}

	public IMEIImpl getServedIMEI() 
	{
		return servedIMEI;
	}

	public ISDNAddressStringImpl getServedMSISDN() 
	{
		return servedMSISDN;
	}

	public BCDDirectoryNumber getCallingNumber() 
	{
		return callingNumber;
	}

	public BCDDirectoryNumber getRoamingNumber() 
	{
		return roamingNumber;
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

	public PartialRecordType getPartialRecordType() 
	{
		if(partialRecordType==null)
			return null;
		
		return partialRecordType.getType();
	}
	
	@Override
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("RoamingRecord");
        sb.append(" [");

        if(recordType!=null && recordType.getValue()!=null)
        {
	        sb.append("recordType=[");
	        sb.append(this.recordType.getType());
	        sb.append("]");
        }
        
        if(servedIMSI!=null)
        {
 	        sb.append(", servedIMSI=[");
 	        sb.append(this.servedIMSI);
 	        sb.append("]");
        }
        
        if(servedIMEI!=null)
        {
 	        sb.append(", servedIMEI=[");
 	        sb.append(this.servedIMEI);
 	        sb.append("]");
        }
        
        if(servedMSISDN!=null)
        {
 	        sb.append(", servedMSISDN=[");
 	        sb.append(this.servedMSISDN);
 	        sb.append("]");
        }
        
        if(callingNumber!=null)
        {
	        sb.append(", callingNumber=[");
	        sb.append(this.callingNumber);
	        sb.append("]");
        }
        
        if(roamingNumber!=null)
        {
	        sb.append(", roamingNumber=[");
	        sb.append(this.roamingNumber);
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
        
        if(partialRecordType!=null && partialRecordType.getType()!=null)
        {
	        sb.append(", partialRecordType=[");
	        sb.append(this.partialRecordType.getType());
	        sb.append("]");
        }
        
        sb.append("]");
        return sb.toString();
    }
}