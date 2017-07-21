package com.sergio.servicio;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sergio.entidades.Client;

@Path("/ejemplos")
public class ServicioWebEjemplo {
	
	@POST
	@Path("/obtenerClientePorServicio")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Client obtenerClientePorServicio(Client nombre) {
		
		Client cliente = new Client();
		cliente.setName("sergio " + nombre);
		return cliente;
	}

}
