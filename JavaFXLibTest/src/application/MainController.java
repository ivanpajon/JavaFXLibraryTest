package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import fxwindow.fxmove.FXMove;
import fxwindow.fxresize.FXResize;
import fxwindow.fxtoolbar.FXToolbar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainController implements Initializable {

    @FXML private Pane paneUp, paneRight, paneDown, paneLeft, paneUpLeft, paneUpRight, paneDownRight, paneDownLeft;
    
    @FXML private AnchorPane root, paneToolbar, paneContent;
    
    @FXML private JFXButton btnClose, btnMaximize, btnMinimize;
    
    @FXML private ImageView imgMaximize;
    
    private FXMove fxmove;
    private FXResize fxresize;
    private FXToolbar fxtoolbar;
    
    private Image minimizeIcon = new Image(getClass().getResource("icons/minimizeSize_icon.png").toExternalForm());
    private Image maximizeIcon = new Image(getClass().getResource("icons/maximizeSize_icon.png").toExternalForm());
    
    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	fxmove = new FXMove(root);
    	fxresize = new FXResize(root, paneUp, paneRight, paneDown, paneLeft, paneUpLeft, paneUpRight, paneDownRight, paneDownLeft);
    	fxtoolbar = new FXToolbar(root, minimizeIcon, maximizeIcon);
	}
    
    @FXML void close(ActionEvent e) {
    	fxtoolbar.closeWindow();
    }
    
    @FXML void maximize(ActionEvent e) {
    	fxtoolbar.maximizeWindow(fxresize, imgMaximize);
    }
    
    @FXML void minimize(ActionEvent e) {
    	fxtoolbar.iconifyWindow();
    }

    @FXML void moveDragged(MouseEvent e) {
    	fxmove.moveDragged(e);
    }

    @FXML void movePressed(MouseEvent e) {
    	fxmove.movePressed(e);
    }
    
 	@FXML void moveReleased(MouseEvent e) {
 		if (fxmove.isDraggedToUp(e)) {
 			fxmove.dragToUp(e);
 			fxresize.disableResizing();
 		}
 		else {
 			fxmove.dragToCenter(e);
 			fxresize.enableResizing();
 		}
 	}
    
    @FXML void resizeVerticalPressed(MouseEvent e) {
    	fxresize.resizeVerticalPressed(e);
    }
    
    @FXML void resizeUpDragged(MouseEvent e) {
    	fxresize.resizeUpDragged(e);
    }
    
    @FXML void resizeDownDragged(MouseEvent e) {
        fxresize.resizeDownDragged(e);
    }
    
    @FXML void resizeHorizontalPressed(MouseEvent e) {
        fxresize.resizeHorizontalPressed(e);
    }
    
    @FXML void resizeLeftDragged(MouseEvent e) {
        fxresize.resizeLeftDragged(e);
    }
    
    @FXML void resizeRightDragged(MouseEvent e) {
        fxresize.resizeRightDragged(e);
    }
    
    @FXML void resizeCornerPressed(MouseEvent e) {
    	fxresize.resizeCornerPressed(e);
    }
    
    @FXML void resizeUpLeftDragged(MouseEvent e) {
    	fxresize.resizeUpLeftDragged(e);
    }
    
    @FXML void resizeUpRightDragged(MouseEvent e) {
    	fxresize.resizeUpRightDragged(e);
    }
    
    @FXML void resizeDownRightDragged(MouseEvent e) {
    	fxresize.resizeDownRightDragged(e);
    }
    
    @FXML void resizeDownLeftDragged(MouseEvent e) {
    	fxresize.resizeDownLeftDragged(e);
    }
    
}