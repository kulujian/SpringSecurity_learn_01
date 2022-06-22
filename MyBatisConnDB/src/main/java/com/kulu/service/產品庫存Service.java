package com.kulu.service;

import java.util.List;

import com.kulu.domain.產品庫存MS;

public interface 產品庫存Service {

	List<產品庫存MS> findProductBy庫存代號(String model);
}
