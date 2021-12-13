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
/*
AoCInformation ::= SET
{
 tariffInformation [0] TariffInformation OPTIONAL,
 aoCCostInformation [1] AoCCostInformation OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class AoCInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = true,index = -1)
	private TariffInformation tariffInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = true,index = -1)
	private AoCCostInformation aoCCostInformation;
	
	public AoCInformation(TariffInformation tariffInformation,AoCCostInformation aoCCostInformation)
	{
		this.tariffInformation=tariffInformation;
		this.aoCCostInformation=aoCCostInformation;
	}

	public TariffInformation getTariffInformation() 
	{
		return tariffInformation;
	}

	public AoCCostInformation getAoCCostInformation() 
	{
		return aoCCostInformation;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AoCInformation");
        sb.append(" [");

        if(tariffInformation!=null)
        {
	        sb.append("tariffInformation=[");
	        sb.append(tariffInformation);
	        sb.append("]");
        }
        
        if(aoCCostInformation!=null)
        {
        	sb.append("aoCCostInformation=[");
	        sb.append(aoCCostInformation);
	        sb.append("]");
        }
        
        sb.append("]");
        return sb.toString();
    }
}