package com.company;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;


import java.io.IOException;
import java.io.InputStream;


public class NameFinder {



    public void findName(String paragraph) throws IOException {

        InputStream inputStream = getClass().getResourceAsStream("/en-ner-person.bin");
        TokenNameFinderModel model = new TokenNameFinderModel(inputStream);
        NameFinderME nameFinder = new NameFinderME(model);


        String[] tokens = tokenize(paragraph);

        Span[] nameSpans = nameFinder.find(tokens);
        for(Span a: nameSpans) System.out.println(tokens[a.getStart()] + " " + tokens[a.getStart() + 1]);
    }

    public String[] tokenize(String sentence) throws IOException{
        InputStream inputStreamTokenizer = getClass().getResourceAsStream("/en-token.bin");
        TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);
        TokenizerME tokenizer = new TokenizerME(tokenModel);
        return tokenizer.tokenize(sentence);
    }
}