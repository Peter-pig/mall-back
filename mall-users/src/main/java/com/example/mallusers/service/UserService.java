package com.example.mallusers.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mallcommon.common.R;
import com.example.mallcommon.entity.TbUser;

public interface UserService extends IService<TbUser> {
    R signIn(TbUser tbUser);

    R register(TbUser tbUser);
}
