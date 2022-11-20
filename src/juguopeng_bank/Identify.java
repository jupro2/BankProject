package juguopeng_bank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Identify {//输入密码判断是否和数据库内对立
    Connect connect=new Connect();//引入数据库连接类
    public boolean PanDuan(Person p) throws SQLException {
        connect.setConn();
        String sql = "Select password From pass where NAME = ?";//sql出错
        PreparedStatement pstmt = Connect.conn.prepareStatement(sql);
        pstmt.setString(1,p.Name);
        ResultSet res = pstmt.executeQuery();
       if(res.next())
       {
           if (p.password==res.getInt(1)){
               pstmt.close();
               Connect.conn.close();
               return true;
           }

       }
        pstmt.close();
        Connect.conn.close();
        return false;




    }
}
