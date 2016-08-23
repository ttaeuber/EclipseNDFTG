package de.ashesitr.eclipse.model;

import de.ashesitr.eclipse.state.GameObject;
import de.ashesitr.eclipse.state.template.TechnologyTemplate;

public class Technology extends GameObject {
	
	private final String name;
	private final TechnologyType type;
	private final int cost;
	private final int minCost;
	
	public Technology(long uid, TechnologyTemplate template) {
		super(uid);
		this.cost = template.cost;
		this.minCost = template.minCost;
		this.name = template.name;
		this.type = template.type;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getMinCost() {
		return minCost;
	}
	
	public String getName() {
		return name;
	}
	
	public TechnologyType getType() {
		return type;
	}
	
	public int getCost(int discount) {
		return Math.min(cost - discount, minCost);
	}
}
