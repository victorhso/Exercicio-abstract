package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class App {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Pessoa> lista = new ArrayList<>();

		System.out.print("Quantos contribuintes serão? \nContribuintes: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print("Pessoa física (f) ou Pessoa jurídica (j)? \nPessoa: ");
			char pessoa = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Renda anual: R$");
			double renda = sc.nextDouble();

			if (pessoa == 'f') {
				System.out.print("Gastos com a saúde: R$");
				double gastos = sc.nextDouble();
				lista.add(new PessoaFisica(nome, renda, gastos));
			} 
			else {
				System.out.print("Número de funcionários: ");
				int func = sc.nextInt();
				lista.add(new PessoaJuridica(nome, renda, func));
			}
			System.out.println("-------------------------------------------------");
		}

		Double soma = 0.0;
		System.out.println();
		System.out.println("--------- Taxas pagas --------");
		System.out.println();

		for (Pessoa x : lista) {
			System.out.println(x.getNome() + ": R$" + String.format("%.2f", x.taxa()));
			soma += x.taxa();
		}

		System.out.println();
		System.out.print("Total de taxas pagas: R$" + String.format("%.2f",soma));

		sc.close();
	}
}
