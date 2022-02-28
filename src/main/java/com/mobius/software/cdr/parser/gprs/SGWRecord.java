package com.mobius.software.cdr.parser.gprs;
import java.util.ArrayList;
import java.util.List;

import org.restcomm.protocols.ss7.commonapp.primitives.IMEIImpl;
import org.restcomm.protocols.ss7.commonapp.primitives.IMSIImpl;
import org.restcomm.protocols.ss7.commonapp.primitives.ISDNAddressStringImpl;
import org.restcomm.protocols.ss7.commonapp.subscriberInformation.UserCSGInformationImpl;
import org.restcomm.protocols.ss7.map.primitives.PlmnIdImpl;
import org.restcomm.protocols.ss7.map.service.mobility.subscriberManagement.ChargingCharacteristicsImpl;
import org.restcomm.protocols.ss7.map.service.mobility.subscriberManagement.PDPTypeImpl;

import com.mobius.software.cdr.parser.primitives.APNSelectionMode;
import com.mobius.software.cdr.parser.primitives.ASNAPNSelectionMode;
import com.mobius.software.cdr.parser.primitives.ASNCauseForRecClosing;
import com.mobius.software.cdr.parser.primitives.ASNChChSelectionMode;
import com.mobius.software.cdr.parser.primitives.ASNRatType;
import com.mobius.software.cdr.parser.primitives.ASNRecordType;
import com.mobius.software.cdr.parser.primitives.ASNServingNodeType;
import com.mobius.software.cdr.parser.primitives.CauseForRecClosing;
import com.mobius.software.cdr.parser.primitives.ChChSelectionMode;
import com.mobius.software.cdr.parser.primitives.ChangeOfCharCondition;
import com.mobius.software.cdr.parser.primitives.ChangeOfCharConditionListWrapper;
import com.mobius.software.cdr.parser.primitives.Diagnostics;
import com.mobius.software.cdr.parser.primitives.IPAddress;
import com.mobius.software.cdr.parser.primitives.IPAddressWrapper;
import com.mobius.software.cdr.parser.primitives.MSTimezone;
import com.mobius.software.cdr.parser.primitives.PDPAddress;
import com.mobius.software.cdr.parser.primitives.PDPAddressWrapper;
import com.mobius.software.cdr.parser.primitives.RATType;
import com.mobius.software.cdr.parser.primitives.RecordType;
import com.mobius.software.cdr.parser.primitives.ServingNodeType;
import com.mobius.software.cdr.parser.primitives.ServingNodeTypeListWrapper;
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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNBoolean;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNIA5String;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNNull;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/*
SGWRecord ::= SET
recordType [0] RecordType,
servedIMSI [3] IMSI OPTIONAL,
s-GWAddress [4] GSNAddress,
chargingID [5] ChargingID,
servingNodeAddress [6] SEQUENCE OF GSNAddress,
accessPointNameNI [7] AccessPointNameNI OPTIONAL,
pdpPDNType [8] PDPType OPTIONAL,
servedPDPPDNAddress [9] PDPAddress OPTIONAL,
dynamicAddressFlag [11] DynamicAddressFlag OPTIONAL,
listOfTrafficVolumes [12] SEQUENCE OF ChangeOfCharCondition OPTIONAL,
recordOpeningTime [13] TimeStamp,
duration [14] CallDuration,
causeForRecClosing [15] CauseForRecClosing,
diagnostics [16] Diagnostics OPTIONAL,
recordSequenceNumber [17] INTEGER OPTIONAL,
nodeID [18] NodeID OPTIONAL,
recordExtensions [19] ManagementExtensions OPTIONAL,
localSequenceNumber [20] LocalSequenceNumber OPTIONAL,
apnSelectionMode [21] APNSelectionMode OPTIONAL,
servedMSISDN [22] MSISDN OPTIONAL,
chargingCharacteristics [23] ChargingCharacteristics,
chChSelectionMode [24] ChChSelectionMode OPTIONAL,
iMSsignalingContext [25] NULL OPTIONAL,
servingNodePLMNIdentifier [27] PLMN-Id OPTIONAL,
servedIMEISV [29] IMEI OPTIONAL,
rATType [30] RATType OPTIONAL,
mSTimeZone [31] MSTimeZone OPTIONAL,
userLocationInformation [32] OCTET STRING OPTIONAL,
sGWChange [34] SGWChange OPTIONAL,
servingNodeType [35] SEQUENCE OF ServingNodeType,
p-GWAddressUsed [36] GSNAddress OPTIONAL,
p-GWPLMNIdentifier [37] PLMN-Id OPTIONAL,
startTime [38] TimeStamp OPTIONAL,
stopTime [39] TimeStamp OPTIONAL,
pDNConnectionChargingID [40] ChargingID OPTIONAL,
iMSIunauthenticatedFlag [41] NULL OPTIONAL,
userCSGInformation [42] UserCSGInformation OPTIONAL,
servedPDPPDNAddressExt [43] PDPAddress OPTIONAL,
lowPriorityIndicator [44] NULL OPTIONAL,
dynamicAddressFlagExt [47] DynamicAddressFlag OPTIONAL
}
/**
* @author yulian.oifa
*
*/
@ASNTag(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 79,constructed = true,lengthIndefinite = false)
public class SGWRecord 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNRecordType recordType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private IMSIImpl servedIMSI;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = true,index = -1)
	private IPAddressWrapper sgwAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private ASNInteger chargingID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = true,index = -1)
	private List<IPAddressWrapper> servingNodeAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private ASNIA5String accessPointNameNI;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private PDPTypeImpl pdpPDNType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = true,index = -1)
	private PDPAddressWrapper servedPDPPDNAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 11,constructed = false,index = -1)
	private ASNBoolean dynamicAddressFlag;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 12,constructed = true,index = -1)
	private ChangeOfCharConditionListWrapper listOfTrafficVolumes;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 13,constructed = false,index = -1)
	private TimeStamp recordOpeningTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 14,constructed = false,index = -1)
	private ASNInteger duration;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 15,constructed = false,index = -1)
	private ASNCauseForRecClosing causeForRecClosing;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 16,constructed = true,index = -1)
	private Diagnostics diagnostics;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 17,constructed = false,index = -1)
	private ASNInteger recordSequenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 18,constructed = false,index = -1)
	private ASNIA5String nodeID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 19,constructed = true,index = -1)
	private ASNOctetString recordExtensions;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 20,constructed = false,index = -1)
	private ASNInteger localSequenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 21,constructed = false,index = -1)
	private ASNAPNSelectionMode apnSelectionMode;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 22,constructed = false,index = -1)
	private ISDNAddressStringImpl servedMSISDN;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 23,constructed = false,index = -1)
	private ChargingCharacteristicsImpl chargingCharacteristics;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 24,constructed = false,index = -1)
	private ASNChChSelectionMode chChSelectionMode;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 25,constructed = false,index = -1)
	private ASNNull iMSsignalingContext;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 27,constructed = false,index = -1)
	private PlmnIdImpl plmnID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 29,constructed = false,index = -1)
	private IMEIImpl servedIMEISV;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 30,constructed = false,index = -1)
	private ASNRatType ratType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 31,constructed = false,index = -1)
	private MSTimezone mSTimeZone;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 32,constructed = false,index = -1)
	private ASNOctetString userLocationInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 34,constructed = false,index = -1)
	private ASNBoolean sGWChange;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 35,constructed = true,index = -1)
	private ServingNodeTypeListWrapper servingNodeType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 36,constructed = true,index = -1)
	private IPAddressWrapper pGWAddressUsed;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 37,constructed = false,index = -1)
	private PlmnIdImpl pGWPLMNIdentifier;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 38,constructed = false,index = -1)
	private TimeStamp startTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 39,constructed = false,index = -1)
	private TimeStamp stopTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 40,constructed = false,index = -1)
	private ASNInteger pDNConnectionChargingID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 41,constructed = false,index = -1)
	private ASNNull iMSIunauthenticatedFlag;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 42,constructed = true,index = -1)
	private UserCSGInformationImpl userCSGInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 43,constructed = false,index = -1)
	private PDPAddressWrapper servedPDPPDNAddressExt;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 44,constructed = false,index = -1)
	private ASNNull lowPriorityIndicator;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 47,constructed = false,index = -1)
	private ASNBoolean dynamicAddressFlagExt;
	
	public SGWRecord()
	{
	}
	
	public SGWRecord(RecordType recordType,IMSIImpl servedIMSI,IPAddress sgwAddress,Integer chargingID,
	List<IPAddress> servingNodeAddress,String accessPointNameNI,PDPTypeImpl pdpPDNType,PDPAddress servedPDPPDNAddress,
	Boolean dynamicAddressFlag,List<ChangeOfCharCondition> listOfTrafficVolumes,TimeStamp recordOpeningTime,
	Integer duration,CauseForRecClosing causeForRecClosing,Diagnostics diagnostics,Integer recordSequenceNumber,
	String nodeID,byte[] recordExtensions,Integer localSequenceNumber,APNSelectionMode apnSelectionMode,
	ISDNAddressStringImpl servedMSISDN,ChargingCharacteristicsImpl chargingCharacteristics,ChChSelectionMode chChSelectionMode,
	boolean iMSsignalingContext,PlmnIdImpl plmnID,IMEIImpl servedIMEISV,RATType ratType,MSTimezone mSTimeZone,byte[] userLocationInformation,
	Boolean sGWChange,List<ServingNodeType> servingNodeType,IPAddress pGWAddressUsed,PlmnIdImpl pGWPLMNIdentifier,
	TimeStamp startTime,TimeStamp stopTime,Integer pDNConnectionChargingID,
	boolean iMSIunauthenticatedFlag,UserCSGInformationImpl userCSGInformation,
	PDPAddress servedPDPPDNAddressExt,boolean lowPriorityIndicator,Boolean dynamicAddressFlagExt)
	{
		if(recordType!=null)
			this.recordType=new ASNRecordType(recordType);
		
		this.servedIMSI=servedIMSI;
		
		if(sgwAddress!=null)
			this.sgwAddress=new IPAddressWrapper(sgwAddress);
		
		if(chargingID!=null)
			this.chargingID=new ASNInteger(chargingID.longValue(),null,null,null,false);
		
		if(servingNodeAddress!=null)
		{
			this.servingNodeAddress=new ArrayList<IPAddressWrapper>();
			for(IPAddress curr:servingNodeAddress)
				this.servingNodeAddress.add(new IPAddressWrapper(curr));
		}
		
		if(accessPointNameNI!=null)
			this.accessPointNameNI=new ASNIA5String(accessPointNameNI,null,null,null,false);
		
		this.pdpPDNType=pdpPDNType;
		
		if(servedPDPPDNAddress!=null)
			this.servedPDPPDNAddress=new PDPAddressWrapper(servedPDPPDNAddress);
		
		if(dynamicAddressFlag!=null)
			this.dynamicAddressFlag=new ASNBoolean(dynamicAddressFlag,null,false,false);
		
		if(listOfTrafficVolumes!=null)
			this.listOfTrafficVolumes=new ChangeOfCharConditionListWrapper(listOfTrafficVolumes);
		
		this.recordOpeningTime=recordOpeningTime;
		
		if(this.duration!=null)
			this.duration=new ASNInteger(duration.longValue(),null,null,null,false);
		
		if(causeForRecClosing!=null)
			this.causeForRecClosing=new ASNCauseForRecClosing(causeForRecClosing);
		
		this.diagnostics=diagnostics;
		
		if(recordSequenceNumber!=null)
			this.recordSequenceNumber=new ASNInteger(recordSequenceNumber.longValue(),null,null,null,false);
		
		if(nodeID!=null)
			this.nodeID=new ASNIA5String(nodeID,null,null,null,false);
		
		if(recordExtensions!=null)
			this.recordExtensions=new ASNOctetString(Unpooled.wrappedBuffer(recordExtensions),null,null,null,false);
		
		if(localSequenceNumber!=null)
			this.localSequenceNumber=new ASNInteger(localSequenceNumber.longValue(),null,null,null,false);
		
		if(apnSelectionMode!=null)
			this.apnSelectionMode=new ASNAPNSelectionMode(apnSelectionMode);
		
		this.servedMSISDN=servedMSISDN;
		this.chargingCharacteristics=chargingCharacteristics;
		
		if(chChSelectionMode!=null)
			this.chChSelectionMode=new ASNChChSelectionMode(chChSelectionMode);
		
		if(iMSsignalingContext)
			this.iMSsignalingContext=new ASNNull();
		
		this.plmnID=plmnID;
		this.servedIMEISV=servedIMEISV;
		
		if(ratType!=null)
			this.ratType=new ASNRatType(ratType);
		
		this.mSTimeZone=mSTimeZone;
		
		if(userLocationInformation!=null)
			this.userLocationInformation=new ASNOctetString(Unpooled.wrappedBuffer(userLocationInformation),null,null,null,false);
		
		if(sGWChange!=null)
			this.sGWChange=new ASNBoolean(sGWChange,null,false,false);
		
		if(servingNodeType!=null)
		{
			List<ASNServingNodeType> currList=new ArrayList<ASNServingNodeType>();
			for(ServingNodeType curr:servingNodeType)
			{
				ASNServingNodeType currType=new ASNServingNodeType(curr);
				currList.add(currType);
			}
			
			this.servingNodeType=new ServingNodeTypeListWrapper(currList);
		}
		
		if(pGWAddressUsed!=null)
			this.pGWAddressUsed=new IPAddressWrapper(pGWAddressUsed);
		
		this.pGWPLMNIdentifier=pGWPLMNIdentifier;
		this.startTime=startTime;
		this.stopTime=stopTime;
		
		if(pDNConnectionChargingID!=null)
			this.pDNConnectionChargingID=new ASNInteger(pDNConnectionChargingID.longValue(),null,null,null,false);
		
		if(iMSIunauthenticatedFlag)
			this.iMSIunauthenticatedFlag=new ASNNull();
		
		this.userCSGInformation=userCSGInformation;
		
		if(servedPDPPDNAddressExt!=null)
			this.servedPDPPDNAddressExt=new PDPAddressWrapper(servedPDPPDNAddressExt);
		
		if(lowPriorityIndicator)
			this.lowPriorityIndicator=new ASNNull();
		
		if(dynamicAddressFlagExt!=null)
			this.dynamicAddressFlagExt=new ASNBoolean(dynamicAddressFlagExt,null,false,false);
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

	public IPAddress getsgwAddress() 
	{
		if(sgwAddress==null)
			return null;
		
		return sgwAddress.getIPAddress();
	}

	public Integer getChargingID() 
	{
		if(chargingID==null || chargingID.getValue()==null)
			return null;
		
		return chargingID.getValue().intValue();
	}

	public List<IPAddress> getServingNodeAddress() 
	{
		if(servingNodeAddress==null)
			return null;
		
		List<IPAddress> result=new ArrayList<IPAddress>();
		for(IPAddressWrapper curr:servingNodeAddress)
			if(curr.getIPAddress()!=null)
				result.add(curr.getIPAddress());
		
		return result;
	}

	public String getAccessPointNameNI() 
	{
		if(accessPointNameNI==null)
			return null;
		
		return accessPointNameNI.getValue();
	}

	public PDPTypeImpl getPdpPDNType() 
	{
		return pdpPDNType;
	}

	public PDPAddress getServedPDPPDNAddress() 
	{
		if(servedPDPPDNAddress==null)
			return null;
		
		return servedPDPPDNAddress.getPDPAddress();
	}

	public Boolean getDynamicAddressFlag() 
	{
		if(dynamicAddressFlag==null)
			return null;
		
		return dynamicAddressFlag.getValue();
	}

	public List<ChangeOfCharCondition> getListOfTrafficVolumes() 
	{
		if(listOfTrafficVolumes==null)
			return null;
		
		return listOfTrafficVolumes.getChangeOfCharCondition();
	}

	public TimeStamp getRecordOpeningTime() 
	{
		return recordOpeningTime;
	}

	public Integer getDuration() 
	{
		if(duration==null || duration.getValue()==null)
			return null;
		
		return duration.getValue().intValue();
	}

	public CauseForRecClosing getCauseForRecClosing() 
	{
		if(causeForRecClosing==null)
			return null;
		
		return causeForRecClosing.getType();
	}

	public Diagnostics getDiagnostics() 
	{
		return diagnostics;
	}

	public Integer getRecordSequenceNumber() 
	{
		if(recordSequenceNumber==null || recordSequenceNumber.getValue()==null)
			return null;
		
		return recordSequenceNumber.getValue().intValue();
	}

	public String getNodeID() 
	{
		if(nodeID==null)
			return null;
		
		return nodeID.getValue();
	}

	public byte[] getRecordExtensions() 
	{
		if(recordExtensions==null)
			return null;
		
		ByteBuf value=recordExtensions.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public Integer getLocalSequenceNumber() 
	{
		if(localSequenceNumber==null || localSequenceNumber.getValue()==null)
			return null;
		
		return localSequenceNumber.getValue().intValue();
	}

	public APNSelectionMode getApnSelectionMode() 
	{
		if(apnSelectionMode==null)
			return null;
		
		return apnSelectionMode.getType();
	}

	public ISDNAddressStringImpl getServedMSISDN() 
	{
		return servedMSISDN;
	}

	public ChargingCharacteristicsImpl getChargingCharacteristics() 
	{
		return chargingCharacteristics;
	}

	public ChChSelectionMode getChChSelectionMode() 
	{
		if(chChSelectionMode==null)
			return null;
		
		return chChSelectionMode.getType();
	}

	public boolean getiMSsignalingContext() 
	{
		return iMSsignalingContext!=null;
	}

	public PlmnIdImpl getPlmnID() 
	{
		return plmnID;
	}

	public IMEIImpl getServedIMEISV() 
	{
		return servedIMEISV;
	}

	public RATType getRatType() 
	{
		if(ratType==null)
			return null;
		
		return ratType.getType();
	}

	public MSTimezone getmSTimeZone() 
	{
		return mSTimeZone;
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

	public Boolean getSGWChange() 
	{
		if(sGWChange==null)
			return null;
		
		return sGWChange.getValue();
	}

	public List<ServingNodeType> getServingNodeType() 
	{
		if(servingNodeType==null || servingNodeType.getServingNodeType()==null)
			return null;
		
		List<ServingNodeType> result=new ArrayList<ServingNodeType>();
		for(ASNServingNodeType curr:servingNodeType.getServingNodeType())
			result.add(curr.getType());
		
		return result;
	}

	public IPAddress getPGWAddressUsed() 
	{
		if(pGWAddressUsed==null)
			return null;
		
		return pGWAddressUsed.getIPAddress();
	}

	public PlmnIdImpl getpGWPLMNIdentifier() 
	{
		return pGWPLMNIdentifier;
	}

	public TimeStamp getStartTime() 
	{
		return startTime;
	}

	public TimeStamp getStopTime() 
	{
		return stopTime;
	}

	public Integer getpDNConnectionChargingID() 
	{
		if(pDNConnectionChargingID==null || pDNConnectionChargingID.getValue()==null)
			return null;
		
		return pDNConnectionChargingID.getValue().intValue();
	}

	public boolean getiMSIunauthenticatedFlag() 
	{
		return iMSIunauthenticatedFlag!=null;
	}

	public UserCSGInformationImpl getUserCSGInformation() 
	{
		return userCSGInformation;
	}

	public PDPAddress getServedPDPPDNAddressExt() 
	{
		if(servedPDPPDNAddressExt==null)
			return null;
		
		return servedPDPPDNAddressExt.getPDPAddress();
	}

	public boolean getLowPriorityIndicator() 
	{
		return lowPriorityIndicator!=null;
	}

	public Boolean getDynamicAddressFlagExt() 
	{
		if(dynamicAddressFlagExt==null)
			return null;
		
		return dynamicAddressFlagExt.getValue();
	}		
	
	@Override
	public String toString() 
	{
       StringBuilder sb = new StringBuilder();
       sb.append("PGWRecord");
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
       
       if(sgwAddress!=null && sgwAddress.getIPAddress()!=null)
       {
	        sb.append(", sgwAddress=[");
	        sb.append(this.sgwAddress.getIPAddress());
	        sb.append("]");
       }
       
       if(chargingID!=null && chargingID.getValue()!=null)
       {
	        sb.append(", chargingID=[");
	        sb.append(this.chargingID.getValue());
	        sb.append("]");
       }
       
       if(servingNodeAddress!=null)
       {
	        sb.append(", servingNodeAddress=[");
	        int index=0;
	        for(IPAddressWrapper curr:servingNodeAddress)
	        {
	        	if(curr.getIPAddress()!=null)
	        	{
		        	if(index!=0)
		        		sb.append(",");
		        	
		        	sb.append(curr.getIPAddress());
		        	index++;
	        	}
	        }
	        
	        sb.append("]");
       }
       
       if(accessPointNameNI!=null && accessPointNameNI.getValue()!=null)
       {
	        sb.append(", accessPointNameNI=[");
	        sb.append(this.accessPointNameNI.getValue());
	        sb.append("]");
       }
       
       if(pdpPDNType!=null)
       {
	        sb.append(", pdpPDNType=[");
	        sb.append(this.pdpPDNType);
	        sb.append("]");
       }
       
       if(servedPDPPDNAddress!=null && servedPDPPDNAddress.getPDPAddress()!=null)
       {
	        sb.append(", servedPDPPDNAddress=[");
	        sb.append(this.servedPDPPDNAddress.getPDPAddress());
	        sb.append("]");
       }
       
       if(dynamicAddressFlag!=null && dynamicAddressFlag.getValue()!=null)
       {
	        sb.append(", dynamicAddressFlag=[");
	        sb.append(this.dynamicAddressFlag.getValue());
	        sb.append("]");
       }
       
       if(listOfTrafficVolumes!=null && listOfTrafficVolumes.getChangeOfCharCondition()!=null)
       {
	        sb.append(", listOfTrafficVolumes=[");
	        int index=0;
	        for(ChangeOfCharCondition curr:listOfTrafficVolumes.getChangeOfCharCondition())
	        {
	        	if(index!=0)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        	index++;
	        }
	        
	        sb.append("]");
       }
       
       if(recordOpeningTime!=null)
       {
	        sb.append(", recordOpeningTime=[");
	        sb.append(this.recordOpeningTime);
	        sb.append("]");
       }
       
       if(duration!=null && duration.getValue()!=null)
       {
	        sb.append(", duration=[");
	        sb.append(this.duration.getValue());
	        sb.append("]");
       }
       
       if(causeForRecClosing!=null && causeForRecClosing.getValue()!=null)
       {
	        sb.append(", causeForRecClosing=[");
	        sb.append(this.causeForRecClosing.getType());
	        sb.append("]");
       }
       
       if(diagnostics!=null)
       {
	        sb.append(", diagnostics=[");
	        sb.append(this.diagnostics);
	        sb.append("]");
       }
       
       if(recordSequenceNumber!=null && recordSequenceNumber.getValue()!=null)
       {
	        sb.append(", recordSequenceNumber=[");
	        sb.append(this.recordSequenceNumber.getValue());
	        sb.append("]");
       }
       
       if(nodeID!=null && nodeID.getValue()!=null)
       {
	        sb.append(", nodeID=[");
	        sb.append(this.nodeID.getValue());
	        sb.append("]");
       }
       
       if(recordExtensions!=null && recordExtensions.getValue()!=null)
       {
	        sb.append("recordExtensions=[");
	        sb.append(recordExtensions.printDataArr());
	        sb.append("]");
       }
       
       if(localSequenceNumber!=null && localSequenceNumber.getValue()!=null)
       {
	        sb.append(", localSequenceNumber=[");
	        sb.append(this.localSequenceNumber.getValue());
	        sb.append("]");
       }
       
       if(apnSelectionMode!=null && apnSelectionMode.getValue()!=null)
       {
	        sb.append(", apnSelectionMode=[");
	        sb.append(this.apnSelectionMode.getType());
	        sb.append("]");
       }
       
       if(servedMSISDN!=null)
       {
	        sb.append(", servedMSISDN=[");
	        sb.append(this.servedMSISDN);
	        sb.append("]");
       }
       
       if(chargingCharacteristics!=null)
       {
	        sb.append(", chargingCharacteristics=[");
	        sb.append(this.chargingCharacteristics);
	        sb.append("]");
       }
       
       if(chChSelectionMode!=null && chChSelectionMode.getValue()!=null)
       {
	        sb.append(", chChSelectionMode=[");
	        sb.append(this.chChSelectionMode.getType());
	        sb.append("]");
       }
       
       if(iMSsignalingContext!=null)
           sb.append(", iMSsignalingContext");	        
               
       if(plmnID!=null)
       {
	        sb.append(", plmnID=[");
	        sb.append(this.plmnID);
	        sb.append("]");
       }
       
       if(servedIMEISV!=null)
       {
	        sb.append(", servedIMEISV=[");
	        sb.append(this.servedIMEISV);
	        sb.append("]");
       }
       
       if(ratType!=null && ratType.getValue()!=null)
       {
	        sb.append(", ratType=[");
	        sb.append(this.ratType.getType());
	        sb.append("]");
       }
       
       if(mSTimeZone!=null)
       {
	        sb.append(", mSTimeZone=[");
	        sb.append(this.mSTimeZone);
	        sb.append("]");
       }
       
       if(userLocationInformation!=null && userLocationInformation.getValue()!=null)
       {
	        sb.append("userLocationInformation=[");
	        sb.append(userLocationInformation.printDataArr());
	        sb.append("]");
       }
       
       if(sGWChange!=null && sGWChange.getValue()!=null)
       {
	        sb.append(", sGWChange=[");
	        sb.append(this.sGWChange.getValue());
	        sb.append("]");
       }
       
       if(servingNodeType!=null && servingNodeType.getServingNodeType()!=null)
       {
	        sb.append(", servingNodeType=[");
	        int index=0;
	        for(ASNServingNodeType curr:servingNodeType.getServingNodeType())
	        {
	        	if(index!=0)
	        		sb.append(",");
	        	
	        	sb.append(curr.getType());
	        	index++;
	        }
	        
	        sb.append("]");
       }
       
       if(pGWAddressUsed!=null && pGWAddressUsed.getIPAddress()!=null)
       {
	        sb.append(", pGWAddressUsed=[");
	        sb.append(this.pGWAddressUsed.getIPAddress());
	        sb.append("]");
       }
       
       if(pGWPLMNIdentifier!=null)
       {
	        sb.append(", pGWPLMNIdentifier=[");
	        sb.append(this.pGWPLMNIdentifier);
	        sb.append("]");
       }
       
       if(startTime!=null)
       {
	        sb.append(", startTime=[");
	        sb.append(this.startTime);
	        sb.append("]");
       }
       
       if(stopTime!=null)
       {
	        sb.append(", stopTime=[");
	        sb.append(this.stopTime);
	        sb.append("]");
       }
       
       if(pDNConnectionChargingID!=null && pDNConnectionChargingID.getValue()!=null)
       {
	        sb.append(", pDNConnectionChargingID=[");
	        sb.append(this.pDNConnectionChargingID.getValue());
	        sb.append("]");
       }
       
       if(iMSIunauthenticatedFlag!=null)
           sb.append(", iMSIunauthenticatedFlag");	
               
       if(userCSGInformation!=null)
       {
	        sb.append(", userCSGInformation=[");
	        sb.append(this.userCSGInformation);
	        sb.append("]");
       }
       
       if(servedPDPPDNAddressExt!=null && servedPDPPDNAddressExt.getPDPAddress()!=null)
       {
	        sb.append(", servedPDPPDNAddressExt=[");
	        sb.append(this.servedPDPPDNAddressExt.getPDPAddress());
	        sb.append("]");
       }
       
       if(lowPriorityIndicator!=null)
           sb.append(", lowPriorityIndicator");	

       if(dynamicAddressFlagExt!=null && dynamicAddressFlagExt.getValue()!=null)
       {
	        sb.append("dynamicAddressFlagExt=[");
	        sb.append(this.dynamicAddressFlagExt);
	        sb.append("]");
       }
       
       sb.append("]");
       return sb.toString();
   }
}