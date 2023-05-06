package com.hdfc.capstone.clientwebservice.entity;

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

public class EmployeeDto {

	private int employeeId;
	private String employeeName;
	private String dateOfBirth;

	
	
	//Decryption of DateOfBirth using AES-256 Algorithm
	private static final String AES_ALGORITHM = "AES";
	private static final String AES_CIPHER_TRANSFORMATION = "AES/ECB/PKCS7Padding";
	private static final byte[] SECRET_KEY = "myverysecretpassword012345678901".getBytes();
	
	//Adding Bouncy Castle Security provider for encryption-decryption purposes
	static {
		Security.addProvider(new BouncyCastleProvider());
	}
	
	public String getDateOfBirth()  throws NoSuchAlgorithmException, NoSuchProviderException, 
											NoSuchPaddingException, IllegalBlockSizeException,
											BadPaddingException, InvalidKeyException  {
		Cipher cipher = Cipher.getInstance(AES_CIPHER_TRANSFORMATION, "BC");
		SecretKeySpec key = new SecretKeySpec(SECRET_KEY, AES_ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(dateOfBirth));
		return new String(decrypted);
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	
}
