/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lab7.entities.Comment;
import lab7.entities.Post;
import lab7.entities.User;

/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    
    Map<Integer,Integer> usersum =new HashMap<Integer,Integer>();
    public void userWithMostLikes(){
        Map<Integer,Integer> userLikecount =new HashMap<Integer,Integer>();
        Map<Integer,User> users =DataStore.getInstance().getUsers();
        for(User user:users.values())
        {
         int likes=0;
        for(Comment c:user.getComments())
        { 
        
        if(userLikecount.containsKey(user.getId()))
            likes=userLikecount.get(user.getId());
        likes+=c.getLikes();
       userLikecount.put(user.getId(), likes);
    }         
        }
        int max=0;
        int maxId=0;
        for(int id:userLikecount.keySet())
        {
           // System.out.println("id "+id+" likes : "+userLikecount.get(id));
            if(userLikecount.get(id)>max){
                
                max=userLikecount.get(id);
            maxId=id;}
        }
        System.out.println("User with most likes : "+max+"\n"+users.get(maxId));
        
    }
    public void topFiveComents(){
                Map<Integer,Comment> comments =DataStore.getInstance().getComments();
        List<Comment> commentList=new ArrayList<>(comments.values());
        Collections.sort(commentList,new Comparator<Comment>(){
        @Override
        public int compare(Comment o1,Comment o2)
        {
            return o2.getLikes()-o1.getLikes();
        }
        });
        
        
    }
     public void averageLikesPerComment()
   {
       Map<Integer,Comment> comments =DataStore.getInstance().getComments();
       double sum=0;
       int tot=0;
       for(Comment c: comments.values())
       {
           sum+=c.getLikes();
       }
       double average= sum/comments.size();
       System.out.println("Average number of likes per comment :"+(int)average);
   }
     public  void postWithMostLikedComments()
   {
       Map<Integer,Post> post =DataStore.getInstance().getPosts();
      Map<Integer,Integer> postLikecount =new HashMap<Integer,Integer>();
       for(Post p:post.values())
       {
           int likes=0;
           for(Comment c:p.getComments())
           {
               if(postLikecount.containsKey(p.getPostId()))
                   likes=postLikecount.get(p.getPostId());
              likes+=c.getLikes();
              postLikecount.put(p.getPostId(), likes);
           }
       }
       int max=0;
        int maxId=0;
        for(int id:postLikecount.keySet())
        {
           // System.out.println("id "+id+" likes : "+userLikecount.get(id));
            if(postLikecount.get(id)>max){
                
                max=postLikecount.get(id);
            maxId=id;
            }
        }
        System.out.println("Post with most liked Comments is: "+maxId+ " and the maximum likes is : "+max);
   }          
       public void getPostMostcomments(){
        Map<Integer,Integer> postCommentCount =new HashMap<Integer,Integer>();
       Map<Integer,Post> posts =DataStore.getInstance().getPosts();
       int postid = 0;
       System.out.println("\n");
       for(Post post:posts.values())
       {
       for(Comment c:post.getComments())
       { 
           int comment=0;
           if(postCommentCount.containsKey(post.getPostId()))
               comment=postCommentCount.get(post.getPostId());
           comment+=1;
           postCommentCount.put(post.getPostId(), comment);
      //     postid = post.getPostId();
       }
       }
       int maxValueInMap=(Collections.max(postCommentCount.values()));
       for(Map.Entry<Integer,Integer> entry: postCommentCount.entrySet()){
           if(entry.getValue()==maxValueInMap){
               System.out.println("Post ID with maximum Comments :"+ entry.getKey()+"  Number of Comments: "+ entry.getValue());
           }
       }
    }

       public void getSum() {
        Map<Integer, Post> posts = DataStore.getInstance().getPosts();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        
        int sum = 0;
        for (User user : users.values()) {
            sum = 0;
            int postSum = 0;
            for (Post p : posts.values()) {
                if (p.getUserId() == user.getId()) {
                    postSum++;
                }
            }

            int commentSum = 0;
            int likesSum = 0;
            for (Comment c : comments.values()) {
                if (c.getUserId() == user.getId()) {
                    likesSum += c.getLikes();
                    commentSum++;
                }
            }

            sum = postSum + likesSum + commentSum;
            usersum.put(user.getId(), sum);
        }

    }

    public void getFiveInactiveUsersOverall() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        getSum();
        List<Integer> slist = new ArrayList<>(usersum.values());
        Collections.sort(slist, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        
        
        System.out.println("\nTop Five Inactive Users");
        
        for (int i = 0; i < slist.size() && i < 5; i++) {
            
            for (Entry <Integer, Integer> en : usersum.entrySet())
            {
                if(en.getValue().equals(slist.get(i)))
                {
                    
                     for (User user : users.values())
                     {
                         if(user.getId() == en.getKey())
                         {
                             System.out.println(users.get(user.getId()));
                         }
                     }
                }
            }

            System.out.println("Sum of overall posts, comments & likes: " +slist.get(i)+"\n");
        }
    }
    
    public void getFiveProactiveUsersOverall() {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        getSum();
        List<Integer> slist = new ArrayList<>(usersum.values());
        Collections.sort(slist, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
       
        System.out.println("\nTop Five Proactive Users");
        
        for (int i = slist.size()-1; i > 4 ; i--) {
            for (Entry <Integer, Integer> en : usersum.entrySet())
            {
                if(en.getValue().equals(slist.get(i)))
                {
                     for (User user : users.values())
                     {
                         if(user.getId() == en.getKey())
                         {
                             System.out.println(users.get(user.getId()));
                         }
                     }
                }
            }

            System.out.println("Sum of overall posts, comments & likes: " +slist.get(i)+"\n");
        }

    }
    public void get5InactiveUsersWithPost(){
       Map<Integer,Integer> postCount =new HashMap<Integer,Integer>();
       Map<Integer,Post> posts =DataStore.getInstance().getPosts();
       int postid = 0;
       int count=0;
       for(Post post:posts.values())
       {
           if(postCount.containsKey(post.getPostId()))
           {
                count =postCount.get(post.getPostId());
           }
           count = count+1;
           postCount.put(post.getPostId(),post.getUserId());
       }
       int count1 = 0;
       Map<Integer, Integer> map = new HashMap<Integer, Integer>();
       for(int i=0;i<10;i++)
       {
            for (int temp : postCount.keySet())
            {
                if(postCount.get(temp).equals(i))
                {
                     count1 = count1 + 1;
                }
            }
            map.put(i,count1);  //will put all users based on all the number of post the user posted
            count1 = 0;
        }
   
       
        List<Map.Entry<Integer, Integer> > list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet()); 
        //    Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >(){ 
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)                       
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data based on accesding order which has least number of posts 
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list)
        { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        
        // Display user based on least number of posts
        Map<Integer,User> user = DataStore.getInstance().getUsers();
        List<Integer> keys = new ArrayList<>(temp.keySet());
        List<Integer> values = new ArrayList<>(temp.values());
        System.out.println("\n");
        System.out.println("Users with least number of posted posts:");
        for(int i=0;i<5;i++)
        {
            for(Map.Entry m : user.entrySet())
            {
                if(keys.get(i).equals(m.getKey()))
                {
                    System.out.println(m.getValue()+"  Number of Posts:"+ values.get(i));
                }
            }   
        }
    }
    
    public void get5InactiveUsersWithComment(){
       Map<Integer,User> user =DataStore.getInstance().getUsers();
       List<User> commentList=new ArrayList<>(user.values());
       Collections.sort(commentList,new Comparator<User>(){
       @Override
       public int compare(User o1,User o2)
       {
           
               return o2.comments.size()-o1.comments.size();
       }
       });
       System.out.println("\n Users with least number of comments :");
       Collections.reverse(commentList);
       for(int i=0;i<commentList.size() && i<5; i++){
           System.out.println(commentList.get(i) );
       }

    }
    
       
}

    
