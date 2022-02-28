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
import java.util.List;

import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNBoolean;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNIA5String;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/*
 ChangeOfServiceCondition ::= SEQUENCE
--
-- Used for Flow based Charging service data container
--
{
ratingGroup [1] RatingGroupId,
chargingRuleBaseName [2] ChargingRuleBaseName OPTIONAL,
resultCode [3] ResultCode OPTIONAL,
localSequenceNumber [4] LocalSequenceNumber OPTIONAL,
timeOfFirstUsage [5] TimeStamp OPTIONAL,
timeOfLastUsage [6] TimeStamp OPTIONAL,
timeUsage [7] CallDuration OPTIONAL,
serviceConditionChange [8] ServiceConditionChange,
qoSInformationNeg [9] EPCQoSInformation OPTIONAL,
servingNodeAddress [10] GSNAddress OPTIONAL,
datavolumeFBCUplink [12] DataVolumeGPRS OPTIONAL,
datavolumeFBCDownlink [13] DataVolumeGPRS OPTIONAL,
timeOfReport [14] TimeStamp,
failureHandlingContinue [16] FailureHandlingContinue OPTIONAL,
serviceIdentifier [17] ServiceIdentifier OPTIONAL,
pSFurnishChargingInformation [18] PSFurnishChargingInformation OPTIONAL,
aFRecordInformation [19] SEQUENCE OF AFRecordInformation OPTIONAL,
userLocationInformation [20] OCTER STRING OPTIONAL,
eventBasedChargingInformation [21] EventBasedChargingInformation OPTIONAL,
timeQuotaMechanism [22] TimeQuotaMechanism OPTIONAL,
serviceSpecificInfo [23] SEQUENCE OF ServiceSpecificInfo OPTIONAL,
threeGPP2UserLocationInformation [24] OCTET STRING OPTIONAL
}

 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class ChangeOfServiceCondition 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNInteger ratingGroupId;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNIA5String chargingRuleBaseName;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNInteger resultCode;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNInteger localSequenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private TimeStamp timeOfFirstUsage;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private TimeStamp timeOfLastUsage;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private ASNInteger timeUsage;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private ServiceConditionChange serviceConditionChange;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = true,index = -1)
	private EPCQoSInformation qoSInformationNeg;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 10,constructed = true,index = -1)
	private IPAddressWrapper servingNodeAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 12,constructed = false,index = -1)
	private ASNInteger dataVolumeFBCUplink;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 13,constructed = false,index = -1)
	private ASNInteger dataVolumeFBCDownlink;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 14,constructed = false,index = -1)
	private TimeStamp timeOfReport;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 16,constructed = false,index = -1)
	private ASNBoolean failureHandlingContinue;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 17,constructed = false,index = -1)
	private ASNInteger serviceIdentifier;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 18,constructed = true,index = -1)
	private PSFurnishChargingInformation pSFurnishChargingInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 19,constructed = true,index = -1)
	private List<AFRecordInformation> aFRecordInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 20,constructed = false,index = -1)
	private ASNOctetString userLocationInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 21,constructed = true,index = -1)
	private EventBasedChargingInformation eventBasedChargingInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 22,constructed = true,index = -1)
	private TimeQuotaMechanism timeQuotaMechanism;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 23,constructed = true,index = -1)
	private List<ServiceSpecificInfo> serviceSpecificInfo;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 24,constructed = false,index = -1)
	private ASNOctetString threeGPP2UserLocationInformation;
	
	public ChangeOfServiceCondition()
	{		
	}
	
	public ChangeOfServiceCondition(Integer ratingGroupId,String chargingRuleBaseName,Integer resultCode,Integer localSequenceNumber,
	TimeStamp timeOfFirstUsage,TimeStamp timeOfLastUsage,Integer timeUsage,ServiceConditionChange serviceConditionChange,EPCQoSInformation qoSInformationNeg,
	IPAddress servingNodeAddress,Integer dataVolumeFBCUplink,Integer dataVolumeFBCDownlink,TimeStamp timeOfReport,
	Boolean failureHandlingContinue,Integer serviceIdentifier,PSFurnishChargingInformation pSFurnishChargingInformation,
	List<AFRecordInformation> aFRecordInformation,byte[] userLocationInformation,EventBasedChargingInformation eventBasedChargingInformation,
	TimeQuotaMechanism timeQuotaMechanism,List<ServiceSpecificInfo> serviceSpecificInfo,byte[] threeGPP2UserLocationInformation)
	{
		if(ratingGroupId!=null)
			this.ratingGroupId=new ASNInteger(ratingGroupId.longValue(),null,null,null,false);
		
		if(chargingRuleBaseName!=null)
			this.chargingRuleBaseName=new ASNIA5String(chargingRuleBaseName,null,null,null,false);
		
		if(resultCode!=null)
			this.resultCode=new ASNInteger(resultCode.longValue(),null,null,null,false);
		
		if(localSequenceNumber!=null)
			this.localSequenceNumber=new ASNInteger(localSequenceNumber.longValue(),null,null,null,false);
		
		this.timeOfFirstUsage=timeOfFirstUsage;
		this.timeOfLastUsage=timeOfLastUsage;
		
		if(timeUsage!=null)
			this.timeUsage=new ASNInteger(timeUsage.longValue(),null,null,null,false);
		
		this.serviceConditionChange=serviceConditionChange;
		this.qoSInformationNeg=qoSInformationNeg;
		
		if(servingNodeAddress!=null)
			this.servingNodeAddress=new IPAddressWrapper(servingNodeAddress);

		if(dataVolumeFBCUplink!=null)
			this.dataVolumeFBCUplink=new ASNInteger(dataVolumeFBCUplink.longValue(),null,null,null,false);
		
		if(dataVolumeFBCDownlink!=null)
			this.dataVolumeFBCDownlink=new ASNInteger(dataVolumeFBCDownlink.longValue(),null,null,null,false);
		
		this.timeOfReport=timeOfReport;
		
		if(failureHandlingContinue!=null)
			this.failureHandlingContinue=new ASNBoolean(failureHandlingContinue,null,false,false);
		
		if(serviceIdentifier!=null)
			this.serviceIdentifier=new ASNInteger(serviceIdentifier.longValue(),null,null,null,false);
		
		this.pSFurnishChargingInformation=pSFurnishChargingInformation;
		this.aFRecordInformation=aFRecordInformation;
		
		if(userLocationInformation!=null)
			this.userLocationInformation=new ASNOctetString(Unpooled.wrappedBuffer(userLocationInformation),null,null,null,false);
		
		this.eventBasedChargingInformation=eventBasedChargingInformation;
		this.timeQuotaMechanism=timeQuotaMechanism;
		this.serviceSpecificInfo=serviceSpecificInfo;
		
		if(threeGPP2UserLocationInformation!=null)
			this.threeGPP2UserLocationInformation=new ASNOctetString(Unpooled.wrappedBuffer(threeGPP2UserLocationInformation),null,null,null,false);		
	}

	public Integer getRatingGroupId() 
	{
		if(ratingGroupId==null || ratingGroupId.getValue()==null)
			return null;
		
		return ratingGroupId.getValue().intValue();
	}

	public String getChargingRuleBaseName() 
	{
		if(chargingRuleBaseName==null || chargingRuleBaseName.getValue()==null)
			return null;
		
		return chargingRuleBaseName.getValue();		
	}

	public Integer getResultCode() 
	{
		if(resultCode==null || resultCode.getValue()==null)
			return null;
		
		return resultCode.getValue().intValue();
	}

	public Integer getLocalSequenceNumber() 
	{
		if(localSequenceNumber==null || localSequenceNumber.getValue()==null)
			return null;
		
		return localSequenceNumber.getValue().intValue();
	}

	public TimeStamp getTimeOfFirstUsage() 
	{
		return timeOfFirstUsage;
	}

	public TimeStamp getTimeOfLastUsage() 
	{
		return timeOfLastUsage;
	}

	public Integer getTimeUsage() 
	{
		if(timeUsage==null || timeUsage.getValue()==null)
			return null;
		
		return timeUsage.getValue().intValue();
	}

	public ServiceConditionChange getServiceConditionChange() 
	{
		return serviceConditionChange;
	}

	public EPCQoSInformation getQoSInformationNeg() 
	{
		return qoSInformationNeg;
	}

	public IPAddress getServingNodeAddress() 
	{
		if(servingNodeAddress==null)
			return null;
		
		return servingNodeAddress.getIPAddress();
	}

	public Integer getDataVolumeFBCUplink() 
	{
		if(dataVolumeFBCUplink==null || dataVolumeFBCUplink.getValue()==null)
			return null;
		
		return dataVolumeFBCUplink.getValue().intValue();
	}

	public Integer getDataVolumeFBCDownlink() 
	{
		if(dataVolumeFBCDownlink==null || dataVolumeFBCDownlink.getValue()==null)
			return null;
		
		return dataVolumeFBCDownlink.getValue().intValue();
	}

	public TimeStamp getTimeOfReport() 
	{
		return timeOfReport;
	}

	public Boolean getFailureHandlingContinue() 
	{
		if(failureHandlingContinue==null || failureHandlingContinue.getValue()==null)
			return null;
		
		return failureHandlingContinue.getValue();
	}

	public Integer getServiceIdentifier() 
	{
		if(serviceIdentifier==null || serviceIdentifier.getValue()==null)
			return null;
		
		return serviceIdentifier.getValue().intValue();
	}

	public PSFurnishChargingInformation getpSFurnishChargingInformation() 
	{
		return pSFurnishChargingInformation;
	}

	public List<AFRecordInformation> getaFRecordInformation() 
	{
		return aFRecordInformation;
	}

	public byte[] getUserLocationInformation() 
	{
		if(userLocationInformation==null ||userLocationInformation.getValue()==null)
			return null;
		
		ByteBuf value=userLocationInformation.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public EventBasedChargingInformation getEventBasedChargingInformation() 
	{
		return eventBasedChargingInformation;
	}

	public TimeQuotaMechanism getTimeQuotaMechanism() 
	{
		return timeQuotaMechanism;
	}

	public List<ServiceSpecificInfo> getServiceSpecificInfo() 
	{
		return serviceSpecificInfo;
	}

	public byte[] getThreeGPP2UserLocationInformation() 
	{
		if(threeGPP2UserLocationInformation==null ||threeGPP2UserLocationInformation.getValue()==null)
			return null;
		
		ByteBuf value=threeGPP2UserLocationInformation.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}
		
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("ChangeOfServiceCondition");
        sb.append(" [");

        if(ratingGroupId!=null && ratingGroupId.getValue()!=null)
        {
	        sb.append(", ratingGroupId=[");
	        sb.append(this.ratingGroupId.getValue());
	        sb.append("]");
        }
        
        if(chargingRuleBaseName!=null && chargingRuleBaseName.getValue()!=null)
        {
	        sb.append(", chargingRuleBaseName=[");
	        sb.append(this.chargingRuleBaseName.getValue());
	        sb.append("]");
        }
        
        if(resultCode!=null && resultCode.getValue()!=null)
        {
	        sb.append(", resultCode=[");
	        sb.append(this.resultCode.getValue());
	        sb.append("]");
        }
        
        if(localSequenceNumber!=null && localSequenceNumber.getValue()!=null)
        {
	        sb.append(", localSequenceNumber=[");
	        sb.append(this.localSequenceNumber.getValue());
	        sb.append("]");
        }
        
        if(timeOfFirstUsage!=null)
        {
	        sb.append(", timeOfFirstUsage=[");
	        sb.append(this.timeOfFirstUsage);
	        sb.append("]");
        }
        
        if(timeOfLastUsage!=null)
        {
	        sb.append(", timeOfLastUsage=[");
	        sb.append(this.timeOfLastUsage);
	        sb.append("]");
        }
        
        if(timeUsage!=null && timeUsage.getValue()!=null)
        {
	        sb.append(", timeUsage=[");
	        sb.append(this.timeUsage.getValue());
	        sb.append("]");
        }
        
        if(serviceConditionChange!=null)
        {
	        sb.append(", serviceConditionChange=[");
	        sb.append(this.serviceConditionChange);
	        sb.append("]");
        }
        
        if(qoSInformationNeg!=null)
        {
	        sb.append(", qoSInformationNeg=[");
	        sb.append(this.qoSInformationNeg);
	        sb.append("]");
        }
        
        if(servingNodeAddress!=null && servingNodeAddress.getIPAddress()!=null)
        {
	        sb.append(", servingNodeAddress=[");
	        sb.append(this.servingNodeAddress.getIPAddress());
	        sb.append("]");
        }
        
        if(dataVolumeFBCUplink!=null && dataVolumeFBCUplink.getValue()!=null)
        {
	        sb.append(", dataVolumeFBCUplink=[");
	        sb.append(this.dataVolumeFBCUplink.getValue());
	        sb.append("]");
        }
        
        if(dataVolumeFBCDownlink!=null && dataVolumeFBCDownlink.getValue()!=null)
        {
	        sb.append(", dataVolumeFBCDownlink=[");
	        sb.append(this.dataVolumeFBCDownlink.getValue());
	        sb.append("]");
        }
        
        if(timeOfReport!=null)
        {
	        sb.append(", timeOfReport=[");
	        sb.append(this.timeOfReport);
	        sb.append("]");
        }
        
        if(failureHandlingContinue!=null && failureHandlingContinue.getValue()!=null)
        {
	        sb.append(", failureHandlingContinue=[");
	        sb.append(this.failureHandlingContinue.getValue());
	        sb.append("]");
        }
        
        if(serviceIdentifier!=null && serviceIdentifier.getValue()!=null)
        {
	        sb.append(", serviceIdentifier=[");
	        sb.append(this.serviceIdentifier.getValue());
	        sb.append("]");
        }
        
        if(pSFurnishChargingInformation!=null)
        {
	        sb.append(", pSFurnishChargingInformation=[");
	        sb.append(this.pSFurnishChargingInformation);
	        sb.append("]");
        }
        
        if(aFRecordInformation!=null)
        {
	        sb.append(", aFRecordInformation=[");
	        int index=0;
	        for(AFRecordInformation curr:aFRecordInformation)
	        {
	        	if(index!=0)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        	index++;
	        }
	        
	        sb.append("]");
        }
        
        if(userLocationInformation!=null && userLocationInformation.getValue()!=null)
        {
	        sb.append("userLocationInformation=[");
	        sb.append(userLocationInformation.printDataArr());
	        sb.append("]");
        }
        
        if(eventBasedChargingInformation!=null)
        {
	        sb.append(", eventBasedChargingInformation=[");
	        sb.append(this.eventBasedChargingInformation);
	        sb.append("]");
        }
        
        if(timeQuotaMechanism!=null)
        {
	        sb.append(", timeQuotaMechanism=[");
	        sb.append(this.timeQuotaMechanism);
	        sb.append("]");
        }
        
        if(serviceSpecificInfo!=null)
        {
	        sb.append(", serviceSpecificInfo=[");
	        int index=0;
	        for(ServiceSpecificInfo curr:serviceSpecificInfo)
	        {
	        	if(index!=0)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        	index++;
	        }
	        
	        sb.append("]");
        }
        
        if(threeGPP2UserLocationInformation!=null && threeGPP2UserLocationInformation.getValue()!=null)
        {
	        sb.append("threeGPP2UserLocationInformation=[");
	        sb.append(threeGPP2UserLocationInformation.printDataArr());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}