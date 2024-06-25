//package com.example.task.globalexceptionhandler;
//
//import com.example.task.model.response.CustomEntityResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.ConstraintViolationException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
////this annotation is used to define Global Exception Handler for for all the controller methods of all controllers
////we dont have to handle exceptions n each controller using this annotation we can consolidate exception handling of all the methods of all
////the controller at same place. the class becomes global exception handler capable of handling any exception thrown
//// by any methhod in any controller in your application
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//
//   //this annotation defines that the method is responsible for handling exceptions caused by type MethodArgumentsNotValid
//    //exceptions. It causes in our controller when the arguments we send to our method which are annotated as @Valid fails to
//    //clear validations put on those fields./So basically '@ExceptionHandler' is an annotation which will invoke the method
//    //to which it iswritten when a specific type of exception is thrown in our controller class.In this case type is
//    //'MethodArgumentNotvalid' exception
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//
//    //this annotation is used to specify which HTTP status should be returned when specific type of exception occurs
//    //'BAD_REQUEST' is the enum constant in 'HttpStatus' class which corresponds to  Http Status '400'
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    //here, the 'MethodArgumentNotValidException ex' is the exception that will be passed to this method when exception will
//    //occur when validations which are put on fields are failed by method arguments which we pass(in this case 'userrequest')
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        //'ex' is the method argument object passed above. the 'getBindingResult()' method returns 'BindingResult' object
//        //this is the method of 'MethodArgumentNotValid' class. This object contains details about validation errors
//        //'getAllErrors()' is the method of 'BindingResult' object.It returns list of'ObjectErrors' Objects which represents
//        // all validation errors.Then we iterate over each 'ObjectError' object using 'forEach' loop which are returned by
//        //'getAllErrors()' method.It is taking lambda expression as an argument.'error' represents each 'ObjectError' object returned
//        //by 'getAllErrors()' method.Further operations are performed on this 'error'.
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
//
//    //this annotation is used to handle specific exceptions which are thrown during execution of program
//    //when exception with type 'ConstraintVoilationException' occurs then this method will be invoked
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
//        Map<String, String> errors = new HashMap<>();
//        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
//        for (ConstraintViolation<?> violation : violations) {
//            String fieldName = violation.getPropertyPath().toString();
//            String errorMessage = violation.getMessage();
//            errors.put(fieldName, errorMessage);
//        }
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<CustomEntityResponse> handleGenericException(Exception ex) {
//        return new ResponseEntity<>(new CustomEntityResponse(ex.getMessage(), -1), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//
//
//
//}
