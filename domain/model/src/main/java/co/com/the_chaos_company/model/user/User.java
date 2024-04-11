package co.com.the_chaos_company.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    private Document document;
    private String name;
    private Integer age;

    public boolean isValid() {
        return document != null && document.isValid() && isValidName() && isValidAge();
    }

    private boolean isValidName() {
        return name != null && !name.isEmpty() && name.length() > 3;
    }

    private boolean isValidAge() {
        return age != null && age >= 18 && age < 100;
    }
}
