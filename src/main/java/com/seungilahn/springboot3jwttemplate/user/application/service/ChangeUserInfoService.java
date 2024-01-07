package com.seungilahn.springboot3jwttemplate.user.application.service;

import com.seungilahn.springboot3jwttemplate.common.UseCase;
import com.seungilahn.springboot3jwttemplate.user.application.port.in.ChangeUserInfoCommand;
import com.seungilahn.springboot3jwttemplate.user.application.port.in.ChangeUserInfoUseCase;
import com.seungilahn.springboot3jwttemplate.user.application.port.out.SaveUserPort;
import com.seungilahn.springboot3jwttemplate.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@UseCase
@Transactional
class ChangeUserInfoService implements ChangeUserInfoUseCase {

    private final SaveUserPort saveUserPort;

    @Override
    public void changeUserInfo(User user, ChangeUserInfoCommand command) {
        user.changeUserInfo(command.name(), command.phoneNumber());
        saveUserPort.saveUser(user);
    }

}
