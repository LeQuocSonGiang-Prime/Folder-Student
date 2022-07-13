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
		result += "\n" + file.getAbsolutePath();
		File[] listFile = file.listFiles();
		for (File f : listFile) {
			result += findAll(f.getAbsolutePath(), ext) + "\n";
		}
		return result;

	}

	public static void findAll(String path, String pattern, List<String> result) {
		File dir = new File(path);
		if (!dir.exists())
			return;
		if (dir.isFile()) {
			String nameFile = dir.getName().substring(0, dir.getName().lastIndexOf('.'));
			if (pattern.contains("*")) {
				if (pattern.endsWith("*")) {
					if (nameFile.indexOf(pattern.substring(1, pattern.length())) == 0) {
						result.add(dir.getAbsolutePath());
					}
				} else {
					if (nameFile.endsWith(pattern.substring(0, pattern.length() - 1)))
						result.add(dir.getAbsolutePath());
				}
			} else if (nameFile.contains(pattern)) {
				result.add(dir.getAbsolutePath());
			}
		}
		if (dir.isDirectory()) {
			if (dir.getName().contains(pattern))
				result.add(dir.getAbsolutePath());
			File[] listFile = dir.listFiles();
			for (File f : listFile) {
				findAll(f.getAbsolutePath(), pattern, result);
			}
		}

	}

	/**
	 * @param path
	 * @param pattern
	 * @return list path base on pattern name
	 */
	public static List<String> findOnPatternName(String path, String pattern) {
		List<String> result = new ArrayList<>();
		findAll(path, pattern, result);
		return result;
	}

	public static List<String> findOnPatternExt(String path, String pattern) {
		List<String> result = new ArrayList<>();
		findOnExt(path, pattern, result);
		return result;
	}

	public static void findOnExt(String path, String pattern, List<String> result) {
		File dir = new File(path);
		if (!dir.exists())
			return;
		if (dir.isFile()) {
			String ext = dir.getName().substring(dir.getName().lastIndexOf('.') + 1, dir.getName().length());
			if (pattern.contains("*")) {
				if (pattern.endsWith("*")) {
					if (ext.indexOf(pattern.substring(0, pattern.length() - 1)) == 0)
						result.add(dir.getAbsolutePath());
				} else {
					if (ext.endsWith(pattern.substring(1, pattern.length())))
						result.add(dir.getAbsolutePath());
				}
			}
		}
		if (dir.isDirectory()) {
			File[] listFile = dir.listFiles();
			for (File f : listFile) {
				findOnExt(f.getAbsolutePath(), pattern, result);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(Find.findAll("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test", "txt"));

		System.out.println(Find.findOnPatternName("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test", "N"));
		System.out.println(Find.findOnPatternExt("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test", "t*"));
	}

}
