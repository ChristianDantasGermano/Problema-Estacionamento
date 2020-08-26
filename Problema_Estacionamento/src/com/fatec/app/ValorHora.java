package com.fatec.app;

public class ValorHora extends CalculoValor {
	
	private final double HORA = 3600000;

	public ValorHora(double valorHora) {
		this.valorParaCalculo = valorHora;
	}

	@Override
	public double valorConta(double tempo, Veiculo veiculo) {
		return valorParaCalculo * Math.ceil(tempo / HORA);
	}

}
