package com.mobius.software.cdr.parser.primitives;
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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNReal;
/*
TariffInformation ::= SEQUENCE
{
 currencyCode [0] INTEGER,
 scaleFactor [1] REAL,
 rateElements [2] SEQUENCE OF RateElement OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class TariffInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNInteger currencyCode;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNReal scaleFactor;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private List<RateElement> rateElements;
	
	public TariffInformation(Integer currencyCode,Double scaleFactor,List<RateElement> rateElements)
	{
		if(currencyCode!=null)
			this.currencyCode=new ASNInteger(currencyCode.longValue(),null,null,null,false);
		
		if(scaleFactor!=null)
			this.scaleFactor=new ASNReal(scaleFactor,null,null,null,false);		
		
		this.rateElements=rateElements;			
	}

	public Integer getCurrencyCode() 
	{
		if(currencyCode==null)
			return null;
		
		return currencyCode.getValue().intValue();
	}

	public Double getScaleFactor() 
	{
		if(scaleFactor==null)
			return null;
		
		return scaleFactor.getValue();
	}

	public List<RateElement> getRateElements() 
	{
		return rateElements;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TariffInformation");
        sb.append(" [");

        if(currencyCode!=null && currencyCode.getValue()!=null)
        {
	        sb.append("currencyCode=[");
	        sb.append(currencyCode.getValue());
	        sb.append("]");
        }
        
        if(scaleFactor!=null && scaleFactor.getValue()!=null)
        {
	        sb.append("scaleFactor=[");
	        sb.append(scaleFactor.getValue());
	        sb.append("]");
        }
        
        if(rateElements!=null)
        {
	        sb.append("rateElements=[");
	        Boolean first=true;
	        for(RateElement currElement:rateElements) {
	        	if(!first)
	        		sb.append(",");
	        	
	        	sb.append(currElement);	        	
	        }
	        sb.append("]");
        }
        
        sb.append("]");
        return sb.toString();
    }
}