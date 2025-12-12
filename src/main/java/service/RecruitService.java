package service;

import com.cluplist.mapper.RecruitMapper;
import com.cluplist.vo.RecruitVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitService {
    private final RecruitMapper recruitMapper;

    public RecruitService(RecruitMapper recruitMapper) {
        this.recruitMapper = recruitMapper;
    }

    public List<RecruitVO> getAll(String category) {
        return recruitMapper.selectAll(category);
    }

    public RecruitVO getById(int id) {
        return recruitMapper.selectById(id);
    }

    public int add(RecruitVO vo, int loginUserId) {
        vo.setWriterUserId(loginUserId);
        return recruitMapper.insert(vo);
    }

    public int update(RecruitVO vo, int loginUserId) {
        RecruitVO db = recruitMapper.selectById(vo.getId());
        if (db == null) throw new RuntimeException("존재하지 않는 모집글");
        if (db.getWriterUserId() != loginUserId) throw new RuntimeException("수정 권한 없음");
        return recruitMapper.update(vo);
    }

    public int delete(int id, int loginUserId) {
        RecruitVO db = recruitMapper.selectById(id);
        if (db == null) throw new RuntimeException("존재하지 않는 모집글");
        if (db.getWriterUserId() != loginUserId) throw new RuntimeException("삭제 권한 없음");
        return recruitMapper.delete(id);
    }
}
