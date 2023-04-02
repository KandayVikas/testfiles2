package com.dailycodebuffer.user.VO;

import com.dailycodebuffer.user.entity.EndUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestTemplateVO {

    private EndUser user;

    private Department department;
}
