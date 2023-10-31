package num3;

public class Student {
	private String name;
	private int num;
	private double grade;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	public Student(String name, int num, double grade) {
		this.name = name;
		this.num = num;
		this.grade = grade;
	}
}
