package dfs;
import java.util.*;

public class RestoreIpAddresses {
  public List<String> Restore(String ip) {
    List<String> res = new ArrayList<>();
    if (ip == null || ip.length() == 0 || ip.length() > 12) {
      return res;
    }

    StringBuilder sb = new StringBuilder();
    dfs(ip.toCharArray(), 0, 0, sb, res);
    return res;
  }

  private void dfs(char[] ip, int level, int offset, StringBuilder sb, List<String> res) {
    if (level == 4) {
      if (sb.length() == ip.length + 4) {        
        res.add(sb.substring(0, sb.length() - 1));
      }
      return;
    }
    
    if (offset < ip.length) {
      sb.append(ip[offset]);
      sb.append('.');
      dfs(ip, level + 1, offset + 1, sb, res);
      sb.delete(sb.length() - 2, sb.length());
    }

    if (offset + 1 < ip.length && ip[offset] != '0') {
      sb.append(ip[offset]);
      sb.append(ip[offset + 1]);
      sb.append('.');
      dfs(ip, level + 1, offset + 2, sb, res);
      sb.delete(sb.length() - 3, sb.length());    
    }

    if (offset + 2 < ip.length) {
      char fstDigit = ip[offset];
      char secDigit = ip[offset + 1];
      char trdDigit = ip[offset + 2];
      if (fstDigit == '1' 
        || fstDigit == '2' && secDigit >= '0' && secDigit <= '4'
        || fstDigit == '2' && secDigit == '5' && trdDigit >= '0' && trdDigit <= '5') {
          sb.append(fstDigit);
          sb.append(secDigit);
          sb.append(trdDigit);
          sb.append('.');
          dfs(ip, level + 1, offset + 3, sb, res);
          sb.delete(sb.length() - 4, sb.length());
      }
    } 
  }
  
  
  // public List<String> Restore(String ip) {

  //   List<String> res = new ArrayList<>();
  //   if (ip == null || ip.length() == 0 || ip.length() > 12) {
  //     return res;
  //   }

  //   StringBuilder sb = new StringBuilder();
  //   dfs(ip, 0, 0, 0, sb, res);
  //   return res;
  // }

  // private void dfs(String ip, int idx, int numOfDots, int number, StringBuilder sb, List<String> res) {
    
  //   // illegal ip
  //   if (number > 255 || numOfDots > 3) {
  //     return;
  //   }
  //   // // cannot add digit after '0'
  //   // if (sb.length() != 0 && sb.charAt(sb.length() - 1) == '0') {
  //   //   return;
  //   // }
  //   // base case
  //   if (idx == ip.length() && numOfDots == 3) {
  //     if (sb.charAt(sb.length() - 1) == '.') {
  //       return;
  //     }
  //     res.add(sb.toString());
  //     return;
  //   }
  //   if (idx >= ip.length()) {
  //     return;
  //   }
  //   number *= 10;
  //   number += ip.charAt(idx) - '0';
  //   sb.append(ip.charAt(idx));
  //   // add or not add dot at this level
  //   dfs(ip, idx + 1, numOfDots, number, sb, res);
  //   if (number <= 255) {
  //     sb.append('.'); 
  //     dfs(ip, idx + 1, numOfDots + 1, 0, sb, res);
  //     sb.delete(sb.length() - 2, sb.length());
  //   } else {
  //     sb.deleteCharAt(sb.length() - 1);
  //   }
  // }

  public static void main(String[] args) {
    RestoreIpAddresses sol = new RestoreIpAddresses();
    System.out.println(sol.Restore("25525511135"));
  }
}
