/*
Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.
.*/
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
      return isMatch(word, abbr, 0, 0);
  }
  //i, p denotes the residual starting pos of input and pattern
  private boolean isMatch(String input, String pattern, int i, int p) {
    if(i == input.length() && p == pattern.length()){
      return true;
    }
    else if(i >= input.length() || p >= pattern.length()) {
      return false;
    }
    if(Character.isLetter(pattern.charAt(p))){
      if(input.charAt(i) != pattern.charAt(p)){
        return false;
      }else {
        return isMatch(input, pattern, i + 1, p + 1);
      }
    } 
    int num = 0;
    while(p < pattern.length() && Character.isDigit(pattern.charAt(p))){
      num = 10 * num + (pattern.charAt(p) - '0');
      p++;
    }
    return isMatch(input, pattern, i + num, p);
  }
}
