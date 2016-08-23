package de.ashesitr.eclipse.model;

public class Planet {
	private final PlanetType type;
	private final int normalSlots;
	private final int advancedSlots;
	private int normalOccupied;
	private int advancedOccupied;
	
	public Planet(PlanetType type, int normalSlots, int advancedSlots) {
		this.type = type;
		this.normalSlots = normalSlots;
		this.advancedSlots = advancedSlots;
		
		this.normalOccupied = 0;
		this.advancedOccupied = 0;
	}
	
	public PlanetType getType() {
		return type;
	}
	
	public int getNormalSlots() {
		return normalSlots;
	}
	
	public int getNormalOccupied() {
		return normalOccupied;
	}
	
	public int getAdvancedSlots() {
		return advancedSlots;
	}
	
	public int getAdvancedOccupied() {
		return advancedOccupied;
	}
	
	public boolean hasRoom(boolean advanced) {
		return normalOccupied < normalSlots || (advancedOccupied < advancedSlots && advanced);
	}
	
	public void setOccupied(int normalOccupied, int advancedOccupied) {
		this.normalOccupied = normalOccupied;
		this.advancedOccupied = advancedOccupied;
	}
	
	public boolean occupyNext(boolean advanced) {
		if (normalOccupied < normalSlots) {
			normalOccupied++;
			return true;
		} else if (advancedOccupied < advancedSlots && advanced) {
			advancedOccupied++;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean accepts(RessourceType type) {
		return this.type.accepts(type);
	}
}
