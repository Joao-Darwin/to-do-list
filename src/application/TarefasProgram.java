package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TarefasProgram {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		boolean execucaoMenu = true;

		System.out.println("---------- Início ----------\n");
		while (execucaoMenu) {
			imprimirMenu();
			int escolhaMenu = sc.nextInt();

			switch (escolhaMenu) {
			case 0: {
				execucaoMenu = false;
				break;
			}
			case 1: {
				adicionarTarefas();
				break;
			}
			case 2: {
				
			}
			case 3: {
				
			}
			case 4: {
				
			}
			case 5: {
				
			}
			default: {
				System.out.println("Opção inválida, escolha novamente!");
			}
			limparTela();
			}
		}

		sc.close();
	}

	public static void limparTela() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static void imprimirMenu() {
		System.out.println("----- Menu -----\n");
		System.out.println("1 - Adicionar Tarefas");
		System.out.println("2 - Consultar Tarefas");
		System.out.println("3 - Atualizar Tarefas");
		System.out.println("4 - Deletar Tarefas");
		System.out.println("5 - Tarefas Concluídas\n");
		System.out.println("0 - Sair\n");
		System.out.print("Escolha: ");
	}

	//Método para "adicionar uma tarefa", em breve decido se vou fazer o acesso ao banco com JDBC ou JPA
	public static void adicionarTarefas() throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Informe o nome da Tarefa: ");
		String nomeTareda = sc.nextLine();

		System.out.print("Prioridade da Tarefa: ");
		int prioridadeTarefa = sc.nextInt();

		Date dataDaTarefa = new Date();

		System.out.print("Informe o prazo para concluir a Tarefa (dd/MM/yyyy): ");
		String dataConclusao = sc.next();
		Date dataConclusaoTarefa = sdf.parse(dataConclusao);

		System.out.println("---------------------");
		System.out.println("Nome Tarefa: " + nomeTareda);
		System.out.println("Prioridade da Tarefa: " + prioridadeTarefa);
		System.out.println("Data de criação: " + sdf.format(dataDaTarefa));
		System.out.println("Dias para Conclusão: " + sdf.format(dataConclusaoTarefa));
	}
}