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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNUTF8String;
/*
SpecifiedTreatmentField ::= SET
{
 incoming [0] GraphicString,
 outgoing [1] GraphicString
 
 Call-Identification-Number [0] UTF8String 
 Interruption-Time [1] Integer 
 Origin-For-Charging [2] UTF8String
 Outgoing-Route [3] UTF8String 
 Incoming-Route [4] UTF8String
 Initial-Visit-CGI [5] UTF8String
 Called-MNP-Info [6] UTF8String
 Subscription-Type [7] Integer
 Translated-Number [8] UTF8String
 MTC-Roaming-Number [9] UTF8String
 Redirecting-Number [10] UTF8String
 RCF-Roaming-Number [11] UTF8String
 RCF-Indication [12] Integer
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class SpecifiedTreatmentField 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNUTF8String callIdentificationNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNInteger interruptionTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNUTF8String originForCharging;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNUTF8String outgoingRoute;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNUTF8String incomingRoute;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private ASNUTF8String initialVisitCGI ;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private ASNUTF8String calledMNPInfo;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private ASNInteger subscriptionType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private ASNUTF8String translatedNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = false,index = -1)
	private ASNUTF8String mtcRoamingNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 10,constructed = false,index = -1)
	private ASNUTF8String redirectingNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 11,constructed = false,index = -1)
	private ASNUTF8String rcfRoamingNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 12,constructed = false,index = -1)
	private ASNInteger rcfIndication;
	
	public SpecifiedTreatmentField() {
		
	}
	
	public SpecifiedTreatmentField(String callIdentificationNumber,Integer interruptionTime,String originForCharging,
			String outgoingRoute,String incomingRoute,String initialVisitCGI,String calledMNPInfo,Integer subscriptionType,
			String translatedNumber,String mtcRoamingNumber,String redirectingNumber,String rcfRoamingNumber,Integer rcfIndication)
	{
		if(callIdentificationNumber!=null)
			this.callIdentificationNumber=new ASNUTF8String(callIdentificationNumber);
		
		if(interruptionTime!=null)
			this.interruptionTime=new ASNInteger(interruptionTime);
		
		if(originForCharging!=null)
			this.originForCharging=new ASNUTF8String(originForCharging);
		
		if(outgoingRoute!=null)
			this.outgoingRoute=new ASNUTF8String(outgoingRoute);
		
		if(incomingRoute!=null)
			this.incomingRoute=new ASNUTF8String(incomingRoute);
		
		if(initialVisitCGI!=null)
			this.initialVisitCGI=new ASNUTF8String(initialVisitCGI);
		
		if(calledMNPInfo!=null)
			this.calledMNPInfo=new ASNUTF8String(calledMNPInfo);
		
		if(subscriptionType!=null)
			this.subscriptionType=new ASNInteger(subscriptionType);
		
		if(translatedNumber!=null)
			this.translatedNumber=new ASNUTF8String(translatedNumber);
		
		if(mtcRoamingNumber!=null)
			this.mtcRoamingNumber=new ASNUTF8String(mtcRoamingNumber);
		
		if(redirectingNumber!=null)
			this.redirectingNumber=new ASNUTF8String(redirectingNumber);
		
		if(rcfRoamingNumber!=null)
			this.rcfRoamingNumber=new ASNUTF8String(rcfRoamingNumber);
		
		if(rcfIndication!=null)
			this.rcfIndication=new ASNInteger(rcfIndication);
	}
	
	public String getCallIdentificationNumber() 
	{
		if(callIdentificationNumber==null)
			return null;
		
		return callIdentificationNumber.getValue();
	}

	public Integer getInterruptionTime() 
	{
		if(interruptionTime==null)
			return null;
		
		return interruptionTime.getIntValue();
	}

	public String getOriginForCharging() 
	{
		if(originForCharging==null)
			return null;
		
		return originForCharging.getValue();
	}

	public String getOutgoingRoute() 
	{
		if(outgoingRoute==null)
			return null;
		
		return outgoingRoute.getValue();
	}

	public String getIncomingRoute() 
	{
		if(incomingRoute==null)
			return null;
		
		return incomingRoute.getValue();
	}

	public String getInitialVisitCGI() 
	{
		if(initialVisitCGI==null)
			return null;
		
		return initialVisitCGI.getValue();
	}

	public String getCalledMNPInfo() 
	{
		if(calledMNPInfo==null)
			return null;
		
		return calledMNPInfo.getValue();
	}

	public Integer getSubscriptionType() 
	{
		if(subscriptionType==null)
			return null;
		
		return subscriptionType.getIntValue();
	}

	public String getTranslatedNumber() 
	{
		if(translatedNumber==null)
			return null;
		
		return translatedNumber.getValue();
	}

	public String getMtcRoamingNumber() 
	{
		if(mtcRoamingNumber==null)
			return null;
		
		return mtcRoamingNumber.getValue();
	}

	public String getRedirectingNumber() 
	{
		if(redirectingNumber==null)
			return null;
		
		return redirectingNumber.getValue();
	}

	public String getRcfRoamingNumber() 
	{
		if(rcfRoamingNumber==null)
			return null;
		
		return rcfRoamingNumber.getValue();
	}

	public Integer getRcfIndication() 
	{
		if(rcfIndication==null)
			return null;
		
		return rcfIndication.getIntValue();
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpecifiedTreatmentField");
        sb.append(" [");

        if(callIdentificationNumber!=null && callIdentificationNumber.getValue()!=null)
        {
	        sb.append("callIdentificationNumber=[");
	        sb.append(callIdentificationNumber.getValue());
	        sb.append("]");
        }
        
        if(interruptionTime!=null && interruptionTime.getValue()!=null)
        {
	        sb.append("interruptionTime=[");
	        sb.append(interruptionTime.getValue());
	        sb.append("]");
        }
        
        if(originForCharging!=null && originForCharging.getValue()!=null)
        {
	        sb.append("originForCharging=[");
	        sb.append(originForCharging.getValue());
	        sb.append("]");
        }
        
        if(outgoingRoute!=null && outgoingRoute.getValue()!=null)
        {
	        sb.append("outgoingRoute=[");
	        sb.append(outgoingRoute.getValue());
	        sb.append("]");
        }
        
        if(incomingRoute!=null && incomingRoute.getValue()!=null)
        {
	        sb.append("incomingRoute=[");
	        sb.append(incomingRoute.getValue());
	        sb.append("]");
        }
        
        if(initialVisitCGI!=null && initialVisitCGI.getValue()!=null)
        {
	        sb.append("initialVisitCGI=[");
	        sb.append(initialVisitCGI.getValue());
	        sb.append("]");
        }
        
        if(calledMNPInfo!=null && calledMNPInfo.getValue()!=null)
        {
	        sb.append("calledMNPInfo=[");
	        sb.append(calledMNPInfo.getValue());
	        sb.append("]");
        }
        
        if(subscriptionType!=null && subscriptionType.getValue()!=null)
        {
	        sb.append("subscriptionType=[");
	        sb.append(subscriptionType.getValue());
	        sb.append("]");
        }
        
        if(translatedNumber!=null && translatedNumber.getValue()!=null)
        {
	        sb.append("translatedNumber=[");
	        sb.append(translatedNumber.getValue());
	        sb.append("]");
        }
        
        if(mtcRoamingNumber!=null && mtcRoamingNumber.getValue()!=null)
        {
	        sb.append("mtcRoamingNumber=[");
	        sb.append(mtcRoamingNumber.getValue());
	        sb.append("]");
        }
        
        if(redirectingNumber!=null && redirectingNumber.getValue()!=null)
        {
	        sb.append("redirectingNumber=[");
	        sb.append(redirectingNumber.getValue());
	        sb.append("]");
        }
        
        if(rcfRoamingNumber!=null && rcfRoamingNumber.getValue()!=null)
        {
	        sb.append("rcfRoamingNumber=[");
	        sb.append(rcfRoamingNumber.getValue());
	        sb.append("]");
        }
        
        if(rcfIndication!=null && rcfIndication.getValue()!=null)
        {
	        sb.append("rcfIndication=[");
	        sb.append(rcfIndication.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}