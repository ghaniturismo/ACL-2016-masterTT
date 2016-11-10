package model;

public class World {
		protected SpaceInvaders space;
		protected float World_width,World_height;

		
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
		
	    
	    public World(){
	    	 this.World_width = 30;
	         this.World_height = 20;
	         this.space = new SpaceInvaders(15,15,this);
	    }
		
		
		
		
}
