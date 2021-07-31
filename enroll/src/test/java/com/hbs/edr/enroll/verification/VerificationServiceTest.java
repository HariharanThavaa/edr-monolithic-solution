package com.hbs.edr.enroll.verification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;


class VerificationServiceTest {

    private VerificationService service;

    @BeforeEach
    public void setUp() {
        service = new VerificationServiceImpl();
    }

    @Test
    public void checkCorrectAttemptTest(){
        // given
        VerificationAttemptDTO dto = new VerificationAttemptDTO(4568, "hari@gmail.com");

        // when
        VerificationAttempt verificationAttempt = service.verifyAttempt(dto);

        // then
        then(verificationAttempt.isCorrect()).isTrue();

    }

    @Test
    public void checkWrongAttemptTest(){
        // given
        VerificationAttemptDTO dto = new VerificationAttemptDTO(4567, "hari@gmail.com");

        // when
        VerificationAttempt verificationAttempt = service.verifyAttempt(dto);

        // then
        then(verificationAttempt.isCorrect()).isFalse();
    }

}