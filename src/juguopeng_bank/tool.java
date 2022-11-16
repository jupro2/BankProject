package juguopeng_bank;

public class tool {
    public String GetRandom()//返回
    {
        int min=10000000;
        int max=99999999;
       int s = min + (int) (Math.random() * (max - min));
       String ss=String.valueOf(s);
       return  ss;
    }
    public boolean IfYes(String s)//判断身份证数值
    {
        if(s.length()!=18)
        {
            return false;
        }
        return true;
    }
    public boolean IfNo(String s)//判断手机号数值
    {
        if(s.length()!=11)
        {
            return false;
        }
        return true;
    }
}
