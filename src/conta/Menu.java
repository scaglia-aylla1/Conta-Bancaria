package conta;

import java.util.Scanner;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int opcao;
		Conta c1 = new Conta(1, 123, 1, "Aylla", 500000);
		c1.visualizar();
		
		c1.sacar(100);
		c1.visualizar();
		
		c1.setTitular("Aylla Scaglia");
		c1.depositar(200000);
		c1.visualizar();
		
		ContaCorrente cc1 = new ContaCorrente(2, 456, 1, "Renata Negrini", 600000, 60000);
		cc1.visualizar();
		cc1.sacar(659000);
		cc1.visualizar();
		cc1.depositar(50000);
		cc1.visualizar();
		
		ContaPoupanca cc2 = new ContaPoupanca(3, 789, 2, "Aylla Scaglia", 70000, 12);
		cc2.visualizar();
		
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
				scan.close();
				System.exit(0);
			}
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta\n\n");
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da conta\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre Contas\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção Inválida\n");
			}
			
		}
		

	}

}
