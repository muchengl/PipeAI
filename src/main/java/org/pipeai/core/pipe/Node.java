package org.pipeai.core.pipe;

import org.pipeai.models.AbstractModel;

import java.util.List;

public class Node {
    AbstractModel model;
    List<Edge> outgoingEdges;
    List<Edge> incomingEdges;

}
