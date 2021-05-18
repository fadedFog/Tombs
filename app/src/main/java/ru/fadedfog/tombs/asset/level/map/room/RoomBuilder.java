package ru.fadedfog.tombs.asset.level.map.room;

import java.util.List;

import ru.fadedfog.tombs.asset.level.element.climb.ClimbItem;
import ru.fadedfog.tombs.asset.level.element.container.Container;
import ru.fadedfog.tombs.asset.level.element.control_point.ControlPoint;
import ru.fadedfog.tombs.asset.level.element.surface.Surface;
import ru.fadedfog.tombs.asset.level.element.trap.Trap;

public class RoomBuilder {
	private Room room;
	
	public void setTypeRoom(TypeRoom typeRoom) {
		if (isRoomNull()) {
			createRoom();
		}
		room.setTypeRoom(typeRoom);
	}
	
	public void setControlPoint(ControlPoint controlPoint) {
		if (isRoomNull()) {
			createRoom();
		}
		room.setControlPoint(controlPoint);
	}
	
	public void setContainers(List<Container> containers) {
		if ( isRoomNull() ) {
			createRoom();
		}
		room.setContainers(containers);
	}
	
	public void setClimbItems(List<ClimbItem> climbItems) {
		if ( isRoomNull() ) {
			createRoom();
		}
		room.setClimbItems(climbItems);
	}
	
	public void setTraps(List<Trap> traps) {
		if ( isRoomNull() ) {
			createRoom();
		}
		room.setTraps(traps);
	}
	
	public void setSurfaces(List<Surface> surfaces) {
		if ( isRoomNull() ) {
			createRoom();
		}
		room.setSurfaces(surfaces);
	}
	
	private boolean isRoomNull() {
		return room == null;
	}
	
	private void createRoom() {
		room = new Room();
	}

	public Room getRoom() {
		return room;
	}
	
	public void reset() {
		room = null;
	}
}
