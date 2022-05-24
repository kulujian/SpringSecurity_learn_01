package com.kulu.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kulu.domain.Menu;

public interface MenuMapper extends BaseMapper<Menu>{
	
	List<String> selectPermsByUserid(Long id);

}
