package com.kulu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kulu.entity.MoneyPo;
import com.kulu.service.impl.StoryMoneyServiceImpl;
import com.kulu.service.impl.TestMoneyServiceImpl;

import java.util.Arrays;
import java.util.List;

/**
 * @author kulu
 * @date 22/06/21
 */
@SpringBootApplication
@MapperScan("com.kulu.mapper")
public class Application {

//    public Application(TestMoneyServiceImpl testMoneyService, StoryMoneyServiceImpl storyMoneyService) {
//        List<MoneyPo> moneyPoList = testMoneyService.listByIds(Arrays.asList(1, 1000));
//        System.out.println(moneyPoList);
//        System.out.println("--------------");
//
//        moneyPoList = storyMoneyService.listByIds(Arrays.asList(1, 1000));
//        System.out.println(moneyPoList);
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}