package com.company;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;



public class Main {

    public static void main(String[] args)     {
        NameFinder nFinder = new NameFinder();





        try {

            Document document = Jsoup.connect("https://opennlp.apache.org/books-tutorials-and-talks.html").get();
            String text = document.select("div.container").text();
            nFinder.findName(text);

            nFinder.tokenize(text);

        }catch (IOException e) {
            e.printStackTrace();
        }


    }
}
