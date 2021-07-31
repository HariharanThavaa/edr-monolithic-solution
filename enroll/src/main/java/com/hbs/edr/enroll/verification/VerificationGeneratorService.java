package com.hbs.edr.enroll.verification;

public interface VerificationGeneratorService {

    /**
     *
     * @return a randomly generated otp
     */
    Verification randomVerification();
}
