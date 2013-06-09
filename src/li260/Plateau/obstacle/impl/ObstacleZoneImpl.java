package li260.Plateau.obstacle.impl;

import li260.Plateau.circuit.zone.Zone;
import li260.Plateau.obstacle.ObstacleZone;

@SuppressWarnings("serial")
public class ObstacleZoneImpl extends ObstacleImpl implements ObstacleZone {
	private Zone type;
	
	public ObstacleZoneImpl(Zone type, int i, int j, int k, int l) {
		super(i, j, k, l);
		this.type = type;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Zone getZone() {
		// TODO Auto-generated method stub
		return type;
	}

}
