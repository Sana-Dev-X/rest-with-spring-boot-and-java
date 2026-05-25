package br.com.sanadev.rest_with_spring_boot_and_java.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"id", "address", "first_name", "last_name", "gender"})
public record PersonDTO(
        Long id,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        String address,
        String gender
){
        @JsonProperty("gender")
        public String getFormattedGender(){
                if(gender == null) return null;

                return "Male".equalsIgnoreCase(gender) ? "M" : "F";
        }
}
