//package com.bank.customer.service.payload;
//
//import org.springframework.http.HttpStatus;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class APIResponse {
//    private String message;
//    private Boolean success;
//    private HttpStatus status;

//}
package com.bank.customer.service.payload;

import org.springframework.http.HttpStatus;

public class APIResponse {
    private String message;
    private Boolean success;
    private HttpStatus status;

    // Private constructor to prevent direct instantiation
    private APIResponse(String message, Boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    // Public static method to create new instances of APIResponse
    public static APIResponseBuilder builder() {
        return new APIResponseBuilder();
    }

    // Getter methods
    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public HttpStatus getStatus() {
        return status;
    }

    // Builder class for APIResponse
    public static class APIResponseBuilder {
        private String message;
        private Boolean success;
        private HttpStatus status;

        // Private constructor to prevent direct instantiation
        private APIResponseBuilder() {
        }

        // Setter methods for builder
        public APIResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public APIResponseBuilder success(Boolean success) {
            this.success = success;
            return this;
        }

        public APIResponseBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        // Build method to construct the APIResponse object
        public APIResponse build() {
            return new APIResponse(message, success, status);
        }
    }
}
