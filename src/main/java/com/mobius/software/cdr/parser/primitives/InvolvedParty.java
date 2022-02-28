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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNGraphicString;
/*
InvolvedParty ::= CHOICE
{
 sIP-URI [0] GraphicString, -- refer to rfc3261 [401]
 tEL-URI [1] GraphicString, -- refer to rfc3966 [402]
 uRN [2] GraphicString, -- refer to rfc5031 [407]
 iSDN-E164 [3] GraphicString -- refer to ITU-T Recommendation E.164[308]
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class InvolvedParty 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNGraphicString sipURI;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNGraphicString telURI;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNGraphicString urn;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNGraphicString isdnE164;
	
	public InvolvedParty()
	{
		
	}
	
	public InvolvedParty(String sipURI,String telURI,String urn,String isdnE164)
	{
		if(sipURI!=null)
			this.sipURI=new ASNGraphicString(sipURI,null,null,null,false);
		
		if(telURI!=null)
			this.telURI=new ASNGraphicString(telURI,null,null,null,false);
		
		if(urn!=null)
			this.urn=new ASNGraphicString(urn,null,null,null,false);
		
		if(isdnE164!=null)
			this.isdnE164=new ASNGraphicString(isdnE164,null,null,null,false);		
	}

	public String getSipURI() 
	{
		if(sipURI==null)
			return null;
		
		return sipURI.getValue();
	}

	public String getTelURI() 
	{
		if(telURI==null)
			return null;
		
		return telURI.getValue();
	}

	public String getURN() 
	{
		if(urn==null)
			return null;
		
		return urn.getValue();
	}

	public String getISDNE164() 
	{
		if(isdnE164==null)
			return null;
		
		return isdnE164.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InvolvedParty");
        sb.append(" [");

        if(sipURI!=null && sipURI.getValue()!=null)
        {
	        sb.append("sipURI=[");
	        sb.append(sipURI.getValue());
	        sb.append("]");
        }
        
        if(telURI!=null && telURI.getValue()!=null)
        {
	        sb.append("telURI=[");
	        sb.append(telURI.getValue());
	        sb.append("]");
        }
        
        if(urn!=null && urn.getValue()!=null)
        {
	        sb.append("urn=[");
	        sb.append(urn.getValue());
	        sb.append("]");
        }
        
        if(isdnE164!=null && isdnE164.getValue()!=null)
        {
	        sb.append("isdnE164=[");
	        sb.append(isdnE164.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}