/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.S2020.project;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author User
 */
public class FinalInterface extends Application {
    Stage lot; 
    Button Entry1, Entry2,Entry3,Entry4,Exit1,Exit2,Exit3,Exit4;
    Button infoPortal,managerButton; 
    Scene level1,customerPortal,customerPortal2,customerPortal3, payment1,payment2,payment3, thankYou,scene2,scene3,scene5,scene4;
    GridPane DisplayBox,b;
    private Spinner floorNumber;
    private int currentfloor=0; int i,index;
    GridPane grid2;
    Manager m= new Manager("manager","admin","admin");
    
   public void floor0(){
        b= new GridPane();
      Entry1= new Button("Entry Point 1");
         Entry2 = new Button("Entry Point 2 ");
        
        
         Exit1= new Button("Exit Point 1");
         Exit2 = new Button("Exit Point 2 ");
infoPortal= new Button("Info Portal");
        managerButton= new Button("Manager Login");
        Label floorLabel= new Label("Floor: ");
        
       //VBox entryLevel1= new VBox(20);
        //VBox exitLevel1= new VBox(20);
         DisplayBox= new GridPane();
        DisplayBox.setHgap(10);
        
         
        b.setAlignment(Pos.TOP_LEFT);
        b.setVgap(20);
        b.setHgap(20);
        b.add(floorLabel,0,0);
        b.add(floorNumber,1,0);
        b.add(Entry1,0,6);
        b.add(Entry2,0,30);
        b.add(Exit1,30,6);
        b.add(Exit2,30,30);
        b.add(infoPortal,30,15);
        b.add(managerButton,0,15);
        b.add(DisplayBox,15,15);
        
        level1= new Scene(b,400,400);
        
        Entry1.setOnAction(e-> {
            CustomerInterface1();
        });
        Entry2.setOnAction(e-> {
            CustomerInterface1();
        });
        Exit1.setOnAction(e-> {
            PaymentSetterUpper();
        });
        Exit2.setOnAction(e-> {
            PaymentSetterUpper();
        });
        
        lot.setScene(level1);
        lot.show();
         
        managerButton.setOnAction(e-> {
            managerRole();
       
        });
        infoPortal.setOnAction(e-> {
            
            GridPane g= new GridPane();
            Label l1= new Label("Welcome to the Info Portal. You can pay for your ticket here.");
            Button butt= new Button("Pay Ticket");
            g.add(l1,0,0);g.add(butt,0,1);
            Scene info= new Scene(g,400,400);
            lot.setScene(info);
            
            butt.setOnAction(ex->
            
            {
                PaymentSetterUpper();});
        });
        
floorNumber.valueProperty().addListener((observable,oldvalue,newValue)->{
            int temp = (Integer) newValue;    
            this.currentfloor= (Integer) newValue;
             
            
            
            switch (this.currentfloor) {
                case 0:
                    floor0();
                    setUpDisplayBox(temp,DisplayBox);
                    break;
                case 1:
                    floor1();
                    setUpDisplayBox(temp,DisplayBox);
                    break;
                case 2:
                    floor2();
                    setUpDisplayBox(temp,DisplayBox);
                    break;
                default:
                    break;
            }
           
                      
         });
   
   }
   public void floor1(){
     b.getChildren().clear();
 Entry3= new Button("Entry Point 3");
 Exit3= new Button("Exit Point 3");
infoPortal= new Button("Info Portal");
        managerButton= new Button("Manager Login");
        Label floorLabel= new Label("Floor: ");
        //VBox entryLevel1= new VBox(20);
        //VBox exitLevel1= new VBox(20);
         DisplayBox= new GridPane();
        DisplayBox.setHgap(10);
 
        b.add(floorLabel,0,0);
        b.add(floorNumber,1,0);
        b.add(Entry3,0,6);
        b.add(Exit3,30,30);
        b.add(infoPortal,30,15);
        b.add(managerButton,0,15);
        b.add(DisplayBox,15,15);
        
        //level1= new Scene(b,600,600);
        
       
        Entry3.setOnAction(e-> {
            CustomerInterface1();
        });
        Exit3.setOnAction(e-> {
            PaymentSetterUpper();
        });
        
        lot.setScene(level1);
        lot.show();
         
        managerButton.setOnAction(e-> {
            managerRole();
       
        });
        infoPortal.setOnAction(e-> {
            
            GridPane g= new GridPane();
            Label l1= new Label("Welcome to the Info Portal. You can pay for your ticket here.");
            Button butt= new Button("Pay Ticket");
            g.add(l1,0,0);g.add(butt,0,1);
            Scene info= new Scene(g,400,400);
            lot.setScene(info);
            
            butt.setOnAction(ex->
            
            {
                PaymentSetterUpper();});
        });
        

   }
   public void floor2(){
    
     b.getChildren().clear();
 Entry4 = new Button("Entry Point 4 ");
 Exit4 = new Button("Exit Point 4 ");
infoPortal= new Button("Info Portal");
        managerButton= new Button("Manager Login");
        Label floorLabel= new Label("Floor: ");
        //VBox entryLevel1= new VBox(20);
        //VBox exitLevel1= new VBox(20);
         DisplayBox= new GridPane();
        DisplayBox.setHgap(10);
        b.add(floorLabel,0,0);
        b.add(floorNumber,1,0);
        b.add(Entry4,0,6);
        b.add(Exit4,30,30);
        b.add(infoPortal,30,15);
        b.add(managerButton,0,15);
        b.add(DisplayBox,15,15);
        //level1= new Scene(b,600,600);
     
       
        Entry4.setOnAction(e-> {
            CustomerInterface1();
        });
        Exit4.setOnAction(e-> {
            PaymentSetterUpper();
        });
        
        lot.setScene(level1);
        lot.show();
         
        managerButton.setOnAction(e-> {
            managerRole();
       
        });
infoPortal.setOnAction(e-> {
            
            GridPane g= new GridPane();
            Label l1= new Label("Welcome to the Info Portal. You can pay for your ticket here.");
            Button butt= new Button("Pay Ticket");
            g.add(l1,0,0);g.add(butt,0,1);
            Scene info= new Scene(g,400,400);
            lot.setScene(info);
            
            butt.setOnAction(ex->
            
            {
                PaymentSetterUpper();});
        });
        
        
   }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        floorNumber= new Spinner(0,2,0);
        lot= primaryStage; 
        
      floor0();
 
        
        
  
      
        
    }
    public void managerRole(){
    
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10));
         
        Label lblUser = new Label("Username");
        grid.add(lblUser, 0, 1);
        
        TextField txtUser = new TextField();
        txtUser.setPromptText("username");
        grid.add(txtUser, 1, 1);
 
        Label lblPass = new Label("Password");
        grid.add(lblPass, 0, 2);
        
        PasswordField pwBox = new PasswordField();
        pwBox.setPromptText("password");
        grid.add(pwBox, 1, 2);
        
        Label label3 = new Label("Error. Wrong password and/or username");
          
        Button loginBtn = new Button("Login");
        grid.add(loginBtn, 1, 3);
        scene2 = new Scene(grid, 600, 600);
        lot.setScene(scene2);
        lot.show();
        
        loginBtn.setOnAction(ex->{
            if(authenticate(txtUser,pwBox)==true){
            lot.setScene(scene3);
            //If Login info is right
        grid2=new GridPane();
     grid2.setAlignment(Pos.CENTER);
        grid2.setVgap(10);
        grid2.setHgap(10);
        grid2.setPadding(new Insets(10));  
       
        grid2.setGridLinesVisible(false);    //Delete After -> for layout purposes only 
        
        Text options = new Text("Managerial Functions: ");
        options.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        grid2.add(options,0,0);
        /*
        Manager can:
        -Logout
        -View Tickets->  modify tickets
                         delete tickets
        */
        Button logout = new Button("exit to main screen");
        grid2.add(logout,3,5);
        
        logout.setOnAction(p-> {
         lot.close();
                try {
                    new FinalInterface(m).start(lot);
                } catch (Exception ex1) {
                    Logger.getLogger(FinalInterface.class.getName()).log(Level.SEVERE, null, ex1);
                }
       });
      
       Button viewTickets = new Button("Edit Tickets");
       Button addCustomer= new Button("Create a Ticket");
       grid2.add(addCustomer,0,4);
       grid2.add(viewTickets,0,2);
       
       scene3= new Scene(grid2,400,400);
       lot.setScene(scene3);
       lot.show();
       GridPane grid3 = new GridPane(); //For ticket view screen
       scene4 = new Scene(grid3,600,600); //For ticket view screen
       
       grid3.setAlignment(Pos.CENTER);
       grid3.setVgap(10);
       grid3.setHgap(10);
       grid3.setPadding(new Insets(10));  
      
      addCustomer.setOnAction(e-> CustomerInterface1());
      
      viewTickets.setOnAction(event ->{
           lot.setScene(scene4);         //Goto new screen
         });
       
      //View/Edit Tickets screen
      Text editTickets = new Text("Edit Tickets:");
      editTickets.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
      grid3.add(editTickets,0,0);
      
      Label ticketSelect = new Label("Select Customer No. : ");
      Label vehicleSelect = new Label("Select new Vehicle: ");
      Label priceChange = new Label("Change Price:");
      Label error= new Label("Please do not leave any field blank");
       TextField price = new TextField();
       price.setPromptText("Price");
      
        
      ComboBox tickets = new ComboBox();
      for (int j=0; j<m.getCustomerList().size();j++){
         tickets.getItems().add(2*j+1);
      }
     grid3.add(ticketSelect,0,2); 
     grid3.add(vehicleSelect,0,4);  
     grid3.add(priceChange,0,5);
     
     ComboBox floorNo = new ComboBox();
     floorNo.getItems().addAll(
             1,
             2,
             3
     );
     ComboBox vehicle = new ComboBox();
     vehicle.getItems().addAll(
                "Compact",
                "Large",
                "Handicapped",
                "Motorcycle",
                "Electric"
     );
       grid3.add(tickets,2,2);
       grid3.add(vehicle, 2, 4);
       grid3.add(price,2,5);
       Button update = new Button("Update Ticket");
       grid3.add(update,3,6);
          
       update.setOnAction(event ->{
          //Read corresponding file
          //change selected values
        if(tickets.getValue()==null||vehicle.getValue()==null||price.getText()==null){
            grid3.add(error,0,20);
            
        }
        else{
          int custEdit = (Integer) tickets.getValue();
         String carEdit = (String) vehicle.getValue();
         double priceEdit2 = Double.parseDouble(price.getText());
         
      Customer edit = m.getSpecificCustomer(custEdit);     
      ParkingTicket tickEdit = m.getSpecificCustomer(edit).getTicket();
      //Update Vehicle
       tickEdit.setCarType(carEdit);    
       //Update Price
       
       tickEdit.setPrice(priceEdit2);
       
       m.updateCustomer(edit);
       tickEdit.WriteToFile(tickEdit.getTicketFile()); //Will Change the file
      //check if when changing, the data is wiped
      lot.close();
         Platform.runLater(()-> {
             try {
                 new FinalInterface(m).start(new Stage());
                 
             } catch (Exception e) {
                 Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, e);
             }
         }); 
       }});
       
       Button deleteTickets = new Button ("Delete Tickets");
       grid2.add(deleteTickets,0,3);
       
      
       
       GridPane grid4 = new GridPane(); //For ticket deletion screen
       scene5 = new Scene(grid4,600,600); //For ticket deletion screen
       
        deleteTickets.setOnAction(event ->{
           lot.setScene(scene5);
             });
        
       grid4.setAlignment(Pos.CENTER);
       grid4.setVgap(10);
       grid4.setHgap(10);
       grid4.setPadding(new Insets(10));  
     
       //Delete Tickets screen
      Text delTick = new Text("Delete Tickets:");
      delTick.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
      Label ticketSelect2 = new Label("Select Ticket via Customer No. : ");
       
      grid4.add(delTick,0 ,0);
      grid4.add(ticketSelect2,0,2); 
     
      ComboBox tickets2 = new ComboBox();
      for (int k=0; k<m.getCustomerList().size();k++){
         tickets2.getItems().add(2*k + 1);
      }
      grid4.add(tickets2, 2,2);
      
      Button delete = new Button("Delete");
      grid4.add(delete,3,2);
      Label l= new Label("Select an Appropriate Customer");
     
     //When deleting
     delete.setOnAction(event ->{
         if(tickets2.getValue()==null){
          grid4.add(l,0,20) ;  
         }
         else{
     int custDel = (Integer) tickets2.getValue();
     
      Customer del = m.getSpecificCustomer(custDel);     
           if(del.getCustomerNumber() == custDel){
            
            //Remove file of removed customer
             m.DeleteFile(del);
             //check if when changing, the data is wiped
      lot.close();
         Platform.runLater(()-> {
             try {
                 new FinalInterface(m).start(new Stage());
                 
             } catch (Exception e) {
                 Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, e);
             }
         }); 
             
         }
         } 
      });
            
            }
            else{
            lot.setScene(scene2);
            lot.show();
            grid.add(label3, 0, 5);
            System.out.println("wrong pass");
          
            managerRole();
            }
            });
            
     
     }
    public void PaymentSetterUpper(){
    GridPane payment= new GridPane();
    payment.setAlignment(Pos.CENTER);
    Label intro= new Label("Payment Required");
    Label errorYo= new Label("please enter a valid Customer Number");
    Label maaz= new Label("Please Enter your Customer Number: ");
    TextField khan = new TextField();
    Button ha= new Button("OK");
    payment.add(intro,0,0);
    payment.add(maaz, 0, 1);
    payment.add(khan,0,2);
    payment.add(ha,0,4);
    ha.setOnAction(e-> {
        Boolean flag=false;
        for(Customer m :m.getCustomerList()){
        if(m.getCustomerNumber()==Integer.parseInt(khan.getText()))
            flag=true;
        }
        
        if(flag==false||khan.getText()==null){
            System.out.println("invalid customer number");
            payment.add(errorYo,0,16);
            
        }
        else{
        PaymentAccepter(Integer.parseInt(khan.getText()));
        }});
    payment1= new Scene(payment,400,400);
    lot.setScene(payment1);
    lot.show();
    
    }
    public void PaymentAccepter(int i){
        GridPane physicalPain= new GridPane();
        physicalPain.setAlignment(Pos.CENTER);
        Label mmk= new Label("Ticket Info:\r\n"+m.getSpecificCustomer(i).getTicket().toString());
        Button cash= new Button("Pay with Cash");
        Button credit = new Button("Pay with Credit");
        physicalPain.add(mmk,0,0);
        physicalPain.add(cash,0,8);
        physicalPain.add(credit,0,10);
        cash.setOnAction(e-> {
             PaymentFinalScreen(m.getSpecificCustomer(i).getTicket().getPrice());                m.getSpecificCustomer(i).payTicket();
        m.updateCustomer(m.getSpecificCustomer(i));
        m.getSpecificCustomer(i).getTicket().WriteToFile(m.getSpecificCustomer(i).getTicket().getTicketFile());
        });
        credit.setOnAction(e-> {
        PaymentFinalScreen(m.getSpecificCustomer(i).getTicket().getPrice());                m.getSpecificCustomer(i).payTicket();
        m.updateCustomer(m.getSpecificCustomer(i));
        m.getSpecificCustomer(i).getTicket().WriteToFile(m.getSpecificCustomer(i).getTicket().getTicketFile());

        });
        payment2= new Scene(physicalPain,400,400);
        lot.setScene(payment2);
        lot.show();
    }
    public void PaymentFinalScreen(double i ){
    GridPane g= new GridPane();
    g.setAlignment(Pos.CENTER);
    Label l= new Label("Thank you! You paid: "+ i);
    Button b= new Button("Back to Main Screen");
    g.add(l,0,0);
    g.add(b,0,5);
    b.setOnAction(e-> {
    lot.hide();
        Platform.runLater(()-> {
            try {
                new FinalInterface(m).start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(FinalInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    });
    
    payment3= new Scene(g,400,400);
    lot.setScene(payment3);
    lot.show();
    }
    
    public void setUpDisplayBox(int num,GridPane db){
        db.getChildren().clear();
        Label l1= new Label("Car Type");
        Label l3= new Label("Spot Empty?");
        db.add(l1,0,0);
        db.add(l3,0,1);
        for(int i=0;i<5;i++){
        Label l = new Label(this.m.getParkingFloors()[num].getParkingSpot(i).getParkingType());
        Label l2 = new Label(Boolean.toString(this.m.getParkingFloors()[num].getParkingSpot(i).getIsUsed()));
        
            db.add(l,i+1,0);
            db.add(l2,i+1,1);
                
                }
    }
    public void handleEntryPoints(){
       //customerPortal= new Scene(CustomerInterface1(),600,600);
       
    }
    public void CustomerInterface1(){
     
  
    GridPane customer = new GridPane();
    customer.setAlignment(Pos.CENTER);
    Label fullParking= new Label("This Floor is currently Full");
    Button returner= new Button("return");
    customer.setAlignment(Pos.CENTER);
    customer.setVgap(10); customer.setHgap(10);
    Label message = new Label("Welcome to the Parking Lot");
    Button createTicket= new Button("Create a Ticket");
    customer.add(message,0,0);
    customer.add(createTicket, 0,10);
    customer.add(returner,10,10);
    customerPortal= new Scene(customer,400,400);
    if (m.getParkingFloors()[currentfloor].getParkingSpot(0).getIsUsed()==true&&m.getParkingFloors()[currentfloor].getParkingSpot(1).getIsUsed()==true&&m.getParkingFloors()[currentfloor].getParkingSpot(2).getIsUsed()==true&&m.getParkingFloors()[currentfloor].getParkingSpot(3).getIsUsed()==true&&m.getParkingFloors()[currentfloor].getParkingSpot(4).getIsUsed()==true){
        customer.getChildren().remove(createTicket);
        customer.add(fullParking,0,3);
    }
    lot.setScene(customerPortal);
    lot.show();
    returner.setOnAction(e-> {
     lot.hide();
        Platform.runLater(()-> {
            try {
                new FinalInterface(this.m).start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(FinalInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    });
    createTicket.setOnAction(e->{
        CustomerInterface2();
    });
    }
    public void CustomerInterface2(){
    GridPane TicketGeneration = new GridPane();
    TicketGeneration.setAlignment(Pos.CENTER);
    TicketGeneration.setVgap(10); TicketGeneration.setHgap(10);
    Label mess= new Label("Please Select the Type of Vehicle you have:");
    Label floor = new Label("What floor are you on?");
     Label errormessage= new Label("There is already a car at that spot");
     Label err2= new Label("Please select a vehicle first");
    ComboBox<Integer> floornum= new ComboBox<>();
    floornum.getItems().addAll(0,1,2);
    ComboBox<String> vehicleTypes= new ComboBox<>();
    vehicleTypes.getItems().addAll("Compact","Large","Handicapped","Motorcycle","Electric");
    //TicketGeneration.add(floornum,0,4);
    //TicketGeneration.add(floor,0,3);
    Button creator = new Button("Create Ticket!");
    TicketGeneration.add(mess,0,0);
    TicketGeneration.add(vehicleTypes,0,1);
    TicketGeneration.add(creator,0,8);
    
    
    creator.setOnAction(e-> {
        if(vehicleTypes.getValue()==null){
        TicketGeneration.add(err2,0,16);
        
        }
        else{
         index=0;
        for(int i =0;i<5;i++){
        if(vehicleTypes.getValue().equals(vehicleTypes.getItems().get(i)))
            index=i;
        }
        
        
       if(!this.m.getParkingFloors()[currentfloor].getParkingSpot(index).getIsUsed())       {
           ParkingTicket ticket;
           Customer a= new Customer();
           ticket= new ParkingTicket(vehicleTypes.getValue(),a,m.getParkingFloors()[currentfloor].getParkingSpot(index));
           a.setCustomerNumber();
           a.setTicket(ticket);
           ticket.setCustomer(a);
           ticket.WriteToFile(ticket.getTicketFile());
           
           m.newCustomer(a);
           System.out.println(ticket.getSpot().getIsUsed());
            CustomerInterface3();
       }
       
       else{
      
       TicketGeneration.add(errormessage,0,18);
       lot.setScene(customerPortal2);
        lot.show();
       Button Back = new Button("return");
       TicketGeneration.add(Back,0,20);
       Back.setOnAction(eg->{ CustomerInterface1();});
       }
      
    }});
   customerPortal2= new Scene(TicketGeneration,400,400);
    lot.setScene(customerPortal2);
    lot.show();
    }
    public void CustomerInterface3(){
        GridPane gg= new GridPane();
        gg.setAlignment(Pos.CENTER);
        Label l = new Label("Ticket Created Succesfully");
        Button b= new Button("Return to Main View");
        gg.setHgap(10); gg.setVgap(10);
        gg.add(l,0,0);
        gg.add(b,0,3);
        b.setOnAction(e-> {
        lot.hide();
        Platform.runLater(()-> {
            try {
                new FinalInterface(this.m).start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(FinalInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        });
        customerPortal3= new Scene(gg,400,400);
        lot.setScene(customerPortal3);
        lot.show();
       
        
        //window.setScene(scene1);
        //window.setTitle("ParkEz - Multi-Floor Parking Application");
        //window.show();
        
        
    
    }
    public FinalInterface(Manager man){
        this.m = man;
    }
        
    public FinalInterface(){
        m = new Manager("manager","admin","admin");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
 public boolean authenticate(TextField user, PasswordField pass){ 
        //if returns true move to next scene
        if(user.getText().equals("admin")){
            if(pass.getText().equals("admin")){
                return true;
            }
        }
        return false;
    }   
}
