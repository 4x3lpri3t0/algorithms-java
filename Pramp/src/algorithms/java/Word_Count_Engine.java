/*
# Word Count Engine

Implement a document scanning engine that receives a text document doc
and returns a list of all unique words in it and their number of occurrences,
sorted by the number of occurrences in descending order.

Example:

for doc: "practice makes perfect. get perfect by practice. just practice!"

the engine returns the list: { practice: 3, perfect: 2,  makes: 1, get: 1, by: 1, just: 1 }.

The engine should ignore punctuation and white-spaces.

Find the minimal runtime complexity and analyze it.
*/

import java.util.*;

public class Word_Count_Engine {
    private class Data implements Comparable<Data> {
        String word;
        int count;

        public Data(String w, int c) {
            word = w;
            count = c;
        }

        public int compareTo(Data that) {
            // Sorts in descending order
            return that.count - this.count;
        }
    }

    public List<Data> countWords(String doc) {
        if (doc == null || doc.length() == 0) {
            return null;
        }

        Map<String, Integer> map = new HashMap<>();
        String[] allWords = doc.toLowerCase().split("[^a-zA-Z]+");

        for (String s : allWords) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        List<Data> result = new ArrayList<Data>();
        for (String key : map.keySet()) {
            result.add(new Data(key, map.get(key)));
        }

        Collections.sort(result);
        return result;
    }

    public void main(String[] args) {
        String doc = "practice makes perfect. get perfect by practice. just practice!";
        List<Data> result = countWords(doc);
        for (Data d : result) {
            System.out.println(d.word + " : " + d.count);
        }
    }
}