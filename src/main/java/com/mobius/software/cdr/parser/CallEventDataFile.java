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

import com.mobius.software.cdr.parser.huawei.HeaderRecord;
import com.mobius.software.cdr.parser.huawei.TrailerRecord;
import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.Unpooled;
/**
 * 
 * wrapper for huawei cs cdrs
 *
CallEventDataFile        ::= SEQUENCE
{
    headerRecord            [0] HeaderRecord,
    callEventRecords        [1] SEQUENCE OF CallEventRecord,
    trailerRecord           [2] TrailerRecord,
    extensions              [3] ManagementExtensions
}
 * 
 * 
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL, tag = 16, constructed = true,lengthIndefinite = false)
public class CallEventDataFile 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC, tag = 0,constructed = true, index=-1)
	private HeaderRecord headerRecord;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC, tag = 1,constructed = true, index=-1)
	private WrappedCSRecordsContainer csRecordContaier;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC, tag = 2,constructed = true, index=-1)
	private TrailerRecord trailerRecord;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC, tag = 3,constructed = true, index=-1)
	private ASNOctetString extensions;
	
	public CallEventDataFile()
	{
		
	}
	
	public CallEventDataFile(HeaderRecord headerRecord,List<CSRecord> csRecords,TrailerRecord trailerRecord,byte[] extensions)
	{
		this.headerRecord=headerRecord;
		this.trailerRecord=trailerRecord;
		
		if(csRecords!=null)
			this.csRecordContaier=new WrappedCSRecordsContainer(csRecords);
		
		if(extensions!=null)
		{
			this.extensions=new ASNOctetString();
			this.extensions.setValue(Unpooled.wrappedBuffer(extensions));
		}
	}
	
	public HeaderRecord getHeaderRecord()
	{
		return headerRecord;
	}
	
	public List<CSRecord> getCSRecords()
	{
		if(csRecordContaier==null)
			return null;
		
		return csRecordContaier.getCSRecords();		
	}
	
	public TrailerRecord getTrailerRecord()
	{
		return trailerRecord;
	}
	
	@Override
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        if(csRecordContaier!=null && csRecordContaier.getCSRecords()!=null && csRecordContaier.getCSRecords().size()>0)
        {
        	int index=0;
        	for(CSRecord record:csRecordContaier.getCSRecords())
        	{
        		if(index!=0)
        			sb.append(",");
        		
        		sb.append(record);
        	}
        }
        return sb.toString();
	}
}