package by.nikita.sockets.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParserService {

    private static Pattern pattern;
    private static final String findInterrogativeSentence = "[]";



    public List<String> getAllSentenceOutString(String entranceString){
        List<String> list = new ArrayList<>();
        String[] temp = entranceString.split("[.?!]");
        for (int i = 0; i<temp.length; i++) {
            list.add(temp[i]);
            System.out.println(temp[i]);
        }
        return list;
    }

    public List<String> findCodeInText(String entranceString){
        List<String> listWithCode = new ArrayList<>();

        return listWithCode;
    }

    public List<String> getAllWordsInSentence(String sentence) {
        List<String> wordsList = new ArrayList<>();
        String[] words = sentence.split("[\\,\\:\\;\\s]");
        for (String word : words) {
            wordsList.add(word);
        }
        return wordsList;
    }

    public void testParameter(String line){
        String[] temp = line.split("[\b.,\\s]");
        for(String str : temp){
            if(str != null && !str.equals(" "))
            System.out.println("Kavo = " + str);
        }
    }


    public List<String> getAllSentences(String line) {

        List<String> textSentences = new ArrayList<>();

        String[] sentences = line.split("[.]{3}|[.!?]");

        for (String sentence : sentences) {
            textSentences.add(sentence.trim());
            System.out.println(sentence);
        }
        return textSentences;
    }

    public List<String> getInterrogativeSentences(List<String> list) {

        List<String> textSentences = new ArrayList<>();

        for(String str : list){
            if(str.matches("([?]$)")){
                textSentences.add(str);
            }
        }
        for(String str : textSentences) {
            System.out.println(str);
        }
        return textSentences;
    }



}
