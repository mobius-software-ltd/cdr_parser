package com.mobius.software.cdr.parser.primitives;
import org.restcomm.protocols.ss7.map.service.mobility.subscriberManagement.BasicServiceCodeImpl;

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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNSingleByte;
/*
ChangeOfService ::= SEQUENCE
{
 basicService [0] BasicServiceCode,
 transparencyInd [1] TransparencyInd OPTIONAL,
 changeTime [2] TimeStamp,
 rateIndication [3] RateIndication OPTIONAL,
 fnur [4] Fnur OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class ChangeOfService 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private BasicServiceCodeImpl basicService;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNTransparencyInd transparencyInd;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private TimeStamp changeTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNSingleByte rateIndication;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNFnur fnur;
	
	public ChangeOfService(BasicServiceCodeImpl basicService,TransparencyInd transparencyInd,TimeStamp changeTime,Integer rateIndication,Fnur fnur)
	{
		this.basicService=basicService;
		
		if(transparencyInd!=null)
			this.transparencyInd=new ASNTransparencyInd(transparencyInd);
		
		this.changeTime=changeTime;
		
		if(rateIndication!=null)
			this.rateIndication=new ASNSingleByte(rateIndication,null,null,null,false);
		
		if(fnur!=null)
			this.fnur=new ASNFnur(fnur);
	}

	public BasicServiceCodeImpl getBasicService() 
	{
		return basicService;
	}

	public TransparencyInd getTransparencyInd() 
	{
		if(transparencyInd==null)
			return null;
		
		return transparencyInd.getInd();
	}

	public TimeStamp getChangeTime() 
	{
		return changeTime;
	}

	public Integer getRateIndication() 
	{
		if(rateIndication==null)
			return null;
		
		return rateIndication.getValue();
	}

	public Fnur getFnur() 
	{
		if(fnur==null)
			return null;
		
		return fnur.getType();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChangeOfService");
        sb.append(" [");

        if(basicService!=null)
        {
	        sb.append("basicService=[");
	        sb.append(basicService);
	        sb.append("]");
        }
        
        if(transparencyInd!=null && transparencyInd.getValue()!=null)
        {
	        sb.append("transparencyInd=[");
	        sb.append(transparencyInd.getInd());
	        sb.append("]");
        }
        
        if(changeTime!=null)
        {
	        sb.append("changeTime=[");
	        sb.append(changeTime);
	        sb.append("]");
        }
        
        if(rateIndication!=null && rateIndication.getValue()!=null)
        {
	        sb.append("rateIndication=[");
	        sb.append(rateIndication.getValue());
	        sb.append("]");
        }
        
        if(fnur!=null && fnur.getValue()!=null)
        {
	        sb.append("fnur=[");
	        sb.append(fnur.getType());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}