package Automato;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Auto_Main{
	static String[] xFita;
	static ArrayList<String> xEstadoFinal = new ArrayList<>();
	static ArrayList<String> xAlfabeto = new ArrayList();
	static ArrayList<String> xEstado = new ArrayList();
	static String xTabela[][] = new String[xEstado.size()][xAlfabeto.size()];
	
	//Criação da matriz da tabela de transição
	public static String[][] criarTabela(){	
		 String y[][] = new String[xEstado.size()][xAlfabeto.size()];	
		 int linha, coluna;
		 String valor;
			Scanner scanner = new Scanner(System.in);
			for (linha = 0; linha < xEstado.size(); linha++) {
	            for (coluna = 0; coluna < xAlfabeto.size(); coluna++) {
	            	System.out.println("Entre com o valor da matriz ["+ xEstado.get(linha) +"]["+ xAlfabeto.get(coluna) +"]: ");
	            	valor = scanner.next();
                    y[linha][coluna] = valor;
	            }
			}
			return y;
		}
	
	// para separar valores
	public static ArrayList<String> separandoValor(String valor){
		 ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(valor.split(",")));
		 return arrayList;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String _autoalfabeto = "";
		String _autoestados = "";
		String _autoestadoFinal = "";
		String _autoestadoInicial = "";
		String _autofita= "";
		int opc;
		int testarPalavra;
		
		
		do{
			
			System.out.println("\n    *********MENU*********");
			System.out.println("   1 - Criar Autômato ");
			System.out.println("   0 - Sair           ");
			System.out.println("   ***********************\n");
            System.out.print("Escolha uma opção: ");
			opc = scanner.nextInt();
			System.out.print("\n");
			
			switch (opc) {
			case 1:
				System.out.println("=> Lembrar de separar tudo por virgula ");
				System.out.println("");
				System.out.println("Insira o alfabeto do automato: ");
				_autoalfabeto = scanner.next();
				System.out.println("Insira os estados do automato:");
				_autoestados = scanner.next();
				System.out.println("Insira o estado final do automato:");
				_autoestadoFinal = scanner.next();
				System.out.println("Insira o estado inicial do automato:");
				_autoestadoInicial = scanner.next();
				
				xAlfabeto = separandoValor(_autoalfabeto);
				xEstado = separandoValor(_autoestados);
				xEstadoFinal = separandoValor(_autoestadoFinal);
				System.out.println("\n Quando não ouver transição marque com um x");
				xTabela = criarTabela();
				
				//criando automato com o processamento
				Automato_ini automato_ini = new Automato_ini(xAlfabeto, xEstado, xEstadoFinal, _autoestadoInicial, xTabela);
				
				do{
				System.out.println("Insira a palavra a ser processada:");
				_autofita = scanner.next();
				xFita = _autofita.split(",");
				
				boolean palavraAceita = automato_ini.validacao_palavra(xFita);
		
				if(palavraAceita){
					System.out.println("A palavra foi aceita. \n");
				}else{
					System.out.println("palavra rejeitada. \n");
				}
				
				System.out.println("Deseja inserir outra palavra? 0 - não / 1 - Sim");
				testarPalavra = scanner.nextInt();
				
				}while(testarPalavra != 0);
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}	
		}while (opc != 0);

	}
	
}
