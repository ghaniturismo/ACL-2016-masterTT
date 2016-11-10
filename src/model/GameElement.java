package model;

public abstract class GameElement {
	protected float x;
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	protected float y;
	protected World world;
    protected float largeur,hauteur;



public GameElement(float x,float y,World w){
	this.x = x;
	this.y = y;
	this.world = w;
	
}

	//recuperer  et maj la largeur
	public float getLargeur(){
	    return this.largeur;
	}
	public void setLargeur(int l){
	    this.largeur = l;
	}
	
	//recuperer  et maj la hauteur
	public float getHauteur() {
	    return hauteur;
	}
	public void setHauteur(int hauteur) {
	    this.hauteur = hauteur;
	}
	
	

}