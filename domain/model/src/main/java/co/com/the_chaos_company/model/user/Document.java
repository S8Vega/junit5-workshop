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
public class Document {
    private Type type;
    private String number;

    public boolean isValid() {
        return type != null && type.isValid() && number != null && !number.isEmpty();
    }

    private enum Type {
        CC, CE, TI, PP;

        public boolean isValid() {
            for (Type type : Type.values()) {
                if (type.name().equals(this.name())) {
                    return true;
                }
            }
            return false;
        }
    }
}
