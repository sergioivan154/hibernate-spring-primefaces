package com.sergio.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

public class Mundo implements InitializingBean, DisposableBean {
	
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

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub antes de inicializar
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub despues de destruir
		
	}
	
	
}
