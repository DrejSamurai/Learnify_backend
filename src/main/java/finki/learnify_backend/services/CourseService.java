package finki.learnify_backend.services;

import finki.learnify_backend.enumerators.Category;
import finki.learnify_backend.models.Course;
import finki.learnify_backend.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public Page<Course> listAllCourses(Integer pageNo, Integer pageSize, String sortBy){
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Course> page = courseRepository.findAllPaged(pageable);
        return page;
    }

    public List<Course> listCoursesByCategory(String category){
        return courseRepository.findAllByCategory(category);
    }

    public Course findById(Long id){
        return courseRepository.findById(id).orElseThrow();
    }

    public Course createCourse(String title, String author, Category category, Long price, Long rating){
        Course course = new Course(title, author, category, price, rating);
        courseRepository.save(course);
        return course;
    }

    public void removeCourse(Long id){
        courseRepository.deleteById(id);
    }

}
