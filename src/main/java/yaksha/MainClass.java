package yaksha;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner in = new Scanner(System.in);
		StudentDAO sdao = new StudentDAO();
		StudentBO sbo = new StudentBO();
		Connection con = StudentDAO.getConnection();
		int rollNo;
		String name;
		int age;
		int mark;
		String department;
		boolean flag = true;
		int choice;
		Student stud;
		String temp;
		while (flag) {
			System.out.println("MENU");
			System.out.println("1.Insert");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Display");
			System.out.println("5.Exit");
			System.out.println("Enter your choice :");
			choice = in.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the Roll Number :");
				rollNo = in.nextInt();
				System.out.println("Enter the Name :");
				in.nextLine();
				name = in.nextLine();
				System.out.println("Enter the Age :");
				age = in.nextInt();
				System.out.println("Enter the Total marks :");
				mark = in.nextInt();
				System.out.println("Enter the Department :");
				in.nextLine();
				department = in.nextLine();
				stud = new Student(rollNo, name, age, mark, department);
				sbo.insertRecord(stud, con);
				break;
			case 2:
				System.out.println("Enter the Roll Number of the student to be updated :");
				in.nextLine();
				temp = in.nextLine();
				if (temp.length() < 3) {
					System.out.println("No Record Found");
				} else {
					rollNo = Integer.parseInt(temp);
					sbo.updateRecord(rollNo, con, in);
				}
				break;
			case 3:
				System.out.println("Enter the Roll Number of the student to be deleted :");
				in.nextLine();
				temp = in.nextLine();
				if (temp.length() < 3) {
					System.out.println("No Record Found");
				} else {
					rollNo = Integer.parseInt(temp);
					sbo.deleteRecord(rollNo, con);
				}
				break;
			case 4:
				sbo.display(con);
				break;
			case 5:
				flag = false;
				break;
			default:
				flag = false;

			}
		}
		sdao.closeConnection();
	}
}
