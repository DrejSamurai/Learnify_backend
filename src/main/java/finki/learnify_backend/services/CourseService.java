package finki.learnify_backend.services;

import finki.learnify_backend.models.User;
import finki.learnify_backend.models.dto.CourseDTO;
import finki.learnify_backend.models.dto.EnrollmentDTO;
import finki.learnify_backend.models.enumerators.Category;
import finki.learnify_backend.models.Course;
import finki.learnify_backend.repository.CourseRepository;
import finki.learnify_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

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

    public Course create(CourseDTO courseDto) {
        Course c = new Course();

        User userCreator = this.userRepository.findById(courseDto.getUserID()).get();

        c.setTitle(courseDto.getTitle());
        c.setDescription(courseDto.getDescription());
        c.setCategory(courseDto.getCategory());
        c.setCreator(userCreator);
        c.setDateCreated(new Date());
        c.setAuthor(courseDto.getAuthor());

        return this.courseRepository.save(c);
    }

    public Course edit(Long id, CourseDTO courseDto) {
        Course c = this.courseRepository.findById(id).get();

        c.setTitle(courseDto.getTitle());
        c.setDescription(courseDto.getDescription());
        c.setCategory(courseDto.getCategory());
        c.setDateCreated(new Date());
        c.setAuthor(courseDto.getAuthor());

        return this.courseRepository.save(c);
    }

    public void removeCourse(Long id){
        courseRepository.deleteById(id);
    }

    public Course enrollUser(EnrollmentDTO enrollmentDto) {
        Course course = this.courseRepository.findById(enrollmentDto.getCourseId()).orElseThrow();
        course.getParticipants().add(this.userRepository.findByEmail(enrollmentDto.getEmail()).orElseThrow());
        return this.courseRepository.save(course);
    }
}
