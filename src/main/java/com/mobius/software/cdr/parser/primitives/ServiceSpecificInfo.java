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
ServiceSpecificInfo ::= SEQUENCE
{
serviceSpecificData [0] GraphicString OPTIONAL,
serviceSpecificType [1] INTEGER OPTIONAL
}

 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class ServiceSpecificInfo 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNGraphicString serviceSpecificData;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNInteger serviceSpecificType;
	
	public ServiceSpecificInfo()
	{
		
	}
	
	public ServiceSpecificInfo(String serviceSpecificData,Integer serviceSpecificType)
	{
		if(serviceSpecificData!=null)
			this.serviceSpecificData=new ASNGraphicString(serviceSpecificData);
		
		if(serviceSpecificType!=null)
			this.serviceSpecificType=new ASNInteger(serviceSpecificType.longValue());		
	}

	public String getServiceSpecificData() 
	{
		if(serviceSpecificData==null)
			return null;
		
		return serviceSpecificData.getValue();
	}

	public Integer getServiceSpecificType() 
	{
		if(serviceSpecificType==null || serviceSpecificType.getValue()==null)
			return null;
		
		return serviceSpecificType.getValue().intValue();
	}
	
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceSpecificInfo");
        sb.append(" [");

        if(serviceSpecificData!=null)
        {
	        sb.append("serviceSpecificData=[");
	        sb.append(this.serviceSpecificData.getValue());
	        sb.append("]");
        }
        
        if(serviceSpecificType!=null && serviceSpecificType.getValue()!=null)
        {
	        sb.append("serviceSpecificType=[");
	        sb.append(this.serviceSpecificType.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}