package bai1;

import java.io.File;

public class DeleteAll {

	public static boolean delete(String path) {
		File dir = new File(path);
		if (dir.isFile()) {
			return dir.delete();
		}
		File[] listFile = dir.listFiles();
		for (File f : listFile) {
			delete(f.getAbsolutePath());
		}
		return true;
	}

	public static void main(String[] args) {
		String path = "G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test";
		System.out.println(DeleteAll.delete(path));
		;
	}
}
