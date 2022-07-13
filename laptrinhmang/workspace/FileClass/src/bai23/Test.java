package bai23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Test {
//	public static void main(String[] args) throws IOException {
//		File dir = new File("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main\\New folder\\New Text Document.txt");
////		System.out.println(dir.getName().substring(0, dir.getName().lastIndexOf('.')));
//		
////		String s = "abcd*";
////		System.out.println(s.substring(0,s.length()-1));
//		//System.out.println(dir.toPath());
////		String path="G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test";
////		System.out.println(path+'\\'+dir.getName());
////		try {
////			Files.copy(new File("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main\\26a4cd00c30a02545b1b.jpg").toPath(),new File("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\test\\a\\scgs.jpg").toPath());
////			System.out.println("djikshd");
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//		FileInputStream fis = new FileInputStream(dir);
//		byte[] buff = new byte[102400];
//		
//		System.out.println("size : "+ dir.length());
//		System.out.println(fis.read(buff, 0, 1024000));
//		
//	}
	public static void main(String[] args) throws IOException {
		RandomAccessFile ran = new RandomAccessFile(
				"G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main\\New folder\\New Text Document.txt", "rw");
		// ran.writeInt(1343000);
		// ran.writeUTF("1000");
		//ran.writeUTF("dwsgd");
		System.out.println(ran.readInt());
		System.out.println(ran.readUTF());
		ran.close();
	}
}
