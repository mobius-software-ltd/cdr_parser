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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNUTF8String;

/*
 SubscriptionID ::= SET
{
privateUserEquipmentInfoType [0] PrivateUserEquipmentInfoType,
PrivateUserEquipmentInfoValue [1] UTF8String
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class PrivateUserEquipmentInfo 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNPrivateUserEquipmentInfoType privateUserEquipmentInfoType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNUTF8String privateUserEquipmentInfoValue;
	
	public PrivateUserEquipmentInfo()
	{
		
	}
	
	public PrivateUserEquipmentInfo(PrivateUserEquipmentInfoType privateUserEquipmentInfoType,String privateUserEquipmentInfoValue)
	{
		if(privateUserEquipmentInfoType!=null)
			this.privateUserEquipmentInfoType=new ASNPrivateUserEquipmentInfoType(privateUserEquipmentInfoType);
		
		if(privateUserEquipmentInfoValue!=null)
			this.privateUserEquipmentInfoValue=new ASNUTF8String(privateUserEquipmentInfoValue,null,null,null,false);
	}

	public PrivateUserEquipmentInfoType getPrivateUserEquipmentInfoType() 
	{
		if(privateUserEquipmentInfoType==null)
			return null;
		
		return privateUserEquipmentInfoType.getType();
	}

	public String getPrivateUserEquipmentInfoValue() 
	{
		if(privateUserEquipmentInfoValue==null)
			return null;
		
		return privateUserEquipmentInfoValue.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrivateUserEquipmentInfo");
        sb.append(" [");
        
        if(privateUserEquipmentInfoType!=null && privateUserEquipmentInfoType.getValue()!=null)
        {
	        sb.append(", privateUserEquipmentInfoType=[");
	        sb.append(this.privateUserEquipmentInfoType.getType());
	        sb.append("]");
        }
        
        if(privateUserEquipmentInfoValue!=null && privateUserEquipmentInfoValue.getValue()!=null)
        {
	        sb.append(", privateUserEquipmentInfoValue=[");
	        sb.append(this.privateUserEquipmentInfoValue.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}