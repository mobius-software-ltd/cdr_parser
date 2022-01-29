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
RealTimeTariffInformation ::= CHOICE
{
 tariffInformation [0] TariffInformation,
 tariffXml [1] UTF8String
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class RealTimeTariffInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private TariffInformation tariffInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNUTF8String tariffXml;
	
	public RealTimeTariffInformation(TariffInformation tariffInformation,String tariffXml)
	{
		this.tariffInformation=tariffInformation;
		
		if(tariffXml!=null)
			this.tariffXml=new ASNUTF8String(tariffXml);		
	}

	public TariffInformation getTariffInformation() 
	{
		return tariffInformation;
	}

	public String getTariffXml() 
	{
		if(tariffXml==null)
			return null;
		
		return tariffXml.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RealTimeTariffInformation");
        sb.append(" [");

        if(tariffInformation!=null)
        {
	        sb.append("tariffInformation=[");
	        sb.append(tariffInformation);
	        sb.append("]");
        }
        
        if(tariffXml!=null && tariffXml.getValue()!=null)
        {
        	sb.append("tariffXml=[");
	        sb.append(tariffXml.getValue());
	        sb.append("]");
        }
        
        sb.append("]");
        return sb.toString();
    }
}