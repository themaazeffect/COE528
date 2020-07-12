/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;
import java.util.ArrayList;
/**
 *
 * @author Mohammad Maaz Khan  500771068
 */
public class Manager {
    
       
  
   private int index=0;
   ArrayList<Flight> list = new ArrayList<Flight>();
   static ArrayList<Ticket> ticketlist= new ArrayList<Ticket>();
   
   /*
   This method generates a predetermined list of flights. 
   Assuming that all we needed to do is show that the methods and code work.
   In actuality this method would include user inputs/read from a file
   containing the necessary data.
   */
    public void createFlights(){
    
        //public Flight(int flightnumber, int capacitygiven, double originalprice, String org, String destination, String departureTime)
       list.add(new Flight(01,10,1000,"Toronto","Vancouver","06/20/2020 10:30pm")) ;
       list.add(new Flight(02,10,800,"Toronto","Edmonton","06/20/2020 10:30am"));
       list.add(new Flight(03,10,1000,"Toronto","Victoria","06/18/2020 12:30pm"));
       list.add(new Flight(04,14,100,"Winnipeg","Vancouver","06/20/2020 1:30pm")) ;
       list.add(new Flight(05,10,1000,"Toronto","Winnipeg","06/20/2020 10:30am"));
       list.add(new Flight(06,20,500,"London","Victoria","06/18/2020 2:30pm"));
       list.add(new Flight(7,11,1000,"Windsor","Vancouver","06/20/2020 10:30pm")) ;
       list.add(new Flight(8,19,9000,"Toronto","Kamloops","06/20/2020 1:30am"));
       list.add(new Flight(9,7,1000,"Toronto","Tokyo","06/18/2020 12:30pm"));
       
       for(int i=0; i<list.size(); i++){
           System.out.println(list.get(i).toString());
           
       }
       

   
  
    }
    /*
    displayavailableflight method shows all the flights provided an origin and a destination. If there are no matching flights, it prints out a message 
    */
    public void displayAvailableFlights(String origin, String destination){
        Flight temp=null;
    for(int i=0; i<list.size();i++){
        if(((list.get(i).getdestination()).equals(destination))&&((list.get(i).getOrigin()).equals(origin))&&(list.get(i).getNumberOfSeatsLeft()!=0)){
        temp=list.get(i);
        }
    }
    if(temp!=null){
        System.out.println(temp.toString());
    }
    else
        System.out.println("No matching flight");
        
    
    }
    /*
    returns the flight associated with a provided flight number, assuming there is a flight number otherwise it returns null
    */
    public Flight getFlight(int flightNumber){
    
        for(int i=0; i<list.size();i++){
        if((list.get(i).getflightNumber())==(flightNumber))
            return list.get(i);
        }
       return null; 
    }
    /*
    class meant to book seats, books seat given that the temp flight object is not null after parsing through the list of flights. Books a seat and generates a ticket for passenger p
    */
    public void bookSeat(int flightNumber, Passenger p){
    
        Flight temp= null;
        
        for(int i =0; i<list.size();i++){
            if(list.get(i).getflightNumber()==flightNumber)
               temp=list.get(i);
            
        }
        if(temp!=null){
            
            if((temp.bookASeat()==true)){
                ticketlist.add(new Ticket(p,temp,temp.getoriginalPrice()));
                (ticketlist.get(index)).setPrice(p.applyDiscount(temp.getoriginalPrice()));
                System.out.println(ticketlist.get(index).toString());
                index++; 
            
            }
            
        }
        else{
        System.out.println("No Flight for provided flight number");
        }
        
    
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
              System.out.println("\nStudent Name:Mohammad Maaz Khan\nStudent Number:500771068\nFlight Booking System - COE528 Lab 1\n\n"); 
        
        Passenger p= new Member(22,"Maaz Khan", 6); //member with big discount
        Passenger q= new NonMember("Mohammad",66);//Senior non member passenger
        Passenger r= new Member(28,"Khan",2);//passenger who is a member(1-3 yrs), 10% discount
        Manager m= new Manager();
        System.out.println("Generating Flights now:\n");
        m.createFlights();
              
        System.out.println("\nAvailable Flights Provided Origin+Destination:");
        System.out.println("\n Provided: Toronto (origin), Vancouver(destination)");
        m.displayAvailableFlights("Toronto","Victoria");
        System.out.println("\n Provided: Winnipeg (origin), Vancouver(destination)");
        m.displayAvailableFlights("Winnipeg","Vancouver");
        System.out.println("\n Provided: Toronto (origin), Karachi(destination)");
        m.displayAvailableFlights("Toronto","Karachi");
        System.out.println();
        System.out.println("Provided Flight #1 : "+m.getFlight(01));
        System.out.println();
        System.out.println("Provided Flight #8 : "+m.getFlight(8));
        System.out.println();
        System.out.println("Provided Flight #4 : "+m.getFlight(4));
        System.out.println();
        System.out.println("Booking for Member:");
        m.bookSeat(01,p);
        System.out.println();
        System.out.println("Booking for Non-Member (over 65 yrs):");
        m.bookSeat(03,q);
        System.out.println("\nBooking for Member (1-3 yrs):");
        m.bookSeat(8,r);
        
        System.out.println("\n\nShowing the tickets booked as of now, along with each unique ID generated for each ticket in the Ticket Class:");
        for (Ticket i: ticketlist){
            System.out.println(i.toString());
            System.out.println("ticket ID : "+i.getID());//parsing through this list allows us to see all the ID's generated as we booked our seats
        }
        
       
        

    }
    
}
