package selenium.testingmachine.json;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JsonDataRepository extends JpaRepository<JsonData, Long> {
    JsonData findByCode(Integer code);
}
