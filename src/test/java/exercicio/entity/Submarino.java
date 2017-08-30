package exercicio.entity;

public class Submarino {

	private Coordenadas coordenadas;
	private Direcao direcao;
	
	public Submarino(){
		this.coordenadas = new Coordenadas();
		this.direcao = Direcao.NORTE;
	}

	public Coordenadas getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	public void setDirecao(Direcao direcao) {
		this.direcao = direcao;
	}

}
