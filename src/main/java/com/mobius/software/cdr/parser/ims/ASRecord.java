package com.mobius.software.cdr.parser.ims;
import java.util.ArrayList;
import java.util.List;

import org.restcomm.protocols.ss7.commonapp.primitives.AddressStringImpl;

import com.mobius.software.cdr.parser.primitives.ASNAccountingRecordType;
import com.mobius.software.cdr.parser.primitives.ASNCallProperty;
import com.mobius.software.cdr.parser.primitives.ASNCauseForRecordClosing;
import com.mobius.software.cdr.parser.primitives.ASNChargingCategory;
import com.mobius.software.cdr.parser.primitives.ASNOnlineChargingFlag;
import com.mobius.software.cdr.parser.primitives.ASNRecordType;
import com.mobius.software.cdr.parser.primitives.ASNRoleOfNode;
import com.mobius.software.cdr.parser.primitives.ASNSDPMediaIdentifier;
import com.mobius.software.cdr.parser.primitives.ASNSessionPriority;
import com.mobius.software.cdr.parser.primitives.ASNTADSIndication;
import com.mobius.software.cdr.parser.primitives.ASNThreeGPPPSDataOffStatus;
import com.mobius.software.cdr.parser.primitives.AccessNetworkInfoChange;
import com.mobius.software.cdr.parser.primitives.AccessTransferInformation;
import com.mobius.software.cdr.parser.primitives.AccountingRecordType;
import com.mobius.software.cdr.parser.primitives.CallProperty;
import com.mobius.software.cdr.parser.primitives.CalledIdentityChange;
import com.mobius.software.cdr.parser.primitives.CauseForRecordClosing;
import com.mobius.software.cdr.parser.primitives.ChargingCategory;
import com.mobius.software.cdr.parser.primitives.EarlyMediaComponentList;
import com.mobius.software.cdr.parser.primitives.InInformation;
import com.mobius.software.cdr.parser.primitives.InInformationListWrapper;
import com.mobius.software.cdr.parser.primitives.IncompleteCDRIndication;
import com.mobius.software.cdr.parser.primitives.InterOperatorIdentifiers;
import com.mobius.software.cdr.parser.primitives.InterOperatorIdentifiersListWrapper;
import com.mobius.software.cdr.parser.primitives.InvolvedParty;
import com.mobius.software.cdr.parser.primitives.InvolvedPartyListWrapper;
import com.mobius.software.cdr.parser.primitives.InvolvedPartyWrapper;
import com.mobius.software.cdr.parser.primitives.MMTelInformation;
import com.mobius.software.cdr.parser.primitives.MSTimezone;
import com.mobius.software.cdr.parser.primitives.MediaComponentList;
import com.mobius.software.cdr.parser.primitives.MediaComponentListWrapper;
import com.mobius.software.cdr.parser.primitives.MessageBody;
import com.mobius.software.cdr.parser.primitives.NNIInformation;
import com.mobius.software.cdr.parser.primitives.NodeAddress;
import com.mobius.software.cdr.parser.primitives.NodeAddressWrapper;
import com.mobius.software.cdr.parser.primitives.OnlineChargingFlag;
import com.mobius.software.cdr.parser.primitives.PrivateUserEquipmentInfo;
import com.mobius.software.cdr.parser.primitives.RealTimeTariffInformation;
import com.mobius.software.cdr.parser.primitives.RecordType;
import com.mobius.software.cdr.parser.primitives.RoleOfNode;
import com.mobius.software.cdr.parser.primitives.SDPMediaIdentifier;
import com.mobius.software.cdr.parser.primitives.ServiceSpecificInfo;
import com.mobius.software.cdr.parser.primitives.SessionPriority;
import com.mobius.software.cdr.parser.primitives.SpecifiedTreatmentField;
import com.mobius.software.cdr.parser.primitives.SubscriberEquipmentNumber;
import com.mobius.software.cdr.parser.primitives.SubscriptionID;
import com.mobius.software.cdr.parser.primitives.SubscriptionIDListWrapper;
import com.mobius.software.cdr.parser.primitives.TADIdentifier;
import com.mobius.software.cdr.parser.primitives.TADSIndication;
import com.mobius.software.cdr.parser.primitives.ThreeGPPPSDataOffStatus;
import com.mobius.software.cdr.parser.primitives.TimeStamp;
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
import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNGraphicString;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNNull;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNUTF8String;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/*
ASRecord ::= SET
{
 recordType [0] RecordType,
 retransmission [1] NULL OPTIONAL,
 sIP-Method [2] SIP-Method OPTIONAL,
 role-of-Node [3] Role-of-Node OPTIONAL,
 nodeAddress [4] NodeAddress OPTIONAL,
 session-Id [5] Session-Id OPTIONAL,
 list-Of-Calling-Party-Address [6] ListOfInvolvedParties OPTIONAL,
 called-Party-Address [7] InvolvedParty OPTIONAL,
 privateUserID [8] GraphicString OPTIONAL,
 serviceRequestTimeStamp [9] TimeStamp OPTIONAL,
 serviceDeliveryStartTimeStamp [10] TimeStamp OPTIONAL,
 serviceDeliveryEndTimeStamp [11] TimeStamp OPTIONAL,
 recordOpeningTime [12] TimeStamp OPTIONAL,
 recordClosureTime [13] TimeStamp OPTIONAL,
 interOperatorIdentifiers [14] InterOperatorIdentifiers OPTIONAL,
 localRecordSequenceNumber [15] LocalSequenceNumber OPTIONAL,
 recordSequenceNumber [16] INTEGER OPTIONAL,
 causeForRecordClosing [17] CauseForRecordClosing OPTIONAL,
 incomplete-CDR-Indication [18] Incomplete-CDR-Indication OPTIONAL,
 iMS-Charging-Identifier [19] IMS-Charging-Identifier OPTIONAL,
 list-Of-SDP-Media-Components [21] SEQUENCE OF Media-Components-List OPTIONAL,
 gGSNaddress [22] NodeAddress OPTIONAL,
 serviceReasonReturnCode [23] UTF8String OPTIONAL,
 list-Of-Message-Bodies [24] SEQUENCE OF MessageBody OPTIONAL,
 recordExtensions [25] ManagementExtensions OPTIONAL,
 expiresInformation [26] INTEGER OPTIONAL,
 event [28] UTF8String OPTIONAL,
 accessNetworkInformation [29] OCTET STRING OPTIONAL,
 serviceContextID [30] ServiceContextID OPTIONAL,
 list-of-subscription-ID [31] SEQUENCE OF SubscriptionID OPTIONAL,
 list-Of-Early-SDP-Media-Components [32] SEQUENCE OF Early-Media-Components-List OPTIONAL,
 iMSCommunicationServiceIdentifier [33] IMSCommunicationServiceIdentifier OPTIONAL,
 numberPortabilityRouting [34] NumberPortabilityRouting OPTIONAL,
 carrierSelectRouting [35] CarrierSelectRouting OPTIONAL,
 sessionPriority [36] SessionPriority OPTIONAL,
 serviceRequestTimeStampFraction [37] Milliseconds OPTIONAL,
 serviceDeliveryStartTimeStampFraction [38] Milliseconds OPTIONAL,
 serviceDeliveryEndTimeStampFraction [39] Milliseconds OPTIONAL,
 list-of-Requested-Party-Address [41] ListOfInvolvedParties OPTIONAL,
 online-charging-flag [43] NULL OPTIONAL,
 realTimeTariffInformation [44] SEQUENCE OF RealTimeTariffInformation OPTIONAL,
 nNI-Information [46] NNI-Information OPTIONAL,
 userLocationInformation [47] OCTET STRING OPTIONAL,
 mSTimeZone [48] MSTimeZone OPTIONAL,
 fromAddress [51] OCTET STRING OPTIONAL,
 transit-IOI-Lists [53] TransitIOILists OPTIONAL,
 iMSVisitedNetworkIdentifier [54] OCTET STRING OPTIONAL,
 listOfReasonHeader [55] ListOfReasonHeader OPTIONAL,
 additionalAccessNetworkInformation [56] OCTET STRING OPTIONAL,
 instanceId [57] OCTET STRING OPTIONAL,
 subscriberEquipmentNumber [58] SubscriberEquipmentNumber OPTIONAL,
 list-Of-AccessNetworkInfoChange [62] SEQUENCE OF AccessNetworkInfoChange OPTIONAL,
 listOfCalledIdentityChanges [63] SEQUENCE OF CalledIdentityChange OPTIONAL,
 cellularNetworkInformation [64] OCTET STRING OPTIONAL,
 serviceSpecificInfo [100] SEQUENCE OF ServiceSpecificInfo OPTIONAL,
 requested-Party-Address [101] InvolvedParty OPTIONAL,
 list-Of-Called-Asserted-Identity [102] ListOfInvolvedParties OPTIONAL,
 alternateChargedPartyAddress [103] UTF8String OPTIONAL,
 outgoingSessionId [104] Session-Id OPTIONAL,
 initialIMS-Charging-Identifier [105] IMS-Charging-Identifier OPTIONAL,
 list-Of-AccessTransferInformation [106] SEQUENCE OF AccessTransferInformation OPTIONAL,
 tADS-Identifier [109] TADIdentifier OPTIONAL,
 vlr-Number [110] MSCAddress OPTIONAL,
 msc-Address [111] MSCAddress OPTIONAL,
 threeGPPPSDataOffStatus [112] ThreeGPPPSDataOffStatus OPTIONAL,
 fEIdentifierList [113] FEIdentifierList OPTIONAL
} 

HAWEI ADDITIONAL DATA
{
 mMTelInformation [110] mMTelInformation OPTIONAL,
 onlineChargingFlag [150] OnlineChargingFlag OPTIONAL,
 charged-party [156] InvolvedParty OPTIONAL,
 duration [200] INTEGER OPTIONAL,
 ringing-duration [200] INTEGER OPTIONAL,
 dialed-party-address [203] InvolvedParty OPTIONAL,
 chargingCategory [216] ChargingCategory OPTIONAL,
 call-property [222] CallProperty OPTIONAL,
 accountingRecordType [227] AccountingRecordType OPTIONAL,
 sdpMediaIdentifier [233] SDPMediaIdentifier OPTIONAL,
 mscNumber [235] UTF8String OPTIONAL,
 TADS-Indication [410] TADS-Indication OPTIONAL
 List-Of-IN-Information [413] List-Of-IN-Information OPTIONAL
 PrivateUserEquipmentInfo [418] PrivateUserEquipmentInfo OPTIONAL
 Recording-Entity-ID [429] UTF8String OPTIONAL
 SpecifiedTreatmentField [446] SpecifiedTreatmentField OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 69,constructed = true,lengthIndefinite = false)
public class ASRecord 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNRecordType recordType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNNull retransmission;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNGraphicString sipMethod;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNRoleOfNode roleOfNode;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = true,index = -1)
	private NodeAddressWrapper nodeAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private ASNGraphicString sessionID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = true,index = -1)
	private InvolvedPartyListWrapper listOfCallingPartyAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = true,index = -1)
	private InvolvedPartyWrapper calledPartyAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private ASNGraphicString privateUserID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = false,index = -1)
	private TimeStamp serviceRequestTimeStamp;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 10,constructed = false,index = -1)
	private TimeStamp serviceDeliveryStartTimeStamp;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 11,constructed = false,index = -1)
	private TimeStamp serviceDeliveryEndTimeStamp;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 12,constructed = false,index = -1)
	private TimeStamp recordOpeningTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 13,constructed = false,index = -1)
	private TimeStamp recordClosureTime;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 14,constructed = true,index = -1)
	private InterOperatorIdentifiersListWrapper interOperatorIdentifiers;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 15,constructed = false,index = -1)
	private ASNInteger localSequenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 16,constructed = false,index = -1)
	private ASNInteger recordSequenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 17,constructed = false,index = -1)
	private ASNCauseForRecordClosing causeForRecordClosing;	
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 18,constructed = true,index = -1)
	private IncompleteCDRIndication incompleteCDRIndication;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 19,constructed = false,index = -1)
	private ASNOctetString imsChargingIdentifier;		
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 21,constructed = true,index = -1)
	private MediaComponentListWrapper mediaComponentList;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 22,constructed = true,index = -1)
	private NodeAddressWrapper ggsnAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 23,constructed = false,index = -1)
	private ASNUTF8String serviceReasonReturnCode;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 24,constructed = true,index = -1)
	private List<MessageBody> listOfMessageBodies;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 25,constructed = true,index = -1)
	private ASNOctetString recordExtensions;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 26,constructed = false,index = -1)
	private ASNInteger expiresInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 28,constructed = false,index = -1)
	private ASNUTF8String event;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 29,constructed = false,index = -1)
	private ASNOctetString accessNetworkInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 30,constructed = false,index = -1)
	private ASNUTF8String serviceContextID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 31,constructed = true,index = -1)
	private SubscriptionIDListWrapper listOfSubscriptionID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 32,constructed = true,index = -1)
	private List<EarlyMediaComponentList> listOfEarlySDPMediaComponents; 
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 33,constructed = false,index = -1)
	private ASNOctetString imsCommunicationServiceIdentifier;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 34,constructed = false,index = -1)
	private ASNGraphicString numberPortabilityRouting;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 35,constructed = false,index = -1)
	private ASNGraphicString carrierSelectRouting;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 36,constructed = false,index = -1)
	private ASNSessionPriority sessionPriority;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 37,constructed = false,index = -1)
	private ASNInteger serviceRequestTimeStampFraction;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 38,constructed = false,index = -1)
	private ASNInteger serviceDeliveryStartTimeStampFraction;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 39,constructed = false,index = -1)
	private ASNInteger serviceDeliveryEndTimeStampFraction;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 41,constructed = true,index = -1)
	private InvolvedPartyListWrapper listOfRequestedPartyAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 43,constructed = false,index = -1)
	private ASNNull onlineChargingFlag;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 44,constructed = true,index = -1)
	private List<RealTimeTariffInformation> realTimeTariffInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 46,constructed = true,index = -1)
	private NNIInformation nniInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 47,constructed = false,index = -1)
	private ASNOctetString userLocationInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 48,constructed = false,index = -1)
	private MSTimezone msTimeZone;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 51,constructed = false,index = -1)
	private ASNOctetString fromAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 53,constructed = false,index = -1)
	private List<ASNGraphicString>  transitIOILists;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 54,constructed = false,index = -1)
	private ASNOctetString imsVisitedNetworkIdentifier;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 55,constructed = false,index = -1)
	private List<ASNGraphicString>  listOfReasonHeader;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 56,constructed = false,index = -1)
	private ASNOctetString additionalAccessNetworkInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 57,constructed = false,index = -1)
	private ASNOctetString instanceId;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 58,constructed = true,index = -1)
	private SubscriberEquipmentNumber subscriberEquipmentNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 62,constructed = true,index = -1)
	private List<AccessNetworkInfoChange> listOfAccessNetworkInfoChange;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 63,constructed = true,index = -1)
	private List<CalledIdentityChange> listOfCalledIdentityChanges;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 64,constructed = false,index = -1)
	private ASNOctetString cellularNetworkInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 100,constructed = true,index = -1)
	private List<ServiceSpecificInfo> serviceSpecificInfo;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 101,constructed = true,index = -1)
	private InvolvedPartyWrapper requestedPartyAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 102,constructed = true,index = -1)
	private InvolvedPartyListWrapper listOfCalledAssertedIdentity;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 103,constructed = false,index = -1)
	private ASNUTF8String alternateChargedPartyAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 104,constructed = false,index = -1)
	private ASNGraphicString outgoingSessionID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 105,constructed = false,index = -1)
	private ASNOctetString initialIMSChargingIdentifier;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 106,constructed = true,index = -1)
	private List<AccessTransferInformation> listOfAccessTransferInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 109,constructed = true,index = -1)
	private TADIdentifier tadsIdentifier;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 110,constructed = false,index = -1)
	private AddressStringImpl vlrNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 110,constructed = true,index = -1)
	private MMTelInformation mMTelInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 111,constructed = false,index = -1)
	private AddressStringImpl mscAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 112,constructed = false,index = -1)
	private ASNThreeGPPPSDataOffStatus threeGPPPSDataOffStatus;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 113,constructed = false,index = -1)
	private List<ASNGraphicString> fEIdentifierList;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 150,constructed = false,index = -1)
	private ASNOnlineChargingFlag onlineChargingFlagEnum;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 156,constructed = true,index = -1)
	private InvolvedPartyWrapper chargedParty;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 200,constructed = false,index = -1)
	private ASNInteger duration;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 203,constructed = true,index = -1)
	private InvolvedPartyWrapper dialedPartyAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 204,constructed = false,index = -1)
	private ASNInteger ringingDuration;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 216,constructed = false,index = -1)
	private ASNChargingCategory chargingCategory;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 222,constructed = false,index = -1)
	private ASNCallProperty callProperty;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 227,constructed = false,index = -1)
	private ASNAccountingRecordType accountingRecordType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 233,constructed = false,index = -1)
	private ASNSDPMediaIdentifier sdpMediaIdentifier;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 235,constructed = false,index = -1)
	private ASNUTF8String mscNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 410,constructed = false,index = -1)
	private ASNTADSIndication tadsIndication;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 413,constructed = true,index = -1)
	private InInformationListWrapper inInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 418,constructed = true,index = -1)
	private PrivateUserEquipmentInfo privateUserEquipmentInfo;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 429,constructed = false,index = -1)
	private ASNUTF8String recordingEntityID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 446,constructed = true,index = -1)
	private SpecifiedTreatmentField specifiedTreatmentField;
	
	public ASRecord()
	{
		
	}

	public ASRecord(RecordType recordType, boolean retransmission, String sipMethod,
			RoleOfNode roleOfNode, NodeAddress nodeAddress, String sessionID,
			List<InvolvedParty> listOfCallingPartyAddress, InvolvedParty calledPartyAddress,
			String privateUserID, TimeStamp serviceRequestTimeStamp, TimeStamp serviceDeliveryStartTimeStamp,
			TimeStamp serviceDeliveryEndTimeStamp, TimeStamp recordOpeningTime, TimeStamp recordClosureTime,
			List<InterOperatorIdentifiers> interOperatorIdentifiers, Integer localSequenceNumber,
			Integer recordSequenceNumber, CauseForRecordClosing causeForRecordClosing,
			IncompleteCDRIndication incompleteCDRIndication, byte[] imsChargingIdentifier,
			List<MediaComponentList> mediaComponentList, NodeAddress ggsnAddress,
			String serviceReasonReturnCode, List<MessageBody> listOfMessageBodies,
			byte[] recordExtensions, Integer expiresInformation, String event,
			byte[] accessNetworkInformation, String serviceContextID,
			List<SubscriptionID> listOfSubscriptionID, List<EarlyMediaComponentList> listOfEarlySDPMediaComponents,
			byte[] imsCommunicationServiceIdentifier, String numberPortabilityRouting,
			String carrierSelectRouting, SessionPriority sessionPriority,
			Integer serviceRequestTimeStampFraction, Integer serviceDeliveryStartTimeStampFraction,
			Integer serviceDeliveryEndTimeStampFraction, List<InvolvedParty> listOfRequestedPartyAddress,
			boolean onlineChargingFlag, List<RealTimeTariffInformation> realTimeTariffInformation,
			NNIInformation nniInformation, byte[] userLocationInformation, MSTimezone msTimeZone,
			byte[] fromAddress, List<String> transitIOILists,
			byte[] imsVisitedNetworkIdentifier, List<String> listOfReasonHeader,
			byte[] additionalAccessNetworkInformation, byte[] instanceId,
			SubscriberEquipmentNumber subscriberEquipmentNumber,
			List<AccessNetworkInfoChange> listOfAccessNetworkInfoChange,
			List<CalledIdentityChange> listOfCalledIdentityChanges, byte[] cellularNetworkInformation,
			List<ServiceSpecificInfo> serviceSpecificInfo, InvolvedParty requestedPartyAddress,
			List<InvolvedParty> listOfCalledAssertedIdentity, String alternateChargedPartyAddress,
			String outgoingSessionID, byte[] initialIMSChargingIdentifier,
			List<AccessTransferInformation> listOfAccessTransferInformation, TADIdentifier tadsIdentifier,
			AddressStringImpl vlrNumber, MMTelInformation mMTelInformation, AddressStringImpl mscAddress, ThreeGPPPSDataOffStatus threeGPPPSDataOffStatus,
			List<String> fEIdentifierList,OnlineChargingFlag onlineChargingFlagEnum,InvolvedParty chargedParty,
			Integer duration,InvolvedParty dialedPartyAddress,Integer ringingDuration,
			CallProperty callProperty,ChargingCategory chargingCategory,AccountingRecordType accountingRecordType,
			SDPMediaIdentifier sdpMediaIdentifier,String mscNumber,TADSIndication tadsIndication,List<InInformation> inInformation,
			PrivateUserEquipmentInfo privateUserEquipmentInfo,String recordingEntityID,SpecifiedTreatmentField specifiedTreatmentField) 
	{
		if(recordType!=null)
			this.recordType = new ASNRecordType(recordType);
		
		if(retransmission)
			this.retransmission = new ASNNull();
		
		if(sipMethod!=null)
			this.sipMethod = new ASNGraphicString(sipMethod);
		
		if(roleOfNode!=null)
			this.roleOfNode = new ASNRoleOfNode(roleOfNode);
		
		if(nodeAddress!=null)
			this.nodeAddress = new NodeAddressWrapper(nodeAddress);
		
		if(sessionID!=null)
			this.sessionID = new ASNGraphicString(sessionID);
		
		if(listOfCallingPartyAddress!=null)
			this.listOfCallingPartyAddress = new InvolvedPartyListWrapper(listOfCallingPartyAddress);
		
		if(calledPartyAddress!=null)
			this.calledPartyAddress = new InvolvedPartyWrapper(calledPartyAddress);
		
		if(privateUserID!=null)
			this.privateUserID = new ASNGraphicString(privateUserID);
		
		this.serviceRequestTimeStamp = serviceRequestTimeStamp;
		this.serviceDeliveryStartTimeStamp = serviceDeliveryStartTimeStamp;
		this.serviceDeliveryEndTimeStamp = serviceDeliveryEndTimeStamp;
		this.recordOpeningTime = recordOpeningTime;
		this.recordClosureTime = recordClosureTime;

		if(interOperatorIdentifiers!=null)
			this.interOperatorIdentifiers = new InterOperatorIdentifiersListWrapper(interOperatorIdentifiers);
		
		if(localSequenceNumber!=null)
			this.localSequenceNumber = new ASNInteger(localSequenceNumber.longValue());
		
		if(recordSequenceNumber!=null)
			this.recordSequenceNumber = new ASNInteger(recordSequenceNumber.longValue());
		
		if(causeForRecordClosing!=null)
			this.causeForRecordClosing = new ASNCauseForRecordClosing(causeForRecordClosing);
		
		this.incompleteCDRIndication = incompleteCDRIndication;
		
		if(imsChargingIdentifier!=null)
			this.imsChargingIdentifier = new ASNOctetString(Unpooled.wrappedBuffer(imsChargingIdentifier));
		
		if(mediaComponentList!=null)
			this.mediaComponentList = new MediaComponentListWrapper(mediaComponentList);
		
		if(ggsnAddress!=null)
			this.ggsnAddress = new NodeAddressWrapper(ggsnAddress);
		
		if(serviceReasonReturnCode!=null)
			this.serviceReasonReturnCode = new ASNUTF8String(serviceReasonReturnCode);
		
		this.listOfMessageBodies = listOfMessageBodies;
		
		if(recordExtensions!=null)
			this.recordExtensions = new ASNOctetString(Unpooled.wrappedBuffer(recordExtensions));
		
		if(expiresInformation!=null)
			this.expiresInformation = new ASNInteger(expiresInformation.longValue());
		
		if(event!=null)
			this.event = new ASNUTF8String(event);
		
		if(accessNetworkInformation!=null)
			this.accessNetworkInformation = new ASNOctetString(Unpooled.wrappedBuffer(accessNetworkInformation));
		
		if(serviceContextID!=null)
			this.serviceContextID = new ASNUTF8String(serviceContextID);
		
		if(listOfSubscriptionID!=null)
			this.listOfSubscriptionID = new SubscriptionIDListWrapper(listOfSubscriptionID);
		
		this.listOfEarlySDPMediaComponents = listOfEarlySDPMediaComponents;
		
		if(imsCommunicationServiceIdentifier!=null)
			this.imsCommunicationServiceIdentifier = new ASNOctetString(Unpooled.wrappedBuffer(imsCommunicationServiceIdentifier));
		
		if(numberPortabilityRouting!=null)
			this.numberPortabilityRouting = new ASNGraphicString(numberPortabilityRouting);
		
		if(carrierSelectRouting!=null)
			this.carrierSelectRouting = new ASNGraphicString(carrierSelectRouting);
		
		if(sessionPriority!=null)
			this.sessionPriority = new ASNSessionPriority(sessionPriority);
		
		if(serviceRequestTimeStampFraction!=null)
			this.serviceRequestTimeStampFraction = new ASNInteger(serviceRequestTimeStampFraction.longValue());
		
		if(serviceDeliveryStartTimeStampFraction!=null)
			this.serviceDeliveryStartTimeStampFraction = new ASNInteger(serviceDeliveryStartTimeStampFraction.longValue());
		
		if(serviceDeliveryEndTimeStampFraction!=null)
			this.serviceDeliveryEndTimeStampFraction = new ASNInteger(serviceDeliveryEndTimeStampFraction.longValue());
		
		if(listOfRequestedPartyAddress!=null)
			this.listOfRequestedPartyAddress=new InvolvedPartyListWrapper(listOfRequestedPartyAddress);
		
		if(onlineChargingFlag)
			this.onlineChargingFlag = new ASNNull();
		
		this.realTimeTariffInformation = realTimeTariffInformation;
		
		if(userLocationInformation!=null)
			this.userLocationInformation = new ASNOctetString(Unpooled.wrappedBuffer(userLocationInformation));
		
		this.msTimeZone = msTimeZone;
		this.nniInformation = nniInformation;
		
		if(fromAddress!=null)
			this.fromAddress = new ASNOctetString(Unpooled.wrappedBuffer(fromAddress));
		
		if(transitIOILists!=null)
		{
			this.transitIOILists = new ArrayList<ASNGraphicString>();
			for(String curr:transitIOILists)
			{
				ASNGraphicString currStr=new ASNGraphicString(curr);
				this.transitIOILists.add(currStr);
			}
		}
		
		if(imsVisitedNetworkIdentifier!=null)
			this.imsVisitedNetworkIdentifier = new ASNOctetString(Unpooled.wrappedBuffer(imsVisitedNetworkIdentifier));
		
		if(listOfReasonHeader!=null)
		{
			this.listOfReasonHeader = new ArrayList<ASNGraphicString>();
			for(String curr:listOfReasonHeader)
			{
				ASNGraphicString currStr=new ASNGraphicString(curr);
				this.listOfReasonHeader.add(currStr);
			}
		}
		
		if(additionalAccessNetworkInformation!=null)
			this.additionalAccessNetworkInformation = new ASNOctetString(Unpooled.wrappedBuffer(additionalAccessNetworkInformation));
		
		if(instanceId!=null)
			this.instanceId = new ASNOctetString(Unpooled.wrappedBuffer(instanceId));
		
		this.subscriberEquipmentNumber = subscriberEquipmentNumber;
		
		this.listOfAccessNetworkInfoChange = listOfAccessNetworkInfoChange;
		this.listOfCalledIdentityChanges = listOfCalledIdentityChanges;
		
		if(cellularNetworkInformation!=null)
			this.cellularNetworkInformation = new ASNOctetString(Unpooled.wrappedBuffer(cellularNetworkInformation));
		
		this.serviceSpecificInfo = serviceSpecificInfo;
		
		if(requestedPartyAddress!=null)
			this.requestedPartyAddress = new InvolvedPartyWrapper(requestedPartyAddress);
		
		if(listOfCalledAssertedIdentity!=null)
			this.listOfCalledAssertedIdentity = new InvolvedPartyListWrapper(listOfCalledAssertedIdentity);
		
		if(alternateChargedPartyAddress!=null)
			this.alternateChargedPartyAddress = new ASNUTF8String(alternateChargedPartyAddress);
		
		if(outgoingSessionID!=null)
			this.outgoingSessionID = new ASNGraphicString(outgoingSessionID);
		
		if(initialIMSChargingIdentifier!=null)
			this.initialIMSChargingIdentifier = new ASNOctetString(Unpooled.wrappedBuffer(initialIMSChargingIdentifier));
		
		this.listOfAccessTransferInformation = listOfAccessTransferInformation;
		this.tadsIdentifier = tadsIdentifier;
		this.vlrNumber = vlrNumber;
		this.mMTelInformation = mMTelInformation;
		this.mscAddress = mscAddress;
		
		if(threeGPPPSDataOffStatus!=null)
			this.threeGPPPSDataOffStatus = new ASNThreeGPPPSDataOffStatus(threeGPPPSDataOffStatus);
		
		if(fEIdentifierList!=null)
		{
			this.fEIdentifierList = new ArrayList<ASNGraphicString>();
			for(String curr:fEIdentifierList)
			{
				ASNGraphicString currStr=new ASNGraphicString(curr);
				this.fEIdentifierList.add(currStr);
			}
		}		
		
		if(onlineChargingFlagEnum!=null) 
			this.onlineChargingFlagEnum=new ASNOnlineChargingFlag(onlineChargingFlagEnum);
		
		if(chargedParty!=null)
			this.chargedParty=new InvolvedPartyWrapper(chargedParty);
		
		if(duration!=null)
			this.duration=new ASNInteger(duration.longValue());
		
		if(dialedPartyAddress!=null)
			this.dialedPartyAddress=new InvolvedPartyWrapper(dialedPartyAddress);
		
		if(ringingDuration!=null)
			this.ringingDuration=new ASNInteger(ringingDuration.longValue());
		
		if(chargingCategory!=null)
			this.chargingCategory=new ASNChargingCategory(chargingCategory);
		
		if(callProperty!=null)
			this.callProperty=new ASNCallProperty(callProperty);
		
		if(accountingRecordType!=null)
			this.accountingRecordType=new ASNAccountingRecordType(accountingRecordType);
		
		if(sdpMediaIdentifier!=null)
			this.sdpMediaIdentifier=new ASNSDPMediaIdentifier(sdpMediaIdentifier);
		
		if(mscNumber!=null)
			this.mscNumber=new ASNUTF8String(mscNumber);
		
		if(tadsIndication!=null)
			this.tadsIndication=new ASNTADSIndication(tadsIndication);
		
		if(inInformation!=null)
			this.inInformation=new InInformationListWrapper(inInformation);
		
		this.privateUserEquipmentInfo=privateUserEquipmentInfo;
		
		if(recordingEntityID!=null)
			this.recordingEntityID=new ASNUTF8String(recordingEntityID);
		
		this.specifiedTreatmentField=specifiedTreatmentField;
	}

	public RecordType getRecordType() 
	{
		if(recordType==null)
			return null;
		
		return recordType.getType();
	}

	public boolean getRetransmission() 
	{		
		return retransmission!=null;
	}

	public String getSipMethod() 
	{
		if(sipMethod==null)
			return null;
		
		return sipMethod.getValue();
	}

	public RoleOfNode getRoleOfNode() 
	{
		if(roleOfNode==null)
			return null;
		
		return roleOfNode.getType();
	}

	public NodeAddress getNodeAddress() 
	{
		if(nodeAddress==null)
			return null;
		
		return nodeAddress.getNodeAddress();
	}

	public String getSessionID() 
	{
		if(sessionID==null)
			return null;
		
		return sessionID.getValue();
	}

	public List<InvolvedParty> getListOfCallingPartyAddress() 
	{
		if(listOfCallingPartyAddress==null)
			return null;
		
		return listOfCallingPartyAddress.getInvolvedParty();
	}

	public InvolvedParty getCalledPartyAddress() 
	{
		if(calledPartyAddress==null)
			return null;
		
		return calledPartyAddress.getInvolvedParty();
	}

	public String getPrivateUserID() 
	{
		if(privateUserID==null)
			return null;
		
		return privateUserID.getValue();
	}

	public TimeStamp getServiceRequestTimeStamp() 
	{
		return serviceRequestTimeStamp;
	}

	public TimeStamp getServiceDeliveryStartTimeStamp() 
	{
		return serviceDeliveryStartTimeStamp;
	}

	public TimeStamp getServiceDeliveryEndTimeStamp() 
	{
		return serviceDeliveryEndTimeStamp;
	}

	public TimeStamp getRecordOpeningTime() 
	{
		return recordOpeningTime;
	}

	public TimeStamp getRecordClosureTime() 
	{
		return recordClosureTime;
	}

	public List<InterOperatorIdentifiers> getInterOperatorIdentifiers() 
	{
		if(interOperatorIdentifiers==null)
			return null;
		
		return interOperatorIdentifiers.getInterOperatorIdentifiers();
	}

	public Integer getLocalSequenceNumber() 
	{
		if(localSequenceNumber==null || localSequenceNumber.getValue()==null)
			return null;
		
		return localSequenceNumber.getValue().intValue();
	}

	public Integer getRecordSequenceNumber() 
	{
		if(recordSequenceNumber==null || recordSequenceNumber.getValue()==null)
			return null;
		
		return recordSequenceNumber.getValue().intValue();
	}

	public CauseForRecordClosing getCauseForRecordClosing() 
	{
		if(causeForRecordClosing==null)
			return null;
		
		return causeForRecordClosing.getType();
	}

	public IncompleteCDRIndication getIncompleteCDRIndication() 
	{
		return incompleteCDRIndication;
	}

	public byte[] getImsChargingIdentifier() 
	{
		if(imsChargingIdentifier==null || imsChargingIdentifier.getValue()==null)
			return null;
		
		ByteBuf value=imsChargingIdentifier.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public String getImsChargingIdentifierStr() 
	{
		byte[] data=getImsChargingIdentifier();
		if(data==null || data.length==0)
			return "";
		
		String result="";
		try {
			result=new String(data);
		}
		catch(Exception ex) {
			
		}
		
		return result;
	}

	public List<MediaComponentList> getMediaComponentList() 
	{
		if(mediaComponentList==null)
			return null;
		
		return mediaComponentList.getMediaComponentList();
	}

	public NodeAddress getGgsnAddress() 
	{
		if(ggsnAddress==null)
			return null;
		
		return ggsnAddress.getNodeAddress();
	}

	public String getServiceReasonReturnCode() 
	{
		if(serviceReasonReturnCode==null)
			return null;
		
		return serviceReasonReturnCode.getValue();
	}

	public List<MessageBody> getListOfMessageBodies() 
	{
		return listOfMessageBodies;
	}

	public byte[] getRecordExtensions() 
	{
		if(recordExtensions==null || recordExtensions.getValue()==null)
			return null;
		
		ByteBuf value=recordExtensions.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public Integer getExpiresInformation() 
	{
		if(expiresInformation==null || expiresInformation.getValue()==null)
			return null;
		
		return expiresInformation.getValue().intValue();
	}

	public String getEvent() 
	{
		if(event==null)
			return null;
		
		return event.getValue();
	}

	public byte[] getAccessNetworkInformation() 
	{
		if(accessNetworkInformation==null || accessNetworkInformation.getValue()==null)
			return null;
		
		ByteBuf value=accessNetworkInformation.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public String getAccessNetworkInformationStr()
	{
		byte[] data=getAccessNetworkInformation();
		if(data==null || data.length==0)
			return "";
		
		String result="";
		try {
			result=new String(data);
		}
		catch(Exception ex) {
			
		}
		
		return result;
	}
	
	public String getServiceContextID() 
	{
		if(serviceContextID==null)
			return null;
		
		return serviceContextID.getValue();
	}

	public List<SubscriptionID> getListOfSubscriptionID() 
	{
		if(listOfSubscriptionID==null) 
			return null;
		
		return listOfSubscriptionID.getSubscriptionIDs();
	}

	public List<EarlyMediaComponentList> getListOfEarlySDPMediaComponents() 
	{
		return listOfEarlySDPMediaComponents;
	}

	public byte[] getImsCommunicationServiceIdentifier() 
	{
		if(imsCommunicationServiceIdentifier==null || imsCommunicationServiceIdentifier.getValue()==null)
			return null;
		
		ByteBuf value=imsCommunicationServiceIdentifier.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public String getNumberPortabilityRouting() 
	{
		if(numberPortabilityRouting==null)
			return null;
		
		return numberPortabilityRouting.getValue();
	}

	public String getCarrierSelectRouting() 
	{
		if(carrierSelectRouting==null)
			return null;
		
		return carrierSelectRouting.getValue();
	}

	public SessionPriority getSessionPriority() 
	{
		if(sessionPriority==null)
			return null;
		
		return sessionPriority.getType();
	}

	public Integer getServiceRequestTimeStampFraction() 
	{
		if(serviceRequestTimeStampFraction==null || serviceRequestTimeStampFraction.getValue()==null)
			return null;
		
		return serviceRequestTimeStampFraction.getValue().intValue();
	}

	public Integer getServiceDeliveryStartTimeStampFraction() 
	{
		if(serviceDeliveryStartTimeStampFraction==null || serviceDeliveryStartTimeStampFraction.getValue()==null)
			return null;
		
		return serviceDeliveryStartTimeStampFraction.getValue().intValue();
	}

	public Integer getServiceDeliveryEndTimeStampFraction() 
	{
		if(serviceDeliveryEndTimeStampFraction==null || serviceDeliveryEndTimeStampFraction.getValue()==null)
			return null;
		
		return serviceDeliveryEndTimeStampFraction.getValue().intValue();
	}

	public List<InvolvedParty> getListOfRequestedPartyAddress() 
	{
		if(listOfRequestedPartyAddress==null)
			return null;
		
		return listOfRequestedPartyAddress.getInvolvedParty();
	}

	public boolean getOnlineChargingFlag() 
	{
		return onlineChargingFlag!=null;
	}

	public List<RealTimeTariffInformation> getRealTimeTariffInformation() 
	{
		return realTimeTariffInformation;
	}

	public byte[] getUserLocationInformation() 
	{
		if(userLocationInformation==null || userLocationInformation.getValue()==null)
			return null;
		
		ByteBuf value=userLocationInformation.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public MSTimezone getMsTimeZone() 
	{
		return msTimeZone;
	}

	public NNIInformation getNniInformation() 
	{
		return nniInformation;
	}

	public byte[] getFromAddress() 
	{
		if(fromAddress==null || fromAddress.getValue()==null)
			return null;
		
		ByteBuf value=fromAddress.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public List<String> getTransitIOILists() 
	{
		if(transitIOILists==null)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(ASNGraphicString curr:transitIOILists)
			result.add(curr.getValue());
		
		return result;
	}

	public byte[] getImsVisitedNetworkIdentifier() 
	{
		if(imsVisitedNetworkIdentifier==null || imsVisitedNetworkIdentifier.getValue()==null)
			return null;
		
		ByteBuf value=imsVisitedNetworkIdentifier.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public List<String> getListOfReasonHeader() 
	{
		if(listOfReasonHeader==null)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(ASNGraphicString curr:listOfReasonHeader)
			result.add(curr.getValue());
		
		return result;
	}

	public byte[] getAdditionalAccessNetworkInformation() 
	{
		if(additionalAccessNetworkInformation==null || additionalAccessNetworkInformation.getValue()==null)
			return null;
		
		ByteBuf value=additionalAccessNetworkInformation.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public byte[] getInstanceId() 
	{
		if(instanceId==null || instanceId.getValue()==null)
			return null;
		
		ByteBuf value=instanceId.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public SubscriberEquipmentNumber getSubscriberEquipmentNumber() 
	{
		return subscriberEquipmentNumber;
	}

	public List<AccessNetworkInfoChange> getListOfAccessNetworkInfoChange() 
	{
		return listOfAccessNetworkInfoChange;
	}

	public List<CalledIdentityChange> getListOfCalledIdentityChanges() 
	{
		return listOfCalledIdentityChanges;
	}

	public byte[] getCellularNetworkInformation() 
	{
		if(cellularNetworkInformation==null || cellularNetworkInformation.getValue()==null)
			return null;
		
		ByteBuf value=cellularNetworkInformation.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public List<String> getfEIdentifierList() 
	{
		if(fEIdentifierList==null)
			return null;
		
		List<String> result=new ArrayList<String>();
		for(ASNGraphicString curr:fEIdentifierList)
			result.add(curr.getValue());
		
		return result;
	}

	public List<ServiceSpecificInfo> getServiceSpecificInfo() 
	{
		return serviceSpecificInfo;
	}

	public InvolvedParty getRequestedPartyAddress() 
	{
		if(requestedPartyAddress==null)
			return null;
		
		return requestedPartyAddress.getInvolvedParty();
	}

	public List<InvolvedParty> getListOfCalledAssertedIdentity() 
	{
		if(listOfCalledAssertedIdentity==null)
			return null;
		
		return listOfCalledAssertedIdentity.getInvolvedParty();
	}

	public String getAlternateChargedPartyAddress() 
	{
		if(alternateChargedPartyAddress==null)
			return null;
		
		return alternateChargedPartyAddress.getValue();
	}

	public String getOutgoingSessionID() 
	{
		if(outgoingSessionID==null)
			return null;
		
		return outgoingSessionID.getValue();
	}

	public byte[] getInitialIMSChargingIdentifier() 
	{
		if(initialIMSChargingIdentifier==null || initialIMSChargingIdentifier.getValue()==null)
			return null;
		
		ByteBuf value=initialIMSChargingIdentifier.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public List<AccessTransferInformation> getListOfAccessTransferInformation() 
	{
		return listOfAccessTransferInformation;
	}

	public TADIdentifier getTadsIdentifier() 
	{
		return tadsIdentifier;
	}

	public AddressStringImpl getVlrNumber() 
	{
		return vlrNumber;
	}

	public MMTelInformation getmMTelInformation() 
	{
		return mMTelInformation;
	}

	public AddressStringImpl getMscAddress() 
	{
		return mscAddress;
	}

	public ThreeGPPPSDataOffStatus getThreeGPPPSDataOffStatus() 
	{
		if(threeGPPPSDataOffStatus==null)
			return null;
		
		return threeGPPPSDataOffStatus.getStatus();
	}
	
	public OnlineChargingFlag getOnlineChargingFlagEnum() 
	{
		if(onlineChargingFlagEnum==null || onlineChargingFlagEnum.getType()==null)
			return null;
		
		return onlineChargingFlagEnum.getType();
	}
	
	public InvolvedParty getChargedParty() 
	{
		if(chargedParty==null || chargedParty.getInvolvedParty()==null)
			return null;
		
		return chargedParty.getInvolvedParty();
	}
	
	public Integer getDuration() 
	{
		if(duration==null || duration.getValue()==null)
			return null;
		
		return duration.getValue().intValue();
	}
	
	public InvolvedParty getDialedPartyAddress() 
	{
		if(dialedPartyAddress==null || dialedPartyAddress.getInvolvedParty()==null)
			return null;
		
		return dialedPartyAddress.getInvolvedParty();
	}
	
	public Integer getRingingDuration() 
	{
		if(ringingDuration==null || ringingDuration.getValue()==null)
			return null;
		
		return ringingDuration.getValue().intValue();
	}
	
	public ChargingCategory getChargingCategory() 
	{
		if(chargingCategory==null)
			return null;
		
		return chargingCategory.getType();
	}
	
	public CallProperty getCallProperty() 
	{
		if(callProperty==null)
			return null;
		
		return callProperty.getType();
	}
	
	public AccountingRecordType getAccountingRecordType() 
	{
		if(accountingRecordType==null)
			return null;
		
		return accountingRecordType.getType();
	}
	
	public SDPMediaIdentifier getSDPMediaIdentifier() 
	{
		if(sdpMediaIdentifier==null)
			return null;
		
		return sdpMediaIdentifier.getIdentifier();
	}
	
	public String getMSCNumber() 
	{
		if(mscNumber==null)
			return null;
		
		return mscNumber.getValue();
	}
	
	public TADSIndication getTADSIndication() 
	{
		if(tadsIndication==null)
			return null;
		
		return tadsIndication.getType();
	}
	
	public List<InInformation> getInInformation() 
	{
		if(inInformation==null)
			return null;
		
		return inInformation.getInInformation();
	}
	
	public PrivateUserEquipmentInfo getPrivateUserEquipmentInfo() 
	{
		return privateUserEquipmentInfo;
	}
	
	public String getRecordingEntityID() 
	{
		if(recordingEntityID==null)
			return null;
		
		return recordingEntityID.getValue();
	}
	
	public SpecifiedTreatmentField getSpecifiedTreatmentField() 
	{
		return specifiedTreatmentField;
	}
	
	@Override
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("ASRecord");
        sb.append(" [");

        if(recordType!=null && recordType.getType()!=null)
        {
	        sb.append("recordType=[");
	        sb.append(this.recordType.getType());
	        sb.append("]");
        }
        
        if(retransmission!=null)
        {
        	sb.append("retransmission ");	        
        }
        
        if(sipMethod!=null && sipMethod.getValue()!=null)
        {
	        sb.append("sipMethod=[");
	        sb.append(this.sipMethod.getValue());
	        sb.append("]");
        }
        
        if(roleOfNode!=null && roleOfNode.getType()!=null)
        {
	        sb.append("roleOfNode=[");
	        sb.append(this.roleOfNode.getType());
	        sb.append("]");
        }
        
        if(nodeAddress!=null && nodeAddress.getNodeAddress()!=null)
        {
	        sb.append("nodeAddress=[");
	        sb.append(this.nodeAddress.getNodeAddress());
	        sb.append("]");
        }
        
        if(sessionID!=null && sessionID.getValue()!=null)
        {
	        sb.append("sessionID=[");
	        sb.append(this.sessionID.getValue());
	        sb.append("]");
        }
        
        if(listOfCallingPartyAddress!=null && listOfCallingPartyAddress.getInvolvedParty()!=null)
        {
	        sb.append("listOfCallingPartyAddress=[");
	        Boolean isFirst=false;
	        for(InvolvedParty curr:listOfCallingPartyAddress.getInvolvedParty())
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
        if(calledPartyAddress!=null && calledPartyAddress.getInvolvedParty()!=null)
        {
	        sb.append("calledPartyAddress=[");
	        sb.append(this.calledPartyAddress.getInvolvedParty());
	        sb.append("]");
        }
        
        if(privateUserID!=null && privateUserID.getValue()!=null)
        {
	        sb.append("privateUserID=[");
	        sb.append(this.privateUserID.getValue());
	        sb.append("]");
        }
        
        if(serviceRequestTimeStamp!=null)
        {
	        sb.append("serviceRequestTimeStamp=[");
	        sb.append(this.serviceRequestTimeStamp);
	        sb.append("]");
        }
        
        if(serviceDeliveryStartTimeStamp!=null)
        {
	        sb.append("serviceDeliveryStartTimeStamp=[");
	        sb.append(this.serviceDeliveryStartTimeStamp);
	        sb.append("]");
        }
        
        if(serviceDeliveryEndTimeStamp!=null)
        {
	        sb.append("serviceDeliveryEndTimeStamp=[");
	        sb.append(this.serviceDeliveryEndTimeStamp);
	        sb.append("]");
        }
        
        if(recordOpeningTime!=null)
        {
	        sb.append("recordOpeningTime=[");
	        sb.append(this.recordOpeningTime);
	        sb.append("]");
        }
        
        if(recordClosureTime!=null)
        {
	        sb.append("recordClosureTime=[");
	        sb.append(this.recordClosureTime);
	        sb.append("]");
        }
        
        if(interOperatorIdentifiers!=null && interOperatorIdentifiers.getInterOperatorIdentifiers()!=null)
        {
	        sb.append("interOperatorIdentifiers=[");
	        Boolean isFirst=false;
	        for(InterOperatorIdentifiers curr:interOperatorIdentifiers.getInterOperatorIdentifiers())
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
        if(localSequenceNumber!=null && localSequenceNumber.getValue()!=null)
        {
	        sb.append("localRecordSequenceNumber=[");
	        sb.append(this.localSequenceNumber.getValue());
	        sb.append("]");
        }
        
        if(recordSequenceNumber!=null && recordSequenceNumber.getValue()!=null)
        {
	        sb.append("recordSequenceNumber=[");
	        sb.append(this.recordSequenceNumber.getValue());
	        sb.append("]");
        }
        
        if(causeForRecordClosing!=null && causeForRecordClosing.getValue()!=null)
        {
	        sb.append("causeForRecordClosing=[");
	        sb.append(this.causeForRecordClosing.getValue());
	        sb.append("]");
        }
        
        if(incompleteCDRIndication!=null)
        {
	        sb.append("incompleteCDRIndication=[");
	        sb.append(this.incompleteCDRIndication);
	        sb.append("]");
        }
        
        if(imsChargingIdentifier!=null && imsChargingIdentifier.getValue()!=null)
        {
	        sb.append("imsChargingIdentifier=[");
	        sb.append(imsChargingIdentifier.printDataArr());
	        sb.append("]");
        }
        
        if(imsChargingIdentifier!=null && imsChargingIdentifier.getValue()!=null)
        {
	        sb.append(" imsChargingIdentifierStr=[");
	        sb.append(getImsChargingIdentifierStr());
	        sb.append("]");
        }
        
        if(mediaComponentList!=null && mediaComponentList.getMediaComponentList()!=null)
        {
	        sb.append("mediaComponentList=[");
	        Boolean isFirst=false;
	        for(MediaComponentList curr:mediaComponentList.getMediaComponentList())
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
        if(ggsnAddress!=null && ggsnAddress.getNodeAddress()!=null)
        {
	        sb.append("ggsnAddress=[");
	        sb.append(ggsnAddress.getNodeAddress());
	        sb.append("]");
        }
        
        if(serviceReasonReturnCode!=null && serviceReasonReturnCode.getValue()!=null)
        {
	        sb.append("serviceReasonReturnCode=[");
	        sb.append(serviceReasonReturnCode.getValue());
	        sb.append("]");
        }
        
        if(listOfMessageBodies!=null)
        {
	        sb.append("listOfMessageBodies=[");
	        Boolean isFirst=false;
	        for(MessageBody curr:listOfMessageBodies)
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
        if(recordExtensions!=null && recordExtensions.getValue()!=null)
        {
	        sb.append("recordExtensions=[");
	        sb.append(recordExtensions.printDataArr());
	        sb.append("]");
        }
        
        if(expiresInformation!=null && expiresInformation.getValue()!=null)
        {
	        sb.append("expiresInformation=[");
	        sb.append(expiresInformation.getValue());
	        sb.append("]");
        }
        
        if(event!=null && event.getValue()!=null)
        {
	        sb.append("event=[");
	        sb.append(event.getValue());
	        sb.append("]");
        }
        
        if(accessNetworkInformation!=null && accessNetworkInformation.getValue()!=null)
        {
	        sb.append(" accessNetworkInformation=[");
	        sb.append(accessNetworkInformation.printDataArr());
	        sb.append("]");
        }
        
        if(accessNetworkInformation!=null && accessNetworkInformation.getValue()!=null)
        {
	        sb.append(" accessNetworkInformationStr=[");
	        sb.append(getAccessNetworkInformationStr());
	        sb.append("]");
        }
        
        if(serviceContextID!=null && serviceContextID.getValue()!=null)
        {
	        sb.append("serviceContextID=[");
	        sb.append(serviceContextID.getValue());
	        sb.append("]");
        }
        
        if(listOfSubscriptionID!=null && listOfSubscriptionID.getSubscriptionIDs()!=null)
        {
	        sb.append("listOfSubscriptionID=[");
	        Boolean isFirst=false;
	        for(SubscriptionID curr:listOfSubscriptionID.getSubscriptionIDs())
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
        if(listOfEarlySDPMediaComponents!=null)
        {
	        sb.append("listOfEarlySDPMediaComponents=[");
	        Boolean isFirst=false;
	        for(EarlyMediaComponentList curr:listOfEarlySDPMediaComponents)
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
        if(imsCommunicationServiceIdentifier!=null && imsCommunicationServiceIdentifier.getValue()!=null)
        {
	        sb.append("imsCommunicationServiceIdentifier=[");
	        sb.append(imsCommunicationServiceIdentifier.printDataArr());
	        sb.append("]");
        }
        
        if(numberPortabilityRouting!=null && numberPortabilityRouting.getValue()!=null)
        {
	        sb.append("numberPortabilityRouting=[");
	        sb.append(numberPortabilityRouting.getValue());
	        sb.append("]");
        }
        
        if(carrierSelectRouting!=null && carrierSelectRouting.getValue()!=null)
        {
	        sb.append("carrierSelectRouting=[");
	        sb.append(carrierSelectRouting.getValue());
	        sb.append("]");
        }
        
        if(sessionPriority!=null && sessionPriority.getValue()!=null)
        {
	        sb.append("sessionPriority=[");
	        sb.append(sessionPriority.getType());
	        sb.append("]");
        }
        
        if(serviceRequestTimeStampFraction!=null && serviceRequestTimeStampFraction.getValue()!=null)
        {
	        sb.append("serviceRequestTimeStampFraction=[");
	        sb.append(serviceRequestTimeStampFraction.getValue());
	        sb.append("]");
        }
        
        if(serviceDeliveryStartTimeStampFraction!=null && serviceDeliveryStartTimeStampFraction.getValue()!=null)
        {
	        sb.append("serviceDeliveryStartTimeStampFraction=[");
	        sb.append(serviceDeliveryStartTimeStampFraction.getValue());
	        sb.append("]");
        }
        
        if(serviceDeliveryEndTimeStampFraction!=null && serviceDeliveryEndTimeStampFraction.getValue()!=null)
        {
	        sb.append("serviceDeliveryEndTimeStampFraction=[");
	        sb.append(serviceDeliveryEndTimeStampFraction.getValue());
	        sb.append("]");
        }
        
        if(listOfRequestedPartyAddress!=null && listOfRequestedPartyAddress.getInvolvedParty()!=null)
        {
	        sb.append("listOfRequestedPartyAddress=[");
	        Boolean isFirst=false;
	        for(InvolvedParty curr:listOfRequestedPartyAddress.getInvolvedParty())
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }

        
        if(onlineChargingFlag!=null)
        {
        	sb.append("onlineChargingFlag ");	        
        }
        
        if(realTimeTariffInformation!=null && realTimeTariffInformation!=null)
        {
	        sb.append("realTimeTariffInformation=[");
	        Boolean isFirst=false;
	        for(RealTimeTariffInformation curr:realTimeTariffInformation)
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
        if(nniInformation!=null)
        {
	        sb.append("nniInformation=[");
	        sb.append(nniInformation);
	        sb.append("]");
        }
        
        if(userLocationInformation!=null && userLocationInformation.getValue()!=null)
        {
	        sb.append("userLocationInformation=[");
	        sb.append(userLocationInformation.printDataArr());
	        sb.append("]");
        }
        
        if(msTimeZone!=null)
        {
	        sb.append("mSTimeZone=[");
	        sb.append(msTimeZone);
	        sb.append("]");
        }
        
        if(fromAddress!=null && fromAddress.getValue()!=null)
        {
	        sb.append("fromAddress=[");
	        sb.append(fromAddress.printDataArr());
	        sb.append("]");
        }
        
        if(transitIOILists!=null)
        {
	        sb.append("transitIOILists=[");
	        Boolean isFirst=false;
	        for(ASNGraphicString curr:transitIOILists)
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr.getValue());
	        }
	        
	        sb.append("]");
        }
        
        if(imsVisitedNetworkIdentifier!=null && imsVisitedNetworkIdentifier.getValue()!=null)
        {
	        sb.append("imsVisitedNetworkIdentifier=[");
	        sb.append(imsVisitedNetworkIdentifier.printDataArr());
	        sb.append("]");
        }
        
        if(listOfReasonHeader!=null)
        {
	        sb.append("listOfReasonHeader=[");
	        Boolean isFirst=false;
	        for(ASNGraphicString curr:listOfReasonHeader)
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr.getValue());
	        }
	        
	        sb.append("]");
        }
        
        if(additionalAccessNetworkInformation!=null && additionalAccessNetworkInformation.getValue()!=null)
        {
	        sb.append("additionalAccessNetworkInformation=[");
	        sb.append(additionalAccessNetworkInformation.printDataArr());
	        sb.append("]");
        }
        
        if(instanceId!=null && instanceId.getValue()!=null)
        {
	        sb.append("instanceId=[");
	        sb.append(instanceId.printDataArr());
	        sb.append("]");
        }
        
        if(subscriberEquipmentNumber!=null)
        {
        	sb.append("subscriberEquipmentNumber=[");
	        sb.append(subscriberEquipmentNumber);
	        sb.append("]");
        }
        
        if(listOfAccessNetworkInfoChange!=null)
        {
	        sb.append("listOfAccessNetworkInfoChange=[");
	        Boolean isFirst=false;
	        for(AccessNetworkInfoChange curr:listOfAccessNetworkInfoChange)
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
        if(listOfCalledIdentityChanges!=null)
        {
	        sb.append("listOfCalledIdentityChanges=[");
	        Boolean isFirst=false;
	        for(CalledIdentityChange curr:listOfCalledIdentityChanges)
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
        if(cellularNetworkInformation!=null && cellularNetworkInformation.getValue()!=null)
        {
	        sb.append("cellularNetworkInformation=[");
	        sb.append(cellularNetworkInformation.printDataArr());
	        sb.append("]");
        }
        
        if(serviceSpecificInfo!=null)
        {
	        sb.append("serviceSpecificInfo=[");
	        Boolean isFirst=false;
	        for(ServiceSpecificInfo curr:serviceSpecificInfo)
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
                
        if(requestedPartyAddress!=null && requestedPartyAddress.getInvolvedParty()!=null)
        {
	        sb.append("requestedPartyAddress=[");
	        sb.append(requestedPartyAddress.getInvolvedParty());
	        sb.append("]");
        }
        
        if(listOfCalledAssertedIdentity!=null && listOfCalledAssertedIdentity.getInvolvedParty()!=null)
        {
	        sb.append("listOfCalledAssertedIdentity=[");
	        Boolean isFirst=false;
	        for(InvolvedParty curr:listOfCalledAssertedIdentity.getInvolvedParty())
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
		if(alternateChargedPartyAddress!=null && alternateChargedPartyAddress.getValue()!=null)
		{
			sb.append("alternateChargedPartyAddress=[");
			sb.append(alternateChargedPartyAddress.getValue());
			sb.append("]");
		}
        
		if(outgoingSessionID!=null && outgoingSessionID.getValue()!=null)
		{
			sb.append("outgoingSessionID=[");
			sb.append(outgoingSessionID.getValue());
			sb.append("]");
		}
        
		if(initialIMSChargingIdentifier!=null && initialIMSChargingIdentifier.getValue()!=null)
		{
			sb.append("initialIMSChargingIdentifier=[");
			sb.append(initialIMSChargingIdentifier.printDataArr());
			sb.append("]");
		}
        
        if(listOfAccessTransferInformation!=null)
        {
	        sb.append("listOfAccessTransferInformation=[");
	        Boolean isFirst=false;
	        for(AccessTransferInformation curr:listOfAccessTransferInformation)
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
		if(tadsIdentifier!=null)
		{
			sb.append("tadsIdentifier=[");
			sb.append(tadsIdentifier);
			sb.append("]");
		}
        
		if(vlrNumber!=null)
		{
			sb.append("vlrNumber=[");
			sb.append(vlrNumber);
			sb.append("]");
		}
        
		if(mMTelInformation!=null)
		{
			sb.append("mMTelInformation=[");
			sb.append(mMTelInformation);
			sb.append("]");
		}
        
		if(mscAddress!=null)
		{
			sb.append("mscAddress=[");
			sb.append(mscAddress);
			sb.append("]"); 
		}
        
		if(threeGPPPSDataOffStatus!=null && threeGPPPSDataOffStatus.getStatus()!=null)
		{
			sb.append("threeGPPPSDataOffStatus=[");
			sb.append(threeGPPPSDataOffStatus.getStatus());
			sb.append("]");
		}
        
        if(fEIdentifierList!=null)
        {
	        sb.append("fEIdentifierList=[");
	        Boolean isFirst=false;
	        for(ASNGraphicString curr:fEIdentifierList)
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr.getValue());
	        }
	        
	        sb.append("]");
        }
        
        if(onlineChargingFlagEnum!=null && onlineChargingFlagEnum.getType()!=null)
		{
			sb.append("onlineChargingFlag=[");
			sb.append(onlineChargingFlagEnum.getType());
			sb.append("]");
		}
        
        if(chargedParty!=null && chargedParty.getInvolvedParty()!=null)
		{
			sb.append("chargedParty=[");
			sb.append(chargedParty.getInvolvedParty());
			sb.append("]");
		}
        
        if(duration!=null && duration.getValue()!=null)
		{
			sb.append("duration=[");
			sb.append(duration.getValue());
			sb.append("]");
		}
        
        if(dialedPartyAddress!=null && dialedPartyAddress.getInvolvedParty()!=null)
		{
			sb.append("dialedPartyAddress=[");
			sb.append(dialedPartyAddress.getInvolvedParty());
			sb.append("]");
		}
        
        if(ringingDuration!=null && ringingDuration.getValue()!=null)
		{
			sb.append("ringingDuration=[");
			sb.append(ringingDuration.getValue());
			sb.append("]");
		}
        
        if(chargingCategory!=null && chargingCategory.getType()!=null)
		{
			sb.append("chargingCategory=[");
			sb.append(chargingCategory.getType());
			sb.append("]");
		}
        
        if(callProperty!=null && callProperty.getType()!=null)
		{
			sb.append("callProperty=[");
			sb.append(callProperty.getType());
			sb.append("]");
		}
        
        if(accountingRecordType!=null && accountingRecordType.getType()!=null)
		{
			sb.append("accountingRecordType=[");
			sb.append(accountingRecordType.getType());
			sb.append("]");
		}
        
        if(sdpMediaIdentifier!=null && sdpMediaIdentifier.getIdentifier()!=null)
		{
			sb.append("sdpMediaIdentifier=[");
			sb.append(sdpMediaIdentifier.getIdentifier());
			sb.append("]");
		}
        
        if(mscNumber!=null && mscNumber.getValue()!=null)
		{
			sb.append("mscNumber=[");
			sb.append(mscNumber.getValue());
			sb.append("]");
		}
        
        if(tadsIndication!=null && tadsIndication.getType()!=null)
		{
			sb.append("tadsIndication=[");
			sb.append(tadsIndication.getType());
			sb.append("]");
		}
        
        if(inInformation!=null && inInformation.getInInformation()!=null)
        {
	        sb.append("inInformation=[");
	        Boolean isFirst=false;
	        for(InInformation curr:inInformation.getInInformation())
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
	        sb.append("]");
        }
        
        if(privateUserEquipmentInfo!=null)
		{
			sb.append("privateUserEquipmentInfo=[");
			sb.append(privateUserEquipmentInfo);
			sb.append("]");
		}
        
        if(recordingEntityID!=null && recordingEntityID.getValue()!=null)
		{
			sb.append("recordingEntityID=[");
			sb.append(recordingEntityID.getValue());
			sb.append("]");
		}
        
        if(specifiedTreatmentField!=null)
		{
			sb.append("specifiedTreatmentField=[");
			sb.append(specifiedTreatmentField);
			sb.append("]");
		}               
                
        sb.append("]");
        return sb.toString();
    }	
}