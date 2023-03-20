package br.com.poo.array;

public class EstruturaArray2 {

	public static void main(String[] args) {
			
			int[] numeros = {432, 755, 92,24,458,7,10,19,30,17,14,77,21};
			
			for(int i = 0 ; i < numeros.length ; i++ ){
				if( numeros [i] % 2 == 0) {
					System.out.println(numeros [i]);
				}
			}
			

	}

}
