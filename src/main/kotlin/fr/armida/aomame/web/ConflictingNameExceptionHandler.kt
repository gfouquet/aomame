package fr.armida.aomame.web

import org.springframework.http.HttpStatus.CONFLICT
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * @author gfouquet
 */
@ControllerAdvice
class ConflictingNameExceptionHandler {
    @ExceptionHandler(ConflictingNameException::class)
    @ResponseStatus(CONFLICT)
    fun handleConflictingName() {
        // NOOP
    }
}

