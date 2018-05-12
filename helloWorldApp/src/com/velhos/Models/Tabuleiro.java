package com.velhos.Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tabuleiro {
	Map<Peca, String> tabla = new HashMap<Peca, String>();
	List<String> positions;
	
	public Tabuleiro() 
	{
		positions = new ArrayList<String>();
		positions.add("A1");
		positions.add("A2");
		positions.add("A3");
		positions.add("A4");
		positions.add("B1");
		positions.add("B2");
		positions.add("B3");
		positions.add("B4");
		positions.add("C1");
		positions.add("C2");
		positions.add("C3");
		positions.add("C4");
		positions.add("D1");
		positions.add("D2");
		positions.add("D3");
		positions.add("D4");
	}
	
	public void JogarPeca(Peca peca, String position) 
	{
		if(position.contains(position) && !tabla.containsValue(position)) 
		{
			this.tabla.put(peca, position);
		}
	}
}
