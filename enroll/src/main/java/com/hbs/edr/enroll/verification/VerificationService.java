package com.hbs.edr.enroll.verification;

public interface VerificationService {

    /**
     * Verifies if an attempt from presentation layer is correct or not
     * 
     * @param attemptDTO
     * @return
     */
    VerificationAttempt verifyAttempt(VerificationAttemptDTO attemptDTO);
}
