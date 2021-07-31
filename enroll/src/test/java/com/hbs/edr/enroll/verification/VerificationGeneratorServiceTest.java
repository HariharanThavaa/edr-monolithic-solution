package com.hbs.edr.enroll.verification;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(MockitoExtension.class)
class VerificationGeneratorServiceTest {

    private VerificationGeneratorService service;

    @Spy
    private Random random;

    @BeforeEach
    public void setUp() {
        service = new VerificationGeneratorServiceImpl(random);
    }

    @Test
    public void generateVerificationCodeBetweenExpectedLimits() {
        // 8999 is max - min range
        given(random.nextInt(8998)).willReturn(3457);

        //when we generate a verification
        Verification verification  = service.randomVerification();

        // then the challenge contains factors as expected
        then(verification.getOtp()).isEqualTo(4458);
    }
}