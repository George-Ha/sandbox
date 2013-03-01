package cz.rc4;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Main {

	/**
	 * @param args
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Security.addProvider(new BouncyCastleProvider());
		Cipher instance = Cipher.getInstance("RC4");
		//System.out.println(instance.getBlockSize()); //prints 0, it is stream cipher
		String alg = "RC4";
//		byte[] key = new String("heslo").getBytes();//{97,97,97,97,97};
		byte[] key = {97,97,97,97,97};
		System.out.println("key: "+key);
		instance.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, alg));
//		String plaintext = "ahoj";
		byte[] plaintext = {97,104,111,106};
		System.out.println("plaintext: "+plaintext);
		byte[] input = new String(plaintext).getBytes();
		for (int i=0; i<input.length; i++) {
			System.out.println("byte: "+input[i]);
		}
		byte[] output = instance.doFinal(input);
		System.out.println("ciphertext:");
		for (int i=0; i<input.length; i++) {
			System.out.println("byte: "+output[i]);
		}
	}

}
