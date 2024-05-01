package application;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class controler {
    @FXML
    private Button btn2;

    @FXML
    private Label lbl1;

    @FXML
    private TextField txt1;

    @FXML
    private PasswordField txt2;
    
    
    String name ; 
	String password; 
	
	Pattern test = Pattern.compile("^\\w+\\W\\w+"); // regular expression
    @FXML
    void login(ActionEvent event) {
    	name=txt1.getText();
    	password=txt2.getText();
    	//password length
    	int numpass =txt2.getLength();
    	Matcher m = test.matcher(name);
    	
    	//if the user name matches the regEx
    	 if (m.matches()) {
    		 	// if the password length is greater than 5
    				   if (numpass>=5) {
    				   try {
    	FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("popup.fxml")); 
    	Parent root1 =(Parent) fxmlloader.load();
    	Stage stage = new Stage (); 
    	Scene scene1 = new Scene(root1); 
    	stage.setScene(scene1); 
    	stage.setTitle("you signed in");
    	stage.setResizable(false);
    	stage.show();
    	}catch(  Exception e  ){
    	System.err.println(e.getMessage()); 

    	}
    				   System.out.println(name);
    				   lbl1.setText("");
    				   }else {
    					   // if the password is shorter than 5 ... show message
    					   lbl1.setText("your passward is short");	
    					   }
    				   }
    				   
    			   else{
    				   try {
    					   // if the user name does not  match the regEx
    					   FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("popuperror.fxml")); 
    					       	Parent root2 =(Parent) fxmlloader.load();
    					       	Stage stage2 = new Stage (); 
    					       	Scene scene1 = new Scene(root2); 
    					       	stage2.setScene(scene1); 
    					       	stage2.setTitle("Error");
    					       	stage2.setResizable(false);
    					       	stage2.show();
    					       	}catch(  Exception e  ){
    					       	System.err.println(e.getMessage()); 
 
    			       	}	  
    	      }
     
       }
}