/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.S2020.project;

/**
 *
 * @author User
 */
public class Person {
    private String name;
   private String user;
   private String pass;

   
public Person(String name, String user, String password){
    this.name=name;
    this.user=user;
    this.pass=password;

}
public Person(){
    this.name="customer";
    this.user=null;
    this.pass=null;
    
}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
   
}
