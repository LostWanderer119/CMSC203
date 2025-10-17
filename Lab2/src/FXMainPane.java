


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
	//  declare two HBoxes
	private Button one, two, three, four, five;
	private Label label;
	private TextField text;
	private HBox b1, b2;
	
	//student Task #4:
	//  declare an instance of DataManager
	private DataManager obj;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		one = new Button("Hello");
		two = new Button("Howdy");
		three = new Button("Chinese");
		four = new Button("Clear");
		five = new Button("Exit");
		label = new Label("Feedback");
		text = new TextField();
		b1 = new HBox();
		b2 = new HBox();
		
		
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		ButtonHandler handler = new ButtonHandler();
		obj = new DataManager();
		b1.setAlignment(Pos.CENTER);
		b2.setAlignment(Pos.CENTER);
		VBox.setMargin(b1, new Insets(10));
		VBox.setMargin(b2, new Insets(10));
		b1.setSpacing(30);
		b2.setSpacing(5);
		
		one.setOnAction(handler);
		two.setOnAction(handler);
		three.setOnAction(handler);
		four.setOnAction(handler);
		five.setOnAction(handler);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		b1.getChildren().addAll(one, two, three, four, five);
		b2.getChildren().addAll(label, text);
		
		this.getChildren().addAll(b1, b2);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			Object source = event.getSource();
			if(source == one) {
				text.setText(obj.getHello());
			} else if (source == two) {
				text.setText(obj.getHowdy());
			} else if (source == three) {
				text.setText(obj.getChinese());
			} else if (source == four) {
				text.clear();
			} else if (source == five) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
	
