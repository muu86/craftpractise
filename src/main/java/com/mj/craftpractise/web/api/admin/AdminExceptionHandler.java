package com.mj.craftpractise.web.api.admin;

import com.mj.craftpractise.domain.model.category.CategoryCreationException;
import com.mj.craftpractise.web.result.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(annotations = RestController.class)
@Slf4j
public class AdminExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({CategoryCreationException.class})
    protected ResponseEntity<ApiResult> handle(CategoryCreationException ex) {
        ApiResult apiResult = ApiResult.error(ex.getMessage());
        return ResponseEntity.badRequest().body(apiResult);
    }
}
