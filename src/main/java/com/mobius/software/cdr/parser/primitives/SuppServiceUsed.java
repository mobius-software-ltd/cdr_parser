package com.mobius.software.cdr.parser.primitives;
import org.restcomm.protocols.ss7.map.api.service.supplementary.SSCodeImpl;

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
SuppServiceUsed ::= SEQUENCE
{
 ssCode [0] SS-Code,
 ssTime [1] TimeStamp OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class SuppServiceUsed 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private SSCodeImpl ssCode;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private TimeStamp ssTime;
	
	public SuppServiceUsed(SSCodeImpl ssCode,TimeStamp ssTime)
	{
		this.ssCode=ssCode;
		this.ssTime=ssTime;
	}

	public SSCodeImpl getSSCode() 
	{
		return ssCode;
	}

	public TimeStamp getSSTime() 
	{
		return ssTime;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SuppServiceUsed");
        sb.append(" [");

        if(ssCode!=null)
        {
	        sb.append("ssCode=[");
	        sb.append(ssCode.getValue());
	        sb.append("]");
        }
        
        if(ssTime!=null)
        {
	        sb.append("ssTime=[");
	        sb.append(ssTime.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}