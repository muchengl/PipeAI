package org.pipeai.models;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.pipeai.connectors.ChatGPTV35Client;
import org.pipeai.models.formats.DataStreamContext;
import org.pipeai.models.formats.ModelDataAcceptance;
import org.pipeai.models.formats.ResponseData;

import java.util.LinkedList;
import java.util.List;


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
@Setter
class ChatResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    @JSONField(name = "system_fingerprint")
    private String systemFingerprint;
    private List<Choice> choices;
    private Usage usage;
}

@Getter
@Setter
class Choice {
    private int index;
    private Message message;
    private Object logprobs;
    @JSONField(name = "finish_reason")
    private String finishReason;
}

@Getter
@Setter
class Usage {
    @JSONField(name = "prompt_tokens")
    private int promptTokens;
    @JSONField(name = "completion_tokens")
    private int completionTokens;
    @JSONField(name = "total_tokens")
    private int totalTokens;
}



@Getter
public class ChatGPTV35 extends AbstractModel {
    // data request to model
    ModelData modelData;

    DataStreamContext dataStreamContext;
    int newDataCon;

    public ChatGPTV35(){
        modelName = "ChatGPT-3.5";
        this.modelData = new ModelData(
                "gpt-3.5-turbo",
                new LinkedList<Message>()
        );

        // ChatGPT3.5 support text only
        DataStreamContext context = new DataStreamContext();

        context.setInputTextEnable(ModelDataAcceptance.MANDATORY);
        context.setInputFileEnable(ModelDataAcceptance.NOT_ACCEPTED);
        context.setOutputTextEnable(ModelDataAcceptance.MANDATORY);
        context.setOutputFileEnable(ModelDataAcceptance.NOT_ACCEPTED);

        context.setInputText(new LinkedList<>());
        context.setOutputText(new LinkedList<>());

        context.setInputTextMaxNum(1);

        this.dataStreamContext = context;
    }

    // add a message to ChatGPT model
    void addModelDataMessage(String role,String content){
        this.modelData.getMessages().add(
                new Message(role,content)
        );
    }

    void addDataContextInput(String text){
        dataStreamContext.getInputText().add(text);
        newDataCon++;
    }

    void addDataContextOutput(String text){
        dataStreamContext.getOutputText().clear();
        dataStreamContext.getOutputText().add(text);
    }

    public void addUserInputText(String text){
        addDataContextInput(text);
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
        //System.out.println(response);
        return new ResponseData(true,response);
    }

    @Override
    boolean parseResponse(ResponseData data) {
        String json = data.getResponse();
        ChatResponse response=JSON.parseObject(json,ChatResponse.class);

        String resp = response.getChoices().get(0).getMessage().getContent();

        addDataContextOutput(resp);
        // add this response to context
        addModelDataMessage("assistant",resp);

        return true;
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
        return false;
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
