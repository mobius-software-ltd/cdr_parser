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
TrunkGroupID ::= CHOICE
{
 incoming [0] GraphicString,
 outgoing [1] GraphicString
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class TrunkGroupID 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNGraphicString incoming;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNGraphicString outgoing;
	
	public TrunkGroupID(String incoming,String outgoing)
	{
		if(incoming!=null)
		{
			this.incoming=new ASNGraphicString();
			this.incoming.setValue(incoming);
		}
		
		if(outgoing!=null)
		{
			this.outgoing=new ASNGraphicString();
			this.outgoing.setValue(outgoing);
		}
	}

	public String getIncoming() 
	{
		if(incoming==null)
			return null;
		
		return incoming.getValue();
	}

	public String getOutgoing() 
	{
		if(outgoing==null)
			return null;
		
		return outgoing.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TrunkGroupID");
        sb.append(" [");

        if(incoming!=null && incoming.getValue()!=null)
        {
	        sb.append("incoming=[");
	        sb.append(incoming.getValue());
	        sb.append("]");
        }
        
        if(outgoing!=null && outgoing.getValue()!=null)
        {
	        sb.append("outgoing=[");
	        sb.append(outgoing.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}