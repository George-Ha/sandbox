package cz.rc4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HashTest {
	
	@Test
	public void testMD5() {
		//http://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html
		Hash h = new Hash("MD5");
		String result = h.fingerprint("ahoj");
		assertEquals("79c2b46ce2594ecbcb5b73e928345492", result);
	}
	
	@Test
	public void testSHA1() {
		Hash h = new Hash("SHA-1");
		String result = h.fingerprint("ahoj");
		assertEquals("edb433bdd7c13851c7c68cb31a5acf33a80cd2cc", result);
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void nullAlg() {
		@SuppressWarnings("unused")
		Hash h = new Hash(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void invalidAlg() {
		@SuppressWarnings("unused")
		Hash h = new Hash("blabla");
	}
	
	@Test
	public void upperCase() {
		String test = "1test";
		assertEquals("1TEST", test.toUpperCase());
		
	}
	
	@Test
	public void bytesProduct() {
//		byte i = -3;
		int i = -33;
		int j = i & 0xff;//???
		System.out.println(j);
		assertEquals(253, j);
		
		byte k = -1;
		int l = k & 0xff;
		System.out.println(l);
		assertEquals(255,l);
	}

}
