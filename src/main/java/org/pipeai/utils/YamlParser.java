package org.pipeai.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.pipeai.connectors.ChatGPTConfigWrapper;
import org.pipeai.project.configs.Models;

import java.io.File;
import java.io.IOException;

public class YamlParser {
    public static ChatGPTConfigWrapper parseGPTv35Yaml(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(new File(filePath), ChatGPTConfigWrapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Models parseAIModels(String yamlFilePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Models aiModels = null;
        try {
            aiModels = mapper.readValue(new File(yamlFilePath), Models.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return aiModels;
    }


}
