package de.andrekupka.demo.propertyresolution;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    @Before
    public void setUp() {
        Customer customer = new Customer();
        customer.setId("id");
        customer.setCLoginId("cId");
        repository.save(customer);
    }

    @Test
    public void shouldReturnCustomer() {
        Optional<Customer> actualCustomer = repository.findByCLoginId("cId");
        assertThat(actualCustomer).hasValueSatisfying(customer -> {
            assertThat(customer.getId()).isEqualTo("id");
            assertThat(customer.getCLoginId()).isEqualTo("cId");
        });
    }
}
