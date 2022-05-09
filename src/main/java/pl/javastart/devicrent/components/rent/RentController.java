package pl.javastart.devicrent.components.rent;
import org.springframework.stereotype.Service;
import pl.javastart.devicrent.components.customer.Customer;
import pl.javastart.devicrent.components.customer.CustomerRepository;
import pl.javastart.devicrent.components.device.Device;
import pl.javastart.devicrent.components.device.DeviceRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Scanner;

@Service
public class RentController {

    private Scanner scanner;
    private DeviceRepository deviceRepository;
    private CustomerRepository customerRepository;

    public RentController(Scanner scanner, DeviceRepository deviceRepository, CustomerRepository customerRepository) {
        this.scanner = scanner;
        this.deviceRepository = deviceRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void rentDeviceToCustomer() {
        try {
            rent();
        } catch(RentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void rent() {
        System.out.println("Podaj ID klienta:");
        long customerId = scanner.nextLong();
        System.out.println("Podaj ID urządzenia:");
        long deviceId = scanner.nextLong();
        Optional<Customer> customer = customerRepository.findById(customerId);
        Optional<Device> device = deviceRepository.findById(deviceId);
        if(customer.isPresent())
            device.ifPresentOrElse(dev -> {
                if(dev.getQuantity() > dev.getCustomers().size())
                    dev.addCustomer(customer.get());
                else
                    throw new RentException("Brak wolnych urządzeń o wskazanym ID");
            }, () -> {
                throw new RentException("Brak urządzenia o wskazanym ID");
            });
        else
            throw new RentException("Brak klienta o wskazanym ID");
    }
}