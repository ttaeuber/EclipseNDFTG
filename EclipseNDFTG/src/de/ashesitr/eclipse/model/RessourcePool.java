package de.ashesitr.eclipse.model;

public class RessourcePool {
	private int[] values = new int[RessourceType.values().length];
	
	public int getValue(RessourceType type) {
		return values[type.ordinal()];
	}
	
	public RessourcePool() {}
	
	public RessourcePool(int gold, int material, int research) {
		values[RessourceType.Gold.ordinal()] = gold;
		values[RessourceType.Material.ordinal()] = material;
		values[RessourceType.Research.ordinal()] = research;
	}
	
	public boolean isLarger(RessourcePool pool) {
		for (int i = 0; i < RessourceType.values().length; i++) {
			if (pool.values[i] > values[i])
				return false;
		}
		return true;
	}
	
	public void subtract(RessourcePool pool) {
		for (int i = 0; i < RessourceType.values().length; i++) {
			values[i] -= pool.values[i];
		}
	}
	
	public void subtract(RessourceType type, int value) {
		values[type.ordinal()] -= value;
	}
	
	public void subtractGold(int value) {
		subtract(RessourceType.Gold, value);
	}
	
	public void subtractMaterial(int value) {
		subtract(RessourceType.Material, value);
	}
	
	public void subtractResearch(int value) {
		subtract(RessourceType.Research, value);
	}
	
	public void add(RessourcePool pool) {
		for (int i = 0; i < RessourceType.values().length; i++) {
			values[i] += pool.values[i];
		}
	}
	
	public void add(RessourceType type, int value) {
		values[type.ordinal()] += value;
	}
	
	public void addGold(int value) {
		add(RessourceType.Gold, value);
	}
	
	public void addMaterial(int value) {
		add(RessourceType.Material, value);
	}
	
	public void addResearch(int value) {
		add(RessourceType.Research, value);
	}
	
	public int get(RessourceType type) {
		return values[type.ordinal()];
	}
	
	public void set(RessourceType type, int value) {
		values[type.ordinal()] = value;
	}
	
	public int getGold() {
		return get(RessourceType.Gold);
	}
	
	public void setGold(int value) {
		set(RessourceType.Gold, value);
	}
	
	public int getMaterial() {
		return get(RessourceType.Material);
	}
	
	public void setMaterial(int value) {
		set(RessourceType.Material, value);
	}
	
	public int getResearch() {
		return get(RessourceType.Research);
	}
	
	public void setResearch(int value) {
		set(RessourceType.Research, value);
	}
	
	public boolean isPositive() {
		for (int i = 0; i < RessourceType.values().length; i++) {
			if (values[i] < 0)
				return false;
		}
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RessourcePool) {
			for (int i = 0; i < RessourceType.values().length; i++)
				if (values[i] != ((RessourcePool) obj).values[i])
					return false;
			return true;
		} else {
			return false;
		}
	}
	
}
