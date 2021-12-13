package com.mobius.software.cdr.parser;
import com.mobius.software.cdr.parser.ims.ASRecord;
import com.mobius.software.cdr.parser.ims.ATCFRecord;
import com.mobius.software.cdr.parser.ims.BGCFRecord;
import com.mobius.software.cdr.parser.ims.ECSCFRecord;
import com.mobius.software.cdr.parser.ims.IBCFRecord;
import com.mobius.software.cdr.parser.ims.ICSCFRecord;
import com.mobius.software.cdr.parser.ims.MGCFRecord;
import com.mobius.software.cdr.parser.ims.MRFCRecord;
import com.mobius.software.cdr.parser.ims.PCSCFRecord;
import com.mobius.software.cdr.parser.ims.SCSCFRecord;
import com.mobius.software.cdr.parser.ims.TFRRecord;
import com.mobius.software.cdr.parser.ims.TRFRecord;
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
public class IMSRecord 
{
	private ASRecord asRecord;
	private ATCFRecord atcfRecord;
	private BGCFRecord bgcfRecord;
	private ECSCFRecord ecscfRecord;
	private IBCFRecord ibcfRecord;
	private ICSCFRecord icscfRecord;
	private MGCFRecord mgcfRecord;
	private MRFCRecord mrfcRecord;
	private PCSCFRecord pcscfRecord;
	private SCSCFRecord scscfRecord;
	private TFRRecord tfrRecord;
	private TRFRecord trfRecord; 
	
	public IMSRecord()
	{
		
	}
	
	public ASRecord getAsRecord() 
	{
		return asRecord;
	}

	public ATCFRecord getAtcfRecord() 
	{
		return atcfRecord;
	}

	public BGCFRecord getBgcfRecord() 
	{
		return bgcfRecord;
	}

	public ECSCFRecord getEcscfRecord() 
	{
		return ecscfRecord;
	}

	public IBCFRecord getIbcfRecord() 
	{
		return ibcfRecord;
	}

	public ICSCFRecord getIcscfRecord() 
	{
		return icscfRecord;
	}

	public MGCFRecord getMgcfRecord() 
	{
		return mgcfRecord;
	}

	public MRFCRecord getMrfcRecord() 
	{
		return mrfcRecord;
	}

	public PCSCFRecord getPcscfRecord() 
	{
		return pcscfRecord;
	}

	public SCSCFRecord getScscfRecord() 
	{
		return scscfRecord;
	}

	public TFRRecord getTfrRecord() 
	{
		return tfrRecord;
	}

	public TRFRecord getTrfRecord() 
	{
		return trfRecord;
	}

	@Override
    public String toString() 
	{
        StringBuilder sb = new StringBuilder();

        sb.append("IMSRecord [");

        if(this.asRecord!=null)
        {
        	sb.append("asRecord=[");
            sb.append(this.asRecord);
            sb.append("]");
        }

        if(this.atcfRecord!=null)
        {
        	sb.append("atcfRecord=[");
            sb.append(this.atcfRecord);
            sb.append("]");
        }
        
        if(this.bgcfRecord!=null)
        {
        	sb.append("bgcfRecord=[");
            sb.append(this.bgcfRecord);
            sb.append("]");
        }
        
        if(this.ecscfRecord!=null)
        {
        	sb.append("ecscfRecord=[");
            sb.append(this.ecscfRecord);
            sb.append("]");
        }
        
        if(this.ibcfRecord!=null)
        {
        	sb.append("ibcfRecord=[");
            sb.append(this.ibcfRecord);
            sb.append("]");
        }
        
        if(this.icscfRecord!=null)
        {
        	sb.append("icscfRecord=[");
            sb.append(this.icscfRecord);
            sb.append("]");
        }
        
        if(this.mgcfRecord!=null)
        {
        	sb.append("mgcfRecord=[");
            sb.append(this.mgcfRecord);
            sb.append("]");
        }
        
        if(this.mrfcRecord!=null)
        {
        	sb.append("mrfcRecord=[");
            sb.append(this.mrfcRecord);
            sb.append("]");
        }
        
        if(this.pcscfRecord!=null)
        {
        	sb.append("pcscfRecord=[");
            sb.append(this.pcscfRecord);
            sb.append("]");
        }
        
        if(this.scscfRecord!=null)
        {
        	sb.append("scscfRecord=[");
            sb.append(this.scscfRecord);
            sb.append("]");
        }
        
        if(this.tfrRecord!=null)
        {
        	sb.append("tfrRecord=[");
            sb.append(this.tfrRecord);
            sb.append("]");
        }
        
        if(this.trfRecord!=null)
        {
        	sb.append("trfRecord=[");
            sb.append(this.trfRecord);
            sb.append("]");
        }  
        
        sb.append("]");

        return sb.toString();
    }
}