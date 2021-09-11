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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;

/*
EPCQoSInformation ::= SEQUENCE
--
-- See TS 29.212 [220] for more information
--
{
qCI [1] INTEGER,
maxRequestedBandwithUL [2] INTEGER OPTIONAL,
maxRequestedBandwithDL [3] INTEGER OPTIONAL,
guaranteedBitrateUL [4] INTEGER OPTIONAL,
guaranteedBitrateDL [5] INTEGER OPTIONAL,
aRP [6] INTEGER OPTIONAL,
aPNAggregateMaxBitrateUL [7] INTEGER OPTIONAL,
aPNAggregateMaxBitrateDL [8] INTEGER OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class EPCQoSInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNInteger qCI;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNInteger maxRequestedBandwithUL;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNInteger maxRequestedBandwithDL;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNInteger guaranteedBitrateUL;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private ASNInteger guaranteedBitrateDL;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private ASNInteger aRP;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private ASNInteger aPNAggregateMaxBitrateUL;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private ASNInteger aPNAggregateMaxBitrateDL;
	
	public EPCQoSInformation()
	{
		
	}
	
	public EPCQoSInformation(Long qCI,Long maxRequestedBandwithUL,Long maxRequestedBandwithDL,Long guaranteedBitrateUL,Long guaranteedBitrateDL,Long aRP,Long aPNAggregateMaxBitrateUL,Long aPNAggregateMaxBitrateDL)
	{
		if(qCI!=null)
		{
			this.qCI=new ASNInteger();
			this.qCI.setValue(qCI.longValue());
		}
		
		if(maxRequestedBandwithDL!=null)
		{
			this.maxRequestedBandwithDL=new ASNInteger();
			this.maxRequestedBandwithDL.setValue(maxRequestedBandwithDL.longValue());
		}
		
		if(maxRequestedBandwithDL!=null)
		{
			this.maxRequestedBandwithDL=new ASNInteger();
			this.maxRequestedBandwithDL.setValue(maxRequestedBandwithDL.longValue());
		}
		
		if(guaranteedBitrateUL!=null)
		{
			this.guaranteedBitrateUL=new ASNInteger();
			this.guaranteedBitrateUL.setValue(guaranteedBitrateUL.longValue());
		}
		
		if(guaranteedBitrateDL!=null)
		{
			this.guaranteedBitrateDL=new ASNInteger();
			this.guaranteedBitrateDL.setValue(guaranteedBitrateDL.longValue());
		}
		
		if(aRP!=null)
		{
			this.aRP=new ASNInteger();
			this.aRP.setValue(aRP.longValue());
		}
		
		if(aPNAggregateMaxBitrateUL!=null)
		{
			this.aPNAggregateMaxBitrateUL=new ASNInteger();
			this.aPNAggregateMaxBitrateUL.setValue(aPNAggregateMaxBitrateUL.longValue());
		}
		
		if(aPNAggregateMaxBitrateDL!=null)
		{
			this.aPNAggregateMaxBitrateDL=new ASNInteger();
			this.aPNAggregateMaxBitrateDL.setValue(qCI.longValue());
		}
	}

	public Long getqCI() 
	{
		if(qCI==null)
			return null;
		
		return qCI.getValue();
	}

	public Long getMaxRequestedBandwithUL() 
	{
		if(maxRequestedBandwithUL==null)
			return null;
		
		return maxRequestedBandwithUL.getValue();
	}

	public Long getMaxRequestedBandwithDL() 
	{
		if(maxRequestedBandwithDL==null)
			return null;
		
		return maxRequestedBandwithDL.getValue();
	}

	public Long getGuaranteedBitrateUL() 
	{
		if(guaranteedBitrateUL==null)
			return null;
		
		return guaranteedBitrateUL.getValue();
	}

	public Long getGuaranteedBitrateDL() 
	{
		if(guaranteedBitrateDL==null)
			return null;
		
		return guaranteedBitrateDL.getValue();
	}

	public Long getaRP() 
	{
		if(aRP==null)
			return null;
		
		return aRP.getValue();
	}

	public Long getaPNAggregateMaxBitrateUL() 
	{
		if(aPNAggregateMaxBitrateUL==null)
			return null;
		
		return aPNAggregateMaxBitrateUL.getValue();
	}

	public Long getaPNAggregateMaxBitrateDL() 
	{
		if(aPNAggregateMaxBitrateDL==null)
			return null;
		
		return aPNAggregateMaxBitrateDL.getValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EPCQoSInformation");
        sb.append(" [");

        if(qCI!=null && qCI.getValue()!=null)
        {
	        sb.append("QCI=[");
	        sb.append(this.qCI.getValue());
	        sb.append("]");
        }
        
        if(maxRequestedBandwithUL!=null && maxRequestedBandwithUL.getValue()!=null)
        {
	        sb.append(", Max Requested Bandwith UL=[");
	        sb.append(this.maxRequestedBandwithUL.getValue());
	        sb.append("]");
        }
        
        if(maxRequestedBandwithDL!=null && maxRequestedBandwithDL.getValue()!=null)
        {
	        sb.append(", Max Requested Bandwith DL=[");
	        sb.append(this.maxRequestedBandwithDL.getValue());
	        sb.append("]");
        }
        
        if(guaranteedBitrateUL!=null && guaranteedBitrateUL.getValue()!=null)
        {
	        sb.append(", Guaranteed Bitrate UL=[");
	        sb.append(this.guaranteedBitrateUL.getValue());
	        sb.append("]");
        }
        
        if(guaranteedBitrateDL!=null && guaranteedBitrateDL.getValue()!=null)
        {
	        sb.append(", Guaranteed Bitrate DL=[");
	        sb.append(this.guaranteedBitrateDL.getValue());
	        sb.append("]");
        }
        
        if(aRP!=null && aRP.getValue()!=null)
        {
	        sb.append(", ARP=[");
	        sb.append(this.aRP.getValue());
	        sb.append("]");
        }
        
        if(aPNAggregateMaxBitrateUL!=null && aPNAggregateMaxBitrateUL.getValue()!=null)
        {
	        sb.append(", APN Aggregate Max Bitrate UL=[");
	        sb.append(this.aPNAggregateMaxBitrateUL.getValue());
	        sb.append("]");
        }
        
        if(aPNAggregateMaxBitrateDL!=null && aPNAggregateMaxBitrateDL.getValue()!=null)
        {
	        sb.append(", APN Aggregate Max Bitrate DL=[");
	        sb.append(this.aPNAggregateMaxBitrateDL.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}