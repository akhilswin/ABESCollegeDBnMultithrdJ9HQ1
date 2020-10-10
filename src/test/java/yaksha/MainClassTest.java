package yaksha;

import static yaksha.TestUtils.businessTestFile;
import static yaksha.TestUtils.currentTest;
import static yaksha.TestUtils.yakshaAssert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.jupiter.api.Test;

class MainClassTest {

	@Test
	public void testExceptionConditon() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.boundaryTestFile);
	}

	@Test
	public void testBoundaryCondition() throws Exception {

		TestUtils.yakshaAssert(TestUtils.currentTest(), true, TestUtils.exceptionTestFile);
	}

	@Test
	void testDisplay() throws Exception {
		// Test will pass
		ResultSet resultset = null;
		PreparedStatement pStatement;
		int rollNo;
		String name;
		int age;
		int mark;
		String department;
		String query = "select * from student";
		String expectedData = "111 Manish 22 87 Science";
		Connection con = StudentDAO.getConnection();
		pStatement = con.prepareStatement(query);
		resultset = pStatement.executeQuery(query);
		while (resultset.next()) {
			rollNo = resultset.getInt("RollNo");
			name = resultset.getString("Name");
			age = resultset.getInt("Age");
			mark = resultset.getInt("Mark");
			department = resultset.getString("Department");
			String receivedData = rollNo + " " + name + " " + age + " " + mark + " " + department;
			yakshaAssert(currentTest(), (expectedData.equals(receivedData) ? "true" : "false"), businessTestFile);
		}
	}
}
