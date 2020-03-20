package bfs;
import java.util.*;


public class WordLadder {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    Set<String> wordSet = new HashSet<>(wordList);
    Queue<String> queue = new ArrayDeque<>();
    Map<String, Integer> lookup = new HashMap<>();
    Map<String, Set<String>> predecessor = new HashMap<>();
    
    queue.offer(beginWord);
    lookup.put(beginWord, 1);
    predecessor.put(beginWord, new HashSet<String>());

    while (!queue.isEmpty()) {
      // expand
      String curWord = queue.poll();
      int curCount = lookup.get(curWord);
      if (curWord.equals(endWord)) {
        break;
      }

      List<String> nextWords = getNextWord(curWord, wordSet);
      for (String word : nextWords) {     
        // mark predecessor
        Set<String> wordPred = predecessor.get(word);
        if (wordPred == null) {
          wordPred = new HashSet<>();            
        } 
        wordPred.add(curWord);
        predecessor.put(word, wordPred);

        // generate next word
        if (!lookup.containsKey(word)) {          
          queue.offer(word);
          lookup.put(word, curCount + 1);                              
        }
      }
    }

    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();    
    getPaths(beginWord, endWord, res, path, lookup, predecessor);

    return res;
  }

  private void getPaths(String beginWord, String curWord, 
                        List<List<String>> res, List<String> path, 
                        Map<String, Integer> lookup, Map<String, Set<String>> predecessor) {

    if (curWord.equals(beginWord)) {
      path.add(curWord);
      List<String> sol = new ArrayList<>(path);
      Collections.reverse(sol);
      res.add(sol);
      path.remove(path.size() - 1);
      return;
    }

    path.add(curWord);
    int curCount = lookup.get(curWord);
    for (Map.Entry<String, Integer> entry : lookup.entrySet()) {
      if (entry.getValue() == curCount - 1 && predecessor.get(curWord).contains(entry.getKey())) {
        getPaths(beginWord, entry.getKey(), res, path, lookup, predecessor);
      }
    }
    path.remove(path.size() - 1);
  }

  private List<String> getNextWord(String curWord, Set<String> words) {
    List<String> res = new ArrayList<>();
    String allChars= "abcdefghijklmnopqrstuvwxyz";
  
    for (int i = 0; i < curWord.length(); i++) {
      StringBuilder sb = new StringBuilder(curWord);
      for (char ch : allChars.toCharArray()) {
        sb.setCharAt(i, ch);
        String nextWord = sb.toString();
        if (nextWord.equals(curWord)) continue;
        if (words.contains(nextWord)) {
          res.add(nextWord);
        }
      }
    }

    return res;
  }  

  public static void main(String[] args) {
    List<String> dict = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    WordLadder sol = new WordLadder();
    System.out.println(sol.findLadders("hit", "cog", dict));
  }
}