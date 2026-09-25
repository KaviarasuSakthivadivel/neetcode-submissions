class Twitter {

    private static int timestamp = 0;
    private HashMap<Integer, User> users;

    public Twitter() {
        users = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        users.computeIfAbsent(userId, u -> new User(userId)).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        if(!users.containsKey(userId)) {
            return Collections.emptyList();
        }

        User u = users.get(userId);
        Set<Integer> followers = u.followedBy;
        List<Integer> tweets = new LinkedList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for(Integer followerId : followers) {
            Tweet tempHead = users.get(followerId).head;
            if(tempHead != null) {
                pq.add(tempHead);
            }
        }

        int n = 10;
        while(!pq.isEmpty() && n-- > 0) {
            Tweet first = pq.remove();
            tweets.add(first.id);
            if(first.next != null) {
                pq.add(first.next);
            }
        }

        return tweets;
    }

    public void follow(int followerId, int followeeId) {
        users.computeIfAbsent(followeeId, u -> new User(followeeId));
        users.computeIfAbsent(followerId, u -> new User(followerId)).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        users.get(followerId).unFollow(followeeId);
    }


    class User {
        int id;
        HashSet<Integer> followedBy;
        Tweet head;

        public User(int id) {
            this.id = id;
            this.head = null;
            this.followedBy = new HashSet<>();
            this.followedBy.add(id); // Add itself
        }

        public void follow(int followerId) {
            this.followedBy.add(followerId);
        }

        public void unFollow(int followerId) {
            this.followedBy.remove(followerId);
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            tweet.next = head;
            head = tweet;
        }
    }

    class Tweet {
        int id;
        int time;
        Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timestamp++;
            next = null;
        }
    }
}
