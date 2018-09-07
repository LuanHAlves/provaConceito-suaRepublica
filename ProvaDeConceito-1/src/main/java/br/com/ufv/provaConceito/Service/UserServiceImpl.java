package br.com.ufv.provaConceito.Service;

import java.util.Arrays;
import java.util.HashSet;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ufv.provaConceito.Models.Role;
import br.com.ufv.provaConceito.Models.User;
import br.com.ufv.provaConceito.repository.RoleRepository;
import br.com.ufv.provaConceito.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService, UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private EntityManager entityManager;
	
    
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User findUserByUsername(String name) {
		return userRepository.findByNomeUsuario(name);
	}

	@Override
	public void saveUser(User user) {
		user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
		
		 Role userRole = roleRepository.findByRole("ADMIN");
		 if(userRole==null)
		 {
			userRole = new Role();
			userRole.setRole("ADMIN");
			userRole.setId(0);
		 }
        
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
	
	@Override
	@Transactional
	public void editUser(User user) {
		user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		entityManager.merge(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByNomeUsuario(username);
		
		if(user == null){
			System.out.println("login errado");//teste falha login
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		System.out.println("login ok"); // teste sucesso login
		return user;
	}

}
