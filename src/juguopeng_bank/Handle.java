package juguopeng_bank;
import java.sql.SQLException;
import java.util.Scanner;
public class Handle {
    public static Bank bb=new Bank();//引入Bank类
    public static tool tt=new tool();//引入tool类
    public static Identify iftrue=new Identify();


    public void Login() throws SQLException {//登录系统
        Scanner sc=new Scanner(System.in);

        boolean real=true;
        while (real)
        {
            System.out.println("————————————————————欢迎登入活期储蓄账目管理系统——————————————————————");
            System.out.println("1:开户\n"+"2:销户\n"+"3:存款\n"+"4:取款\n"+"5:查询余额\n"+"6:查询账单\n"+"7:退出");
            System.out.println("—————————————————————————————————————————————————————————————————");
            System.out.println("请输入你需要的业务序号：");
            int car=0;//记录序号
            car=sc.nextInt();
            switch (car){
                case 1:{//开户
                    Person p1=new Person();
                    System.out.println("请输入姓名：");
                    p1.Name=sc.next();
                    System.out.println("请输入密码：");
                    p1.password=sc.nextInt();
                    System.out.println("请输入身份证号码：");
                    p1.IDNumber=sc.next();
                    if(tt.IfYes(p1.IDNumber)==false)//如果不是十八位，进入if
                    {
                        while (!tt.IfYes(p1.IDNumber))//当为假时，退出循环
                        {
                            System.out.println("您输入的数值有误，请重写输入！");
                            System.out.println("请重新输入：");
                            p1.IDNumber= sc.next();
                        }
                    }
                    System.out.println("请输入手机号码：");
                    p1.PhoneNumber=sc.next();
                    if(tt.IfNo(p1.PhoneNumber)==false)//如果不是十八位，进入if
                    {
                        while (!tt.IfNo(p1.PhoneNumber))//当为假时，退出循环
                        {
                            System.out.println("您输入的数值有误，请重写输入！");
                            System.out.println("请重新输入：");
                            p1.PhoneNumber= sc.next();
                        }
                    }

                    p1.Balance=0;
                    p1.CountNumber=tt.GetRandom();//返回从10000000-99999999的账户号码
                    bb.OpenAccount(p1);
                    break;
                }//case1
                case 2:{//销户
                    Person p2=new Person();
                    System.out.println("请登录：");
                    System.out.println("请输入要销户的户主名：");
                    String name=sc.next();
                    System.out.println("请输入密码：");
                    int password= sc.nextInt();
                    p2.setPassword(password);
                    p2.setName(name);

                    if(iftrue.Identify(p2)){
                        bb.AccountCancellation(p2);
                        break;
                    }
                    else {
                        System.out.println("登陆错误，请重试！");
                        break;
                    }


                }//case2
                case 3:{//存入
                    Person p3=new Person();
                    System.out.println("请输入账户名称：");
                    p3.Name=sc.next();
                    System.out.println("请输入密码");
                    int password=sc.nextInt();
                    p3.setPassword(password);
                    if(iftrue.Identify(p3)){
                        bb.Saving(p3);
                        break;
                    }
                    else {
                        System.out.println("登陆错误，请重试！");
                        break;
                    }
                }//case3
                case 4:{//支出
                    Person p4=new Person();
                    System.out.println("请输入账户名称：");
                    p4.Name=sc.next();
                    System.out.println("请输入密码：");
                    int password=sc.nextInt();
                    p4.setPassword(password);


                    if(iftrue.Identify(p4)){
                        bb.Withdrawal(p4);
                        break;
                    }
                    else {
                        System.out.println("登陆错误，请重试！");
                        break;
                    }

                }//case4
                case 5:{
                    Person p5=new Person();
                    System.out.println("请输入账户姓名：");
                    p5.Name= sc.next();
                    System.out.println("请输入密码：");
                    p5.password= sc.nextInt();
                    if(iftrue.Identify(p5)){
                        bb.Look(p5);
                        break;
                    }
                    else {
                        System.out.println("登陆错误，请重试！");
                        break;
                    }
                }//case5
                case 6:{
                    Person p6=new Person();
                    System.out.println("请输入账户姓名：");
                    p6.Name= sc.next();
                    System.out.println("请输入密码：");
                    p6.password= sc.nextInt();
                    if(iftrue.Identify(p6)){
                        bb.CheckBill(p6);
                        break;
                    }
                    else {
                        System.out.println("登陆错误，请重试！");
                        break;
                    }


                }
                case 7:{
                    real=false;
                    System.out.println("已退出！");
                    break;
                }//case6
                default:{
                    System.out.println("输入错误，请重新尝试");
                    break;
                }//default

            }//Switch

        }//while

    }//Login




}
