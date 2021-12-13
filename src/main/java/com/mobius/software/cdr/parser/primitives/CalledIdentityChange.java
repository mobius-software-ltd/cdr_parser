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
CalledIdentityChange ::= SEQUENCE
{
calledIdentity [0] InvolvedParty OPTIONAL,
changeTime [1] TimeStamp OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class CalledIdentityChange 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = true,index = -1)
	private InvolvedPartyWrapper calledIdentity;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private TimeStamp changeTime;
	
	public CalledIdentityChange(InvolvedParty calledIdentity,TimeStamp changeTime)
	{
		if(calledIdentity!=null)
			this.calledIdentity=new InvolvedPartyWrapper(calledIdentity);
		
		this.changeTime=changeTime;
	}

	public InvolvedParty getCalledIdentity() 
	{
		if(calledIdentity==null)
			return null;
		
		return calledIdentity.getInvolvedParty();
	}

	public TimeStamp getChangeTime() 
	{
		if(changeTime==null)
			return null;
		
		return changeTime;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CalledIdentityChange");
        sb.append(" [");

        if(calledIdentity!=null && calledIdentity.getInvolvedParty()!=null)
        {
	        sb.append("calledIdentity=[");
	        sb.append(calledIdentity.getInvolvedParty());
	        sb.append("]");
        }
        
        if(changeTime!=null)
        {
        	sb.append("changeTime=[");
	        sb.append(changeTime);
	        sb.append("]");
        }
        
        sb.append("]");
        return sb.toString();
    }
}