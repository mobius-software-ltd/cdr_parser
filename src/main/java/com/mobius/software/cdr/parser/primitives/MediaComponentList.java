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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNNull;
/*
Media-Components-List ::= SEQUENCE
--
-- MediaInitiatorParty is used to identify the initiator of the media
-- multi-participants session e.g. in AS PoC Server
--
{
 sIP-Request-Timestamp [0] TimeStamp OPTIONAL,
 sIP-Response-Timestamp [1] TimeStamp OPTIONAL,
 sDP-Media-Components [2] SEQUENCE OF SDP-Media-Component OPTIONAL,
 mediaInitiatorFlag [3] NULL OPTIONAL,
 sDP-Session-Description [4] SEQUENCE OF GraphicString OPTIONAL,
 mediaInitiatorParty [5] InvolvedParty OPTIONAL,
 sIP-Request-Timestamp-Fraction [6] Milliseconds OPTIONAL,
 sIP-Response-Timestamp-Fraction [7] Milliseconds OPTIONAL,
 sDP-Type [8] SDP-Type OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class MediaComponentList 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private TimeStamp sipRequestTimestamp;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private TimeStamp sipResponseTimestamp;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = true,index = -1)
	private SDPMediaComponentListWrapper sdpMediaComponents;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNNull mediaInitiatorFlag;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = true,index = -1)
	private List<ASNGraphicString>  sdpSessionDescription;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = true,index = -1)
	private InvolvedPartyWrapper mediaInitiatorParty;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private ASNInteger sipRequestTimestampFraction;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private ASNInteger sipResponseTimestampFraction;
	
	public MediaComponentList()
	{
		
	}
	
	public MediaComponentList(TimeStamp sipRequestTimestamp,TimeStamp sipResponseTimestamp,List<SDPMediaComponent> sdpMediaComponents,boolean mediaInitiatorFlag,List<String> sdpSessionDescription,InvolvedParty mediaInitiatorParty,Integer sipRequestTimestampFraction,Integer sipResponseTimestampFraction)
	{
		this.sipRequestTimestamp=sipRequestTimestamp;
		this.sipResponseTimestamp=sipRequestTimestamp;
		
		if(sdpMediaComponents!=null)
			this.sdpMediaComponents=new SDPMediaComponentListWrapper(sdpMediaComponents);
		
		if(mediaInitiatorFlag)
			this.mediaInitiatorFlag=new ASNNull();
		
		if(sdpSessionDescription!=null)
		{
			this.sdpSessionDescription=new ArrayList<ASNGraphicString>();
			for(String curr:sdpSessionDescription) {
				ASNGraphicString currString=new ASNGraphicString(curr,null,null,null,false);
				this.sdpSessionDescription.add(currString);
			}
		}
		
		if(mediaInitiatorParty!=null)
			this.mediaInitiatorParty=new InvolvedPartyWrapper(mediaInitiatorParty);
		
		if(sipRequestTimestampFraction!=null)
			this.sipRequestTimestampFraction=new ASNInteger(sipRequestTimestampFraction.longValue(),null,null,null,false);
		
		if(sipResponseTimestampFraction!=null)
			this.sipResponseTimestampFraction=new ASNInteger(sipResponseTimestampFraction.longValue(),null,null,null,false);	
	}

	public TimeStamp getSIPResponseTimestamp() 
	{
		return sipResponseTimestamp;
	}

	public TimeStamp getSIPRequestTimestamp() 
	{
		return sipRequestTimestamp;
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

	public InvolvedParty getMediaInitiatorParty() 
	{
		if(mediaInitiatorParty==null || mediaInitiatorParty.getInvolvedParty()==null)
			return null;
		
		return mediaInitiatorParty.getInvolvedParty();
	}

	public Integer getSIPRequestTimestampFraction() 
	{
		if(sipRequestTimestampFraction==null || sipRequestTimestampFraction.getValue()==null)
			return null;
		
		return sipRequestTimestampFraction.getValue().intValue();
	}

	public Integer getSIPResponseTimestampFraction() 
	{
		if(sipResponseTimestampFraction==null || sipResponseTimestampFraction.getValue()==null)
			return null;
		
		return sipResponseTimestampFraction.getValue().intValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MediaComponentList");
        sb.append(" [");

        if(sipRequestTimestamp!=null)
        {
	        sb.append("sipRequestTimestamp=[");
	        sb.append(sipRequestTimestamp.getValue());
	        sb.append("]");
        }
        
        if(sipResponseTimestamp!=null)
        {
	        sb.append("sipResponseTimestamp=[");
	        sb.append(sipResponseTimestamp.getValue());
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
        
        if(mediaInitiatorParty!=null && mediaInitiatorParty.getInvolvedParty()!=null)
        {
	        sb.append("mediaInitiatorParty=[");
	        sb.append(mediaInitiatorParty.getInvolvedParty());
	        sb.append("]");
        } 
        
        if(sipRequestTimestampFraction!=null && sipRequestTimestampFraction.getValue()!=null)
        {
	        sb.append("sipRequestTimestampFraction=[");
	        sb.append(sipRequestTimestampFraction.getValue());
	        sb.append("]");
        }
        
        if(sipResponseTimestampFraction!=null && sipResponseTimestampFraction.getValue()!=null)
        {
	        sb.append("sipResponseTimestampFraction=[");
	        sb.append(sipResponseTimestampFraction.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}