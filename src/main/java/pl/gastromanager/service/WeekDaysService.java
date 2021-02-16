package pl.gastromanager.service;

import pl.gastromanager.model.WeekDays;
import java.util.List;
import java.util.Optional;

public interface WeekDaysService {
    Optional<WeekDays> findById(Long id);
    Optional<WeekDays>findByName(String name);
    List<WeekDays> findAll();
}
