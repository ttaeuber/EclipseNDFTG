package de.ashesitr.eclipse.state;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import de.ashesitr.eclipse.model.ShipCannon;
import de.ashesitr.eclipse.model.ShipStats;
import de.ashesitr.eclipse.model.ShipType;
import de.ashesitr.eclipse.model.Technology;
import de.ashesitr.eclipse.state.template.ShipBlueprintTemplate;

public class ShipBlueprint extends GameObject {

	private final Faction owner;
	private final ShipType type;
	private final int cost;
	private final List<Technology> techRequirements;
	private final ShipPart[] blueprint;
	private final ShipPart[] baseBlueprint;
	
	public ShipBlueprint(long uid, GameState game, Faction owner, ShipBlueprintTemplate template) {
		super(uid);
		
		this.owner = owner;
		this.type = template.type;
		
		this.cost = template.cost;
		this.techRequirements = template.requiredTechnologies.stream().
				map(tname -> game.getTechnology(tname)).
				collect(Collectors.toList());
		
		this.baseBlueprint = Arrays.stream(template.initialShipParts).
				map(pname -> game.getShipPart(pname)).
				collect(Collectors.toCollection(ArrayList::new)).
				toArray(new ShipPart[0]);
		
		this.blueprint = Arrays.copyOf(this.baseBlueprint, this.baseBlueprint.length);
	}
	
	public Faction getOwner() {
		return owner;
	}
	
	public ShipType getType() {
		return type;
	}
	
	public int getCost() {
		return cost;
	}
	
	public List<Technology> getTechRequirements() {
		return techRequirements;
	}
	
	public boolean requirementsFulfilled() {
		return techRequirements.stream().allMatch(tech -> owner.hasTechnology(tech));
	}
	
	public ShipStats getStats() {
		return Arrays.stream(blueprint).
				map(part -> part.getStats()).
				collect(ShipStats.addCollector());
	}
	
	public List<ShipCannon> getCannons() {
		return Arrays.stream(blueprint).
				map(part -> part.getCannons()).
				collect(ArrayList::new, (a, b) -> a.addAll(b), (a, b) -> a.addAll(b));
	}
	
	public boolean isValid() {
		ShipStats stats = getStats();
		return stats.isValid() && ((type == ShipType.Starbase && stats.speed == 0) || stats.speed > 0);
	}
}
