package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Worker;
import entities.Department;
import entities.HourContract;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date hoje = new Date();
		
		System.out.println(sdf.format(hoje));
		System.out.println();
		System.out.println("--- DEPARTMENT ---");
		System.out.print("Enter department's name: ");
		String department = sc.next();
		System.out.println();
		System.out.println("--- WORKER ---");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Level: (JUNIOR/MID_LEVEL/SENIOR)");
		String level = sc.next();
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department));

		System.out.println();
		System.out.println("--- CONTRACTS ---");
		System.out.print("Number of contracts: ");
		int n = sc.nextInt();
		System.out.println();		
		
		for(int i=0; i<n; i++) {
			System.out.println("-- Contract N#"+(i+1)+" --");
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf1.parse(sc.next());
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(date, valuePerHour, hours);
			worker.addContract(contract);
			System.out.println();
		}
		
		System.out.println("--- INCOMINGS ---");
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String dateIncome = sc.next();
		int month = Integer.parseInt(dateIncome.substring(0,2));
		int year = Integer.parseInt(dateIncome.substring(3));
		System.out.println("Name: "+ worker.getName());
		System.out.println("Department: "+ worker.getDepartment().getName());
		System.out.println("Income for "+dateIncome+": R$"+ worker.income(year, month));
		
		sc.close();
	}

}
