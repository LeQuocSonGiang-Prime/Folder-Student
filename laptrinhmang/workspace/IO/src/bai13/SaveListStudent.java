package bai13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveListStudent {

	public void saveListStudent(List<Student> list, String path) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
		dos.writeInt(list.size());
		for (Student s : list) {
			dos.writeUTF(s.getName());
			dos.writeInt(s.getAge());
			dos.writeDouble(s.getCount());
		}
		dos.close();
	}

	public List<Student> loadListStudent(String path) throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(path));
		int listSize = dis.readInt();
		List<Student> result = new ArrayList<>();
		for (int i = 0; i < listSize; i++) {
			Student st = new Student();
			st.setName(dis.readUTF());
			st.setAge(dis.readInt());
			st.setCount(dis.readDouble());
			result.add(st);
		}
		return result;
	}
}
