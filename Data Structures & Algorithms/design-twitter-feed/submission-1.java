public class Tweet {
    static long time = 0;
    int tweetId;
    long timestamp;
    Tweet(int id) {
        tweetId = id;
        timestamp = time++;
    }
}
class Twitter {
    Map<Integer, Set<Integer>> followingMap;
    Map<Integer, List<Tweet>> tweetsMap;
    public Twitter() {
        followingMap = new HashMap<>();
        tweetsMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetsMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b) -> Long.compare(a.timestamp, b.timestamp));
        List<Tweet> userTweets = tweetsMap.getOrDefault(userId, new ArrayList<>());
        Set<Integer> following = followingMap.getOrDefault(userId, new HashSet<>());
        for (Tweet tweet: userTweets) {
            pq.offer(tweet);
            if (pq.size()>10) pq.poll();
        }
        for (Integer follow : following) {
            List<Tweet> followingTweets = tweetsMap.getOrDefault(follow, new ArrayList<>());
            for (Tweet tweet: followingTweets) {
            pq.offer(tweet);
            if (pq.size()>10) pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            result.add(pq.poll().tweetId);
        }
        Collections.reverse(result);
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followingMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followingMap.containsKey(followerId) && followingMap.get(followerId).contains(followeeId)) {
            followingMap.get(followerId).remove(followeeId);
        }
    }
}
