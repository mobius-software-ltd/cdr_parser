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
/*
 RecordType ::= INTEGER
{--
-- Record values 0..17 and 87 are CS specific.
-- The contents are defined in TS 32.250 [10]
moCallRecord (0),
mtCallRecord (1),
roamingRecord (2),
incGatewayRecord (3),
outGatewayRecord (4),
transitCallRecord (5),
moSMSRecord (6),
mtSMSRecord (7),
moSMSIWRecord (8),
mtSMSGWRecord (9),
ssActionRecord (10),
hlrIntRecord (11),
locUpdateHLRRecord (12),
locUpdateVLRRecord (13),
commonEquipRecord (14),
moTraceRecord (15), --- used in earlier releases
mtTraceRecord (16), --- used in earlier releases
termCAMELRecord (17),
--
-- Record values 18..22 are GPRS specific.
-- The contents are defined in TS 32.251 [11]
--
sgsnPDPRecord (18),
sgsnMMRecord (20),
sgsnSMORecord (21),
sgsnSMTRecord (22),
--
-- Record values 23..25 are CS-LCS specific.
-- The contents are defined in TS 32.250 [10]
--
mtLCSRecord (23),
moLCSRecord (24),
niLCSRecord (25),
--
-- Record values 26..28 are GPRS-LCS specific.
-- The contents are defined in TS 32.251 [11]
--
sgsnMTLCSRecord (26),
sgsnMOLCSRecord (27),
sgsnNILCSRecord (28),
--
-- Record values 30..62 are MMS specific.
-- The contents are defined in TS 32.270 [30]
--
mMO1SRecord (30),
mMO4FRqRecord (31),
mMO4FRsRecord (32),
mMO4DRecord (33),
mMO1DRecord (34),
mMO4RRecord (35),
mMO1RRecord (36),
mMOMDRecord (37),
mMR4FRecord (38),
mMR1NRqRecord (39),
mMR1NRsRecord (40),
mMR1RtRecord (41),
mMR1AFRecord (42),
mMR4DRqRecord (43),
mMR4DRsRecord (44),
mMR1RRRecord (45),
mMR4RRqRecord (46),
mMR4RRsRecord (47),
mMRMDRecord (48),
mMFRecord (49),
mMBx1SRecord (50),
mMBx1VRecord (51),
mMBx1URecord (52),
mMBx1DRecord (53),
mM7SRecord (54),
mM7DRqRecord (55),
mM7DRsRecord (56),
mM7CRecord (57),
mM7RRecord (58),
mM7DRRqRecord (59),
mM7DRRsRecord (60),
mM7RRqRecord (61),
mM7RRsRecord (62),
--
-- Record values 63..69, 70, 82 are IMS specific.
-- The contents are defined in TS 32.260 [20]
--
sCSCFRecord (63),
pCSCFRecord (64),
iCSCFRecord (65),
mRFCRecord (66),
mGCFRecord (67),
bGCFRecord (68),
aSRecord (69),
eCSCFRecord (70),
iBCFRecord (82),
--
-- Record values 71..75 are LCS specific.
-- The contents are defined in TS 32.271 [31]
--
lCSGMORecord (71),
lCSRGMTRecord (72),
lCSHGMTRecord (73),
lCSVGMTRecord (74),
lCSGNIRecord (75),
--
-- Record values 76..79,86 are MBMS specific.
-- The contents are defined in TS 32.251 [11]
-- Record values 76,77 and 86 are MBMS bearer context specific
--
sgsnMBMSRecord (76),
ggsnMBMSRecord (77),
gwMBMSRecord (86),
--
-- And TS 32.273 [33]
-- Record values 78 and 79 are MBMS service specific
-- and defined in TS 32.273 [33]
--
sUBBMSCRecord (78),
cONTENTBMSCRecord (79),
--
-- Record Values 80..81 are PoC specific.
-- The contents are defined in TS 32.272 [32]
--
pPFRecord (80),
cPFRecord (81),
-- Record values 84..85 are EPC specific.
-- The contents are defined in TS 32.251 [11]
--
sGWRecord (84),
pGWRecord (85),
--
-- Record Value 83 is MMTel specific.
-- The contents are defined in TS 32.275 [35]
--
mMTelRecord (83),
-- Record value 87 is CS specific.
-- The contents are defined in TS 32.250 [10]
--
mSCsRVCCRecord (87)
}
 */
/**
 * @author yulian.oifa
 *
 */
public enum RecordType 
{
	moCallRecord (0),
	mtCallRecord (1),
	roamingRecord (2),
	incGatewayRecord (3),
	outGatewayRecord (4),
	transitCallRecord (5),
	moSMSRecord (6),
	mtSMSRecord (7),
	moSMSIWRecord (8),
	mtSMSGWRecord (9),
	ssActionRecord (10),
	hlrIntRecord (11),
	locUpdateHLRRecord (12),
	locUpdateVLRRecord (13),
	commonEquipRecord (14),
	moTraceRecord (15),
	mtTraceRecord (16),
	termCAMELRecord (17),
	sgsnPDPRecord (18),
	sgsnMMRecord (20),
	sgsnSMORecord (21),
	sgsnSMTRecord (22),
	mtLCSRecord (23),
	moLCSRecord (24),
	niLCSRecord (25),
	sgsnMTLCSRecord (26),
	sgsnMOLCSRecord (27),
	sgsnNILCSRecord (28),
	mMO1SRecord (30),
	mMO4FRqRecord (31),
	mMO4FRsRecord (32),
	mMO4DRecord (33),
	mMO1DRecord (34),
	mMO4RRecord (35),
	mMO1RRecord (36),
	mMOMDRecord (37),
	mMR4FRecord (38),
	mMR1NRqRecord (39),
	mMR1NRsRecord (40),
	mMR1RtRecord (41),
	mMR1AFRecord (42),
	mMR4DRqRecord (43),
	mMR4DRsRecord (44),
	mMR1RRRecord (45),
	mMR4RRqRecord (46),
	mMR4RRsRecord (47),
	mMRMDRecord (48),
	mMFRecord (49),
	mMBx1SRecord (50),
	mMBx1VRecord (51),
	mMBx1URecord (52),
	mMBx1DRecord (53),
	mM7SRecord (54),
	mM7DRqRecord (55),
	mM7DRsRecord (56),
	mM7CRecord (57),
	mM7RRecord (58),
	mM7DRRqRecord (59),
	mM7DRRsRecord (60),
	mM7RRqRecord (61),
	mM7RRsRecord (62),
	sCSCFRecord (63),
	pCSCFRecord (64),
	iCSCFRecord (65),
	mRFCRecord (66),
	mGCFRecord (67),
	bGCFRecord (68),
	aSRecord (69),
	eCSCFRecord (70),
	lCSGMORecord (71),
	lCSRGMTRecord (72),
	lCSHGMTRecord (73),
	lCSVGMTRecord (74),
	lCSGNIRecord (75),
	sgsnMBMSRecord (76),
	ggsnMBMSRecord (77),
	sUBBMSCRecord (78),
	cONTENTBMSCRecord (79),
	pPFRecord (80),
	cPFRecord (81),
	iBCFRecord (82),
	mMTelRecord (83),
	sGWRecord (84),
	pGWRecord (85),
	gwMBMSRecord (86),
	mSCsRVCCRecord (87);
	
	private int code;

	private RecordType(int code) 
	{
		this.code = code;
	}

	public int getCode() 
	{
		return this.code;
	}

	public static RecordType getRecordType(int code) 
	{
		switch (code) 
		{
			case 0:
				return moCallRecord;
			case 1:
				return mtCallRecord;
			case 2:
				return roamingRecord;
			case 3:
				return incGatewayRecord;
			case 4:
				return outGatewayRecord;
			case 5:
				return transitCallRecord;
			case 6:
				return moSMSRecord;
			case 7:
				return moSMSRecord;
			case 8:
				return moSMSIWRecord;
			case 9:
				return mtSMSGWRecord;
			case 10:
				return ssActionRecord;
			case 11:
				return hlrIntRecord;
			case 12:
				return locUpdateHLRRecord;
			case 13:
				return locUpdateVLRRecord;
			case 14:
				return commonEquipRecord;
			case 15:
				return moTraceRecord;
			case 16:
				return mtTraceRecord;
			case 17:
				return termCAMELRecord;
			case 18:
				return sgsnPDPRecord;
			case 20:
				return sgsnMMRecord;		
			case 21:
				return sgsnSMORecord;
			case 22:
				return sgsnSMTRecord;
			case 23:
				return mtLCSRecord;
			case 24:
				return moLCSRecord;
			case 25:
				return niLCSRecord;
			case 26:
				return sgsnMTLCSRecord;
			case 27:
				return sgsnMOLCSRecord;
			case 28:
				return sgsnNILCSRecord;
			case 30:
				return mMO1SRecord;
			case 31:
				return mMO4FRqRecord;		
			case 32:
				return mMO4FRsRecord;
			case 33:
				return mMO4DRecord;
			case 34:
				return mMO1DRecord;
			case 35:
				return mMO4RRecord;
			case 36:
				return mMO1RRecord;
			case 37:
				return mMOMDRecord;
			case 38:
				return mMR4FRecord;
			case 39:
				return mMR1NRqRecord;
			case 40:
				return mMR1NRsRecord;
			case 41:
				return mMR1RtRecord;		
			case 42:
				return mMR1AFRecord;
			case 43:
				return mMR4DRqRecord;
			case 44:
				return mMR4DRsRecord;
			case 45:
				return mMR1RRRecord;
			case 46:
				return mMR4RRqRecord;
			case 47:
				return mMR4RRsRecord;
			case 48:
				return mMRMDRecord;
			case 49:
				return mMFRecord;
			case 50:
				return mMBx1SRecord;
			case 51:
				return mMBx1VRecord;		
			case 52:
				return mMBx1URecord;
			case 53:
				return mMBx1DRecord;
			case 54:
				return mM7SRecord;
			case 55:
				return mM7DRqRecord;
			case 56:
				return mM7DRsRecord;
			case 57:
				return mM7CRecord;
			case 58:
				return mM7RRecord;
			case 59:
				return mM7DRRqRecord;
			case 60:
				return mM7DRRsRecord;
			case 61:
				return mM7RRqRecord;		
			case 62:
				return mM7RRsRecord;
			case 63:
				return sCSCFRecord;
			case 64:
				return pCSCFRecord;
			case 65:
				return iCSCFRecord;
			case 66:
				return mRFCRecord;
			case 67:
				return mGCFRecord;
			case 68:
				return bGCFRecord;
			case 69:
				return aSRecord;
			case 70:
				return eCSCFRecord;
			case 71:
				return lCSGMORecord;		
			case 72:
				return lCSRGMTRecord;
			case 73:
				return lCSHGMTRecord;
			case 74:
				return lCSVGMTRecord;
			case 75:
				return lCSGNIRecord;
			case 76:
				return sgsnMBMSRecord;
			case 77:
				return ggsnMBMSRecord;
			case 78:
				return sUBBMSCRecord;
			case 79:
				return cONTENTBMSCRecord;
			case 80:
				return pPFRecord;
			case 81:
				return cPFRecord;		
			case 82:
				return iBCFRecord;
			case 83:
				return mMTelRecord;
			case 84:
				return sGWRecord;
			case 85:
				return pGWRecord;
			case 86:
				return gwMBMSRecord;
			case 87:
				return mSCsRVCCRecord;
			default:
				return null;
		}
	}
}