import model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDriver {

    @Test
    public void testDriverClass() {
        Customer customer = new Customer();
        assertNotNull(customer);
    }
}
