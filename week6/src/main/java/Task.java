
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asus
 */
public class Task {
    
    private String owner;
    private String description;
    private LocalDate deadline;

    
    
    public Task(String owner, String description, String deadline) {
        this.owner = owner;
        this.description = description;
        LocalDate d = LocalDate.parse(deadline);
        if(d.equals(LocalDate.now()) || d.isBefore(LocalDate.now())){
            throw new DateTimeException("Invalid date time error.");
        }else{
            this.deadline = d;
        }
    }

    public Task() {
        this.owner = "Owner";
        this.description = "Description";
        this.deadline = LocalDate.now();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
      if(deadline.equals(LocalDate.now()) || deadline.isBefore(LocalDate.now())){
            throw new DateTimeException("Invalid date time error.");
        }else{
            this.deadline = deadline;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.owner);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.deadline);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.deadline, other.deadline)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task{" + "owner: " + owner + ", description: " + description + ", deadline: " + deadline + '}';
    }
    
    
    
}
