package li260.Plateau.obstacle.impl;

import li260.Plateau.obstacle.Obstacle;

@SuppressWarnings("serial")
public class ObstacleImpl implements Obstacle {
	private int x;
	private int y;
	private int x2;
	private int y2;

	public ObstacleImpl(int i, int j, int k, int l) {
		super();
		this.x = i;
		this.y = j;
		this.x2 = k;
		this.y2 = l;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getX2() {
		return x2;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getY2() {
		return y2;
	}

}
