package com.mobius.software.cdr.parser.primitives;
import java.util.concurrent.ConcurrentHashMap;

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
import org.restcomm.protocols.ss7.map.api.MAPException;

import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.ASNParser;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNDecode;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNEncode;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNLength;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;

import io.netty.buffer.ByteBuf;
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass=ASNClass.UNIVERSAL,tag=4,constructed=false,lengthIndefinite=false)
public class TimeStamp {
	private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private char timeZoneSign;
    private int timeZoneHours;
    private int timeZoneMinutes;

    public TimeStamp() {
    }

    public TimeStamp(int year, int month, int day, int hour, int minute, int second, char timeZoneSign,int timeZoneHours,int timeZoneMinutes) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.timeZoneSign=timeZoneSign;
        this.timeZoneHours = timeZoneHours;
        this.timeZoneMinutes = timeZoneMinutes;
    }

    @ASNLength
	public Integer getLength(ASNParser parser) {
    	return 9;
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
    
    public void createMessage(ByteBuf data) throws MAPException {

        if (data == null)
            throw new MAPException("Error creating ServiceCentreTimeStamp: stream must not be null");

        if (data.readableBytes() < 9)
            throw new MAPException("Error creating ServiceCentreTimeStamp: not enouph data in the stream");
        
        byte[] buf = new byte[9];
        data.readBytes(buf);
        year = constractDigitVal(buf[0]);
        month = constractDigitVal(buf[1]);
        day = constractDigitVal(buf[2]);
        hour = constractDigitVal(buf[3]);
        minute = constractDigitVal(buf[4]);
        second = constractDigitVal(buf[5]);
        if(buf[6]=='-')
        	timeZoneSign='-';
        else
        	timeZoneSign='+';
        
        timeZoneHours = constractDigitVal(buf[7]);
        timeZoneMinutes = constractDigitVal(buf[8]);        
    }

    private static int constractDigitVal(byte bt) {
        return (bt & 0xF) + ((bt & 0xF0) >>> 4) * 10;
    }

    public String getValue() {
    	StringBuilder sb = new StringBuilder();

        int yr;
        if (this.year > 90)
            yr = 1900 + this.year;
        else
            yr = 2000 + this.year;
        sb.append(this.month);
        sb.append("/");
        sb.append(this.day);
        sb.append("/");
        sb.append(yr);

        sb.append(" ");
        sb.append(this.hour);
        sb.append(":");
        sb.append(this.minute);
        sb.append(":");
        sb.append(this.second);

        sb.append(" GMT");
        sb.append(timeZoneSign);
        sb.append(this.timeZoneHours);
        sb.append(":");
        sb.append(this.timeZoneMinutes);

        return sb.toString();
    }

    private static int constractEncodesVal(int val) {
        int i1 = val % 10;
        int i2 = val / 10;
        return (i2 << 4) | i1;
    }

    public void encodeData(ByteBuf stm) throws MAPException {
    	stm.writeByte(constractEncodesVal(this.year));
        stm.writeByte(constractEncodesVal(this.month));
        stm.writeByte(constractEncodesVal(this.day));
        stm.writeByte(constractEncodesVal(this.hour));
        stm.writeByte(constractEncodesVal(this.minute));
        stm.writeByte(constractEncodesVal(this.second));
        stm.writeChar(timeZoneSign);
        stm.writeByte(constractEncodesVal(this.timeZoneHours));        
        stm.writeByte(constractEncodesVal(this.timeZoneMinutes));        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Timestamp [");

        int yr;
        if (this.year > 90)
            yr = 1900 + this.year;
        else
            yr = 2000 + this.year;
        sb.append(this.month);
        sb.append("/");
        sb.append(this.day);
        sb.append("/");
        sb.append(yr);

        sb.append(" ");
        sb.append(this.hour);
        sb.append(":");
        sb.append(this.minute);
        sb.append(":");
        sb.append(this.second);

        sb.append(" GMT");
        sb.append(timeZoneSign);
        sb.append(this.timeZoneHours);
        sb.append(":");
        sb.append(this.timeZoneMinutes);

        sb.append("]");

        return sb.toString();
    }
}
