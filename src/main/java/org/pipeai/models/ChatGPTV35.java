package org.pipeai.models;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.pipeai.connectors.ChatGPTV35Client;
import org.pipeai.models.formats.DataStreamContext;
import org.pipeai.models.formats.ResponseData;

import java.util.LinkedList;
import java.util.List;

import static org.pipeai.models.formats.ModelDataAcceptance.MANDATORY;
import static org.pipeai.models.formats.ModelDataAcceptance.NOT_ACCEPTED;

@Getter
@Setter
@AllArgsConstructor
class ModelData {
    private String model;
    private List<Message> messages;
}

@Getter
@Setter
@AllArgsConstructor
class Message {
    private String role;
    private String content;
}

@Getter
public class ChatGPTV35 extends AbstractModel {
    // data request to model
    ModelData modelData;
    DataStreamContext dataStreamContext;

    int newDataCon;

    public ChatGPTV35(){
        this.modelData = new ModelData(
                "gpt-3.5-turbo",
                new LinkedList<Message>()
        );

        // ChatGPT3.5 text only
        DataStreamContext context = new DataStreamContext();

        context.setInputTextEnable(MANDATORY);
        context.setInputFileEnable(NOT_ACCEPTED);
        context.setOutputTextEnable(MANDATORY);
        context.setOutputFileEnable(NOT_ACCEPTED);

        context.setInputText(new LinkedList<>());
        context.setOutputText(new LinkedList<>());

        this.dataStreamContext = context;
    }

    // add a message to ChatGPT model
    public void addModelDataMessage(String role,String content){
        this.modelData.getMessages().add(
                new Message(role,content)
        );
    }

    public void addDataContext(String text){
        dataStreamContext.getInputText().add(text);
        newDataCon++;
    }

    public void addUserInputText(String text){
        addDataContext(text);
    }

    public void updateDataStreamContext(DataStreamContext newContext){
        for(int i=dataStreamContext.getInputText().size();i<newContext.getInputText().size();i++){
            addUserInputText(
                    newContext.getInputText().get(i)
            );
        }
    }

    @Override
    boolean dataCheck() {
        if (this.dataStreamContext.getInputText().size()==0){
            return false;
        }
        if(this.dataStreamContext.getInputFile()!=null) {
            return false;
        }
        return true;
    }

    @Override
    boolean initModelMessage(){
        if(newDataCon==0) return false;

        List<String> context = dataStreamContext.getInputText();

        int idx = context.size() - newDataCon;
        for(;idx<context.size();idx++){
            addModelDataMessage("user",context.get(idx));
        }

        newDataCon=0;
        return true;
    }

    @Override
    ResponseData runModel() {
        String response = ChatGPTV35Client.sendRequest(
                JSON.toJSONString(this.modelData)
        );
        System.out.println(response);
        return new ResponseData(true,response);
    }

    @Override
    boolean parseResponse(ResponseData data) {
        return false;
    }

    @Override
    boolean textInput(List<String> texts) {
        this.dataStreamContext.getInputText().addAll(
                texts
        );
        return true;
    }

    @Override
    boolean fileInput(List<String> files) {
        // no file input for gpt3.5
        return true;
    }

    @Override
    List<String> textOutput() {
        return dataStreamContext.getOutputText();
    }

    @Override
    List<String> fileOutput() {
        return null;
    }
}
