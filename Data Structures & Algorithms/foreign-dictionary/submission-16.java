class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, List<Character>> mp = new HashMap<>();
      int[] inCount = new int[26];
              Queue<Character> q = new LinkedList<>();
              Arrays.fill(inCount, Integer.MAX_VALUE);
      for (int i = 1;i<words.length;i++) {
        if(words[i].equals(words[i-1])) continue;
        else {
            int j = 0;
            while (j<words[i].length() && j<words[i-1].length() && words[i].charAt(j) == words[i-1].charAt(j)) {
                j++;
            }
            if (j<words[i].length() && j<words[i-1].length()) {
                if (inCount[words[i].charAt(j) - 'a'] == Integer.MAX_VALUE) inCount[words[i].charAt(j) - 'a'] = 0;
                                if (inCount[words[i-1].charAt(j) - 'a'] == Integer.MAX_VALUE) inCount[words[i-1].charAt(j) - 'a'] = 0;
                mp.computeIfAbsent(words[i-1].charAt(j), k-> new ArrayList<>()).add(words[i].charAt(j));
                inCount[words[i].charAt(j) - 'a']++;
            } else if (j == words[i].length()) return "";
        }
      }

        for (String word: words) {
            for (char ch: word.toCharArray()) {
                if (inCount[ch-'a'] == Integer.MAX_VALUE) inCount[ch-'a'] = 0;
            }
        }

      for (int i = 0;i<26;i++) {
            if (inCount[i] == 0) q.offer((char)(i+'a'));
      }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            char temp = q.poll();
            sb.append(temp);
            if (mp.get(temp) == null) continue;
            for (char node : mp.get(temp)) {
                inCount[node-'a']--;
                 if (inCount[node-'a'] == 0) q.offer(node);
            }
        }

        for (int i = 0;i<26;i++) {
            if (inCount[i] != Integer.MAX_VALUE && inCount[i] != 0) return "";
      } 
        return new String(sb);


    }
}
