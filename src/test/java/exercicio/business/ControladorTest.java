package exercicio.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exercicio.entity.Submarino;

public class ControladorTest {

	private Controlador controlador;
	private Submarino submarino;

	@Before
	public void setUp() {
		this.submarino = new Submarino();
		this.controlador = new Controlador(this.submarino);
	}

	@Test
	public void executeMovimentMoveTest() {
		controlador.executeMovements("M");
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("0 1 0 NORTE", coordenadas);
	}

	@Test
	public void executeMovimentLeftTest() {
		controlador.executeMovements("L");
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("0 0 0 OESTE", coordenadas);
	}

	@Test
	public void executeMovimentRightTest() {
		controlador.executeMovements("R");
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("0 0 0 LESTE", coordenadas);
	}

	@Test
	public void executeMovimentDownTest() {
		controlador.executeMovements("D");
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("0 0 -1 NORTE", coordenadas);
	}

	@Test
	public void executeMovimentUpTest() {
		controlador.executeMovements("D");
		controlador.executeMovements("D");
		controlador.executeMovements("U");
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("0 0 -1 NORTE", coordenadas);
	}

}
