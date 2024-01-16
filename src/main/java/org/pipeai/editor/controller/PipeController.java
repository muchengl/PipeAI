package org.pipeai.editor.controller;

import com.alibaba.fastjson.JSON;
import org.pipeai.core.pojo.ModelDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pipe")
public class PipeController {

    @RequestMapping("/save")
    public String save(String pipeInfoJson){
        System.out.println(pipeInfoJson);

        testJson = pipeInfoJson;

        List<ModelDTO> model = JSON.parseObject(pipeInfoJson,List.class);
        System.out.println(JSON.toJSONString(model));

        return "ok";
    }

    String testJson="[{\"cellGeo\":{\"x\":389.99671212784983,\"y\":99.99433615687697,\"height\":80,\"width\":130},\"modelID\":\"Empty Container\",\"ModelName\":\"Empty Container\",\"connectFrom\":[\"aa34e86d-87cf-4107-99e6-062645539074\"],\"connectFromStyle\":[\"outputText\"],\"connectTo\":[\"afe6259a-b2cd-49c5-b63f-570e7a08d845\"],\"connectToStyle\":[\"inputText\"],\"ModelContextJson\":\"{empty}\",\"DataStreamContext\":\"{stream}\",\"uuid\":\"98ab6246-5fc3-4803-b830-ccd8a1be88d5\"},{\"cellGeo\":{\"x\":589.9952718717341,\"y\":99.99817878502364,\"height\":80,\"width\":130},\"modelID\":\"ChatGPTv35\",\"ModelName\":\"ChatGPT 3.5\",\"connectFrom\":[\"98ab6246-5fc3-4803-b830-ccd8a1be88d5\"],\"connectFromStyle\":[\"outputText\"],\"connectTo\":[\"1530dfac-f120-4e18-8a5a-8425a0d93283\"],\"connectToStyle\":[\"inputText\"],\"ModelContextJson\":\"{gpt 3.5}\",\"DataStreamContext\":\"{stream}\",\"uuid\":\"afe6259a-b2cd-49c5-b63f-570e7a08d845\"},{\"cellGeo\":{\"x\":830,\"y\":100,\"height\":130,\"width\":230},\"modelID\":\"ChatGPTv35\",\"ModelName\":\"ChatGPT 3.5\",\"connectFrom\":[\"afe6259a-b2cd-49c5-b63f-570e7a08d845\"],\"connectFromStyle\":[\"outputText\"],\"connectTo\":[],\"connectToStyle\":[],\"ModelContextJson\":\"{gpt 3.5}\",\"DataStreamContext\":\"{stream}\",\"uuid\":\"1530dfac-f120-4e18-8a5a-8425a0d93283\"},{\"cellGeo\":{\"x\":76.7942295845371,\"y\":227.95365874041104,\"height\":80,\"width\":130},\"modelID\":\"Empty Container\",\"ModelName\":\"Empty Container\",\"connectFrom\":[],\"connectFromStyle\":[],\"connectTo\":[\"98ab6246-5fc3-4803-b830-ccd8a1be88d5\"],\"connectToStyle\":[\"inputText\"],\"ModelContextJson\":\"{empty}\",\"DataStreamContext\":\"{stream}\",\"uuid\":\"aa34e86d-87cf-4107-99e6-062645539074\"}]\n";
    @RequestMapping("/loadproject")
    public String load(){
        System.out.println("load proj");
        return testJson;
    }
}
