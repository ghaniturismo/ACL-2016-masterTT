package fr.ul.acl.model;

public abstract class GameMoveableElement extends GameElement {
    private float speed = 20;
    private enum Direction{RIGHT,LEFT,UP,DOWN};
    private Direction direction;
    private boolean isMoving;



	public GameMoveableElement(float x, float y, World world) {
		super(x, y, world);
        this.isMoving = false;
        this.direction = Direction.LEFT;
	}
	
	public void DirectionRight(){
        this.isMoving = true;
        this.direction = Direction.RIGHT;
    }
	
	public void DirectionLeft(){
        this.isMoving = true;
        this.direction = Direction.LEFT;
    }
	
	 public void DirectionUP(){
	        this.isMoving = true;
	        this.direction = Direction.UP;
	    }

	    public void DirectionDown(){
	        this.isMoving = true;
	        this.direction = Direction.DOWN;
	    }
	    
    public void update(float delta){
        float tmp = delta * speed;
        float x = this.getX();
        float y = this.getY();

        if(isMoving) {
            switch (direction) {
                case LEFT:
                	turnLeft(x,tmp);
                    break;
                case RIGHT:
                	turnRight(x,tmp);
                    break;
		        case UP:
	            	turnUp(y,tmp);
		            break;
		        case DOWN:
		        	 turnDown(y,tmp);
		            break;
            }
        }
       }
    
    public void stop(){
    	this.isMoving = false;
    }
    
    public void turnLeft(float x,float tmp){
    	if(x - tmp <= 0){
            isMoving = false;
            this.setX(0);
        }else {
           	x = x - tmp;
           	this.setX(x);
        }
    }
    
    public void turnRight(float x,float tmp){
    	if(x + 1 + tmp >= world.getWorld_width()) {
            isMoving = false;
            this.setX( world.getWorld_width() - 1);
        }else {
            x = x + tmp;
           	this.setX(x);
        }
    }
    
    public void turnUp(float y,float tmp){
  	  if(y + 1 + tmp >= world.getWorld_height()) {
          isMoving = false;
          this.setY(world.getWorld_height() - 1);
      }else {
        y = y + tmp;
       	this.setY(y);

      }
    }
    
    public void turnDown(float y,float tmp){
    	if(y - tmp <= 0) {
            isMoving = false;
            this.setY(0);
        }else {
           y = y - tmp;
          	this.setY(y);
        }
    }
  
  
}
