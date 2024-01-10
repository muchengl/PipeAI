package org.pipeai.models;

import org.pipeai.models.formats.ResponseData;

import java.util.List;

public abstract class AbstractModel {
    public ResponseData run(){
        if(!dataCheck()){
            return new ResponseData(false,"data check not pass");
        }

        if(!initModelMessage()){
            return new ResponseData(false,"init message fail");
        }

        ResponseData data = runModel();

        if(!parseResponse(data)){
            return new ResponseData(false,"parse data fail,raw response: "+data.getResponse());
        }

        return data;
    }

    abstract boolean dataCheck();

    abstract boolean initModelMessage();

    abstract ResponseData runModel();

    // for models with a "context" like ChatGPT, should add response as a system-input to old context
    abstract boolean parseResponse(ResponseData data);

    // APIs for stream
    abstract boolean textInput(List<String> texts);
    abstract boolean fileInput(List<String> files);

    abstract List<String> textOutput();
    abstract List<String> fileOutput();
}
