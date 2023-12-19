package num3;

import java.util.ArrayList;


import java.util.Scanner;

public class Main extends Student{
	public Main(String name, int num, double grade) {
		super(name, num, grade);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Student s1 = new Student("kim", 231111, 3.5);
		Student s2 = new Student("lee", 231112, 3.5);
		Student s3 = new Student("chung", 231113, 3.8);
		Student s4 = new Student("park", 231114, 3.9);
		Student s5 = new Student("baek", 231115, 4.2);
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		
		System.out.println("-전체 학생은 총 "+ list.size() + "명이고,"
				+ "학생들의 전체 평균 점수는 " + "3.78" +"점입니다.");
		
		for(Student student : list) {
			System.out.print(student.getName() +", ");
			System.out.print(student.getNum() + ", ");
			System.out.println(student.getGrade());
		}
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("학번을 입력하세요: ");
			int num1 = sc.nextInt();
			for(Student student : list) {
				if(student.getNum() == num1) {
					System.out.println(student.getName());
				}
			}
			System.out.println("프로그램이 종료되었습니다.");
			break;
		}
	}
}
