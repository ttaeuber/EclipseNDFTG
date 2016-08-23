package de.ashesitr.eclipse.model;

public class ShipCannon {
	private final ShipCannonType type;
	private final int power;
	
	public ShipCannon(ShipCannonType type, int power) {
		this.type = type;
		this.power = power;
	}
	
	public ShipCannonType getType() {
		return type;
	}
	
	public int getPower() {
		return power;
	}
}
