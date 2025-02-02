package pl.webapp.wsjava.dto;

public class ResponseDTO {

    private String token;
    private UserDTO userDTOEntity;

    public ResponseDTO() {
    }

    public ResponseDTO(String token, UserDTO userDTOEntity) {
        this.token = token;
        this.userDTOEntity = userDTOEntity;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserDTO getUserEntity() {
        return userDTOEntity;
    }

    public void setUserEntity(UserDTO userDTOEntity) {
        this.userDTOEntity = userDTOEntity;
    }
}