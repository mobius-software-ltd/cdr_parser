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
public class ServiceConditionChange extends ASNBitString {
	private static final int _INDEX_QOS_CHANGE = 0;
    private static final int _INDEX__SGSN_CHANGE = 1;
    private static final int _INDEX_SGSN_PLMNID_CHANGE = 2;
    private static final int _INDEX_TARIFF_TIME_SWITCH = 3;
    private static final int _INDEX_PDP_CONTEXT_RELEASE = 4;
    private static final int _INDEX_RAT_CHANGE = 5;
    private static final int _INDEX_SERVICE_IDLED_OUT = 6;
    private static final int _INDEX_RESERVED = 7;
    private static final int _INDEX_CONFIGURATION_CHANGE = 8;
    private static final int _INDEX_SERVICE_STOP = 9;
    private static final int _INDEX_DCCA_TIME_THRESOLD_REACHED = 10;
    private static final int _INDEX_DCCA_VOLUME_THRESHOLD_REACHED = 11;
    private static final int _INDEX_DCCA_SERVICE_SPECIFIC_UNIT_THRESHOLD_REACHED = 12;
    private static final int _INDEX_DCCA_TIME_EXHAUSED = 13;
    private static final int _INDEX_DCCA_VOLUME_EXHAUSED = 14;
    private static final int _INDEX_DCCA_VALIDITY_TIMEOUT = 15;
    private static final int _INDEX_RESERVED_1 = 16;
    private static final int _INDEX_DCCA_REAUTHORIZATION_REQUEST = 17;
    private static final int _INDEX_DCCA_CONTINUE_ONGOING_SESSION = 18;
    private static final int _INDEX_DCCA_RETRY_AND_TERMINATE_ONGOING_SESSION = 19;
    private static final int _INDEX_DCCA_TERMINATE_ONGOING_SESSION = 20;
    private static final int _INDEX_CGI_SAI_CHANGE = 21;
    private static final int _INDEX_RAI_CHANGE = 22;
    private static final int _INDEX_DCCA_SERVICE_SPECIFIC_UNIT_EXHAUSTED = 23;
    private static final int _INDEX_RECORD_CLOSURE = 24;
    private static final int _INDEX_TIME_LIMIT = 25;
    private static final int _INDEX_VOLUME_LIMIT = 26;
    private static final int _INDEX_SERVICE_SPECIFIC_UNIT_LIMIT = 27;
    private static final int _INDEX_ENVELOPE_CLOSURE = 28;
    private static final int _INDEX_ECGI_CHANGE = 29;
    private static final int _INDEX_TAI_CHANGE = 30;
    private static final int _INDEX_USER_LOCATION_CHANGE = 31;

    public ServiceConditionChange() {
    }

    public ServiceConditionChange(boolean qoSChange, boolean sGSNChange, boolean sGSNPLMNIDChange,
            boolean tariffTimeSwitch,boolean pDPContextRelease, boolean rATChange, boolean serviceIdledOut,
            boolean reserved,boolean configurationChange, boolean serviceStop, boolean dCCATimeThresholdReached,
            boolean dCCAVolumeThresholdReached,boolean dCCAServiceSpecificUnitThresholdReached, boolean dCCATimeExhausted, boolean dCCAVolumeExhausted,
            boolean dCCAValidityTimeout,boolean reserved1, boolean dCCAReauthorisationRequest, boolean dCCAContinueOngoingSession,
            boolean dCCARetryAndTerminateOngoingSession,boolean dCCATerminateOngoingSession, boolean cGISAIChange, boolean rAIChange,
            boolean dCCAServiceSpecificUnitExhausted,boolean recordClosure, boolean timeLimit, boolean volumeLimit,
            boolean serviceSpecificUnitLimit,boolean envelopeClosure, boolean eCGIChange, boolean tAIChange,
            boolean userLocationChange) {        

    	if (qoSChange)
            this.setBit(_INDEX_QOS_CHANGE);
        if (sGSNChange)
            this.setBit(_INDEX__SGSN_CHANGE);
        if (sGSNPLMNIDChange)
            this.setBit(_INDEX_SGSN_PLMNID_CHANGE);
        if (tariffTimeSwitch)
            this.setBit(_INDEX_TARIFF_TIME_SWITCH);
        if (pDPContextRelease)
            this.setBit(_INDEX_PDP_CONTEXT_RELEASE);
        if (rATChange)
            this.setBit(_INDEX_RAT_CHANGE);
        if (serviceIdledOut)
            this.setBit(_INDEX_SERVICE_IDLED_OUT);
        if (reserved)
            this.setBit(_INDEX_RESERVED);
        if (configurationChange)
            this.setBit(_INDEX_CONFIGURATION_CHANGE);
        if (serviceStop)
            this.setBit(_INDEX_SERVICE_STOP);
        if (dCCATimeThresholdReached)
            this.setBit(_INDEX_DCCA_TIME_THRESOLD_REACHED);
        if (dCCAVolumeThresholdReached)
            this.setBit(_INDEX_DCCA_VOLUME_THRESHOLD_REACHED);
        if (dCCAServiceSpecificUnitThresholdReached)
            this.setBit(_INDEX_DCCA_SERVICE_SPECIFIC_UNIT_THRESHOLD_REACHED);
        if (dCCATimeExhausted)
            this.setBit(_INDEX_DCCA_TIME_EXHAUSED);
        if (dCCAVolumeExhausted)
            this.setBit(_INDEX_DCCA_VOLUME_EXHAUSED);
        if (dCCAValidityTimeout)
            this.setBit(_INDEX_DCCA_VALIDITY_TIMEOUT);
        if (reserved1)
            this.setBit(_INDEX_RESERVED_1);
        if (dCCAReauthorisationRequest)
            this.setBit(_INDEX_DCCA_REAUTHORIZATION_REQUEST);
        if (dCCAContinueOngoingSession)
            this.setBit(_INDEX_DCCA_CONTINUE_ONGOING_SESSION);
        if (dCCARetryAndTerminateOngoingSession)
            this.setBit(_INDEX_DCCA_RETRY_AND_TERMINATE_ONGOING_SESSION);
        if (dCCATerminateOngoingSession)
            this.setBit(_INDEX_DCCA_TERMINATE_ONGOING_SESSION);
        if (cGISAIChange)
            this.setBit(_INDEX_CGI_SAI_CHANGE);        
        if (rAIChange)
            this.setBit(_INDEX_RAI_CHANGE);
        if (dCCAServiceSpecificUnitExhausted)
            this.setBit(_INDEX_DCCA_SERVICE_SPECIFIC_UNIT_EXHAUSTED);
        if (recordClosure)
            this.setBit(_INDEX_RECORD_CLOSURE);
        if (timeLimit)
            this.setBit(_INDEX_TIME_LIMIT);
        if (volumeLimit)
            this.setBit(_INDEX_VOLUME_LIMIT);
        if (serviceSpecificUnitLimit)
            this.setBit(_INDEX_SERVICE_SPECIFIC_UNIT_LIMIT);
        if (envelopeClosure)
            this.setBit(_INDEX_ENVELOPE_CLOSURE);
        if (eCGIChange)
            this.setBit(_INDEX_ECGI_CHANGE);
        if (tAIChange)
            this.setBit(_INDEX_TAI_CHANGE);
        if (userLocationChange)
            this.setBit(_INDEX_USER_LOCATION_CHANGE);
    }

    public boolean getQoSChange() {
        return this.isBitSet(_INDEX_QOS_CHANGE);
    }

    public boolean getSGSNChange() {
        return this.isBitSet(_INDEX__SGSN_CHANGE);
    }

    public boolean getSGSNPLMNIDChange() {
        return this.isBitSet(_INDEX_SGSN_PLMNID_CHANGE);
    }

    public boolean getTariffTimeSwitch() {
        return this.isBitSet(_INDEX_TARIFF_TIME_SWITCH);
    }
    
    public boolean getPDPContextRelease() {
        return this.isBitSet(_INDEX_PDP_CONTEXT_RELEASE);
    }

    public boolean getRATChange() {
        return this.isBitSet(_INDEX_RAT_CHANGE);
    }

    public boolean getServiceIdledOut() {
        return this.isBitSet(_INDEX_SERVICE_IDLED_OUT);
    }

    public boolean getReserved() {
        return this.isBitSet(_INDEX_RESERVED);
    }
    
    public boolean getConfigurationChange() {
        return this.isBitSet(_INDEX_CONFIGURATION_CHANGE);
    }

    public boolean getServiceStop() {
        return this.isBitSet(_INDEX_SERVICE_STOP);
    }

    public boolean getDCCATimeThresholdReached() {
        return this.isBitSet(_INDEX_DCCA_TIME_THRESOLD_REACHED);
    }

    public boolean getDCCAVolumeThresholdReached() {
        return this.isBitSet(_INDEX_DCCA_VOLUME_THRESHOLD_REACHED);
    }
    
    public boolean getDCCAServiceSpecificUnitThresholdReached() {
        return this.isBitSet(_INDEX_DCCA_SERVICE_SPECIFIC_UNIT_THRESHOLD_REACHED);
    }

    public boolean getDCCATimeExhausted() {
        return this.isBitSet(_INDEX_DCCA_TIME_EXHAUSED);
    }

    public boolean getDCCAVolumeExhausted() {
        return this.isBitSet(_INDEX_DCCA_VOLUME_EXHAUSED);
    }

    public boolean getDCCAValidityTimeout() {
        return this.isBitSet(_INDEX_DCCA_VALIDITY_TIMEOUT);
    }
    
    public boolean getReserved1() {
        return this.isBitSet(_INDEX_RESERVED_1);
    }

    public boolean getDCCAReauthorisationRequest() {
        return this.isBitSet(_INDEX_DCCA_REAUTHORIZATION_REQUEST);
    }

    public boolean getDCCAContinueOngoingSession() {
        return this.isBitSet(_INDEX_DCCA_CONTINUE_ONGOING_SESSION);
    }

    public boolean getDCCARetryAndTerminateOngoingSession() {
        return this.isBitSet(_INDEX_DCCA_RETRY_AND_TERMINATE_ONGOING_SESSION);
    }
    
    public boolean getDCCATerminateOngoingSession() {
        return this.isBitSet(_INDEX_DCCA_TERMINATE_ONGOING_SESSION);
    }

    public boolean getCGISAIChange() {
        return this.isBitSet(_INDEX_CGI_SAI_CHANGE);
    }

    public boolean getRAIChange() {
        return this.isBitSet(_INDEX_RAI_CHANGE);
    }

    public boolean getDCCAServiceSpecificUnitExhausted() {
        return this.isBitSet(_INDEX_DCCA_SERVICE_SPECIFIC_UNIT_EXHAUSTED);
    }
    
    public boolean getRecordClosure() {
        return this.isBitSet(_INDEX_RECORD_CLOSURE);
    }

    public boolean getTimeLimit() {
        return this.isBitSet(_INDEX_TIME_LIMIT);
    }

    public boolean getVolumeLimit() {
        return this.isBitSet(_INDEX_VOLUME_LIMIT);
    }

    public boolean getServiceSpecificUnitLimit() {
        return this.isBitSet(_INDEX_SERVICE_SPECIFIC_UNIT_LIMIT);
    }
    
    public boolean getEnvelopeClosure() {
        return this.isBitSet(_INDEX_ENVELOPE_CLOSURE);
    }

    public boolean getECGIChange() {
        return this.isBitSet(_INDEX_ECGI_CHANGE);
    }

    public boolean getTAIChange() {
        return this.isBitSet(_INDEX_TAI_CHANGE);
    }

    public boolean getUserLocationChange() {
        return this.isBitSet(_INDEX_USER_LOCATION_CHANGE);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("DeferredLocationEventType [");

        if (getQoSChange()) {
            sb.append("qoSChange, ");
        }
        if (getSGSNChange()) {
            sb.append("SGSNChange, ");
        }
        if (getSGSNPLMNIDChange()) {
            sb.append("SGSNPLMNIDChange, ");
        }
        if (getTariffTimeSwitch()) {
            sb.append("tariffTimeSwitch, ");
        }
        if (getPDPContextRelease()) {
            sb.append("PDPContextRelease, ");
        }
        if (getRATChange()) {
            sb.append("RATChange, ");
        }
        if (getServiceIdledOut()) {
            sb.append("serviceIdledOut, ");
        }
        if (getReserved()) {
            sb.append("reserved, ");
        }
        if (getConfigurationChange()) {
            sb.append("configurationChange");
        }
        if (getServiceStop()) {
            sb.append("serviceStop, ");
        }
        if (getDCCATimeThresholdReached()) {
            sb.append("DCCATimeThresholdReached, ");
        }
        if (getDCCAVolumeThresholdReached()) {
            sb.append("DCCAVolumeThresholdReached, ");
        }
        if (getDCCAServiceSpecificUnitThresholdReached()) {
            sb.append("DCCAServiceSpecificUnitThresholdReached, ");
        }
        if (getDCCATimeExhausted()) {
            sb.append("DCCATimeExhausted, ");
        }
        if (getDCCAVolumeExhausted()) {
            sb.append("DCCAVolumeExhausted, ");
        }
        if (getDCCAValidityTimeout()) {
            sb.append("DCCAValidityTimeout, ");
        }
        if (getReserved1()) {
            sb.append("reserved1, ");
        }
        if (getDCCAReauthorisationRequest()) {
            sb.append("DCCAReauthorisationRequest, ");
        }
        if (getDCCAContinueOngoingSession()) {
            sb.append("DCCAContinueOngoingSession, ");
        }
        if (getDCCARetryAndTerminateOngoingSession()) {
            sb.append("DCCARetryAndTerminateOngoingSession, ");
        }
        if (getDCCATerminateOngoingSession()) {
            sb.append("DCCATerminateOngoingSession, ");
        }
        if (getCGISAIChange()) {
            sb.append("CGISAIChange, ");
        }
        if (getRAIChange()) {
            sb.append("RAIChange, ");
        }
        if (getDCCAServiceSpecificUnitExhausted()) {
            sb.append("DCCAServiceSpecificUnitExhausted, ");
        }
        if (getRecordClosure()) {
            sb.append("recordClosure, ");
        }
        if (getTimeLimit()) {
            sb.append("timeLimit, ");
        }
        if (getVolumeLimit()) {
            sb.append("volumeLimit, ");
        }
        if (getServiceSpecificUnitLimit()) {
            sb.append("serviceSpecificUnitLimit, ");
        }
        if (getEnvelopeClosure()) {
            sb.append("envelopeClosure, ");
        }
        if (getECGIChange()) {
            sb.append("ECGIChange, ");
        }
        if (getTAIChange()) {
            sb.append("TAIChange, ");
        }
        if (getUserLocationChange()) {
            sb.append("userLocationChange, ");
        }

        sb.append("]");

        return sb.toString();
    }
}