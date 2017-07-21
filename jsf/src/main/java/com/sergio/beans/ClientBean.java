package com.sergio.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sergio.entidades.Client;
import com.sergio.spring.Mundo;
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
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //para no mandar a llamar asi el archivo xml tan directo
		//Mundo m = (Mundo) applicationContext.getBean("mundoBean"); //patron de diseño factory, un id y regresa una instancia
		//Mundo m = (Mundo) applicationContext.getBean(Mundo.class);
		
		Mundo m = (Mundo) applicationContext.getBean("mundoBean"); 
		
		clientes += m.getSaludo() + m.getPlaneta().getNombre();  
		m.setSaludo("nuevo saludo");
		((AbstractApplicationContext) applicationContext).close(); //liberar un recurso
		
		return clientes;
	}
	
	public String getSaludo() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Mundo m = (Mundo) applicationContext.getBean("mundoBean"); 
		((AbstractApplicationContext) applicationContext).close(); //liberar un recurso
		
		return m.getSaludo();
		
	}
}
