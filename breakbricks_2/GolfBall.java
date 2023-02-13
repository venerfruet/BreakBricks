import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bola de golfe que fica quicando na cena, é controlada
 * indiretamente pelo jogador através da Barra Bloqueadora.
 * 
 * @author (Vener Fruet daSilveira) 
 * @version (2023-02-13)
 */
public class GolfBall extends Actor
{
    /**
     * Act - do whatever the GolfBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int dirX=1;
    private int dirY=1;
    private int speedX=7;
    private int speedY=7;
    
    private Actor blocker;
    
    public void act()
    {
        int widthWorld=getWorld().getWidth();
        int heightWorld=getWorld().getHeight();
        int plus=getImage().getWidth()/2;

        if(getX()-plus <= 0 || getX()+plus >= widthWorld){
            dirX *= -1;
        }
        
        if(getY()-plus <= 30 || getY()+plus >=heightWorld){
            dirY *= -1;
        }
        
        setLocation(dirX * speedX + getX(), dirY * speedY + getY());
        
        defineSpeedAndDirectionX();
        removeBrick();
    }
    
    /**
     * getBlocker - retorna o objeto Barra Bloqueadora.
     */
    private Actor getBlocker(){
        if(!getWorld().getObjects(Blocker.class).isEmpty())
        {
            Actor blocker=(Actor)getWorld().getObjects(Blocker.class).get(0);
            return blocker;
        }else{
            return null;
        }
    }
    
    /**
     * getTouchInBlocker - Retorna a posição no eixo X em que a Barra Bloqueadora se encotra.
     */
    private int getTouchInBlocker()
    {
        Actor blocker=getBlocker();
        
        if(blocker != null)
        {
            return blocker.getX();
        }else{
            return 1000;
        }
    }
    
    /**
     * defineSpeedAndDirectionX - Define a velocida entre 1, 3, 5 e 10 no eixo X
     * de acordo com a posição da colisão na Barra Bloqueadora. E inverte a direção
     * no eixo X caso colida em uma das pontas da Barra Bloqueadora.
     */
    private void defineSpeedAndDirectionX()
    {
        if(isTouching(Blocker.class)){
            int blockerWidth=getBlocker().getImage().getWidth();
            int xBlocker=getTouchInBlocker();
            int posX=getX();
            int colisao=xBlocker-posX;
            
            /*
            define a velecidade entre 1, 3, 5 e 10 em X de acordo
            com a posição da colisão na barra bloqueadora
            */
            if(colisao <= blockerWidth * 0.05 && colisao >= blockerWidth * 0.05 * -1)
            {
                speedX=1;
            }else if(colisao <= blockerWidth * 0.1 && colisao >= blockerWidth * 0.1 * -1)
            {
                speedX=3;
            }else if(colisao <= blockerWidth * 0.15 && colisao >= blockerWidth * 0.15 -1)
            {
                speedX=5;
            }else
            {
                speedX=7;
            }
            /*
            define a direção em X de acordo com a ponta
            da barra bloqueadora em que a bola colide
            */
           
            if(colisao >= blockerWidth / 2)
            {
                if(dirX>0)
                {
                    dirX *= -1;
                }
            }else if(colisao <= blockerWidth / 2 * -1)
            {
                if(dirX<0)
                {
                    dirX *= -1;
                }
            }
            speedY *= -1;
        }
    }
    
    /**
     * removeBrick - Remove tijolo colidido
     */
    private void removeBrick(){
        //Actor brick=getOneObjectAtOffset((getImage().getWidth() / 2 + speedX) * dirX, (getImage().getHeight() / 2 + speedY) * dirY, Brick.class);
        Actor brick=getOneObjectAtOffset(0, 0, Brick.class);
        
        if(brick !=null){
            /*TESTES
            int[] boxBall = getBoundingBox(this);//0-left, 1-right, 2-up, 3-down
            int[] boxBrick = getBoundingBox(brick);//0-left, 1-right, 2-up, 3-down

            if(boxBall[1] <= boxBrick[0] || boxBall[0] >= boxBrick[1])
            {
                getWorld().showText("X", 300, 440);
                dirX *= -1;
            }

            if(boxBall[3] <= boxBrick[2] || boxBall[2] >= boxBrick[3])
            {
                getWorld().showText("Y", 300, 460);
                dirY *= -1;
            }
            */
           
            dirY *= -1;
            
            getWorld().removeObject(brick);
        }
        
    }
    
    /**
     * getBoundingBox(Actor object) - Retorna uma matriz com as coordenas da caixa de um objeto de classe Ator.
     * <br>
     * indices:
     * <br>
     * 0 = eixo X a direita
     * 1 = eixo X a esquerda
     * 2 = eixo Y a cima
     * 3 = eixo Y a baixo
     */
    
    private int[] getBoundingBox(Actor object)
    {
        //define matriz de coordenadas
        int[] coordinates = new int[4];
        
        /*
        determina a metade da largura do objeto
        para calcular as coordenadas esquerda e direita
        */
        int calculateX = object.getImage().getWidth() / 2;
        /*
        determina a metade da altura do objeto
        para calcular as coordenadas cima e baixo
        */
        int calculateY = object.getImage().getHeight() / 2;
        /*
        deve calcular a esquerda, direita, cima e baixo pois
        os pontos X e Y são no centro do objeto
        */
        int left = object.getX() - calculateX;
        int right = object.getX() + calculateX;
        int up = object.getY() - calculateY;
        int down = object.getY() + calculateY;
        
        //atribui os valores a matriz
        coordinates[0] = left;
        coordinates[1] = right;
        coordinates[2] = up;
        coordinates[3] = down;
        
        //retorna matriz
        return coordinates;
    }
}
