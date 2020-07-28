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
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ParkingTicket {
    private long id; 
    private double price;
    private boolean customerPaid;
    private String carType;
    private Customer customer;
    private ParkingSpot spot;
    private static ArrayList<Long> idHolder= new ArrayList<Long>();
    private File ticketFile;
    private int timeSpent;
   

  
public ParkingTicket( String carType, Customer customer,ParkingSpot parking){
    this.carType=carType;
    this.customer=customer;
   this.spot=parking;
   Boolean flag=true;
   while(flag==true){
     this.id= (long)(Math.random()*1000000000 + 1000000000L);
     if(idHolder.contains(this.id)){
     flag=true;
     }
     else{
     flag=false;
     idHolder.add(this.id);
     }
   }
   this.ticketFile=createFile();
   Random rand= new Random();
   this.timeSpent= rand.nextInt(11)+1;
   this.price=calcPrice();
   spot.setIsUsed(true);
   WriteToFile(this.ticketFile);
}

public File createFile(){
    File t;
    try {
      t = new File(this.getId()+".txt");
      if (t.createNewFile()) {
        return t;
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return null;
}
public void WriteToFile(File f){
   try {
      FileWriter w = new FileWriter(f);
      w.write(this.toString());
      w.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
}
  public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }
    
public double calcPrice(){
    double temp=0;
    if(this.timeSpent==1){
        temp=4.0;
    }
    else if(this.timeSpent==2){
        temp=4.0+3.5;
    }
    else if (this.timeSpent==3){
        temp=4.0+7.0;
    }
    else if (this.timeSpent>3){
        temp= (4.0+7.0+(this.timeSpent-3)*2.5);
    }
    if(this.getSpot().getParkingType().equalsIgnoreCase("Electric")){
        temp+=this.getTimeSpent()*0.35;//rate for electricity/hour
    }
    return temp;
   
}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCustomerPaid() {
        return customerPaid;
    }

    public void setCustomerPaid(boolean customerPaid) {
        this.customerPaid = customerPaid;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
    }

    public static ArrayList<Long> getIdHolder() {
        return idHolder;
    }


    public File getTicketFile() {
        return ticketFile;
    }

    public void setTicketFile(File ticketFile) {
        this.ticketFile = ticketFile;
    }
@Override
public String toString(){
return ("Ticket Number: "+this.getId()+
        "\r\n"+"Customer Number: "+this.customer.getCustomerNumber()+  
        "\r\n"+"Parking Spot Type: "+this.getSpot().getParkingType()+
        "\r\n"+"Vehicle Type: "+this.getCarType()+
        "\r\n"+"Time Spent In Lot: "+this.timeSpent+
        "\r\n"+"Total Cost: "+this.price+
        "\r\n"+"Paid?: "+this.isCustomerPaid()+
        "\r\n"+"Is Spot Used?: "+this.getSpot().getIsUsed()
        );
}

}