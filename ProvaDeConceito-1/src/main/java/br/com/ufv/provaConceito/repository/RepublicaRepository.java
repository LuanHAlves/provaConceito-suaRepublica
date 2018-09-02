package br.com.ufv.provaConceito.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.ufv.provaConceito.Models.Republica;

@Repository
public interface RepublicaRepository extends JpaRepository<Republica, Integer>{
	
	@Query(value = "SELECT * FROM republica", nativeQuery = true)
	Republica getRepublicaRepository();
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO republica VALUES (?, ?, ?, ?, ?, ?, ?,?)", nativeQuery = true)
    public int querySave(int id, String email, String endereco, int lotacao, String nome, float valorAluguel, float valorDespesas,int user_id);

}
