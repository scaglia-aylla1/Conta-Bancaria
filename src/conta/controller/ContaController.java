package conta.controller;

import java.util.ArrayList;

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
	public void cadastrar(Conta conta) {
		listarContas.add(conta);
		System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "A Conta foi criada com sucesso!!");
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
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
