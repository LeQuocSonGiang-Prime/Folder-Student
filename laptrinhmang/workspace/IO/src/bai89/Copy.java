package bai89;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

	/**
	 * Copy/Move File
	 */
	public static boolean fileCopy(String sFile, String dFile, boolean moved) {
		try {
			FileInputStream fis = new FileInputStream(sFile);
			FileOutputStream fos = new FileOutputStream(dFile);
			byte[] buff = new byte[1024];
			int data;
			while ((data = fis.read(buff)) != -1) {
				fos.write(buff);
			}
			fos.close();
			fis.close();
			if (moved) {
				File f = new File(sFile);
				if (!f.delete()) {
					File newFile = new File(dFile);
					newFile.delete();
					return false;
				}
			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Copy/move folder
	 */
	public static boolean dirCopy(String sDir, String dDir, boolean moved) {
		File dir = new File(sDir);
		if (!dir.exists())
			return false;
		File desDir = new File(dDir);
		if (!desDir.exists())
			desDir.mkdirs();
		if (dir.isFile()) {
			String dFile = dDir += "\\" + dir.getName();
			try {
				FileInputStream fis = new FileInputStream(sDir);
				FileOutputStream fos = new FileOutputStream(dFile);
				byte[] buff = new byte[1024];
				int data;
				while ((data = fis.read(buff)) != -1) {
					fos.write(buff);
				}
				fis.close();
				fos.close();
				if (moved) {
					if (!dir.delete()) {
						File newFile = new File(dFile);
						newFile.delete();
						return false;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (dir.isDirectory()) {
			File[] listFile = dir.listFiles();
			for (File f : listFile) {
				dirCopy(f.getAbsolutePath(), dDir+"\\" + dir.getName(), moved);
			}
		}
		return true;
	}

	public static void main(String[] args) {
//		System.out.println(Copy.fileCopy("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test\\scdgs11.webp",
//				"G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test4\\s222cdgs11.webp", false));
//		;
		System.out.println(Copy.dirCopy("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main", "G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test4\\", false));
	}

}
