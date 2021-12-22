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
TrunkGroup ::= CHOICE
{
 tkgpNumber [0] INTEGER,
 tkgpName [1] GraphicString
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class TrunkGroup 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNInteger tkgpNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNGraphicString tkgpName;
	
	public TrunkGroup()
	{
		
	}
	
	public TrunkGroup(Integer tkgpNumber,String tkgpName)
	{
		if(tkgpNumber!=null)
		{
			this.tkgpNumber=new ASNInteger();
			this.tkgpNumber.setValue(tkgpNumber.longValue());
		}
		
		if(tkgpName!=null)
		{
			this.tkgpName=new ASNGraphicString();
			this.tkgpName.setValue(tkgpName);
		}
	}

	public Integer getTkgpNumber() 
	{
		if(tkgpNumber==null || tkgpNumber.getValue()==null)
			return null;
		
		return tkgpNumber.getValue().intValue();
	}

	public String getTkgpName() 
	{
		if(tkgpName==null)
			return null;
		
		return tkgpName.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TrunkGroup");
        sb.append(" [");

        if(tkgpNumber!=null && tkgpNumber.getValue()!=null)
        {
	        sb.append("tkgpNumber=[");
	        sb.append(tkgpNumber.getValue());
	        sb.append("]");
        }
        
        if(tkgpName!=null && tkgpName.getValue()!=null)
        {
	        sb.append("tkgpName=[");
	        sb.append(tkgpName.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}