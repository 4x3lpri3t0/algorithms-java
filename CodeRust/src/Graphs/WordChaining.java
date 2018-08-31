package Graphs;

import java.io.*;
import java.util.*;

import static java.lang.System.*;
import static java.lang.System.out;

public class WordChaining {
    static void test(List<String> list, boolean expected) {
        Graph g = new Graph(new ArrayList<>());
        g.create_graph(list);
        boolean result = g.check_cycle(list.size());
        String output;
        if(expected == true){
            output = "all strings should form chain";
        }
        else{
            output = "all strings should not form chain";
        }
        out.println(list + " : Result = "+ result);
    }

    // Test Program.
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("eve", "eat", "ripe", "tear"));
        test(list, true);

        list.clear();
        list.addAll(Arrays.asList("bad", "cab", "bac", "dab"));
        test(list, true);

        list.clear();
        list.addAll(Arrays.asList("deg", "fed"));
        test(list, false);

        list.clear();
        list.addAll(Arrays.asList("a", "a"));
        test(list, true);

        list.clear();
        list.addAll(Arrays.asList("ghi", "abc", "def", "xyz"));
        test(list, false);

        list.clear();
        //Check empty list
        test(list, false);

        list.addAll(Arrays.asList("aa", "aa"));
        test(list, true);

        list.clear();
        list.addAll(Arrays.asList("aba", "aba"));
        test(list, true);

        list.clear();
        list.addAll(Arrays.asList("aba", "bab"));
        test(list, false);

        list.clear();
        list.addAll(Arrays.asList("eve"));
        test(list, false);

        list.clear();
        list.addAll(Arrays.asList("eve", "eve", "sail", "lass"));
        test(list, false);

        list.clear();
        list.addAll(Arrays.asList("aa", "bb"));
        test(list, false);

        list.clear();
        list.addAll(Arrays.asList("ab", "cd", "dc", "ba"));
        test(list, false);

        list.clear();
        list.addAll(Arrays.asList("ab", "bc", "cd", "de", "ce", "ea"));
        test(list, false);

        list.clear();
        list.addAll(Arrays.asList("ab", "bc", "bc", "cd", "ce", "de", "ea", "eb"));
        test(list, true);

        out.println("Completed!");
    }
}