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
ChangedParameters ::= SET
{
 changeFlags [0] ChangeFlags,
 changeList [1] CAMELModificationParameters OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class ChangeParameters 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ChangeFlags changeFlags;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = true,index = -1)
	private CAMELModificationParameters changeList;
	
	public ChangeParameters(ChangeFlags changeFlags,CAMELModificationParameters changeList)
	{
		this.changeFlags=changeFlags;
		this.changeList=changeList;
	}

	public ChangeFlags getChangeFilags() 
	{
		return changeFlags;
	}

	public CAMELModificationParameters getChangeList() 
	{
		return changeList;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChangeParameters");
        sb.append(" [");

        if(changeFlags!=null)
        {
	        sb.append("changeFlags=[");
	        sb.append(changeFlags);
	        sb.append("]");
        }
        
        if(changeList!=null)
        {
	        sb.append("changeList=[");
	        sb.append(changeList);
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}