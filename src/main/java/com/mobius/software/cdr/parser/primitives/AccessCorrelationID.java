package com.mobius.software.cdr.parser.primitives;

import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNGraphicString;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;

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
/*
AccessCorrelationID ::= CHOICE
--
-- gPRS-Charging-Id is used for GPRS, EPS and 5GS
--
{
 gPRS-Charging-Id [2] INTEGER (0..4294967295),
 accessNetworkChargingIdentifier [4] GraphicString
} 
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class AccessCorrelationID 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNInteger gprsChargingId;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNGraphicString accessNetworkChargingIdentifier;
	
	public AccessCorrelationID(Integer gprsChargingId,String accessNetworkChargingIdentifier)
	{
		if(gprsChargingId!=null)
			this.gprsChargingId=new ASNInteger(gprsChargingId.longValue());
		
		if(accessNetworkChargingIdentifier!=null)
			this.accessNetworkChargingIdentifier=new ASNGraphicString(accessNetworkChargingIdentifier);		
	}

	public Integer getGPRSChargingId() 
	{
		if(gprsChargingId==null || gprsChargingId.getValue()==null)
			return null;
		
		return gprsChargingId.getValue().intValue();
	}

	public String getAccessNetworkChargingIdentifier() 
	{
		if(accessNetworkChargingIdentifier==null)
			return null;
		
		return accessNetworkChargingIdentifier.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AccessCorrelationID");
        sb.append(" [");

        if(gprsChargingId!=null && gprsChargingId.getValue()!=null)
        {
	        sb.append("gprsChargingId=[");
	        sb.append(gprsChargingId.getValue());
	        sb.append("]");
        }
        
        if(accessNetworkChargingIdentifier!=null && accessNetworkChargingIdentifier.getValue()!=null)
        {
	        sb.append("accessNetworkChargingIdentifier=[");
	        sb.append(accessNetworkChargingIdentifier.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}