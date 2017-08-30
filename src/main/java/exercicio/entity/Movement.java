package exercicio.entity;

import exercicio.exception.IllegalMovement;

public enum Movement {
	M, L, R, U, D;

	public static Movement parse(String mov) throws IllegalMovement {
		for (Movement movement : Movement.values()) {
			if (movement.toString().equals(mov)) {
				return movement;
			}
		}
		throw new IllegalMovement("Ação não permitida!");
	}
}
