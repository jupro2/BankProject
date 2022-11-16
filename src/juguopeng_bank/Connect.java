package juguopeng_bank;

import java.sql.*;

public class Connect{
   public static Connection conn=null;
    public void setConn() {
        String driverName="com.mysql.cj.jdbc.Driver";
        String ulr="jdbc:mysql://localhost:3306/bank";
        String username="root";
        String userWord="123456";

        try {
            Class.forName(driverName);
            conn=DriverManager.getConnection(ulr,username,userWord);

            System.out.println("\n");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

