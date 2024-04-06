package com.mks.learnAI.nlp.api;

import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ChatBotController {

    @Autowired
    private StanfordCoreNLP stanfordCoreNLP;

    public String processInput(String userInput){
        Annotation annotation = new Annotation(userInput);
        stanfordCoreNLP.annotate(annotation);
        //List<CoreMap> sentences = "";
        return null;
    }
}
