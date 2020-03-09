package ua.lviv.iot.regex;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class WordMatcherTest
{
    @Test
    public void testFindUniqueWordInTheFirstSentence()
    {
        String input = "A sentence here, my friends. That's a second one by the way. Here is another. A last one.";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner text = new Scanner(System.in);

        WordMatcher.findUniqueWordInTheFirstSentence("\\b\\w+\\b", text.nextLine());
    }
}
