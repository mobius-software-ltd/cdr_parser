package com.mobius.software.cdr.parser.primitives;

import org.restcomm.protocols.ss7.commonapp.api.APPException;
import org.restcomm.protocols.ss7.commonapp.api.APPParsingComponentException;
import org.restcomm.protocols.ss7.commonapp.api.APPParsingComponentExceptionReason;

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
	protected static int DIGIT_1_MASK = 0x0F;
    protected static int DIGIT_2_MASK = 0xF0;

    protected static int DIGIT_MASK = 0xFF;

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
    	if(address.length()%2==0)
    		return address.length()/2;
    	else
    		return address.length()/2+1;
	}
    
    @ASNEncode
	public void encode(ASNParser parser,ByteBuf buffer) throws APPException {
    	encode(buffer);
    }
    
    public void encode(ByteBuf buffer) throws APPException {
    	char[] chars = address.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2) {
            char a = chars[i];

            int digit1 = encodeNumber(a);
            int digit2;
            if ((i + 1) == chars.length) {
                // add the filler instead
                digit2 = 15;
            } else {
                char b = chars[i + 1];
                digit2 = encodeNumber(b);
            }

            int digit = (digit1 << 4) | digit2;
            buffer.writeByte(digit);
        }
	}

    protected static int encodeNumber(char c) throws APPException {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case '*':
                return 10;
            case '#':
                return 11;
            case 'a':
            case 'A':
                return 12;
            case 'b':
            case 'B':
                return 13;
            case 'c':
            case 'C':
                return 14;
            default:
                throw new APPException(
                        "char should be between 0 - 9, *, #, a, b, c for Telephony Binary Coded Decimal String. Received " + c);

        }
    }
    
    @ASNDecode
	public Boolean decode(ASNParser parser,Object parent,ByteBuf buffer,Boolean skipErrors) throws APPParsingComponentException {
    	decode(buffer);
    	return false;
    }
    
    public void decode(ByteBuf buffer) throws APPParsingComponentException {
    	StringBuilder s = new StringBuilder();
        while (buffer.readableBytes()>0) {
            int b = buffer.readByte();

            int digit2 = ((b & DIGIT_2_MASK) >> 4);
            if (digit2 == 15) {
                // this is mask
            } else {
                s.append(decodeNumber(digit2));
            }
            
            int digit1 = (b & DIGIT_1_MASK);
            if (digit1 == 15) {
                // this is mask
            } else {
                s.append(decodeNumber(digit1));
            }

            
        }

        address = s.toString();
	}

    protected static char decodeNumber(int i) throws APPParsingComponentException {
        switch (i) {
            case 0:
                return '0';
            case 1:
                return '1';
            case 2:
                return '2';
            case 3:
                return '3';
            case 4:
                return '4';
            case 5:
                return '5';
            case 6:
                return '6';
            case 7:
                return '7';
            case 8:
                return '8';
            case 9:
                return '9';
            case 10:
                return '*';
            case 11:
                return '#';
            case 12:
                return 'a';
            case 13:
                return 'b';
            case 14:
                return 'c';
                // case 15:
                // return 'd';
            default:
                throw new APPParsingComponentException(
                        "Integer should be between 0 - 15 for Telephony Binary Coded Decimal String. Received " + i,
                        APPParsingComponentExceptionReason.MistypedParameter);

        }
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
