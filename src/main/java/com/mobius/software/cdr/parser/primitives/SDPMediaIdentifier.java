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
/**
 * @author yulian.oifa
 *
 */
public enum SDPMediaIdentifier {
    Voice(0),Video(1), Fax(2), CSD(3), PABX(4), Text(5);

    private int code;

    private SDPMediaIdentifier(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static SDPMediaIdentifier getInstance(int code) {
        switch (code) {
        	case 0:
            	return SDPMediaIdentifier.Voice;
        	case 1:
                return SDPMediaIdentifier.Video;
            case 2:
                return SDPMediaIdentifier.Fax;
            case 3:
                return SDPMediaIdentifier.CSD;
            case 4:
                return SDPMediaIdentifier.PABX;
            case 5:
                return SDPMediaIdentifier.Text;
            default:
                return null;
        }
    }
}