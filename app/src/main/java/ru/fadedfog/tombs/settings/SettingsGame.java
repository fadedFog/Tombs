package ru.fadedfog.tombs.settings;

public class SettingsGame {
	public static final int ZERO = 0;
	public static final int GRAVITATION_PRIMORDIAL = -1;
	public static int gravitation = GRAVITATION_PRIMORDIAL;
	
	public static int getGravitation() {
		return gravitation;
	}
	
	public static void setGravitation(int gravitation) {
		SettingsGame.gravitation = gravitation;
	}
	
	public static void setGravitaionToPrimordial() {
		SettingsGame.gravitation = GRAVITATION_PRIMORDIAL;
	}
	
}
