package com.hbs.edr.enroll.verification;

import com.hbs.edr.enroll.user.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class VerificationAttempt {
    private Long id;
    private User user;
    private int otp;
    private int guess;
    private boolean correct;
}
