package de.ashesitr.eclipse.state;

import de.ashesitr.eclipse.model.Direction;
import de.ashesitr.eclipse.model.Planet;
import de.ashesitr.eclipse.model.Position;
import de.ashesitr.eclipse.state.template.TileTemplate;

public class Tile extends GameObject {
	
	private final Position position;
	private final boolean[] wormholes;
	private final int number;
	private final int tier;
	private final Planet[] planets;
	
	public Tile(long uid, TileTemplate template, Position position, Direction rotation) {
		super(uid);
		
		this.position = position;
		this.wormholes = new boolean[6];
		for (int i = 0; i < 6; i++) {
			this.wormholes[i] = template.wormholes[(i + rotation.ordinal()) % 6];
		}
		
		this.planets = template.planets;
		
		this.number = template.number;
		this.tier = template.tier;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public boolean hasWormhole(Direction d) {
		return wormholes[d.ordinal()];
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getTier() {
		return tier;
	}
}
