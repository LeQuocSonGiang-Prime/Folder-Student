package bai10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Split {

	public static boolean splitFile(String src, String dest, long size) throws IOException {
		File file = new File(src);
		if (!file.exists() || file.isDirectory())
			return false;
		int countFileSplit = (int) (file.length() / size +1);
		InputStream is = new BufferedInputStream(new FileInputStream(file));
		for (int i = 0; i < countFileSplit; i++) {
			OutputStream os = new BufferedOutputStream(new FileOutputStream(dest + "\\" + file.getName() + i));
			byte[] buff = new byte[1024];
			int dataRead = (int) (buff.length >= size ? size : buff.length);
			int data;
			int step = 0;
			while ((data = is.read(buff, 0, dataRead)) != -1) {
				os.write(buff, 0, data);
				step++;
				if (buff.length != dataRead)
					break;
				System.out.println(buff.length * step + data);
				dataRead = (int) ((size - buff.length * step > buff.length || size - buff.length * step < 0)
						? buff.length
						: size - buff.length * step);
				System.out.println(dataRead);
			}
			os.close();
		}
		is.close();
		return true;
	}
	
	public static boolean joinFile(String src, String dest) throws IOException {
		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
		File dir = new File(src);
		if(!dir.exists()) 
			return false;
		File[] listFile = dir.listFiles();
		for(File f: listFile) {
			InputStream is = new BufferedInputStream(new FileInputStream(f));
			byte[] buff = new byte[1024];int data;
			while((data = is.read(buff))!=-1) {
				os.write(buff);
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
//		Split.splitFile(
//				"G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main\\New folder\\New folder\\6gkQSe.webp",
//				"G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main\\New folder\\New folder\\New folder", 30000);
		
		Split.joinFile("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main\\New folder\\New folder\\New folder", "G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main\\New folder\\New folder\\jion");
	}
}
