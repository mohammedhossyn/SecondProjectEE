package com.secondprojectee.model.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Admin extends Base {
    private String firstName;
    private String lastName;

    public Admin(long id, String firstName, String lastName,boolean status) {
        this.setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.setStatus(true);

    }
}
