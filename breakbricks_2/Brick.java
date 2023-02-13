import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick extends Actor
{
    /**
     * Act - do whatever the Brick wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        detectBall();
    }

    private void detectBall()
    {
        getWorld().showText(isTouching(GolfBall.class) +"", 300, 300);
        if(isTouching(GolfBall.class)){
            getWorld().removeObject(this);
        }
    }    
}
