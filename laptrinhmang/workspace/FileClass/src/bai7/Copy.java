package bai7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Copy {

	public static void copyAll(String sDir, String dDir, String pathParent, String... ext) {
		File dir = new File(sDir);
		if (!dir.exists())
			return;
		if (dir.isFile()) {
			for (String i : ext) {
				if (dir.getName().substring(dir.getName().lastIndexOf(".") + 1, dir.getName().length()).equals(i)) {
					try {
						Files.copy(dir.toPath(), new File(dDir + pathParent + "\\" + dir.getName()).toPath(),
								StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		if (dir.isDirectory()) {
			if (pathParent.length() == 0) {
				pathParent += "\\";
			} else if (pathParent.equals("\\")) {
				pathParent += dir.getName();
			} else {
				pathParent += "\\" + dir.getName();
			}
			File newDir = new File(dDir + pathParent);
			if (!newDir.exists())
				newDir.mkdirs();
			File[] listFile = dir.listFiles();
			for (File f : listFile) {
				copyAll(f.getAbsolutePath(), dDir, pathParent, ext);
			}
		}
	}

	public static void copyAll2(String sDir, String dDir, String... ext) {
		File dir = new File(sDir);
		if (!dir.exists())
			return;
		File newDir = new File(dDir);
		if (!newDir.exists())
			newDir.mkdirs();
		if (dir.isFile()) {
			for (String i : ext) {
				if (dir.getName().substring(dir.getName().lastIndexOf(".") + 1, dir.getName().length()).equals(i)) {
					try {
						Files.copy(dir.toPath(), new File(dDir + "\\" + dir.getName()).toPath());
						System.out.println("csjh");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		if (dir.isDirectory()) {
			File[] listFile = dir.listFiles();
			for (File f : listFile) {
				copyAll2(f.getAbsolutePath(), dDir,ext);
			}
		}
	}

	public static void main(String[] args) {
//		Copy.copyAll("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test",
//				"G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test1", "", "txt", "jpg");
		Copy.copyAll2("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main",
				"G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test2", "txt", "jpg");
	}

}
