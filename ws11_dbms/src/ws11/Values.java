package ws11;

import java.util.TimeZone;

public class Values {
	public static final String DRIVER_CLASS_MYSQL = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:8889/firstDB?serverTimezone="  + TimeZone.getDefault().getID();
	public static final String USER_NAME = "root";
	public static final String PASS_WORD = "root";
}
