package com.demo.please.dto;

import com.demo.please.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long id;
    private String userEmail;
    private String userName;
    private String password;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setUserEmail(memberEntity.getUserEmail());
        memberDTO.setUserName(memberEntity.getUserName());
        memberDTO.setPassword(memberEntity.getPassword());

        return memberDTO;
    }
}
