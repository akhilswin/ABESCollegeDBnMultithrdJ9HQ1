package yaksha;

public class Student {

	int rollNo;
	String name;
	int age;
	int mark;
	String department;

	public Student() {

	}

	public Student(int rollNo, String name, int age, int mark, String department) {

		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.mark = mark;
		this.department = department;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
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

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
