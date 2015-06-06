package io.scanner.ex3;


public class ContaY extends ContaBancaria {

	@Override
	public double saldoMédioEstimado() {
		if (getLinhasDeMovimentos().isEmpty())
			return 0.0;

		double soma = 0.0;
		int nDias = 0;
		for(Movimento m: getLinhasDeMovimentos()) {
			Data dInicial = m.getData(); 
			Data dFinal = dataDoMovimentoSeguinte(m);
			int d = Data.differencaEmDiasEntre(dFinal, dInicial);
			soma += m.getSaldoCorrente() * d;
			nDias += d; 
		}		
		
		return soma / nDias;
		
	}

	private Data dataDoMovimentoSeguinte(Movimento m) {
		Data dFinal = null;
		int i = getLinhasDeMovimentos().indexOf(m);
		if (i == - 1 || i == getLinhasDeMovimentos().size() - 1)
			dFinal = new Data();
		else {			
			dFinal = getLinhasDeMovimentos().get(i + 1).getData();
		}
		return dFinal;
	}

}
