package com.fatec.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Principal {

	public static void main(String[] args) throws ParseException {
		String[] tempPerg = {"dia","mês","ano","horas","minutos","secundos"};
		int[] tempEnt = {0,0,0,0,0,0};//dia, mes , ano , horas , minutos, secundos
		int tipoVeiculo=0;
		Date dataAtual = new Date(System.currentTimeMillis());//Data atual
		Scanner myObj = new Scanner(System.in);
		for(int i =0;i<6;i++) {
			System.out.println("Digite "+tempPerg[i]+":");
			tempEnt[i] = myObj.nextInt();
		}	
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String  dataString= tempEnt[0]+"/"+tempEnt[1]+"/"+tempEnt[2]+" "+tempEnt[3]+":"+tempEnt[4]+":"+tempEnt[5];
		Date dataAtrasada = fmt.parse(dataString); 
		double dataFinal = (dataAtual.getTime()-dataAtrasada.getTime());
		//Escolher tipo de veículo.
		System.out.println("Qual tipo de veículo, sendo: \n"
				+ "0 - Passeio \n"
				+ "1 - Carga \n"
				+ "2 - Coletivo");
		tipoVeiculo = myObj.nextInt();
		myObj.close();
		Veiculo v = null;
		
		switch(tipoVeiculo) {
			case 0:
				v = new Passeio(dataFinal);
				break;
			case 1:
				v = new Carga(dataFinal);
				break;
			case 2:
				v = new  Coletivo(dataFinal);
		}
		
		ContaEstacionamento c = new ContaEstacionamento();
		c.veiculo = v;
		
		CalculoValor cv = null;

		if(v.tempo >((24  * 3600000)*15)) {
			cv = (CalculoValor) new ValorMensal(c.veiculo.valor);
		}
		else if(v.tempo >12  * 3600000) {
			cv = (CalculoValor) new ValorDiaria(c.veiculo.valor);
		}
		else {
			cv = (CalculoValor) new ValorHora(c.veiculo.valor);
		}
		c.setCalculo(cv);
		System.out.println("Valor a ser pago: " +c.valorConta());
	}
	
	

}
