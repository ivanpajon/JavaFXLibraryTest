package application;

import java.net.URL;
import java.util.ResourceBundle;

import fxwindow.fxmove.FXMove;
import fxwindow.fxresize.FXResize;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainController implements Initializable {

    @FXML private Pane paneToolbar, paneUp, paneRight, paneDown, paneLeft, paneUpLeft, paneUpRight, paneDownRight, paneDownLeft;
    
    @FXML private AnchorPane root;
    
    private FXMove fxmove;
    private FXResize fxresize;
    
    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	fxmove = new FXMove(root);
    	fxresize = new FXResize(root, paneUp, paneRight, paneDown, paneLeft, paneUpLeft, paneUpRight, paneDownRight, paneDownLeft);
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