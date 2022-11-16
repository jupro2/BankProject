package juguopeng_bank;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class Bank {
    Connect connect=new Connect();//引入数据库连接类


    Scanner sc=new Scanner(System.in);
    public Date date=new Date();
    Timestamp sql_date=new Timestamp(date.getTime());



    public void OpenAccount(Person p) throws SQLException {//处理开户请求
        connect.setConn();


        String sql = "Select * from information where Name = ?";
        PreparedStatement pstmt = Connect.conn.prepareStatement(sql);
        pstmt.setString(1,p.Name);
        ResultSet res = pstmt.executeQuery();
        if (res.next()) {
            System.out.println("你的账户已存在!");
        }
        else {//插入信息
            String sql1="INSERT INTO information VALUES(?,?,?,?,?,?)";//sql1
            PreparedStatement pstmt1 = Connect.conn.prepareStatement(sql1);//sql1
            pstmt1.setString(1,p.Name);//传入参数
            pstmt1.setString(2,p.IDNumber);
            pstmt1.setString(3,p.CountNumber);
            pstmt1.setString(4, p.PhoneNumber);
            pstmt1.setFloat(5,p.Balance);
            pstmt1.setTimestamp(6,sql_date);

            String sql2="INSERT INTO pass VALUES(?,?)";
            PreparedStatement pstmt2 = Connect.conn.prepareStatement(sql2);
            pstmt2.setString(1,p.Name);
            pstmt2.setInt(2,p.password);


            pstmt1.execute();// 执行sql语句
            pstmt2.execute();
            System.out.println("开户成功，欢迎！！！！");
            System.out.println("你的开户人为："+p.Name);
            System.out.println("你的开户账号为："+p.CountNumber);
            pstmt1.close();
        }
        pstmt.close();
        Connect.conn.close();
    }//OpenAccount

    public void AccountCancellation(Person p)throws SQLException{
        connect.setConn();

        String sql = "Select * from information where Name = ?";
        PreparedStatement pstmt = Connect.conn.prepareStatement(sql);
        pstmt.setString(1,p.Name);
        ResultSet res = pstmt.executeQuery();
        if (res.next()) {
            String sql1="DELETE from information where Name=?";//sql1
            PreparedStatement pstmt1 = Connect.conn.prepareStatement(sql1);//sql1
            pstmt1.setString(1,p.Name);
            pstmt1.execute();// 执行sql语句
            System.out.println("你的账户已销户！！！");
        }
        else {
            System.out.println("你的账户不存在！！");
        }
        pstmt.close();
        Connect.conn.close();


    }//AccountCancellation

    public void Saving(Person p)throws SQLException{//存钱
        connect.setConn();


        String sql = "Select * from information where Name = ?";
        PreparedStatement pstmt = Connect.conn.prepareStatement(sql);
        pstmt.setString(1,p.Name);
        ResultSet res = pstmt.executeQuery();
        if (res.next()) {
            System.out.println("请输入存款数额：");
            p.Change=sc.nextFloat();
            //执行sql1语句
            String sql1 = "UPDATE information set Balance=Balance+? where Name=?";//使原数值增加
            PreparedStatement pstmt1 = Connect.conn.prepareStatement(sql1);
            pstmt1.setFloat(1,p.Change);
            pstmt1.setString(2,p.Name);
            //执行sql2语句
            String sql2="INSERT INTO time VALUES(?,?,?)";
            PreparedStatement pstmt2=Connect.conn.prepareStatement(sql2);
            pstmt2.setString(1,p.Name);
            pstmt2.setFloat(2,+p.Change);
            pstmt2.setTimestamp(3,sql_date);

            pstmt1.execute();
            pstmt2.execute();
            System.out.println("存入成功！！！");
        }
        else {
            System.out.println("你的账号不存在或出现问题，请联系银行工作人员！");
        }
        pstmt.close();
        Connect.conn.close();


    }//Saving
    public void Withdrawal(Person p)throws SQLException{//支出
        connect.setConn();


        String sql = "Select * from information where Name = ?";
        PreparedStatement pstmt = Connect.conn.prepareStatement(sql);
        pstmt.setString(1,p.Name);
        ResultSet res = pstmt.executeQuery();
        if (res.next()) {
            System.out.println("请输入取款数额：");
            p.Change=sc.nextFloat();
            String sql1 = "UPDATE information set Balance=Balance-? where Name=?";//使原数值增加
            PreparedStatement pstmt1 = Connect.conn.prepareStatement(sql1);
            pstmt1.setFloat(1,p.Change);
            pstmt1.setString(2,p.Name);
            pstmt1.execute();

            String sql2="INSERT INTO time VALUES(?,?,?)";
            PreparedStatement pstmt2=Connect.conn.prepareStatement(sql2);
            pstmt2.setString(1,p.Name);
            pstmt2.setFloat(2,-p.Change);
            pstmt2.setTimestamp(3,sql_date);
            pstmt2.execute();

            System.out.println("取款成功！！！");
        }
        else {
            System.out.println("你的账号不存在或出现问题，请联系银行工作人员！");
        }
        pstmt.close();
        Connect.conn.close();

    }//Withdrawal

    public void Look(Person p)throws SQLException{
        connect.setConn();

        String sql = "Select * from information where Name = ?";
        PreparedStatement pstmt = Connect.conn.prepareStatement(sql);
        pstmt.setString(1,p.Name);
        ResultSet res = pstmt.executeQuery();
        if(res.next()) {
            String sql1 = "SELECT Balance FROM information WHERE  `Name`= ?";
            PreparedStatement pstmt1 = Connect.conn.prepareStatement(sql1);
            pstmt1.setString(1, p.Name);
            ResultSet res1 = pstmt1.executeQuery();
            if (res1.next()) {
                System.out.println("您的余额为" + res1.getFloat(1));

            } else {
                System.out.println("你的账户出现问题，请联系银行工作人员！！");

            }//else
        }

    }//Look

    public void CheckBill(Person p)throws SQLException{
        connect.setConn();
        String sql = "Select * from time where Name = ?";
        PreparedStatement pstmt = Connect.conn.prepareStatement(sql);
        pstmt.setString(1,p.Name);
        ResultSet res = pstmt.executeQuery();
        if(res.next())
        {
            do{
                String name=res.getString(1);
                float change= res.getFloat(2);
                Timestamp timestamp=res.getTimestamp(3);
                System.out.println("姓名："+name+" 金额："+change+" 时间："+timestamp);
            }while (res.next());//while
            }//if

        else {
            System.out.println("你的账单为空！！");
        }//else
    }//CheckBill
    
}
