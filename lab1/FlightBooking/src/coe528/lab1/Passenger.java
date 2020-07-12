/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 *
 * @author Mohammad Maaz Khan  500771068
 */
public abstract class Passenger {
    private String name;
    private int age;
    
public Passenger (String name, int age){
    this.name=name;
    this.age=age;
    
}
 
public  Passenger(){
this.name=" ";
this.age=0;

}    
public int getAge(){
    return this.age;
}
public void setAge(int age){
this.age=age;
}
public String getName(){
return this.name;
}
public void setName(String name){
this.name=name;
}

public abstract double applyDiscount(double p);

 
}
