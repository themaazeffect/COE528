/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.S2020.project;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Manager extends Person {
    private final int floors=3;
    private final int spots=5;
    private LotFloor[] parkingFloors= new LotFloor[floors];
    private  ArrayList<Customer> customerList= new ArrayList<>();
    
public Manager(String name,String user, String pass){
super(name,user,pass);
for(int i =0; i<floors;i++){
    parkingFloors[i]=new LotFloor(i+1);
}

}
public void newCustomer(Customer c){
this.customerList.add(c);
}
public void removeCustomer(Customer c ){
for(Customer m: customerList){
    if(m.getCustomerNumber()==c.getCustomerNumber()){
    m.getTicket().getSpot().setIsUsed(false);
    customerList.remove(m);
    }
}
}
public void updateCustomer(Customer c){
for(Customer m: customerList){
    if(m.getCustomerNumber()==c.getCustomerNumber()){
    customerList.set(customerList.indexOf(m),c);
    
    }
}
}
public void DeleteFile(Customer c ){
    for(Customer m: customerList){
    if(m.getCustomerNumber()==c.getCustomerNumber()){
        try{
           if(m.getTicket().getTicketFile().delete()){
           System.out.println("deleted");
           }
           else{
           System.out.println("Error");}
           
        }
        catch(Exception e){
        e.printStackTrace();
        }
    m.getTicket().getSpot().setTicket(null);//clears the parking spot of a ticket and resets its state
    
    }
    }
}
public void modifyPrice(Customer c,double p){
    for(Customer m: customerList){
    if(m.getCustomerNumber()==c.getCustomerNumber()){
        m.getTicket().setPrice(p);
    }
    
    }
}
 public void payTicket(Customer c){
    for(Customer m: customerList){
    if(m.getCustomerNumber()==c.getCustomerNumber()){
    m.payTicket();
    }
}
    }
public Customer getSpecificCustomer(Customer c){
for(Customer m: customerList){
    if(m.getCustomerNumber()==c.getCustomerNumber()){
        return m;
    }
    
    }
    return null;
}
public Customer getSpecificCustomer(int c){
for(Customer m: customerList){
    if(m.getCustomerNumber()==c){
        return m;
    }
    
    }
return null;
}
    public LotFloor[] getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(LotFloor[] parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public  ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    //public  void setCustomerList(ArrayList<Customer> customerList) {
     //   Manager.customerList = customerList;
   // }
    
/*public static void main(String[] args) {
//This is just for testing purposes.
Manager man= new Manager("manager","user","pass"); 

ParkingTicket p;
Customer c= new Customer();
p=new ParkingTicket("Sedan",c,man.getParkingFloors()[0].getParkingSpot(4));//means the first floor and the fifth spot on the floor which is an electric spot
System.out.println("The Floor Number is : "+man.getParkingFloors()[0].getFloorNumber());//this is to show you what floor we're talking about
c.setTicket(p);
p.setCustomer(c);
p.WriteToFile(p.getTicketFile());
System.out.println(c.getTicket().getPrice());
man.newCustomer(c);//adding the customer to the managers master list
man.payTicket(c);//using the manager to pay the ticket
man.updateCustomer(c);//update the customer since he/she paid
p.WriteToFile(p.getTicketFile());

//Since we have paid for the ticket, the spot is now empty, let us try to book a new ticket on the same spot. You can view the files created side by side to see the similarities.
ParkingTicket q;
Customer b = new Customer();
q=new ParkingTicket("Sedan",c,man.getParkingFloors()[0].getParkingSpot(4));//using the same spot as before
b.setTicket(q);
q.setCustomer(b);
man.newCustomer(b);//this customer should be customer #1, the last was customer#0
//this time the customer has not paid yet, so the is paid flag remains false and the spot is NOT empty
man.getSpecificCustomer(b).getTicket().WriteToFile(man.getSpecificCustomer(b).getTicket().getTicketFile());

}    
    */
}
