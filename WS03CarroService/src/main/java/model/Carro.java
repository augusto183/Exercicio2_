package model;

import java.time.temporal.ChronoUnit;

public class Carro {
	private int id;
	private String marca;
	private String modelo;
	private int ano;
	private String cor;
	private float preco;
	
	public Carro() {
		id = -1;
		marca = "";
		modelo = "";
		ano = java.time.Year.now().getValue();
		cor = "";
		preco = 0.00F;
	}

	public Carro(int id, String marca, String modelo, int ano, String cor, float preco) {
		setId(id);
		setMarca(marca);
		setModelo(modelo);
		setAno(ano);
		setCor(cor);
		setPreco(preco);
	}		
	
	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	/**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa
	 * ser exibido na forma de String.
	 */
	@Override
	public String toString() {
		return "Carro: " + marca + " " + modelo + "   Ano: " + ano + "   Cor: " + cor + "   Preço: R$" + preco;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getID() == ((Carro) obj).getID());
	}	
}
