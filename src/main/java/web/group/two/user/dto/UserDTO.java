package web.group.two.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import web.group.two.user.entity.User;


@Schema(description = "User DTO")
@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserDTO {

    @Schema(name = "id", description = "user id", example = "1")
    private Long id;

    @Schema(name = "name", description = "user name", example = "Tony Stark")
    private String name;

    @Schema(name = "age", description = "user age", example = "12")
    private Integer age;

    @Schema(name = "nickName", description = "user nickName", example = "Tony Stark")
    private String nickName;

    @Schema(name = "username", description = "username", example = "SFA")
    private String username;


    public UserDTO(final User user){
        this.nickName = user.getNickname();
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
        this.username = user.getAccount().getUsername();

    }

}
