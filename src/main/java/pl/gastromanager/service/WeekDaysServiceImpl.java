package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.WeekDays;
import pl.gastromanager.repository.WeekDaysRepository;
import java.util.List;
import java.util.Optional;

@Service
public class WeekDaysServiceImpl implements WeekDaysService{

    private final WeekDaysRepository weekDaysRepository;

    public WeekDaysServiceImpl(WeekDaysRepository weekDaysRepository) {
        this.weekDaysRepository = weekDaysRepository;
    }

    @Override
    public Optional<WeekDays> findById(Long id) {
        return weekDaysRepository.findById(id);
    }

    @Override
    public Optional<WeekDays> findByName(String name) {
        return weekDaysRepository.findByName(name);
    }

    @Override
    public List<WeekDays> findAll() {
        return weekDaysRepository.findAll();
    }
}
