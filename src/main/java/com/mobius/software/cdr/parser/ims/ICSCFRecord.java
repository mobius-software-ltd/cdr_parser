package com.mobius.software.cdr.parser.ims;
import java.util.ArrayList;
import java.util.List;

import com.mobius.software.cdr.parser.primitives.ASNCauseForRecordClosing;
import com.mobius.software.cdr.parser.primitives.ASNRecordType;
import com.mobius.software.cdr.parser.primitives.ASNRoleOfNode;
import com.mobius.software.cdr.parser.primitives.ASNSessionPriority;
import com.mobius.software.cdr.parser.primitives.CauseForRecordClosing;
import com.mobius.software.cdr.parser.primitives.IncompleteCDRIndication;
import com.mobius.software.cdr.parser.primitives.InterOperatorIdentifiers;
import com.mobius.software.cdr.parser.primitives.InterOperatorIdentifiersListWrapper;
import com.mobius.software.cdr.parser.primitives.InvolvedParty;
import com.mobius.software.cdr.parser.primitives.InvolvedPartyListWrapper;
import com.mobius.software.cdr.parser.primitives.InvolvedPartyWrapper;
import com.mobius.software.cdr.parser.primitives.MSTimezone;
import com.mobius.software.cdr.parser.primitives.NodeAddress;
import com.mobius.software.cdr.parser.primitives.NodeAddressWrapper;
import com.mobius.software.cdr.parser.primitives.RecordType;
import com.mobius.software.cdr.parser.primitives.RoleOfNode;
import com.mobius.software.cdr.parser.primitives.SCSCFInformation;
import com.mobius.software.cdr.parser.primitives.SessionPriority;
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
ICSCFRecord ::= SET
{
 recordType [0] RecordType,
 retransmission [1] NULL OPTIONAL,
 sIP-Method [2] SIP-Method OPTIONAL,
 role-of-Node [3] Role-of-Node OPTIONAL,
 nodeAddress [4] NodeAddress OPTIONAL,
 session-Id [5] Session-Id OPTIONAL,
 list-Of-Calling-Party-Address [6] ListOfInvolvedParties OPTIONAL,
 called-Party-Address [7] InvolvedParty OPTIONAL,
 serviceRequestTimeStamp [9] TimeStamp OPTIONAL,
 interOperatorIdentifiers [14] InterOperatorIdentifiers OPTIONAL,
 localRecordSequenceNumber [15] LocalSequenceNumber OPTIONAL,
 causeForRecordClosing [17] CauseForRecordClosing OPTIONAL,
 incomplete-CDR-Indication [18] Incomplete-CDR-Indication OPTIONAL,
 iMS-Charging-Identifier [19] IMS-Charging-Identifier OPTIONAL,
 serviceReasonReturnCode [23] UTF8String OPTIONAL,
 recordExtensions [25] ManagementExtensions OPTIONAL,
 expiresInformation [26] INTEGER OPTIONAL,
 list-Of-Associated-URI [27] ListOfInvolvedParties OPTIONAL,
 event [28] UTF8String OPTIONAL,
 accessNetworkInformation [29] OCTET STRING OPTIONAL,
 serviceContextID [30] ServiceContextID OPTIONAL,
 numberPortabilityRouting [34] NumberPortabilityRouting OPTIONAL,
 carrierSelectRouting [35] CarrierSelectRouting OPTIONAL,
 sessionPriority [36] SessionPriority OPTIONAL,
 serviceRequestTimeStampFraction [37] Milliseconds OPTIONAL, 
 transit-IOI-List [45] GraphicString OPTIONAL,
 userLocationInformation [47] OCTET STRING OPTIONAL,
 mSTimeZone [48] MSTimeZone OPTIONAL,
 fromAddress [51] OCTET STRING OPTIONAL,
 iMSEmergencyIndicator [52] NULL OPTIONAL,
 listOfReasonHeader [55] ListOfReasonHeader OPTIONAL,
 additionalAccessNetworkInformation [56] OCTET STRING OPTIONAL,
 routeHeaderTransmitted [60] OCTET STRING OPTIONAL,
 s-CSCF-Information [61] S-CSCF-Information OPTIONAL,
 cellularNetworkInformation [64] OCTET STRING OPTIONAL,
 fEIdentifierList [65] FEIdentifierList OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 65,constructed = true,lengthIndefinite = false)
public class ICSCFRecord 
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
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = false,index = -1)
	private TimeStamp serviceRequestTimeStamp;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 14,constructed = true,index = -1)
	private InterOperatorIdentifiersListWrapper interOperatorIdentifiers;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 15,constructed = false,index = -1)
	private ASNInteger localSequenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 17,constructed = false,index = -1)
	private ASNCauseForRecordClosing causeForRecordClosing;	
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 18,constructed = true,index = -1)
	private IncompleteCDRIndication incompleteCDRIndication;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 19,constructed = false,index = -1)
	private ASNOctetString imsChargingIdentifier;		
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 23,constructed = false,index = -1)
	private ASNUTF8String serviceReasonReturnCode;
	
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
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 34,constructed = false,index = -1)
	private ASNGraphicString numberPortabilityRouting;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 35,constructed = false,index = -1)
	private ASNGraphicString carrierSelectRouting;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 36,constructed = false,index = -1)
	private ASNSessionPriority sessionPriority;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 37,constructed = false,index = -1)
	private ASNInteger serviceRequestTimeStampFraction;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 45,constructed = false,index = -1)
	private ASNGraphicString  transitIOIList;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 47,constructed = false,index = -1)
	private ASNOctetString userLocationInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 48,constructed = false,index = -1)
	private MSTimezone msTimeZone;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 51,constructed = false,index = -1)
	private ASNOctetString fromAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 52,constructed = false,index = -1)
	private ASNNull imsEmergencyIndicator;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 55,constructed = false,index = -1)
	private List<ASNGraphicString>  listOfReasonHeader;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 56,constructed = false,index = -1)
	private ASNOctetString additionalAccessNetworkInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 60,constructed = false,index = -1)
	private ASNOctetString routeHeaderTransmitted;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 61,constructed = true,index = -1)
	private SCSCFInformation scscfInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 64,constructed = false,index = -1)
	private ASNOctetString cellularNetworkInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 65,constructed = false,index = -1)
	private List<ASNGraphicString> fEIdentifierList;
	
	public ICSCFRecord()
	{
		
	}

	public ICSCFRecord(RecordType recordType, boolean retransmission, String sipMethod,
			RoleOfNode roleOfNode, NodeAddress nodeAddress, String sessionID,
			List<InvolvedParty> listOfCallingPartyAddress, InvolvedParty calledPartyAddress,
			TimeStamp serviceRequestTimeStamp, List<InterOperatorIdentifiers> interOperatorIdentifiers,
			Integer localSequenceNumber, CauseForRecordClosing causeForRecordClosing,
			IncompleteCDRIndication incompleteCDRIndication, byte[] imsChargingIdentifier,
			String serviceReasonReturnCode, byte[] recordExtensions, Integer expiresInformation,
			List<InvolvedParty> listOfAssociatedURI, String event, byte[] accessNetworkInformation,
			String serviceContextID, String numberPortabilityRouting,
			String carrierSelectRouting, SessionPriority sessionPriority,
			Integer serviceRequestTimeStampFraction, String transitIOIList,
			byte[] userLocationInformation, MSTimezone msTimeZone, byte[] fromAddress,
			boolean imsEmergencyIndicator, List<String> listOfReasonHeader,
			byte[] additionalAccessNetworkInformation, byte[] routeHeaderTransmitted,
			SCSCFInformation scscfInformation, byte[] cellularNetworkInformation,
			List<String> fEIdentifierList) 
	{
		if(recordType!=null)
		{
			this.recordType = new ASNRecordType();
			this.recordType.setType(recordType);
		}
		
		if(retransmission)
			this.retransmission = new ASNNull();
		
		if(sipMethod!=null)
		{
			this.sipMethod = new ASNGraphicString();
			this.sipMethod.setValue(sipMethod);
		}
		
		if(roleOfNode!=null)
		{
			this.roleOfNode = new ASNRoleOfNode();
			this.roleOfNode.setType(roleOfNode);
		}
		
		if(nodeAddress!=null)
			this.nodeAddress = new NodeAddressWrapper(nodeAddress);
		
		if(sessionID!=null)
		{
			this.sessionID = new ASNGraphicString();
			this.sessionID.setValue(sessionID);
		}
		
		if(listOfCallingPartyAddress!=null)
			this.listOfCallingPartyAddress = new InvolvedPartyListWrapper(listOfCallingPartyAddress);
		
		if(calledPartyAddress!=null)
			this.calledPartyAddress = new InvolvedPartyWrapper(calledPartyAddress);
		
		this.serviceRequestTimeStamp = serviceRequestTimeStamp;
		
		if(interOperatorIdentifiers!=null)
			this.interOperatorIdentifiers = new InterOperatorIdentifiersListWrapper(interOperatorIdentifiers);
		
		if(localSequenceNumber!=null)
		{
			this.localSequenceNumber = new ASNInteger();
			this.localSequenceNumber.setValue(localSequenceNumber.longValue());
		}
		
		if(causeForRecordClosing!=null)
		{
			this.causeForRecordClosing = new ASNCauseForRecordClosing();
			this.causeForRecordClosing.setType(causeForRecordClosing);
		}
		
		this.incompleteCDRIndication = incompleteCDRIndication;
		
		if(imsChargingIdentifier!=null)
		{
			this.imsChargingIdentifier = new ASNOctetString();
			this.imsChargingIdentifier.setValue(Unpooled.wrappedBuffer(imsChargingIdentifier));
		}
		
		if(serviceReasonReturnCode!=null)
		{
			this.serviceReasonReturnCode = new ASNUTF8String();
			this.serviceReasonReturnCode.setValue(serviceReasonReturnCode);
		}
		
		if(recordExtensions!=null)
		{
			this.recordExtensions = new ASNOctetString();
			this.recordExtensions.setValue(Unpooled.wrappedBuffer(recordExtensions));
		}
		
		if(expiresInformation!=null)
		{
			this.expiresInformation = new ASNInteger();
			this.expiresInformation.setValue(expiresInformation.longValue());
		}
		
		if(listOfAssociatedURI!=null)
			this.listOfAssociatedURI = new InvolvedPartyListWrapper(listOfAssociatedURI);
		
		if(event!=null)
		{
			this.event = new ASNUTF8String();
			this.event.setValue(event);
		}
		
		if(accessNetworkInformation!=null)
		{
			this.accessNetworkInformation = new ASNOctetString();
			this.accessNetworkInformation.setValue(Unpooled.wrappedBuffer(accessNetworkInformation));
		}
		
		if(serviceContextID!=null)
		{
			this.serviceContextID = new ASNUTF8String();
			this.serviceContextID.setValue(serviceContextID);
		}
		
		if(numberPortabilityRouting!=null)
		{
			this.numberPortabilityRouting = new ASNGraphicString();
			this.numberPortabilityRouting.setValue(numberPortabilityRouting);
		}
		
		if(carrierSelectRouting!=null)
		{
			this.carrierSelectRouting = new ASNGraphicString();
			this.carrierSelectRouting.setValue(carrierSelectRouting);
		}
		
		if(sessionPriority!=null)
		{
			this.sessionPriority = new ASNSessionPriority();
			this.sessionPriority.setType(sessionPriority);
		}
		
		if(serviceRequestTimeStampFraction!=null)
		{
			this.serviceRequestTimeStampFraction = new ASNInteger();
			this.serviceRequestTimeStampFraction.setValue(serviceRequestTimeStampFraction.longValue());
		}
		
		if(transitIOIList!=null)
		{
			this.transitIOIList=new ASNGraphicString();
			this.transitIOIList.setValue(transitIOIList);
		}
		
		if(userLocationInformation!=null)
		{
			this.userLocationInformation = new ASNOctetString();
			this.userLocationInformation.setValue(Unpooled.wrappedBuffer(userLocationInformation));
		}
		
		this.msTimeZone = msTimeZone;
		
		if(fromAddress!=null)
		{
			this.fromAddress = new ASNOctetString();
			this.fromAddress.setValue(Unpooled.wrappedBuffer(fromAddress));
		}
		
		if(imsEmergencyIndicator)
			this.imsEmergencyIndicator = new ASNNull();
		
		if(listOfReasonHeader!=null)
		{
			this.listOfReasonHeader = new ArrayList<ASNGraphicString>();
			for(String curr:listOfReasonHeader)
			{
				ASNGraphicString currStr=new ASNGraphicString();
				currStr.setValue(curr);
				this.listOfReasonHeader.add(currStr);
			}
		}
		
		if(additionalAccessNetworkInformation!=null)
		{
			this.additionalAccessNetworkInformation = new ASNOctetString();
			this.additionalAccessNetworkInformation.setValue(Unpooled.wrappedBuffer(additionalAccessNetworkInformation));
		}
		
		if(routeHeaderTransmitted!=null)
		{
			this.routeHeaderTransmitted = new ASNOctetString();
			this.routeHeaderTransmitted.setValue(Unpooled.wrappedBuffer(routeHeaderTransmitted));
		}
		
		this.scscfInformation=scscfInformation;
		if(cellularNetworkInformation!=null)
		{
			this.cellularNetworkInformation = new ASNOctetString();
			this.cellularNetworkInformation.setValue(Unpooled.wrappedBuffer(cellularNetworkInformation));
		}
		
		if(fEIdentifierList!=null)
		{
			this.fEIdentifierList = new ArrayList<ASNGraphicString>();
			for(String curr:fEIdentifierList)
			{
				ASNGraphicString currStr=new ASNGraphicString();
				currStr.setValue(curr);
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

	public TimeStamp getServiceRequestTimeStamp() 
	{
		return serviceRequestTimeStamp;
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

	public String getServiceReasonReturnCode() 
	{
		if(serviceReasonReturnCode==null)
			return null;
		
		return serviceReasonReturnCode.getValue();
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
	
	public String getTransitIOIList() 
	{
		if(transitIOIList==null)
			return null;
		
		return transitIOIList.getValue();
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

	public byte[] getRouteHeaderTransmitted() 
	{
		if(routeHeaderTransmitted==null || routeHeaderTransmitted.getValue()==null)
			return null;
		
		ByteBuf value=routeHeaderTransmitted.getValue();
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public SCSCFInformation getScscfInformation() 
	{
		return scscfInformation;
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
	
	@Override
	public String toString() 
	{
        StringBuilder sb = new StringBuilder();
        sb.append("ICSCFRecord");
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
        
        if(serviceRequestTimeStamp!=null)
        {
	        sb.append("serviceRequestTimeStamp=[");
	        sb.append(this.serviceRequestTimeStamp);
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
	        sb.append(ASNOctetString.printDataArr(getImsChargingIdentifier()));
	        sb.append("]");
        }
        
        if(imsChargingIdentifier!=null && imsChargingIdentifier.getValue()!=null)
        {
	        sb.append(" imsChargingIdentifierStr=[");
	        sb.append(getImsChargingIdentifierStr());
	        sb.append("]");
        }
        
        if(serviceReasonReturnCode!=null && serviceReasonReturnCode.getValue()!=null)
        {
	        sb.append("serviceReasonReturnCode=[");
	        sb.append(serviceReasonReturnCode.getValue());
	        sb.append("]");
        }
        
        if(recordExtensions!=null && recordExtensions.getValue()!=null)
        {
	        sb.append("recordExtensions=[");
	        sb.append(ASNOctetString.printDataArr(getRecordExtensions()));
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
	        sb.append(ASNOctetString.printDataArr(getAccessNetworkInformation()));
	        sb.append("]");
        }
        
        if(serviceContextID!=null && serviceContextID.getValue()!=null)
        {
	        sb.append("serviceContextID=[");
	        sb.append(serviceContextID.getValue());
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
        
        if(transitIOIList!=null && transitIOIList.getValue()!=null)
        {
	        sb.append("transitIOIList=[");
	        sb.append(transitIOIList.getValue());
	        sb.append("]");
        }
        
        if(userLocationInformation!=null && userLocationInformation.getValue()!=null)
        {
	        sb.append("userLocationInformation=[");
	        sb.append(ASNOctetString.printDataArr(getUserLocationInformation()));
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
	        sb.append(ASNOctetString.printDataArr(getFromAddress()));
	        sb.append("]");
        }
        
        if(imsEmergencyIndicator!=null)
        {
        	sb.append("imsEmergencyIndicator ");	        
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
	        sb.append(ASNOctetString.printDataArr(getAdditionalAccessNetworkInformation()));
	        sb.append("]");
        }
        
        if(routeHeaderTransmitted!=null && routeHeaderTransmitted.getValue()!=null)
        {
	        sb.append("routeHeaderTransmitted=[");
	        sb.append(ASNOctetString.printDataArr(getRouteHeaderTransmitted()));
	        sb.append("]");
        }
        
        if(scscfInformation!=null)
        {
	        sb.append("scscfInformation=[");
	        sb.append(scscfInformation);
	        sb.append("]");
        }
        
        if(cellularNetworkInformation!=null && cellularNetworkInformation.getValue()!=null)
        {
	        sb.append("cellularNetworkInformation=[");
	        sb.append(ASNOctetString.printDataArr(getCellularNetworkInformation()));
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