package conta.model;

import java.text.NumberFormat;

public class Conta {
	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}
	public Conta() {}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public boolean sacar(float valor) {
		if(this.saldo < valor) {
			System.out.println("\nSaldo não é sufciente!");
			return false;
		}
		this.saldo -= valor;
		return true;
	}
	public void depositar(float valor) {
		this.saldo += valor;
		
	}
	
	
	
	public void visualizar() {
		
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		
		String tipoString = "";
		switch(this.tipo) {
		case 1 -> tipoString = "Conta Corrente";
		case 2 -> tipoString = "Conta Poupança";
		case 3 -> tipoString = "Inválido";
		}
		
		System.out.println("*******************************");
		System.out.println("*****_DADOS DA CONTA_**********");
		System.out.println("********************************");
		System.out.println("Número da Conta: " + this.numero);
		System.out.println("Número da Agência: " + this.agencia);
		System.out.println("Tipo da Conta: " + tipoString);
		System.out.println("Titular da Conta: " + this.titular);
		System.out.println("Saldo da Conta: " + nfMoeda.format(this.saldo));
	}

}
