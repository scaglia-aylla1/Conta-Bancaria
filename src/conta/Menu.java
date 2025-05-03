package conta;

import java.io.IOException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		//Dados para teste
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);
		
		while(true) {
			System.out.println(Cores.TEXT_PURPLE_BRIGHT + Cores.ANSI_BLACK_BACKGROUND
					         + "********************************************************");
			System.out.println("*                                                      *");
			System.out.println("*              BANCO DO BRAZIL COM Z                   *");
			System.out.println("*                                                      *");
			System.out.println("********************************************************");
			System.out.println("*                                                      *");
			System.out.println("*                                                      *");
			System.out.println("*             1 - Criar Conta                          *");
			System.out.println("*             2 - Listar todas as Contas               *");
			System.out.println("*             3 - Buscar Conta por Número              *");
			System.out.println("*             4 - Atualizar Dados da Conta             *");
			System.out.println("*             5 - Apagar Conta                         *");
			System.out.println("*             6 - Sacar                                *");
			System.out.println("*             7 - Depositar                            *");
			System.out.println("*             8 - Transferir valores entre Contas      *");
			System.out.println("*             9 - Sair                                 *");
			System.out.println("*                                                      *");
			System.out.println("********************************************************");
			System.out.println("*                                                      *");
			System.out.println("* Entre com a opção desejada:                          *");
			System.out.println("********************************************************"+ Cores.TEXT_RESET);
			
			opcao = scan.nextInt();
			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "\nBanco do Brazil com Z - O seu Futuro começa aqui!!");
				sobre();
				scan.close();
				System.exit(0);
			}
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");
				
				System.out.println("Digite o número da Agência: ");
				agencia = scan.nextInt();
				System.out.println("Digite o nome do Titular: ");
				scan.skip("\\R");
				titular = scan.nextLine();
				System.out.println("Digite o tipo da Conta (1 - Conta Corrente | 2 - Conta Poupança): ");
				tipo = scan.nextInt();
				System.out.println("Digite o Saldo inicial da Conta: ");
				saldo = scan.nextFloat();
				
				switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite da Conta: ");
						limite = scan.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do aniversário da Conta: ");
						aniversario = scan.nextInt();
						contas.cadastrar(
								new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
				System.out.println("Digite o número da conta: ");
				numero = scan.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da conta\n\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida\n");
				keyPress();
				break;
			}
			
			
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: Aylla Scaglia");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/scaglia-aylla1");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.err.println("Ocorreu um erro ao tentar ler o teclado");

		}
	}

}
