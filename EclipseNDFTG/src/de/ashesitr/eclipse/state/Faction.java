package de.ashesitr.eclipse.state;

import java.util.List;
import java.util.stream.Collectors;

import de.ashesitr.eclipse.core.Player;
import de.ashesitr.eclipse.model.RessourcePool;
import de.ashesitr.eclipse.model.Technology;
import de.ashesitr.eclipse.state.template.FactionTemplate;

/**
 * Repräsentiert eine Faktion in einem Spiel.
 * 
 * @author Alex
 *
 */
public class Faction extends GameObject {
	
	public static enum Color {
		Blue,
		Red,
		Green,
		Yellow,
		Black,
		White;
	}
	
	public Faction(long uid, GameState game, FactionTemplate template) {
		super(uid);
		// Game-global information
		this.player = template.player;
		this.color = template.color;
		this.name = template.name;
		this.ressources = template.ressources;
		this.researchedTechnologies = template.initialTechnologies.stream().
				map(tname -> game.getTechnology(tname)).
				collect(Collectors.<Technology>toList());
		
		// Round-local information
		this.passed = false;
	}
	
	private final Color color;
	private final String name;
	private final Player player;
	private final RessourcePool ressources;
	private List<Technology> researchedTechnologies;
	private boolean passed;
	
	public Color getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public RessourcePool getRessources() {
		return ressources;
	}
	
	public boolean hasTechnology(Technology tech) {
		return researchedTechnologies.contains(tech);
	}
	
	public List<Technology> getTechnologies() {
		return researchedTechnologies;
	}
	
	public boolean hasPassed() {
		return passed;
	}
	
	public void pass() {
		passed = true;
	}
	
	public void resetRound() {
		// TODO Round-locals zurücksetzen
		// Abrechnung geschieht in GameState. Hier nur lokale "Merker" zurücksetzen
		passed = false;
	}
}
