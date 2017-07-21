package com.sergio.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

import com.sergio.entidades.Client;
import com.sergio.utilidades.HibernateUtil;


@ManagedBean
public class ClientBean {
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void guardarCliente() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Client cliente = new Client(nombre);
		session.save(cliente);
		session.getTransaction().commit();
		session.close();
	}
	
	public String getClientes() {
		
		String clientes = "";
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Client> lista = session.createCriteria(Client.class).list();
		for(Client cliente:lista) {
			clientes += cliente.getName() +"\n"; 
		}
		session.close();
		
		
		return clientes;
	}
	
}
