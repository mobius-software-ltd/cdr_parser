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
import com.mobius.software.telco.protocols.ss7.asn.primitives.ASNEnumerated;
/**
 * @author yulian.oifa
 *
 */
public class ASNAccountingRecordType extends ASNEnumerated 
{
	public void setType(AccountingRecordType t) 
	{
		super.setValue(Long.valueOf(t.getType()));
	}
	
	public AccountingRecordType getType() 
	{
		Long realValue=super.getValue();
		if(realValue==null)
			return null;
		
		return AccountingRecordType.getType(getValue().intValue());
	}
}