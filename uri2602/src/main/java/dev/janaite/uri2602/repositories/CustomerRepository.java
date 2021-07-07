package dev.janaite.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.janaite.uri2602.entities.Customer;
import dev.janaite.uri2602.projections.CustomerMinProjection;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(nativeQuery = true, value = "SELECT name FROM customers WHERE state = :state")
	List<CustomerMinProjection> search1(String state);

}
