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
package com.mobius.software.cdr.parser.primitives;

import io.netty.buffer.ByteBuf;

import java.util.concurrent.ConcurrentHashMap;

import org.restcomm.protocols.ss7.map.api.MAPException;

import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.ASNParser;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNDecode;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNEncode;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNLength;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;

/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass=ASNClass.UNIVERSAL,tag=4,constructed=false,lengthIndefinite=false)
public class MSTimezone {
	private int timeZone;
	private int offset;
    
	public MSTimezone() {
    }

    public MSTimezone(int timeZone,int offset) {
        this.timeZone = timeZone;
        this.offset = offset;
    }

    @ASNLength
   	public Integer getLength(ASNParser parser) {
    	return 2;
    }
       
    @ASNEncode
   	public void encode(ASNParser parser,ByteBuf buffer) throws MAPException {
    	encodeData(buffer);
    }
       
    @ASNDecode
   	public Boolean decode(ASNParser parser,Object parent,ByteBuf buffer,ConcurrentHashMap<Integer,Object> mappedData,Boolean skipErrors) throws MAPException {
       	createMessage(buffer);
       	return false;
    }
       
    public static MSTimezone createMessage(ByteBuf data) throws MAPException {

        if (data == null)
            throw new MAPException("Error creating MSTimestamp: stream must not be null");

        if (data.readableBytes() < 2)
            throw new MAPException("Error creating MSTimestamp: not enought data in the stream");

        
        MSTimezone res = new MSTimezone();
        byte[] buf = new byte[2];
        data.readBytes(buf);
        res.timeZone = constractDigitVal((byte) (buf[0] & 0xF7));
        if ((buf[0] & 0x08) != 0)
            res.timeZone = -res.timeZone;
        
        res.offset=constractDigitVal((byte) (buf[1] & 0x03));
        return res;
    }

    private static int constractDigitVal(byte bt) {
        return (bt & 0xF) * 10 + ((bt & 0xF0) >>> 4);
    }

    public int getTimeZone() {
        return timeZone;
    }
    
    public int getOffset() {
        return offset;
    }

    private static int constractEncodesVal(int val) {
        int i1 = val % 10;
        int i2 = val / 10;
        return (i1 << 4) | i2;
    }

    public void encodeData(ByteBuf stm) throws MAPException {
    	stm.writeByte(constractEncodesVal(this.offset));
        if (this.timeZone >= 0)
            stm.writeByte(constractEncodesVal(this.timeZone));
        else
            stm.writeByte(constractEncodesVal((-this.timeZone)) | 0x08);
        
        stm.writeByte(constractEncodesVal(this.offset));        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("TimeZone [");

        if (this.timeZone >= 0)
            sb.append("+");
        sb.append(this.timeZone / 4);
        sb.append(":");
        sb.append((this.timeZone % 4) * 15);

        sb.append(" ");
        sb.append(this.offset);
        sb.append("]");

        return sb.toString();
    }
}
