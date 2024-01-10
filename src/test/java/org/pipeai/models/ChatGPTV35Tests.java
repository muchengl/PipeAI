package org.pipeai.models;

import com.alibaba.fastjson.JSON;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.pipeai.PipeAiApplication;
import org.pipeai.models.formats.ResponseData;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ChatGPTV35Tests {
    @Test
    void testMessageToJson() throws JSONException {
        ChatGPTV35 chatGPTV35 = new ChatGPTV35();
        chatGPTV35.addUserInputText("test");
        chatGPTV35.initModelMessage();

        String msg = JSON.toJSONString(
                chatGPTV35.getModelData()
        );

        String expectMsg = "{" +
                "    \"model\": \"gpt-3.5-turbo\"," +
                "    \"messages\": [" +
                "      {" +
                "        \"role\": \"user\"," +
                "        \"content\": \"test\"" +
                "      }" +
                "    ]" +
                "  }";
        System.out.println(msg);

        JSONAssert.assertEquals(msg, expectMsg, true);
    }

    @Test
    void testRunModel(){
//        ChatGPTV35 chatGPTV35 = new ChatGPTV35();
//        chatGPTV35.addUserInputText("Hello!");
//        ResponseData responseData = chatGPTV35.run();
//
//        String msg = JSON.toJSONString(
//                chatGPTV35.getModelData()
//        );
//        System.out.println(msg);
//
//        System.out.println(JSON.toJSONString(responseData));
    }

}
