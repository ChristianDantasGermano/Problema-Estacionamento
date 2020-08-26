package com.fatec.app;

public interface CalculoValor {

	protected double valorParaCalculo;
	public abstract double valorConta(double tempo, Veiculo veiculo);
}
