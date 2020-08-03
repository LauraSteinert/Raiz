/*******************************************************************/
/*   ACH2001 - Introdução à Programação                            */
/*   EACH-USP - Primeiro Semestre de 2020                          */
/*   Matutino - Prof. Digiampietri                                 */
/*                                                                 */
/*   Segundo Exercício-Programa                                    */
/*                                                                 */
/*   Laura Steinert de Freitas                   10725244          */
/*                                                                 */
/*   Entrega: 06/05                                                */
/*******************************************************************/

/*
	Cálculo para raiz quadrada
*/

public class Raiz {
	/*
		Calcula a raiz quadrada de um valor, com uma determinada
		precisão. Retorna esse valor, ou -1 quando:
		
		* valor < 0
		* epsilon <= 0
		* epsilon >= 1
		
		Parâmetro:
			valor - valor cuja raiz quadrada será calculada
			epsilon - precisão do cálculo
	*/

	static double raizQuadrada(double valor, double epsilon) {
		
		/*
			 Definicao de Variaveis
		*/
		
		double raizZero = 0;
		double raizNewton = 0;
		double raizAnterior;
		double variacao;
		
		/* 
			Verificação de condições para o valor e para epsilon
		
		*/
		
		// Para caso o valor a ser calculado for zero
		if (valor == 0){
			
			return raizNewton;
		}
		// Para caso o valor a ser calculado for menor que zero ou epsilon for menor que zero ou maior que um 
		else if (epsilon <= 0 || epsilon >= 1 || valor < 0){
			
			raizNewton = -1;
			return raizNewton;
			}
		
		// Caso o valor a ser calculado for maior e diferente de zero 
		
		else if (valor > 0){
			
			//Primeiro cálculo da Raiz	
			
			raizZero = valor/2;	
			raizNewton = ((0.5)*(raizZero + (valor/raizZero)));
			variacao = raizNewton - raizZero;
			if(variacao < 0)
				variacao *= -1;
	
			//Loop que irá rodar enquanto variação for maior ou igual a epsilon
			
			do { 
				raizAnterior = raizNewton;
				raizNewton = ((0.5)*(raizNewton + (valor/raizNewton)));
				variacao = (raizNewton - raizAnterior);
				
				// Como variação representa módulo, multiplicar por -1 caso seja negativo 
				if(variacao < 0)
					variacao *= -1;

			} while (variacao >= epsilon);
		} 

		return raizNewton;
	}
			
	/*
		Apenas para seus testes. ISSO SERA IGNORADO NA CORRECAO
	*/
	public static void main(String[] args) {
		// escreva seu código (para testes) aqui

		// Exemplo de teste:
		double valor = 20;
		double epsilon = 0.001;
		System.out.println("Raiz de : "+valor+" = "+raizQuadrada(valor, epsilon));
	}
}