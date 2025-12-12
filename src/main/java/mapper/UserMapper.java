package mapper;

import com.cluplist.vo.UserVO;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    UserVO selectByUserid(@Param("userid") String userid);
}
