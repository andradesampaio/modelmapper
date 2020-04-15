import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderDTOTest {

    @Test
    void should_validate_orderDTO(){
        Address address = new Address("Rua Jeremy Benthan", "Sao Paulo");
        Name name = new Name("Teste", "Teste");
        Customer customer = new Customer(name);
        Order order = new Order(customer, address);

        ModelMapper modelMapper = new ModelMapper();
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());

    }
}
