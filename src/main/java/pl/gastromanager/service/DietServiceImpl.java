package pl.gastromanager.service;

import org.springframework.stereotype.Service;
import pl.gastromanager.model.Diet;
import pl.gastromanager.repository.DietRepository;

import java.util.List;

@Service
public class DietServiceImpl implements DietService{
    private final DietRepository dietRepository;

    public DietServiceImpl(DietRepository dietRepository) {
        this.dietRepository = dietRepository;
    }

    @Override
    public List<Diet> findAllDiets() {
        return dietRepository.findAll();
    }
}
