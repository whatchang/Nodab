package test2;

import java.io.File;
import java.io.IOException;

/*
 * DeleteFile�� ��ȣȭ ���α׷� ����� ��ȣȭ ������ �����ϴ� ������ �Ѵ�.
 */

/*
 * ������ : depath�� ���� �ϵ� �ڵ����� ���� ExeProcess�� path�� ���� �����Ƿ� ���ڸ� ���޹ްų� ��ӹ޴� �������� �ϸ� 
 * ���� �� ����.
 */
public class DeleteFile implements Runnable {
	String depath = "C:\\Users\\dnckd\\Desktop\\Desktop2\\�����ڴ�ȸ\\RainSpear\\TEST\\�� ����\\�� ���� (2)\\test_result.xlsx";
	File sizeDe = new File(depath);
	public void run(){
       sizeDe.delete();
	}
}
