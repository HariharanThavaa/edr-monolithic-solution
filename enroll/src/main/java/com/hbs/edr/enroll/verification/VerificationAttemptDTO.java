package com.hbs.edr.enroll.verification;

import lombok.Value;

@Value
public class VerificationAttemptDTO {
    int guess;
    String email;
}
