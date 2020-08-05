import java.util.*;
import java.text.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Week12{
    
    public static void main(String []args){

        String f = readUnicodeFile("FrenchTextFile.txt");
        ArrayList<String> words = extractWords(f, Locale.FRENCH);
        outputWordsToFile("Modified.txt", words);
        
    }
    
    public static String readUnicodeFile(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        
        try {
            Reader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_16);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String s;
            
            while ((s = bufferedReader.readLine()) != null) {
                fileContent.append(s + "\n");
            }
            
            bufferedReader.close();
            reader.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return fileContent.toString();
    }
    
    public static ArrayList<String> extractWords(String inputText, Locale currentLocale) {
        
        ArrayList<String> wordList = new ArrayList<>();
        BreakIterator wordIterator = BreakIterator.getWordInstance(currentLocale);
        wordIterator.setText(inputText);
        int start = wordIterator.first();
        int end = wordIterator.next();
        
        while (end != BreakIterator.DONE) {
            String word = inputText.substring(start, end);
            word = word.toLowerCase();
            
            if (Character.isLetter(word.charAt(0)) && word.length() > 1) {
                wordList.add(word);
            }
            start = end;
            end = wordIterator.next();
        }
        
        return wordList;
    }
    
    public static void outputWordsToFile(String filePath, ArrayList<String> wordList) {
        
        try {
            Writer writer = new OutputStreamWriter(  new FileOutputStream(filePath), StandardCharsets.UTF_16);
            PrintWriter printWriter = new PrintWriter(writer);
            
            for(int i=0; i < wordList.size(); ++i) {
                printWriter.println(wordList.get(i));
            }
            
            writer.close();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

