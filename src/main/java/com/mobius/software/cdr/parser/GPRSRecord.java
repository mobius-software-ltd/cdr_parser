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
import com.mobius.software.cdr.parser.gprs.GGSNMBMSRecord;
import com.mobius.software.cdr.parser.gprs.GWMBMSRecord;
import com.mobius.software.cdr.parser.gprs.PGWRecord;
import com.mobius.software.cdr.parser.gprs.SGSNMBMSRecord;
import com.mobius.software.cdr.parser.gprs.SGSNMMRecord;
import com.mobius.software.cdr.parser.gprs.SGSNMOLCSRecord;
import com.mobius.software.cdr.parser.gprs.SGSNMTLCSRecord;
import com.mobius.software.cdr.parser.gprs.SGSNNILCSRecord;
import com.mobius.software.cdr.parser.gprs.SGSNPDPRecord;
import com.mobius.software.cdr.parser.gprs.SGSNSMORecord;
import com.mobius.software.cdr.parser.gprs.SGSNSMTRecord;
import com.mobius.software.cdr.parser.gprs.SGWRecord;
import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;

/*
GPRSRecord ::= CHOICE
--
-- Record values 20, 22..27 are specific
-- Record values 76, 77, 86 are MBMS specific
-- Record values 78..79 are EPC specific
--
{
sgsnPDPRecord [20] SGSNPDPRecord,
sgsnMMRecord [22] SGSNMMRecord,
sgsnSMORecord [23] SGSNSMORecord,
sgsnSMTRecord [24] SGSNSMTRecord,
sgsnMTLCSRecord [25] SGSNMTLCSRecord,
sgsnMOLCSRecord [26] SGSNMOLCSRecord,
sgsnNILCSRecord [27] SGSNNILCSRecord,
--
sgsnMBMSRecord [76] SGSNMBMSRecord,
ggsnMBMSRecord [77] GGSNMBMSRecord,
gwMBMSRecord [86] GWMBMSRecord,
sGWRecord [78] SGWRecord,
pGWRecord [79] PGWRecord
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class GPRSRecord 
{
	private SGSNPDPRecord sgsnPDPRecord;
	private SGSNMMRecord sgsnMMRecord;
	private SGSNSMORecord sgsnSMORecord;
	private SGSNSMTRecord sgsnSMTRecord;
	private SGSNMTLCSRecord sgsnMTLCSRecord;
	private SGSNMOLCSRecord sgsnMOLCSRecord;
	private SGSNNILCSRecord sgsnNILCSRecord;
	private SGSNMBMSRecord sgsnMBMSRecord;
	private GGSNMBMSRecord ggsnMBMSRecord;
	private GWMBMSRecord gwMBMSRecord;
	private SGWRecord sGWRecord;
	private PGWRecord pGWRecord; 
	
	public GPRSRecord()
	{
		
	}
	
	public GPRSRecord(SGSNPDPRecord sgsnPDPRecord)
	{
		this.sgsnPDPRecord=sgsnPDPRecord;
	}
	
	public GPRSRecord(SGSNMMRecord sgsnMMRecord)
	{
		this.sgsnMMRecord=sgsnMMRecord;
	}
	
	public GPRSRecord(SGSNSMORecord sgsnSMORecord)
	{
		this.sgsnSMORecord=sgsnSMORecord;
	}
	
	public GPRSRecord(SGSNSMTRecord sgsnSMTRecord)
	{
		this.sgsnSMTRecord=sgsnSMTRecord;
	}
	
	public GPRSRecord(SGSNMTLCSRecord sgsnMTLCSRecord)
	{
		this.sgsnMTLCSRecord=sgsnMTLCSRecord;
	}
	
	public GPRSRecord(SGSNMOLCSRecord sgsnMOLCSRecord)
	{
		this.sgsnMOLCSRecord=sgsnMOLCSRecord;
	}
	
	public GPRSRecord(SGSNNILCSRecord sgsnNILCSRecord)
	{
		this.sgsnNILCSRecord=sgsnNILCSRecord;
	}
	
	public GPRSRecord(SGSNMBMSRecord sgsnMBMSRecord)
	{
		this.sgsnMBMSRecord=sgsnMBMSRecord;
	}
	
	public GPRSRecord(GGSNMBMSRecord ggsnMBMSRecord)
	{
		this.ggsnMBMSRecord=ggsnMBMSRecord;
	}
	
	public GPRSRecord(GWMBMSRecord gwMBMSRecord)
	{
		this.gwMBMSRecord=gwMBMSRecord;
	}
	
	public GPRSRecord(SGWRecord sGWRecord)
	{
		this.sGWRecord=sGWRecord;
	}
	
	public GPRSRecord(PGWRecord pGWRecord)
	{
		this.pGWRecord=pGWRecord;
	}

	public SGSNPDPRecord getSgsnPDPRecord() 
	{
		return sgsnPDPRecord;
	}

	public SGSNMMRecord getSgsnMMRecord() 
	{
		return sgsnMMRecord;
	}

	public SGSNSMORecord getSgsnSMORecord() 
	{
		return sgsnSMORecord;
	}

	public SGSNSMTRecord getSgsnSMTRecord() 
	{
		return sgsnSMTRecord;
	}

	public SGSNMTLCSRecord getSgsnMTLCSRecord() 
	{
		return sgsnMTLCSRecord;
	}

	public SGSNMOLCSRecord getSgsnMOLCSRecord() 
	{
		return sgsnMOLCSRecord;
	}

	public SGSNNILCSRecord getSgsnNILCSRecord() 
	{
		return sgsnNILCSRecord;
	}

	public SGSNMBMSRecord getSgsnMBMSRecord() 
	{
		return sgsnMBMSRecord;
	}

	public GGSNMBMSRecord getGgsnMBMSRecord() 
	{
		return ggsnMBMSRecord;
	}

	public GWMBMSRecord getGwMBMSRecord() 
	{
		return gwMBMSRecord;
	}

	public SGWRecord getsGWRecord() 
	{
		return sGWRecord;
	}

	public PGWRecord getpGWRecord() 
	{
		return pGWRecord;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("GPRSRecord [");

        if(this.ggsnMBMSRecord!=null)
        {
        	sb.append("ggsnMBMSRecord=[");
            sb.append(this.ggsnMBMSRecord);
            sb.append("]");
        }

        if(this.gwMBMSRecord!=null)
        {
        	sb.append("gwMBMSRecord=[");
            sb.append(this.gwMBMSRecord);
            sb.append("]");
        }
        
        if(this.pGWRecord!=null)
        {
        	sb.append("pGWRecord=[");
            sb.append(this.pGWRecord);
            sb.append("]");
        }
        
        if(this.sgsnMBMSRecord!=null)
        {
        	sb.append("sgsnMBMSRecord=[");
            sb.append(this.sgsnMBMSRecord);
            sb.append("]");
        }
        
        if(this.sgsnMMRecord!=null)
        {
        	sb.append("sgsnMMRecord=[");
            sb.append(this.sgsnMMRecord);
            sb.append("]");
        }
        
        if(this.sgsnMOLCSRecord!=null)
        {
        	sb.append("sgsnMOLCSRecord=[");
            sb.append(this.sgsnMOLCSRecord);
            sb.append("]");
        }
        
        if(this.sgsnMTLCSRecord!=null)
        {
        	sb.append("sgsnMTLCSRecord=[");
            sb.append(this.sgsnMTLCSRecord);
            sb.append("]");
        }
        
        if(this.sgsnNILCSRecord!=null)
        {
        	sb.append("sgsnNILCSRecord=[");
            sb.append(this.sgsnNILCSRecord);
            sb.append("]");
        }
        
        if(this.sgsnPDPRecord!=null)
        {
        	sb.append("sgsnPDPRecord=[");
            sb.append(this.sgsnPDPRecord);
            sb.append("]");
        }
        
        if(this.sgsnSMORecord!=null)
        {
        	sb.append("sgsnSMORecord=[");
            sb.append(this.sgsnSMORecord);
            sb.append("]");
        }
        
        if(this.sgsnSMTRecord!=null)
        {
        	sb.append("sgsnSMTRecord=[");
            sb.append(this.sgsnSMTRecord);
            sb.append("]");
        }
        
        if(this.sGWRecord!=null)
        {
        	sb.append("sGWRecord=[");
            sb.append(this.sGWRecord);
            sb.append("]");
        }                
        sb.append("]");

        return sb.toString();
    }
}