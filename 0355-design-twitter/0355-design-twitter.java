//NMS. need to implement this again!
class Twitter {

    private int timeStamp; // Global timestamp to track the order of tweets
    private Map<Integer, List<int[]>> tweets; // Map userId to a list of tweets (timestamp, tweetId)
    private Map<Integer, Set<Integer>> followers; // Map followerId to a set of followeeIds

    public Twitter() {
        this.timeStamp = 0; // Initialize timestamp
        this.tweets = new HashMap<>(); // Initialize tweet storage
        this.followers = new HashMap<>(); // Initialize followers storage
    }

    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        // Initialize the tweet list if the user doesn't have any tweets yet
        tweets.putIfAbsent(userId, new ArrayList<>());
        // Add the tweet with its timestamp
        tweets.get(userId).add(new int[]{timeStamp, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); // Max-heap based on timestamp

        // Add the user's own tweets.
        if (tweets.containsKey(userId)) {
            for (int[] tweet : tweets.get(userId)) {
                maxHeap.add(tweet);
            }
        }

        // Add tweets from users that this user follows.
        Set<Integer> following = followers.getOrDefault(userId, new HashSet<>());
        for (int followeeId : following) {
            if (tweets.containsKey(followeeId)) {
                for (int[] tweet : tweets.get(followeeId)) {
                    maxHeap.add(tweet);
                }
            }
        }

        // Retrieve the top 10 recent tweets.
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            newsFeed.add(maxHeap.poll()[1]); // Get the tweetId
            count++;
        }

        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId); // Use add instead of put for adding to a set
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
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
