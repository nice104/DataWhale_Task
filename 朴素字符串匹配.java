public class BruteForce { 
  public static void main(String[] args) { 
    String waitForMatch = "abbacbabcdabcbec"; 
    String pattern = "abcbe"; 
    BruteForce bruteForce = new BruteForce(); 
    int index = bruteForce.getSubStringIndex(waitForMatch, pattern); 
    System.out.println("Matched index is "+index); 
  } 
  /** 
   * @author 
   * @param waitForMatch 主字符串 
   * @param pattern 模式字符串 
   * @return 第一次字符串匹配成功的位置 
   */ 
  public int getSubStringIndex(String waitForMatch, String pattern){ 
    int stringLength = waitForMatch.length(); 
    int patternLength = pattern.length(); 
    // 从主串开始比较 
    for(int i=0; i<stringLength; i++) { 
      int k = i; // k指向主串下一个位置 
      for(int j=0; j<patternLength; j++) { 
        if(waitForMatch.charAt(k) != pattern.charAt(j)) { 
          break; 
        }else { 
          k++;// 指向主串下一个位置 
          if(j == patternLength-1) { 
            return i; 
          } 
        }           
      } 
    } 
    // 匹配不成功，返回0 
    return 0; 
  } 
} 
