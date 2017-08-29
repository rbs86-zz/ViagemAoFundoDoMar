package exercicio.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControladorTest {

	@Test
	public void executeMovimentMoveTest() {
		Controlador controlador = new Controlador();
		controlador.executeMoviments("M");
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("0 1 0 NORTE", coordenadas);
	}

}
