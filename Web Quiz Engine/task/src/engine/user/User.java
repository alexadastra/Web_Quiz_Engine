package engine.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import engine.quiz.Quiz;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "'email' field does not contain a valid email!", regexp = "^(\\S+)@(\\S+)(\\.)(\\S+)$")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 5, max = 222, message = " field password must be not less than 5 characters long")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @JsonIgnore
    @OneToMany
    List<Quiz> quizzes;

    protected User() { }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() { return password; }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public void encryptPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode(password);
        this.password = result;
    }
}

 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
@NotNull
public class User {
    @JsonIgnore
    @OneToMany
    List<Quiz> quizzes;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "'email' field must not be blank!")
    @Email(message = "'email' field does not contain a valid email!", regexp = "^(\\S+)@(\\S+)(\\.)(\\S+)$")
    private String email;
    @Size(min = 5, max = 222, message = " field password must be not less than 5 characters long")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public User() {
    }

    public User(@NotBlank(message = "'email' field must not be blank!") @Email(message = "'email' field does not contain a valid email!") String email, @Size(min = 5) String password) {
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void encryptPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String result = encoder.encode(password);
        this.password = result;
    }
}