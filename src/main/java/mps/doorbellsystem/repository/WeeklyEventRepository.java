package mps.doorbellsystem.repository;

import mps.doorbellsystem.model.WeeklyEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeeklyEventRepository extends JpaRepository<WeeklyEvent, Integer> {
}
