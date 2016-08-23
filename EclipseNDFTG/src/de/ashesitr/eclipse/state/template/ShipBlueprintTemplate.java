package de.ashesitr.eclipse.state.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.ashesitr.eclipse.model.ShipType;

public class ShipBlueprintTemplate {
	public int cost;
	public List<String> requiredTechnologies = new ArrayList<>();
	public String[] initialShipParts;
	public ShipType type;
	
	public ShipBlueprintTemplate(int nParts) {
		initialShipParts = new String[nParts];
		Arrays.fill(initialShipParts, ShipPartTemplate.EMPTY_SHIP_PART_TEMPLATE.name);
	}
}
