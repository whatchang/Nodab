package test2;

import java.io.IOException;
import java.io.File;


/*
 * ExeProcess는 복호화된 파일(String depath의 값)을 ProcessBulider를 이용하여 실행을 시켜주고 waitFor메소드를 이용하여
 * 종료시까지 기다려준다. 그 후 프로세스를 종료시켜준다. 
 */

/*
 * 개선점 : ProcessBulider를 사용하게 되면 첫번째 인자에 연결프로그램을 넣어주어야 한다. 사용자가 실행시킨 파일의 확장자는
 * 매번 다를 수 있으므로 그에 따라 첫번째 인자의 값도 매번 달라질 것이다. 이에 반해 Runtime.getRuntime.exec라는 메소드 가 있는데 이 
 * 메소드를 사용하면 첫번째 인자에 대한 문제는 해결되나 waitFor이 제대로 적용이 되지 않는다. 그러나 생성자를 이용하여 파일을 구분해서 특정파일 순서로
 * 실행하게 하면 이 문제를 해결할 수 있을 것으로 보인다(멘토님이 해결해 주신 부분).
 */
public class ExeProcess implements Runnable {
	public void run() {
		try {
			String depath = "C:\\Users\\dnckd\\Desktop\\Desktop2\\개발자대회\\RainSpear\\\\TEST\\새 폴더\\새 폴더 (2)\\test_result.xlsx";
			//Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + depath);
			Process p = new ProcessBuilder("C:\\Program Files\\Microsoft Office\\root\\Office16\\EXCEL.EXE", depath).start();
			p.waitFor();
			p.destroy();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}