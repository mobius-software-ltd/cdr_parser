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
/*
ApplicationServersInformation
::= SEQUENCE
{
 applicationServersInvolved[0] NodeAddress OPTIONAL,
 applicationProvidedCalledParties[1] SEQUENCE OF InvolvedParty OPTIONAL,
 sTatus[2] Status OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class ApplicationServersInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = true,index = -1)
	private NodeAddressWrapper applicationServersInvolved;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = true,index = -1)
	private InvolvedPartyListWrapper applicationProvidedCalledParties;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNStatus status;
	
	public ApplicationServersInformation(NodeAddress applicationServersInvolved,List<InvolvedParty> applicationProvidedCalledParties,Status status)
	{
		if(applicationServersInvolved!=null)
			this.applicationServersInvolved=new NodeAddressWrapper(applicationServersInvolved);
		
		if(applicationProvidedCalledParties!=null)
			this.applicationProvidedCalledParties=new InvolvedPartyListWrapper(applicationProvidedCalledParties);
		
		if(status!=null)
			this.status=new ASNStatus(status);		
	}

	public NodeAddress getApplicationServersInvolved() 
	{
		if(applicationServersInvolved==null)
			return null;
		
		return applicationServersInvolved.getNodeAddress();
	}

	public List<InvolvedParty> getApplicationProvidedCalledParties() 
	{
		if(applicationProvidedCalledParties==null)
			return null;
		
		return applicationProvidedCalledParties.getInvolvedParty();
	}

	public Status getStatus() 
	{
		if(status==null)
			return null;
		
		return status.getType();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApplicationServersInformation");
        sb.append(" [");

        if(applicationServersInvolved!=null && applicationServersInvolved.getNodeAddress()!=null)
        {
	        sb.append("applicationServersInvolved=[");
	        sb.append(applicationServersInvolved.getNodeAddress());
	        sb.append("]");
        }
        
        if(applicationProvidedCalledParties!=null && applicationProvidedCalledParties.getInvolvedParty()!=null)
        {
	        sb.append("applicationProvidedCalledParties=[");
	        Boolean first=true;
	        for(InvolvedParty currParty:applicationProvidedCalledParties.getInvolvedParty()) {
	        	if(!first)
	        		sb.append(",");
	        	
	        	sb.append(currParty);	        	
	        }
	        sb.append("]");
        }
        
        if(status!=null && status.getType()!=null)
        {
	        sb.append("status=[");
	        sb.append(status.getType());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}