package conta.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import conta.model.Conta;
import conta.repository.ContaRepository;
import conta.util.Cores;

public class ContaController implements ContaRepository{
	
	//Criar Collection ArrayList
	private ArrayList<Conta> listarContas = new ArrayList<Conta>();
	
	//Variável para controlar os números das contas
	int numero = 0;
	

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		if(conta != null)
			conta.visualizar();
		else
			System.out.printf("\nA Conta %d não foi encontrada!!", numero);
		
	}

	@Override
	public void listarTodas() {
		for(var conta : listarContas) {
			conta.visualizar();
		}
		
	}
	
	@Override
	public void listarPorTitular(String titular) {
		List<Conta> listaTitulares = listarContas.stream()
				.filter(c -> c.getTitular().toUpperCase().contains(titular.toUpperCase()))
				.collect(Collectors.toList());
		
		if(listaTitulares.isEmpty())
			System.out.printf("\nNenhuma conta foi encontrada com base no critério: %s", titular);
		
		for(var conta : listaTitulares)
			conta.visualizar();
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listarContas.add(conta);
		System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "A Conta foi criada com sucesso!!");
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());

		if (buscaConta != null) {
			listarContas.set(listarContas.indexOf(buscaConta), conta);
			System.out.println("\nA Conta numero: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("\nA Conta numero: " + conta.getNumero() + " não foi encontrada!");

	}

	@Override
	public void deletar(int numero) {
		 var conta = buscarNaCollection(numero);
			
			if (conta != null) {
				if(listarContas.remove(conta) == true)
					System.out.println("\nA Conta numero: " + numero + " foi deletada com sucesso!");
			}else
				System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
		
	}

	@Override
	public void sacar(int numero, float valor) {
		 var conta = buscarNaCollection(numero);
			
			if (conta != null) {
				
				if(conta.sacar(valor) == true)
					System.out.println("\nO Saque na Conta numero: " + numero + " foi efetuado com sucesso!");		
			
			}else
				System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
		
	}

	@Override
	public void depositar(int numero, float valor) {
		var conta = buscarNaCollection(numero);

		if (conta != null) {
			conta.depositar(valor);
			System.out.println("\nO Depósito na Conta numero: " + numero + " foi efetuado com sucesso!");
		} else
			System.out.println(
					"\nA Conta numero: " + numero + " não foi encontrada ou a Conta destino não é uma Conta Corrente!");

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem != null && contaDestino != null) {
							
				if (contaOrigem.sacar(valor) == true) {
					contaDestino.depositar(valor);
					System.out.println("\nA Transferência foi efetuado com sucesso!");
				}
		}else
			System.out.println("\nA Conta de Origem e/ou Destino não foram encontradas!");
		
	}
	
	//Metódos auxiliares
	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for(var conta : listarContas) {
			if(conta.getNumero() == numero) 
				return conta;
		}
		return null;
	}



}
