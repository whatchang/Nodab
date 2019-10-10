package safo;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class DeleteFile implements Runnable {
	String Path;
	DeleteFile(){
		System.out.println("input list file path");
		System.exit(-1);
	}
	DeleteFile(String Path){
		this.Path = Path;
	}
	public void run(){
		File sizeDe = new File(Path);
       sizeDe.delete();
	}
}
