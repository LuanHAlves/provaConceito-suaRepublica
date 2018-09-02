package br.com.ufv.provaConceito.Service;

import br.com.ufv.provaConceito.Models.User;

public interface UserService{
	public User findUserByEmail(String email);
	public User findUserByUsername(String name);
	public void saveUser(User user);
	public void editUser(User user);
}
