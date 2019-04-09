package ws11;

import java.sql.*;

public class CreateStudents {
	public static void main(String args[]){
		Connection con = null;
		Statement stmt = null;
		
		String createString = "create table Students " + "(stdID int, " + "firstName varchar(32), " +  "lastName varchar(32)," + "course varchar(32))";
		
		try {
			// Get Connection and Statement Object
			con = DriverManager.getConnection(Values.URL, Values.USER_NAME, Values.PASS_WORD);
			stmt = con.createStatement();
			
			// Execute JDBC commands
			stmt.execute("DROP TABLE IF EXISTS Students");
			stmt.executeUpdate(createString);
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		} finally {
			try{
				// Close connection and statement
				if(stmt != null)
					stmt.close();
				if(con != null)
					con.close();
			} catch (Exception ex) {
				System.err.println("SQLException: " + ex.getMessage());
			}
		}
	}
}
