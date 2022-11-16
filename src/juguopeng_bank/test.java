package juguopeng_bank;

import juguopeng_bank.Bank;
import juguopeng_bank.Handle;

import java.sql.SQLException;

public class test {
    public static Bank bank=new Bank();
    public static void main(String[]args) throws SQLException, ClassNotFoundException {
        //登录主程序
        Handle handle=new Handle();
        handle.Login();

        }//main
}
