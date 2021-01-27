package by.nikita.sockets.server.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextEditorService {

    private List<String> fileRows;
    private List<String> clearedFileRows;//лист с предложениями без кода
    private List<String> listWithSentences = new ArrayList<>();
    private List<String> listWithWords = new ArrayList<>();

    private ParserService parserService = new ParserService();


    private static final String wordsSeparator = " ";
    private static final String sentencesSeparator = "[,.!?\\s]";
    private static final String findAllWordsInString = "";


    public List<String> function3() {
        List<String> resultList = new ArrayList<>();
        List<String> firstSentenceWords = new ArrayList<>();
        String firstSentence = listWithSentences.get(0);

        String[] words = firstSentence.split("[\\,\\:\\;\\s]");
        for (String word : words) {
            firstSentenceWords.add(word);

        }

        List<String> textSentancesForSearch = new ArrayList<>(listWithSentences);
        textSentancesForSearch.remove(0);

        for (String word : firstSentenceWords) {
            boolean isOnly = true;
            for (String sentance : textSentancesForSearch) {
                if (parserService.getAllWordsInSentence(sentance).contains(word)) {
                    isOnly = false;
                }
            }
            if (isOnly) {
                resultList.add("The word \"" + word + "\" is situated only in first sentance of text!");
            }
        }
        return resultList;
    }

    public List<String> function4(String stringWithAllText/*приходят все вопросительные предложения*/, int number){//исключает повторяющиеся слова в массиве
        List<String> list = new ArrayList<>();
        //а у меня нету тут символов препинания скорее всего нету . ? ! и как быть?

        String[] temp = stringWithAllText.split("[?]");
        for(int i = 0; i< temp.length; i++){
            String[] getTargetSentences = temp[i].split("[.!]");
            list.add(getTargetSentences[getTargetSentences.length-1]);
        }

        for(String str : list){
            list.addAll(findWordWithByTheNumberOfLetter(str, number));
        }
        list = clearDuplicateWords(list);
        return list;
    }

    public List<String> function5(List<String> list){
        for(String i : list){
            String[] temp = i.split("[\\s]");
            String str = "";
            str = str.concat(temp[temp.length-1]).concat(wordsSeparator);
            for(int j = 1; j<temp.length-2; j++){
                str = str.concat(temp[j]).concat(wordsSeparator);
            }
            str = str.concat(temp[0]).concat(wordsSeparator);
            listWithSentences.add(str);
        }
        return listWithSentences;
    }

    public List<String> function6(String string){
        String[] deletePoint = string.split("[,.!?()]");
        string = "";
        for(String str : deletePoint){
            if(!str.equals(" ")) {
                string = string.concat(str).concat(wordsSeparator);
            }
        }
        String[] temp = string.split("[\\s]");
        listWithSentences = Arrays.asList(temp);
        Collections.sort(listWithSentences);//вывод отсортированного массива производится на стороне клиента
        return listWithSentences;
    }

    public List<String> function9(String stringWithAllWords, String letter){
        String[] deletePoint = stringWithAllWords.split(sentencesSeparator);
        for(String str : deletePoint){
            if(str.contains(letter)) {
                listWithSentences.add(str);
            }
        }
        //сортировка по кол-ву букв в слове

        return listWithSentences;
    }

    public List<String> function12(String stringWithAllText, int number){
        String[] arrWords = stringWithAllText.split(sentencesSeparator);
        String stringWithDeletedWords = "";
        for(String str : arrWords){
            if(!str.matches("[\b[цкнгшщзхждлрпвфчсмтб]]" )&& str.length()==number){
                stringWithDeletedWords = stringWithDeletedWords.concat(str).concat(wordsSeparator);
            }
        }
        listWithSentences = Arrays.asList(stringWithDeletedWords.split("[.!?]"));
        for(String str : listWithSentences){
            System.out.println("Method = " + str);
        }
        return listWithSentences;
    }

    public List<String> function16(List<String> textStrings, int number, int lengthString, String upString){
        clearedFileRows = textStrings;
        //List<String> allWords = new ArrayList<>();
        String replaceString  = textStrings.get(number);
        String[] allWords = replaceString.split("[,:;\\s]");
        replaceString = "";
        for(String str : allWords){
            if(str.length() == lengthString){
                str = upString;
            }
            replaceString = replaceString.concat(str).concat(wordsSeparator);
        }
        textStrings.set(number, replaceString);
        return textStrings;
    }

    public List<String> findWordWithByTheNumberOfLetter(String line, int number){//ищет все слова заданной длины
        List<String> string = new ArrayList<>();
        List<String> temp = parserService.getAllWordsInSentence(line);
        for(String i : temp){
            if(i.length() == number){
                string.add(i);
            }
        }
        return string;
    }

    public List<String> clearDuplicateWords(List<String> list){
        List<String> string = new ArrayList<>();
        for(String str : list){
            int count = 0;
            for(String i : string){
                if(i.equals(str)){
                    count++;
                }
            }
            if(count == 0){
                string.add(str);
            }
        }
        return string;
    }



    /*public void chosenEditText(String strWithAllText, String number){
        switch (number){
            case "1":
                System.out.println("Called case 1");
                break;
            case "2":
                //function();
                break;
            case "3":
                function3();
                break;
            case "4":
                function4();
                break;
            case "5":
                function5();
                break;
            case "6":
                function6();
                break;
            case "7":
                function12();
                break;
            case "8":
                function5();
                break;
            case "9":
                function9();
                break;
            case "10":
                function4();
                break;
            case "11":
                function5();
                break;
            case "12":
                function12();
                break;
            case "13":
                function4();
                break;
            case "14":
                function5();
                break;
            case "15":
                function4();
                break;
            case "16":
                function16();
                break;
            default:
        }
    }*/

    
}
