package org.example.yeye_backend.domain.auth.service;

import lombok.RequiredArgsConstructor;
import org.example.yeye_backend.domain.auth.presentation.request.RegisterRequestDto;
import org.example.yeye_backend.domain.common.service.FileUploadService;
import org.example.yeye_backend.domain.user.domain.User;
import org.example.yeye_backend.domain.user.exception.UserExistException;
import org.example.yeye_backend.domain.user.domain.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(RegisterRequestDto dto){
        if(userRepository.findByAccountId(dto.accountId()).isPresent()){
            throw UserExistException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .accountId(dto.accountId())
                .name(dto.name())
                .password(passwordEncoder.encode(dto.password()))
                .build());
    }
}
