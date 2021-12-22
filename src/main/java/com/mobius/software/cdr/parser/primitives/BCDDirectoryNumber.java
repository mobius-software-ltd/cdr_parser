package com.mobius.software.cdr.parser.primitives;

import org.restcomm.protocols.ss7.commonapp.api.APPException;
import org.restcomm.protocols.ss7.commonapp.api.APPParsingComponentException;
import org.restcomm.protocols.ss7.commonapp.primitives.TbcdStringImpl;

import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.ASNParser;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNDecode;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNEncode;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNLength;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;

import io.netty.buffer.ByteBuf;

/*
BCDDirectoryNumber        ::= OCTET STRING
    -- This type contains the binary coded decimal representation of
    -- a directory number e.g. calling/called/connected/translated number.
    -- The encoding of the octet string is in accordance with the
    -- the elements "Calling party BCD number", "Called party BCD number"
    -- and "Connected number" defined in TS 24.008.
    -- This encoding includes type of number and number plan information
    -- together with a BCD encoded digit string.
    -- It may also contain both a presentation and screening indicator
    -- (octet 3a).
    -- For the avoidance of doubt, this field does not include
    -- octets 1 and 2, the element name and length, as this would be
    -- redundant.
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 4,constructed = false,lengthIndefinite = false)
public class BCDDirectoryNumber  
{
	protected String address;

    public BCDDirectoryNumber() 
    {    	
    }
    
    public BCDDirectoryNumber(String address) 
    {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    @ASNLength
	public Integer getLength(ASNParser parser) {
    	return getLength();
    }
    
    public Integer getLength() {
    	return TbcdStringImpl.getLength(false, null, address) + 1;
	}
    
    @ASNEncode
	public void encode(ASNParser parser,ByteBuf buffer) throws APPException {
    	encode(buffer);
    }
    
    public void encode(ByteBuf buffer) throws APPException {
    	TbcdStringImpl.encodeString(buffer, address);		
	}
    
    @ASNDecode
	public Boolean decode(ASNParser parser,Object parent,ByteBuf buffer,Boolean skipErrors) throws APPParsingComponentException {
    	decode(buffer);
    	return false;
    }
    
    public void decode(ByteBuf buffer) throws APPParsingComponentException {
    	this.address=TbcdStringImpl.decodeString(buffer);		
	}

    @Override
    public String toString() {
        return "BCDDirectoryNumber[Address=" + this.address + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BCDDirectoryNumber other = (BCDDirectoryNumber) obj;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        return true;
    }
}
