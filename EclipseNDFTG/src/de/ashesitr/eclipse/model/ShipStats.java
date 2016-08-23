package de.ashesitr.eclipse.model;

import java.util.stream.Collector;

public class ShipStats {
	public int energy;
	public int energyConsumed;
	public int hull;
	public int initiative;
	public int speed;

	public static final Collector<ShipStats, ShipStats, ShipStats> addCollector() {
		return Collector.of(ShipStats::new, ShipStats::addStats, (a, b) -> {a.addStats(b); return a;});
	}

	public void addStats(ShipStats other) {
		this.energy += other.energy;
		this.energyConsumed += other.energyConsumed;
		this.hull += other.hull;
		this.initiative += other.initiative;
		this.speed += other.speed;
	}
	
	public boolean isValid() {
		return (energyConsumed >= 0 &&
				hull >= 0 &&
				initiative >= 0 &&
				speed >= 0 &&
				energy >= energyConsumed);
	}
}
