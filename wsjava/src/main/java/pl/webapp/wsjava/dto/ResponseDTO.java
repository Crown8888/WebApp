package pl.webapp.wsjava.dto;

import pl.webapp.wsjava.model.User;

public class ResponseDTO {

    private String token;
    private UserDTO userEntity;

    public ResponseDTO() {
    }

    public ResponseDTO(String token, UserDTO userEntity) {
        this.token = token;
        this.userEntity = userEntity;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDTO getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserDTO userEntity) {
        this.userEntity = userEntity;
    }
}