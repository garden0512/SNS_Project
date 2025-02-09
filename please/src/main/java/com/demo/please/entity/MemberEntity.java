package com.demo.please.entity;

import com.demo.please.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userEmail;

    @Column
    private String password;

    @Column
    private String userName;

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setUserEmail(memberDTO.getUserEmail());
        memberEntity.setUserName(memberDTO.getUserName());
        memberEntity.setPassword(memberDTO.getPassword());
        return memberEntity;
    }
}
