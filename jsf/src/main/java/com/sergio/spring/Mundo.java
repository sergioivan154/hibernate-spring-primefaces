package com.sergio.spring;

import org.springframework.beans.factory.annotation.Value;

public class Mundo {
	
	//@Value("hola ivan")
	private String saludo;
	private Planeta planeta;
	
	
	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

	public Planeta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}
	
	
}
