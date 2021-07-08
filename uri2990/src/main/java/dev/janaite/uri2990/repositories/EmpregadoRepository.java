package dev.janaite.uri2990.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.janaite.uri2990.entities.Empregado;
import dev.janaite.uri2990.projections.EmpregadoDeptProjection;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

	@Query(nativeQuery = true, value = "SELECT e.cpf, e.enome, d.dnome "
			+ "FROM empregados e "
			+ "INNER JOIN departamentos d on e.dnumero = d.dnumero "
			+ "WHERE e.cpf NOT IN "
			+ "( "
			+ "SELECT empregados.cpf FROM empregados "
			+ "INNER JOIN trabalha t ON t.cpf_emp = e.cpf "
			+ ") "
			+ "ORDER BY e.cpf ")
	List<EmpregadoDeptProjection> search1();
	
	@Query(nativeQuery = true, value="SELECT e.cpf, e.enome, d.dnome "
			+ "FROM empregados e "
			+ "INNER JOIN departamentos d ON e.dnumero = d.dnumero "
			+ "LEFT JOIN trabalha t ON t.cpf_emp = e.cpf "
			+ "WHERE t.cpf_emp IS NULL "
			+ "ORDER BY e.cpf ")
	List<EmpregadoDeptProjection> search2();
}
