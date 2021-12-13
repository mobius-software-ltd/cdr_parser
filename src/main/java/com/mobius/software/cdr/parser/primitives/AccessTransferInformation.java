package com.mobius.software.cdr.parser.primitives;

import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNProperty;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNNull;
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNOctetString;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/*
AccessTransferInformation ::= SEQUENCE
{
 accessTransferType [0] AccessTransferType OPTIONAL,
 accessNetworkInformation [1] OCTET STRING OPTIONAL,
 additionalAccessNetworkInformation [2] OCTET STRING OPTIONAL,
 inter-UE-Transfer [3] NULL OPTIONAL,
 relatedICID [4] IMS-Charging-Identifier OPTIONAL,
 relatedICIDGenerationNode [5] NodeAddress OPTIONAL,
 accessTransferTime [6] TimeStamp OPTIONAL,
 subscriberEquipmentNumber [7] SubscriberEquipmentNumber OPTIONAL,
 instanceId [8] OCTET STRING OPTIONAL,
 cellularNetworkInformation [9] OCTET STRING OPTIONAL
} 
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class AccessTransferInformation 
{
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 0,constructed = false,index = -1)
	private ASNAccessTransferType accessTransferType;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 1,constructed = false,index = -1)
	private ASNOctetString accessNetworkInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 2,constructed = false,index = -1)
	private ASNOctetString additionalAccessNetworkInformation;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 3,constructed = false,index = -1)
	private ASNNull interUETransfer;
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 4,constructed = false,index = -1)
	private ASNOctetString relatedICID;		
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 5,constructed = false,index = -1)
	private NodeAddressWrapper relatedICIDGenerationNode;		
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 6,constructed = false,index = -1)
	private TimeStamp accessTransferTime;		
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 7,constructed = true,index = -1)
	private SubscriberEquipmentNumber subscriberEquipmentNumber;		
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private ASNOctetString instanceID;		
	
	@ASNProperty(asnClass = ASNClass.CONTEXT_SPECIFIC,tag = 8,constructed = false,index = -1)
	private ASNOctetString cellularNetworkInformation;		
	
	public AccessTransferInformation(AccessTransferType accessTransferType,byte[] accessNetworkInformation,byte[] additionalAccessNetworkInformation,boolean interUETransfer,byte[] relatedICID,NodeAddress relatedICIDGenerationNode,TimeStamp accessTransferTime,SubscriberEquipmentNumber subscriberEquipmentNumber,byte[] instanceID,byte[] cellularNetworkInformation)
	{
		if(accessTransferType!=null)
		{
			this.accessTransferType=new ASNAccessTransferType();
			this.accessTransferType.setType(accessTransferType);
		}
		
		if(accessNetworkInformation!=null) 
		{
			this.accessNetworkInformation=new ASNOctetString();
			this.accessNetworkInformation.setValue(Unpooled.wrappedBuffer(accessNetworkInformation));
		}
		
		if(additionalAccessNetworkInformation!=null) 
		{
			this.additionalAccessNetworkInformation=new ASNOctetString();
			this.additionalAccessNetworkInformation.setValue(Unpooled.wrappedBuffer(additionalAccessNetworkInformation));
		}
		
		if(interUETransfer)
			this.interUETransfer=new ASNNull();
		
		if(relatedICID!=null) 
		{
			this.relatedICID=new ASNOctetString();
			this.relatedICID.setValue(Unpooled.wrappedBuffer(relatedICID));
		}
		
		if(relatedICIDGenerationNode!=null) 
			this.relatedICIDGenerationNode=new NodeAddressWrapper(relatedICIDGenerationNode);			
		
		this.accessTransferTime=accessTransferTime;
		this.subscriberEquipmentNumber=subscriberEquipmentNumber;
		
		if(instanceID!=null) 
		{
			this.instanceID=new ASNOctetString();
			this.instanceID.setValue(Unpooled.wrappedBuffer(instanceID));
		}
		
		if(cellularNetworkInformation!=null) 
		{
			this.cellularNetworkInformation=new ASNOctetString();
			this.cellularNetworkInformation.setValue(Unpooled.wrappedBuffer(cellularNetworkInformation));
		}
	}

	public AccessTransferType getAccessTransferType() 
	{
		if(accessTransferType==null)
			return null;
		
		return accessTransferType.getType();
	}

	public byte[] getAccessNetworkInformation() 
	{
		if(accessNetworkInformation==null)
			return null;
		
		ByteBuf value=accessNetworkInformation.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}
	
	public byte[] getAdditionalAccessNetworkInformation() 
	{
		if(additionalAccessNetworkInformation==null)
			return null;
		
		ByteBuf value=additionalAccessNetworkInformation.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}

	public boolean getInterUETransfer() 
	{
		return interUETransfer!=null;
	}
	
	public byte[] getRelatedICID() 
	{
		if(relatedICID==null)
			return null;
		
		ByteBuf value=relatedICID.getValue();
		if(value==null)
			return null;
		
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
	
	public TimeStamp getAccessTransferTime() 
	{
		return accessTransferTime;
	}
	
	public SubscriberEquipmentNumber getSubscriberEquipmentNumber() 
	{
		return subscriberEquipmentNumber;
	}
	
	public byte[] getInstanceID() 
	{
		if(instanceID==null)
			return null;
		
		ByteBuf value=instanceID.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}
	
	public byte[] getCellularNetworkInformation() 
	{
		if(cellularNetworkInformation==null)
			return null;
		
		ByteBuf value=cellularNetworkInformation.getValue();
		if(value==null)
			return null;
		
		byte[] data=new byte[value.readableBytes()];
		value.readBytes(data);
		return data;
	}
	
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AccessTransferInformation");
        sb.append(" [");

        if(accessTransferType!=null && accessTransferType.getType()!=null)
        {
	        sb.append("accessTransferType=[");
	        sb.append(accessTransferType.getType());
	        sb.append("]");
        }
        
        if(accessNetworkInformation!=null && accessNetworkInformation.getValue()!=null)
        {
	        sb.append("accessNetworkInformation=[");
	        sb.append(ASNOctetString.printDataArr(getAccessNetworkInformation()));
	        sb.append("]");
        }
        
        if(additionalAccessNetworkInformation!=null && additionalAccessNetworkInformation.getValue()!=null)
        {
	        sb.append("additionalAccessNetworkInformation=[");
	        sb.append(ASNOctetString.printDataArr(getAdditionalAccessNetworkInformation()));
	        sb.append("]");
        }
        
        if(interUETransfer!=null)
            sb.append("interUETransfer ");
        
        if(relatedICID!=null && relatedICID.getValue()!=null)
        {
	        sb.append("relatedICID=[");
	        sb.append(ASNOctetString.printDataArr(getRelatedICID()));
	        sb.append("]");
        }
        
        if(relatedICIDGenerationNode!=null && relatedICIDGenerationNode.getNodeAddress()!=null)
        {
	        sb.append("relatedICIDGenerationNode=[");
	        sb.append(relatedICIDGenerationNode.getNodeAddress());
	        sb.append("]");
        }
        
        if(accessTransferTime!=null)
        {
	        sb.append("accessTransferTime=[");
	        sb.append(accessTransferTime);
	        sb.append("]");
        }
        
        if(subscriberEquipmentNumber!=null)
        {
	        sb.append("subscriberEquipmentNumber=[");
	        sb.append(subscriberEquipmentNumber);
	        sb.append("]");
        }
        
        if(instanceID!=null && instanceID.getValue()!=null)
        {
	        sb.append("instanceID=[");
	        sb.append(ASNOctetString.printDataArr(getInstanceID()));
	        sb.append("]");
        }
        
        if(cellularNetworkInformation!=null && cellularNetworkInformation.getValue()!=null)
        {
	        sb.append("cellularNetworkInformation=[");
	        sb.append(ASNOctetString.printDataArr(getCellularNetworkInformation()));
	        sb.append("]");
        }
        
        
        sb.append("]");

        return sb.toString();
    }
}