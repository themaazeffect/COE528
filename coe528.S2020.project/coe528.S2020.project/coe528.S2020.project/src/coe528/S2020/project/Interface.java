
package coe528.S2020.project;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Interface extends Application {
    //you select creating it will ask you what floor and entry point you’re at (maybe a drop down select for each), display all available parking spots on that floor, and then generate the ticket
    //If you select paying for a ticket, it should ask you what exit point you are at, and whether youre paying with cash or card and update the ticket file accordingly
    
    Stage window;
    Scene scene1, scene2, scene3, customerScene, createTicket, createTicket2, createTicket3, payTicket, payTicket1, payTicket2, thankYou;
    static int save;
    GridPane create3 = new GridPane();
    Manager man = new Manager("manager","user","pass");
    
   // public static void main(String[] args) {
     //   launch(args);
   // }
  
    public Interface(Manager man){
        this.man = man;
    }
        
    public Interface(){
        man = new Manager("manager","user","pass");
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        GridPane s = new GridPane();
        s.setAlignment(Pos.CENTER);
        s.setVgap(10);
        s.setHgap(10);
        s.setPadding(new Insets(10));   
        
        Text welcomeTxt = new Text("Welcome.");
        welcomeTxt.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        s.add(welcomeTxt, 0, 0);
        
        Label w = new Label("Are you a customer or a manager?");
        s.add(w, 0, 1);
      
        Button Customer = new Button("Customer");
        s.add(Customer, 0, 3);
        Customer.setOnAction(e->{
            window.setScene(customerScene);
        });
        
        Button Manager = new Button("Manager");
        s.add(Manager, 0, 4);
        Customer.setOnAction(e->{
            window.setScene(customerScene);
        });
        
        Manager.setOnAction(e -> window.setScene(scene2));
    
       
        scene1 = new Scene(s, 600, 600);
        
        //Layout for Manager Button
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
        loginBtn.setOnAction(e->{
            if(authenticate(txtUser, pwBox)){
            window.setScene(scene3);}
            grid.add(label3, 0, 5);
        });
        
        scene2 = new Scene(grid, 600, 600);
        
        GridPane grid2 = new GridPane();
        
        scene3 = new Scene(grid2, 600, 600);
        
        
        GridPane customerLanding = new GridPane();
        customerLanding.setAlignment(Pos.CENTER);
        customerLanding.setVgap(10);
        customerLanding.setHgap(10);
        customerLanding.setPadding(new Insets(10));     
        
        Text welcomeT = new Text("Welcome Customer");
        welcomeT.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        customerLanding.add(welcomeT, 0, 0);
         
        //Combo Box with drop down values. 
        Label floor = new Label("What floor are you on?");
        customerLanding.add(floor, 0, 1);
        
        ComboBox<Integer> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                1,
                2,
                3
        );
        
        customerLanding.add(comboBox, 0, 2);
        
        Button CreateTicket = new Button("Create Ticket");
        customerLanding.add(CreateTicket, 0, 3);
        CreateTicket.setOnAction(e->{
            if(comboBox.getValue()!=null){
                window.setScene(createTicket);
            }
        });
        
        Button PayTicket = new Button("Pay Ticket");
        customerLanding.add(PayTicket, 0, 4);
        PayTicket.setOnAction(e->{
              if(comboBox.getValue()!=null){
                 window.setScene(payTicket);
              }     
        });
        
        
        customerScene = new Scene(customerLanding, 600, 600);
        
        GridPane create = new GridPane();
        //Layout for Create Button
        create.setAlignment(Pos.CENTER);
        create.setVgap(10);
        create.setHgap(10);
        create.setPadding(new Insets(10));
        
        Text CreateText = new Text("Create Ticket");
        CreateText.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        create.add(CreateText, 0, 0);

        Label entryPoint = new Label("What is your entry point?");
        create.add(entryPoint, 0, 1);
        
        TextField entryPoint1 = new TextField();
        entryPoint1.setPromptText("entry point");
        create.add(entryPoint1, 0, 2);

        Button Submit = new Button("Submit");
        create.add(Submit, 0, 3);
        
        Submit.setOnAction(e->{
            
                window.setScene(createTicket2);
                
        });
        
        createTicket = new Scene(create, 600, 600); 
        //After this form is submitted the next screen adds a combo box that shows the car types
        //then the ticket is created. 
        
        GridPane create2 = new GridPane();
        //Layout for Create Button
        create2.setAlignment(Pos.CENTER);
        create2.setVgap(10);
        create2.setHgap(10);
        create2.setPadding(new Insets(10));

        ComboBox<String> None = new ComboBox<>();
        None.getItems().addAll(
                "Compact",
                "Large",
                "Handicapped",
                "Motorcycle",
                "Electric"
        );
        
        create2.add(None, 0, 2);  
        
        Text CreateText2 = new Text("Car Type?");
        CreateText2.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        create2.add(CreateText2, 0, 0);
        
        Button Submit2 = new Button("Create Ticket");
        
        create2.add(Submit2, 0, 3);
        Submit2.setOnAction(e->{
        final int index;
        int i;
        for (i = 0; i < 5;i++)
        {
            String p = None.getItems().get(i);
            if(p.equals(None.getValue())){
                break;
            }        
        }
        
        index = i;
        
        //creating ticket
        if(!man.getParkingFloors()[comboBox.getValue()-1].getParkingSpot(index).getIsUsed()){
        ParkingTicket p;
        Customer c= new Customer();
        p=new ParkingTicket(None.getValue(),c,man.getParkingFloors()[comboBox.getValue()-1].getParkingSpot(index));
        c.setCustomerNumber();
        c.setTicket(p);
        save = c.getCustomerNumber();
        System.out.println(save);     
        
        p.setCustomer(c);
        p.WriteToFile(p.getTicketFile());
            
        man.newCustomer(c);
        
       
        window.setScene(createTicket3);
        Label cart1 = new Label("Please remember your customer number:  " + save + " Thank You!");
        create3.add(cart1, 0, 2);

        
        }
        else{
        //Takes you to error screen; currently pressing submit button does nothing if capacity reached
        Label entryPoint2 = new Label("There is already a car parked at that spot.");
        create2.add(entryPoint2, 0, 4);
        
        Button Submit4 = new Button("Ok");
        
        create2.add(Submit4, 0, 5);
        
        Submit4.setOnAction(p->{
         window.close();
         Platform.runLater(()-> {
             try {
                 new Interface(man).start(new Stage());
                 
             } catch (Exception ex) {
                 Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
             }
         }); 
        });        
        
        }
        });
   
        createTicket2 = new Scene(create2, 600, 600);
        
        //Confirmation Scene then returns back to main Selection Scene after you press ok. 
        create3.setAlignment(Pos.CENTER);
        create3.setVgap(10);
        create3.setHgap(10);
        create3.setPadding(new Insets(10));
        
        Text CreateText3 = new Text("Your ticket has been created!");
        CreateText3.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        create3.add(CreateText3, 0, 0);
       
        Button Ok = new Button("Ok");
        create3.add(Ok, 0, 3);
        //Running this block makes the window reset
        Ok.setOnAction(e->{
         window.hide();
         Platform.runLater(()-> {
             try {
                 new Interface(man).start(new Stage());
                 
             } catch (Exception ex) {
                 Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
        });
        
        createTicket3 = new Scene(create3, 600, 600);
        
        //The static floors comboBox changes size depending on how many spots are free.
     
       
        
        GridPane pay = new GridPane();

        pay.setAlignment(Pos.CENTER);
        pay.setVgap(10);
        pay.setHgap(10);
        pay.setPadding(new Insets(10));

        Text PayText = new Text("Pay Ticket");
        PayText.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        pay.add(PayText, 0, 0);
        
        Label exitPoint = new Label("What is your Customer Number?");
        pay.add(exitPoint, 0, 1);
        
        TextField exitPoint1 = new TextField();
        exitPoint1.setPromptText("customer number");
        pay.add(exitPoint1, 0, 2);
        
        //Find customer located at that floor with that Car 
        //payTicket
        //updateCustomer
        //WriteToFile
        //man.payTicket(c);
        //man.updateCustomer(c);
        //p.WriteToFile(p.getTicketFile());
        
        ComboBox<String> type = new ComboBox<>();
        type.getItems().addAll(
                "Compact",
                "Large",
                "Handicapped",
                "Motorcycle",
                "Electric"
        );
        
            
        pay.add(type, 0, 4);  
        
        Label cart = new Label("What is your car type?");
        pay.add(cart, 0, 3);
        
        
        Button PayCash = new Button("Pay With Cash");
        pay.add(PayCash, 0, 5);
        
        PayCash.setOnAction(e->{
            Customer j = man.getSpecificCustomer(Integer.parseInt(exitPoint1.getText()));
            ParkingTicket i = man.getSpecificCustomer(Integer.parseInt(exitPoint1.getText())).getTicket();
           if(i.getSpot().getIsUsed()){
           if(j.getCustomerNumber() == Integer.parseInt(exitPoint1.getText())){
               if(i.getCarType() == type.getValue()){ //Making sure the selected car type is the same with the ticket on file
                      man.getSpecificCustomer(Integer.parseInt(exitPoint1.getText())).payTicket();
                      man.payTicket(j);//using the manager to pay the ticket
                      man.updateCustomer(j);//update the customer since he/she paid
                      i.WriteToFile(i.getTicketFile());
                      window.setScene(thankYou);
               }else{
                     Label cart1 = new Label("Wrong car type selected please try again!");
                     pay.add(cart1, 0, 6);                  
               }
           }
           }else{
             Label cart1 = new Label("Customer number wrong!");
             pay.add(cart1, 0, 7);
           }
        });
       
           
        Button PayCard = new Button("Pay With Credit Card");
        pay.add(PayCard, 1, 5);
        PayCard.setOnAction(e->{
             Customer j = man.getSpecificCustomer(Integer.parseInt(exitPoint1.getText()));
            ParkingTicket i = man.getSpecificCustomer(Integer.parseInt(exitPoint1.getText())).getTicket();
           if(i.getSpot().getIsUsed()){
           if(j.getCustomerNumber() == Integer.parseInt(exitPoint1.getText())){
               if(i.getCarType() == type.getValue()){ //Making sure the selected car type is the same with the ticket on file
                      man.getSpecificCustomer(Integer.parseInt(exitPoint1.getText())).payTicket();
                      man.payTicket(j);//using the manager to pay the ticket
                      man.updateCustomer(j);//update the customer since he/she paid
                      i.WriteToFile(i.getTicketFile());
                      window.setScene(thankYou);
               }else{
                     Label cart1 = new Label("Wrong car type selected please try again!");
                     pay.add(cart1, 0, 6);                  
               }
           }
           }else{
             Label cart1 = new Label("Customer number wrong!");
             pay.add(cart1, 0, 7);
           }
        });  
      
        payTicket = new Scene(pay, 600, 600);
         
        GridPane n = new GridPane();
        n.setAlignment(Pos.CENTER);
        n.setVgap(10);
        n.setHgap(10);
        n.setPadding(new Insets(10));
        
        Text CreateText4 = new Text("Thank You for using ParkEz");
        CreateText4.setFont(Font.font("Tahoma", FontWeight.LIGHT, 25));
        n.add(CreateText4, 0, 0);
 
        Button Ok1 = new Button("Ok");
        n.add(Ok1, 0, 2);
        Ok1.setOnAction(e->{
                //Reset
                window.hide();
                Platform.runLater(()-> {
                try {
                  new Interface(man).start(new Stage());
                 
                   } catch (Exception ex) {
                  Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
                });
        });
        
        thankYou = new Scene(n, 600, 600);
        
        window.setScene(scene1);
        window.setTitle("ParkEz - Multi-Floor Parking Application");
        window.show();
        
        
    }
    
    public boolean authenticate(TextField user, PasswordField pass){ 
        //if returns true move to next scene
        if("admin".equals(user.getText())){
            if("admin".equals(pass.getText())){
                return true;
            }
        }
        return false;
    }
    
   
    
    //Authenticate method is run after login is pressed
    
    
}
