class Solution {
    public String foreignDictionary(String[] words) {
        int[][] dependencyMatrix = new int[26][26];
        String ans = "";
        int[] incomingCount = new int[26];
        int[] present = new int[26];
        for(int i=0;i<words.length;i++) {
           for(int j = 0;j<words[i].length();j++) {
                present[(words[i].charAt(j)-'a')] = 1;
           }
        }
        for(int i=0;i<words.length-1;i++) {
            int j = 0;
            while(j<words[i].length() && j<words[i+1].length() && words[i].charAt(j) == words[i+1].charAt(j)){
                j++;
            }
            if(j<words[i].length() && j>=words[i+1].length()) {
                return "";
            }
            if (j<words[i].length() && j<words[i+1].length()) {
                if(dependencyMatrix[(words[i].charAt(j)-'a')][(words[i+1].charAt(j)-'a')] == 0) {
                    dependencyMatrix[(words[i].charAt(j)-'a')][(words[i+1].charAt(j)-'a')] = 1;
                    incomingCount[(words[i+1].charAt(j)-'a')]++;
                }

            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<incomingCount.length;i++) {
            if(incomingCount[i] == 0 && present[i] == 1) {
                q.add(i);
            }
            System.out.println(incomingCount[i]);
        }

        // if(q.isEmpty()) {
        //     return ans;
        // }

        while(!q.isEmpty()) {
            int temp = q.poll();
            ans+= (char) ('a' + temp);
            for(int i = 0;i<26;i++) {
                if(dependencyMatrix[temp][i] == 1) {
                    incomingCount[i] --;
                    if(incomingCount[i] == 0 && present[i] == 1) {
                        q.add(i);
                    }
                }
            }
        }

        for(int i=0;i<incomingCount.length;i++) {
            if(incomingCount[i] != 0) {
                return "";
            }
        }
        return ans;
    }
}
