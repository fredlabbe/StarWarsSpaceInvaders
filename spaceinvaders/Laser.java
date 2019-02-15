/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 *
 * @author Frederick
 */
public class Laser extends GameObject
{
    public Laser(Vector2D position, Vector2D velocity, double radius, boolean friendly)
    {
        super(position, velocity, new Vector2D(0.0, 9.8), radius, friendly);
        //circle.setFill(AssetManager.getRandomPlanet());
    }

    public boolean getFriendly()
    {
        return friendly;
    }
}
