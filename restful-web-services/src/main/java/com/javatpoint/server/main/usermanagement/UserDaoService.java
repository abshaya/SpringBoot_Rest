package com.javatpoint.server.main.usermanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static int UserCount = 5;
	private static ArrayList<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1,"Noor",new Date()));
		users.add(new User(2,"Jahan",new Date()));
		users.add(new User(3,"Juhi",new Date()));
		users.add(new User(4,"Abshaya",new Date()));
		users.add(new User(5,"Yasmin",new Date()));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public User getUser(int id) {
		/*
		 * Stream st = users.stream().map((user) -> {return user.getUserID() == id;});
		 * ArrayList<User> newUserList = (ArrayList<User>)
		 * st.collect(Collectors.toList()); return newUserList.get(0);
		 */
		for(User user : users) {
			if(user.getUserID() == id) {
				return user;
			}
		}
		return null;
	}
	
	public int saveUser(User user) {
		UserCount++;
		if(users.add(new User(UserCount,user.getUserName(),user.getDob())))
				{
			return 1;
		}
			return 0;
		
		
	}
	
	public User createUser(User user) {
		UserCount++;
		user.setUserID(UserCount);
		if(users.add(user))
				{
			return user;
		}
			return user;
	}
	
	
	public User deleteUser(User sUser) {
		/*
		 * if(users.remove(user)) { UserCount--; return user; } return null;
		 */
		Iterator<User> iterator = users.iterator();  
		while(iterator.hasNext())  
		{  
		User user=iterator.next();  
		if(user.getUserID()== sUser.getUserID())  
		{  
		iterator.remove();  
		return user; //returns the deleted resource back  
		}  
		}  
		return null;  
		
	}
	
}
