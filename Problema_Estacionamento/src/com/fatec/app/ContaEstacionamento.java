package com.fatec.app;

class ContaEstacionamento {
	
	private CalculoValor calculo; // compondo a classe ContaEstacionamento
	// com um objeto do tipo CalculoValor
	public Veiculo veiculo;
	private double inicio, fim;

	public double valorConta() {
		return calculo.valorConta(fim - inicio, veiculo);
	}

	// valorDiaria, valorMensal, valor....
	// promocao
	public void setCalculo(CalculoValor calculo) {
		this.calculo = calculo;
	}

}
