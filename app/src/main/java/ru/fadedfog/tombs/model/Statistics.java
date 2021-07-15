package ru.fadedfog.tombs.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statistics {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	public Long id;
	private int numberStepsUser;
	
	public Statistics() {}
	
	public Statistics(int numberStepsUser) {
		this.numberStepsUser = numberStepsUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getNumberStepsUser() {
		return numberStepsUser;
	}

	public void setNumberStepsUser(int numberStepsUser) {
		this.numberStepsUser = numberStepsUser;
	}
	
	@Override
	public String toString() {
		return String.format(
		        "Statistics[id=%d, numberStepsUser='%s']",
		        id, numberStepsUser);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numberStepsUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Statistics other = (Statistics) obj;
		return numberStepsUser == other.numberStepsUser;
	}
	
}
