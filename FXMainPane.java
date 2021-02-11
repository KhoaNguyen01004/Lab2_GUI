
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button Hello, Howdy, Chinese, Clear, Exit;
	Label lable;
	TextField texfield;

	//  declare two HBoxes
	HBox hBox1, hbox2;
	//student Task #4:
	//  declare an instance of DataManager
	DataManager data = new DataManager();
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		Hello = new Button("Hello");
		Howdy = new Button("Howdy");
		Chinese = new Button ("Chinese");
		Clear = new Button ("Clear");
		Exit = new Button ("Exit");
		lable = new Label ("");
		texfield = new TextField();
		//  instantiate the HBoxes
		hBox1 = new HBox();
		hbox2 = new HBox();
		
		
		//student Task #4:
		//  instantiate the DataManager instance
		data = new DataManager();
		//  set margins and set alignment of the components
		HBox.setMargin(Hello, new Insets(50,30,30,0));
		HBox.setMargin(Howdy, new Insets(50,30,30,0));
		HBox.setMargin(Chinese, new Insets(50,30,30,0));
		HBox.setMargin(Clear, new Insets(50,30,30,0));
		HBox.setMargin(Exit, new Insets(50,30,30,0));
		HBox.setMargin(texfield, new Insets(50,30,30,0));
		
		hBox1.setAlignment(Pos.CENTER);
		hbox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		hBox1.getChildren().addAll(texfield);
		//  add the buttons to the other HBox
		hbox2.getChildren().addAll(Hello, Howdy, Chinese, Clear, Exit, texfield);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(hBox1, hbox2);
		
		Hello.setOnAction(new ButtonHandle());
		Howdy.setOnAction(new ButtonHandle());
		Chinese.setOnAction(new ButtonHandle());
		Clear.setOnAction(new ButtonHandle());
		Exit.setOnAction(new ButtonHandle());
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandle implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) 
		{
			EventTarget target = event.getTarget();
			
			if (target == Hello)
			{
				texfield.setText(data.getHello());
			}
			if (target == Howdy)
			{
				texfield.setText(data.getHowdy());
			}
			if (target == Chinese)
			{
				texfield.setText(data.getChinese());
			}
			if (target == Clear)
			{
				texfield.setText("");
			}
			if (target == Exit)
			{
				Platform.exit();
				System.exit(0);
			}
			
		}
	}
}
	