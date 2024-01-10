package org.pipeai.models;

import org.pipeai.models.formats.DataStreamContext;
import org.pipeai.models.formats.ModelDataAcceptance;
import org.pipeai.models.formats.ResponseData;

import java.util.ArrayList;
import java.util.List;

public class EmptyContainer extends AbstractModel{

    DataStreamContext dataStreamContext;

    EmptyContainer(){
        DataStreamContext dataStreamContext=new DataStreamContext();
        dataStreamContext.setInputTextEnable(ModelDataAcceptance.OPTIONAL);
        dataStreamContext.setInputFileEnable(ModelDataAcceptance.OPTIONAL);
        dataStreamContext.setOutputTextEnable(ModelDataAcceptance.OPTIONAL);
        dataStreamContext.setOutputFileEnable(ModelDataAcceptance.OPTIONAL);
        dataStreamContext.setInputText(new ArrayList<>());
        dataStreamContext.setInputFile(new ArrayList<>());
        dataStreamContext.setOutputText(new ArrayList<>());
        dataStreamContext.setOutputFile(new ArrayList<>());

        this.dataStreamContext=dataStreamContext;
    }

    @Override
    boolean dataCheck() {
        return true;
    }

    @Override
    boolean initModelMessage() {
        return true;
    }

    @Override
    ResponseData runModel() {
        return null;
    }

    @Override
    boolean parseResponse(ResponseData data) {
        return true;
    }

    @Override
    boolean textInput(List<String> texts) {
        return dataStreamContext.getInputText().addAll(texts);
    }

    @Override
    boolean fileInput(List<String> files) {
        return dataStreamContext.getInputFile().addAll(files);
    }

    @Override
    List<String> textOutput() {
        return dataStreamContext.getOutputText();
    }

    @Override
    List<String> fileOutput() {
        return dataStreamContext.getOutputFile();
    }
}
