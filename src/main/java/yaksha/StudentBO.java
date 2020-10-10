package yaksha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentBO {
	public static PreparedStatement pStatement;

	public void insertRecord(Student stud, Connection connection) {
		try {
			String query = "insert into student values (?,?,?,?,?)";
			pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, stud.rollNo);
			pStatement.setString(2, stud.name);
			pStatement.setInt(3, stud.age);
			pStatement.setInt(4, stud.mark);
			pStatement.setString(5, stud.department);
			int noRows = pStatement.executeUpdate();
			if (noRows > 0) {
				System.out.println("Record Inserted");
			} else {
				System.out.println("Record Not Inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateRecord(int rollNo, Connection connection, Scanner in) {
		try {
			String query;
			String dispQuery = "select RollNo from student where RollNo = ?";
			pStatement = connection.prepareStatement(dispQuery);
			pStatement.setInt(1, rollNo);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()) {
				int choice;
				System.out.println("Do you want to update :");
				System.out.println("1.Name\n2.Age\n3.Total Marks\n4.Department\n5.Exit\nEnter Your choice :");
				choice = in.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter the Name :");
					in.nextLine();
					String name = in.nextLine();
					query = "update student set Name=? where RollNo=?";
					pStatement = connection.prepareStatement(query);
					pStatement.setString(1, name);
					pStatement.setInt(2, rollNo);
					pStatement.executeUpdate();
					System.out.println("Record Updated Successfully");
					break;
				case 2:
					System.out.println("Enter the Age :");
					int age = in.nextInt();
					query = "update student set age=? where RollNo=?";
					pStatement = connection.prepareStatement(query);
					pStatement.setInt(1, age);
					pStatement.setInt(2, rollNo);
					pStatement.executeUpdate();
					System.out.println("Record Updated Successfully");
					break;
				case 3:
					System.out.println("Enter the Total marks :");
					int mark = in.nextInt();
					query = "update student set Mark=? where RollNo=?";
					pStatement = connection.prepareStatement(query);
					pStatement.setInt(1, mark);
					pStatement.setInt(2, rollNo);
					pStatement.executeUpdate();
					System.out.println("Record Updated Successfully");
					break;
				case 4:
					System.out.println("Enter the Department :");
					in.nextLine();
					String department = in.nextLine();
					query = "update student set Department=? where RollNo=?";
					pStatement = connection.prepareStatement(query);
					pStatement.setString(1, department);
					pStatement.setInt(2, rollNo);
					pStatement.executeUpdate();
					System.out.println("Record Updated Successfully");
					break;
				default:

				}
			} else {
				System.out.println("No Record Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteRecord(int rollNo, Connection connection) {
		String dispQuery = "select RollNo from student where RollNo = ?";
		String query = "delete from student where RollNo=?";
		try {
			pStatement = connection.prepareStatement(dispQuery);
			pStatement.setInt(1, rollNo);
			ResultSet rs = pStatement.executeQuery();
			if (rs.next()) {
				pStatement = connection.prepareStatement(query);
				pStatement.setInt(1, rollNo);
				pStatement.executeUpdate();
				System.out.println("Record Deleted Successfully");
			} else {
				System.out.println("No Record Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void display(Connection connection) {
		ResultSet resultset = null;
		int rollNo;
		String name;
		int age;
		int mark;
		String department;
		String query = "select * from student";
		try {
			pStatement = connection.prepareStatement(query);
			resultset = pStatement.executeQuery(query);
			while (resultset.next()) {
				rollNo = resultset.getInt("RollNo");
				name = resultset.getString("Name");
				age = resultset.getInt("Age");
				mark = resultset.getInt("Mark");
				department = resultset.getString("Department");
				System.out.println("Roll No :" + String.format("%03d", rollNo));
				System.out.println("Name :" + name);
				System.out.println("Age :" + age);
				System.out.println("Total marks :" + mark);
				System.out.println("Department :" + department);
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
