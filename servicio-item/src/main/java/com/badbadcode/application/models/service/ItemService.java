package com.badbadcode.application.models.service;

import java.util.List;

import com.badbadcode.application.models.entity.Item;

public interface ItemService {

	public List<Item> findAll();
	public Item findById(Long id, Integer cantidad);
}