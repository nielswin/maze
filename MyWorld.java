import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static int score = 0;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(600, 600, 1);
        this.score=0;
        prepare();
        
    }
    
    public void act(){
        showText("Score = "+ score , 50, 25);
        
        if(score >= 3){
            addObject(new Home(),575,25);
        }
        
        updateTimer();
        checkGameOver();
    }
     private void updateTimer() {
        if (timer > 0) {
            timer--;
            counter.setValue("Time: " + timer);
        }
    }
     private void checkGameOver() {
        if (timer <= 0) {
            // Show game over screen
            getWorld().showText("Game Over", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            
            // Stop the game
            Greenfoot.stop();
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    private void prepare()
    { 
        int y = 25;
        int x = 25;        
        int[][] maze = 
            {
                {1, 1, 0, 1, 0, 2, 0, 0, 0, 0, 1, 0},
                {Greenfoot.getRandomNumber(2)+2, 0, 0, 1, 0, 1, 1, 0, 1, Greenfoot.getRandomNumber(2)+2, 1, 0},
                {1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {Greenfoot.getRandomNumber(2)+2, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1},
                {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 1, 2, 1, 0},
                {0, 1, 1, 1, 0, 1, 1, 0, Greenfoot.getRandomNumber(2)+2, 0, 1, 1},
                {0, 1, 0, 2, 0, 0, 0, 0, 1, 1, 1, Greenfoot.getRandomNumber(2)+2},
                {Greenfoot.getRandomNumber(2)+2, 1, 0, 1, 0, 1, 1, 0, 0, 1, Greenfoot.getRandomNumber(2)+2, 0},
                {1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, Greenfoot.getRandomNumber(2)+2, 0, Greenfoot.getRandomNumber(2)+2, 1, 0, 0, 0, 0, 0},

            };
        for(int i=0; i<maze.length; i++) {
            x = 25;
            for(int j=0; j<maze[i].length; j++) {  
                if(maze[i][j] == 1){
                    addObject(new Wall(),x,y);
                }
                else if(maze[i][j] == 2){
                    addObject(new Food(),x,y);
                }  
                else if(maze[i][j] == 3){
                    addObject(new Enemy(),x,y);
                }  
                x = x+50;
            }
            y= y+50;
        }

        addObject(new Person(),25,575);
        addObject(new bomb(),222, 520);
        addObject(new bomb(),230, 30);
        addObject(counter, 60, 20);
    }
  
}
