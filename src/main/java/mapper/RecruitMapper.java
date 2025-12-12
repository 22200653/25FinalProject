package mapper;

import com.cluplist.vo.RecruitVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecruitMapper {
    List<RecruitVO> selectAll(@Param("category") String category);
    RecruitVO selectById(@Param("id") int id);

    int insert(RecruitVO vo);
    int update(RecruitVO vo);
    int delete(@Param("id") int id);
}
