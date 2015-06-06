package io.scanner.ex3;

public class ContaX extends ContaBancaria {

	@Override
	public double saldoMédioEstimado() {
		if (getLinhasDeMovimentos().isEmpty())
			return 0.0;
		
		int lastIndex = getLinhasDeMovimentos().size() - 1; 
		return getLinhasDeMovimentos().get(lastIndex).getSaldoCorrente() / 2;
	}

}
