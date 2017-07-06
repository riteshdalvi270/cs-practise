package amazon;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Frequency of each word in file words.txt
 * Created by ritesh on 7/6/17.
 */
public class WordsFrequency {
    public static void main(String args[]) {

        final File file = new File("words.txt");

        wordCount(file);
    }

    private static void wordCount(final File file) {

        try {
            final FileReader fileReader = new FileReader(file);
            final BufferedReader bf = new BufferedReader(fileReader);

            String input = null;

            final Map<String,Integer> wordFrequency = new HashMap<>();

            while((input = bf.readLine())!=null) {

                final String[] splitInputs = input.split(" ");


                for(final String in : splitInputs) {

                    if (wordFrequency.containsKey(in)) {
                        Integer count = wordFrequency.get(in);
                        count = count + 1;
                        wordFrequency.put(in,count);
                    }else {
                        wordFrequency.put(in,1);
                    }
                }
            }


            final List<String> frequentWords = new ArrayList<>();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
