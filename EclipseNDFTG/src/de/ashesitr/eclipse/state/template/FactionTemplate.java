package de.ashesitr.eclipse.state.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.ashesitr.eclipse.core.Player;
import de.ashesitr.eclipse.model.RessourcePool;
import de.ashesitr.eclipse.model.ShipType;
import de.ashesitr.eclipse.state.Faction.Color;

public class FactionTemplate {
	public Player player;
	public Color color;
	public String name;
	public RessourcePool ressources;
	public List<String> initialTechnologies = new ArrayList<>();
	public Map<ShipType, ShipBlueprintTemplate> blueprints = new HashMap<>();
}