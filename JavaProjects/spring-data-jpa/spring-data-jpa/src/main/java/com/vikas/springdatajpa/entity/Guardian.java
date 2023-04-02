package com.vikas.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
//@AttributeOverrides({
//        @AttributeOverride(
//                name = "name",
//                column = @Column(name="guardian_name")
//        ),
//        @AttributeOverride(
//                name = "email",
//                column = @Column(name="guardian_email")
//        ),
//        @AttributeOverride(
//                name = "mobile",
//                column = @Column(name="guardian_mobile")
//        )
//}
//)
public class Guardian {
    @Column(name = "guardian_name")
    private String name;
    @Column(name="guardian_email")
    private String  email;
    @Column(name="guardian_mobile")
    private String mobile;
}
