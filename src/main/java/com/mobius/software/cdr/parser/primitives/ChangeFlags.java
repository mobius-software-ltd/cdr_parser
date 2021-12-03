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
public class ChangeFlags extends ASNBitString {
	private static final int _INDEX_CALLING_PARTY_NUMBER = 0;
    private static final int _INDEX_CALLING_PARTY_CATEGORY = 1;
    private static final int _INDEX_ORIGINAL_CALLED_PART_NUMBER = 2;
    private static final int _INDEX_GENERIC_NUMBERS = 3;
    private static final int _INDEX_REDIRECTING_PARTY_NUMBER = 4;
    private static final int _INDEX_REDIRECTION_COUNTER = 5;

    public ChangeFlags() {
    }

    public ChangeFlags(boolean callingPartyNumberModified, boolean callingPartyCategoryModified, boolean originalCalledPartyNumberModified,
    		boolean genericNumbersModified, boolean redirectingPartyNumberModified, boolean redirectionCounterModified) {        

    	if (callingPartyNumberModified)
            this.setBit(_INDEX_CALLING_PARTY_NUMBER);
        if (callingPartyCategoryModified)
            this.setBit(_INDEX_CALLING_PARTY_CATEGORY);
        if (originalCalledPartyNumberModified)
            this.setBit(_INDEX_ORIGINAL_CALLED_PART_NUMBER);        
        if (genericNumbersModified)
            this.setBit(_INDEX_GENERIC_NUMBERS);
        if (redirectingPartyNumberModified)
            this.setBit(_INDEX_REDIRECTING_PARTY_NUMBER);
        if (redirectionCounterModified)
            this.setBit(_INDEX_REDIRECTION_COUNTER);
    }

    public boolean getCallingPartyNumberModified() {
        return this.isBitSet(_INDEX_CALLING_PARTY_NUMBER);
    }

    public boolean getCallingPartyCategoryModified() {
        return this.isBitSet(_INDEX_CALLING_PARTY_CATEGORY);
    }

    public boolean getOriginalCalledPartyNumberModified() {
        return this.isBitSet(_INDEX_ORIGINAL_CALLED_PART_NUMBER);
    }

    public boolean getGenericNumbersModified() {
        return this.isBitSet(_INDEX_GENERIC_NUMBERS);
    }

    public boolean getRedirectingPartyNumberModified() {
        return this.isBitSet(_INDEX_REDIRECTING_PARTY_NUMBER);
    }

    public boolean getRedirectionCounterModified() {
        return this.isBitSet(_INDEX_REDIRECTION_COUNTER);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("ChangeFlags [");

        if (getCallingPartyNumberModified()) {
            sb.append("callingPartyNumberModified, ");
        }
        if (getCallingPartyCategoryModified()) {
            sb.append("callingPartyCategoryModified, ");
        }
        if (getOriginalCalledPartyNumberModified()) {
            sb.append("originalCalledPartyNumberModified, ");
        }

        if (getGenericNumbersModified()) {
            sb.append("genericNumbersModified, ");
        }
        if (getRedirectingPartyNumberModified()) {
            sb.append("redirectingPartyNumberModified, ");
        }
        if (getRedirectionCounterModified()) {
            sb.append("redirectionCounterModified, ");
        }

        sb.append("]");

        return sb.toString();
    }
}