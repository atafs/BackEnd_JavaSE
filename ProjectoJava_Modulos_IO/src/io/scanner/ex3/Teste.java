package io.scanner.ex3;

public class Teste {

	public static void main(String[] args) {
		ContaBancaria x = new ContaX();
		// Movimentos sumários, apenas para teste (não era exigido na resposta)
		x.addMovimento(new Movimento(new Data(2,3,2015), 100, 1000));
		x.addMovimento(new Movimento(new Data(4,3,2015), 100, 1100));
		x.addMovimento(new Movimento(new Data(5,3,2015), 100, 1200));
		x.addMovimento(new Movimento(new Data(6,3,2015), 100, 1300));
		x.addMovimento(new Movimento(new Data(7,3,2015), 200, 1500));
		x.addMovimento(new Movimento(new Data(8,3,2015), 100, 1600));
		
		ContaBancaria y = new ContaY();
		y.addMovimento(new Movimento(new Data(2,3,2015), 100, 1000));
		y.addMovimento(new Movimento(new Data(4,3,2015), 100, 1100));
		y.addMovimento(new Movimento(new Data(5,3,2015), 100, 1200));
		y.addMovimento(new Movimento(new Data(6,3,2015), 100, 1300));
		y.addMovimento(new Movimento(new Data(7,3,2015), 200, 1500));
		y.addMovimento(new Movimento(new Data(8,3,2015), 100, 1600));
		
		System.out.println(x.saldoMédioEstimado());
		System.out.println(y.saldoMédioEstimado());
	}

}
