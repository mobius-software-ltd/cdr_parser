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
/*
S-CSCF-Information ::= SEQUENCE
{
 mandatoryCapabilities [0] SEQUENCE OF GraphicString OPTIONAL,
 optionalCapabilities [1] SEQUENCE OF GraphicString OPTIONAL,
 serverName [2] GraphicString OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class SCSCFInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private List<ASNGraphicString> mandatoryCapabilities;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private List<ASNGraphicString> optionalCapabilities;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNGraphicString serverName;
	
	public SCSCFInformation(List<String> mandatoryCapabilities,List<String> optionalCapabilities,String serverName)
	{
		if(mandatoryCapabilities!=null)
		{
			this.mandatoryCapabilities=new ArrayList<ASNGraphicString>();
			for(String curr:mandatoryCapabilities)
			{
				ASNGraphicString currStr=new ASNGraphicString();
				currStr.setValue(curr);
				this.mandatoryCapabilities.add(currStr);
			}
		}
		
		if(optionalCapabilities!=null)
		{
			this.optionalCapabilities=new ArrayList<ASNGraphicString>();
			for(String curr:optionalCapabilities)
			{
				ASNGraphicString currStr=new ASNGraphicString();
				currStr.setValue(curr);
				this.optionalCapabilities.add(currStr);
			}
		}
		
		if(serverName!=null)
		{
			this.serverName=new ASNGraphicString();
			this.serverName.setValue(serverName);
		}
	}

	public List<String> getMandatoryCapabilities() 
	{
		if(mandatoryCapabilities==null)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(ASNGraphicString curr:mandatoryCapabilities)
			result.add(curr.getValue());
		
		return result;
	}

	public List<String> getOptionalCapabilities() 
	{
		if(optionalCapabilities==null)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(ASNGraphicString curr:optionalCapabilities)
			result.add(curr.getValue());
		
		return result;
	}

	public String getServerName() 
	{
		if(serverName==null)
			return null;
		
		return serverName.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SCSCFInformation");
        sb.append(" [");

        if(mandatoryCapabilities!=null)
        {
	        sb.append("mandatoryCapabilities=[");
	        Boolean first=true;
	        for(ASNGraphicString currCapability:mandatoryCapabilities) {
	        	if(!first)
	        		sb.append(",");
	        	
	        	sb.append(currCapability.getValue());	        	
	        }
	        sb.append("]");
        }
        
        if(optionalCapabilities!=null)
        {
	        sb.append("optionalCapabilities=[");
	        Boolean first=true;
	        for(ASNGraphicString currCapability:optionalCapabilities) {
	        	if(!first)
	        		sb.append(",");
	        	
	        	sb.append(currCapability.getValue());	        	
	        }
	        sb.append("]");
        }
        
        if(serverName!=null && serverName.getValue()!=null)
        {
	        sb.append("serverName=[");
	        sb.append(serverName.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}