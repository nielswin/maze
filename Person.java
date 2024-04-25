import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person extends Actor
{
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     
    public void act()
    {
        // Add your action code here.
        moveAround();
        hitEnemy();
        hitFood();
        hitBomb();
    }
      public void hitBomb() {
        if (isTouching(bomb.class)) {
            // Show game over text
            getWorld().showText("Game Over", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            
            // Stop the game
            Greenfoot.stop();
        }
    }
    public boolean hitHome(){
       if(isTouching(Home.class)){
           return true;
       }
       else{
        return false;
        }
    }
    public boolean hitWall(){
       if(isTouching(Wall.class)){
           return true;
       }
       else{
        return false;
        }
    }
    public void hitEnemy(){
       Actor apple = getOneIntersectingObject(Enemy.class);
       if(apple != null){
           getWorld().removeObject(apple);
           MyWorld.score--;
        }
       
    }
    public void hitFood(){
       Actor food = getOneIntersectingObject(Food.class);
       if(food != null){
           getWorld().removeObject(food);
           MyWorld.score++;
        }
       
    }
    public boolean hitEdge(){
        int getX = getX();
        int getY = getY();
        if(getX <= 10|| getX >=590|| getY <= 15|| getY >= 585  ){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public void moveAround(){
        if(Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-1);
            if(hitWall() == true || hitEdge() == true){
                setLocation(getX(), getY()+2);
            }
            if(hitHome() == true){
                World level2 = new FishWorld();
                Greenfoot.setWorld(level2);
            }
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+1);
            if(isTouching(Wall.class))
         {
           setLocation(getX(), getY()-2);   
         }
            
        }
        if(Greenfoot.isKeyDown("right")){
            setLocation(getX()+1, getY());
           if(isTouching(Wall.class))
         {
           setLocation(getX()-2, getY());   
         }
        }
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX()-1, getY());
            if(isTouching(Wall.class))
         {
           setLocation(getX()+2, getY());   
         }
        }
    }
}
