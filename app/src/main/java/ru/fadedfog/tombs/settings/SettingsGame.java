package ru.fadedfog.tombs.settings;


public class SettingsGame {
	public final int ZERO = 0;
	public final int GRAVITATION_PRIMORDIAL = -1;
	private int gravitation = GRAVITATION_PRIMORDIAL;
	
	public int getGravitation() {
		return gravitation;
	}
	
	public void setGravitation(int gravitation) {
		this.gravitation = gravitation;
	}
	
	public void setGravitaionToPrimordial() {
		this.gravitation = GRAVITATION_PRIMORDIAL;
	}
	
}
