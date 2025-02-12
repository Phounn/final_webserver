package web.group.two.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {
    @Column(name = "account_username")
    private String username;

    @Column(name = "account_password")
    private String password;

    public static Account create(final String username, final String password){
        return new Account(username, password);
    }
}
