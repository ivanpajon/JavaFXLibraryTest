package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import fxwindow.fxmove.FXMove;
import fxwindow.fxstage.FXStage;
import fxwindow.fxtoolbar.FXToolbar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SecondStageController implements Initializable {
	
	@FXML private AnchorPane root;
	
	@FXML private JFXButton btnClose, btnUpdateScene;
	
	private FXMove fxmove;
	private FXToolbar fxtoolbar;
	private FXStage fxstage;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		fxmove = new FXMove(root);
		
		fxtoolbar = new FXToolbar(root);
		
		fxstage = new FXStage(root, "src/application/UpdatedScene.fxml");
	}
	
	@FXML void close(ActionEvent e) {
		fxtoolbar.closeWindow();
    }
	
	@FXML void movePressed(MouseEvent e) {
		fxmove.movePressed(e);
    }

    @FXML void moveDragged(MouseEvent e) {
    	fxmove.moveDragged(e);
    }
    
    @FXML void updateScene(ActionEvent e) {
    	//new FXStage(root, "src/application/UpdatedScene.fxml").updateScene(); // This method doesn't need initialization, although, both ways are valid
    	fxstage.updateScene();
    }
}
