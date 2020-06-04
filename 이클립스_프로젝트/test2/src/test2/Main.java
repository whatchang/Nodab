package test2;

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

import test2.AES256Util;
import test2.ExeProcess;

/*
 * Main클래스에서는 암호화된 파일(String Path의 값)을 복호화 해주고 그 프로그램을 실행시켜준다. 여기서는 다음과 같은 경로의 파일을
 * 실행시켜준다.C:\\Users\\dnckd\\Desktop\\Desktop2\\개발자대회\\RainSpear\\TEST\\새 폴더\\새 폴더 (2)\\test_result.xlsx.enc
 * Main클래스의 동작과정은 암호화 파일을 열어서 복호화를 시켜준다. 이때 복호화에  쓰인 키값은 암호화할때 쓰인 키와 동일하다. 그 후 복호화가 끝나면
 * .enc 확장자를 체거해준 상태로 파일을 생성시키고 그 프로그램을 실행시켜 준고 복호화 프로그램 종료시 복호화 파일을 제거해 준다(ExeAndDelete 메소드의 역활).
 */

/*
 * 개선점 : 하드 코딩한 Path부분을 사용자가 암호화 파일 클릭시 암호화 파일의 경로를 Path의 값으로 줄 수 있게 해주어야 한다. C++, C#처럼 윈도우 API를
 * 이용하면 되므로 JNI 혹은 JNA를 사용하여 kernel32.dll에 있는 GetModulFileName함수를 이용하면 Path값을 동적으로 할당해 줄 수 있을 것이다.
 * 그리고 레지스트리에 .enc확장자 연결프로그램을 이 프로그램으로 연결시켜주는 부분도 구현해야 된다.
 */

public class Main{
	public static void main(String[] args) throws Exception {
		String Path = "C:\\Users\\dnckd\\Desktop\\Desktop2\\개발자대회\\RainSpear\\TEST\\새 폴더\\새 폴더 (2)\\test_result.xlsx.enc";
		AES256Util aes256 = null;
		String key = "aes256-test-key!!"; 
		try {
			aes256 = new AES256Util(key);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File size = new File(Path);
		String DePath = Path.substring(0, Path.length()-4);
		  try (FileInputStream fis = new FileInputStream(Path);
				  FileOutputStream fos =new FileOutputStream(DePath)) { 
			  byte[] temp = new byte[(int)size.length()]; 
			  while (fis.read(temp) != -1)
				try {
					fos.write((aes256.aesDecode(temp)));
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
		  
		  Runnable r1 = new ExeAndDelete();
		  Thread t1 = new Thread(r1);
		  
		  t1.start();
	}
}