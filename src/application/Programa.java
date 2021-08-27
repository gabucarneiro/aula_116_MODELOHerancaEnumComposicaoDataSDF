package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import entities.Departamento;
import entities.HoraContrato;
import entities.Trabalhador;
import entities.enums.NivelTrabalhador;

import java.util.Date;

public class Programa {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Date hoje = new Date();
		System.out.println(sdf.format(hoje));
		System.out.println();
		
		System.out.println("--- DEPARTAMENTO ---");
		System.out.print("Departamento: ");
		String departamento = sc.next();
		System.out.println();
		
		System.out.println("--- INFORMAÇÕES DO TRABALHADOR ---");
		System.out.print("Nome: ");
		String nome = sc.next();
		System.out.print("Level: ");
		String level = sc.next();
		System.out.print("Salario base: ");
		Double salarioBase = sc.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(level), salarioBase, new Departamento (departamento));
		System.out.println();
		
		System.out.println("--- CONTRATOS ---");
		System.out.print("Número de contratos: ");
		int n = sc.nextInt();
		System.out.println();
		
		for(int i=0; i<n; i++) {
			System.out.printf("-- Contrato #%d --%n", (i+1));
			System.out.print("Data (DD/MM/YYYY): ");
			Date data = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			Double valorPorHora = sc.nextDouble();
			System.out.print("Duração (horas): ");
			Integer horas = sc.nextInt();
			HoraContrato contrato = new HoraContrato(data, valorPorHora, horas);
			trabalhador.addContrato(contrato);
			System.out.println();
		}
		System.out.println("--- ENTRADAS ---");
		System.out.print("Entre com o mês e o ano para calcular as entradas (MM/YYYY): ");
		String entradas = sc.next();
		int ano = Integer.parseInt(entradas.substring(3));
		int mes = Integer.parseInt(entradas.substring(0, 2));
		System.out.println("Nome: "+ trabalhador.getNome());
		System.out.println("Departamento: "+ trabalhador.getDepartamento().getNome());
		System.out.println("Entradas para "+entradas+": R$"+String.format("%.2f", trabalhador.entradas(ano, mes)));
		
		sc.close();
	}
}
