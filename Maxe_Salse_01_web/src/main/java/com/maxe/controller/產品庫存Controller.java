package com.maxe.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maxe.domain.ResponseResult;
import com.maxe.domain.產品庫存MS;
import com.maxe.service.產品庫存Service;

@CrossOrigin 	// 加在方法上，只允許加註方法跨域請求(此註解無細部設定，算是快速開啟跨域連線的小撇步) 
@RestController
@RequestMapping(path = "/product")
public class 產品庫存Controller {

	@Autowired
	private 產品庫存Service 產品庫存service;
	
	@RequestMapping(path = "/search", method = RequestMethod.POST) //RequestBody  String  model) {// 
//	public List<產品庫存MS> findProductBy庫存代號(@RequestBody  Map<String, String>  model) {// RequestParam(name = "model") String  model) {
	public ResponseResult findProductBy庫存代號(@RequestBody  Map<String, String>  model) {// RequestParam(name = "model") String  model) {
		System.out.println("controller " + model.get("model"));
		List<產品庫存MS> models = 產品庫存service.findProductBy庫存代號(model.get("model"));
//		System.out.println(models.size());

        if(models.size() == 0){
            return new ResponseResult<>(200, "<br><h1>產品【 "+model.get("model")+" 】查無資料</h1>", models);
        }
        int mgicNum = 0;

        String response_top =
        		"<div class='container kulu-table-config' style='border: 1px solid #000 ;'>"+
        		"    <div class='row'>"+
        		"        <div class='col-12'>"+
        		"            更新時間<br>"+models.get(0).get異動時間()+
        		"        </div>"+
        		"    </div>"+
        		"</div><p />";
        String response_body =
        		"<div class='container kulu-table-config' style='border: 1px solid #000 ;'>"+
        		"    <div class='row'>"+
        		"        <div class='col-12'>"+
        				 	 models.get(0).get貨品代號()+
        		"        </div>"+
        		"    </div>"+
        		"    <div class='row'>"+
        		"        <div class='col-6 right'>"+
							 models.get(0).get庫位名稱()+
        		"        </div>"+
        		"        <div class='col-6 left'>"+
							 models.get(0).get現有存量()+
        		"        </div>"+
        		"    </div>";
        for(int i=1; i<models.size()-mgicNum; i++){

            if(i == models.size()-mgicNum-1){
                response_body += 
        		"    <div class='row'>"+
        		"        <div class='col-6 right'>"+
							 models.get(i).get庫位名稱()+
        		"        </div>"+
        		"        <div class='col-6 left'>"+
							 models.get(i).get現有存量()+
        		"        </div>"+
        		"    </div>"+
        		"</div>";
            }else if (models.get(i).get貨品代號().equals(models.get(i-1).get貨品代號())) {
                response_body += 
        		"    <div class='row'>"+
        		"        <div class='col-6 right'>"+
        					 models.get(i).get庫位名稱()+
        		"        </div>"+
        		"        <div class='col-6 left'>"+
				             models.get(i).get現有存量()+
        		"        </div>"+
        		"    </div>";
            }else{
                response_body += 
        		"</div><p />"+
        		"<div class='container kulu-table-config' style='border: 1px solid #000 ;'>"+
        		"    <div class='row'>"+
        		"        <div class='col-12'>"+
				             models.get(i).get貨品代號()+
        		"        </div>"+
        		"    </div>"+
        		"    <div class='row'>"+
        		"        <div class='col-6 right'>"+
	                         models.get(i).get庫位名稱()+
        		"        </div>"+
        		"        <div class='col-6 left'>"+
	                         models.get(i).get現有存量()+
        		"        </div>"+
        		"    </div>";
            }
        }
            
        String response_foot = "";
        String response_item = response_top+response_body+response_foot;
//        System.out.println(models.get(3).get貨品代號());
//        System.out.println(models.get(3-1).get貨品代號());
//        System.out.println(models.get(3).get貨品代號().equals(models.get(3-1).get貨品代號()));
//        System.out.println(response_item.replace("  ", ""));
		return new ResponseResult<>(200, response_item.replace("  ", ""), models);
	}
}
