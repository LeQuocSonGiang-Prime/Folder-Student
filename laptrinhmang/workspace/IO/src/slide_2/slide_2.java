package slide_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class slide_2 {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(
				new File("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\t.txt"));
		FileOutputStream fos = new FileOutputStream("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\x.txt");
		int data;
		while ((data = fis.read()) > -1) {
			fos.write(data);
		}
		fos.close();
		fis.close();
	}
}
