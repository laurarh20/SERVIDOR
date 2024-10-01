package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Cliente;

@RestController
public class ClienteController {
	
	List<Cliente>clientes = new ArrayList<>();	
	
	public ClienteController() {
		
		Cliente cli1 = new Cliente(1, "Laura", "lrubio", "lorisita");
		Cliente cli2 = new Cliente(2, "Andres", "avelino", "andresit");
		Cliente cli3 = new Cliente(3, "tay", "nmoreda", "taysit");
		Cliente cli4 = new Cliente(4, "Rosi", "rdelgado", "Rosarit");
		
		clientes.add(cli1);
		clientes.add(cli2);
		clientes.add(cli3);
		clientes.add(cli4);

	}

	@GetMapping("/clientes")
	public List<Cliente> datosClientes() {
		
		return clientes;
		
	}
	
	@GetMapping("/clientes/{username}")
	public Cliente datosCliente(@PathVariable String username) {
		
		Cliente cli = null;
				
		for(Cliente cliente : clientes) {
			if(cliente.getUsername().equals(username)) {
				cli = cliente;
			}
			
			}
		return cli;
	}
	
	
	@PostMapping("/clientes")
	public Cliente addCliente (@RequestBody Cliente cliente) {
		
		int idN=cliente.getId();
		String user=cliente.getUsername();
		String contra=cliente.getPassword();
		String nombr=cliente.getNombre();
		
		Cliente clienteNuevo=new Cliente(idN,nombr,user,contra);
		return clienteNuevo;
		
		
	}
}
