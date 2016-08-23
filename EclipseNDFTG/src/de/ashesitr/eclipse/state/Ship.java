package de.ashesitr.eclipse.state;

public class Ship extends GameObject {
	
	private final ShipBlueprint blueprint;
	private int hits;
	
	public Ship(long uid, ShipBlueprint blueprint) {
		super(uid);
		this.blueprint = blueprint;
		
		this.hits = 0;
	}
	
	public int getHits() {
		return hits;
	}
	
	public ShipBlueprint getBlueprint() {
		return blueprint;
	}
}
