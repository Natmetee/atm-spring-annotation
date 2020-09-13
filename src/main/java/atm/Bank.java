package atm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * A bank contains customers with bank accounts.
 */
@Component
public class Bank {

   private String name;
   private Map<Integer,Customer> customers;
   private DataSource dataSource;

   /**
    *
    *
    * Constructs a bank with no customers.
    */
   @Autowired
   public Bank(@Value("${bankname}") String name, DataSource dataSource) {
      this.name = name;
      this.dataSource = dataSource;
      this.customers = dataSource.readCustomers();
   }
   /**
    * Adds a customer to the bank.
    * @param customer the customer to add
    */
   public void registerCustomer(Customer customer) {
      customers.put(customer.getId(), customer);
   }

   /**
    * Finds a customer in the bank.
    * @param id a customer id
    * @return the matching customer, or null if no customer
    * matches
    */
   public Customer findCustomer(int id) {
      return customers.get(id);
   }

   public String getName() {
      return name;
   }
}

