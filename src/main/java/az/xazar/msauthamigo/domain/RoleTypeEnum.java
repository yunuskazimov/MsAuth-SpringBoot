package az.xazar.msauthamigo.domain;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Locale;

public enum RoleTypeEnum {
    USER, ADMIN, REPORTER, MANAGER, SUPER;

    @JsonValue
    public String toLower() {
        return this.toString().toLowerCase(Locale.ENGLISH);
    }
}
