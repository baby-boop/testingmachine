package selenium.testingmachine.json;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.io.Serializable;

@Entity
public class JsonData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated primary key

    @Column(name = "code", unique = true, nullable = false)
    private Integer code;

    @Column(name = "name", columnDefinition = "TEXT") // Use TEXT for larger JSON strings
    private String name; // To store JSON data

    @Column(name = "description", columnDefinition = "LONGTEXT") // Use LONGTEXT for large JSON data
    private String description; // To store full JSON file

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
