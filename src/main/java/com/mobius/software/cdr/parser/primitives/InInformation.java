package com.mobius.software.cdr.parser.primitives;
import org.restcomm.protocols.ss7.map.api.service.mobility.subscriberManagement.DefaultCallHandling;
import org.restcomm.protocols.ss7.map.service.mobility.subscriberManagement.ASNDefaultCallHandling;

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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNUTF8String;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/*
InInformation ::= SEQUECE
{
 serviceKey [0] INTEGER,
 ServiceNumber [1] UTF8String,
 Fci-Free-Format-Data [2] OctetString,
 Fci-Free-Format-Data-Manne [3] Enumerated,
 Default-Call-Handling [4] Enumerated,
 Scf-Address [5] OctetString,
 GenericNumber [6] UTF8String,
 Level-Of-Camel-Service [7] UTF8String,
 charge-Class [8] INTEGER,
 iN-Bypass [9] INTEGER,
 camel-Destination-Number [10] UTF8String,
 camel-Destination-Number-Type [11] Enumerated,
 sci-Charge-Number [12] UTF8String,
 fci-Charge-Number [13] UTF8String,
 fci-Charged-Party-ID [14] UTF8String,
 aOCParameters [15] OctetString,
 interaction-With-IP [16] UTF8String,
 resource-Charge-IP-number [17] UTF8String,
 trigger-Detection-Point [23] UTF8String,
 time-For-TH-EOS [22] UTF8String,
 iN-Service-Trigger [19] UTF8String,
 sSF-Charging-Case [20] UTF8String,
 global-Title-Subsystem [21] UTF8String,
 iN-Composite-CDR [18] UTF8String,
 CGI-Information [26] UTF8String,
 MSC-GT-when-IN-Bypass [27] UTF8String,
 VLR-GT-when-IN-Bypass [28] UTF8String
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class InInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNInteger serviceKey;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNUTF8String serviceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNOctetString fciFreeFormatData;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNFciFreeFormatDataManner fciFreeFormatDataManner;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNDefaultCallHandling defaultCallHandling;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private ASNOctetString scfAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private ASNUTF8String genericNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private ASNUTF8String levelOfCamelService;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private ASNInteger chargeClass;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = false,index = -1)
	private ASNInteger inBypass;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 10,constructed = false,index = -1)
	private ASNUTF8String camelDestinationNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 11,constructed = false,index = -1)
	private ASNCamelDestinationNumberType camelDestinationNumberType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 12,constructed = false,index = -1)
	private ASNUTF8String sciChargeNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 13,constructed = false,index = -1)
	private ASNUTF8String fciChargeNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 14,constructed = false,index = -1)
	private ASNUTF8String fciChargedPartyID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 15,constructed = false,index = -1)
	private ASNOctetString aOCParameters;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 16,constructed = false,index = -1)
	private ASNUTF8String interactionWithIP;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 17,constructed = false,index = -1)
	private ASNUTF8String resourceChargeIPNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 23,constructed = false,index = -1)
	private ASNUTF8String triggerDetectionPoint;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 22,constructed = false,index = -1)
	private ASNUTF8String timeForTHEOS;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 19,constructed = false,index = -1)
	private ASNUTF8String inServiceTrigger;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 20,constructed = false,index = -1)
	private ASNUTF8String ssfChargingCase;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 21,constructed = false,index = -1)
	private ASNUTF8String globalTitleSubsystem;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 18,constructed = false,index = -1)
	private ASNUTF8String inCompositeCDR;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 26,constructed = false,index = -1)
	private ASNUTF8String cgiInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 27,constructed = false,index = -1)
	private ASNUTF8String mscGTWhenINBypass;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 28,constructed = false,index = -1)
	private ASNUTF8String vlrGTWhenINBypass;
	
	public InInformation()
	{
		
	}
	
	public InInformation(Integer serviceKey,String serviceNumber,byte[] fciFreeFormatData,
			FciFreeFormatDataManner fciFreeFormatDataManner,DefaultCallHandling defaultCallHandling,
			byte[] scfAddress,String genericNumber,String levelOfCamelService,Integer chargeClass,
			Integer inBypass,String camelDestinationNumber,CamelDestinationNumberType camelDestinationNumberType,
			String sciChargeNumber,String fciChargeNumber,String fciChargedPartyID,byte[] aOCParameters,
			String interactionWithIP,String resourceChargeIPNumber,String triggerDetectionPoint,
			String timeForTHEOS,String inServiceTrigger,String ssfChargingCase,String globalTitleSubsystem,
			String inCompositeCDR,String cgiInformation,String mscGTWhenINBypass,String vlrGTWhenINBypass)
	{
		if(serviceKey!=null)
			this.serviceKey=new ASNInteger(serviceKey.longValue());
		
		if(serviceNumber!=null)
			this.serviceNumber=new ASNUTF8String(serviceNumber);
		
		if(fciFreeFormatData!=null)
			this.fciFreeFormatData=new ASNOctetString(Unpooled.wrappedBuffer(fciFreeFormatData));
		
		if(fciFreeFormatDataManner!=null)
			this.fciFreeFormatDataManner=new ASNFciFreeFormatDataManner(fciFreeFormatDataManner);
		
		if(defaultCallHandling!=null)
			this.defaultCallHandling=new ASNDefaultCallHandling(defaultCallHandling);
		
		if(scfAddress!=null)
			this.scfAddress=new ASNOctetString(Unpooled.wrappedBuffer(scfAddress));
		
		if(genericNumber!=null)
			this.genericNumber=new ASNUTF8String(genericNumber);
		
		if(levelOfCamelService!=null)
			this.levelOfCamelService=new ASNUTF8String(levelOfCamelService);
		
		if(chargeClass!=null)
			this.chargeClass=new ASNInteger(chargeClass.longValue());
		
		if(inBypass!=null)
			this.inBypass=new ASNInteger(inBypass.longValue());
		
		if(camelDestinationNumber!=null)
			this.camelDestinationNumber=new ASNUTF8String(camelDestinationNumber);
		
		if(camelDestinationNumberType!=null)
			this.camelDestinationNumberType=new ASNCamelDestinationNumberType(camelDestinationNumberType);
		
		if(sciChargeNumber!=null)
			this.sciChargeNumber=new ASNUTF8String(sciChargeNumber);
		
		if(fciChargeNumber!=null)
			this.fciChargeNumber=new ASNUTF8String(fciChargeNumber);
		
		if(fciChargedPartyID!=null)
			this.fciChargedPartyID=new ASNUTF8String(fciChargedPartyID);
		
		if(aOCParameters!=null)
			this.aOCParameters=new ASNOctetString(Unpooled.wrappedBuffer(aOCParameters));
		
		if(interactionWithIP!=null)
			this.interactionWithIP=new ASNUTF8String(interactionWithIP);
		
		if(resourceChargeIPNumber!=null)
			this.resourceChargeIPNumber=new ASNUTF8String(resourceChargeIPNumber);
		
		if(triggerDetectionPoint!=null)
			this.triggerDetectionPoint=new ASNUTF8String(triggerDetectionPoint);
		
		if(timeForTHEOS!=null)
			this.timeForTHEOS=new ASNUTF8String(timeForTHEOS);
		
		if(inServiceTrigger!=null)
			this.inServiceTrigger=new ASNUTF8String(inServiceTrigger);
		
		if(ssfChargingCase!=null)
			this.ssfChargingCase=new ASNUTF8String(ssfChargingCase);
		
		if(globalTitleSubsystem!=null)
			this.globalTitleSubsystem=new ASNUTF8String(globalTitleSubsystem);
		
		if(inCompositeCDR!=null)
			this.inCompositeCDR=new ASNUTF8String(inCompositeCDR);
		
		if(cgiInformation!=null)
			this.cgiInformation=new ASNUTF8String(cgiInformation);
		
		if(mscGTWhenINBypass!=null)
			this.mscGTWhenINBypass=new ASNUTF8String(mscGTWhenINBypass);
		
		if(vlrGTWhenINBypass!=null)
			this.vlrGTWhenINBypass=new ASNUTF8String(vlrGTWhenINBypass);		
	}

	public Integer getServiceKey() 
	{
		if(serviceKey==null || serviceKey.getValue()==null)
			return null;
		
		return serviceKey.getValue().intValue();
	}

	public String getServiceNumber() 
	{
		if(serviceNumber==null)
			return null;
		
		return serviceNumber.getValue();
	}

	public byte[] getFciFreeFormatData() 
	{
		if(fciFreeFormatData==null || fciFreeFormatData.getValue()==null)
			return null;
		
		ByteBuf value=fciFreeFormatData.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public FciFreeFormatDataManner getFciFreeFormatDataManner() 
	{
		if(fciFreeFormatDataManner==null)
			return null;
		
		return fciFreeFormatDataManner.getIdentifier();
	}

	public DefaultCallHandling getDefaultCallHandling() 
	{
		if(defaultCallHandling==null)
			return null;
		
		return defaultCallHandling.getType();
	}

	public byte[] getScfAddress() 
	{
		if(scfAddress==null || scfAddress.getValue()==null)
			return null;
		
		ByteBuf value=scfAddress.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public String getGenericNumber() 
	{
		if(genericNumber==null)
			return null;
		
		return genericNumber.getValue();
	}

	public String getLevelOfCamelService() 
	{
		if(levelOfCamelService==null)
			return null;
		
		return levelOfCamelService.getValue();
	}

	public Integer getChargeClass() 
	{
		if(chargeClass==null || chargeClass.getValue()==null)
			return null;
		
		return chargeClass.getValue().intValue();		
	}

	public Integer getInBypass() 
	{
		if(inBypass==null || inBypass.getValue()==null)
			return null;
		
		return inBypass.getValue().intValue();
	}

	public String getCamelDestinationNumber() 
	{
		if(camelDestinationNumber==null)
			return null;
		
		return camelDestinationNumber.getValue();
	}

	public CamelDestinationNumberType getCamelDestinationNumberType() 
	{
		if(camelDestinationNumberType==null)
			return null;
		
		return camelDestinationNumberType.getIdentifier();
	}

	public String getSciChargeNumber() 
	{
		if(sciChargeNumber==null)
			return null;
		
		return sciChargeNumber.getValue();
	}

	public String getFciChargeNumber() 
	{
		if(fciChargeNumber==null)
			return null;
		
		return fciChargeNumber.getValue();
	}

	public String getFciChargedPartyID() 
	{
		if(fciChargedPartyID==null)
			return null;
		
		return fciChargedPartyID.getValue();
	}

	public byte[] getaOCParameters() 
	{
		if(aOCParameters==null || aOCParameters.getValue()==null)
			return null;
		
		ByteBuf value=aOCParameters.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public String getInteractionWithIP() 
	{
		if(interactionWithIP==null)
			return null;
		
		return interactionWithIP.getValue();
	}

	public String getResourceChargeIPNumber() 
	{
		if(resourceChargeIPNumber==null)
			return null;
		
		return resourceChargeIPNumber.getValue();
	}

	public String getTriggerDetectionPoint() 
	{
		if(triggerDetectionPoint==null)
			return null;
		
		return triggerDetectionPoint.getValue();
	}

	public String getTimeForTHEOS() 
	{
		if(timeForTHEOS==null)
			return null;
		
		return timeForTHEOS.getValue();
	}

	public String getInServiceTrigger() 
	{
		if(inServiceTrigger==null)
			return null;
		
		return inServiceTrigger.getValue();
	}

	public String getSsfChargingCase() 
	{
		if(ssfChargingCase==null)
			return null;
		
		return ssfChargingCase.getValue();
	}

	public String getGlobalTitleSubsystem() 
	{
		if(globalTitleSubsystem==null)
			return null;
		
		return globalTitleSubsystem.getValue();
	}

	public String getInCompositeCDR() 
	{
		if(inCompositeCDR==null)
			return null;
		
		return inCompositeCDR.getValue();
	}

	public String getCgiInformation() 
	{
		if(cgiInformation==null)
			return null;
		
		return cgiInformation.getValue();
	}

	public String getMscGTWhenINBypass() 
	{
		if(mscGTWhenINBypass==null)
			return null;
		
		return mscGTWhenINBypass.getValue();
	}

	public String getVlrGTWhenINBypass() 
	{
		if(vlrGTWhenINBypass==null)
			return null;
		
		return vlrGTWhenINBypass.getValue();
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InInformation");
        sb.append(" [");

        if(serviceKey!=null && serviceKey.getValue()!=null)
        {
	        sb.append("serviceKey=[");
	        sb.append(serviceKey.getValue());
	        sb.append("]");
        }
        
        if(serviceNumber!=null && serviceNumber.getValue()!=null)
        {
	        sb.append("serviceNumber=[");
	        sb.append(serviceNumber.getValue());
	        sb.append("]");
        }
        
        if(fciFreeFormatData!=null && fciFreeFormatData.getValue()!=null)
        {
	        sb.append("fciFreeFormatData=[");
	        sb.append(fciFreeFormatData.printDataArr());
	        sb.append("]");
        }
        
        if(fciFreeFormatDataManner!=null && fciFreeFormatDataManner.getIdentifier()!=null)
        {
	        sb.append("fciFreeFormatDataManner=[");
	        sb.append(fciFreeFormatDataManner.getIdentifier());
	        sb.append("]");
        }
        

        if(defaultCallHandling!=null && defaultCallHandling.getType()!=null)
        {
	        sb.append("defaultCallHandling=[");
	        sb.append(defaultCallHandling.getType());
	        sb.append("]");
        }
        
        if(scfAddress!=null && scfAddress.getValue()!=null)
        {
	        sb.append("scfAddress=[");
	        sb.append(scfAddress.printDataArr());
	        sb.append("]");
        }
        
        if(genericNumber!=null && genericNumber.getValue()!=null)
        {
	        sb.append("genericNumber=[");
	        sb.append(genericNumber.getValue());
	        sb.append("]");
        }
        
        if(levelOfCamelService!=null && levelOfCamelService.getValue()!=null)
        {
	        sb.append("levelOfCamelService=[");
	        sb.append(levelOfCamelService.getValue());
	        sb.append("]");
        }
        
        if(chargeClass!=null && chargeClass.getValue()!=null)
        {
	        sb.append("chargeClass=[");
	        sb.append(chargeClass.getValue());
	        sb.append("]");
        }
        
        if(inBypass!=null && inBypass.getValue()!=null)
        {
	        sb.append("inBypass=[");
	        sb.append(inBypass.getValue());
	        sb.append("]");
        }
        
        if(camelDestinationNumber!=null && camelDestinationNumber.getValue()!=null)
        {
	        sb.append("camelDestinationNumber=[");
	        sb.append(camelDestinationNumber.getValue());
	        sb.append("]");
        }
        
        if(camelDestinationNumberType!=null && camelDestinationNumberType.getIdentifier()!=null)
        {
	        sb.append("camelDestinationNumberType=[");
	        sb.append(camelDestinationNumberType.getIdentifier());
	        sb.append("]");
        }
        

        if(sciChargeNumber!=null && sciChargeNumber.getValue()!=null)
        {
	        sb.append("sciChargeNumber=[");
	        sb.append(sciChargeNumber.getValue());
	        sb.append("]");
        }
        
        if(fciChargeNumber!=null && fciChargeNumber.getValue()!=null)
        {
	        sb.append("fciChargeNumber=[");
	        sb.append(fciChargeNumber.getValue());
	        sb.append("]");
        }
        
        if(fciChargedPartyID!=null && fciChargedPartyID.getValue()!=null)
        {
	        sb.append("fciChargedPartyID=[");
	        sb.append(fciChargedPartyID.getValue());
	        sb.append("]");
        }
        
        if(aOCParameters!=null && aOCParameters.getValue()!=null)
        {
	        sb.append("aOCParameters=[");
	        sb.append(aOCParameters.printDataArr());
	        sb.append("]");
        }
        
        if(interactionWithIP!=null && interactionWithIP.getValue()!=null)
        {
	        sb.append("interactionWithIP=[");
	        sb.append(interactionWithIP.getValue());
	        sb.append("]");
        }
        
        if(resourceChargeIPNumber!=null && resourceChargeIPNumber.getValue()!=null)
        {
	        sb.append("resourceChargeIPNumber=[");
	        sb.append(resourceChargeIPNumber.getValue());
	        sb.append("]");
        }
        
        if(triggerDetectionPoint!=null && triggerDetectionPoint.getValue()!=null)
        {
	        sb.append("triggerDetectionPoint=[");
	        sb.append(triggerDetectionPoint.getValue());
	        sb.append("]");
        }
        
        if(timeForTHEOS!=null && timeForTHEOS.getValue()!=null)
        {
	        sb.append("timeForTHEOS=[");
	        sb.append(timeForTHEOS.getValue());
	        sb.append("]");
        }
        

        if(inServiceTrigger!=null && inServiceTrigger.getValue()!=null)
        {
	        sb.append("inServiceTrigger=[");
	        sb.append(inServiceTrigger.getValue());
	        sb.append("]");
        }
        
        if(ssfChargingCase!=null && ssfChargingCase.getValue()!=null)
        {
	        sb.append("ssfChargingCase=[");
	        sb.append(ssfChargingCase.getValue());
	        sb.append("]");
        }
        
        if(globalTitleSubsystem!=null && globalTitleSubsystem.getValue()!=null)
        {
	        sb.append("globalTitleSubsystem=[");
	        sb.append(globalTitleSubsystem.getValue());
	        sb.append("]");
        }
        
        if(inCompositeCDR!=null && inCompositeCDR.getValue()!=null)
        {
	        sb.append("inCompositeCDR=[");
	        sb.append(inCompositeCDR.getValue());
	        sb.append("]");
        }
        
        if(cgiInformation!=null && cgiInformation.getValue()!=null)
        {
	        sb.append("cgiInformation=[");
	        sb.append(cgiInformation.getValue());
	        sb.append("]");
        }
        
        if(mscGTWhenINBypass!=null && mscGTWhenINBypass.getValue()!=null)
        {
	        sb.append("mscGTWhenINBypass=[");
	        sb.append(mscGTWhenINBypass.getValue());
	        sb.append("]");
        }
        
        if(vlrGTWhenINBypass!=null && vlrGTWhenINBypass.getValue()!=null)
        {
	        sb.append("vlrGTWhenINBypass=[");
	        sb.append(vlrGTWhenINBypass.getValue());
	        sb.append("]");
        }
               
        sb.append("]");

        return sb.toString();
    }
}