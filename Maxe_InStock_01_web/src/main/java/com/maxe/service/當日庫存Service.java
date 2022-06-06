package com.maxe.service;

import java.util.List;

import com.maxe.domain.當日庫存;

public interface 當日庫存Service {

	List<當日庫存> findInventory(String date, String model, String storehouse);
}
