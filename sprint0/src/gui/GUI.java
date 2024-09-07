package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
		
	private GridSquare[][] gridSquares;
	
	private Label gameStatus = new Label("Current Turn: Blue");
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("SOS");
		
		// Plain Text
		Text title = new Text("SOS");
		Text blueLabel = new Text("Blue Player");
		Text redLabel = new Text("Red Player");
		
		title.getStyleClass().add("normal-text");
		title.getStyleClass().add("title");
		blueLabel.getStyleClass().add("normal-text");
		redLabel.getStyleClass().add("normal-text");
		
		// Labels
		Label sizeLabel = new Label("Board Size:");
		
		// Lines
		Line blueLabelLine = new Line();
		blueLabelLine.getStyleClass().add("line-blue");
		blueLabelLine.setStartX(0);
		blueLabelLine.setEndX(110);
		
		Line redLabelLine = new Line();
		redLabelLine.getStyleClass().add("line-red");
		redLabelLine.setStartX(0);
		redLabelLine.setEndX(110);
		
		// Buttons
		Button replayButton = new Button("Replay");
		Button newGameButton = new Button("New Game");
		newGameButton.getStyleClass().add("button-blue");
		
		replayButton.setPrefWidth(100);
		newGameButton.setPrefWidth(100);
		
		// Check boxes
		CheckBox recordBox = new CheckBox("Record Game");
	    
		// Radio Buttons
		RadioButton simpleGame = new RadioButton("Simple Game");
		RadioButton generalGame = new RadioButton("General Game");
		RadioButton blueHuman = new RadioButton("Human");
		RadioButton blueS = new RadioButton("S");
		RadioButton blueO = new RadioButton("O");
		RadioButton blueComp = new RadioButton("Computer");
		RadioButton redHuman = new RadioButton("Human");
		RadioButton redS = new RadioButton("S");
		RadioButton redO = new RadioButton("O");
		RadioButton redComp = new RadioButton("Computer");
		
		// Toggle Groups
		ToggleGroup gameSelectButtons = new ToggleGroup();
		ToggleGroup bluePlayerButtons = new ToggleGroup();
		ToggleGroup blueLetterButtons = new ToggleGroup();
		ToggleGroup redPlayerButtons = new ToggleGroup();
		ToggleGroup redLetterButtons = new ToggleGroup();
		
		simpleGame.setToggleGroup(gameSelectButtons);
		generalGame.setToggleGroup(gameSelectButtons);
		blueHuman.setToggleGroup(bluePlayerButtons);
		blueS.setToggleGroup(blueLetterButtons);
		blueO.setToggleGroup(blueLetterButtons);
		blueComp.setToggleGroup(bluePlayerButtons);
		redHuman.setToggleGroup(redPlayerButtons);
		redS.setToggleGroup(redLetterButtons);
		redO.setToggleGroup(redLetterButtons);
		redComp.setToggleGroup(redPlayerButtons);
		
		simpleGame.setSelected(true);
		blueHuman.setSelected(true);
		blueS.setSelected(true);
		redHuman.setSelected(true);
		redS.setSelected(true);
		
		
		// Text Fields
		TextField sizeTextField = new TextField ();
		sizeTextField.setPrefWidth(50);
		
		// Spacers
		Pane spacer = new Pane();
		HBox.setHgrow(spacer, Priority.ALWAYS);
		spacer.setMinSize(10, 1);
		
		// Grid
		GridPane grid = new GridPane();
		gridSquares = new GridSquare[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				grid.add(gridSquares[i][j] = new GridSquare(), j, i);
			}
		}
		
		// Layout
		BorderPane root = new BorderPane();
		HBox top = new HBox(title,simpleGame,generalGame,spacer,sizeLabel,sizeTextField);
		VBox left = new VBox(blueLabel,blueLabelLine,blueHuman,blueS,blueO,blueComp);
		VBox right = new VBox(redLabel,redLabelLine,redHuman,redS,redO,redComp);
		BorderPane bottom = new BorderPane();
		VBox resetButtons = new VBox(replayButton,newGameButton);
		
		root.setTop(top);
		root.setLeft(left);
		root.setCenter(grid);
		root.setRight(right);
		root.setBottom(bottom);
		bottom.setLeft(recordBox);
		bottom.setCenter(gameStatus);
		bottom.setRight(resetButtons);
		
		// Alignment
		top.setAlignment(Pos.CENTER_LEFT);
		left.setAlignment(Pos.CENTER);
		grid.setAlignment(Pos.CENTER);
		right.setAlignment(Pos.CENTER);
		
		// Padding and Spacing
		top.setPadding(new Insets(10,10,30,10));
		left.setPadding(new Insets(10,10,10,10));
		right.setPadding(new Insets(10,10,10,10));
		bottom.setPadding(new Insets(10,10,10,10));
		top.setSpacing(25);
		left.setSpacing(5);
		right.setSpacing(5);
		resetButtons.setSpacing(5);
		
		// Scene
		Scene scene = new Scene(root, 1000, 500);
		scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public class GridSquare extends Pane {
		
		public GridSquare() {
			getStyleClass().clear();
			getStyleClass().add("grid-square");
			this.setPrefSize(50, 50);
		}
		
	}
	
}