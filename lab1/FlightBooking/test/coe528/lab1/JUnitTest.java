/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mohammad Maaz Khan
 */
public class JUnitTest {
    
    //Defining test flight object
    Flight test;
    
    @Before
    public void setUp() {
    
      test= new Flight(1030,10,1000,"toronto","vancouver","06/18/2020 10:30 pm");
      /*
      flight number= 1030
      capacity = 10
      ticket price= 1000
      origin=toronto
      destination =vancouver
      departure time= 06/18/2020 10:30 pm
      */
    
    }
    
    
  @Test
 
  public void testConstructor(){
   
    try{
     //public Flight(int flightnumber, int capacitygiven, double originalprice, String org, String destination, String departureTime) 
     System.out.println("\n \n testing 6 param constructor");
       Flight testA= new Flight(1030,10,1000.0,"Toronto","Vancouver","06/18/2020 10:30 pm");
       assertEquals(true,true);//ensuring that the constructor worked with no issues (as it should in this case)
    }
    catch (Exception e){
        System.out.println("Exception should not have thrown");//dealing with the exception, although it shouldn't throw
        fail();
       
        
    }
    }
   
 
 
 @Test
   public void testInvalidConstructor()
    {
       try{
        System.out.println("testing InvalidConstructor");
        Flight testError= new Flight(1030,10,1000.0,"Toronto","Toronto","06/10/2020 //10:30pm");
        System.out.println("Exception");//we are expecting an exception when the origin and destination are the same
        fail();
       }
       catch(IllegalArgumentException e){//catch functions
           System.out.println("Exception Detected");
                   assertEquals(1,1);
       }
    }
  
   /*
   Testing the GetFlightNumber Flight class method
   */
  @Test
  public void testGetFlightNumber(){
      int flightnum=test.getflightNumber();
      assertEquals(1030,flightnum);//1030 is the provided flightnumber
      System.out.println("GetFlightNumber works");
      
  }
   /*
   Testing the getCapacity Flight class method
   */
  @Test
  public void testGetCapacity(){
      int cap=test.getCapacity();
      assertEquals(10,cap);//10 is the assigned capacity 
      System.out.println("GetCapacity works");
      
  }
   /*
   Testing the getOriginalPrice Flight class method
   */
  @Test
  public void testGetOriginalPrice(){
      double oprice=test.getoriginalPrice();
      assertEquals(1000.00,oprice,0);//1000 is the price of the flight
      System.out.println("GetOriginalPrice works");
      
  }
   /*
   Testing the getOrigin Flight class method
   */
  @Test
  public void testGetOrigin(){
      String o=test.getOrigin();
      assertEquals("toronto",o);//the origin was toronto
      System.out.println("GetOrigin works");
      
  }
   /*
   Testing the getDestination Flight class method
   */
  @Test
  public void testGetDestination(){
      String dest=test.getdestination();
      assertEquals("vancouver",dest);//the destination was vancouver
      System.out.println("GetDestination works");
      
  }
   /*
   Testing the GetDepartureTime Flight class method
   */
  @Test
  public void testGetDepartureTime(){
      String dTime=test.getDepartureTime();
      assertEquals("06/18/2020 10:30 pm",dTime);//the departure time is as above
      System.out.println("GetDepartureTime works");
      
  }
   /*
   Testing the GetNumberOfSeatsLeft Flight class method
   */
  @Test
  public void testNumberOfSeatsLeft(){
      int seatsLeft=test.getNumberOfSeatsLeft();
      assertEquals(10,seatsLeft);//the number of seats initially is equal to the capacity. as tickets are booked, the number of seats left decrease
      System.out.println("GetNumberOfSeatsLeft works");
      
  }
   /*
  
   Testing the BookASeat Flight class method
   */
  @Test
  public void testBookASeat(){
      assertEquals(true,test.bookASeat());//bookASeat returns a boolean!!
      System.out.println("GetFlightNumber works");
      
  }
 
    public JUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
