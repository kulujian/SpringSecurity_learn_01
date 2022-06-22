package com.kulu.service;

import java.util.List;

import com.kulu.domain.當日庫存;

public interface 當日庫存Service {

	List<當日庫存> findInventory(String date, String model, String storehouse);
}
