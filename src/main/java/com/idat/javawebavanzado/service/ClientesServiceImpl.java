package com.idat.javawebavanzado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idat.javawebavanzado.model.Clientes;
import com.idat.javawebavanzado.repository.ClientesRepository;

@Service
@Transactional
public class ClientesServiceImpl implements ClientesService{

@Autowired
ClientesRepository clientesRepository;
	
	@Override
	public List<Clientes> getAllClientes() {
		return (List<Clientes>) clientesRepository.findAll();
	}

	@Override
	public Clientes getClientesById(long id) {
		return clientesRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Clientes clientes) {
		clientesRepository.save(clientes);
	}

	@Override
	public void deleteClientes(long id) {
		clientesRepository.deleteById(id);
		
	}

	
}