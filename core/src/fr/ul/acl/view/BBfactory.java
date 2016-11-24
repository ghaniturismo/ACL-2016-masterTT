package fr.ul.acl.view;

import com.badlogic.gdx.math.Rectangle;

public class BBfactory {
    private Rectangle ship = new Rectangle(0,0,1,1);
    private Rectangle bullet = new Rectangle(0,0,1,1);
    private Rectangle alien = new Rectangle(0,0,1,1);

    private static BBfactory instance = new BBfactory();
    
    //recuperer les instance des boundingbox
    public static BBfactory getInstance() {
        return instance;
    }
    public Rectangle getBBShip() {
        return ship;
    }
    public Rectangle getBBMissile() {
        return bullet;
    }
    public Rectangle getBBAlien() {
        return alien;
    }

}
