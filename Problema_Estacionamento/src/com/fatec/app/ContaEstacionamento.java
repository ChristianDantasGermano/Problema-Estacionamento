package com.fatec.app;

class ContaEstacionamento {
	
	private CalculoValor calculo; // compondo a classe ContaEstacionamento
	// com um objeto do tipo CalculoValor
	public Veiculo veiculo;

	public double valorConta() {
		return calculo.valorConta(veiculo.tempo, veiculo);
	}

	// valorDiaria, valorMensal, valor....
	// promocao
	public void setCalculo(CalculoValor calculo) {
		this.calculo = calculo;
	}

}
