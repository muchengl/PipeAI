package org.pipeai.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.pipeai.connectors.ChatGPTConfigWrapper;

import java.io.File;
import java.io.IOException;

public class YamlParser {
    public static ChatGPTConfigWrapper parseYaml(String filePath) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(new File(filePath), ChatGPTConfigWrapper.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
