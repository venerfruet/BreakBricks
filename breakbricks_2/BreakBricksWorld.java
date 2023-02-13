import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is class world of game, where the cene objects are included.
 * <br>
 * Esta é a classe mundo do jogo, onde são incluídos os objetos da cena.
 * 
 * @author (Vener Fruet daSilveira) 
 * @version (2023-02-10)
 */
public class BreakBricksWorld extends World
{

    /**
     * Constructor for objects of class BreakBricksWorld<br>
     * Create a new world with 600x400 cells with a cell size of 1x1 pixels<br>
     * <br>
     * Construtor de Objetos da classe BreakBricksWorld<br>
     * Cria um novo mundo com 600x400 células onde uma celula tem 1x1 pixels de tamanhanho.
     */
    public BreakBricksWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // Cria um novo mundo com 600x400 células onde uma celula tem 1x1 pixels de tamanhanho.
        super(600, 500, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * Prepara o mundo para o início do programa.
     * That is: create the initial objects and add them to the world.
     * Para isto: são criados os objetos iniciais e adicionados ao mundo.
     */
    private void prepare()
    {
        int widthBrick=60;
        int heightBrick=20;
        int posX=widthBrick/2;
        int posY=heightBrick*2;
        int score=0;
        int level=1;
        int lifes=3;

        //define the scoreboard.
        //define o placar.
        showText("Pontuação: "+ score, 60, 10);
        showText("Nível: "+ level, 280, 10);
        showText("Vidas: "+ lifes, 540, 10);

        //return the current level.
        //retorna a fase atual
        Actor[][] bricks=Level002();

        //add 3 rows of a bricks.
        //adiciona 3 linhas de tijolos.
        for(int row=0; row<bricks.length; row++)
        {

        //add 10 bricks of a bricks. 
        //adiciona 10 linhas de tijolos.
        for(int column=0; column<bricks[0].length; column++)
        {
        addObject(bricks[row][column],posX,posY);
        posX+=widthBrick;
        }

        //restore position X.
        //restaura posição X.
        posX=widthBrick/2;

        //define position Y.
        //define posição Y.
        posY+=heightBrick;
        }
        
        /*
        //teste
        Brick010 brick010 = new Brick010();
        addObject(brick010,287,244);
        */
       
        //add the blocker
        //adiciona o cloqueador
        Blocker blocker = new Blocker();
        addObject(blocker,293,468);

        //add the ball
        //adiciona a bola
        GolfBall GolfBall = new GolfBall();
        addObject(GolfBall,279,443);
    }
    
    private Actor[][] Level001()
    {
        
        //draw the level 1 static.
        //desenha a fase 1 estatica.
        Actor[][] bricks=new Actor[8][10];
        
        for(int i=0; i<10; i++)
        {
            bricks[0][i]=new Brick001();
        }
        
        for(int i=0; i<10; i++)
        {
            bricks[1][i]=new Brick002();
        }
        
        for(int i=0; i<10; i++)
        {
            bricks[2][i]=new Brick005();
        }

        for(int i=0; i<10; i++)
        {
            bricks[3][i]=new Brick004();
        }
        
        for(int i=0; i<10; i++)
        {
            bricks[4][i]=new Brick006();
        }
        
        for(int i=0; i<10; i++){
            bricks[5][i]=new Brick007();
        }

        for(int i=0; i<10; i++)
        {
            bricks[6][i]=new Brick008();
        }

        for(int i=0; i<10; i++)
        {
            bricks[7][i]=new Brick003();
        }
       
        return bricks;        
    }
    
    private Actor[][] Level002()
    {
        Actor[][] bricks=new Actor[8][10];
        
        //draw the level 2 randomic.
        //desenha a fase 2 aletatória.
        for(int row=0; row<bricks.length; row++)
        {
            
            for(int column=0; column<bricks[0].length; column++)
            {
                
                int item=Greenfoot.getRandomNumber(8);
                switch(item)
                {
                    case 0:
                        bricks[row][column]=new Brick001();
                        break;
                    case 1:
                        bricks[row][column]=new Brick002();
                        break;
                    case 2:
                        bricks[row][column]=new Brick003();
                        break;
                    case 3:
                        bricks[row][column]=new Brick004();
                        break;
                    case 4:
                        bricks[row][column]=new Brick005();
                        break;
                    case 5:
                        bricks[row][column]=new Brick006();
                        break;
                    case 6:
                        bricks[row][column]=new Brick007();
                        break;
                    case 7:
                        bricks[row][column]=new Brick008();
                        break;
                }
            }            
        }
        
        return bricks;
    }
}
