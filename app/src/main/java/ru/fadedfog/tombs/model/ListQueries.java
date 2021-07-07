package ru.fadedfog.tombs.model;

public class ListQueries {
	
	public static final String COUNT_ALL_STEPS = "SELECT COUNT(*) FROM steps";
	public static final String INIT_LINE_STEPS = "INSERT INTO steps(id, number_steps) VALUE (1, 0)";
	public static final String UPDATE_LINE_STEPS = "UPDATE steps SET number_steps = %s WHERE id = 1";

}
