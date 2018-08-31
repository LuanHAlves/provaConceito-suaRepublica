package br.com.ufv.provaConceito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufv.provaConceito.Models.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByEmail(String email);
	 
	 User findByNomeUsuario(String username);
}
