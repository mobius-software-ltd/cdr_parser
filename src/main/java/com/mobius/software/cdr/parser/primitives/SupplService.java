package com.mobius.software.cdr.parser.primitives;
import java.util.List;

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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNGraphicString;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/*
SupplService ::= SET
{
 	serviceType [0] ServiceType,
 	serviceMode [1] ServiceMode OPTIONAL,
 	numberOfDiversions [2] INTEGER OPTIONAL,
	associated-Party-Address [3] InvolvedParty OPTIONAL,
	serviceId [4] Service-Id OPTIONAL,
	changeTime [5] TimeStamp,
	numberOfParticipants [6] INTEGER OPTIONAL,
	participantActionType [7] ParticipantActionType OPTIONAL,
	cUGInformation [8] OCTET STRING OPTIONAL,
	aoCInformation [9] SEQUENCE OF AoCInformation OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class SupplService 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNInteger serviceType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNInteger serviceMode;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNInteger numberOfDiversions;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = true,index = -1)
	private InvolvedPartyWrapper associatedPartyAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNGraphicString serviceID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private TimeStamp changeTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private ASNInteger numberOfParticipants;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private ASNParticipantActionType participantActionType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private ASNOctetString cugInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = true,index = -1)
	private AoCInformationListWrapper aocInformation;
	
	public SupplService()
	{
		
	}
	
	public SupplService(Integer serviceType,Integer serviceMode,Integer numberOfDiversions,
			InvolvedParty associatedPartyAddress,String serviceID,TimeStamp changeTime,
			Integer numberOfParticipants,ParticipantActionType participantActionType,
			byte[] cugInformation,List<AoCInformation> aocInformation)
	{
		if(serviceType!=null)
			this.serviceType=new ASNInteger(serviceType.longValue(),null,null,null,false);
		
		if(serviceMode!=null)
			this.serviceMode=new ASNInteger(serviceMode.longValue(),null,null,null,false);
		
		if(numberOfDiversions!=null)
			this.numberOfDiversions=new ASNInteger(numberOfDiversions.longValue(),null,null,null,false);
		
		if(associatedPartyAddress!=null)
			this.associatedPartyAddress=new InvolvedPartyWrapper(associatedPartyAddress);
		
		if(serviceID!=null)
			this.serviceID=new ASNGraphicString(serviceID,null,null,null,false);
		
		this.changeTime=changeTime;
		
		if(numberOfParticipants!=null)
			this.numberOfParticipants=new ASNInteger(numberOfParticipants.longValue(),null,null,null,false);
		
		if(participantActionType!=null)
			this.participantActionType=new ASNParticipantActionType(participantActionType);
		
		if(cugInformation!=null)
			this.cugInformation=new ASNOctetString(Unpooled.wrappedBuffer(cugInformation),null,null,null,false);
		
		if(aocInformation!=null)
			this.aocInformation=new AoCInformationListWrapper(aocInformation);		
	}
	
	public Integer getServiceType() 
	{
		if(serviceType==null || serviceType.getValue()==null)
			return null;
		
		return serviceType.getValue().intValue();
	}

	public Integer getServiceMode() 
	{
		if(serviceMode==null || serviceMode.getValue()==null)
			return null;
		
		return serviceMode.getValue().intValue();
	}

	public Integer getNumberOfDiversions() 
	{
		if(numberOfDiversions==null || numberOfDiversions.getValue()==null)
			return null;
		
		return numberOfDiversions.getValue().intValue();
	}

	public InvolvedParty getAssociatedPartyAddress() 
	{
		if(associatedPartyAddress==null)
			return null;
		
		return associatedPartyAddress.getInvolvedParty();
	}

	public String getServiceID() 
	{
		if(serviceID==null)
			return null;
		
		return serviceID.getValue();
	}

	public TimeStamp getChangeTime() 
	{
		return changeTime;
	}

	public Integer getNumberOfParticipants() 
	{
		if(numberOfParticipants==null || numberOfParticipants.getValue()==null)
			return null;
		
		return numberOfParticipants.getValue().intValue();
	}

	public ParticipantActionType getParticipantActionType() 
	{
		if(participantActionType==null)
			return null;
		
		return participantActionType.getType();
	}

	public byte[] getCugInformation() 
	{
		if(cugInformation==null || cugInformation.getValue()==null)
			return null;
		
		ByteBuf value=cugInformation.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public List<AoCInformation> getAocInformation() 
	{
		if(aocInformation==null)
			return null;
		
		return aocInformation.getAoCInformation();
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SupplService");
        sb.append(" [");

        if(serviceType!=null && serviceType.getValue()!=null)
        {
	        sb.append("serviceType=[");
	        sb.append(serviceType.getValue());
	        sb.append("]");
        }
        
        if(serviceMode!=null && serviceMode.getValue()!=null)
        {
	        sb.append("serviceMode=[");
	        sb.append(serviceMode.getValue());
	        sb.append("]");
        }
        
        if(numberOfDiversions!=null && numberOfDiversions.getValue()!=null)
        {
	        sb.append("numberOfDiversions=[");
	        sb.append(numberOfDiversions.getValue());
	        sb.append("]");
        }
        
        if(associatedPartyAddress!=null && associatedPartyAddress.getInvolvedParty()!=null)
        {
	        sb.append("associatedPartyAddress=[");
	        sb.append(associatedPartyAddress.getInvolvedParty());
	        sb.append("]");
        }
        
        if(serviceID!=null && serviceID.getValue()!=null)
        {
	        sb.append("serviceID=[");
	        sb.append(serviceID.getValue());
	        sb.append("]");
        }
        
        if(changeTime!=null)
        {
	        sb.append("changeTime=[");
	        sb.append(changeTime.getValue());
	        sb.append("]");
        }
        
        if(numberOfParticipants!=null && numberOfParticipants.getValue()!=null)
        {
	        sb.append("numberOfParticipants=[");
	        sb.append(numberOfParticipants.getValue());
	        sb.append("]");
        }
        
        if(participantActionType!=null && participantActionType.getType()!=null)
        {
	        sb.append("participantActionType=[");
	        sb.append(participantActionType.getType());
	        sb.append("]");
        }
        
        if(cugInformation!=null && cugInformation.getValue()!=null)
        {
	        sb.append("cugInformation=[");
	        sb.append(cugInformation.printDataArr());
	        sb.append("]");
        }
        
        if(aocInformation!=null && aocInformation.getAoCInformation()!=null)
        {
	        sb.append("aocInformation=[");
	        Boolean isFirst=true;
	        for(AoCInformation curr:aocInformation.getAoCInformation()) 
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        	isFirst=false;
	        }
	        
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}