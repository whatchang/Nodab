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
 * MainŬ���������� ��ȣȭ�� ����(String Path�� ��)�� ��ȣȭ ���ְ� �� ���α׷��� ��������ش�. ���⼭�� ������ ���� ����� ������
 * ��������ش�.C:\\Users\\dnckd\\Desktop\\Desktop2\\�����ڴ�ȸ\\RainSpear\\TEST\\�� ����\\�� ���� (2)\\test_result.xlsx.enc
 * MainŬ������ ���۰����� ��ȣȭ ������ ��� ��ȣȭ�� �����ش�. �̶� ��ȣȭ��  ���� Ű���� ��ȣȭ�Ҷ� ���� Ű�� �����ϴ�. �� �� ��ȣȭ�� ������
 * .enc Ȯ���ڸ� ü������ ���·� ������ ������Ű�� �� ���α׷��� ������� �ذ� ��ȣȭ ���α׷� ����� ��ȣȭ ������ ������ �ش�(ExeAndDelete �޼ҵ��� ��Ȱ).
 */

/*
 * ������ : �ϵ� �ڵ��� Path�κ��� ����ڰ� ��ȣȭ ���� Ŭ���� ��ȣȭ ������ ��θ� Path�� ������ �� �� �ְ� ���־�� �Ѵ�. C++, C#ó�� ������ API��
 * �̿��ϸ� �ǹǷ� JNI Ȥ�� JNA�� ����Ͽ� kernel32.dll�� �ִ� GetModulFileName�Լ��� �̿��ϸ� Path���� �������� �Ҵ��� �� �� ���� ���̴�.
 * �׸��� ������Ʈ���� .encȮ���� �������α׷��� �� ���α׷����� ��������ִ� �κе� �����ؾ� �ȴ�.
 */

public class Main{
	public static void main(String[] args) throws Exception {
		String Path = "C:\\Users\\dnckd\\Desktop\\Desktop2\\�����ڴ�ȸ\\RainSpear\\TEST\\�� ����\\�� ���� (2)\\test_result.xlsx.enc";
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