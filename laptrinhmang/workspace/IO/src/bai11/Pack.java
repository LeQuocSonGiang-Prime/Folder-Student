package bai11;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Pack {

	public boolean packFile(String src, String des) throws IOException {
		File file = new File(src);
		if (!file.exists())
			return false;
		File[] listFile = file.listFiles();
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(des));
		dos.writeInt(listFile.length);
		for (File f : listFile) {
			InputStream is = new BufferedInputStream(new FileInputStream(f));
			dos.writeUTF(f.getName());
			dos.writeLong(f.length());
			int data;
			byte[] buff = new byte[1024];
			while ((data = is.read(buff)) != -1) {
				dos.write(buff, 0, data);
			}
			is.close();
		}
		dos.close();
		return true;
	}

	public boolean unPackFile(String src, String des) throws IOException {
		File file = new File(src);
		if (!file.exists() || file.isDirectory())
			return false;
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		int totalFile = dis.readInt();
		for (int i = 0; i < totalFile; i++) {
			String fileName = dis.readUTF();
			long fileSize = dis.readLong();
			long remain = fileSize;
			FileOutputStream fos = new FileOutputStream(des + "\\" + fileName);
			byte[] buff = new byte[1024];
			int data;
			while (remain > 0) {
				data = (int) ((remain > buff.length) ? buff.length : remain);
				dis.read(buff, 0, data);
				fos.write(buff, 0, data);
				remain -= data;
			}
			fos.close();
		}
		dis.close();
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		//new Pack().packFile("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main\\New folder\\New folder", "G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main\\New folder\\New folder\\a");
		new Pack().unPackFile("G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main\\New folder\\New folder\\a", "G:\\tai_lieu_cac_mon_hoc\\laptrinhmang\\sample-data\\main\\New folder\\New folder\\New folder");
	}

}
