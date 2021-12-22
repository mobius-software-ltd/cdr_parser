package com.mobius.software.cdr.parser.cs;
import java.util.List;

import org.restcomm.protocols.ss7.commonapp.callhandling.CallReferenceNumberImpl;
import org.restcomm.protocols.ss7.commonapp.circuitSwitchedCall.DestinationRoutingAddressImpl;
import org.restcomm.protocols.ss7.commonapp.primitives.AddressStringImpl;
import org.restcomm.protocols.ss7.commonapp.primitives.IMSIImpl;
import org.restcomm.protocols.ss7.commonapp.primitives.ISDNAddressStringImpl;
import org.restcomm.protocols.ss7.map.api.service.mobility.subscriberManagement.DefaultCallHandling;
import org.restcomm.protocols.ss7.map.service.mobility.subscriberInformation.RouteingNumberImpl;
import org.restcomm.protocols.ss7.map.service.mobility.subscriberManagement.ASNDefaultCallHandling;

import com.mobius.software.cdr.parser.primitives.ASNCauseForRecClosing;
import com.mobius.software.cdr.parser.primitives.ASNLocationRoutingNumberQueryStatus;
import com.mobius.software.cdr.parser.primitives.ASNLocationRoutingNumberSourceIndicator;
import com.mobius.software.cdr.parser.primitives.ASNPartialRecordType;
import com.mobius.software.cdr.parser.primitives.ASNRecordType;
import com.mobius.software.cdr.parser.primitives.BCDDirectoryNumber;
import com.mobius.software.cdr.parser.primitives.CAMELInformation;
import com.mobius.software.cdr.parser.primitives.CamelInformationListWrapper;
import com.mobius.software.cdr.parser.primitives.CauseForRecClosing;
import com.mobius.software.cdr.parser.primitives.Diagnostics;
import com.mobius.software.cdr.parser.primitives.LevelOfCAMELService;
import com.mobius.software.cdr.parser.primitives.LocationRoutingNumberQueryStatus;
import com.mobius.software.cdr.parser.primitives.LocationRoutingNumberSourceIndicator;
import com.mobius.software.cdr.parser.primitives.PartialRecordType;
import com.mobius.software.cdr.parser.primitives.RecordType;
import com.mobius.software.cdr.parser.primitives.TimeStamp;
import com.mobius.software.cdr.parser.primitives.TrunkGroup;
import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNBoolean;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/*
TermCAMELRecord ::= SET
{
 recordtype [0] RecordType,
 servedIMSI [1] IMSI,
 servedMSISDN [2] MSISDN OPTIONAL,
 recordingEntity [3] RecordingEntity,
 interrogationTime [4] TimeStamp,
 destinationRoutingAddress [5] DestinationRoutingAddress,
 gsm-SCFAddress [6] Gsm-SCFAddress,
 serviceKey [7] ServiceKey,
 networkCallReference [8] NetworkCallReference OPTIONAL,
 mSCAddress [9] MSCAddress OPTIONAL,
 defaultCallHandling [10] DefaultCallHandling OPTIONAL,
 recordExtensions [11] ManagementExtensions OPTIONAL,
 calledNumber [12] CalledNumber,
 callingNumber [13] CallingNumber OPTIONAL,
 mscIncomingTKGP [14] TrunkGroup OPTIONAL,
 mscOutgoingTKGP [15] TrunkGroup OPTIONAL,
 seizureTime [16] TimeStamp OPTIONAL,
 answerTime [17] TimeStamp OPTIONAL,
 releaseTime [18] TimeStamp OPTIONAL,
 callDuration [19] CallDuration,
 dataVolume [20] DataVolume OPTIONAL,
 causeForTerm [21] CauseForTerm,
 diagnostics [22] Diagnostics OPTIONAL,
 callReference [23] CallReferenceNumber,
 sequenceNumber [24] INTEGER OPTIONAL,
 numberOfDPEncountered [25] INTEGER OPTIONAL,
 levelOfCAMELService [26] LevelOfCAMELService OPTIONAL,
 freeFormatData [27] FreeFormatData OPTIONAL,
 cAMELCallLegInformation [28] SEQUENCE OF CAMELInformation OPTIONAL,
 freeFormatDataAppend [29] BOOLEAN OPTIONAL,
 defaultCallHandling-2 [30] DefaultCallHandling OPTIONAL,
 gsm-SCFAddress-2 [31] Gsm-SCFAddress OPTIONAL,
 serviceKey-2 [32] ServiceKey OPTIONAL,
 freeFormatData-2 [33] FreeFormatData OPTIONAL,
 freeFormatDataAppend-2 [34] BOOLEAN OPTIONAL,
 mscServerIndication [35] BOOLEAN OPTIONAL,
 locationRoutNum [36] LocationRoutingNumber OPTIONAL,
 lrnSoInd [37] LocationRoutingNumberSourceIndicator OPTIONAL,
 lrnQuryStatus [38] LocationRoutingNumberQueryStatus OPTIONAL,
 jIPPara [39] JurisdictionInformationParameter OPTIONAL,
 jIPSoInd [40] JurisdictionInformationParameterSourceIndicator OPTIONAL,
 jIPQuryStatus [41] JurisdictionInformationParameterQueryStatus OPTIONAL,
 partialRecordType [42] PartialRecordType OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 16,constructed = true,lengthIndefinite = false)
public class TermCamelRecord 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNRecordType recordType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private IMSIImpl servedIMSI;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ISDNAddressStringImpl servedMSISDN;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private AddressStringImpl recordingEntity;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private TimeStamp interrogationTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = true,index = -1)
	private DestinationRoutingAddressImpl destinationRoutingAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private ISDNAddressStringImpl gsmSCFAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private ASNInteger serviceKey;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private CallReferenceNumberImpl networkCallReference;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = false,index = -1)
	private AddressStringImpl mscAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 10,constructed = false,index = -1)
	private ASNDefaultCallHandling defaultCallHandling;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 11,constructed = true,index = -1)
	private ASNOctetString recordExtensions;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 12,constructed = false,index = -1)
	private BCDDirectoryNumber calledNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 13,constructed = false,index = -1)
	private BCDDirectoryNumber callingNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 14,constructed = true,index = -1)
	private TrunkGroup mscIncomingTKGP;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 15,constructed = true,index = -1)
	private TrunkGroup mscOutgoingTKGP;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 16,constructed = false,index = -1)
	private TimeStamp seizureTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 17,constructed = false,index = -1)
	private TimeStamp answerTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 18,constructed = false,index = -1)
	private TimeStamp releaseTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 19,constructed = false,index = -1)
	private ASNInteger callDuration;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 20,constructed = false,index = -1)
	private ASNInteger dataVolume;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 21,constructed = false,index = -1)
	private ASNCauseForRecClosing causeForTerm;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 22,constructed = true,index = -1)
	private Diagnostics diagnostics;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 23,constructed = false,index = -1)
	private CallReferenceNumberImpl callReferenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 24,constructed = false,index = -1)
	private ASNInteger sequenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 25,constructed = false,index = -1)
	private ASNInteger numberOfDPEncountered;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 26,constructed = false,index = -1)
	private LevelOfCAMELService levelOfCAMELService;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 27,constructed = false,index = -1)
	private ASNOctetString freeFormatData;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 28,constructed = true,index = -1)
	private CamelInformationListWrapper camelCallLegInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 29,constructed = false,index = -1)
	private ASNBoolean freeFormatDataAppend;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 30,constructed = false,index = -1)
	private ASNDefaultCallHandling defaultCallHandling2;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 31,constructed = false,index = -1)
	private ISDNAddressStringImpl gsmSCFAddress2;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 32,constructed = false,index = -1)
	private ASNInteger serviceKey2;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 33,constructed = false,index = -1)
	private ASNOctetString freeFormatData2;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 34,constructed = false,index = -1)
	private ASNBoolean freeFormatDataAppend2;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 35,constructed = false,index = -1)
	private ASNBoolean mscServerIndication;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 36,constructed = false,index = -1)
	private RouteingNumberImpl locationRoutNum;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 37,constructed = false,index = -1)
	private ASNLocationRoutingNumberSourceIndicator locationRoutingNumberSourceIndicator;	
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 38,constructed = false,index = -1)
	private ASNLocationRoutingNumberQueryStatus locationRoutingNumberQueryStatus;	
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 39,constructed = false,index = -1)
	private RouteingNumberImpl jIPPara;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 40,constructed = false,index = -1)
	private ASNLocationRoutingNumberSourceIndicator jIPSoInd;	
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 41,constructed = false,index = -1)
	private ASNLocationRoutingNumberQueryStatus jIPQuryStatus;	
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 42,constructed = false,index = -1)
	private ASNPartialRecordType partialRecordType;			
	
	public TermCamelRecord() 
	{		
	}
	
	public TermCamelRecord(RecordType recordType,IMSIImpl servedIMSI,ISDNAddressStringImpl servedMSISDN,AddressStringImpl recordingEntity,TimeStamp interrogationTime,DestinationRoutingAddressImpl destinationRoutingAddress,ISDNAddressStringImpl gsmSCFAddress,Long serviceKey,CallReferenceNumberImpl networkCallReference,AddressStringImpl mscAddress,DefaultCallHandling defaultCallHandling,byte[] recordExtensions,BCDDirectoryNumber calledNumber,BCDDirectoryNumber callingNumber,TrunkGroup mscIncomingTKGP,TrunkGroup mscOutgoingTKGP,TimeStamp seizureTime,TimeStamp answerTime,TimeStamp releaseTime, Integer callDuration,Integer dataVolume,CauseForRecClosing causeForTerm,Diagnostics diagnostics,CallReferenceNumberImpl callReferenceNumber,Integer sequenceNumber,Integer numberOfDPEncountered,LevelOfCAMELService levelOfCAMELService,byte[] freeFormatData,List<CAMELInformation> camelCallLegInformation, Boolean freeFormatDataAppend,DefaultCallHandling defaultCallHandling2,ISDNAddressStringImpl gsmSCFAddress2,Long serviceKey2,byte[] freeFormatData2,Boolean freeFormatDataAppend2,Boolean mscServerIndication, RouteingNumberImpl locationRoutNum,LocationRoutingNumberSourceIndicator locationRoutingNumberSourceIndicator,LocationRoutingNumberQueryStatus locationRoutingNumberQueryStatus,RouteingNumberImpl jIPPara,LocationRoutingNumberSourceIndicator jIPSoInd,LocationRoutingNumberQueryStatus jIPQuryStatus,PartialRecordType partialRecordType)
	{
		if(recordType!=null)
		{
			this.recordType=new ASNRecordType(); 
			this.recordType.setType(recordType);
		}
		
		this.servedIMSI=servedIMSI;
		this.servedMSISDN=servedMSISDN;		
		this.recordingEntity=recordingEntity;
		this.interrogationTime=interrogationTime;
		this.destinationRoutingAddress=destinationRoutingAddress;
		this.gsmSCFAddress=gsmSCFAddress;
		
		if(serviceKey!=null)
		{
			this.serviceKey=new ASNInteger();
			this.serviceKey.setValue(serviceKey);
		}
		
		this.networkCallReference=networkCallReference;
		this.mscAddress=mscAddress;
		
		if(defaultCallHandling!=null)
		{
			this.defaultCallHandling=new ASNDefaultCallHandling();
			this.defaultCallHandling.setType(defaultCallHandling);
		}
		
		if(recordExtensions!=null)
		{
			this.recordExtensions=new ASNOctetString();
			this.recordExtensions.setValue(Unpooled.wrappedBuffer(recordExtensions));
		}
		
		this.calledNumber=calledNumber;
		this.callingNumber=callingNumber;
		this.mscIncomingTKGP=mscIncomingTKGP;
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
		
		if(numberOfDPEncountered!=null)
		{
			this.numberOfDPEncountered=new ASNInteger();
			this.numberOfDPEncountered.setValue(numberOfDPEncountered.longValue());
		}
		
		this.levelOfCAMELService=levelOfCAMELService;
		
		if(freeFormatData!=null)
		{
			this.freeFormatData=new ASNOctetString();
			this.freeFormatData.setValue(Unpooled.wrappedBuffer(freeFormatData));
		}
		
		if(camelCallLegInformation!=null)
			this.camelCallLegInformation=new CamelInformationListWrapper(camelCallLegInformation);
		
		if(freeFormatDataAppend!=null)
		{
			this.freeFormatDataAppend=new ASNBoolean();
			this.freeFormatDataAppend.setValue(freeFormatDataAppend);
		}
		
		if(defaultCallHandling2!=null)
		{
			this.defaultCallHandling2=new ASNDefaultCallHandling();
			this.defaultCallHandling2.setType(defaultCallHandling2);
		}
		
		this.gsmSCFAddress2=gsmSCFAddress2;
		if(serviceKey2!=null)
		{
			this.serviceKey2=new ASNInteger();
			this.serviceKey2.setValue(serviceKey2);
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
		
		if(mscServerIndication!=null)
		{
			this.mscServerIndication=new ASNBoolean();
			this.mscServerIndication.setValue(mscServerIndication);
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

	public ISDNAddressStringImpl getServedMSISDN() 
	{
		return servedMSISDN;
	}

	public AddressStringImpl getRecordingEntity() 
	{
		return recordingEntity;
	}

	public TimeStamp getInterrogationTime() 
	{
		return interrogationTime;
	}

	public DestinationRoutingAddressImpl getDestinationRoutingAddress() 
	{
		return destinationRoutingAddress;
	}

	public ISDNAddressStringImpl getGsmSCFAddress() 
	{
		return gsmSCFAddress;
	}

	public Long getServiceKey() 
	{
		if(serviceKey==null)
			return null;
		
		return serviceKey.getValue();
	}

	public CallReferenceNumberImpl getNetworkCallReference() 
	{
		return networkCallReference;
	}

	public AddressStringImpl getMSCAddress() 
	{
		return mscAddress;
	}

	public DefaultCallHandling getDefaultCallHandling() 
	{
		if(defaultCallHandling==null)
			return null;
		
		return defaultCallHandling.getType();
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

	public BCDDirectoryNumber getCalledNumber() 
	{
		return calledNumber;
	}

	public BCDDirectoryNumber getCallingNumber() 
	{
		return callingNumber;
	}

	public TrunkGroup getMscIncomingTKGP() 
	{
		return mscIncomingTKGP;
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

	public Integer getNumberOfDPEncountered() 
	{
		if(numberOfDPEncountered==null || numberOfDPEncountered.getValue()==null)
			return null;
		
		return numberOfDPEncountered.getValue().intValue();
	}

	public LevelOfCAMELService getLevelOfCAMELService() 
	{
		return levelOfCAMELService;
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

	public List<CAMELInformation> getCamelCallLegInformation()
	{
		if(this.camelCallLegInformation==null)
			return null;
		
		return camelCallLegInformation.getCAMELInformation();
	}
	
	public Boolean getFreeFormatDataAppend() 
	{
		if(freeFormatDataAppend==null)
			return null;
		
		return freeFormatDataAppend.getValue();
	}

	public DefaultCallHandling getDefaultCallHandling2() 
	{
		if(defaultCallHandling2==null)
			return null;
		
		return defaultCallHandling2.getType();
	}

	public ISDNAddressStringImpl getGsmSCFAddress2() 
	{
		return gsmSCFAddress2;
	}

	public Long getServiceKey2() 
	{
		if(serviceKey2==null)
			return null;
		
		return serviceKey2.getValue();
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

	public Boolean getMscServerIndication() 
	{
		if(mscServerIndication==null)
			return null;
		
		return mscServerIndication.getValue();
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
        
        if(servedMSISDN!=null)
        {
 	        sb.append(", servedMSISDN=[");
 	        sb.append(this.servedMSISDN);
 	        sb.append("]");
        }
        
        if(recordingEntity!=null)
        {
	        sb.append(", recordingEntity=[");
	        sb.append(this.recordingEntity);
	        sb.append("]");
        }
        
        if(interrogationTime!=null)
        {
	        sb.append(", interrogationTime=[");
	        sb.append(this.interrogationTime);
	        sb.append("]");
        }
        
        if(destinationRoutingAddress!=null)
        {
	        sb.append(", destinationRoutingAddress=[");
	        sb.append(this.destinationRoutingAddress);
	        sb.append("]");
        }
        
        if(gsmSCFAddress!=null)
        {
	        sb.append(", gsmSCFAddress=[");
	        sb.append(this.gsmSCFAddress);
	        sb.append("]");
        }
        
        if(serviceKey!=null && serviceKey.getValue()!=null)
        {
	        sb.append(", serviceKey=[");
	        sb.append(this.serviceKey.getValue());
	        sb.append("]");
        }
        
        if(networkCallReference!=null)
        {
	        sb.append(", networkCallReference=[");
	        sb.append(this.networkCallReference);
	        sb.append("]");
        }
        
        if(mscAddress!=null)
        {
	        sb.append(", mscAddress=[");
	        sb.append(this.mscAddress);
	        sb.append("]");
        }
        
        if(defaultCallHandling!=null && defaultCallHandling.getValue()!=null)
        {
	        sb.append(", defaultCallHandling=[");
	        sb.append(this.defaultCallHandling.getType());
	        sb.append("]");
        }
        
        if(recordExtensions!=null && recordExtensions.getValue()!=null)
        {
	        sb.append(", recordExtensions=[");
	        sb.append(ASNOctetString.printDataArr(getRecordExtensions()));
	        sb.append("]");
        }
        
        if(calledNumber!=null)
        {
	        sb.append(", calledNumber=[");
	        sb.append(this.calledNumber);
	        sb.append("]");
        }
        
        if(callingNumber!=null)
        {
	        sb.append(", callingNumber=[");
	        sb.append(this.callingNumber);
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
        
        if(numberOfDPEncountered!=null && numberOfDPEncountered.getValue()!=null)
        {
	        sb.append(", numberOfDPEncountered=[");
	        sb.append(this.numberOfDPEncountered.getValue());
	        sb.append("]");
        }
        
        if(levelOfCAMELService!=null)
        {
	        sb.append(", levelOfCAMELService=[");
	        sb.append(this.levelOfCAMELService);
	        sb.append("]");
        }
        
        if(freeFormatData!=null && freeFormatData.getValue()!=null)
        {
	        sb.append(", freeFormatData=[");
	        sb.append(this.getFreeFormatData());
	        sb.append("]");
        }
        
        if(camelCallLegInformation!=null && camelCallLegInformation.getCAMELInformation()!=null)
        {
        	sb.append(", camelCallLegInformation=[");
	        int index=0;
	        for(CAMELInformation curr:camelCallLegInformation.getCAMELInformation())
	        {
	        	if(index!=0)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        	index++;
	        }
	        
	        sb.append("]");
        }
        
        if(freeFormatDataAppend!=null && freeFormatDataAppend.getValue()!=null)
        {
	        sb.append(", freeFormatDataAppend=[");
	        sb.append(this.freeFormatDataAppend.getValue());
	        sb.append("]");
        }
        
        if(defaultCallHandling2!=null && defaultCallHandling2.getValue()!=null)
        {
	        sb.append(", defaultCallHandling2=[");
	        sb.append(this.defaultCallHandling2.getType());
	        sb.append("]");
        }
        
        if(gsmSCFAddress2!=null)
        {
	        sb.append(", gsmSCFAddress2=[");
	        sb.append(this.gsmSCFAddress2);
	        sb.append("]");
        }
        
        if(serviceKey2!=null && serviceKey2.getValue()!=null)
        {
	        sb.append(", serviceKey2=[");
	        sb.append(this.serviceKey2.getValue());
	        sb.append("]");
        }
        
        if(freeFormatData2!=null && freeFormatData2.getValue()!=null)
        {
	        sb.append(", freeFormatData2=[");
	        sb.append(this.getFreeFormatData2());
	        sb.append("]");
        }
        
        if(freeFormatDataAppend2!=null && freeFormatDataAppend2.getValue()!=null)
        {
	        sb.append(", freeFormatDataAppend2=[");
	        sb.append(this.freeFormatDataAppend2.getValue());
	        sb.append("]");
        }
        
        if(mscServerIndication!=null && mscServerIndication.getValue()!=null)
        {
	        sb.append(", mscServerIndication=[");
	        sb.append(this.mscServerIndication.getValue());
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