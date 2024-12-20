package org.tenten.bittakotlin.jobpost.controller.advice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.tenten.bittakotlin.jobpost.exception.JobPostTaskException

@RestControllerAdvice
class JobPostControllerAdvice {
    @ExceptionHandler(JobPostTaskException::class)
    fun handleArgsException(e: JobPostTaskException): ResponseEntity<Map<String, String>> {
        return ResponseEntity.status(e.code)
            .body(mapOf("error" to e.message))
    }
}
