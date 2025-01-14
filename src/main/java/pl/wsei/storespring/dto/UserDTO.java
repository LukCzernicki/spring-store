package pl.wsei.storespring.dto;

import pl.wsei.storespring.model.User;
import jakarta.validation.constraints.*;

public class UserDTO {

    @NotNull(message = "ID cannot be null.")
    private Long id;

    @NotBlank(message = "Name cannot be empty.")
    private String name;

    @NotBlank(message = "Surname cannot be empty.")
    @Size(min = 2, message = "Surname must be at least 2 characters long.")
    private String surname;

    @NotBlank(message = "Login cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Login must contain only letters and numbers.")
    private String login;

    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Invalid email format.")
    private String email;

    // Gettery i settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static UserDTO fromEntity(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setLogin(user.getLogin());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setLogin(dto.getLogin());
        user.setEmail(dto.getEmail());
        return user;
    }
}

