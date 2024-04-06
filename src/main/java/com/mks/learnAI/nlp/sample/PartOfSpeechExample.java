package com.mks.learnAI.nlp.sample;

import com.mks.learnAI.nlp.pipeline.Pipeline;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class PartOfSpeechExample {

    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        String text = "Hey! This is Mahesh Kumar Sharma. Current time is 2 PM. jsoup is a Java library for working with real-world HTML. It provides a very convenient API for fetching URLs and extracting and manipulating data, using the best of HTML5 DOM methods and CSS selectors. " +
                "Custom chat bot or chat agent for automated chat replies for FAQs. It uses " +
                "  different features of Apache OpenNLP for understanding what user is asking " +
                "  for. NLP is natural language processing.";

        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);

        List<CoreLabel> coreLabelList = coreDocument.tokens();
        for (CoreLabel coreLabel: coreLabelList) {
            String pos = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            System.out.println(coreLabel.originalText() + " : " + pos);
            System.out.println("-------------------------------------------------");
            System.out.println(String.format("%s\t%s", coreLabel.word(), coreLabel.tag()));
        }
    }
}
