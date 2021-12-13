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
/*
 NNIType ::= ENUMERATED
{
 non-roaming (0),
 roaming-without-loopback (1),
 roaming-with-loopback (2)
} 
 */
/**
 * @author yulian.oifa
 *
 */
public enum NNIType {
    non_roaming(0), roaming_without_loopback(1), roaming_with_loopback(2);

    private int type;

    private NNIType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public static NNIType getInstance(int type) {
        switch (type) {
        	case 0:	
            	return NNIType.non_roaming;
        	case 1:
                return NNIType.roaming_without_loopback;
            case 2:
                return NNIType.roaming_with_loopback;
            default:
                return null;
        }
    }
}
