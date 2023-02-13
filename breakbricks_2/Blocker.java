import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Barra Boqueadora, controlada diretamente pelo jogador
 * é ela é quem não deixa a bola cair.
 * 
 * @author (Vener Fruet daSilveira) 
 * @version (2023-02-13)
 */
public class Blocker extends Actor
{
    /**
     * Act - do whatever the Blocker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //Inicializa variáveis de posição e velocidade da Barra Bloqueadora    
    private int posX=0;
    private int posY=0;
    private int speed=7;
    
    public void act()
    {
        //Determina o máximo que a Barra Bloqueadora se move na vertical
        double limitToUpWordHeight = getWorld().getHeight() * 0.90;
        int maxY=getWorld().getHeight();
        int minY=(int)limitToUpWordHeight;
        int minX=53;
        int maxX=543;
        
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

    /**
     * moveBlocker - Move a Barra Bloqueadora nos nos eixos X e Y
     */
    private void moveBlocker(int dirX, int dirY)
    {
        setLocation(posX, posY);
    }

}
