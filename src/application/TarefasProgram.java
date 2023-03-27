package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TarefasProgram {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Bem vindo ao seu Gerenciador de Tarefas!\n");
		
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
		sc.close();
	}
}	