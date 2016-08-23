package de.ashesitr.eclipse.state;

import java.util.List;

import de.ashesitr.eclipse.model.ShipCannon;
import de.ashesitr.eclipse.model.ShipStats;
import de.ashesitr.eclipse.state.template.ShipPartTemplate;

public class ShipPart extends GameObject {
	
	private final String name;
	private final ShipStats stats;
	private final List<ShipCannon> cannons;
	
	public ShipPart(long uid, ShipPartTemplate template) {
		super(uid);
		
		this.name = template.name;
		this.stats = template.stats;
		this.cannons = template.cannons;
	}
	
	public String getName() {
		return name;
	}
	
	public ShipStats getStats() {
		return stats;
	}
	
	public List<ShipCannon> getCannons() {
		return cannons;
	}
}
