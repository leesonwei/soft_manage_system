package com.delta.soft_manage_system.utils;

import com.delta.auth.dto.TweiAuth;
import com.delta.common.code.AuthrizeCode;
import com.delta.common.constant.GlobalConst;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname AuthsUtil
 * @Date 2019/4/12 17:43
 * @Author LIZONG.WEI
 * @Since 1.8
 */
public class AuthsUtil {
    public static Map<String,Integer> getAuthValue(List<TweiAuth> auths){
        Map<String,Integer> authValues = new HashMap<>();
        List<TweiAuth> result = null;
        result = auths.stream().filter(auth -> auth.getAuthType() == 2).collect(Collectors.toList());
        Set parent = new HashSet();
        for (TweiAuth auth:result) {
            parent.add(auth.getAuthParentId());
        }
        for (TweiAuth auth : auths) {
            if (parent.contains(auth.getAuthId())) {
                result = auths.stream().filter(button -> button.getAuthParentId() != null && button.getAuthParentId().equals(auth.getAuthId())).collect(Collectors.toList());
                int value = 0;
                for (TweiAuth buttonVlue:result) {
                    if (buttonVlue.getAuthUrl().contains(GlobalConst.INSERT)) {
                        value += AuthrizeCode.INSERT.getCode();
                    }
                    if (buttonVlue.getAuthUrl().contains(GlobalConst.UPDATE)) {
                        value += AuthrizeCode.UPDATE.getCode();
                    }
                    if (buttonVlue.getAuthUrl().contains(GlobalConst.DELETE)) {
                        value += AuthrizeCode.DELETE.getCode();
                    }
                    if (buttonVlue.getAuthUrl().contains(GlobalConst.SELECT)) {
                        value += AuthrizeCode.SELECT.getCode();
                    }
                    if (buttonVlue.getAuthUrl().contains(GlobalConst.SETAUTHS)) {
                        value += AuthrizeCode.SETAUTHS.getCode();
                    }
                    if (buttonVlue.getAuthUrl().contains(GlobalConst.SETROLES)) {
                        value += AuthrizeCode.SETROLES.getCode();
                    }
                    if (buttonVlue.getAuthUrl().contains(GlobalConst.CHECK)) {
                        value += AuthrizeCode.CHECK.getCode();
                    }
                }
                authValues.put(auth.getAuthId(),value);
            }
        }
        return authValues;
    }
}
