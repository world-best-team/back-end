package team.world.best.backend.common.code;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
public enum ConflictExceptionCode {
    E01_001("E01-001", CONFLICT);

    private final String code;
    private final HttpStatus status;
}
