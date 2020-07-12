/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 *
 * @author Mohammad Maaz Khan 500771068
 */
public class Member  extends Passenger{
    
    private int yearsOfMembership; 
    
public Member(int age, String name, int yearsOfMembership){
    super(name,age);
    this.yearsOfMembership=yearsOfMembership;
    
}
    
    public double applyDiscount(double p){

        if(this.yearsOfMembership>5){
        return (p/2);
        }
        else if((this.yearsOfMembership>1)&&(this.yearsOfMembership<=5)){
        return (0.9*p);
        }
        else
            return p;
    }
  
public void setYearsOfMembership(int a){
this.yearsOfMembership=a;
}
public int getYearsOfMembership(){
return this.yearsOfMembership;}

}
