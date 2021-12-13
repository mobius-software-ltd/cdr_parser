package com.mobius.software.cdr.parser.primitives;
import java.util.ArrayList;
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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNNull;
/*
Early-Media-Components-List ::= SEQUENCE
{
 sDP-Offer-Timestamp [0] TimeStamp OPTIONAL,
 sDP-Answer-Timestamp [1] TimeStamp OPTIONAL,
 sDP-Media-Components [2] SEQUENCE OF SDP-Media-Component OPTIONAL,
 mediaInitiatorFlag [3] NULL OPTIONAL,
 sDP-Session-Description [4] SEQUENCE OF GraphicString OPTIONAL,
 sDP-Type [5] SDP-Type OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class EarlyMediaComponentList 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private TimeStamp sdpOfferTimestamp;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private TimeStamp sdpAnswerTimestamp;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = true,index = -1)
	private SDPMediaComponentListWrapper sdpMediaComponents;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNNull mediaInitiatorFlag;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private List<ASNGraphicString>  sdpSessionDescription;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private ASNSDPType sdpType;	
	
	public EarlyMediaComponentList(TimeStamp sdpOfferTimestamp,TimeStamp sdpAnswerTimestamp,List<SDPMediaComponent> sdpMediaComponents,boolean mediaInitiatorFlag,List<String> sdpSessionDescription,SDPType sdpType)
	{
		this.sdpOfferTimestamp=sdpOfferTimestamp;
		this.sdpAnswerTimestamp=sdpOfferTimestamp;
		
		if(sdpMediaComponents!=null)
			this.sdpMediaComponents=new SDPMediaComponentListWrapper(sdpMediaComponents);
		
		if(mediaInitiatorFlag)
			this.mediaInitiatorFlag=new ASNNull();
		
		if(sdpSessionDescription!=null)
		{
			this.sdpSessionDescription=new ArrayList<ASNGraphicString>();
			for(String curr:sdpSessionDescription) {
				ASNGraphicString currString=new ASNGraphicString();
				currString.setValue(curr);
				this.sdpSessionDescription.add(currString);
			}
		}
		
		if(sdpType!=null)
		{
			this.sdpType=new ASNSDPType();
			this.sdpType.setType(sdpType);
		}
	}

	public TimeStamp getSDPAnswerTimestamp() 
	{
		return sdpAnswerTimestamp;
	}

	public TimeStamp getSDPOfferTimestamp() 
	{
		return sdpOfferTimestamp;
	}

	public List<SDPMediaComponent> getSDPMediaComponents() 
	{
		if(sdpMediaComponents==null)
			return null;
		
		return sdpMediaComponents.getMediaComponentList();	
	}

	public Boolean getMediaInitiatorFlag() 
	{
		return mediaInitiatorFlag!=null;
	}

	public List<String> getSDPSessionDescription() 
	{
		if(sdpSessionDescription==null || sdpSessionDescription.size()==0)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(ASNGraphicString curr:sdpSessionDescription)
			result.add(curr.getValue());
		
		return result;
	}

	public SDPType getSDPType() 
	{
		if(sdpType==null || sdpType.getType()==null)
			return null;
		
		return sdpType.getType();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EarlyMediaComponentList");
        sb.append(" [");

        if(sdpOfferTimestamp!=null)
        {
	        sb.append("sdpOfferTimestamp=[");
	        sb.append(sdpOfferTimestamp.getValue());
	        sb.append("]");
        }
        
        if(sdpAnswerTimestamp!=null)
        {
	        sb.append("sdpAnswerTimestamp=[");
	        sb.append(sdpAnswerTimestamp.getValue());
	        sb.append("]");
        }
        
        if(sdpMediaComponents!=null && sdpMediaComponents.getMediaComponentList()!=null)
        {
	        sb.append("sdpMediaComponents=[");
	        Boolean first=true;
	        for(SDPMediaComponent curr:sdpMediaComponents.getMediaComponentList()) {
	        	if(!first)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        	first=false;
	        }
	        
	        sb.append("]");
        }
        
        if(mediaInitiatorFlag!=null)
        {
	        sb.append("mediaInitiatorFlag=[yes]");	        
        }
        
        if(sdpSessionDescription!=null && sdpSessionDescription.size()>0)
        {
	        sb.append("sdpSessionDescription=[");
	        Boolean first=true;
	        for(ASNGraphicString curr:sdpSessionDescription) {
	        	if(!first)
	        		sb.append(",");
	        	
	        	sb.append(curr.getValue());
	        	first=false;
	        }
	        
	        sb.append("]");
        }
        
        if(sdpType!=null && sdpType.getType()!=null)
        {
	        sb.append("sdpType=[");
	        sb.append(sdpType.getType());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}