package com.idat.javawebavanzado.service;

import java.util.List;

import com.idat.javawebavanzado.model.Clientes;


public interface ClientesService {

	public List<Clientes> getAllClientes();
	
	public Clientes getClientesById(long id);
	
	public void saveOrUpdate(Clientes clientes);
	
	public void deleteClientes(long id);
	
	
}