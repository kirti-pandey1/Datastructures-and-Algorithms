package SlidingWindowAndTwoPointer;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */

public class LongestSubstringWithoutRepeation {
    public String getLongestSubsequence(String sequence){
        String substring = StringUtils.EMPTY;
        int leftPointer = 0;
        int rightPointer = 0;
        String oldString = StringUtils.EMPTY;
        HashMap<Character,Integer> visitedNodes = new HashMap<>();
        while (leftPointer<=rightPointer && sequence.length()>rightPointer){
            if(!visitedNodes.containsKey(sequence.charAt(rightPointer))){
                visitedNodes.put(sequence.charAt(rightPointer),rightPointer);
                substring = substring + sequence.charAt(rightPointer);
                rightPointer++;
            }else{
                leftPointer = visitedNodes.get(sequence.charAt(rightPointer))+1;
                rightPointer =leftPointer;
                if(oldString.length()<substring.length())
                    oldString=substring;
                substring = StringUtils.EMPTY;
                visitedNodes.clear();
            }
        }
        if(oldString.length()>substring.length())
            substring=oldString;
        return substring;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeation substringWithoutRepeation = new LongestSubstringWithoutRepeation();
        System.out.println(substringWithoutRepeation.getLongestSubsequence("sdrgkjjsc"));
    }
}
