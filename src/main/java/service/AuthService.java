package service;

import com.cluplist.mapper.UserMapper;
import com.cluplist.vo.UserVO;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserMapper userMapper;

    public AuthService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserVO login(String userid, String password) {
        if (userid == null || password == null) return null;
        UserVO user = userMapper.selectByUserid(userid);
        if (user == null) return null;

        // 과제/프로젝트 기본: 평문 비교 (시간 있으면 해시로 개선)
        if (password.equals(user.getPassword())) return user;

        return null;
    }
}
