package pl.javastart.devicrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.devicrent.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}