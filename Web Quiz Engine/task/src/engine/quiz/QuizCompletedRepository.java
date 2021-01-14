package engine.quiz;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
@Repository
public interface QuizCompletedRepository extends CrudRepository<QuizCompleted, Integer> {
    Page<QuizCompleted> findAll(Pageable pageable);

    @Query(value = "select q from QuizCompleted q where q.userId = Id", nativeQuery = false)
    Page<QuizCompleted> findAllByUserId(Long Id);
}

 */
