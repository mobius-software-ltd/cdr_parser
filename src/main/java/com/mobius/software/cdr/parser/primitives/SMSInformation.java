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
import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNInteger;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNUTF8String;

import io.netty.buffer.ByteBuf;
/*
SmsInformation ::= Sequence
{
 SMS-Node [1] SMS-Node,
 SMSC-Address [2] UTF8String,
 Originator-SCCP-Address [3] UTF8String,
 Message-Reference [4] OCTET STRING
 vmsc-address [5] UTF8String
 SMS-Result [6] SMS-Result
 map-fail-cause [7] map-fail-cause
 maximum-of-concatenated-sms [8] INTEGER
 concatenated-sms-reference-number [9] INTEGER
 sequence-number-of-current-sms [10] INTEGER
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class SMSInformation 
{
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNSMSNode smsNode;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNUTF8String smscAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNUTF8String originatorSCCPAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNOctetString messageReference;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private ASNUTF8String vmscAddress;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private ASNSMSResult smsResult;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = false,index = -1)
	private ASNSMSMapFailCause mapFailCause;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private ASNInteger maximumOfConcatenatedSms;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 9,constructed = false,index = -1)
	private ASNInteger concatenatedSmsReferenceNumber;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 10,constructed = false,index = -1)
	private ASNInteger sequenceNumberOfCurrentSms;
	
	public SMSInformation() {
		
	}
	
	public SMSInformation(SMSNode smsNode,String smscAddress,String originatorSCCPAddress,ByteBuf messageReference,
			String vmscAddress,SMSResult smsResult,MapFailCause mapFailCause,Integer maximumOfConcatenatedSms,
			Integer concatenatedSmsReferenceNumber,Integer sequenceNumberOfCurrentSms)
	{
		if(smsNode!=null)
			this.smsNode=new ASNSMSNode(smsNode);
		
		if(smscAddress!=null)
			this.smscAddress=new ASNUTF8String(smscAddress,null,null,null,false);		

		if(originatorSCCPAddress!=null)
			this.originatorSCCPAddress=new ASNUTF8String(originatorSCCPAddress,null,null,null,false);		

		if(messageReference!=null)
			this.messageReference=new ASNOctetString(messageReference,null,null,null,false);		

		if(vmscAddress!=null)
			this.vmscAddress=new ASNUTF8String(vmscAddress,null,null,null,false);		

		if(smsResult!=null)
			this.smsResult=new ASNSMSResult(smsResult);
		
		if(mapFailCause!=null)
			this.mapFailCause=new ASNSMSMapFailCause(mapFailCause);
		
		if(maximumOfConcatenatedSms!=null)
			this.maximumOfConcatenatedSms=new ASNInteger(maximumOfConcatenatedSms,null,null,null,false);		

		if(concatenatedSmsReferenceNumber!=null)
			this.concatenatedSmsReferenceNumber=new ASNInteger(concatenatedSmsReferenceNumber,null,null,null,false);		

		if(sequenceNumberOfCurrentSms!=null)
			this.sequenceNumberOfCurrentSms=new ASNInteger(sequenceNumberOfCurrentSms,null,null,null,false);		
	}

	public SMSNode getSMSNode() 
	{
		if(smsNode==null)
			return null;
		
		return smsNode.getType();
	}
	
	public String getSMSCAddress() 
	{
		if(smscAddress==null)
			return null;
		
		return smscAddress.getValue();
	}
	
	public String getOriginatorSCCPAddress() 
	{
		if(originatorSCCPAddress==null)
			return null;
		
		return originatorSCCPAddress.getValue();
	}
	
	public ByteBuf getMessageReference() 
	{
		if(messageReference==null)
			return null;
		
		return messageReference.getValue();
	}
	
	public String getVMSCAddress() 
	{
		if(vmscAddress==null)
			return null;
		
		return vmscAddress.getValue();
	}
	
	public SMSResult getSMSResult() 
	{
		if(smsResult==null)
			return null;
		
		return smsResult.getType();
	}
	
	public MapFailCause getMapFailCause() 
	{
		if(mapFailCause==null)
			return null;
		
		return mapFailCause.getType();
	}
	
	public Integer getMaximumOfConcatenatedSms() 
	{
		if(maximumOfConcatenatedSms==null)
			return null;
		
		return maximumOfConcatenatedSms.getIntValue();
	}
	
	public Integer getConcatenatedSmsReferenceNumber() 
	{
		if(concatenatedSmsReferenceNumber==null)
			return null;
		
		return concatenatedSmsReferenceNumber.getIntValue();
	}
	
	public Integer getSequenceNumberOfCurrentSms() 
	{
		if(sequenceNumberOfCurrentSms==null)
			return null;
		
		return sequenceNumberOfCurrentSms.getIntValue();
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SMS Information");
        sb.append(" [");

        if(smsNode!=null && smsNode.getValue()!=null)
        {
	        sb.append("smsNode=[");
	        sb.append(smsNode.getValue());
	        sb.append("]");
        }
        
        if(smscAddress!=null && smscAddress.getValue()!=null)
        {
	        sb.append("smscAddress=[");
	        sb.append(smscAddress.getValue());
	        sb.append("]");
        }
        
        if(originatorSCCPAddress!=null && originatorSCCPAddress.getValue()!=null)
        {
	        sb.append("originatorSCCPAddress=[");
	        sb.append(originatorSCCPAddress.getValue());
	        sb.append("]");
        }
        
        if(messageReference!=null && messageReference.getValue()!=null)
        {
	        sb.append("messageReference=[");
	        sb.append(messageReference.printDataArr());
	        sb.append("]");
        }
        
        if(vmscAddress!=null && vmscAddress.getValue()!=null)
        {
	        sb.append("vmscAddress=[");
	        sb.append(vmscAddress.getValue());
	        sb.append("]");
        }
        
        if(smsResult!=null && smsResult.getValue()!=null)
        {
	        sb.append("smsResult=[");
	        sb.append(smsResult.getValue());
	        sb.append("]");
        }
        
        if(mapFailCause!=null && mapFailCause.getValue()!=null)
        {
	        sb.append("mapFailCause=[");
	        sb.append(mapFailCause.getValue());
	        sb.append("]");
        }
        
        if(maximumOfConcatenatedSms!=null && maximumOfConcatenatedSms.getValue()!=null)
        {
	        sb.append("maximumOfConcatenatedSms=[");
	        sb.append(maximumOfConcatenatedSms.getValue());
	        sb.append("]");
        }
        
        if(concatenatedSmsReferenceNumber!=null && concatenatedSmsReferenceNumber.getValue()!=null)
        {
	        sb.append("concatenatedSmsReferenceNumber=[");
	        sb.append(concatenatedSmsReferenceNumber.getValue());
	        sb.append("]");
        }
        
        if(sequenceNumberOfCurrentSms!=null && sequenceNumberOfCurrentSms.getValue()!=null)
        {
	        sb.append("sequenceNumberOfCurrentSms=[");
	        sb.append(sequenceNumberOfCurrentSms.getValue());
	        sb.append("]");
        }
        
        sb.append("]");

        return sb.toString();
    }
}