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
public class Flight {
    
    private int flightNumber, capacity, numberOfSeatsLeft;
   private String origin, destination, departureTime;
    private double originalPrice; 
    
    public Flight(){
    }
    
    public Flight(int flightnumber, int capacitygiven, double originalprice, String org, String destination, String departureTime){
        this.flightNumber=flightnumber;
        this.capacity=capacitygiven;
        this.originalPrice=originalprice; 
        this.origin=org;
        this.destination=destination;
        this.departureTime=departureTime;
        setNumberOfSeatsLeft(capacitygiven);
        
        if(org.equals(destination)){
        throw new IllegalArgumentException("destination can't be the same as origin");}
}
 
    public int getflightNumber(){
    return this.flightNumber;
    }
    public void setflightNumber(int flightNumber){
    this.flightNumber=flightNumber;
    }
   
    public int getCapacity(){
    return this.capacity;
    }
    
    public void setCapacity(int capacity){
    this.capacity=capacity;
    }
    public double getoriginalPrice(){
    return this.originalPrice;
    }
    public void setoriginalPrice(double originalPrice){
        this.originalPrice=originalPrice;
    }
    public String getOrigin(){
        return this.origin;
    }
    public void setOrigin(String origin){
    this.origin=origin;
    }
    public String getdestination(){
    
    return this.destination;
    
    }
    public void setdestination(String destination){
    this.destination=destination;
    }
    public String getDepartureTime(){
    return this.departureTime;
    }
    public void setDepartureTime(String departureTime){
    this.departureTime=departureTime;
    }
    public int getNumberOfSeatsLeft(){
    return this.numberOfSeatsLeft;
    }
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft){
    this.numberOfSeatsLeft=numberOfSeatsLeft;
    }
    
   public boolean bookASeat() {
      if(this.numberOfSeatsLeft>0){
          this.numberOfSeatsLeft--;
          return true;
      }
      return false;
   }
   
   
   @Override
    public String toString(){
    return "Flight "+this.flightNumber+" "+this.origin+" to "+this.destination+", "+departureTime+", "+this.originalPrice+"$";}
}

