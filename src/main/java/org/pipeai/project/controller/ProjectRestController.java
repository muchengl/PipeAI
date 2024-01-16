package org.pipeai.project.controller;

import org.pipeai.PipeAiApplication;
import org.pipeai.core.Core;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectRestController {
    @RequestMapping("/load")
    public String load(){
        PipeAiApplication.core = new Core();
        PipeAiApplication.core.Init(
                PipeAiApplication.allModels
        );
        return "ok";
    }
}
