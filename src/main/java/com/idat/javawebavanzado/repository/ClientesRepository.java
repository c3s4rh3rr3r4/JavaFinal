package com.idat.javawebavanzado.repository;

import org.springframework.data.repository.CrudRepository;

import com.idat.javawebavanzado.model.Clientes;

public interface ClientesRepository extends CrudRepository<Clientes, Long> {

}