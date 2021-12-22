package com.mobius.software.cdr.parser;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

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
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobius.software.telco.protocols.ss7.asn.ASNDecodeResult;
import com.mobius.software.telco.protocols.ss7.asn.ASNException;
import com.mobius.software.telco.protocols.ss7.asn.ASNParser;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
/**
 * @author yulian.oifa
 *
 */
public class RecordsTest 
{
	private static Logger logger=LogManager.getLogger(RecordsTest.class);
	private static List<File> samples;
	private static List<File> cssamples;
	private static List<File> imssamples;
	private static List<File> huaweisamples;
	private static ObjectMapper mapper = new ObjectMapper();
	
	@BeforeClass
	public static void setUp() throws Exception 
	{
		Configurator.initialize(new DefaultConfiguration());
	    Configurator.setRootLevel(Level.INFO);
	    mapper.setSerializationInclusion(Include.NON_NULL);
	    
	    File[] files = TestUtil.getFilesList("captures");
		samples = Arrays.asList(files);
		
		files = TestUtil.getFilesList("cscaptures");
		cssamples = Arrays.asList(files);
		
		files = TestUtil.getFilesList("imscaptures");
		imssamples = Arrays.asList(files);
		
		files = TestUtil.getFilesList("huawei");
		huaweisamples = Arrays.asList(files);
	}
	
	@Test
	public void testGPRSRecords() throws ASNException, IOException
	{
		ASNParser parser=new ASNParser();
		parser.loadClass(GPRSRecordsContainer.class);
		
		for (File file : samples)
		{
			logger.info("=======================================================================");
			logger.info("Reading file:" + file.getAbsolutePath());
			logger.info("=======================================================================");
			byte[] arr = Files.readAllBytes(file.toPath());
			ByteBuf in = Unpooled.copiedBuffer(arr);
			int count=0;
			while(in.readableBytes()>0)
			{
				ASNDecodeResult result=parser.decode(in);
				assertNotNull(result);
				assertFalse(result.getHadErrors());
				assertTrue(result.getResult() instanceof GPRSRecordsContainer);
				GPRSRecordsContainer currContainer=((GPRSRecordsContainer)result.getResult());
				if(currContainer.getGPRSRecords()!=null && currContainer.getGPRSRecords().size()>0)
				{
					for(GPRSRecord curr:currContainer.getGPRSRecords())
					{							
						logger.info("TEXT:" + curr.toString());
						logger.info("JSON:" + mapper.writeValueAsString(curr));
						count++;
					}
				}	
			}
			
			logger.info("Total records in file:" + count);
			logger.info("=======================================================================");
		}
	}

	@Test
	public void testCSRecords() throws ASNException, IOException
	{
		ASNParser parser=new ASNParser();
		parser.loadClass(CSRecordsContainer.class);
		for (File file : cssamples)
		{
			logger.info("=======================================================================");
			logger.info("Reading file:" + file.getAbsolutePath());
			logger.info("=======================================================================");
			byte[] arr = Files.readAllBytes(file.toPath());
			ByteBuf in = Unpooled.copiedBuffer(arr);
			int count=0;
			while(in.readableBytes()>0)
			{
				ASNDecodeResult result=parser.decode(in);
				assertNotNull(result);
				assertFalse(result.getHadErrors());
				assertTrue(result.getResult() instanceof CSRecordsContainer);
				CSRecordsContainer currContainer=((CSRecordsContainer)result.getResult());
				if(currContainer.getCSRecords()!=null && currContainer.getCSRecords().size()>0)
				{
					for(CSRecord curr:currContainer.getCSRecords())
					{							
						logger.info("TEXT:" + curr.toString());
						logger.info("JSON:" + mapper.writeValueAsString(curr));
						count++;
					}
				}	
			}
			
			logger.info("Total records in file:" + count);
			logger.info("=======================================================================");
		}
	}

	@Test
	public void testIMSRecords() throws ASNException, IOException
	{
		ASNParser parser=new ASNParser(true);
		parser.loadClass(IMSRecordsContainer.class);
		for (File file : imssamples)
		{
			logger.info("=======================================================================");
			logger.info("Reading file:" + file.getAbsolutePath());
			logger.info("=======================================================================");
			byte[] arr = Files.readAllBytes(file.toPath());
			ByteBuf in = Unpooled.copiedBuffer(arr);
			int count=0;
			while(in.readableBytes()>0)
			{
				ASNDecodeResult result=parser.decode(in);
				assertNotNull(result);
				//assertFalse(result.getHadErrors());
				assertTrue(result.getResult() instanceof IMSRecordsContainer);
				IMSRecordsContainer currContainer=((IMSRecordsContainer)result.getResult());
				if(currContainer.getIMSRecords()!=null && currContainer.getIMSRecords().size()>0)
				{
					for(IMSRecord curr:currContainer.getIMSRecords())
					{							
						logger.info("TEXT:" + curr.toString());
						logger.info("JSON:" + mapper.writeValueAsString(curr));
						count++;
					}
				}	
			}
			
			logger.info("Total records in file:" + count);
			logger.info("=======================================================================");
		}
	}

	@Test
	public void testHuaweiRecords() throws ASNException, IOException
	{
		ASNParser parser=new ASNParser(true);
		parser.loadClass(CallEventDataFile.class);
		for (File file : huaweisamples)
		{
			logger.info("=======================================================================");
			logger.info("Reading file:" + file.getAbsolutePath());
			logger.info("=======================================================================");
			byte[] arr = Files.readAllBytes(file.toPath());
			ByteBuf in = Unpooled.copiedBuffer(arr);
			int count=0;
			while(in.readableBytes()>0)
			{
				ASNDecodeResult result=parser.decode(in);
				assertNotNull(result);
				//assertFalse(result.getHadErrors());
				assertTrue(result.getResult() instanceof CallEventDataFile);
				CallEventDataFile currContainer=((CallEventDataFile)result.getResult());
				if(currContainer.getCSRecords()!=null && currContainer.getCSRecords().size()>0)
				{
					for(CSRecord curr:currContainer.getCSRecords())
					{							
						logger.info("TEXT:" + curr.toString());
						logger.info("JSON:" + mapper.writeValueAsString(curr));
						count++;
					}
				}	
			}
			
			logger.info("Total records in file:" + count);
			logger.info("=======================================================================");
		}
	}
}
