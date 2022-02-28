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
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNChoise;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNBoolean;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNGraphicString;
/*
SDP-Media-Component ::= SEQUENCE
{
 sDP-Media-Name [0] GraphicString OPTIONAL,
 sDP-Media-Descriptions [1] SDP-Media-Description OPTIONAL,
 accessCorrelationID AccessCorrelationID OPTIONAL, -- not used in MGCF
 -- [2] is used by gPRS-Charging-Id
 -- [4] is used by accessNetworkChargingIdentifier
 localGWInsertedIndication [5] BOOLEAN OPTIONAL,
 iPRealmDefaultIndication [6] BOOLEAN OPTIONAL,
 transcoderInsertedIndication [7] BOOLEAN OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class SDPMediaComponent 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNGraphicString sdpMediaName;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = true,index = -1)
	private List<ASNGraphicString> sdpMediaDescription;
	
	@ASNChoise
	private AccessCorrelationID accessCorrelationID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private ASNBoolean localGWInsertedIndication;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private ASNBoolean ipRealmDefaultIndication;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private ASNBoolean transcoderInsertedIndication;
	
	public SDPMediaComponent()
	{
		
	}
	
	public SDPMediaComponent(String sdpMediaName,List<String> sdpMediaDescription,AccessCorrelationID accessCorrelationID,Boolean localGWInsertedIndication,Boolean ipRealmDefaultIndication,Boolean transcoderInsertedIndication)
	{
		if(sdpMediaName!=null)
			this.sdpMediaName=new ASNGraphicString(sdpMediaName,null,null,null,false);
		
		if(sdpMediaDescription!=null)
		{
			this.sdpMediaDescription=new ArrayList<ASNGraphicString>();
			for(String curr:sdpMediaDescription) {
				ASNGraphicString currString=new ASNGraphicString(curr,null,null,null,false);
				this.sdpMediaDescription.add(currString);
			}
		}
		
		this.accessCorrelationID=accessCorrelationID;
		
		if(localGWInsertedIndication!=null)
			this.localGWInsertedIndication=new ASNBoolean(localGWInsertedIndication,null,false,false);
		
		if(ipRealmDefaultIndication!=null)
			this.ipRealmDefaultIndication=new ASNBoolean(ipRealmDefaultIndication,null,false,false);
		
		if(transcoderInsertedIndication!=null)
			this.transcoderInsertedIndication=new ASNBoolean(transcoderInsertedIndication,null,false,false);
	}

	public String getSDPMediaName() 
	{
		if(sdpMediaName==null || sdpMediaName.getValue()==null)
			return null;
		
		return sdpMediaName.getValue();
	}

	public List<String> getSDPMediaDescription() 
	{
		if(sdpMediaDescription==null || sdpMediaDescription.size()==0)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(ASNGraphicString curr:sdpMediaDescription)
			result.add(curr.getValue());
		
		return result;
	}

	public AccessCorrelationID getAccessCorrelationID() 
	{
		return accessCorrelationID;
	}

	public Boolean getLocalGWInsertedIndication() 
	{
		if(localGWInsertedIndication==null || localGWInsertedIndication.getValue()==null)
			return null;
		
		return localGWInsertedIndication.getValue();
	}

	public Boolean getIPRealmDefaultIndication() 
	{
		if(ipRealmDefaultIndication==null || ipRealmDefaultIndication.getValue()==null)
			return null;
		
		return ipRealmDefaultIndication.getValue();
	}

	public Boolean getTranscoderInsertedIndication() 
	{
		if(transcoderInsertedIndication==null || transcoderInsertedIndication.getValue()==null)
			return null;
		
		return transcoderInsertedIndication.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SDPMediaComponent");
        sb.append(" [");

        if(sdpMediaName!=null && sdpMediaName.getValue()!=null)
        {
	        sb.append("sdpMediaName=[");
	        sb.append(sdpMediaName.getValue());
	        sb.append("]");
        }
        
        if(sdpMediaDescription!=null && sdpMediaDescription.size()>0)
        {
	        sb.append("sdpMediaDescription=[");
	        Boolean first=true;
	        for(ASNGraphicString curr:sdpMediaDescription) {
	        	if(!first)
	        		sb.append(",");
	        	
	        	sb.append(curr.getValue());
	        	first=false;
	        }
	        
	        sb.append("]");
        }
        
        if(accessCorrelationID!=null)
        {
	        sb.append("accessCorrelationID=[");
	        sb.append(accessCorrelationID);
	        sb.append("]");
        } 
        
        if(localGWInsertedIndication!=null && localGWInsertedIndication.getValue()!=null)
        {
	        sb.append("localGWInsertedIndication=[");
	        sb.append(localGWInsertedIndication.getValue());
	        sb.append("]");
        }
        
        if(ipRealmDefaultIndication!=null && ipRealmDefaultIndication.getValue()!=null)
        {
	        sb.append("ipRealmDefaultIndication=[");
	        sb.append(ipRealmDefaultIndication.getValue());
	        sb.append("]");
        }
        
        if(transcoderInsertedIndication!=null && transcoderInsertedIndication.getValue()!=null)
        {
	        sb.append("transcoderInsertedIndication=[");
	        sb.append(transcoderInsertedIndication.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}