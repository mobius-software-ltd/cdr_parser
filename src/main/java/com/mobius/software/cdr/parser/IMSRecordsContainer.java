package com.mobius.software.cdr.parser;
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
import java.util.List;

import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNChoise;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNWrappedTag;
/**
 * @author yulian.oifa
 *
 */
@ASNWrappedTag
public class IMSRecordsContainer 
{
	@ASNChoise
	private List<IMSRecord> imsRecords;
	
	public IMSRecordsContainer()
	{
		
	}
	
	public IMSRecordsContainer(List<IMSRecord> imsRecords)
	{
		this.imsRecords=imsRecords;
	}
	
	public List<IMSRecord> getIMSRecords()
	{
		return imsRecords;
	}
	
	@Override
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        if(imsRecords!=null && imsRecords.size()>0)
        {
        	int index=0;
        	for(IMSRecord record:imsRecords)
        	{
        		if(index!=0)
        			sb.append(",");
        		
        		sb.append(record);
        	}
        }
        return sb.toString();
	}
}