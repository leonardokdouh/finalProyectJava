package utils.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Shifts {
    @JsonProperty("Night")
    NIGHT ("Night"),
    @JsonProperty("Evening")
    EVENING ("Evening"),
    @JsonProperty("Morning")
    MORNING ("Morning");

    private final String value;

    Shifts(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
