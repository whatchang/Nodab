package test2;

import test2.DeleteFile;

import java.io.*;
import java.util.*;


/*
 * ExeAndDelete������ ������ ��������ִ� ExeProcess �޼ҵ�� ������ ������ �ִ� DeleteFile �޼ҵ带 ȣ���� �ִ� ������ �Ѵ�.
 * ExeProcess�� ȣ���ϸ� ����ڰ� ��ȣȭ ���α׷��� �����ҽñ��� ��ٸ� �� ����Ǹ� DeleteFile �޼ҵ带 ȣ���Ͽ� ��ȣȭ ������ ������ �ش�. 
 */

public class ExeAndDelete implements Runnable{
	public void run() {
	Runnable r1 = new ExeProcess();
	Thread t1 = new Thread(r1);
	
	try {
		t1.start();
		t1.join();
	
		Runnable r2 = new DeleteFile();
		Thread t2 = new Thread(r2);
		t2.start();
	}catch(InterruptedException e) {
		e.printStackTrace();
	}
	
	}
}


