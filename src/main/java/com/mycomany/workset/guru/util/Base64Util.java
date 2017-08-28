package com.mycomany.workset.guru.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Util {
	
	public static String decode(String password)
			throws UnsupportedEncodingException {
		byte[] decoded = Base64.getDecoder().decode(password);
		return new String(decoded, "UTF-8");
	}
}
