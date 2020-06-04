package test2;

import test2.DeleteFile;

import java.io.*;
import java.util.*;


/*
 * ExeAndDelete파일은 파일을 실행시켜주는 ExeProcess 메소드와 파일을 제거해 주는 DeleteFile 메소드를 호출해 주는 역할을 한다.
 * ExeProcess를 호출하면 사용자가 복호화 프로그램을 종료할시까지 기다린 후 종료되면 DeleteFile 메소드를 호출하여 복호화 파일을 제거해 준다. 
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


