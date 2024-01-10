package org.pipeai.connectors;


import lombok.Getter;
import lombok.Setter;

public class ChatGPTConfigWrapper {
    private ChatGPTConfig chatgpt;

    // getter 和 setter
    public ChatGPTConfig getChatgpt() {
        return chatgpt;
    }

    public void setChatgpt(ChatGPTConfig chatgpt) {
        this.chatgpt = chatgpt;
    }

    @Getter
    @Setter
    public static class ChatGPTConfig {
        private Api api;


        @Getter
        @Setter
        public static class Api {
            private String url;
            private String key;
        }
    }
}