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
 * Cryptor클래스는 아파치의 AES256Util을 이용하여 파일을 암호화(EncodingFile 메소드)하고
 *  복호화(DecodingFile 메소드)할 수 있는 static 클래스이다.
 *  암호화/복호화 메소드의 인자값은 암호화/복호화할 대상 파일의 경로를 String으로 주면 된다.
 */


public class Cryptor{
	public static String key = "aes256-test-key!!"; // key는 16자 이상
	
	/*
	 * 개선점 : EncodingFile 메소드와 DecodingFile메소드 부분에서 파일 크기만큼 배열을 선언해 주는 부분이 있는때
	 * 이때 byte배열 생성시 (int)타입이여야 되서 (long)타입을 강제 형변환 시켜주었다. 그래서 문제가 되는 점은
	 * GB단위의 파일을 암/복호화 할 시 파일이 짤리는 경우가 생긴다. 따라서 byte배열 생성하는 부분은 오버로딩하거나
	 * 새로운 클래스를 만들고 상속받은 후 오버라이딩을 해야하 지 않을까 생각이 든다.  
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
