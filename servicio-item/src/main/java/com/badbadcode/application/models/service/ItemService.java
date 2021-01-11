package com.badbadcode.application.models.service;

import java.util.List;

import com.badbadcode.application.models.entity.Item;
import com.badbadcode.application.models.entity.Producto;

public interface ItemService {

	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);
	
	public Producto save(Producto producto);
	public Producto update(Producto producto, Long id);
	public void delete(Long id);
}