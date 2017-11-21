package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import fxwindow.fxmove.FXMove;
import fxwindow.fxtoolbar.FXToolbar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SecondStageController implements Initializable {
	
	@FXML private AnchorPane root;
	
	@FXML private JFXButton btnClose;
	
	private FXMove fxmove;
	private FXToolbar fxtoolbar;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		fxmove = new FXMove(root);
		
		fxtoolbar = new FXToolbar(root);
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
}
