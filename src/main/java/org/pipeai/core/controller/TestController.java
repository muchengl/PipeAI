package org.pipeai.core.controller;

import com.alibaba.fastjson.JSON;
import org.pipeai.models.ChatGPTV35;
import org.pipeai.models.formats.ResponseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @RequestMapping("/test/gpt")
    public String testGpt(){
        ChatGPTV35 chatGPTV35 = new ChatGPTV35();
        chatGPTV35.addUserInputText("Hello, who are you?");
        ResponseData responseData = chatGPTV35.run();

        return JSON.toJSONString(responseData);
    }
}
