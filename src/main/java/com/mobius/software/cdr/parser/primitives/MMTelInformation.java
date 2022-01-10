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
MMTelInformation ::= SET
{
 	ListOfSupplServices [0] SEQUENCE OF SupplService OPTIONAL,
 	subscriberRole [1] SubscriberRole OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class MMTelInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = true,index = -1)
	private SupplServiceListWrapper listOfSupplServices;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNSubscriberRole subscriberRole;
	
	public MMTelInformation()
	{
		
	}
	
	public MMTelInformation(List<SupplService> listOfSupplServices,SubscriberRole subscriberRole)
	{
		if(listOfSupplServices!=null)
			this.listOfSupplServices=new SupplServiceListWrapper(listOfSupplServices);
		
		if(subscriberRole!=null)
		{
			this.subscriberRole=new ASNSubscriberRole();
			this.subscriberRole.setType(subscriberRole);
		}		
	}
	
	public List<SupplService> getSupplService() 
	{
		if(listOfSupplServices==null)
			return null;
		
		return listOfSupplServices.getSupplService();
	}

	public SubscriberRole getSubscriberRole() 
	{
		if(subscriberRole==null)
			return null;
		
		return subscriberRole.getType();
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MMTelInformation");
        sb.append(" [");

        if(listOfSupplServices!=null && listOfSupplServices.getSupplService()!=null)
        {
	        sb.append("listOfSupplServices=[");
	        Boolean isFirst=true;
	        for(SupplService curr:listOfSupplServices.getSupplService()) 
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        	isFirst=false;
	        }
	        
	        sb.append("]");
        }
        
        if(subscriberRole!=null && subscriberRole.getType()!=null)
        {
	        sb.append("subscriberRole=[");
	        sb.append(subscriberRole.getType());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}