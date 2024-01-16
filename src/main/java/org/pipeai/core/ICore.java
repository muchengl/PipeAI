package org.pipeai.core;

import org.pipeai.core.pojo.ModelDTO;
import org.pipeai.project.configs.AIModel;
import org.pipeai.project.configs.Models;

import java.util.List;

public interface ICore {
    void Init(Models models);
    void Init(Models models,String project);

    List<ModelDTO> getModels();
}

