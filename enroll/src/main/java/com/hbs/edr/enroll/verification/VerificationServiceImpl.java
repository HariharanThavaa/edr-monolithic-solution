package com.hbs.edr.enroll.verification;

import com.hbs.edr.enroll.user.User;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl implements VerificationService {



    @Override
    public VerificationAttempt verifyAttempt(VerificationAttemptDTO attemptDTO) {

        // Check the attempt is correct
        boolean isCorrect = attemptDTO.getGuess() == 4568;

        // We don't use identifiers now
        User user = new User(null, null, attemptDTO.getEmail());

        // Builds the domain object. Null Id for now
        VerificationAttempt attempt = new VerificationAttempt(
                null,
                user,
                4568,
                attemptDTO.getGuess(),
                isCorrect
        );

        return attempt;
    }
}
