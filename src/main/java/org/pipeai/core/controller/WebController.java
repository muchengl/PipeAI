package org.pipeai.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pipe")
public class WebController {

//    @RequestMapping("/index")
//    public String index(){
//        return "pipeline";
//    }

    @RequestMapping("/editor")
    public String pipe(){
        return "pipe";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
