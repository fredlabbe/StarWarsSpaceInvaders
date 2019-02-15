/*/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceinvaders;

/**
 *
 * @author Frederick
 */
public class TieFighter extends GameObject{
    //protected double movementSpeed; 
    private Vector2D border;
    private int direction = 1;
    
    public TieFighter(Vector2D position, Vector2D velocity ,double radius, int direction)
    {
        super(position, new Vector2D(0.0, 0.0), new Vector2D(0.0, 0.0), radius, false);
        //this.movementSpeed = movementSpeed; 
        border = new Vector2D(0,position.getY()); 
        this.velocity = border.sub(position);
        this.velocity.setMagnitude(50);
        this.direction = direction;
        circle.setFill(AssetManager.getTieFighterImage());
    }
    
    
    public void update(double dt)
    {
        //super.update(dt);
        if (position.getX() <= 0) 
        {
            direction = -direction;
            this.border = new Vector2D(754 , position.getY());
            this.velocity = border.sub(position);
            //this.position = position.mul(direction);
            this.velocity.setMagnitude(50);
        }
        else if(position.getX() >= 754)
        {
            this.border = new Vector2D(0,position.getY());
            this.velocity = border.sub(position);
            this.velocity.setMagnitude(50);
        }
        super.update(dt);
        System.out.println(position.getX());
    }
}
