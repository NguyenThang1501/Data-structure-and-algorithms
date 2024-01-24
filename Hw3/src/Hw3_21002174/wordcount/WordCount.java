package Hw3_21002174.wordcount;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws IOException {
        FileInputStream inputFile = new FileInputStream("C:\\Users\\Thang Laptop\\DataStructuresAndAlgorithms\\Hw3\\src\\Hw3_21002174\\wordcount\\data");
        Scanner fileInput = new Scanner(inputFile);

        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> count = new ArrayList<Integer>();

        while (fileInput.hasNext()) {
            String nextWord = fileInput.next();
            if (words.contains(nextWord)) {
                int index = words.indexOf(nextWord);
                count.set(index, count.get(index) + 1);
            } else {
                words.add(nextWord);
                count.add(1);
            }
        }
        fileInput.close();
        inputFile.close();
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + ": xuất hiện " + count.get(i) + " lần");
        }
    }
}
