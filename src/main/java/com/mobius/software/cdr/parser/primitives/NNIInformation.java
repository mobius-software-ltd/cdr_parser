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
NNI-Information ::= SEQUENCE
{
 sessionDirection [0] SessionDirection OPTIONAL,
 nNIType [1] NNIType OPTIONAL,
 relationshipMode [2] RelationshipMode OPTIONAL,
 neighbourNodeAddress [3] IPAddress OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class NNIInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNSessionDirection sessionDirection;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNNNIType nniType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNRelationshipMode relationshipMode;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = true,index = -1)
	private IPAddressWrapper neighbourNodeAddress;
	
	public NNIInformation(SessionDirection sessionDirection,NNIType nniType,RelationshipMode relationshipMode,IPAddress neighbourNodeAddress)
	{
		if(sessionDirection!=null)
			this.sessionDirection=new ASNSessionDirection(sessionDirection);
		
		if(nniType!=null)
			this.nniType=new ASNNNIType(nniType);
		
		if(relationshipMode!=null)
			this.relationshipMode=new ASNRelationshipMode(relationshipMode);
		
		if(neighbourNodeAddress!=null) {
			this.neighbourNodeAddress=new IPAddressWrapper(neighbourNodeAddress);
		}
	}

	public SessionDirection getSessionDirection() 
	{
		if(sessionDirection==null)
			return null;
		
		return sessionDirection.getType();
	}

	public NNIType getNNIType() 
	{
		if(nniType==null)
			return null;
		
		return nniType.getType();
	}

	public RelationshipMode getRelationshipMode() 
	{
		if(relationshipMode==null)
			return null;
		
		return relationshipMode.getType();
	}

	public IPAddress getNeighbourNodeAddress() 
	{
		if(neighbourNodeAddress==null)
			return null;
		
		return neighbourNodeAddress.getIPAddress();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NNIInformation");
        sb.append(" [");

        if(sessionDirection!=null && sessionDirection.getType()!=null)
        {
	        sb.append("sessionDirection=[");
	        sb.append(sessionDirection.getType());
	        sb.append("]");
        }
        
        if(nniType!=null && nniType.getType()!=null)
        {
        	sb.append("nniType=[");
	        sb.append(nniType.getType());
	        sb.append("]");
        }
        
        if(relationshipMode!=null && relationshipMode.getType()!=null)
        {
        	sb.append("relationshipMode=[");
	        sb.append(relationshipMode.getType());
	        sb.append("]");
        }
        
        if(neighbourNodeAddress!=null && neighbourNodeAddress.getIPAddress()!=null)
        {
	        sb.append("neighbourNodeAddress=[");
	        sb.append(neighbourNodeAddress.getIPAddress());
	        sb.append("]");
        }
        
        sb.append("]");
        return sb.toString();
    }
}