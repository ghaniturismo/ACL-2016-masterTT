package model;

public abstract class GameMoveableElement extends GameElement {

	public GameMoveableElement(float x, float y, World w) {
		super(x, y, w);
	}


	public void turnRight(){
		float tmp = this.getWorld().getSpace().getX() + 1;
		System.out.println(tmp);
		
		if(this.getWorld().getWorld_width() > tmp ){
			this.getWorld().getSpace().setX(tmp);
			System.out.println("La position de la fusée : " + this.getWorld().getSpace().getX() + "-" + this.getWorld().getSpace().getY());
		}else{
			System.out.println("impossible :  depassement de la fenetre \n");
		}
    }
	
	public void turnLeft(){
		float tmp = this.getWorld().getSpace().getX() - 1;
		if(tmp>=0){
			this.getWorld().getSpace().setX(tmp);
			System.out.println("La position de la fusée : " + this.getWorld().getSpace().getX() + "-" + this.getWorld().getSpace().getY());
		}else{
			System.out.println("impossible :  depassement de la fenetre \n");
		}
    }
}
