import java.util.*;

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
        List<int[]> allTweets = new ArrayList<>();

        // Add the user's own tweets to allTweets
        if (tweets.containsKey(userId)) {
            List<int[]> userTweets = tweets.get(userId);
            for (int i = 0; i < userTweets.size(); i++) {
                allTweets.add(userTweets.get(i));
            }
        }

        // Add tweets from users that this user follows
        Set<Integer> following = followers.getOrDefault(userId, new HashSet<>());
        for (Integer followeeId : following) {
            if (tweets.containsKey(followeeId)) {
                List<int[]> followeeTweets = tweets.get(followeeId);
                for (int i = 0; i < followeeTweets.size(); i++) {
                    allTweets.add(followeeTweets.get(i));
                }
            }
        }

        // Sort all tweets based on their timestamps (latest first)
        Collections.sort(allTweets, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0]; // Sort in descending order
            }
        });

        // Get the top 10 recent tweets
        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            newsFeed.add(allTweets.get(i)[1]); // Get the tweetId
        }

        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId); // Use add for adding to a set
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
