package com.badbadcode.application.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.badbadcode.application.commons.models.entity.Producto;
import com.badbadcode.application.models.entity.Item;


@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService{

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-producto/listar", Producto[].class));
		
		return productos.stream()
						.map( producto -> new Item(producto, 1))
						.collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {

		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		
		Producto producto = clienteRest.getForObject("http://servicio-producto/ver/{id}", Producto.class, pathVariable);
		
		return new Item(producto, cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		
		HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
		
		ResponseEntity<Producto> response = clienteRest.exchange("http://servicio-producto/crear", HttpMethod.POST, body, Producto.class);
		Producto productoResponse = response.getBody();
		
		return productoResponse;
	}

	@Override
	public Producto update(Producto producto, Long id) {
		
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		
		HttpEntity<Producto> body = new HttpEntity<Producto>(producto);
		
		ResponseEntity<Producto> response = clienteRest.exchange("http://servicio-producto/editar/{id}", HttpMethod.PUT, body, Producto.class, pathVariable);
		Producto productoResponse = response.getBody();
		
		return productoResponse;
	}

	@Override
	public void delete(Long id) {
		Map<String, String> pathVariable = new HashMap<String, String>();
		pathVariable.put("id", id.toString());
		
		clienteRest.delete("http://servicio-producto/eliminar/{id}", pathVariable);
	}

}