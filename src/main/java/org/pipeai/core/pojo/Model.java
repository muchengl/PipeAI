package org.pipeai.core.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Model {
    private String modelID;
    private CellGeo cellGeo;
    private List<String> connectFrom;
    private List<String> connectFromStyle;
    private List<String> connectTo;
    private List<String> connectToStyle;
    private String ModelContextJson;
    private String DataStreamContext;
    private String uuid;
}
