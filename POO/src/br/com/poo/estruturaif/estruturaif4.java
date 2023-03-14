package br.com.poo.estruturaif;

import java.util.Scanner;

public class estruturaif4 {

	public static void main(String[] args) {
			double salario, aliquota;
			Scanner entrada = new Scanner(System.in);
			
			System.out.println("==================== Calculo Contribuição INSS ===============");
			System.out.println("\nDigite seu salario abaixo: \n ");
			salario = entrada.nextDouble();
			
			if (salario <= 1302.00) {
				aliquota = (salario * 7.5)/100; 
				System.out.println("\nO salario informado foi: " +salario);
				System.out.println("\nO seu aliquota é de:  " +aliquota);
			}
			
			else if(salario <= 2571.29) {
				aliquota = (salario * 9.0)/100;
				System.out.println("\nO salario informado foi: " +salario);
				System.out.println("\nO seu aliquota é de:  " +aliquota);
			}
			
			else if(salario <= 3856.94) {
				aliquota = (salario * 12.0)/100;
				System.out.println("\nO salario informado foi: " +salario);
				System.out.println("\nO seu aliquota é de:  " +aliquota);
			}
			else if(salario <= 7507.49) {
				aliquota = (salario * 14.0)/100;
				System.out.println("\nO salario informado foi: " +salario);
				System.out.println("\nO seu aliquota é de:  " +aliquota);
			}
			
			else {
				System.out.println("\nO salario não está na tabela");
			}
	}

}
