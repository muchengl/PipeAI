package org.pipeai.core.pipe;

import org.pipeai.core.pojo.ModelDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Pipe {
    List<Node> nodes;

    public Pipe(){}
    public Pipe(String project){
        // todo recover from old proj
    }

    public boolean syncUI(ModelDTO modelDTO){

        return true;
    }
}
