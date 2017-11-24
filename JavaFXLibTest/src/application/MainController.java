package application;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;

import fxthread.FXThread;
import fxwindow.fxmove.FXMove;
import fxwindow.fxresize.FXResize;
import fxwindow.fxstage.FXStage;
import fxwindow.fxtoolbar.FXToolbar;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainController implements Initializable {

    @FXML private Pane paneUp, paneRight, paneDown, paneLeft, paneUpLeft, paneUpRight, paneDownRight, paneDownLeft;
    
    @FXML private AnchorPane root, paneToolbar, paneContent;
    
    @FXML private JFXButton btnClose, btnMaximize, btnMinimize, btnNewStage;
    
    @FXML private ImageView imgMaximize;
    
    @FXML private Label lblClock;
    
    @FXML private JFXToggleButton toggleClock;
    
    private FXMove fxmove;
    private FXResize fxresize;
    private FXToolbar fxtoolbar;
    private FXThread fxthread;
    private FXStage fxstage;
    
    private Image minimizeIcon = new Image(getClass().getResource("icons/minimizeSize_icon.png").toExternalForm());
    private Image maximizeIcon = new Image(getClass().getResource("icons/maximizeSize_icon.png").toExternalForm());
    
    @Override
	public void initialize(URL url, ResourceBundle rb) {
    	fxthread = new FXThread();
    	Runnable task = () -> runTask(lblClock);
		fxthread.setTask(task);
		
    	fxmove = new FXMove(root);
    	
    	fxresize = new FXResize(root, paneUp, paneRight, paneDown, paneLeft, paneUpLeft, paneUpRight, paneDownRight, paneDownLeft);
    	
    	fxtoolbar = new FXToolbar(root, minimizeIcon, maximizeIcon);
    	
    	fxstage = new FXStage("src/application/SecondStage.fxml");
	}
    
    @FXML void newStage(ActionEvent e) {
    	fxstage.setUndecorated(true);
    	fxstage.open();
    }
    
    @FXML void clock(ActionEvent event) {
    	if (toggleClock.isSelected()) {
    		fxthread.startThread();
    		toggleClock.setText("Detener");
    	}
    	else {
    		fxthread.stopThread();
    		toggleClock.setText("Reanudar");
    	}
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
    
    private void runTask(Label l) {
		try {
			while (true) {
				Calendar rightNow = Calendar.getInstance();
				int hour = rightNow.get(Calendar.HOUR_OF_DAY);
				int minutes = rightNow.get(Calendar.MINUTE);
				int seconds = rightNow.get(Calendar.SECOND);
				
				String time;
				if (hour >= 10 && minutes >= 10 && seconds < 10) {
					time = hour + ":" + minutes + ":0" + seconds;
				}
				else if (hour >= 10 && minutes < 10 && seconds < 10) {
					time = hour + ":0" + minutes + ":0" + seconds;
				}
				else if (hour < 10 && minutes < 10 && seconds < 10) {
					time = "0" + hour + ":0" + minutes + ":0" + seconds;
				}
				else if (hour >= 10 && minutes < 10 && seconds >= 10) {
					time = hour + ":0" + minutes + ":" + seconds;
				}
				else if (hour < 10 && minutes >= 10 && seconds >= 10) {
					time = "0" + hour + ":" + minutes + ":" + seconds;
				}
				else if (hour < 10 && minutes < 10 && seconds >= 10) {
					time = "0" + hour + ":0" + minutes + ":" + seconds;
				}
				else if (hour < 10 && minutes >= 10 && seconds < 10) {
					time = "0" + hour + ":" + minutes + ":0" + seconds;
				}
				else {
					time = hour + ":" + minutes + ":" + seconds;
				}
				
				if (Platform.isFxApplicationThread()) {
					new Runnable() {
						@Override
						public void run( ) {
							l.setText(time);
						}
					};
				}
		        else {
		        	Platform.runLater(
							new Runnable() {
								@Override
								public void run( ) {
									l.setText(time);
								}
							}
						);
		        }
				Thread.sleep(100);
				}
		}
		catch (InterruptedException e) {
			System.out.println(e);
		}
	}
    
}