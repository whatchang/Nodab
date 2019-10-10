package safo;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

/*
 * Monitor클래스에는 Scanning메소드가 있다. 메소드의 역할은 현재 디렉토리부터 하위디렉토리까지 파일들을 목록화 시키고 
 * 그 정보를 MainAES에게 건네주는 역할을 하다. 이때 현재 디렉토리는 Monitor클래스 안에 있는 path를 기준으로 한다. 
 */

/*
 * 개선점 : 만약 현재 디텍토리가(path)가 C드라이브라면 운영체제가 사용하는 파일도 암호화가 될 것이다. 그러면 사용자가 
 * 컴퓨터를 사용하는데 있어서 큰 문제가 될 것이다. 그래서 운영체제가 사용하는 디렉토리 부분은 암호화를 안 시키는 조건문을 만들어야 
 * 될 것 같다.
 */
public class Monitor {
	public static ArrayList<String> MonitorList = new ArrayList();

	public static String path = "C:\\Users\\dnckd\\Desktop\\Desktop2\\개발자대회\\RainSpear\\TEST"; //기준 디렉토리


	public static ArrayList<String> Scanning() { 
		String isDir = path;
  
  // 하위 디렉토리 
		for (File info : new File(isDir).listFiles()){ 
			if(info.isDirectory()) { 
				System.out.println(info.getName()); 
			}
			if(info.isFile()) { 
				System.out.println(info.getName()); 
			} 
		}
		
  
  // 하위의 모든 파일  
		for(File info : FileUtils.listFiles(new File(isDir),TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) {
			MonitorList.add(info.getPath());
		}
  
  // 하위의 모든 디렉토리 
		for (File info : FileUtils.listFilesAndDirs(new File(isDir), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) { 
			if(info.isDirectory()) {
			} 
		}
 
		return MonitorList;
  
	}

}
