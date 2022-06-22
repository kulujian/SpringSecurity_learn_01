package com.kulu.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kulu.entity.MoneyPo;
import com.kulu.mapper.MoneyMapper;
import com.kulu.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author kulu
 * @since 2022-06-21
 */

@Service
@DS("story")
public class StoryMoneyServiceImpl extends ServiceImpl<MoneyMapper, MoneyPo> implements MoneyService {
	
    @Autowired
    private MoneyMapper moneyMapper;

    @Override
    public List<MoneyPo> findByIds(List<Integer> ids) {
        return moneyMapper.findByIds(ids);
    }
}