package com.jsf.Beans;


import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

import com.jsf.Entidades.Client;
import com.jsf.Utils.HiberneteUtils;

@ManagedBean(name="clientBean")
public class ClientBean {
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void guardarCliente() {
		Session session = HiberneteUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Client cliente = new Client(nombre);
		session.save(cliente);
		session.getTransaction().commit();
		
		session.close();
	}
	

}
