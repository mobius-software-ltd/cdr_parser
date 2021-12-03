package com.mobius.software.cdr.parser;
import com.mobius.software.cdr.parser.cs.CommonEquipRecord;
import com.mobius.software.cdr.parser.cs.HLRIntRecord;
import com.mobius.software.cdr.parser.cs.ICSRegisterRecord;
import com.mobius.software.cdr.parser.cs.IncGatewayRecord;
import com.mobius.software.cdr.parser.cs.LocUpdateHLRRecord;
import com.mobius.software.cdr.parser.cs.LocUpdateVLRRecord;
import com.mobius.software.cdr.parser.cs.MMTRFRecord;
import com.mobius.software.cdr.parser.cs.MOCallRecord;
import com.mobius.software.cdr.parser.cs.MOLCSRecord;
import com.mobius.software.cdr.parser.cs.MOSMSIWRecord;
import com.mobius.software.cdr.parser.cs.MOSMSRecord;
import com.mobius.software.cdr.parser.cs.MSCSRVCCRecord;
import com.mobius.software.cdr.parser.cs.MTCallRecord;
import com.mobius.software.cdr.parser.cs.MTLCSRecord;
import com.mobius.software.cdr.parser.cs.MTSMSIWRecord;
import com.mobius.software.cdr.parser.cs.MTSMSRecord;
import com.mobius.software.cdr.parser.cs.NILCSRecord;
import com.mobius.software.cdr.parser.cs.OutGatewayRecord;
import com.mobius.software.cdr.parser.cs.RecTypeExtensions;
import com.mobius.software.cdr.parser.cs.RoamingRecord;
import com.mobius.software.cdr.parser.cs.SSActionRecord;
import com.mobius.software.cdr.parser.cs.TransitRecord;
import com.mobius.software.telco.protocols.ss7.asn.ASNClass;
import com.mobius.software.telco.protocols.ss7.asn.annotations.ASNTag;

/*
CSRecord ::= CHOICE
--
-- Record values 0..21 are circuit switch specific
--
{
 moCallRecord [0] MOCallRecord,
 mtCallRecord [1] MTCallRecord,
 roamingRecord [2] RoamingRecord,
 incGatewayRecord [3] IncGatewayRecord,
 outGatewayRecord [4] OutGatewayRecord,
 transitRecord [5] TransitCallRecord,
 moSMSRecord [6] MOSMSRecord,
 mtSMSRecord [7] MTSMSRecord,
 moSMSIWRecord [8] MOSMSIWRecord,
 mtSMSGWRecord [9] MTSMSGWRecord,
 ssActionRecord [10] SSActionRecord,
 hlrIntRecord [11] HLRIntRecord,
 locUpdateHLRRecord [12] LocUpdateHLRRecord,
 locUpdateVLRRecord [13] LocUpdateVLRRecord,
 commonEquipRecord [14] CommonEquipRecord,
 recTypeExtensions [15] ManagementExtensions,
 termCAMELRecord [16] TermCAMELRecord,
 mtLCSRecord [17] MTLCSRecord,
 moLCSRecord [18] MOLCSRecord,
 niLCSRecord [19] NILCSRecord,
 mSCsRVCCRecord [20] MSCsRVCCRecord,
 mMTRFRecord [21] MTRFRecord,
 iCSRegisterRecord [22] ICSregisterRecord
}
 */
/**
 * @author yulian.oifa
 *
 */
@ASNTag(asnClass = ASNClass.UNIVERSAL,tag = 16,constructed = true,lengthIndefinite = false)
public class CSRecord 
{
	private MOCallRecord moCallRecord;
	private MTCallRecord mtCallRecord;
	private RoamingRecord roamingRecord;
	private IncGatewayRecord incGatewayRecord;
	private OutGatewayRecord outGatewayRecord;
	private TransitRecord transitRecord;
	private MOSMSRecord moSmsRecord;
	private MTSMSRecord mtSmsRecord;
	private MOSMSIWRecord moSmsIwRecord;
	private MTSMSIWRecord mtSmsIwRecord;
	private SSActionRecord ssActionRecord;
	private HLRIntRecord hlrIntRecord; 
	private LocUpdateHLRRecord locUpdateHLRRecord;
	private LocUpdateVLRRecord locUpdateVLRRecord;
	private CommonEquipRecord commonEquipRecord;
	private RecTypeExtensions recTypeExtensions;
	private MTLCSRecord mtLcsRecord;
	private MOLCSRecord moLcsRecord;
	private NILCSRecord niLcsRecord;
	private MSCSRVCCRecord mscSrvccRecord;
	private MMTRFRecord mMtrfRecord;
	private ICSRegisterRecord icsRegisterRecord;
	
	public CSRecord()
	{
		
	}
	
	public MOCallRecord getMoCallRecord() 
	{
		return moCallRecord;
	}

	public MTCallRecord getMtCallRecord() 
	{
		return mtCallRecord;
	}

	public RoamingRecord getRoamingRecord() 
	{
		return roamingRecord;
	}

	public IncGatewayRecord getIncGatewayRecord() 
	{
		return incGatewayRecord;
	}

	public OutGatewayRecord getOutGatewayRecord() 
	{
		return outGatewayRecord;
	}

	public TransitRecord getTransitRecord() 
	{
		return transitRecord;
	}

	public MOSMSRecord getMoSmsRecord() 
	{
		return moSmsRecord;
	}

	public MTSMSRecord getMtSmsRecord() 
	{
		return mtSmsRecord;
	}

	public MOSMSIWRecord getMoSmsIwRecord() 
	{
		return moSmsIwRecord;
	}

	public MTSMSIWRecord getMtSmsIwRecord() 
	{
		return mtSmsIwRecord;
	}

	public SSActionRecord getSsActionRecord() 
	{
		return ssActionRecord;
	}

	public HLRIntRecord getHlrIntRecord() 
	{
		return hlrIntRecord;
	}

	public LocUpdateHLRRecord getLocUpdateHLRRecord() 
	{
		return locUpdateHLRRecord;
	}

	public LocUpdateVLRRecord getLocUpdateVLRRecord() 
	{
		return locUpdateVLRRecord;
	}

	public CommonEquipRecord getCommonEquipRecord() 
	{
		return commonEquipRecord;
	}

	public RecTypeExtensions getRecTypeExtensions() 
	{
		return recTypeExtensions;
	}

	public MTLCSRecord getMtLcsRecord() 
	{
		return mtLcsRecord;
	}

	public MOLCSRecord getMoLcsRecord() 
	{
		return moLcsRecord;
	}

	public NILCSRecord getNiLcsRecord() 
	{
		return niLcsRecord;
	}

	public MSCSRVCCRecord getMscSrvccRecord() 
	{
		return mscSrvccRecord;
	}

	public MMTRFRecord getmMtrfRecord() 
	{
		return mMtrfRecord;
	}

	public ICSRegisterRecord getIcsRegisterRecord() 
	{
		return icsRegisterRecord;
	}

	@Override
    public String toString() 
	{
        StringBuilder sb = new StringBuilder();

        sb.append("CSRecord [");

        if(this.moCallRecord!=null)
        {
        	sb.append("moCallRecord=[");
            sb.append(this.moCallRecord);
            sb.append("]");
        }

        if(this.mtCallRecord!=null)
        {
        	sb.append("mtCallRecord=[");
            sb.append(this.mtCallRecord);
            sb.append("]");
        }
        
        if(this.roamingRecord!=null)
        {
        	sb.append("roamingRecord=[");
            sb.append(this.roamingRecord);
            sb.append("]");
        }
        
        if(this.incGatewayRecord!=null)
        {
        	sb.append("incGatewayRecord=[");
            sb.append(this.incGatewayRecord);
            sb.append("]");
        }
        
        if(this.outGatewayRecord!=null)
        {
        	sb.append("outGatewayRecord=[");
            sb.append(this.outGatewayRecord);
            sb.append("]");
        }
        
        if(this.transitRecord!=null)
        {
        	sb.append("transitRecord=[");
            sb.append(this.transitRecord);
            sb.append("]");
        }
        
        if(this.moSmsRecord!=null)
        {
        	sb.append("moSmsRecord=[");
            sb.append(this.moSmsRecord);
            sb.append("]");
        }
        
        if(this.mtSmsRecord!=null)
        {
        	sb.append("mtSmsRecord=[");
            sb.append(this.mtSmsRecord);
            sb.append("]");
        }
        
        if(this.moSmsIwRecord!=null)
        {
        	sb.append("moSmsIwRecord=[");
            sb.append(this.moSmsIwRecord);
            sb.append("]");
        }
        
        if(this.mtSmsIwRecord!=null)
        {
        	sb.append("mtSmsIwRecord=[");
            sb.append(this.mtSmsIwRecord);
            sb.append("]");
        }
        
        if(this.ssActionRecord!=null)
        {
        	sb.append("ssActionRecord=[");
            sb.append(this.ssActionRecord);
            sb.append("]");
        }
        
        if(this.hlrIntRecord!=null)
        {
        	sb.append("hlrIntRecord=[");
            sb.append(this.hlrIntRecord);
            sb.append("]");
        }        
        
        if(this.locUpdateHLRRecord!=null)
        {
        	sb.append("locUpdateHLRRecord=[");
            sb.append(this.locUpdateHLRRecord);
            sb.append("]");
        }
        
        if(this.locUpdateVLRRecord!=null)
        {
        	sb.append("locUpdateVLRRecord=[");
            sb.append(this.locUpdateVLRRecord);
            sb.append("]");
        }
        
        if(this.commonEquipRecord!=null)
        {
        	sb.append("commonEquipRecord=[");
            sb.append(this.commonEquipRecord);
            sb.append("]");
        }
        
        if(this.recTypeExtensions!=null)
        {
        	sb.append("recTypeExtensions=[");
            sb.append(this.recTypeExtensions);
            sb.append("]");
        }
        
        if(this.mtLcsRecord!=null)
        {
        	sb.append("mtLcsRecord=[");
            sb.append(this.mtLcsRecord);
            sb.append("]");
        }
        
        if(this.moLcsRecord!=null)
        {
        	sb.append("moLcsRecord=[");
            sb.append(this.moLcsRecord);
            sb.append("]");
        }
        
        if(this.niLcsRecord!=null)
        {
        	sb.append("niLcsRecord=[");
            sb.append(this.niLcsRecord);
            sb.append("]");
        }
        
        if(this.mscSrvccRecord!=null)
        {
        	sb.append("mscSrvccRecord=[");
            sb.append(this.mscSrvccRecord);
            sb.append("]");
        }
        
        if(this.mMtrfRecord!=null)
        {
        	sb.append("mMtrfRecord=[");
            sb.append(this.mMtrfRecord);
            sb.append("]");
        }
        
        if(this.icsRegisterRecord!=null)
        {
        	sb.append("icsRegisterRecord=[");
            sb.append(this.icsRegisterRecord);
            sb.append("]");
        } 
        
        sb.append("]");

        return sb.toString();
    }
}