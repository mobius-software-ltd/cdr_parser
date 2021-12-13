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
RateElement ::= SEQUENCE
{
 unitType [0] INTEGER,
 unitValue [1] REAL,
 unitCost [2] REAL,
 unitQuotaThreshold [3] REAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class RateElement 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNInteger unitType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNReal unitValue;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNReal unitCost;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNReal unitQuotaThreshold;
	
	public RateElement(Integer unitType,Double unitValue,Double unitCost,Double unitQuotaThreshold)
	{
		if(unitType!=null) {
			this.unitType=new ASNInteger();
			this.unitType.setValue(unitType.longValue());
		}
		
		if(unitValue!=null) {
			this.unitValue=new ASNReal();
			this.unitValue.setValue(unitValue);
		}
		
		if(unitCost!=null) {
			this.unitCost=new ASNReal();
			this.unitCost.setValue(unitCost);
		}
		
		if(unitQuotaThreshold!=null) {
			this.unitQuotaThreshold=new ASNReal();
			this.unitQuotaThreshold.setValue(unitQuotaThreshold);
		}
	}

	public Integer getUnitType() 
	{
		if(unitType==null)
			return null;
		
		return unitType.getValue().intValue();
	}

	public Double getUnitValue() 
	{
		if(unitValue==null)
			return null;
		
		return unitValue.getValue();
	}

	public Double getUnitCost() 
	{
		if(unitCost==null)
			return null;
		
		return unitCost.getValue();
	}

	public Double getUnitQuotaThreshold() 
	{
		if(unitQuotaThreshold==null)
			return null;
		
		return unitQuotaThreshold.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RateElement");
        sb.append(" [");

        if(unitType!=null && unitType.getValue()!=null)
        {
	        sb.append("unitType=[");
	        sb.append(unitType.getValue());
	        sb.append("]");
        }
        
        if(unitValue!=null && unitValue.getValue()!=null)
        {
        	sb.append("unitValue=[");
	        sb.append(unitValue.getValue());
	        sb.append("]");
        }
        
        if(unitCost!=null && unitCost.getValue()!=null)
        {
	        sb.append("unitCost=[");
	        sb.append(unitCost.getValue());
	        sb.append("]");
        }
        
        if(unitQuotaThreshold!=null && unitQuotaThreshold.getValue()!=null)
        {
	        sb.append("unitQuotaThreshold=[");
	        sb.append(unitQuotaThreshold.getValue());
	        sb.append("]");
        }
        
        sb.append("]");
        return sb.toString();
    }
}