package com.hspedu.Encap;

public class TestAccess {
    static void main(String[] args) {
        Account account = new Account("何以味mama",4.0,"mimalddl");
         String str = account.info();
        System.out.println(str);



    }
}
