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
InterOperatorIdentifiers ::= SEQUENCE
{
 originatingIOI [0] GraphicString OPTIONAL,
 terminatingIOI [1] GraphicString OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class InterOperatorIdentifiers 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNGraphicString originatingIOI;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNGraphicString terminatingIOI;
	
	public InterOperatorIdentifiers()
	{
		
	}
	
	public InterOperatorIdentifiers(String originatingIOI,String terminatingIOI)
	{
		if(originatingIOI!=null)
			this.originatingIOI=new ASNGraphicString(originatingIOI,null,null,null,false);
		
		if(terminatingIOI!=null)
			this.terminatingIOI=new ASNGraphicString(terminatingIOI,null,null,null,false);		
	}

	public String getoriginatingIOI() 
	{
		if(originatingIOI==null)
			return null;
		
		return originatingIOI.getValue();
	}

	public String getTerminatingIOI() 
	{
		if(terminatingIOI==null)
			return null;
		
		return terminatingIOI.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InterOperatorIdentifiers");
        sb.append(" [");

        if(originatingIOI!=null && originatingIOI.getValue()!=null)
        {
	        sb.append("originatingIOI=[");
	        sb.append(originatingIOI.getValue());
	        sb.append("]");
        }
        
        if(terminatingIOI!=null && terminatingIOI.getValue()!=null)
        {
	        sb.append("terminatingIOI=[");
	        sb.append(terminatingIOI.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}