package de.ashesitr.eclipse.model;

public enum Direction {
	North,
	NorthWest,
	SouthWest,
	South,
	SouthEast,
	NorthEast;
	
	public Direction clockwise(int n) {
		return values()[(ordinal() - n) % 6];
	}
	
	public Direction counterClockwise(int n) {
		return values()[(ordinal() + n) % 6];
	}
	
	public Direction reverse() {
		return values()[(ordinal() + 3) % 6];
	}
}
