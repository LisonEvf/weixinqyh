package web.Dao;

import java.util.List;

import web.Model.User;

public interface  UserDao {
	public User SelectUser(String username);
	public List<User> SelectUser();

}
