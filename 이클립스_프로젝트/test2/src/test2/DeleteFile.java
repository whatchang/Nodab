package test2;

import java.io.File;
import java.io.IOException;

/*
 * DeleteFile은 복호화 프로그램 종료시 복호화 파일을 삭제하는 역할을 한다.
 */

/*
 * 개선점 : depath의 값을 하드 코딩하지 말고 ExeProcess의 path의 값과 같으므로 인자를 전달받거나 상속받는 형식으로 하면 
 * 좋을 것 같다.
 */
public class DeleteFile implements Runnable {
	String depath = "C:\\Users\\dnckd\\Desktop\\Desktop2\\개발자대회\\RainSpear\\TEST\\새 폴더\\새 폴더 (2)\\test_result.xlsx";
	File sizeDe = new File(depath);
	public void run(){
       sizeDe.delete();
	}
}
