/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author nathangoshay
 */
public class SingleUser extends User implements Subject {  
    
    
    public String latestMessage;
    public int positiveMessageCount;
    
    public Map<String, Observer> followersList;
    public Map<String, Subject> followingList;
    public List<String> tweetFeed;
    public static final List<String> POSITIVE_WORDS = Arrays.asList("good");
    
    
    public SingleUser(String ID) {
        
        super(ID);
        followersList = new HashMap<String, Observer>();
        followingList = new HashMap<String, Subject>();
        followersList.put(this.getUniqueID(), this);
        tweetFeed = new ArrayList<>();
        
    }
    
    //Single User Methods
    
    public Map<String, Observer> getFollowersList() {
        
        return followersList;
    }
    
    public String getLatestTweet() {
        return this.latestMessage;
    }
    
    public Map<String, Subject> getFollowingList() { 
        
        return followingList;
        
    }
    
    public int getPositiveTweetCount() {
        return positiveMessageCount;
    }
    
    public List<String> getTweetFeed() {
        
        return tweetFeed;
        
    }
    
    private void addFollower(Observer user) {
        
        this.getFollowersList().put(((User) user).getUniqueID(), user);
        
    }
    
    private void addFollowing(Subject s) {
        
        if(s.getClass() == SingleUser.class) {
            getFollowingList().put(((User) s).getUniqueID(), s);
        }
        
    }
    
    //subject methods

    public void attach(Observer observer) {
        addFollower(observer);
    }
    

    public void notifyObservers() {
        for(Observer observer : followersList.values()) {
            observer.update(this);
        }
    }
    
    //visitor methods
    
    public void postTweet(String msg) {
        
        latestMessage = msg;
        this.setTotalTweets(this.getTotalTweets() + 1);
        
        //check if the message is positibe or not
        if(isPositiveMessage(msg)) {
            positiveMessageCount++;
        }
        
        notifyObservers();
        
    }
    
    public boolean isPositiveMessage(String msg) {
        
        boolean positive = false;
        String message = msg.toLowerCase();
        String[] positiveWords = {"great", "good", "awesome", "fun", "happy"};
        
        for(String word : POSITIVE_WORDS) {
            if(message.contains(word)) {
                positive =  true;
            }
        }
        return positive;
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visitSingleUser(this);
    }
    

    
    //observer pattern
    @Override
    public void update(Subject subject) {
        tweetFeed.add(0, (((SingleUser) subject).getUniqueID() + ":" + ((SingleUser) subject).getLatestTweet()));
    }

    //composite pattern
    @Override
    public boolean contains(String id) {
        return this.getUniqueID().equals(uniqueID);
    }
    
    @Override
    public int getSingleUserCount() {
        return 1;
    }

    @Override
    public int getUserGroupCount() {
        return 0;
    }
    
    
}
