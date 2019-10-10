package safo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import safo.AES256Util;


/*
 * CryptorŬ������ ����ġ�� AES256Util�� �̿��Ͽ� ������ ��ȣȭ(EncodingFile �޼ҵ�)�ϰ�
 *  ��ȣȭ(DecodingFile �޼ҵ�)�� �� �ִ� static Ŭ�����̴�.
 *  ��ȣȭ/��ȣȭ �޼ҵ��� ���ڰ��� ��ȣȭ/��ȣȭ�� ��� ������ ��θ� String���� �ָ� �ȴ�.
 */


public class Cryptor{
	public static String key = "aes256-test-key!!"; // key�� 16�� �̻�
	
	/*
	 * ������ : EncodingFile �޼ҵ�� DecodingFile�޼ҵ� �κп��� ���� ũ�⸸ŭ �迭�� ������ �ִ� �κ��� �ִ¶�
	 * �̶� byte�迭 ������ (int)Ÿ���̿��� �Ǽ� (long)Ÿ���� ���� ����ȯ �����־���. �׷��� ������ �Ǵ� ����
	 * GB������ ������ ��/��ȣȭ �� �� ������ ©���� ��찡 �����. ���� byte�迭 �����ϴ� �κ��� �����ε��ϰų�
	 * ���ο� Ŭ������ ����� ��ӹ��� �� �������̵��� �ؾ��� �� ������ ������ ���.  
	 */
	
	public static void DecodingFile(String EnPath) {
		File sizeEn = new File(EnPath);
		String DePath = EnPath.substring(0, EnPath.length()-4);
		AES256Util aes256 = null;
		try {
			aes256 = new AES256Util(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (FileInputStream fis = new FileInputStream(EnPath); 
				FileOutputStream fos = new FileOutputStream(DePath)) {
			byte[] temp = new byte[(int) sizeEn.length()];
			while (fis.read(temp) != -1)
				try {
					fos.write((aes256.aesDecode(temp)));
				} catch (InvalidKeyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvalidAlgorithmParameterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalBlockSizeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void EncodingFile(String Path) {
		AES256Util aes256 = null;
		try {
			aes256 = new AES256Util(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File size = new File(Path);
		String EnPath = Path+".enc";
		  try (FileInputStream fis = new FileInputStream(Path);
				  FileOutputStream fos =new FileOutputStream(EnPath)) { 
			  byte[] temp = new byte[(int)size.length()]; 
			  if(temp.length == 0)
				  return ;
			  while (fis.read(temp) != -1)
				try {
					fos.write((aes256.aesEncode(temp)));
				} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
						| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
