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
public class NonMember extends Passenger{
    
public NonMember(String Name, int age){
super(Name,age);
}

public double applyDiscount(double p){

    if(super.getAge()>65){
    return (0.9*p);
    }
    else 
        return p;
    
}

}