package spaceinvaders;


import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.paint.ImagePattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cstuser
 */
public class AssetManager {
    static private Background backgroundImage = null;
    static private Background deathStarImage = null;
    static private ArrayList<ImagePattern> planets = new ArrayList<>();
    static private ImagePattern vesseau = null;
    static private ImagePattern crossHairImage = null;
    static private ImagePattern tieFighterImage = null;
    static private ImagePattern asteroid1Image = null;
    static private ImagePattern asteroid2Image = null;
    static private ImagePattern asteroid3Image = null;
    
    static private Media backgroundMusic = null;
    static private Media gameMusic = null;
    static private AudioClip newPlanetSound = null;
    static private AudioClip shootingSound = null;
    static private AudioClip explosionSound = null;
    static private AudioClip tieShootingSound = null;
    
    
    static private String fileURL(String relativePath)
    {
        return new File(relativePath).toURI().toString();
    }
    
    static public void preloadAllAssets()
    {
        // Preload all images
        Image background = new Image(fileURL("./assets/images/obiwanSpaceMustafar.jpg"));
        backgroundImage = new Background(
                            new BackgroundImage(background, 
                                                BackgroundRepeat.NO_REPEAT, 
                                                BackgroundRepeat.NO_REPEAT, 
                                                BackgroundPosition.DEFAULT,
                                                BackgroundSize.DEFAULT));
        Image DeathStarBackground = new Image(fileURL("./assets/images/DeathStarBackground.jpg"));
        deathStarImage = new Background(
                            new BackgroundImage(DeathStarBackground, 
                                                BackgroundRepeat.NO_REPEAT, 
                                                BackgroundRepeat.NO_REPEAT, 
                                                BackgroundPosition.DEFAULT,
                                                BackgroundSize.DEFAULT));
        //planets.add(new ImagePattern(new Image(fileURL("./assets/images/mercury.png"))));
        //planets.add(new ImagePattern(new Image(fileURL("./assets/images/venus.png"))));
        //planets.add(new ImagePattern(new Image(fileURL("./assets/images/earth.png"))));
        //planets.add(new ImagePattern(new Image(fileURL("./assets/images/jupiter.png"))));
        //planets.add(new ImagePattern(new Image(fileURL("./assets/images/saturn.png"))));
        
        tieFighterImage = new ImagePattern(new Image(fileURL("./assets/images/tieFighter.gif")));
        //crossHairImage = new ImagePattern(new Image(fileURL("./assets/images/crosshair.png")));
        asteroid1Image = new ImagePattern(new Image(fileURL("./assets/images/asteroid1.jpg")));
        asteroid2Image = new ImagePattern(new Image(fileURL("./assets/images/asteroid2.jpg")));
        asteroid3Image = new ImagePattern(new Image(fileURL("./assets/images/asteroid3.png")));
        
        
        // Preload all music tracks
        backgroundMusic = new Media(fileURL("./assets/sounds/StarWarsMainTheme.mp3"));
        gameMusic = new Media(fileURL("./assets/sounds/TIEFighterAttackMusic.mp3"));

        // Preload all sound effects
        //newPlanetSound = new AudioClip(fileURL("./assets/soundfx/newPlanet.wav"));
        shootingSound =  new AudioClip(fileURL("./assets/sounds/XWing-Laser.wav")); 
        explosionSound =  new AudioClip(fileURL("./assets/sounds/explosion.mp3")); 
        tieShootingSound =  new AudioClip(fileURL("./assets/sounds/TIE-Fire.wav")); 
       
       vesseau = new ImagePattern(new Image(fileURL("./assets/images/X-Wing_Top_View.png")));
    }
    
     


static public ImagePattern getAsteroid1Image()
    {
        return asteroid1Image;
    }
    static public ImagePattern getAsteroid2Image()
    {
        return asteroid2Image;
    }
    static public ImagePattern getAsteroid3Image()
    {
        return asteroid3Image;
    }
    
    static public Background getBackgroundImage()
    {
        return backgroundImage;        
    }
    static public Background getDeathStarImage()
    {
        return deathStarImage;        
    }
    
    static public ImagePattern getRandomPlanet()
    {
        Random rng = new Random();
        int i = rng.nextInt(planets.size());
        return planets.get(i);
    }

    static public ImagePattern getVesseauImage()
    {
        return vesseau;
    }
    
    static public ImagePattern getTieFighterImage()
    {
        return tieFighterImage;
    }
    
    static public Media getBackgroundMusic()
    {
        return backgroundMusic;
    }
    static public Media getGameMusic()
    {
        return gameMusic;
    }
    
    static public AudioClip getShootingSound()
    {
        return shootingSound;
    }
    static public AudioClip getTieShootingSound()
    {
        return tieShootingSound;
    }
    static public AudioClip getExplosionSound()
    {
        return explosionSound;
    }
}
