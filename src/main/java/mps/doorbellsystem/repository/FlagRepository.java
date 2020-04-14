package mps.doorbellsystem.repository;

import mps.doorbellsystem.model.Flag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlagRepository extends JpaRepository<Flag, String> {
}
