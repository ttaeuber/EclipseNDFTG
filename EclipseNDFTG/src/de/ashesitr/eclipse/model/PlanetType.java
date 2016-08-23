package de.ashesitr.eclipse.model;

public enum PlanetType {
	Gold,
	Material,
	Research,
	White;
	
	public boolean accepts(RessourceType type) {
		switch (this) {
		case Gold:
			return type == RessourceType.Gold;
		case Material:
			return type == RessourceType.Material;
		case Research:
			return type == RessourceType.Research;
		case White:
			return true;
		default:
			throw new RuntimeException("Unreachable PlanetType.accepts()");
		}
	}
}
