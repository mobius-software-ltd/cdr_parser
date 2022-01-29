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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
/*
MessageBody ::= SEQUENCE
{
 content-Type [0] GraphicString,
 content-Disposition [1] GraphicString OPTIONAL,
 content-Length [2] INTEGER,
 originator [3] InvolvedParty OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class MessageBody 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNGraphicString contentType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNGraphicString contentDisposition;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNInteger contentLength;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = true,index = -1)
	private InvolvedPartyWrapper originator;
	
	public MessageBody(String contentType,String contentDisposition,Integer contentLength,InvolvedParty originator)
	{
		if(contentType!=null)
			this.contentType=new ASNGraphicString(contentType);
		
		if(contentDisposition!=null)
			this.contentDisposition=new ASNGraphicString(contentDisposition);
		
		if(contentLength!=null)
			this.contentLength=new ASNInteger(contentLength.longValue());
		
		if(originator!=null)
			this.originator=new InvolvedPartyWrapper(originator);			
	}

	public String getContentType() 
	{
		if(contentType==null || contentType.getValue()==null)
			return null;
		
		return contentType.getValue();
	}

	public String getContentDisposition() 
	{
		if(contentDisposition==null || contentDisposition.getValue()==null)
			return null;
		
		return contentDisposition.getValue();
	}

	public Integer getContentLength() 
	{
		if(contentLength==null || contentLength.getValue()==null)
			return null;
		
		return contentLength.getValue().intValue();
	}

	public InvolvedParty getOriginator() 
	{
		if(originator==null || originator.getInvolvedParty()==null)
			return null;
		
		return originator.getInvolvedParty();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MessageBody");
        sb.append(" [");

        if(contentType!=null && contentType.getValue()!=null)
        {
	        sb.append("contentType=[");
	        sb.append(contentType.getValue());
	        sb.append("]");
        }
        
        if(contentDisposition!=null && contentDisposition.getValue()!=null)
        {
	        sb.append("contentDisposition=[");
	        sb.append(contentDisposition.getValue());
	        sb.append("]");
        }
        
        if(contentLength!=null && contentLength.getValue()!=null)
        {
	        sb.append("contentLength=[");
	        sb.append(contentLength.getValue());
	        sb.append("]");
        }
        
        if(originator!=null && originator.getInvolvedParty()!=null)
        {
	        sb.append("originator=[");
	        sb.append(originator.getInvolvedParty());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}