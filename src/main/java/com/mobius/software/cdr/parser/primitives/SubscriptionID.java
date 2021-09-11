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
subscriptionIDType [0] SubscriptionIDType,
subscriptionIDData [1] UTF8String
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class SubscriptionID 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNSubscriptionIDType subscriptionIDType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNUTF8String subscriptionIDData;
	
	public SubscriptionID(SubscriptionIDType subscriptionIDType,String subscriptionIDData)
	{
		if(subscriptionIDType!=null)
		{
			this.subscriptionIDType=new ASNSubscriptionIDType();
			this.subscriptionIDType.setType(subscriptionIDType);
		}
		
		if(subscriptionIDData!=null)
		{
			this.subscriptionIDData=new ASNUTF8String();
			this.subscriptionIDData.setValue(subscriptionIDData);
		}
	}

	public SubscriptionIDType getSubscriptionIDType() 
	{
		if(subscriptionIDType==null)
			return null;
		
		return subscriptionIDType.getType();
	}

	public String getSubscriptionIDData() 
	{
		if(subscriptionIDData==null)
			return null;
		
		return subscriptionIDData.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SubscriptionID");
        sb.append(" [");
        
        if(subscriptionIDType!=null && subscriptionIDType.getValue()!=null)
        {
	        sb.append(", subscriptionIDType=[");
	        sb.append(this.subscriptionIDType.getType());
	        sb.append("]");
        }
        
        if(subscriptionIDData!=null && subscriptionIDData.getValue()!=null)
        {
	        sb.append(", subscriptionIDData=[");
	        sb.append(this.subscriptionIDData.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}