package org.pipeai.core.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.pipeai.core.pojo.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pipe")
public class PipeObjController {

    @RequestMapping("/save")
    public String save(String pipeInfoJson){
        System.out.println(pipeInfoJson);

        List<Model> model = JSON.parseObject(pipeInfoJson,List.class);
        System.out.println(JSON.toJSONString(model));

        return "ok";
    }

    String testJson="[{\"modelID\":\"Empty Container\",\"cellGeo\":{\"x\":78.83287688058593,\"width\":130,\"y\":88.31929670496959,\"height\":80,\"relative\":false},\"connectFrom\":[],\"connectFromStyle\":[],\"connectTo\":[\"b7425689-fe55-4a9f-859a-cd5161437626\"],\"connectToStyle\":[\"inputText\"],\"ModelContextJson\":\"{empty}\",\"DataStreamContext\":\"{stream}\",\"uuid\":\"23055030-ea44-4a5b-b974-a22e2a7bb19c\"},{\"modelID\":\"ChatGPTv35\",\"cellGeo\":{\"x\":284.2177974821955,\"width\":130,\"y\":289.4808322301784,\"height\":{\"$ref\":\"cellGeo.height\"},\"relative\":{\"$ref\":\"cellGeo.relative\"}},\"connectFrom\":[\"23055030-ea44-4a5b-b974-a22e2a7bb19c\"],\"connectFromStyle\":[\"outputText\"],\"connectTo\":[],\"connectToStyle\":[],\"ModelContextJson\":\"{gpt 3.5}\",\"DataStreamContext\":\"{stream}\",\"uuid\":\"b7425689-fe55-4a9f-859a-cd5161437626\"}]\n";
    @RequestMapping("/load")
    public String load(){
        return testJson;
    }

}
