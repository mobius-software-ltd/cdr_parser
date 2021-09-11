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
public enum RATType {
    utran(1), geran(2), wlan(3), gan(4), hspa_evolution(5), eUtran(6), virtual(7), eutran_nb_iot(8), lte_m(9), ieee_802_16e(101), eHRPD(102), hrpd(103), onexrtt(104), umb(105);

    private int code;

    private RATType(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static RATType getInstance(int code) {
        switch (code) {
            case 1:
                return RATType.utran;
            case 2:
                return RATType.geran;
            case 3:
                return RATType.wlan;
            case 4:
                return RATType.gan;
            case 5:
                return RATType.hspa_evolution;
            case 6:
                return RATType.eUtran;
            case 7:
                return RATType.virtual;
            case 8:
                return RATType.eutran_nb_iot;
            case 9:
                return RATType.lte_m;
            case 101:
                return RATType.ieee_802_16e;
            case 102:
                return RATType.eHRPD;
            case 103:
                return RATType.hrpd;
            case 104:
                return RATType.onexrtt;
            case 105:
                return RATType.umb;
            default:
                return null;
        }
    }
}
