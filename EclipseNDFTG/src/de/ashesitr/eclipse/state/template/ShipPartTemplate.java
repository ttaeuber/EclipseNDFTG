package de.ashesitr.eclipse.state.template;

import java.util.Collections;
import java.util.List;

import de.ashesitr.eclipse.model.ShipCannon;
import de.ashesitr.eclipse.model.ShipStats;

public class ShipPartTemplate {
	public static final ShipPartTemplate EMPTY_SHIP_PART_TEMPLATE = new ShipPartTemplate();
	
	static {
		EMPTY_SHIP_PART_TEMPLATE.stats = new ShipStats();
		EMPTY_SHIP_PART_TEMPLATE.name = "<empty>";
	}
	
	public ShipStats stats;
	public String name;
	public List<ShipCannon> cannons = Collections.emptyList();
}
