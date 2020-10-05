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
	
}