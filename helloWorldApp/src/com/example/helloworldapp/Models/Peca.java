package com.example.helloworldapp.Models;

public class Peca {
		public String _type = "";
		
		public Peca(String type) 
		{
			if(type.equals("X") || type.equals("O"))
				this._type = type;
		}
}
