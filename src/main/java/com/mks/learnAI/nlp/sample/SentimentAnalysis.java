package com.mks.learnAI.nlp.sample;

import com.mks.learnAI.nlp.pipeline.Pipeline;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class SentimentAnalysis {

    public static void main(String[] args) {

        StanfordCoreNLP pipeline = Pipeline.getPipeline();
        String text = "Hey! This is Mahesh Kumar Sharma. Current time is 2 pm.  I am living at Delhi " +
                "jsoup is a Java library for working with real-world HTML. It provides a very convenient API for fetching " +
                "URLs and extracting and manipulating data, using the best of HTML5 DOM methods and CSS selectors. " +
                "Custom chat bot or chat agent for automated chat replies for FAQs. It uses " +
                "  different features of Apache OpenNLP for understanding what user is asking " +
                "  for. NLP is natural language processing.";
        CoreDocument coreDocument = new CoreDocument(text);
        pipeline.annotate(coreDocument);
        List<CoreSentence> coreSentenceList = coreDocument.sentences();

        for (CoreSentence sentence: coreSentenceList) {
            String sentiment = sentence.sentiment();
            System.out.println(sentiment + " - "+ sentence);
        }
    }
}
