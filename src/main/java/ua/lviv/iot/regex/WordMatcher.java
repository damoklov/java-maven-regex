package ua.lviv.iot.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordMatcher
{
    private static List<String> listOfFoundWords = new ArrayList<>();
    private static List<String> uniqueWordsInSentence = new ArrayList<>();

    public static void findUniqueWordInTheFirstSentence(final String pattern, String textToProcess){
        String[] sentences = textToProcess.split("\\.");
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(sentences[0]);

        while (matcher.find()){
            listOfFoundWords.add(matcher.group());
        }

        for (String word: listOfFoundWords) {
            boolean isUnique = true;

            for (int i = 1; i < sentences.length; i++) {
                String[] wordsInSentence = sentences[i].toLowerCase().split(" ");

                for (String wordInSentence: wordsInSentence){
                    wordInSentence = wordInSentence.replaceAll("^[\\s\t]+|[\\s\t]+$", "");

                    if (wordInSentence.toLowerCase().equals(word.toLowerCase())){
                        isUnique = false;
                        break;
                    }
                }
            }
            if (isUnique){
                word = word.replaceAll("^[\\s\t]+|[\\s\t]+$", "");
                uniqueWordsInSentence.add(word);
            }
        }
        System.out.println(uniqueWordsInSentence);
    }
}
