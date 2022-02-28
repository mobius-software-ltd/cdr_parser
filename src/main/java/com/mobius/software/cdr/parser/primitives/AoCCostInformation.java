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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNReal;
/*
AoCCostInformation ::= SEQUENCE
{
 accumulatedCost [0] REAL,
 incrementalCost [1] REAL,
 currencyCode [2] INTEGER
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class AoCCostInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNReal accumulatedCost;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNReal incrementalCost;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNInteger currencyCode;
	
	public AoCCostInformation(Double accumulatedCost,Double incrementalCost,Integer currencyCode)
	{
		if(accumulatedCost!=null)
			this.accumulatedCost=new ASNReal(accumulatedCost,null,null,null,false);
		
		if(incrementalCost!=null)
			this.incrementalCost=new ASNReal(incrementalCost,null,null,null,false);
		
		if(currencyCode!=null)
			this.currencyCode=new ASNInteger(currencyCode.longValue(),null,null,null,false);		
	}

	public Double getAccumulatedCost() 
	{
		if(accumulatedCost==null)
			return null;
		
		return accumulatedCost.getValue();
	}

	public Double getIncrementalCost() 
	{
		if(incrementalCost==null)
			return null;
		
		return incrementalCost.getValue();
	}

	public Integer getCurrencyCode() 
	{
		if(currencyCode==null)
			return null;
		
		return currencyCode.getValue().intValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AoCCostInformation");
        sb.append(" [");

        if(accumulatedCost!=null && accumulatedCost.getValue()!=null)
        {
	        sb.append("accumulatedCost=[");
	        sb.append(accumulatedCost.getValue());
	        sb.append("]");
        }
        
        if(incrementalCost!=null && incrementalCost.getValue()!=null)
        {
        	sb.append("incrementalCost=[");
	        sb.append(incrementalCost.getValue());
	        sb.append("]");
        }
        
        if(currencyCode!=null && currencyCode.getValue()!=null)
        {
	        sb.append("currencyCode=[");
	        sb.append(currencyCode.getValue());
	        sb.append("]");
        }
        
        sb.append("]");
        return sb.toString();
    }
}