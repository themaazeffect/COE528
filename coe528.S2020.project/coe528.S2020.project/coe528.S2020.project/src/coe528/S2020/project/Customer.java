/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.S2020.project;
import java.awt.Desktop;
import java.io.File;  
import java.io.IOException;

/**
 *
 * @author User
 */
public class Customer extends Person{
    private static int counter=0;
    private int customerNumber;
    private ParkingTicket ticket;
    
public Customer(){
        super();
        this.customerNumber = getCounter();
        counter++;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber() {
        this.customerNumber = counter;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }

    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
    public void payTicket(){
    this.ticket.setCustomerPaid(true);
    this.getTicket().getSpot().setIsUsed(false);
        
    }
    public void openFile(){
    try  
{  
//constructor of file class having file as argument  
File file= this.ticket.getTicketFile();
if(!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
{  
System.out.println("not supported");  
return;  
}  
Desktop desktop = Desktop.getDesktop();  
if(file.exists())         //checks file exists or not  
desktop.open(file);              //opens the specified file  
}  
catch(Exception e)  
{  
e.printStackTrace();  
}  
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Customer.counter = counter;
    }
    
}
