package mvc.repository;

import mvc.model.Skill;

import java.util.List;

public interface SkillRepository extends GenericRepository<Skill, Integer> {
    @Override
    void save(Skill skill);

    @Override
    Skill getById(Integer id);

    @Override
    void update(Skill skill);

    @Override
    List<Skill> getAll();

    @Override
    void delete(Integer id);
}
