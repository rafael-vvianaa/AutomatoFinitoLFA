package Automato;

import java.util.ArrayList;

public class Automato_ini{
	private String auto_EstadoInicial;
	private ArrayList<String> auto_Estados = new ArrayList<String>();
	private ArrayList<String> auto_EstadosFinais = new ArrayList<String>();
	private ArrayList<String> auto_Alfabeto = new ArrayList<String>();
	private String auto_Tabela[][] = new String[auto_Estados.size()][auto_Alfabeto.size()];
	
	public Automato_ini(ArrayList<String> _autoalfabeto, ArrayList<String> _autoestados,
		   ArrayList<String> _autoestadoFinal, String _autoestadoInicial, String _autotabela[][]){
		
		this.auto_Alfabeto = _autoalfabeto;
		this.auto_Estados = _autoestados;
		this.auto_EstadoInicial = _autoestadoInicial;
		this.auto_EstadosFinais = _autoestadoFinal;
		this.auto_Tabela = _autotabela;
   }
	
	public String existeTransicao( String auto_estadoAtual, String simbolo_da_Fita){
		String transicao = "x";
		for(int linha = 0; linha <= auto_Estados.size(); linha++ ){
			for(int coluna = 0; coluna <= auto_Alfabeto.size(); coluna++){
				if(auto_Estados.get(linha).equals(auto_estadoAtual) && auto_Alfabeto.get(coluna).equals(simbolo_da_Fita)){
					if(auto_Tabela[linha][coluna] != "x"){
						transicao = auto_Tabela[linha][coluna];
						return transicao;
					}
				}
			}
		}
		return transicao;
	}
	
		public boolean validacao_palavra(String[] fita){
			String auto_estadoAtual = this.getAuto_EstadoInicial();
			String transicao = "";
			for(int i = 0; i < fita.length; i++){
				transicao = existeTransicao( auto_estadoAtual, fita[i]);
				if(transicao != "x"){
					auto_estadoAtual = transicao;
				}else{
					return false;
				}
			}
			
			if(auto_EstadosFinais.contains(auto_estadoAtual)){  
				return true;
			}else{
				return false;
			}
			
		}
		
		
}