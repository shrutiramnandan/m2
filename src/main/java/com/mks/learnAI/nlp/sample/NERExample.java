package com.mks.learnAI.nlp.sample;

import com.mks.learnAI.nlp.pipeline.Pipeline;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class NERExample {

    public static void main(String[] args) {

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
        String text = "Hey! This is Mahesh Kumar Sharma. Current time is 2 pm.  I am living at Delhi " +
                "jsoup is a Java library for working with real-world HTML. It provides a very convenient API for fetching " +
                "URLs and extracting and manipulating data, using the best of HTML5 DOM methods and CSS selectors. " +
                "Custom chat bot or chat agent for automated chat replies for FAQs. It uses " +
                "  different features of Apache OpenNLP for understanding what user is asking " +
                "  for. NLP is natural language processing.";
        CoreDocument coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        List<CoreLabel> coreLabelList = coreDocument.tokens();

        // get confidences for entities
        for (CoreEntityMention em : coreDocument.entityMentions()) {
            System.out.println(em.text() + "\t" + em.entityTypeConfidences());
        }
        System.out.println("-----------------------");
        // get confidences for tokens
        for (CoreLabel token : coreDocument.tokens()) {
            System.out.println(token.word() + "\t" + token.get(CoreAnnotations.NamedEntityTagProbsAnnotation.class));
        }
        System.out.println("-----------------------");
        for (CoreLabel coreLabel: coreLabelList) {
            String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
            System.out.println(coreLabel.originalText() + " ----> " + ner);
        }
    }
}
