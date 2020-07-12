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
public class Ticket {
    
    Passenger p;
    Flight flight = new Flight();
    private double price; 
    private static int number=1;
    private int id =0;
    
    public Ticket(Passenger p, Flight flight, double price){
        this.flight=flight;
        this.price=price;
        this.p=p;
        id=number++;
       
     
  
    }
    
    public Passenger getPassenger(){
    return this.p;
    }
    public void setPassenger(Passenger p){
    this.p=p;
    }
    public Flight getFlight(){
    return this.flight;
    }
    public void setFlight(Flight flight){
    this.flight=flight;
    }
    public double getPrice(){
    return this.price;
    }
    public void setPrice(double price){
    this.price=price;
    }
    public int getID(){
    return id;
    }
   
    @Override
    public String toString(){
    return p.getName()+", Flight "+flight.getflightNumber()+" "+flight.getOrigin()+" to "+flight.getdestination()+", "+flight.getDepartureTime()+", original price: "+flight.getoriginalPrice()+"$, ticket price: $"+this.getPrice();
    
    }
    
    
    
}
