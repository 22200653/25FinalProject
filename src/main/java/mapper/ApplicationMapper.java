package mapper;

import com.cluplist.vo.ApplicationVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicationMapper {
    List<ApplicationVO> selectByRecruitId(@Param("recruitId") int recruitId);
    int insert(ApplicationVO vo);
}
