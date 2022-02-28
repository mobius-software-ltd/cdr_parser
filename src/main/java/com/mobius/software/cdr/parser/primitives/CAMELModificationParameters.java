package com.mobius.software.cdr.parser.primitives;
import java.util.List;

import org.restcomm.protocols.ss7.commonapp.isup.CallingPartysCategoryIsupImpl;
import org.restcomm.protocols.ss7.commonapp.primitives.AddressStringImpl;

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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
/*
CAMELModificationParameters ::= SET
--
-- The list contains only parameters changed due to CAMEL call handling.
--
{
 callingPartyNumber [0] CallingNumber OPTIONAL,
 callingPartyCategory [1] CallingPartyCategory OPTIONAL,
 originalCalledPartyNumber [2] OriginalCalledNumber OPTIONAL,
 genericNumbers [3] GenericNumbers OPTIONAL,
 redirectingPartyNumber [4] RedirectingNumber OPTIONAL,
 redirectionCounter [5] NumberOfForwarding OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class CAMELModificationParameters 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private AddressStringImpl callingPartyNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private CallingPartysCategoryIsupImpl callingPartyCategory;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private AddressStringImpl originalCalledPartyNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = true,index = -1)
	private AddressFieldListWrapper genericNumbers;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private AddressStringImpl redirectingPartyNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private ASNInteger redirectionCounter;
	
	public CAMELModificationParameters(AddressStringImpl callingPartyNumber,CallingPartysCategoryIsupImpl callingPartyCategory,AddressStringImpl originalCalledPartyNumber,List<AddressStringImpl> genericNumbers,AddressStringImpl redirectingPartyNumber,Integer redirectionCounter)
	{
		this.callingPartyNumber=callingPartyNumber;
		this.callingPartyCategory=callingPartyCategory;
		this.originalCalledPartyNumber=originalCalledPartyNumber;
		
		if(genericNumbers!=null)
			this.genericNumbers=new AddressFieldListWrapper(genericNumbers);
		
		this.redirectingPartyNumber=redirectingPartyNumber;
		if(redirectionCounter!=null)
			this.redirectionCounter=new ASNInteger(redirectionCounter.longValue(),null,null,null,false);		
	}

	public AddressStringImpl getCallingPartyNumber() 
	{
		return callingPartyNumber;
	}
	
	public CallingPartysCategoryIsupImpl getCallingPartyCategory() 
	{
		return callingPartyCategory;
	}

	public AddressStringImpl getOriginalCalledPartyNumber() 
	{
		return originalCalledPartyNumber;
	}

	public List<AddressStringImpl> getGenericNumbers() 
	{
		if(genericNumbers==null)
			return null;
		
		return genericNumbers.getAddressFieldImpl();
	}

	public AddressStringImpl getRedirectingPartyNumber() 
	{
		return redirectingPartyNumber;
	}

	public Integer getRedirectionCounter() 
	{
		if(redirectionCounter==null || redirectionCounter.getValue()==null)
			return null;
		
		return redirectionCounter.getValue().intValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CAMELModificationParameters");
        sb.append(" [");

        if(callingPartyNumber!=null)
        {
	        sb.append("callingPartyNumber=[");
	        sb.append(callingPartyNumber);
	        sb.append("]");
        }
        
        if(callingPartyCategory!=null)
        {
	        sb.append("callingPartyCategory=[");
	        sb.append(callingPartyCategory);
	        sb.append("]");
        }
        
        if(originalCalledPartyNumber!=null)
        {
	        sb.append("originalCalledPartyNumber=[");
	        sb.append(originalCalledPartyNumber);
	        sb.append("]");
        }
        
        if(genericNumbers!=null && genericNumbers.getAddressFieldImpl()!=null)
        {
	        sb.append(", genericNumbers=[");
	        int index=0;
	        for(AddressStringImpl curr:genericNumbers.getAddressFieldImpl())
	        {
	        	if(index!=0)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        	index++;
	        }
	        
	        sb.append("]");
        }
        
        if(redirectingPartyNumber!=null)
        {
	        sb.append("redirectingPartyNumber=[");
	        sb.append(redirectingPartyNumber);
	        sb.append("]");
        }
        
        if(redirectionCounter!=null && redirectionCounter.getValue()!=null)
        {
	        sb.append("redirectionCounter=[");
	        sb.append(redirectionCounter.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}