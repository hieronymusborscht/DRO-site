package jto.util;

import java.util.Random;

public class RandomThing {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.out.println(getString(8));
	//}
	
	
	 public static String getString(int length) {
		  Random random = new Random();
	      String temp_s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0987654321!@#$%^&*()";
	      char[] symbols = temp_s.toCharArray();
		  StringBuilder sb = new StringBuilder();
		  for(int i=0; i<length; i++){
			  sb.append(symbols[random.nextInt(symbols.length)]);
		  }
		  return sb.toString();
	 }
	
	
	

}
