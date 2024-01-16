package org.pipeai.models;

import org.pipeai.models.formats.ResponseData;

import java.util.List;

public abstract class AbstractModel {
    String modelName;

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

    // Stream style APIs
    abstract boolean addTextInput(List<String> texts);
    abstract boolean addFileInput(List<String> files);

    abstract List<String> getTextOutput();
    abstract List<String> getFileOutput();
}
