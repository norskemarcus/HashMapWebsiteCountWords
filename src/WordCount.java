import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class WordCount {

    public static HashMap<String, Integer> wordCountWebside(ArrayList<String> words) throws Exception {

      HashMap<String, Integer> wordCountMap = new HashMap<>();
      URL connection = new URL("https://dr.dk/");
      BufferedReader reader = new BufferedReader(new InputStreamReader(connection.openStream()));

      for (String word : words) {
        wordCountMap.put(word, 0);
      }

      String inputLine = "";

      while (inputLine != null) {

        //Checke ordene fra arrayliste
        for (String word : words) {
          if (inputLine.contains(word)) {
            Integer count = wordCountMap.get(word);
            count++;
            wordCountMap.put(word, count);
          }
        }
        inputLine = reader.readLine();
      }
      reader.close();
      return wordCountMap;
    }


    public static void main(String[] args) {

      ArrayList<String> searchWords = new ArrayList<>();
      searchWords.add("Ungarn");
      searchWords.add("Rusland");
      searchWords.add("Hedebølger");
      searchWords.add("Lolland");

      try {
        HashMap<String, Integer> hashMap = wordCountWebside(searchWords);

        // keySet returns a set view of the keys
        for (String sKey : hashMap.keySet()) {
          System.out.println("Ord fundet: " + sKey + " " + hashMap.get(sKey) + " gange");
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());

      }
    }
  }






