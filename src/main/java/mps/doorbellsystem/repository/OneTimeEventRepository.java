package mps.doorbellsystem.repository;

import mps.doorbellsystem.model.OneTimeEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OneTimeEventRepository extends JpaRepository<OneTimeEvent, Integer> {
}
