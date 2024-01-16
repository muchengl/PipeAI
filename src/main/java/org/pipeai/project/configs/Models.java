package org.pipeai.project.configs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

// A wrapper class for a list of AIModel

@Getter
@Setter
public class Models {
    private List<AIModel> models;
}
