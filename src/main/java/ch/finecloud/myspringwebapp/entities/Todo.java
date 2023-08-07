package ch.finecloud.myspringwebapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(min = 10, message = "Enter at least 10 characters.")
    private String description;
    @NotNull(message = "Due date cannot be null.")
    @Future(message = "Due date must be in the future.")
    private LocalDate dueDate;
    private boolean completed;

    public Todo(int id, String username, String description, LocalDate dueDate, boolean completed) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public Todo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", completed=" + completed +
                '}';
    }
}
