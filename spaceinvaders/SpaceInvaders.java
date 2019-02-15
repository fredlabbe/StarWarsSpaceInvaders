/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author cstuser
 */ 

public class SpaceInvaders extends Application {
    
    public static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenuDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        //stage.setFullScreen(true);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } 
    
    /*//@FXML
    public void newWindow() {
            try {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("SpaceInvaders");
        stage.setScene(scene);
        stage.show();
    } catch (Exception e) {
        //Logger logger = Logger.getLogger(getClass().getName());
        //logger.log(Level.SEVERE, "Failed to create new Window.", e);
    }
    
    
    }*/
    
}
