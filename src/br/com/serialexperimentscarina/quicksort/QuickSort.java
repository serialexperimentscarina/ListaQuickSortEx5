package br.com.serialexperimentscarina.quicksort;

public class QuickSort {
	
	public QuickSort() {
		super();
	}
	
	public void ordenar(int[] vetor, int inicio, int fim) {
		// Verifica se é um vetor de mais de 1 posição
		// Caso seja de 1 posição, já está ordenado
		if (inicio < fim) {
			int posicaoPivo = dividir(vetor, inicio, fim);
			ordenar(vetor, inicio, posicaoPivo - 1);
			ordenar(vetor, posicaoPivo + 1, fim);
		}
	}
 	
	private int dividir(int[] vetor, int inicio, int fim) {
		// - Defina, arbitrariamente, a primeira posição como um pivô, portanto, a validação será feita da 2ª posição até a última
		int pivo = vetor[inicio];
		
		// - Marcar a segunda posição com um ponteiro da esquerda e a última com um ponteiro da direita
		int pontEsquerda = inicio + 1;
		int pontDireita = fim;
		
		// Enquanto o ponteiro da esquerda se mantiver à esquerda do ponteiro da direita
		while(pontEsquerda <= pontDireita) {
			// Enquanto o valor do ponteiro da esquerda for menor ou igual ao valor do pivô e o ponteiro da esquerda continuar à esquerda do ponteiro da direita, o ponteiro
			// da esquerda incrementa 1
			while(pontEsquerda <= pontDireita && vetor[pontEsquerda] <= pivo) {
				pontEsquerda++;
			}
			
			// - Enquanto o valor do ponteiro da direita for maior que o pivô e o ponteiro da esquerda continuar à esquerda ou igualar ao ponteiro da direita, o ponteiro da
			// direita decrementa 1
			while(pontEsquerda <= pontDireita && vetor[pontDireita] >= pivo) {
				pontDireita--;
			}
			
			// Se incremento do ponteiro da esquerda e decremento do ponteiro da direita cessarem, mas o ponteiro da esquerda continuar à esquerda do ponteiro da
			// direita, os valores cujos índices forem, ponteiro da esquerda e ponteiro da direita, mudam de lugar. Incrementa-se o ponteiro da esquerda e decrementa-se o
			// ponteiro da direita
			if(pontEsquerda < pontDireita) {
				trocar(vetor, pontEsquerda, pontDireita);
				pontEsquerda++;
				pontDireita--;
			}
		}
		
		// Quando o ponteiro da direita, passar à esquerda do ponteiro da esquerda, o valor do pivô troca de lugar com o valor cujo índice é o ponteiro da direita
		trocar(vetor, inicio, pontDireita);
		// A partir desse momento, com o pivô em algum lugar entre o início e o fim do vetor inicial, este valor já está na sua posição definitiva
		return pontDireita;
	}

	private void trocar(int[] vetor, int i, int j) {
		int temp = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = temp;
	}
	
	

}
