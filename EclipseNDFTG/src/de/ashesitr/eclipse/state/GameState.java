package de.ashesitr.eclipse.state;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.ashesitr.eclipse.model.Technology;
import de.ashesitr.eclipse.state.template.FactionTemplate;
import de.ashesitr.eclipse.state.template.GameStateTemplate;
import de.ashesitr.eclipse.state.template.TechnologyTemplate;

/**
 * Repräsentiert einen wahren Spielzustand.
 * 
 * @author Alex
 *
 */
public class GameState {
	private long currUID = 0;
	
	private long reserveNextUID() {
		return currUID++;
	}
	
	public GameState(GameStateTemplate template) {
		idxObject = new HashMap<>();
		idxTechnologies = new HashMap<>();
		idxFaction = new HashMap<>();
		
		// TODO Tiles, ShipParts
		
		for (TechnologyTemplate technologyT : template.technologies) {
			Technology technology = new Technology(reserveNextUID(), technologyT);
			idxTechnologies.put(technology.getID(), technology);
			idxObject.put(technology.getID(), technology);
		}
		
		for (FactionTemplate factionT : template.factions) {
			Faction faction = new Faction(reserveNextUID(), this, factionT);
			idxFaction.put(faction.getID(), faction);
			idxObject.put(faction.getID(), faction);
		}
	}
	
	private Map<Long, GameObject> idxObject;
	private Map<Long, Faction> idxFaction;
	private Map<Long, Technology> idxTechnologies;
	private Map<Long, ShipPart> idxShipPart;
	private Map<Long, Tile> idxTiles;
	
	public Faction getFaction(long id) {
		return idxFaction.get(id);
	}
	
	public Technology getTechnology(long id) {
		return idxTechnologies.get(id);
	}
	
	public Technology getTechnology(String name) {
		return idxTechnologies.values().stream().filter(tech -> tech.getName().equals(name)).findAny().get();
	}
	
	public ShipPart getShipPart(long id) {
		return idxShipPart.get(id);
	}
	
	public ShipPart getShipPart(String name) {
		return idxShipPart.values().stream().filter(part -> part.getName().equals(name)).findAny().get();
	}
	
	public GameObject getGameObject(long id) {
		return idxObject.get(id);
	}
	
	public Collection<Technology> technologies() {
		return idxTechnologies.values();
	}
}
