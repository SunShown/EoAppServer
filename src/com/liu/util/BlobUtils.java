package com.liu.util;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

public class BlobUtils {
public String BlobtoString(Blob bb){
	byte[] b;
	String result=null;
	try {
		b = bb.getBytes(0, (int)bb.length());
		try {
			 result = new String(b,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;

}


}
