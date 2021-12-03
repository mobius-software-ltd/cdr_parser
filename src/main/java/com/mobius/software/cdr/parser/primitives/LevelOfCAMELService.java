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

import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNBitString;

/**
 * @author yulian.oifa
 *
 */
public class LevelOfCAMELService extends ASNBitString {
	private static final int _INDEX_BASIC = 0;
    private static final int _INDEX_CALL_DURATION_SUPERVISION = 1;
    private static final int _INDEX_ONLINE_CHARGING = 2;

    public LevelOfCAMELService() {
    }

    public LevelOfCAMELService(boolean basic, boolean callDurationSupervision, boolean onlineCharging) {        

    	if (basic)
            this.setBit(_INDEX_BASIC);
        if (callDurationSupervision)
            this.setBit(_INDEX_CALL_DURATION_SUPERVISION);
        if (onlineCharging)
            this.setBit(_INDEX_ONLINE_CHARGING);
    }

    public boolean getBasic() {
        return this.isBitSet(_INDEX_BASIC);
    }

    public boolean getCallDurationSupervision() {
        return this.isBitSet(_INDEX_CALL_DURATION_SUPERVISION);
    }

    public boolean getOnlineCharging() {
        return this.isBitSet(_INDEX_ONLINE_CHARGING);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("LevelOfCAMELService [");

        if (getBasic()) {
            sb.append("basic, ");
        }
        if (getCallDurationSupervision()) {
            sb.append("callDurationSupervision, ");
        }
        if (getOnlineCharging()) {
            sb.append("onlineCharging, ");
        }

        sb.append("]");

        return sb.toString();
    }
}