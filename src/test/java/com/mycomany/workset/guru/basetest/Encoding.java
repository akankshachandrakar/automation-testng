package com.mycomany.workset.guru.basetest;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

class Encoding {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		String ToBeEncoded= "dapYham";
		String encoded =Base64.getEncoder().encodeToString(ToBeEncoded.getBytes());
		System.out.println(encoded);
		byte[] decoded = Base64.getDecoder().decode(encoded);
		String str =new String(decoded, "UTF-8");
		System.out.println(str);
		
	}

}
