package com.hdfc.capstone.capstoneemployee.dto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class EmployeeDto {

	private int employeeId;
	private String employeeName;
	private String dateOfBirth;

	
	
	//Encryption of DateOfBirth using AES-256 Algorithm
	private static final String AES_ALGORITHM = "AES";
	private static final String AES_CIPHER_TRANSFORMATION = "AES/ECB/PKCS7Padding";
	private static final byte[] SECRET_KEY = "myverysecretpassword012345678901".getBytes();
	
	//Adding Bouncy Castle Security provider for encryption-decryption purposes
	static {
		Security.addProvider(new BouncyCastleProvider());
	}
	
	public void setDateOfBirth(String dateOfBirth)  throws NoSuchAlgorithmException, NoSuchProviderException, 
															NoSuchPaddingException, IllegalBlockSizeException,
															BadPaddingException, InvalidKeyException  {
		Cipher cipher = Cipher.getInstance(AES_CIPHER_TRANSFORMATION, "BC");
		SecretKeySpec key = new SecretKeySpec(SECRET_KEY, AES_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encrypted = cipher.doFinal(dateOfBirth.getBytes());
		this.dateOfBirth = Base64.getEncoder().encodeToString(encrypted);
	}

	
}
