package finki.learnify_backend.controllers;

import finki.learnify_backend.models.dto.CourseDTO;
import finki.learnify_backend.models.dto.EnrollmentDTO;
import finki.learnify_backend.models.Course;
import finki.learnify_backend.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
                                      @RequestParam(defaultValue = "id") String sortBy,
                                      @RequestParam String category,
                                      @RequestParam String search){
        return this.courseService.listAllCourses(pageNo, pageSize, sortBy);
    }
    @PostMapping("/all-courses/category")
    public ResponseEntity<List<Course>> getAllCoursesByCategory(@RequestParam String category) {
        return ResponseEntity.ok(courseService.listCoursesByCategory(category));
    }
    @PostMapping("/enroll-user")
    private ResponseEntity<Course> enrollUser(@RequestBody EnrollmentDTO enrollmentDto){
        return ResponseEntity.ok().body(this.courseService.enrollUser(enrollmentDto));
    }

    @PostMapping("course/create")
    private ResponseEntity<Course> create(@RequestBody CourseDTO courseDto) {
        return ResponseEntity.ok().body(this.courseService.create(courseDto));
    }

    @PutMapping("course/edit/{id}")
    private ResponseEntity<Course> edit(@PathVariable Long id, @RequestBody CourseDTO courseDto) {
        return ResponseEntity.ok().body(this.courseService.edit(id, courseDto));
    }

    @PostMapping("/delete/{id}")
    private void delete(@PathVariable Long id){
        this.courseService.removeCourse(id);
    }
}
