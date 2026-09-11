class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> mp = new HashMap<>();
        for (List<String> ticket: tickets) {
            mp.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        List<String> result = new ArrayList<>();
        dfs(mp, "JFK", result);

        Collections.reverse(result);
        return result; 
    }
    private void dfs(Map<String, PriorityQueue<String>> mp, String curr, List<String> result) {
        PriorityQueue<String> destinationsList = mp.get(curr);
        while (destinationsList!=null && !destinationsList.isEmpty()) {
            String next = destinationsList.poll();
            dfs(mp, next, result);
        }
        result.add(curr);
    }
}
