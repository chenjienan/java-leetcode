package bfs;
import java.util.*;


public class AlienDictionary {
  public String alienOrder(String[] words) {
    
    int[] inDegree = new int[26];
    Map<Character, Set<Character>> graph = new HashMap<>();    
    buildGraph(graph, words, inDegree);        
    return getCharOrder(graph, inDegree);
  }

  
  private void buildGraph(Map<Character, Set<Character>> graph, String[] words, int[] inDegree) {
    // init neighbours for each char
    for(String word : words) {
      for(char ch : word.toCharArray()) {
        graph.putIfAbsent(ch, new HashSet<Character>());      
      }    
    }
    
    // add indegree for each char according to the words dependencies
    // add relations between each char
    for (int i = 1; i < words.length; i++) {
      String word1 = words[i - 1];
      String word2 = words[i];
            
      int minLen = Math.min(word1.length(), word2.length());      
      for (int j = 0; j < minLen; j++) {
        char ch1 = word1.charAt(j);
        char ch2 = word2.charAt(j);
        if (ch1 != ch2) {                                 
          Set<Character> neighbors = graph.get(ch1);
          if (!neighbors.contains(ch2)) {
            neighbors.add(ch2);
            inDegree[ch2 - 'a']++;                  
          }
          break;
        }
      }         
    }  
  }
  
  private String getCharOrder(Map<Character, Set<Character>> graph, int[] inDegree) {
    StringBuilder sb = new StringBuilder();
    Queue<Character> queue = new ArrayDeque<>();
    
    for (char ch : graph.keySet()) {
      if (inDegree[ch - 'a'] == 0) {
        queue.offer(ch);
      }
    }
    
    while (!queue.isEmpty()) {
      char curChar = queue.poll();
      sb.append(curChar);
      
      for (char neighbor : graph.get(curChar)) {        
        inDegree[neighbor - 'a']--;        
        if (inDegree[neighbor - 'a'] == 0) {          
          queue.offer(neighbor);
        }     
      }       
    }
    
    return sb.length() == graph.size() ? sb.toString() : "";
  }

  public static void main(String[] args) {
    String[] strA = {
      "wrt",
      "wrf",
      "er",
      "ett",
      "rftt"
    };

    AlienDictionary sol = new AlienDictionary();
    System.out.println(sol.alienOrder(strA));
  }
}
