package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
@Service
public class MyOpenAIService  {

    public String openAIServiceCall(String userInput) {
        Scanner scanner = new Scanner(System.in);

        OpenAiService service = new OpenAiService("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");
        List<ChatMessage> chatMessages = Arrays.asList(
                new ChatMessage(ChatMessageRole.SYSTEM.value(), "You are a helpful assistant."),
                new ChatMessage(ChatMessageRole.USER.value(), userInput)
        );
        ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
                .messages(chatMessages)
                .temperature(0.5)
                .model("gpt-3.5-turbo")
                .build();
        ChatCompletionResult response = service.createChatCompletion(completionRequest);

        String aiResponse = response.getChoices().get(0).getMessage().getContent();
        System.out.println("AI Response: " + aiResponse);
        scanner.close();

        return aiResponse;
    }

  
  
}