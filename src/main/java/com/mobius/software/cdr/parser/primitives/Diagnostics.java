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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class Diagnostics 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNInteger gsm0408Cause;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNInteger gsm0902MapErrorValue;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNInteger itutQ767Cause;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNOctetString networkSpecificCause;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNOctetString manufacturerSpecificCause;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private ASNInteger positionMethodFailureCause;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private ASNInteger unauthorizedLCSClientCause;
	
	public Diagnostics() 
	{
		
	}

	public Integer getGsm0408Cause() 
	{
		if(gsm0408Cause==null || gsm0408Cause.getValue()==null)
			return null;
		
		return gsm0408Cause.getValue().intValue();
	}

	public void setGsm0408Cause(Integer gsm0408Cause) 
	{
		if(gsm0408Cause==null)
			this.gsm0408Cause=null;
		else
		{
			this.gsm0408Cause = new ASNInteger();
			this.gsm0408Cause.setValue(gsm0408Cause.longValue());
		}
		
		setGsm0902MapErrorValue(null);
		setItutQ767Cause(null);
		setNetworkSpecificCause(null);
		setPositionMethodFailureCause(null);
		setManufacturerSpecificCause(null);
		setUnauthorizedLCSClientCause(null);
	}

	public Integer getGsm0902MapErrorValue() 
	{
		if(gsm0902MapErrorValue==null || gsm0902MapErrorValue.getValue()==null)
			return null;
		
		return gsm0902MapErrorValue.getValue().intValue();
	}

	public void setGsm0902MapErrorValue(Integer gsm0902MapErrorValue) 
	{
		if(gsm0902MapErrorValue==null)
			this.gsm0902MapErrorValue=null;
		else
		{
			this.gsm0902MapErrorValue = new ASNInteger();
			this.gsm0902MapErrorValue.setValue(gsm0902MapErrorValue.longValue());
		}
		
		setGsm0408Cause(null);
		setItutQ767Cause(null);
		setNetworkSpecificCause(null);
		setPositionMethodFailureCause(null);
		setManufacturerSpecificCause(null);
		setUnauthorizedLCSClientCause(null);
	}

	public Integer getItutQ767Cause() 
	{
		if(itutQ767Cause==null || itutQ767Cause.getValue()==null)
			return null;
		
		return itutQ767Cause.getValue().intValue();
	}

	public void setItutQ767Cause(Integer itutQ767Cause) 
	{
		if(itutQ767Cause==null)
			this.itutQ767Cause=null;
		else
		{
			this.itutQ767Cause = new ASNInteger();
			this.itutQ767Cause.setValue(itutQ767Cause.longValue());
		}
		
		setGsm0408Cause(null);
		setGsm0902MapErrorValue(null);
		setNetworkSpecificCause(null);
		setPositionMethodFailureCause(null);
		setManufacturerSpecificCause(null);
		setUnauthorizedLCSClientCause(null);
	}

	public byte[] getNetworkSpecificCause() 
	{
		if(this.networkSpecificCause==null)
			return null;
		
		ByteBuf value=this.networkSpecificCause.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public void setNetworkSpecificCause(byte[] networkSpecificCause) 
	{
		if(networkSpecificCause==null)
			this.networkSpecificCause=null;
		else
		{
			this.networkSpecificCause=new ASNOctetString();
			this.networkSpecificCause.setValue(Unpooled.wrappedBuffer(networkSpecificCause));
		}
		
		setGsm0408Cause(null);
		setGsm0902MapErrorValue(null);
		setItutQ767Cause(null);
		setManufacturerSpecificCause(null);
		setPositionMethodFailureCause(null);
		setUnauthorizedLCSClientCause(null);
	}

	public byte[] getManufacturerSpecificCause() 
	{
		if(this.manufacturerSpecificCause==null)
			return null;
		
		ByteBuf value=this.manufacturerSpecificCause.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public void setManufacturerSpecificCause(byte[] manufacturerSpecificCause) 
	{
		if(manufacturerSpecificCause==null)
			this.manufacturerSpecificCause=null;
		else
		{
			this.manufacturerSpecificCause=new ASNOctetString();
			this.manufacturerSpecificCause.setValue(Unpooled.wrappedBuffer(manufacturerSpecificCause));
		}
		
		setGsm0408Cause(null);
		setGsm0902MapErrorValue(null);
		setItutQ767Cause(null);
		setNetworkSpecificCause(null);
		setPositionMethodFailureCause(null);
		setUnauthorizedLCSClientCause(null);
	}

	public Integer getPositionMethodFailureCause() 
	{
		if(positionMethodFailureCause==null || positionMethodFailureCause.getValue()==null)
			return null;
		
		return positionMethodFailureCause.getValue().intValue();
	}

	public void setPositionMethodFailureCause(Integer positionMethodFailureCause) 
	{
		if(positionMethodFailureCause==null)
			this.positionMethodFailureCause=null;
		else
		{
			this.positionMethodFailureCause = new ASNInteger();
			this.positionMethodFailureCause.setValue(positionMethodFailureCause.longValue());
		}
		
		setGsm0408Cause(null);
		setGsm0902MapErrorValue(null);
		setItutQ767Cause(null);
		setNetworkSpecificCause(null);
		setManufacturerSpecificCause(null);
		setUnauthorizedLCSClientCause(null);
	}

	public Integer getUnauthorizedLCSClientCause() 
	{
		if(unauthorizedLCSClientCause==null || unauthorizedLCSClientCause.getValue()==null)
			return null;
		
		return unauthorizedLCSClientCause.getValue().intValue();
	}

	public void setUnauthorizedLCSClientCause(Integer unauthorizedLCSClientCause) 
	{
		if(unauthorizedLCSClientCause==null)
			this.unauthorizedLCSClientCause=null;
		else
		{
			this.unauthorizedLCSClientCause = new ASNInteger();
			this.unauthorizedLCSClientCause.setValue(unauthorizedLCSClientCause.longValue());
		}
		
		setGsm0408Cause(null);
		setGsm0902MapErrorValue(null);
		setItutQ767Cause(null);
		setNetworkSpecificCause(null);
		setManufacturerSpecificCause(null);
		setPositionMethodFailureCause(null);
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("GPRSRecord [");

        if(this.getGsm0408Cause()!=null)
        {
        	sb.append("gsm0408Cause=[");
            sb.append(this.getGsm0408Cause());
            sb.append("]");
        }

        if(this.getGsm0902MapErrorValue()!=null)
        {
        	sb.append("gsm0902MapErrorValue=[");
            sb.append(this.getGsm0902MapErrorValue());
            sb.append("]");
        }
        
        if(this.getItutQ767Cause()!=null)
        {
        	sb.append("itutQ767Cause=[");
            sb.append(this.getItutQ767Cause());
            sb.append("]");
        }
        
        if(this.getNetworkSpecificCause()!=null)
        {
        	sb.append("networkSpecificCause=[");
            sb.append(ASNOctetString.printDataArr(getNetworkSpecificCause()));
            sb.append("]");
        }
        
        if(this.getManufacturerSpecificCause()!=null)
        {
        	sb.append("manufacturerSpecificCause=[");
            sb.append(ASNOctetString.printDataArr(getManufacturerSpecificCause()));
            sb.append("]");
        }
        
        if(this.getPositionMethodFailureCause()!=null)
        {
        	sb.append("positionMethodFailureCause=[");
            sb.append(this.getPositionMethodFailureCause());
            sb.append("]");
        }
        
        if(this.getUnauthorizedLCSClientCause()!=null)
        {
        	sb.append("unauthorizedLCSClientCause=[");
            sb.append(this.getUnauthorizedLCSClientCause());
            sb.append("]");
        }              
        sb.append("]");

        return sb.toString();
    }
}