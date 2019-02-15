/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

import javafx.scene.paint.Color;

/**
 *
 * @author Frederick
 */
public class XWing extends GameObject{ 
    
    public XWing(Vector2D position, double radius)
    {
        super(position, new Vector2D(0.0, 0.0), new Vector2D(0.0, 0.0), radius, true);

        circle.setFill(AssetManager.getVesseauImage());
    }
    
    public void update(double dt)
    {
        // Make it always on top!
        getCircle().toFront();
    }
}
