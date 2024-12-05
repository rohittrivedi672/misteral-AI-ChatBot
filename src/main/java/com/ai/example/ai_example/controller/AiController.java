package com.ai.example.ai_example.controller;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AiController {

    private OllamaChatModel client;

    public AiController(OllamaChatModel client) {
        this.client = client;
    }

    @GetMapping("/prompt1")
    public Flux<String> getSolution(@RequestParam("prompt") String reqParam) {
        Flux<String> response = client.stream(reqParam);
        System.out.println(response);
        return response;
    }
//    @GetMapping("/prompt2")
//    public Flux<ChatResponse> getSolution1(@RequestParam("prompt") String reqParam) {
//        Prompt ob = new Prompt(reqParam);
//        Flux<ChatResponse> response = client.stream(ob);
//        System.out.println(response);
//        return response;
//    }
}
