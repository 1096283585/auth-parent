package com.wugeek.auth.service.service.impl.basic;

import com.wugeek.auth.api.model.po.*;
import com.wugeek.auth.api.model.vo.ModifyPassword;
import com.wugeek.auth.api.model.vo.UserVo;
import com.wugeek.auth.api.service.basic.UserService;
import com.wugeek.auth.service.dao.sub.SimpleTokenDao;
import com.wugeek.auth.service.dao.sub.SimpleUserAssociateRoleDao;
import com.wugeek.auth.service.dao.sub.SimpleUserCategoryDao;
import com.wugeek.auth.service.dao.sub.SimpleUserDao;
import com.wugeek.auth.service.dao.unit.RolePermissionUnit;
import com.wugeek.auth.service.dao.unit.UserRoleUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.web.service.model.vo.ServiceVo;
import pers.web.service.service.BasicCURDServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guoshixiong on 2017/6/20.
 * <p>
 * version: 1.0
 */
@Service
public class UserServiceImpl extends BasicCURDServiceImpl<UserPo, Integer> implements UserService {

    @Autowired
    SimpleUserDao simpleUserDao;
    @Autowired
    SimpleUserCategoryDao simpleUserCategoryDao;
    @Autowired
    SimpleUserAssociateRoleDao simpleUserAssociateRoleDao;
    @Autowired
    SimpleTokenDao simpleTokenDao;
    @Autowired
    UserRoleUnit userRoleUnit;
    @Autowired
    RolePermissionUnit rolePermissionUnit;

    public UserServiceImpl(@Autowired SimpleUserDao simpleUserDao) {
        setBasicCRUDDao(simpleUserDao);
    }

    @Override
    public ServiceVo create(UserPo record) {
        record.setPassword(record.getLoginName());

        return super.create(record);
    }

    @Override
    public ServiceVo retrieve(String token) {
        ServiceVo serviceVo = new ServiceVo();

        TokenPo tokenPo = simpleTokenDao.selectByToken(token);
        if (tokenPo == null) {
            serviceVo.setCode(1);
            serviceVo.setMessaga("无效的token");

            return serviceVo;
        }

        return retrieve(tokenPo.getUserId());
    }

    @Override
    public ServiceVo retrieve(Integer id) {
        ServiceVo serviceVo = new ServiceVo();

        try {
            UserPo userPo = simpleUserDao.selectByPrimaryKey(id);

            int categoryId = userPo.getUserCategoryId();
            UserCategoryPo userCategoryPo = simpleUserCategoryDao.selectByPrimaryKey(categoryId);

            UserVo userVo = buildUserVo(userPo, userCategoryPo);

            serviceVo.setResults(userVo);
        } catch (Exception e) {
        }

        return serviceVo;
    }

    @Override
    public ServiceVo retrieveAll() {
        ServiceVo serviceVo = new ServiceVo();

        List<UserPo> userPoList = simpleUserDao.selectAll();
        List<UserCategoryPo> userCategoryPoList = simpleUserCategoryDao.selectAll();

        List<UserVo> userVoList = buildListUserVo(userPoList, userCategoryPoList);

        serviceVo.setResults(userVoList);

        return serviceVo;
    }

    @Override
    public ServiceVo retrieveByPage(Integer page, Integer count) {
        ServiceVo serviceVo = new ServiceVo();

        int offset = (page - 1) * count;
        List<UserPo> userPoList = simpleUserDao.selectByPage(offset, count);
        List<UserCategoryPo> userCategoryPoList = simpleUserCategoryDao.selectAll();

        List<UserVo> userVoList = buildListUserVo(userPoList, userCategoryPoList);

        serviceVo.setResults(userVoList);

        return serviceVo;

    }

    private List<UserVo> buildListUserVo(List<UserPo> userPoList, List<UserCategoryPo> userCategoryPoList) {
        List<UserVo> userVoList = new ArrayList<>();

        for (UserPo userPo : userPoList) {
            Integer userCategoryId = userPo.getUserCategoryId();

            UserVo userVo;
            UserCategoryPo categoryPo = null;
            for (UserCategoryPo userCategoryPo : userCategoryPoList) {
                if (userCategoryId == userCategoryPo.getUserCategoryId()) {
                    categoryPo = userCategoryPo;

                    break;
                }
            }

            userVo = buildUserVo(userPo, categoryPo);

            userVoList.add(userVo);
        }

        return userVoList;
    }

    private UserVo buildUserVo(UserPo userPo, UserCategoryPo userCategoryPo) {
        UserVo userVo = new UserVo();
        userVo.setUserId(userPo.getUserId());
        if (userCategoryPo != null) {
            userVo.setUserCategory(userCategoryPo.getUserCategory());
        }
        userVo.setLoginName(userPo.getLoginName());
        userVo.setPassword(userPo.getPassword());
        userVo.setUserCode(userPo.getUserCode());

        return userVo;
    }

    @Override
    public ServiceVo retrieveRole(Integer id) {
        ServiceVo serviceVo = new ServiceVo();

        List<RolePo> list = userRoleUnit.selectByUserId(id);

        serviceVo.setResults(list);

        return serviceVo;
    }

    @Override
    public ServiceVo retrievePermission(String token) {
        ServiceVo serviceVo = new ServiceVo();

        TokenPo tokenPo = simpleTokenDao.selectByToken(token);
        if (tokenPo == null) {
            serviceVo.setCode(1);
            serviceVo.setMessaga("无效的token");

            return serviceVo;
        }

        int id = tokenPo.getUserId();
        List<RolePo> roles = userRoleUnit.selectByUserId(id);

        List<PermissionPo> result = new ArrayList<>();
        for (RolePo role : roles) {
            List<PermissionPo> permissions = rolePermissionUnit.retrievePermissionByRoleId(role.getRoleId());

            result.addAll(permissions);
        }

        serviceVo.setResults(result);

        return serviceVo;
    }

    @Override
    public ServiceVo retrieveByLoginName(String loginName) {
        ServiceVo serviceVo = new ServiceVo();

        UserPo userPo = simpleUserDao.selectUserByLoginName(loginName);

        serviceVo.setResults(userPo);

        return serviceVo;
    }

    @Override
    public ServiceVo modifyPassword(ModifyPassword modifyPassword) {
        String loginName = modifyPassword.getLoginName();
        String oldPassword = modifyPassword.getOldPassword();
        String newPassword = modifyPassword.getNewPassword();

        ServiceVo serviceVo = new ServiceVo();
        UserPo userPo = simpleUserDao.selectUserByLoginName(loginName);
        if (userPo == null) {
            serviceVo.setCode(1);
            serviceVo.setMessaga("用户不存在");

            return serviceVo;
        }
        String realPassword = userPo.getPassword();
        if (realPassword.equals(oldPassword)) {
            userPo.setPassword(newPassword);
            simpleUserDao.updateByPrimaryKeySelective(userPo);
        } else {
            serviceVo.setCode(1);
            serviceVo.setMessaga("密码错误");
        }

        return serviceVo;
    }

    @Override
    public ServiceVo delete(Integer id) {
        simpleTokenDao.deleteByUserId(id);
        simpleUserAssociateRoleDao.deleteByUserId(id);
        return super.delete(id);
    }
}
