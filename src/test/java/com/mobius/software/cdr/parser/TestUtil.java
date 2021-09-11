package com.mobius.software.cdr.parser;
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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * @author yulian.oifa
 *
 */
public class TestUtil
{
	public static String[] getResourcesList(String folder, boolean absolutePath) throws IOException
	{
		File currFile = new File(TestUtil.class.getClassLoader().getResource(folder).getPath());
		File[] allFiles = currFile.listFiles();
		String[] result = new String[allFiles.length];
		for (int i = 0; i < allFiles.length; i++)
		{
			if (absolutePath)
				result[i] = allFiles[i].getAbsolutePath();
			else
				result[i] = allFiles[i].getName();
		}

		return result;
	}

	public static File[] getFilesList(String folder) throws IOException
	{
		File currFile = new File(TestUtil.class.getClassLoader().getResource(folder).getPath());
		File[] allFiles = currFile.listFiles();

		return allFiles;
	}

	static String readFile(String path, String encoding) throws IOException
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	public static byte[] hexStringToByteArray(String file)
	{
		String s;
		byte[] data = null;
		try
		{
			s = readFile(file, "UTF-8");
			data = new byte[s.length() / 2];
			for (int i = 0; i < data.length; i++)
			{
				data[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2), 16);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return data;
	}
}