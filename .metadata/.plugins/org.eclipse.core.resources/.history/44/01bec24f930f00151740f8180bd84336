package io.scanner.ex3;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public Data() {		
		// para teste apenas (não era exigido na resposta)
		dia = 10;
		mes = 3;
		ano = 2015;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public static int differencaEmDiasEntre(Data data1, Data data2) {
		// errado em geral, ... para teste apenas (não era exigido na resposta)
		return 256 * (Math.abs(data1.getAno()) - data2.getAno()) + 
					  (31 * (Math.abs(data1.getMes() - data1.getMes())) + 
					  (Math.abs(data1.getDia()) - data2.getDia()));
//		return 0;
	}

}
