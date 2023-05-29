package finki.learnify_backend.controllers;

import finki.learnify_backend.models.Course;
import finki.learnify_backend.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CoursesController {
    private final CourseService courseService;

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @PostMapping("/all-courses")
    public Page<Course> getAllCourses(@RequestParam(defaultValue = "0") Integer pageNo,
                                      @RequestParam(defaultValue = "3") Integer pageSize,
                                      @RequestParam(defaultValue = "id") String sortBy){
        return this.courseService.listAllCourses(pageNo, pageSize, sortBy);
    }
}
