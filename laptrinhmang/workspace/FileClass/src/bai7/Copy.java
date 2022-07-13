package bai7;

import java.io.File;

public class Copy {

	
	public static void copyAll(String sDir, String dDir, String... ext) {
		File dir = new File(sDir);
		if(!dir.exists())
			return ;
		if(dir.isFile()) {
			for(String i : ext) {
				if(dir.getName().substring(dir.getName().lastIndexOf(".")+1, dir.getName().length()).equals(i)) {
					
				}
			}
		}
		File[] listFile = dir.listFiles();
		for(File i: listFile) {
			
		}
	}
	
}
