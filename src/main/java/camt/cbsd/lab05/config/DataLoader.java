package camt.cbsd.lab05.config;

import camt.cbsd.lab05.dao.CourseDao;
import camt.cbsd.lab05.dao.StudentDao;
import camt.cbsd.lab05.entity.Course;
import camt.cbsd.lab05.entity.Student;
import camt.cbsd.lab05.entity.security.Authority;
import camt.cbsd.lab05.entity.security.AuthorityName;
import camt.cbsd.lab05.entity.security.User;
import camt.cbsd.lab05.security.repository.AuthorityRepository;
import camt.cbsd.lab05.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@ConfigurationProperties(prefix = "server")
@Component
public class DataLoader implements ApplicationRunner {
    StudentDao studentDao;

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;

    }

    @Autowired
    CourseDao courseDao;

    String baseUrl;
    String imageUrl;
    String imageBaseUrl;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        imageBaseUrl = baseUrl + imageUrl;
        Student student1 = Student.builder().studentId("SE-001").name("Mitsuha").surname("Miyamizu")
                .gpa(2.15).image(imageBaseUrl + "mitsuha.gif").feature(true)
                .penAmount(0).description("The most beloved one").build();
        Student student2 = Student.builder().studentId("SE-002").name("Prayuth").surname("The minister")
                .gpa(3.59).image(imageBaseUrl + "tu.jpg").feature(false)
                .penAmount(15).description("The great man ever!!!!").build();
        Student student3 = Student.builder().studentId("SE-003").name("Jurgen").surname("Kloop")
                .gpa(2.15).image(imageBaseUrl + "Kloop.gif").feature(true)
                .penAmount(2).description("The man for the Kop").build();

        Course course1 = Course.builder().courseId("953331").courseName("CBSD").build();
        Course course2 = Course.builder().courseId("953323").courseName("Software Construction").build();
        Course course3 = Course.builder().courseId("953499").courseName("Software Project").build();

        courseDao.add(course1);
        courseDao.add(course2);
        courseDao.add(course3);
        studentDao.addStudent(student1);
        studentDao.addStudent(student2);
        studentDao.addStudent(student3);

        student1.addCourse(course1);
        student1.addCourse(course2);
        student2.addCourse(course2);
        student2.addCourse(course3);
        student3.addCourse(course1);
        student3.addCourse(course3);
        securitySetup();

    }


    private void securitySetup() {
        Authority auth1 = Authority.builder().name(AuthorityName.ROLE_USER).build();
        Authority auth2 = Authority.builder().name(AuthorityName.ROLE_ADMIN).build();
        authorityRepository.save(auth1);
        authorityRepository.save(auth2);
        User user1 = User.builder()
                .username("admin")
                .password("admin")
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        User user2 = User.builder()
                .username("user")
                .password("user")
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        User user3 = User.builder()
                .username("disabled")
                .password("disabled")
                .firstname("user")
                .lastname("user")
                .email("disabled@user.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2016,01,01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
        user1.setAuthorities(new ArrayList<>());
        user1.getAuthorities().add(auth1);
        user1.getAuthorities().add(auth2);
        user2.setAuthorities(new ArrayList<>());
        user2.getAuthorities().add(auth1);
        user3.setAuthorities(new ArrayList<>());
        user3.getAuthorities().add(auth1);
        userRepository .save(user1);
        userRepository .save(user2);
        userRepository .save(user3);

    }
}


