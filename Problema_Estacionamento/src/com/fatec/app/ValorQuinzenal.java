package com.fatec.app;

public class ValorQuinzenal extends CalculoValor {
	private final double QUINZENAL = 1296000000;

	public ValorQuinzenal(double valorQuinzenal) {
		valorParaCalculo = valorQuinzenal;
	}

	@Override
	public double valorConta(double tempo, Veiculo veiculo) {
		return valorParaCalculo * Math.ceil(tempo / QUINZENAL);
	}
}
