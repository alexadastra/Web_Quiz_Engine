package engine.quiz;

import engine.quiz.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/*
@Repository
public interface QuizRepository extends PagingAndSortingRepository<Quiz, Integer> {
    Page<Quiz> findAll(Pageable pageable);
}
*/
@Repository
public interface QuizRepository extends CrudRepository<Quiz, Integer> {
    Page<Quiz> findAll(Pageable pageable);
}


