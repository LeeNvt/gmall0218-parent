package com.atguigu.gmall0218.logger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

//@Controller  (@RestController=@Controller+@ResponseBody )
@RestController
@Slf4j
public class LoggerController {

    //@RequestMapping(path="test",method = RequestMethod.GET)
    //@ResponseBody
    @GetMapping("test") // ==@RequestMapping(path="test",method = RequestMethod.GET)
    public String getTest(){
        return "success1";
    }

    @PostMapping("log")
    public String doLog(@RequestParam("logString") String logString){
        //System.out.println(logString);
        //1.加时间戳
        JSONObject jsonObject = JSON.parseObject(logString);
        jsonObject.put("ts",System.currentTimeMillis());
        String jsonString = jsonObject.toJSONString();

        //2.log4j logback  -->落盘日志（写好了配置文件，resouce中）
        log.info(jsonString);

        return "success2222";
    }

}
