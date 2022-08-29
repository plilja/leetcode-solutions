class Twitter {
    private static int LIMIT = 10;
    private static int nextCounter = 0;
    
    private record Tweet (int tweetId, int counterId) implements Comparable<Tweet> {
        @Override
        public int compareTo(Tweet other) {
            if (counterId != other.counterId) {
                return other.counterId - counterId;
            } else {
                return other.tweetId - tweetId;
            }
        }
    }
    
    private final Map<Integer, LinkedList<Tweet>> userFeeds = new HashMap<>();
    private final Map<Integer, Set<Integer>> followers = new HashMap<>();
    private final Map<Integer, Set<Integer>> following = new HashMap<>();
    private final Map<Integer, Set<Tweet>> tweets = new HashMap<>();
    
    
    public Twitter() {
        
    }
    
    private void insertIntoFeed(int user, Tweet tweet) {
        LinkedList<Tweet> feed = userFeeds.computeIfAbsent(user, k -> new LinkedList<>());
        feed.addFirst(tweet);
        while (feed.size() > LIMIT) {
            feed.removeLast();
        }
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, nextCounter++);
        tweets.computeIfAbsent(userId, k -> new HashSet<>()).add(tweet);
        for (int follower : followers.getOrDefault(userId, Set.of())) {
            insertIntoFeed(follower, tweet);
        }
        insertIntoFeed(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        return userFeeds.computeIfAbsent(userId, k -> new LinkedList<>()).stream()
            .map(tweet -> tweet.tweetId())
            .toList();
    }
    
    public void follow(int followerId, int followeeId) {
        if (followers.computeIfAbsent(followeeId, k -> new HashSet<>()).contains(followerId)) {
            return;
        }
        followers.computeIfAbsent(followeeId, k -> new HashSet<>()).add(followerId);
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        Set<Tweet> tw = tweets.computeIfAbsent(followeeId, k -> new HashSet<>());
        LinkedList<Tweet> feed = userFeeds.computeIfAbsent(followerId, k -> new LinkedList<>());
        feed.addAll(tw);
        Collections.sort(feed);
        while (feed.size() > LIMIT) {
            feed.removeLast();
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!followers.computeIfAbsent(followeeId, k -> new HashSet<>()).contains(followerId)) {
            return;
        }
        followers.computeIfAbsent(followeeId, k -> new HashSet<>()).remove(followerId);
        following.computeIfAbsent(followerId, k -> new HashSet<>()).remove(followeeId);
        LinkedList<Tweet> feed = userFeeds.computeIfAbsent(followerId, k -> new LinkedList<>());
        feed.clear();
        for (int follow : following.get(followerId)) {
            Set<Tweet> tw = tweets.computeIfAbsent(follow, k -> new HashSet<>());
            feed.addAll(tw);
        }
        feed.addAll(tweets.computeIfAbsent(followerId, k -> new HashSet<>()));
        Collections.sort(feed);
        while (feed.size() > LIMIT) {
            feed.removeLast();
        }
    }
    
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
