/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize; 
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import static spaceinvaders.SpaceInvaders.stage;

/**
 * FXML Controller class
 *
 * @author cstuser
 */
public class FXMLMenuDocumentController implements Initializable {

    /**
     * Initializes the controller class.
     */ 
    @FXML
    AnchorPane pane; 
    @FXML 
    Button startButton; 
    @FXML
    Button quitButton; 
    private Stage gameStage = null;  
    protected static Scene gameScene = null;
    private MediaPlayer musicPlayer = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        AssetManager.preloadAllAssets();
        pane.setBackground(AssetManager.getBackgroundImage()); 
        musicPlayer = new MediaPlayer(AssetManager.getBackgroundMusic());
        musicPlayer.play();
                
        
    } 
    @FXML
    public void mouseOnButton(){ 
        
        
    } 
    
    public static Scene getScene(){ 
        return gameScene;
    }
    
    @FXML
    public void handleQuit(ActionEvent e){ 
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
    }
    
    public void handleButtonAction(ActionEvent event) { 
        
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            gameScene = new Scene(root);
            //stage.close();
            gameStage = new Stage(); 
            gameStage.setScene(gameScene);
            gameStage.show();
            System.out.println("it worked"); 
            musicPlayer.stop();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //ControllerCommunicationInterface.registerController1(this);
    }
    

    
}
