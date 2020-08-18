import java.util.Scanner;

public class BatalhaNaval {

	public static void main(String[] args) {
		Scanner tecladoColuna = new Scanner(System.in);
		Scanner tecladoLinha = new Scanner(System.in);

		String[] colunasArray = new String[] { "A", "B", "C", "D", "E", "F", "G", "H" };

		// Tabuleiro: Utilizado somente para o formato a ser exibido do
		// tabuleiro
		String tabela[][] = new String[8][8];

		// Área do tabuleiro (para ser utilizado valores númericos)
		int area[][] = new int[8][8];

		// Array de navios, totalizando 5. Cada um com seu valor (ponto)
		int navios[] = new int[] { 2, 2, 3, 3, 4 };

		int tiroCol = 0; // Tiro em colunas
		int tiroLin = 0; // Tiro em linhas
		int pontos = 0, acertos = 0, erros = 0;
		int linhas = 0; // Linhas com random
		int cols = 0; // Colunas com random
		int qtdTentativas = 5; // Quantidade de tentativas

		// Abaixo estão sendo inseridos os navios na área do tabuleiro.
		// O if(area[linhas][cols] == 0) compara se o valor atual não foi
		// preenchido por algum navio anterior.
		// Como as váriaveis "linhas" e "colunas" estão com um valor randômico,
		// o valor da área
		// que vier aleatoriamente, será preenchido pelo navio.
		// A varivável contNavios é o contador de navios.
		int contNavios = 0;
		do {
			linhas = (int) (Math.random() * 8); // Linhas
			cols = (int) (Math.random() * 8); // Colunas
			if (area[linhas][cols] == 0) {
				if (contNavios == 0) {
					area[linhas][cols] = navios[0];
				} else if (contNavios == 1) {
					area[linhas][cols] = navios[1];
				} else if (contNavios == 2) {
					area[linhas][cols] = navios[2];
				} else if (contNavios == 3) {
					area[linhas][cols] = navios[3];
				} else if (contNavios == 4) {
					area[linhas][cols] = navios[4];
				}
				contNavios++;
			}

		} while (contNavios < 5);

		System.out.println("*** Batalha Naval ***");
		System.out.println("\nRegras do jogo: O jogo contém um tabuleiro 8x8 com 5 navios nele.");
		System.out.println("Há 2 navios de 2 pontos, 2 navios de 3 pontos e 1 navio de 4 pontos.");
		System.out.println("Caso acerte um navio será marcado X no tabuleiro, caso acerte a água será marcado O.");
		System.out.println("Você tem " + qtdTentativas + " tiros disponíveis.");
		System.out.println("No final do jogo será exibido o local dos navios com seus respectivos pontos.");
		System.out.println("Acerte todos, se puder xD. Boa sorte!\n");

		// No while abaixo, será a quantidade de tentativas de tiros que poderão
		// ser realizados.
		
		while (qtdTentativas > 0) {
			System.out.println("Tentativas restantes: " + qtdTentativas);
			String coluna;
			System.out.print("Escolha a coluna: ");
			coluna = tecladoColuna.nextLine();

			// For utilizado para comparar a letra digitada acima com o array de
			// colunas
			// a letra sendo igual, irá passar o valor do i para o tiroCol
			// Sendo que a posição do A = 0
			// Utilizado o equalsIgnoreCase, pois o == não funciona com
			// comparação de String
			for (int i = 0; i < 8; i++) {
				if (coluna.equalsIgnoreCase(colunasArray[i])) {
					tiroCol = i;
				}

			}

			// Valor adquirido pelo Scanner -1, ou seja, se for digitado 1,
			// irá pegar a primeira linha que a primeira posição do array (0)
			System.out.print("Escolha a linha: ");
			tiroLin = tecladoLinha.nextInt() - 1;
			System.out.println();

			// Ifs utilizados para atribuição de pontos, acertos e erros
			// Caso ocorra algum acerto, será inserido X no tabuleiro, caso
			// contrário insere O
			if (area[tiroLin][tiroCol] == navios[0] || area[tiroLin][tiroCol] == navios[1]) {
				pontos += 2;
				acertos++;
				System.out.println("Acertou o navio de 2 pontos!");
				tabela[tiroLin][tiroCol] = "X";
			} else if (area[tiroLin][tiroCol] == navios[2] || area[tiroLin][tiroCol] == navios[3]) {
				pontos += 3;
				acertos++;
				System.out.println("Acertou o navio de 3 pontos!!");
				tabela[tiroLin][tiroCol] = "X";
			} else if (area[tiroLin][tiroCol] == navios[4]) {
				pontos += 4;
				acertos++;
				System.out.println("Acertou o navio de 4 pontos!!!");
				tabela[tiroLin][tiroCol] = "X";
			}

			else {
				erros++;
				System.out.println("Acertou a água... =/");
				tabela[tiroLin][tiroCol] = "O";
			}

			// Exibir as letras das colunas antes de exibir o tabuleiro
			System.out.print("------------------\n");
			System.out.println(" |A|B|C|D|E|F|G|H|");
			System.out.print("------------------");

			// for utilizado somente para formatar e exibir o tabuleiro
			for (int i = 0; i < 8; i++) {
				System.out.println("");
				System.out.print(i + 1);

				for (int j = 0; j < 8; j++) {

					if (tabela[i][j] != "X" && tabela[i][j] != "O") {
						tabela[i][j] = " ";
					}
					System.out.print("|" + tabela[i][j]);

				}
				System.out.print("|\n------------------");
			}

			// Exibir os pontos, acertos e erros
			System.out.println("\nPontos: " + pontos);
			System.out.println("Acertos no navio: " + acertos);
			System.out.println("Acertos na água: " + erros);
			System.out.println();

			// Contador de tentativas
			qtdTentativas--;

		} // Fim while contTentativas
		tecladoLinha.close();
		tecladoColuna.close();

		// Campo para exibir a resposta do jogo
		System.out.println("**** RESPOSTA ****");
		System.out.print("------------------\n");
		System.out.println(" |A|B|C|D|E|F|G|H|");
		System.out.print("------------------");

		for (int i = 0; i < 8; i++) {
			System.out.println("");
			System.out.print(i + 1);

			for (int j = 0; j < 8; j++) {

				System.out.print("|" + area[i][j]);

			}
			System.out.print("|\n------------------");
		}
	}

}
