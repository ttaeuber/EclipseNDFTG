package de.ashesitr.eclipse.state;

public abstract class GameObject {
	private final long id;
	
	protected GameObject(long id) {
		this.id = id;
	}
	
	public long getID() {
		return id;
	}
}
