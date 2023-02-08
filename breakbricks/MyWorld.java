import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
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

        //define o placar
        showText("Pontuação: "+ score, 60, 10);
        showText("Nível: "+ level, 280, 10);
        showText("Vidas: "+ lifes, 540, 10);

        //retorna a fase atual
        Actor[][] bricks=Level002();

        //adiciona 3 linhas de tijolos
        for(int row=0; row<bricks.length; row++){
            //adiciona 10 tijolos por linha
            for(int column=0; column<bricks[0].length; column++){
                addObject(bricks[row][column],posX,posY);
                posX+=widthBrick;
            }
            posX=widthBrick/2; //restaura posição X
            posY+=heightBrick; //define posição Y
        }

        //adiciona a bola
        GolfBall GolfBall = new GolfBall();
        addObject(GolfBall,272,279);
        Blocker blocker = new Blocker();
        addObject(blocker,274,469);
        blocker.setLocation(277,473);
        blocker.setLocation(293,468);
        GolfBall.setLocation(276,444);
        GolfBall.setLocation(279,443);
    }
    
    private Actor[][] Level001(){
        Actor[][] bricks=new Actor[8][10];
        
        for(int i=0; i<10; i++){
            bricks[0][i]=new Brick001();
        }
        
        for(int i=0; i<10; i++){
            bricks[1][i]=new Brick002();
        }
        
        for(int i=0; i<10; i++){
            bricks[2][i]=new Brick005();
        }

        for(int i=0; i<10; i++){
            bricks[3][i]=new Brick004();
        }
        
        for(int i=0; i<10; i++){
            bricks[4][i]=new Brick006();
        }
        
        for(int i=0; i<10; i++){
            bricks[5][i]=new Brick007();
        }

        for(int i=0; i<10; i++){
            bricks[6][i]=new Brick008();
        }

        for(int i=0; i<10; i++){
            bricks[7][i]=new Brick003();
       }
       
        return bricks;        
    }
    
    private Actor[][] Level002(){
        Actor[][] bricks=new Actor[8][10];
        
        for(int row=0; row<bricks.length; row++){
            
            for(int column=0; column<bricks[0].length; column++){
                
                int item=Greenfoot.getRandomNumber(8);
                switch(item){
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
