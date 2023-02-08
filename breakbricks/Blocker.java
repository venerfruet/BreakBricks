import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blocker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blocker extends Actor
{
    /**
     * Act - do whatever the Blocker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int posX=0;
    int posY=0;
    int speed=10;
    int maxY=488;
    int minY=388;
    int minX=53;
    int maxX=543;
    
    public void act()
    {
        posX=getX();
        posY=getY();
        
        if(Greenfoot.isKeyDown("right"))
        {
            posX += speed;
            if(posX>maxX)
                posX=getX();
                
        }else if(Greenfoot.isKeyDown("left"))
        {
            posX -= speed;
            if(posX<minX)
                posX=getX();
                
        }else if(Greenfoot.isKeyDown("up"))
        {
            posY -= speed;
            if(posY<minY)
                posY=getY();
                
        }else if(Greenfoot.isKeyDown("down"))
        {
            posY += speed;
            if(posY>maxY)
                posY=getY();
                
        }
        
        moveBlocker(posX, posY);
        
    }

    private void moveBlocker(int dirX, int dirY)
    {
        setLocation(posX, posY);
    }
    
}
