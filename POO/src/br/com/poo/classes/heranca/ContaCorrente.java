package br.com.poo.classes.heranca;

public class ContaCorrente extends ContaBancaria {
		private double limite;
		private double limiteInicial;
		
		
		public ContaCorrente() {}

		public ContaCorrente(double limite) {
			this.limite = limite;
			limiteInicial = limite;
		};
		
		public ContaCorrente(Long numeroBanco, int agencia, Long numeConta, String titular, double saldo, double limite) {
			super.setAgencia(agencia);
			super.setNumeroBanco(numeroBanco);
			super.setNumeroConta(numeConta);
			super.setSaldo(saldo);
			super.setTitular(titular);
			this.limite = limite;
			limiteInicial = limite;
		}
		
		@Override
		public String sacar (double valor) {
				String msg = " ";
				
				if(limite+ super.getSaldo() < valor) {
					msg = "Saldo insuficiente.";
				}
				else if(super.getSaldo() < valor) {
					
					this.limite = this.limite - (valor - super.getSaldo());
					super.setSaldo(0);
					msg = "Saque feito com sucesso.\n Seu limite atual é "+
					this.limite+"\n seu saldo é 0";
				}
				else {
					super.setSaldo(super.getSaldo()-valor);
					msg = "Saldo feito com sucesso. \nSeu novo saldo é:"+super.getSaldo();
				}
				return msg;
		}
		
		@Override
		public String depositar(double valor) {
				
				String msg = "";
				if(limiteInicial != limite) {
					
					super.setSaldo(valor - (limiteInicial - limite));
					limite += limiteInicial - limite;
					msg = "Deposito feito com sucesso.\nSeu saldo é: "
					+super.getSaldo()+"\ne seu limite é "+ limite;
				}
				else {
					super.setSaldo(super.getSaldo()+valor);
					msg = "Deposito realizado.\n Seu saldo é: "+super.getSaldo();
				}
				return msg;
		}
				

}
