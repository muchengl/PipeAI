package org.pipeai;

import com.alibaba.fastjson.JSON;
import org.pipeai.connectors.ChatGPTConfigWrapper;
import org.pipeai.connectors.ChatGPTV35Client;
import org.pipeai.core.Core;
import org.pipeai.project.configs.AIModel;
import org.pipeai.project.configs.Models;
import org.pipeai.utils.YamlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;

@SpringBootApplication
public class PipeAiApplication {

    public static String runningPath;
    public static Core core;
    public static Models allModels;

    public static void main(String[] args) {
        SpringApplication.run(PipeAiApplication.class, args);
        init();
    }

    // should design a config sys, this is just for test
    public static void init(){
//        ApplicationHome home = new ApplicationHome(PipeAiApplication.class);
//        System.out.println(home);
//
//        ChatGPTConfigWrapper config = YamlParser.parseYaml(home+"/configs/ChatGPTV35.yaml");
//        System.out.println(JSON.toJSONString(config));
//
//        ChatGPTV35Client.initialize(config.getChatgpt().getApi().getUrl(),config.getChatgpt().getApi().getKey());
        ApplicationHome runningPath = new ApplicationHome(PipeAiApplication.class);
        Models models = YamlParser.parseAIModels(runningPath+"/configs/Models.yaml");

        for (AIModel aiModel : models.getModels()) {
            System.out.println(aiModel.toString());
        }

        PipeAiApplication.allModels = models;
        PipeAiApplication.runningPath = runningPath.toString();
    }
}
