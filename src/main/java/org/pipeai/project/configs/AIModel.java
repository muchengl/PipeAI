package org.pipeai.project.configs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AIModel {
    private String name;
    @JsonProperty("model_id")
    private String modelId;
    private boolean enabled;
    @JsonProperty("config_file")
    private String configFile;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getConfigFile() {
        return configFile;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "AIModel{" +
                "name='" + name + '\'' +
                ", modelId='" + modelId + '\'' +
                ", enabled=" + enabled +
                ", configFile='" + configFile + '\'' +
                '}';
    }
}
