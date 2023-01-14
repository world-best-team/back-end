package team.world.best.backend.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import team.world.best.backend.common.code.ConflictExceptionCode;

@Getter
@AllArgsConstructor
public class ConflictException extends RuntimeException{

    private final ConflictExceptionCode conflictExceptionCode;

}
