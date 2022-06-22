package com.kulu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kulu.entity.MoneyPo;

//import java.util.List;

/**
 * Created by @author kulu in 14:13 22/06/21.
 */
@Mapper
@Repository 
public interface MoneyMapper extends BaseMapper<MoneyPo> {

	List<MoneyPo> findByIds(List<Integer> ids);
}