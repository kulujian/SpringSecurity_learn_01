package com.kulu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kulu.entity.MoneyPo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Kulu
 * @since 2022-06-21
 */
public interface MoneyService extends IService<MoneyPo> {

	List<MoneyPo> findByIds(List<Integer> ids);
	
}