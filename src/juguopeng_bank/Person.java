package juguopeng_bank;

public class Person {
    public String Name;
    public String IDNumber;
    public  String CountNumber;
    public String PhoneNumber;
    public float Balance;
    public float Change;
    public int password;

    Person(){}
    Person(String name,String IDNumber,String CountNumber,String PhoneNumber)//
    {
        this.Name=name;
        this.IDNumber=IDNumber;
        this.CountNumber=CountNumber;
        this.PhoneNumber=PhoneNumber;
    }
    public void setName(String name)
    {
        this.Name=name;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public void setCountNumber(String countNumber) {
        CountNumber = countNumber;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
