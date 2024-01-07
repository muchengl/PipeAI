package org.pipeai.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pipe")
public class WebController {

    @RequestMapping("/index")
    public String index(){
        return "pipeline";
    }
}
