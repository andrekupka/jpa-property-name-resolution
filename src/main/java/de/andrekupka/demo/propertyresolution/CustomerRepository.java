package de.andrekupka.demo.propertyresolution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("SELECT c FROM Customer c WHERE c.cLoginId = :cLoginId")
    Optional<Customer> findByCLoginId(String cLoginId);
}
