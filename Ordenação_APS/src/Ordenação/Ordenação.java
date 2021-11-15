package Ordenação;

import java.util.Scanner;

public class Ordenação {
	
	// Algoritmo de ordenação Insertion Sort
	public static void insertionSort(int[] v) {
		int i, j, key;
		for (i = 1; i < v.length; i++) {
			key = v[i];
			for (j = i - 1; (j >= 0) && (v[j] > key); j--) {
				v[j + 1] = v[j];
			}
			v[j + 1] = key;
		}
		
	}
	
	// Algoritmo de ordenação Selection Sort
	 public static void selectionSort(int[] v) {
		 for (int fixo = 0; fixo < v.length - 1; fixo++) {
			 int menor = fixo;
			 
			 for (int i = menor + 1; i < v.length; i++) {
				 if (v[i] < v[menor]) {
					 menor = i;
				 }
			 }
			 if (menor != fixo) {
				 int t = v[fixo];
				 v[fixo] = v[menor];
				 v[menor] = t;
			 }
		 }

	 }
	
	// Algoritmo de ordenação Bubble Sort
	public static void bubbleSort(int[] v) {
		boolean troca = true;
		int aux;
		while (troca) {
			troca = false;
			for (int i = 0; i < v.length - 1; i++) {
				if (v[i] > v[i + 1]) {
					aux = v[i];
					v[i]  = v[i + 1];
					v[i + 1] = aux;
					troca = true;
				}
			}
		}

	}
	
	public static void main(String[] args) {
		int opcao;
		long tempoInicial;
		long tempoFinal;
		int[] v = null;
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		
		do {
			int quant = 100000;
			v = new int[quant];
			
			for (int i = 0; i < v.length; i++) {
				v[i] = (int) (Math.random()*quant);
			}
			System.out.println("\nDeseja ver os números gerados?");
			System.out.println("Digite um número:");
			System.out.println("1-Sim");
			System.out.println("2-Não");
			opcao = s.nextInt();
			if (opcao == 1) {
				for (int i = 0; i < v.length; i++) {
					System.out.print(v[i]+", ");
					if (i % 50 == 0) {
						System.out.print("\n");
					}
				}
			}
			
			System.out.println("\nDigite um número:");
			System.out.println("1-Insertion Sort");
			System.out.println("2-Selection Sort");
			System.out.println("3-Bubble Sort");
			System.out.println("4-Sair");
			opcao = s.nextInt();

			switch(opcao)
			{
			
				case 1 :
					tempoInicial = System.currentTimeMillis();		
					insertionSort(v);
					tempoFinal = System.currentTimeMillis();
					System.out.println("Insertion Sort");
					System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
					break;
				
				case 2 :
					tempoInicial = System.currentTimeMillis();		
					selectionSort(v);
					tempoFinal = System.currentTimeMillis();
					System.out.println("Selection Sort");
					System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
					break;
					
				case 3 :
					tempoInicial = System.currentTimeMillis();		
					bubbleSort(v);
					tempoFinal = System.currentTimeMillis();
					System.out.println("Bubble Sort");
					System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
					break;
					
				case 4 :
					System.out.println("Finalizando...");
					break;
				
				default:
					System.out.println("Digite um numero valido");
					break;
			}
			
			if (opcao == 1 || opcao == 2 || opcao == 3) {
				System.out.println("Deseja ver como os números ficaram?");
				System.out.println("Digite um número:");
				System.out.println("1-Sim");
				System.out.println("2-Não");
				opcao = s.nextInt();
				if (opcao == 1) {
					for (int i = 0; i < v.length; i++) {
						System.out.print(v[i]+", ");
						if (i % 50 == 0) {
							System.out.print("\n");
						}
					}
				}
			}
		}while(opcao != 4);
	}

}
