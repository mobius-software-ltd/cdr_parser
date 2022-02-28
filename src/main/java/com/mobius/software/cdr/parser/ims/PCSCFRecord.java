package com.mobius.software.cdr.parser.ims;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.cdr.parser.primitives.ASNCauseForRecordClosing;
import com.mobius.software.cdr.parser.primitives.ASNRecordType;
import com.mobius.software.cdr.parser.primitives.ASNRoleOfNode;
import com.mobius.software.cdr.parser.primitives.ASNSessionPriority;
import com.mobius.software.cdr.parser.primitives.AccessNetworkInfoChange;
import com.mobius.software.cdr.parser.primitives.AccessTransferInformation;
import com.mobius.software.cdr.parser.primitives.CalledIdentityChange;
import com.mobius.software.cdr.parser.primitives.CauseForRecordClosing;
import com.mobius.software.cdr.parser.primitives.EarlyMediaComponentList;
import com.mobius.software.cdr.parser.primitives.IPAddress;
import com.mobius.software.cdr.parser.primitives.IPAddressWrapper;
import com.mobius.software.cdr.parser.primitives.IncompleteCDRIndication;
import com.mobius.software.cdr.parser.primitives.InterOperatorIdentifiers;
import com.mobius.software.cdr.parser.primitives.InterOperatorIdentifiersListWrapper;
import com.mobius.software.cdr.parser.primitives.InvolvedParty;
import com.mobius.software.cdr.parser.primitives.InvolvedPartyListWrapper;
import com.mobius.software.cdr.parser.primitives.InvolvedPartyWrapper;
import com.mobius.software.cdr.parser.primitives.MSTimezone;
import com.mobius.software.cdr.parser.primitives.MediaComponentList;
import com.mobius.software.cdr.parser.primitives.MediaComponentListWrapper;
import com.mobius.software.cdr.parser.primitives.MessageBody;
import com.mobius.software.cdr.parser.primitives.NNIInformation;
import com.mobius.software.cdr.parser.primitives.NodeAddress;
import com.mobius.software.cdr.parser.primitives.NodeAddressWrapper;
import com.mobius.software.cdr.parser.primitives.RecordType;
import com.mobius.software.cdr.parser.primitives.RoleOfNode;
import com.mobius.software.cdr.parser.primitives.SessionPriority;
import com.mobius.software.cdr.parser.primitives.SubscriberEquipmentNumber;
import com.mobius.software.cdr.parser.primitives.SubscriptionID;
import com.mobius.software.cdr.parser.primitives.SubscriptionIDListWrapper;
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
 * 
PCSCFRecord ::= SET
--
-- This record is also applicable for P-CSCF with collocated ATCF
-- ATCF-specific fields which are not applicable to P-CSCF are indicated.
--
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
 list-Of-Associated-URI [27] ListOfInvolvedParties OPTIONAL,
 event [28] UTF8String OPTIONAL,
 accessNetworkInformation [29] OCTET STRING OPTIONAL,
 serviceContextID [30] ServiceContextID OPTIONAL,
 list-of-subscription-ID [31] SEQUENCE OF SubscriptionID OPTIONAL,
 list-Of-Early-SDP-Media-Components [32] SEQUENCE OF Early-Media-Components-List OPTIONAL,
 iMSCommunicationServiceIdentifier [33] IMSCommunicationServiceIdentifier OPTIONAL,
 sessionPriority [36] SessionPriority OPTIONAL,
 serviceRequestTimeStampFraction [37] Milliseconds OPTIONAL,
 serviceDeliveryStartTimeStampFraction [38] Milliseconds OPTIONAL,
 serviceDeliveryEndTimeStampFraction [39] Milliseconds OPTIONAL,
 list-of-Requested-Party-Address [41] ListOfInvolvedParties OPTIONAL, -- ATCF only
 list-Of-Called-Asserted-Identity [42] ListOfInvolvedParties OPTIONAL,
 nNI-Information [46] NNI-Information OPTIONAL,
 userLocationInformation [47] OCTET STRING OPTIONAL,
 mSTimeZone [48] MSTimeZone OPTIONAL,
 servedPartyIPAddress [50] ServedPartyIPAddress OPTIONAL,
 fromAddress [51] OCTET STRING OPTIONAL,
 iMSEmergencyIndicator [52] NULL OPTIONAL,
 transit-IOI-Lists [53] TransitIOILists OPTIONAL,
 iMSVisitedNetworkIdentifier [54] OCTET STRING OPTIONAL,
 listOfReasonHeader [55] ListOfReasonHeader OPTIONAL,
 additionalAccessNetworkInformation [56] OCTET STRING OPTIONAL,
 instanceId [57] OCTET STRING OPTIONAL,
 subscriberEquipmentNumber [58] SubscriberEquipmentNumber OPTIONAL,
 routeHeaderReceived [59] OCTET STRING OPTIONAL,
 routeHeaderTransmitted [60] OCTET STRING OPTIONAL,
 list-Of-AccessNetworkInfoChange [62] SEQUENCE OF AccessNetworkInfoChange OPTIONAL,
 listOfCalledIdentityChanges [63] SEQUENCE OF CalledIdentityChange OPTIONAL,
 cellularNetworkInformation [64] OCTET STRING OPTIONAL,
 initialIMS-Charging-Identifier [105] IMS-Charging-Identifier OPTIONAL, -- ATCF only
 list-Of-AccessTransferInformation [106] SEQUENCE OF AccessTransferInformation OPTIONAL,
 -- ATCF only
 relatedICID [107] IMS-Charging-Identifier OPTIONAL,
 relatedICIDGenerationNode [108] NodeAddress OPTIONAL,
 fEIdentifierList [109] FEIdentifierList OPTIONAL
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 64,constructed = true,lengthIndefinite = false)
public class PCSCFRecord 
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
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 27,constructed = true,index = -1)
	private InvolvedPartyListWrapper listOfAssociatedURI;
	
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
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 42,constructed = true,index = -1)
	private InvolvedPartyListWrapper listOfCalledAssertedIdentity;	
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 46,constructed = true,index = -1)
	private NNIInformation nniInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 47,constructed = false,index = -1)
	private ASNOctetString userLocationInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 48,constructed = false,index = -1)
	private MSTimezone msTimeZone;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 50,constructed = false,index = -1)
	private IPAddressWrapper servedPartyIPAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 51,constructed = false,index = -1)
	private ASNOctetString fromAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 52,constructed = false,index = -1)
	private ASNNull imsEmergencyIndicator;
	
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
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 59,constructed = false,index = -1)
	private ASNOctetString routeHeaderReceived;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 60,constructed = false,index = -1)
	private ASNOctetString routeHeaderTransmitted;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 62,constructed = true,index = -1)
	private List<AccessNetworkInfoChange> listOfAccessNetworkInfoChange;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 63,constructed = true,index = -1)
	private List<CalledIdentityChange> listOfCalledIdentityChanges;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 64,constructed = false,index = -1)
	private ASNOctetString cellularNetworkInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 105,constructed = false,index = -1)
	private ASNOctetString initialIMSChargingIdentifier;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 106,constructed = true,index = -1)
	private List<AccessTransferInformation> listOfAccessTransferInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 107,constructed = false,index = -1)
	private ASNOctetString relatedICID;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 108,constructed = false,index = -1)
	private NodeAddressWrapper relatedICIDGenerationNode;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 109,constructed = false,index = -1)
	private List<ASNGraphicString> fEIdentifierList;	
	
	public PCSCFRecord()
	{
		
	}

	public PCSCFRecord(RecordType recordType, boolean retransmission, String sipMethod,
			RoleOfNode roleOfNode, NodeAddress nodeAddress, String sessionID,
			List<InvolvedParty> listOfCallingPartyAddress, InvolvedParty calledPartyAddress,
			String privateUserID, TimeStamp serviceRequestTimeStamp, TimeStamp serviceDeliveryStartTimeStamp,
			TimeStamp serviceDeliveryEndTimeStamp, TimeStamp recordOpeningTime, TimeStamp recordClosureTime,
			List<InterOperatorIdentifiers> interOperatorIdentifiers, Integer localSequenceNumber,
			Integer recordSequenceNumber, CauseForRecordClosing causeForRecordClosing,
			IncompleteCDRIndication incompleteCDRIndication, byte[] imsChargingIdentifier,
			List<MediaComponentList> mediaComponentList, NodeAddress ggsnAddress,
			String serviceReasonReturnCode, List<MessageBody> listOfMessageBodies,
			byte[] recordExtensions, Integer expiresInformation,
			List<InvolvedParty> listOfAssociatedURI, String event, byte[] accessNetworkInformation,
			String serviceContextID, List<SubscriptionID> listOfSubscriptionID,
			List<EarlyMediaComponentList> listOfEarlySDPMediaComponents,
			byte[] imsCommunicationServiceIdentifier, SessionPriority sessionPriority,
			Integer serviceRequestTimeStampFraction, Integer serviceDeliveryStartTimeStampFraction,
			Integer serviceDeliveryEndTimeStampFraction, List<InvolvedParty> listOfRequestedPartyAddress,
			List<InvolvedParty> listOfCalledAssertedIdentity, NNIInformation nniInformation,
			byte[] userLocationInformation, MSTimezone msTimeZone, IPAddress servedPartyIPAddress,
			byte[] fromAddress, byte[] imsEmergencyIndicator, List<String> transitIOILists,
			byte[] imsVisitedNetworkIdentifier, List<String> listOfReasonHeader,
			byte[] additionalAccessNetworkInformation, byte[] instanceId,
			SubscriberEquipmentNumber subscriberEquipmentNumber, byte[] routeHeaderReceived,
			byte[] routeHeaderTransmitted, List<AccessNetworkInfoChange> listOfAccessNetworkInfoChange,
			List<CalledIdentityChange> listOfCalledIdentityChanges, byte[] cellularNetworkInformation,
			byte[] initialIMSChargingIdentifier,
			List<AccessTransferInformation> listOfAccessTransferInformation, byte[] relatedICID,
			NodeAddress relatedICIDGenerationNode, List<String> fEIdentifierList) 
	{
		if(recordType!=null)
			this.recordType = new ASNRecordType(recordType);
		
		if(retransmission)
			this.retransmission = new ASNNull();
		
		if(sipMethod!=null)
			this.sipMethod = new ASNGraphicString(sipMethod,null,null,null,false);
		
		if(roleOfNode!=null)
			this.roleOfNode = new ASNRoleOfNode(roleOfNode);
		
		if(nodeAddress!=null)
			this.nodeAddress = new NodeAddressWrapper(nodeAddress);
		
		if(sessionID!=null)
			this.sessionID = new ASNGraphicString(sessionID,null,null,null,false);
		
		if(listOfCallingPartyAddress!=null)
			this.listOfCallingPartyAddress = new InvolvedPartyListWrapper(listOfCallingPartyAddress);
		
		if(calledPartyAddress!=null)
			this.calledPartyAddress = new InvolvedPartyWrapper(calledPartyAddress);
		
		if(privateUserID!=null)
			this.privateUserID = new ASNGraphicString(privateUserID,null,null,null,false);
		
		this.serviceRequestTimeStamp = serviceRequestTimeStamp;
		this.serviceDeliveryStartTimeStamp = serviceDeliveryStartTimeStamp;
		this.serviceDeliveryEndTimeStamp = serviceDeliveryEndTimeStamp;
		this.recordOpeningTime = recordOpeningTime;
		this.recordClosureTime = recordClosureTime;

		if(interOperatorIdentifiers!=null)
			this.interOperatorIdentifiers = new InterOperatorIdentifiersListWrapper(interOperatorIdentifiers);
		
		if(localSequenceNumber!=null)
			this.localSequenceNumber = new ASNInteger(localSequenceNumber.longValue(),null,null,null,false);
		
		if(recordSequenceNumber!=null)
			this.recordSequenceNumber = new ASNInteger(recordSequenceNumber.longValue(),null,null,null,false);
		
		if(causeForRecordClosing!=null)
			this.causeForRecordClosing = new ASNCauseForRecordClosing(causeForRecordClosing);
		
		this.incompleteCDRIndication = incompleteCDRIndication;
		
		if(imsChargingIdentifier!=null)
			this.imsChargingIdentifier = new ASNOctetString(Unpooled.wrappedBuffer(imsChargingIdentifier),null,null,null,false);
		
		if(mediaComponentList!=null)
			this.mediaComponentList = new MediaComponentListWrapper(mediaComponentList);
		
		if(ggsnAddress!=null)
			this.ggsnAddress = new NodeAddressWrapper(ggsnAddress);
		
		if(serviceReasonReturnCode!=null)
			this.serviceReasonReturnCode = new ASNUTF8String(serviceReasonReturnCode,null,null,null,false);
		
		this.listOfMessageBodies = listOfMessageBodies;
		
		if(recordExtensions!=null)
			this.recordExtensions = new ASNOctetString(Unpooled.wrappedBuffer(recordExtensions),null,null,null,false);
		
		if(expiresInformation!=null)
			this.expiresInformation = new ASNInteger(expiresInformation.longValue(),null,null,null,false);
		
		if(listOfAssociatedURI!=null)
			this.listOfAssociatedURI = new InvolvedPartyListWrapper(listOfAssociatedURI);
		
		if(event!=null)
			this.event = new ASNUTF8String(event,null,null,null,false);
		
		if(accessNetworkInformation!=null)
			this.accessNetworkInformation = new ASNOctetString(Unpooled.wrappedBuffer(accessNetworkInformation),null,null,null,false);
		
		if(serviceContextID!=null)
			this.serviceContextID = new ASNUTF8String(serviceContextID,null,null,null,false);
		
		if(listOfSubscriptionID!=null)
			this.listOfSubscriptionID = new SubscriptionIDListWrapper(listOfSubscriptionID);
		
		this.listOfEarlySDPMediaComponents = listOfEarlySDPMediaComponents;
		
		if(imsCommunicationServiceIdentifier!=null)
			this.imsCommunicationServiceIdentifier = new ASNOctetString(Unpooled.wrappedBuffer(imsCommunicationServiceIdentifier),null,null,null,false);
		
		if(sessionPriority!=null)
			this.sessionPriority = new ASNSessionPriority(sessionPriority);
		
		if(serviceRequestTimeStampFraction!=null)
			this.serviceRequestTimeStampFraction = new ASNInteger(serviceRequestTimeStampFraction.longValue(),null,null,null,false);
		
		if(serviceDeliveryStartTimeStampFraction!=null)
			this.serviceDeliveryStartTimeStampFraction = new ASNInteger(serviceDeliveryStartTimeStampFraction.longValue(),null,null,null,false);
		
		if(serviceDeliveryEndTimeStampFraction!=null)
			this.serviceDeliveryEndTimeStampFraction = new ASNInteger(serviceDeliveryEndTimeStampFraction.longValue(),null,null,null,false);
		
		if(listOfRequestedPartyAddress!=null)
			this.listOfRequestedPartyAddress = new InvolvedPartyListWrapper(listOfRequestedPartyAddress);
		
		if(listOfCalledAssertedIdentity!=null)
			this.listOfCalledAssertedIdentity = new InvolvedPartyListWrapper(listOfCalledAssertedIdentity);
		
		if(userLocationInformation!=null)
			this.userLocationInformation = new ASNOctetString(Unpooled.wrappedBuffer(userLocationInformation),null,null,null,false);
		
		this.msTimeZone = msTimeZone;
		this.nniInformation = nniInformation;
		
		if(servedPartyIPAddress!=null)
			this.servedPartyIPAddress=new IPAddressWrapper(servedPartyIPAddress);
		
		if(fromAddress!=null)
			this.fromAddress = new ASNOctetString(Unpooled.wrappedBuffer(fromAddress),null,null,null,false);
		
		if(transitIOILists!=null)
		{
			this.transitIOILists = new ArrayList<ASNGraphicString>();
			for(String curr:transitIOILists)
			{
				ASNGraphicString currStr=new ASNGraphicString(curr,null,null,null,false);
				this.transitIOILists.add(currStr);
			}
		}
		
		if(imsVisitedNetworkIdentifier!=null)
			this.imsVisitedNetworkIdentifier = new ASNOctetString(Unpooled.wrappedBuffer(imsVisitedNetworkIdentifier),null,null,null,false);
		
		if(listOfReasonHeader!=null)
		{
			this.listOfReasonHeader = new ArrayList<ASNGraphicString>();
			for(String curr:listOfReasonHeader)
			{
				ASNGraphicString currStr=new ASNGraphicString(curr,null,null,null,false);
				this.listOfReasonHeader.add(currStr);
			}
		}
		
		if(additionalAccessNetworkInformation!=null)
			this.additionalAccessNetworkInformation = new ASNOctetString(Unpooled.wrappedBuffer(additionalAccessNetworkInformation),null,null,null,false);
		
		if(instanceId!=null)
			this.instanceId = new ASNOctetString(Unpooled.wrappedBuffer(instanceId),null,null,null,false);
		
		this.subscriberEquipmentNumber = subscriberEquipmentNumber;
		
		if(routeHeaderReceived!=null)
			this.routeHeaderReceived = new ASNOctetString(Unpooled.wrappedBuffer(routeHeaderReceived),null,null,null,false);
		
		if(routeHeaderTransmitted!=null)
			this.routeHeaderTransmitted = new ASNOctetString(Unpooled.wrappedBuffer(routeHeaderTransmitted),null,null,null,false);
		
		this.listOfAccessNetworkInfoChange = listOfAccessNetworkInfoChange;
		this.listOfCalledIdentityChanges = listOfCalledIdentityChanges;
		
		if(cellularNetworkInformation!=null)
			this.cellularNetworkInformation = new ASNOctetString(Unpooled.wrappedBuffer(cellularNetworkInformation),null,null,null,false);
		
		if(initialIMSChargingIdentifier!=null)
			this.initialIMSChargingIdentifier = new ASNOctetString(Unpooled.wrappedBuffer(initialIMSChargingIdentifier),null,null,null,false);
		
		this.listOfAccessTransferInformation = listOfAccessTransferInformation;
		
		if(relatedICID!=null)
			this.relatedICID = new ASNOctetString(Unpooled.wrappedBuffer(relatedICID),null,null,null,false);
		
		if(relatedICIDGenerationNode!=null)
			this.relatedICIDGenerationNode = new NodeAddressWrapper(relatedICIDGenerationNode);
		
		if(fEIdentifierList!=null)
		{
			this.fEIdentifierList = new ArrayList<ASNGraphicString>();
			for(String curr:fEIdentifierList)
			{
				ASNGraphicString currStr=new ASNGraphicString(curr,null,null,null,false);
				this.fEIdentifierList.add(currStr);
			}
		}				
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

	public List<InvolvedParty> getListOfAssociatedURI() 
	{
		if(listOfAssociatedURI==null)
			return null;
		
		return listOfAssociatedURI.getInvolvedParty();
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

	public List<InvolvedParty> getListOfCalledAssertedIdentity() 
	{
		if(listOfCalledAssertedIdentity==null)
			return null;
		
		return listOfCalledAssertedIdentity.getInvolvedParty();
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

	public IPAddress getServedPartyIPAddress() 
	{
		if(servedPartyIPAddress==null)
			return null;
		
		return servedPartyIPAddress.getIPAddress();
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

	public boolean getImsEmergencyIndicator() 
	{
		return imsEmergencyIndicator!=null;
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

	public byte[] getRouteHeaderReceived() 
	{
		if(routeHeaderReceived==null || routeHeaderReceived.getValue()==null)
			return null;
		
		ByteBuf value=routeHeaderReceived.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public byte[] getRouteHeaderTransmitted() 
	{
		if(routeHeaderTransmitted==null || routeHeaderTransmitted.getValue()==null)
			return null;
		
		ByteBuf value=routeHeaderTransmitted.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
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

	public byte[] getRelatedICID() 
	{
		if(relatedICID==null || relatedICID.getValue()==null)
			return null;
		
		ByteBuf value=relatedICID.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public NodeAddress getRelatedICIDGenerationNode() 
	{
		if(relatedICIDGenerationNode==null)
			return null;
		
		return relatedICIDGenerationNode.getNodeAddress();
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
	
	@Override
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("PCSCFRecord");
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
        
        if(listOfAssociatedURI!=null && listOfAssociatedURI.getInvolvedParty()!=null)
        {
	        sb.append("listOfAssociatedURI=[");
	        Boolean isFirst=false;
	        for(InvolvedParty curr:listOfAssociatedURI.getInvolvedParty())
	        {
	        	if(!isFirst)
	        		sb.append(",");
	        	
	        	sb.append(curr);
	        }
	        
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
	        sb.append("accessNetworkInformation=[");
	        sb.append(accessNetworkInformation.printDataArr());
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
        
        if(servedPartyIPAddress!=null && servedPartyIPAddress.getIPAddress()!=null)
        {
	        sb.append("servedPartyIPAddress=[");
	        sb.append(servedPartyIPAddress.getIPAddress());
	        sb.append("]");
        }
        
        if(fromAddress!=null && fromAddress.getValue()!=null)
        {
	        sb.append("fromAddress=[");
	        sb.append(fromAddress.printDataArr());
	        sb.append("]");
        }
        
        if(imsEmergencyIndicator!=null)
        {
        	sb.append("imsEmergencyIndicator ");	        
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
        
        if(routeHeaderReceived!=null && routeHeaderReceived.getValue()!=null)
        {
	        sb.append("routeHeaderReceived=[");
	        sb.append(routeHeaderReceived.printDataArr());
	        sb.append("]");
        }
        
        if(routeHeaderTransmitted!=null && routeHeaderTransmitted.getValue()!=null)
        {
	        sb.append("routeHeaderTransmitted=[");
	        sb.append(routeHeaderTransmitted.printDataArr());
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
        
        if(relatedICID!=null && relatedICID.getValue()!=null)
        {
	        sb.append("relatedICID=[");
	        sb.append(relatedICID.printDataArr());
	        sb.append("]");
        }
        
        if(relatedICIDGenerationNode!=null && relatedICIDGenerationNode.getNodeAddress()!=null)
        {
	        sb.append("relatedICIDGenerationNode=[");
	        sb.append(relatedICIDGenerationNode.getNodeAddress());
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
        
        sb.append("]");
        return sb.toString();
    }
}