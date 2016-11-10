package model;

public class World {
		protected SpaceInvaders space;
	    public SpaceInvaders getSpace() {
			return space;
		}


		public void setSpace(SpaceInvaders space) {
			this.space = space;
		}


		public float getWorld_width() {
			return World_width;
		}


		public void setWorld_width(float world_width) {
			World_width = world_width;
		}


		public float getWorld_height() {
			return World_height;
		}


		public void setWorld_height(float world_height) {
			World_height = world_height;
		}


		protected float World_width,World_height;
		
	    
	    public World(){
	    	 this.World_width = 30;
	         this.World_height = 30;
	         this.space = new SpaceInvaders(15,15,this);
	    }
		
		
		
		
}
