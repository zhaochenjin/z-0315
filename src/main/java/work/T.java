package work;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

        public class T {
            public static void main(String[] args) {
                HashMap<String, Integer> mapWord = new HashMap<String, Integer>();
                try {
                    BufferedReader in = new BufferedReader(new FileReader("src/data/file.txt"));
                    String line;
                    while (null != (line = in.readLine())) {
                        String[] words = line.split("\\W");
                        for (String s : words) {
                            if (s.trim().length() == 0) continue;
                            s = s.toLowerCase();
                            if (!mapWord.containsKey(s)) {
                                mapWord.put(s, 1);
                            } else if (mapWord.containsKey(s)) {
                                int n = mapWord.get(s);
                                mapWord.put(s, n + 1);
                            }
                        }
                    }
                    for (String s : mapWord.keySet()) {
                        int v = mapWord.get(s);
                        System.out.println("word   " + s + "  have  " + v);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
