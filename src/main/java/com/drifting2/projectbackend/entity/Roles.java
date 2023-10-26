package com.drifting2.projectbackend.entity;

import com.drifting2.projectbackend.security.user.User;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String type;
    @OneToOne
    User user;

}
