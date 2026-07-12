class Solution {
    private boolean isAnagram (Map<Character, Integer> tempMap, String tempString) {
        for (int i = 0;i<tempString.length();i++) {
            if (!tempMap.containsKey(tempString.charAt(i)) || tempMap.get(tempString.charAt(i)) == 0) {
                return false;
            }
            int currentCount = tempMap.get(tempString.charAt(i));
            tempMap.put(tempString.charAt(i), currentCount-1);
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
      Set<String> includedStrings = new HashSet<>(); 
      List<List<String>> result = new ArrayList<>();
      for (int i = 0;i<strs.length;i++) {
        if (!includedStrings.contains(strs[i])) {
            List<String> tempResult = new ArrayList<>();
            tempResult.add(strs[i]);
            includedStrings.add(strs[i]);
            for (int j = i+1;j<strs.length;j++) {
                Map<Character,Integer> tempMap = new HashMap<>();
                for (int k = 0;k<strs[i].length();k++) {
                    if (!tempMap.containsKey(strs[i].charAt(k))) {
                        tempMap.put(strs[i].charAt(k), 1);
                    } else {
                        int currCount = tempMap.get(strs[i].charAt(k));
                        tempMap.put(strs[i].charAt(k), currCount+1);
                    }
                }
                if ((strs[i].length() == strs[j].length()) && isAnagram(tempMap,strs[j])) {
                    tempResult.add(strs[j]);
                    includedStrings.add(strs[j]);
                }
            }
            result.add(tempResult);       
        }
      }
      return result;
    }
}
