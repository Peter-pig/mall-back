package com.example.mallusers.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mallcommon.common.BcryptUtil;
import com.example.mallcommon.common.JwtUtils;
import com.example.mallcommon.common.R;
import com.example.mallcommon.entity.TbUser;
import com.example.mallusers.mapper.UserMapper;
import com.example.mallusers.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, TbUser> implements UserService {
    HashMap<String,Object> res=new HashMap<>();

    @Override
    public R signIn(TbUser tbUser) {
        LambdaQueryWrapper<TbUser> tbUserLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tbUserLambdaQueryWrapper.eq(TbUser::getUsername,tbUser.getUsername());
        TbUser one = getOne(tbUserLambdaQueryWrapper);
        boolean match = BcryptUtil.match(tbUser.getPassword(), one.getPassword());
        if (match){
            String token = JwtUtils.generateToken(tbUser.getName());
            res.put("token",token);
            return R.success(res);
        }else {
            return R.error(401,"密码或权限不足");
        }
    }

    @Override
    public R register(TbUser tbUser) {
        LambdaQueryWrapper<TbUser> tbUserLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tbUserLambdaQueryWrapper.eq(TbUser::getName,tbUser.getName());
        TbUser one = getOne(tbUserLambdaQueryWrapper);
        if (ObjectUtils.isNotNull(one)){
            String encrypt = BcryptUtil.encrypt(tbUser.getPassword());
            tbUser.setPassword(encrypt);
            save(tbUser);
            return R.success();
        }else {
            return R.error(500,"用户存在");
        }
    }
}
