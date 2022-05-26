package com.learning.spgbootstrap.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.learning.spgbootstrap.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    @JsonProperty("student")
    public String name;

    @JsonProperty("since")
    public String age;

    @Null
    @JsonProperty("gender")
    public String gender;
}
