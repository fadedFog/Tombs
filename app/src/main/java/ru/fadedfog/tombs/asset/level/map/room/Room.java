package ru.fadedfog.tombs.asset.level.map.room;

import java.util.List;

import ru.fadedfog.tombs.asset.level.element.climb.ClimbItem;
import ru.fadedfog.tombs.asset.level.element.container.Container;
import ru.fadedfog.tombs.asset.level.element.control_point.ControlPoint;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.trap.Trap;


public class Room {
	private TypeRoom typeRoom;
	private List<Surface> surfaces;
	private List<Trap> traps;
	private List<ClimbItem> climbItems;
	private List<Container> containers;
	private ControlPoint controlPoint;
	
	public Room() {
		
	}
	
	public Room(TypeRoom typeRoom,List<Surface> surfaces, List<Trap> traps, List<ClimbItem> climbItems,
			List<Container> containers, ControlPoint controlPoint) {
		this.setTypeRoom(typeRoom);
		this.surfaces = surfaces;
		this.traps = traps;
		this.climbItems = climbItems;
		this.containers = containers;
		this.controlPoint = controlPoint;
	}
	
	public TypeRoom getTypeRoom() {
		return typeRoom;
	}

	public void setTypeRoom(TypeRoom typeRoom) {
		this.typeRoom = typeRoom;
	}
	
	public List<Surface> getSurfaces() {
		return surfaces;
	}
	
	public void setSurfaces(List<Surface> surfaces) {
		this.surfaces = surfaces;
	}

	public List<Trap> getTraps() {
		return traps;
	}

	public void setTraps(List<Trap> traps) {
		this.traps = traps;
	}

	public List<ClimbItem> getClimbItems() {
		return climbItems;
	}

	public void setClimbItems(List<ClimbItem> climbItems) {
		this.climbItems = climbItems;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	public ControlPoint getControlPoint() {
		return controlPoint;
	}

	public void setControlPoint(ControlPoint controlPoint) {
		this.controlPoint = controlPoint;
	}
	
}
