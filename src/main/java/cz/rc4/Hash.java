package cz.rc4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Hash {

	MessageDigest instance = null;

	public Hash(String algorithm) {
		if (algorithm == null) {
			throw new IllegalArgumentException("Chosen algorithm cannot be empty.");
		}
		Security.addProvider(new BouncyCastleProvider());
		try {
			//http://docs.oracle.com/javase/6/docs/technotes/guides/security/StandardNames.html
			instance = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("Algorithm not found.");
		}
	}

	public String fingerprint(String string) {
		byte[] doFinal = instance.digest(string.getBytes());
		StringBuilder sb = new StringBuilder();
	    for (byte b : doFinal) {
	        sb.append(String.format("%02X ", b));
	    }
		return sb.toString().replaceAll(" ", "").trim().toLowerCase();
	}
	
		public String toHex(String arg) {
		  return String.format("%x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
		}

}
