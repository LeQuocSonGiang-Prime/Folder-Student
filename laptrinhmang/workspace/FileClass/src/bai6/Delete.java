package bai6;

import java.io.File;

public class Delete {

	public static void deleteAll(String path, String... ext) {
		File dir = new File(path);
		if (!dir.exists())
			return;
		if (dir.isFile())
			for (String i : ext) {
				if (dir.getName().substring(dir.getName().lastIndexOf(".") + 1, dir.getName().length()).equals(i)) {
					dir.delete();
					break;
				}
			}
		if (dir.isDirectory()) {
			File[] listFile = dir.listFiles();
			for(File f: listFile) {
				deleteAll(f.getAbsolutePath(), ext);
			}
		}
	}
	public static void main(String[] args) {
		Delete.deleteAll("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test", "txt");
	}

}
