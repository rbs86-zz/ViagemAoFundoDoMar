package exercicio.entity;

public class Coordenadas {

	private static final String SPACE = " ";
	private int x;
	private int y;
	private int z;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z > 0 ? 0 : z;
	}

	@Override
	public String toString() {
		return new StringBuilder().append(x).append(SPACE).append(y).append(SPACE).append(getZ()).toString();
	}
}
