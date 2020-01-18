package com.idat.javawebavanzado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.idat.javawebavanzado.model.Clientes;
import com.idat.javawebavanzado.service.ClientesService;

@Controller
@RequestMapping(value="/clientes")
public class ClientesController {

@Autowired
ClientesService clientesService;

@RequestMapping(value="/list", method=RequestMethod.GET)
public ModelAndView list() {
	ModelAndView model = new ModelAndView("clientes_list");
	List<Clientes> clientesList = clientesService.getAllClientes();
	model.addObject("clientesList", clientesList);
	
	return model;
}

@RequestMapping(value="/addClientes", method=RequestMethod.GET)
public ModelAndView addClientes() {
	ModelAndView model = new ModelAndView();
	
	Clientes clientes = new Clientes ();
	model.addObject("clientesForm", clientes);
	model.setViewName("clientes_form");
	
	return model;
}

@RequestMapping(value="/updateClientes/{id}", method=RequestMethod.GET)
public ModelAndView editClientes(@PathVariable long id) {
	ModelAndView model = new ModelAndView();
	
	Clientes clientes = clientesService.getClientesById(id);
	model.addObject("clientesForm", clientes);
	model.setViewName("clientes_form");
	
	return model;
}

@RequestMapping(value="/saveClientes", method=RequestMethod.POST)
public ModelAndView save(@ModelAttribute("clientesForm")Clientes clientes) {
	clientesService.saveOrUpdate(clientes);
	
	return new ModelAndView("redirect:/clientes/list");
}

@RequestMapping(value="/deleteClientes/{id}", method=RequestMethod.GET)
public ModelAndView delete(@PathVariable("id") long id) {
	clientesService.deleteClientes(id);
	
	return new ModelAndView("redirect:/article/list");
}

}
