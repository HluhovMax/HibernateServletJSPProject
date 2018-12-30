package mvc.repository;

import mvc.model.Developer;

import java.util.List;

public interface DeveloperRepository extends GenericRepository<Developer, Integer> {
    @Override
    void save(Developer developer);

    @Override
    Developer getById(Integer id);

    @Override
    void update(Developer developer);

    @Override
    List<Developer> getAll();

    @Override
    void delete(Integer id);
}
