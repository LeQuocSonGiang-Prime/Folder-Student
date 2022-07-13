package bai13;

import java.util.Objects;

public class Student {

	
	private String name;
	private int age;
	private double count;
	
	public Student() {}

	public Student(String name, int age, double count) {
		super();
		this.name = name;
		this.age = age;
		this.count = count;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, count, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Double.doubleToLongBits(count) == Double.doubleToLongBits(other.count)
				&& Objects.equals(name, other.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
	}
	
	
}
