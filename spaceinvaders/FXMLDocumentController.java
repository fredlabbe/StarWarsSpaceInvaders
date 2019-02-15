/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle;

/**
 *
 * @author cstuser
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    AnchorPane pane;
    @FXML
    Label statusLabel;
    @FXML
    Label scoreLabel;
    @FXML
    protected XWing xWing; 
    @FXML 
    public Rectangle life1; 
    @FXML
    public Rectangle life2; 
    @FXML
    public Rectangle life3;
    
    private double mouseX=0.0; 
    private double mouseY=0.0; 
    private double lastFrameTime = 0.0; 
    private Vector2D playerLaserPos = null;
    private Vector2D playerLaserVel = null; 
    //rivate GameObject playerLaser = null;
    //private GameObject [][] ennemyList = new GameObject [8][4]; 
    private ArrayList<GameObject> gameObjectList;
    private ArrayList<GameObject> laserList; 
    private ArrayList<GameObject> ennemyList; 
    //private ArrayList<ArrayList<GameObject>> ennemyList = new ArrayList<ArrayList<GameObject>>();
    private int numEnnemyDestroyed = 0; 
    private int amtLives = 3; 
    private boolean isEnded = false;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    } 
    
    @FXML
    public void onMouseMove(MouseEvent event)
    {
        //System.out.println("(" + event.getX() + ", " + event.getY() + ")");
        mouseX = event.getX();
        mouseY = event.getY();
        
        xWing.setPosition(mouseX, 480);
    } 
    
    @FXML
    public void onMouseClick(MouseEvent event)
    {
        System.out.println("Clicked: " + event.getButton());
        
        if (event.getButton() == MouseButton.PRIMARY)
        {
            int radius = 3;
            playerLaserPos = new Vector2D(mouseX, mouseY);
            playerLaserVel = playerLaserPos.sub(xWing.getPosition());
            //leftVelocity.setMagnitude(200);
            playerLaserVel.setMagnitude(1000);
            
            GameObject playerLaser = new Laser( xWing.getPosition(), 
                                            playerLaserVel,
                                            radius,
                                            true);
            laserList.add(playerLaser);
            gameObjectList.add(playerLaser); 
            playerLaser.getCircle().setFill(Color.RED);
            addToPane(playerLaser.getCircle());

            AssetManager.getShootingSound().play();
        }
        
    }
    
    public void addToPane(Node node)
    {
        pane.getChildren().add(node);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
         
        
        //xWing.setFill(AssetManager.getVesseauImage());
        //xWing.setStroke(Color.TRANSPARENT); 
        //xWing.toFront();
        //xWing = new XWing(new Vector2D(mouseX, mouseY));
         
        
        lastFrameTime = 0.0f;
        long initialTime = System.nanoTime();
        //final Vector2D acceleration = new Vector2D(0.0, 9.8); 
        AssetManager.preloadAllAssets();  
        
        ennemyList = new ArrayList<>();
        laserList = new ArrayList<GameObject>();
        gameObjectList = new ArrayList<>();
        
        pane.setBackground(AssetManager.getDeathStarImage());
        
        MediaPlayer musicPlayer = new MediaPlayer(AssetManager.getGameMusic());
        musicPlayer.play(); 
        
        //FXMLMenuDocumentController.getScene().setCursor(Cursor.NONE);
        xWing = new XWing(new Vector2D(mouseX, 480),20); 
        gameObjectList.add(0,xWing);
        addToPane(xWing.getCircle());
        
        Asteroid leftAsteroid = new Asteroid(new Vector2D(164, 400), 40); 
        leftAsteroid.getCircle().setFill(AssetManager.getAsteroid3Image());
        Asteroid centerAsteroid = new Asteroid(new Vector2D(364, 400), 40); 
        centerAsteroid.getCircle().setFill(AssetManager.getAsteroid3Image());
        Asteroid rightAsteroid = new Asteroid(new Vector2D(564, 400), 40);
        rightAsteroid.getCircle().setFill(AssetManager.getAsteroid3Image()); 
        addToPane(leftAsteroid.getCircle()); 
        addToPane(rightAsteroid.getCircle());
        addToPane(centerAsteroid.getCircle()); 
        gameObjectList.add(leftAsteroid); 
        gameObjectList.add(centerAsteroid); 
        gameObjectList.add(rightAsteroid);  
        
        
        
        life1.setFill(AssetManager.getVesseauImage());
        life2.setFill(AssetManager.getVesseauImage());
        life3.setFill(AssetManager.getVesseauImage());
        
        for(int i = 0; i<8; i++){ 
            for(int j=0; j<4; j++){ 
                
                TieFighter ennemy = new TieFighter(new Vector2D(150+62*i, 75+62*j), new Vector2D(0,0), 25, 1); 
                //ennemyList.get(i).set(j,ennemy);
                //ennemyList.add(ennemy); 
//                ennemyList[i][j]= ennemy;
                ennemyList.add(ennemy);
                gameObjectList.add(ennemy);
                addToPane(ennemy.getCircle());
            }  
        } 
        
        Vector2D leftBound = new Vector2D(0,0); 
        Vector2D rightBound = new Vector2D(pane.getWidth(),0); 
        
        new AnimationTimer()
        {
            @Override
            public void handle(long now) {

                // Time calculation                
                double currentTime = (now - initialTime) / 1000000000.0;
                double  frameDeltaTime = currentTime - lastFrameTime;
                lastFrameTime = currentTime; 
                
                for (int i = 0; i < gameObjectList.size(); i++) 
                {
                    GameObject c1 = gameObjectList.get(i); 
                    for (int j = i+1; j < gameObjectList.size(); j++) 
                    {
                        GameObject c2 = gameObjectList.get(j);
                        double d = Vector2D.distance(c1.getPosition(), c2.getPosition());
                        
                        if (c1 instanceof TieFighter && c2 instanceof TieFighter) 
                            continue;
                        
                        if (c1 instanceof Laser && c2 instanceof Laser) 
                            continue;
                        
                        if(c1 instanceof TieFighter && c2.friendly == false)
                           continue;
                        
                        if (c2 instanceof TieFighter && c1.friendly == false) 
                            continue;  
                        
                        if (c2 instanceof Laser && c1.friendly == true && c2.friendly == true) 
                            continue; 
                        
                        
                        if (d < c1.getCircle().getRadius() + c2.getCircle().getRadius())
                        { 
                                
                            if(c1 instanceof XWing && c2 instanceof Laser && c2.friendly == false)
                            {
                                gameObjectList.remove(c2);
                                c2.getCircle().setRadius(0);
                                pane.getChildren().remove(c2);
                                amtLives -= 1;

                            }
                            if(amtLives == 2)
                                {   
                                    life3.setWidth(0); 
                                    life3.setHeight(0); 
                                }
                                    
                                    
                                    
                                else if(amtLives == 1)
                                {
                                    life2.setWidth(0);
                                    life2.setHeight(0); 
                                }
                                    
                                    
                                else if(amtLives == 0)
                                {
                                    life1.setWidth(0);
                                    life1.setHeight(0); 
                                    statusLabel.setTextFill(Color.RED); 
                                    statusLabel.setText("Game Over!"); 
                                    pane.getChildren().remove(c1.getCircle()); 
                                    gameObjectList.remove(c1);
                                } 
                                
                                if((c2 instanceof Laser && c1 instanceof TieFighter) || (c1 instanceof Laser && c2 instanceof TieFighter))
                                { 
                                    gameObjectList.remove(c2); 
                                    ennemyList.remove(c2); 
                                    laserList.remove(c2);
                                    pane.getChildren().remove(c1.getCircle()); 
                                    gameObjectList.remove(c1); 
                                    ennemyList.remove(c1); 
                                    laserList.remove(c1);
                            
                                    pane.getChildren().remove(c2.getCircle());
                                    j = gameObjectList.size();
                            
                                    numEnnemyDestroyed += 1; 
                                    scoreLabel.setText(String.valueOf(numEnnemyDestroyed)); 
                                    AssetManager.getExplosionSound().play();
                                } 
                                else if((c1 instanceof Asteroid && c2 instanceof Laser)||(c1 instanceof Asteroid&& c2.friendly== true))
                                { 
                                    gameObjectList.remove(c2); 
                                    //ennemyList.remove(c2); 
                                    laserList.remove(c2); 
                                    pane.getChildren().remove(c2.getCircle()); 
                                    j = gameObjectList.size(); 
                                    AssetManager.getExplosionSound().play();
                                } 
                                /*else if((c1 instanceof Asteroid && c2.friendly== true))
                                { 
                                    pane.getChildren().remove(c1.getCircle()); 
                                    gameObjectList.remove(c1); 
                                    ennemyList.remove(c1); 
                                    laserList.remove(c1); 
                                    j = gameObjectList.size();
                                }*/
                        } 
                        
                    }
                } 
                if(numEnnemyDestroyed==32){ 
                    statusLabel.setText("Victory!"); 
                    isEnded =true;
                }

                if (Math.random() < 0.01 && isEnded==false)
                {
                    randomEnnemyShot();                     
                } 
                
                for (GameObject obj : gameObjectList)
                {
                    obj.update(frameDeltaTime);
                } 
                
                
            }
        }.start();
        
    } 
    
    public void randomEnnemyShot(){  
        

        Random rng = new Random();
        int ennemyIndex = -1;
        
        while (ennemyIndex < 0)
            ennemyIndex = rng.nextInt() % ennemyList.size();
        GameObject currentEnnemy = ennemyList.get(ennemyIndex); 

        Vector2D velocity = new Vector2D(0, 1);
        velocity.setMagnitude(100); 
        
        GameObject ennemyLaser = new Laser( currentEnnemy.getPosition(), 
                                            velocity,
                                            5,
                                            false);     
        ennemyLaser.getCircle().setFill(Color.LIME);
        //laserList.add(ennemyLaser);
        gameObjectList.add(ennemyLaser);         
        addToPane(ennemyLaser.getCircle()); 
        AssetManager.getTieShootingSound().play();
        
    } 
    
    public void gameOver(){ 
        
    }
    
}