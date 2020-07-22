package circles;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener ;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
/**
 * A lab #2 exercise file.
 * @author Mohammad Maaz Khan
 */
public class Circles extends Application {
    
    public static  int ROWS = 4;
    public static  int COLS = 5;
    public static  Double CELL_SIZE = 100.0;
    public static int x_scale=0;
    public static int y_scale=0;
    HBox[] h= new HBox[5];
    HBox buttonBox;
    @Override
    public void start(Stage primaryStage) {
       
        root = new BorderPane();
        canvas = new VBox();
       
        addSpinnerHandler();
        
        Spinner s= new Spinner(1,5,ROWS);
        Spinner y = new Spinner(1,5,COLS);
        Slider cellsize= new Slider(10,150,CELL_SIZE);
        Spinner xscale = new Spinner(-3,3,x_scale);
        Spinner yscale = new Spinner(-3,3,y_scale);
        Label label= new Label("100");
        Label rowLabel=new Label("Rows");
        Label colLabel=new Label("Columns");
        Label cellLabel=new Label("Cell Size");
        Label xLabel=new Label("X Scale");
        Label yLabel=new Label("Y Scale");
        buttonBox= new HBox(20);
        HBox labelBox= new HBox(150);
        VBox b= new VBox(20);
        buttonBox.setAlignment(Pos.BASELINE_LEFT);
     
        labelBox.getChildren().addAll(rowLabel,colLabel,cellLabel,xLabel,yLabel);
        buttonBox.getChildren().addAll(s,y,cellsize,label,xscale,yscale);
        b.getChildren().addAll(labelBox,buttonBox);
        root.setBottom(b);
       
        root.setLeft(canvas);
 
        primaryStage.setTitle("Lab #2 Exercise");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
      
       
         cellsize.valueProperty().addListener((observable,oldvalue,newValue)->
                
                      label.textProperty().setValue(
                           String.valueOf(newValue.intValue())));
         
         s.valueProperty().addListener((observable,oldvalue,newValue)->{
                    ROWS= (Integer) newValue;
                    addSpinnerHandler();
         });
        
         y.valueProperty().addListener((observable,oldvalue,newValue)->{
                    COLS= (Integer) newValue;
                    addSpinnerHandler();
         });
         cellsize.valueProperty().addListener((observable,oldvalue,newValue)->{
                    CELL_SIZE= (Double) newValue;
                    addSpinnerHandler();
         });
         
         xscale.valueProperty().addListener((observable,oldvalue,newValue)->{
                    x_scale= (Integer) newValue;
                    addSpinnerHandler();
         });
       yscale.valueProperty().addListener((observable,oldvalue,newValue)->{
                    y_scale= (Integer) newValue;
                    addSpinnerHandler();
         });
   }
       
    /**
     * This method adds the handler to the button that gives
     * this application its behavior.
     */
    private void addSpinnerHandler() {
       canvas.setPrefSize(ROWS*CELL_SIZE,COLS*CELL_SIZE);

       canvas.getChildren().removeAll(h);
        
        ScaleTransition s;
        
         for (int i=0; i<ROWS;i++){
            
            h[i]=new HBox(10);
            h[i].setAlignment(Pos.TOP_LEFT);
            for(int j =0; j<COLS;j++){
            Circle circ=new Circle();
            circ.setRadius(CELL_SIZE/2);
            circ.setFill(Color.color(Math.random(),Math.random(),Math.random()));
            if(x_scale==0 && y_scale==0){
               h[i].getChildren().add(circ);
            }
            else{
            h[i].getChildren().add(circ);
            s=new ScaleTransition(Duration.seconds(4),circ);
            s.setToX(x_scale);
            s.setToY(y_scale);
            s.setAutoReverse(true);
            s.setCycleCount(ScaleTransition.INDEFINITE);
            s.play();}
            }
            
            canvas.getChildren().add(h[i]);
        }
         
    
    }
 
     
    private BorderPane root;
    private VBox canvas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
