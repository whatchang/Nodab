package test2;

import java.io.IOException;
import java.io.File;


/*
 * ExeProcess�� ��ȣȭ�� ����(String depath�� ��)�� ProcessBulider�� �̿��Ͽ� ������ �����ְ� waitFor�޼ҵ带 �̿��Ͽ�
 * ����ñ��� ��ٷ��ش�. �� �� ���μ����� ��������ش�. 
 */

/*
 * ������ : ProcessBulider�� ����ϰ� �Ǹ� ù��° ���ڿ� �������α׷��� �־��־�� �Ѵ�. ����ڰ� �����Ų ������ Ȯ���ڴ�
 * �Ź� �ٸ� �� �����Ƿ� �׿� ���� ù��° ������ ���� �Ź� �޶��� ���̴�. �̿� ���� Runtime.getRuntime.exec��� �޼ҵ� �� �ִµ� �� 
 * �޼ҵ带 ����ϸ� ù��° ���ڿ� ���� ������ �ذ�ǳ� waitFor�� ����� ������ ���� �ʴ´�. �׷��� �����ڸ� �̿��Ͽ� ������ �����ؼ� Ư������ ������
 * �����ϰ� �ϸ� �� ������ �ذ��� �� ���� ������ ���δ�(������� �ذ��� �ֽ� �κ�).
 */
public class ExeProcess implements Runnable {
	public void run() {
		try {
			String depath = "C:\\Users\\dnckd\\Desktop\\Desktop2\\�����ڴ�ȸ\\RainSpear\\\\TEST\\�� ����\\�� ���� (2)\\test_result.xlsx";
			//Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + depath);
			Process p = new ProcessBuilder("C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE", depath).start();
			p.waitFor();
			p.destroy();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}