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
 * MonitorŬ�������� Scanning�޼ҵ尡 �ִ�. �޼ҵ��� ������ ���� ���丮���� �������丮���� ���ϵ��� ���ȭ ��Ű�� 
 * �� ������ MainAES���� �ǳ��ִ� ������ �ϴ�. �̶� ���� ���丮�� MonitorŬ���� �ȿ� �ִ� path�� �������� �Ѵ�. 
 */

/*
 * ������ : ���� ���� �����丮��(path)�� C����̺��� �ü���� ����ϴ� ���ϵ� ��ȣȭ�� �� ���̴�. �׷��� ����ڰ� 
 * ��ǻ�͸� ����ϴµ� �־ ū ������ �� ���̴�. �׷��� �ü���� ����ϴ� ���丮 �κ��� ��ȣȭ�� �� ��Ű�� ���ǹ��� ������ 
 * �� �� ����.
 */
public class Monitor {
	public static ArrayList<String> MonitorList = new ArrayList();

	public static String path = "C:\\Users\\dnckd\\Desktop\\Desktop2\\�����ڴ�ȸ\\RainSpear\\TEST"; //���� ���丮


	public static ArrayList<String> Scanning() { 
		String isDir = path;
  
  // ���� ���丮 
		for (File info : new File(isDir).listFiles()){ 
			if(info.isDirectory()) { 
				System.out.println(info.getName()); 
			}
			if(info.isFile()) { 
				System.out.println(info.getName()); 
			} 
		}
		
  
  // ������ ��� ����  
		for(File info : FileUtils.listFiles(new File(isDir),TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) {
			MonitorList.add(info.getPath());
		}
  
  // ������ ��� ���丮 
		for (File info : FileUtils.listFilesAndDirs(new File(isDir), TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE)) { 
			if(info.isDirectory()) {
			} 
		}
 
		return MonitorList;
  
	}

}
