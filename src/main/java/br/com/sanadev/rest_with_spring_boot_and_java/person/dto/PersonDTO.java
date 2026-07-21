package br.com.sanadev.rest_with_spring_boot_and_java.person.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public record PersonDTO (
        Long id,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        String address,
        String gender
){
        public String getFormattedGender(){
                if(gender == null) return null;

                return "Male".equalsIgnoreCase(gender) ? "M" : "F";
        }
}
