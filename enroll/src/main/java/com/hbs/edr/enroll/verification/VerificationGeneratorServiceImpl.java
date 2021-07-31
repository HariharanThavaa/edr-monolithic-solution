package com.hbs.edr.enroll.verification;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class VerificationGeneratorServiceImpl implements VerificationGeneratorService {

    private final Random random;

    private final static int MINIMUM_FACTOR = 1001;
    private final static int MAXIMUM_FACTOR = 9999;

    VerificationGeneratorServiceImpl() {
        this.random = new Random();
    }

    protected VerificationGeneratorServiceImpl(final Random random) {
        this.random = random;
    }

    @Override
    public Verification randomVerification() {
        return new Verification(next());
    }

    private int next() {
        return random.nextInt(MAXIMUM_FACTOR - MINIMUM_FACTOR) + MINIMUM_FACTOR;
    }
}
