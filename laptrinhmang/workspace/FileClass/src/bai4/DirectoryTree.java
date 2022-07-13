package bai4;

import java.io.File;

public class DirectoryTree {
	/**
	 * cau 4
	 */
	public static String dirTree(String path, String tab) {
		File dir = new File(path);
		if (!dir.exists())
			return null;
		String result = "";
		if (dir.isFile()) {
			return tab + "- " + dir.getName() + "\n";
		}
		if (dir.isDirectory()) {
			result += tab + "+ " + dir.getName() + "\n";
			tab += "\t";
			File[] listFile = dir.listFiles();
			for (File f : listFile) {
				result += "\t" + dirTree(f.getAbsolutePath(), tab);
			}
		}
		return result;
	}
	
	/**
	 * cau 5
	 */
	public static String dirStat(String path,String tab) {
		File dir = new File(path);
		if (!dir.exists())
			return null;
		String result = "";
		if (dir.isFile()) {
			return tab + "- " + dir.getName()+ "  :  "+dir.length() + " bytes\n";
		}
		if (dir.isDirectory()) {
			result += tab + "+ " + dir.getName() + "\n";
			tab += "\t";
			File[] listFile = dir.listFiles();
			for (File f : listFile) {
				result += "\t" + dirStat(f.getAbsolutePath(), tab);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(DirectoryTree.dirStat("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test", ""));
	//	System.out.println(DirectoryTree.dirTree("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test", ""));
	}

}
