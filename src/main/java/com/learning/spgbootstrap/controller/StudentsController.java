package com.learning.spgbootstrap.controller;

import com.learning.spgbootstrap.model.dto.StudentDto;
import com.learning.spgbootstrap.model.enums.Gender;
import com.learning.spgbootstrap.validators.ContactNumberConstraint;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Validated
@RequestMapping("api/v1/students")
@RestController
public class StudentsController {


    @PostMapping
    public ResponseEntity getStudents(StudentDto studentDto){

        studentDto.setGender(Gender.MALE.toString());
        return new ResponseEntity<>(studentDto,HttpStatus.OK);
    }

//    This exception handler can also be set in MvcExceptionHandler with @controllerAdvice to avoid code repetition
//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
//            List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
//
//            e.getConstraintViolations().forEach(constraintViolation -> {
//                errors.add(constraintViolation.getMessage());
//            });
//            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

    @GetMapping
    public ResponseEntity testValidation(@RequestParam(required = false, name = "param1") @NotNull(message = "first param cannot be empty") String a,
                                         @RequestParam(required = false, name = "param2") @NotNull(message = "b param2 param cannot be empty") String b,
                                         @RequestParam(required = false, name = "phone") @ContactNumberConstraint String ph){
        System.out.println(a);

//      @ContactNumberConstraint is a custom validator

//        @Validated on class top is required to check the params for function

//        MVC validation can also be applied with dto (@Valid @RequestBody bodyDto )


//        This will not work
//        @Valid
//        @NotNull(message = "param3 cannot be null")
//        String param3 = null;
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
