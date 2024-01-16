package org.pipeai.core;

import org.pipeai.core.pipe.Pipe;
import org.pipeai.core.pojo.ModelDTO;
import org.pipeai.project.configs.AIModel;
import org.pipeai.project.configs.Models;

import java.util.ArrayList;
import java.util.List;

public class Core implements ICore{
    List<ModelDTO> models;
    Pipe pipe;

    @Override
    public void Init(Models models) {
        this.models = modelsToModelDTO(models);
        this.pipe=new Pipe();
    }

    // init with old project
    @Override
    public void Init(Models models,String project) {
        this.models = modelsToModelDTO(models);
        this.pipe=new Pipe(project);
    }

//    var items = [
//    {   modelID :"Empty Container",
//            img: "../img/ailist/EmptyContainer.png",
//            name: "Empty Container",
//            description: "Container for input",
//            jsonContext: "{empty}",
//            streamContext: "{stream}",
//    },
//
//    {   modelID :"ChatGPTv35",
//            img: "../img/ailist/gpt3.5.png",
//            name: "ChatGPT 3.5",
//            description: "Amazing AI power by OpenAI",
//            jsonContext: "{gpt 3.5}",
//            streamContext: "{stream}",
//    },
//            ];

    private List<ModelDTO> modelsToModelDTO(Models models){
        List<ModelDTO> modelDTOS = new ArrayList<>();

        for (AIModel model : models.getModels()) {
            // todo,models -> ModelDTOs
            // todo, return all ModelDTO to frontend
            // todo, init all connectors, at the same time
        }

        return modelDTOS;
    }

    @Override
    public List<ModelDTO> getModels() {
        return models;
    }
}