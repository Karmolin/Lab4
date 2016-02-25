package application;

import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Lab4Part2 extends Application {
	final double PADDING = 20.5; // setting a constant for all the padding.

	public static void main(String[] args) {
		launch(args);

	}
	

	@Override
	public void start(Stage primaryStage) {
		GridPane gameGrid = new GridPane();
		gameGrid.setPadding(new Insets(PADDING));
		gameGrid.setHgap(PADDING);
		gameGrid.setVgap(PADDING);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.println(Lab4.board.getTiles()[i][j].getTileType1().toString());
			
				
			}
		}
		// I need to make a 4x4 grid that holds pictures buttons.
		for (int row = 0; row < 4; row++) {
			for (int column = 0; column < 4; column++) {
		          System.out.println(Lab4.board.getTiles()[row][column].getOwner());
				if(Lab4.board.getTiles()[row][column].getOwner() == null){
				
				ImageView iv1 = new ImageView(Lab4.board.getTiles()[row][column].image1);
				iv1.setFitWidth(20);
				iv1.setFitHeight(20);
				ImageView iv2 = new ImageView(Lab4.board.getTiles()[row][column].image2);
				iv2.setFitWidth(20);
				iv2.setFitHeight(20);
				VBox vbox = new VBox(iv1,iv2);
				gameGrid.add(vbox, row, column);
				}
				else if(Lab4.board.getTiles()[row][column].getOwner() == "RED"){
					ImageView ivRed= new ImageView(new Image("application/redIcon.png"));
					ivRed.setFitWidth(20);
					ivRed.setFitHeight(20);
					gameGrid.add(ivRed, row, column);
				}
				else if(Lab4.board.getTiles()[row][column].getOwner() == "BLACK"){
					ImageView ivBlk= new ImageView(new Image("application/blackIcon.png"));
					ivBlk.setFitWidth(20);
					ivBlk.setFitHeight(20);
					gameGrid.add(ivBlk, row, column);
				}
				
				
		  }
		}
		BorderPane moves = new BorderPane();
		
		Text topText = new Text();
		Text bottomText = new Text();
		ImageView playerIcon=null;
		
        
		if(Lab4.redMove){
			topText.setText("Red To Move");
			playerIcon=new ImageView("application/redIcon.png");
			bottomText.setText(Lab4.getRed().tilesToString());
		}
		else if(!Lab4.redMove){
			topText.setText("Black To Move");
			playerIcon=new ImageView("application/blackIcon.png");
			bottomText.setText(Lab4.getBlack().tilesToString());
		}
		playerIcon.setFitWidth(75);
		playerIcon.setFitHeight(75);
		
		topText.setFont(Font.font("Helvetica", 16));
		
		moves.setTop(topText);
		moves.setCenter(gameGrid);
		moves.setBottom(bottomText);
		moves.setLeft(playerIcon);

		primaryStage.setScene(new Scene(moves));

		primaryStage.show();
	}

}
