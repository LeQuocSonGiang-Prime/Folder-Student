package bai23;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Find {

	public static String findAll(String path, String... ext) {
		String result = "";
		File file = new File(path);
		if (!file.exists())
			return result;
		if (file.isFile()) {
			for (String i : ext) {
				if (path.endsWith(i))
					result = path;
				break;
			}
			return result;
		}
		result+="\n"+ file.getAbsolutePath();
		File[] listFile = file.listFiles();
		for (File f : listFile) {
			result +=findAll(f.getAbsolutePath(), ext)+"\n";
		}
		return result;

	}
	
	public List<String> findAll(String path, String pattern, List<String> result){
		File dir = new File(path);
		if(!dir.exists()) 
			return result;
		if(dir.isFile()) {
			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Find.findAll("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test", "txt"));;
	}

}
