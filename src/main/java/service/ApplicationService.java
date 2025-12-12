package service;

import com.cluplist.mapper.ApplicationMapper;
import com.cluplist.vo.ApplicationVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationMapper applicationMapper;

    public ApplicationService(ApplicationMapper applicationMapper) {
        this.applicationMapper = applicationMapper;
    }

    public List<ApplicationVO> listByRecruitId(int recruitId) {
        return applicationMapper.selectByRecruitId(recruitId);
    }

    public int apply(ApplicationVO vo, int loginUserId) {
        vo.setApplicantUserId(loginUserId);
        return applicationMapper.insert(vo);
    }
}
