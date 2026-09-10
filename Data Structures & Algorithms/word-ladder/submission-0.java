class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> s = new HashSet<>();
        q.offer(beginWord);
        for (String word: wordList) s.add(word);
        int count = 0;

        while(!q.isEmpty()) {
            count++;
            int wordsCount = q.size();
            while (wordsCount>0) {
                String temp = q.poll();
                if (temp.equals(endWord)) return count;
                char[] tempArray = temp.toCharArray();
                for (int j =0;j<tempArray.length;j++) {
                    char tempChar = tempArray[j];
                    for (int i=0;i<26;i++) {
                        tempArray[j] = (char) ('a' + i);
                        String updatedString = new String(tempArray);
                        if (s.contains(updatedString)) {
                            q.offer(updatedString);
                            s.remove(updatedString);
                        }
                    }
                    tempArray[j] = tempChar;
                }
                wordsCount--;
            }

        }

        return 0;
        
    }
}
