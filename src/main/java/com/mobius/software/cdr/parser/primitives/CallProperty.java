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
public enum CallProperty {
    Unknown_Call(0),Intra_Office_Call(1), Local_Call(2), Local_Toll_Call(3), National_Toll_Call(4), International_Toll_Call(5), Intra_Local_Toll_Call(6), Intra_National_Toll_Call(7), Intra_Inter_Toll_Call(8), New_Service_Call(17);

    private int code;

    private CallProperty(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static CallProperty getInstance(int code) {
        switch (code) {
        	case 0:
            	return CallProperty.Unknown_Call;
        	case 1:
                return CallProperty.Intra_Office_Call;
            case 2:
                return CallProperty.Local_Call;
            case 3:
                return CallProperty.Local_Toll_Call;
            case 4:
                return CallProperty.National_Toll_Call;
            case 5:
                return CallProperty.International_Toll_Call;
            case 6:
                return CallProperty.Intra_Local_Toll_Call;
            case 7:
                return CallProperty.Intra_National_Toll_Call;
            case 8:
                return CallProperty.Intra_Inter_Toll_Call;
            case 17:
                return CallProperty.New_Service_Call;
            default:
                return null;
        }
    }
}