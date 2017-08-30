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
		controlador.addMovements("M");
		controlador.executeMovements();
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("0 1 0 NORTE", coordenadas);
	}

	@Test
	public void executeMovimentLeftTest() {
		controlador.addMovements("L");
		controlador.executeMovements();
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("0 0 0 OESTE", coordenadas);
	}

	@Test
	public void executeMovimentRightTest() {
		controlador.addMovements("R");
		controlador.executeMovements();
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("0 0 0 LESTE", coordenadas);
	}

	@Test
	public void executeMovimentDownTest() {
		controlador.addMovements("D");
		controlador.executeMovements();
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("0 0 -1 NORTE", coordenadas);
	}

	@Test
	public void executeMovimentUpTest() {
		controlador.addMovements("D");
		controlador.addMovements("D");
		controlador.addMovements("U");
		controlador.executeMovements();
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("0 0 -1 NORTE", coordenadas);
	}

	@Test
	public void executeMultipleMovimentsTest() {
		controlador.addMovements("LMRDDMMUU");
		controlador.executeMovements();
		String coordenadas = controlador.recuperarCoordenadasSubmarino();
		assertEquals("-1 2 0 NORTE", coordenadas);
	}
}
