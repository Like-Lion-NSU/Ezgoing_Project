package easyGoing.festival.service;

import easyGoing.festival.domain.Festival;
import easyGoing.festival.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FestivalService {
    private final FestivalRepository festivalRepository;

    @Transactional
    public void saveFestival(Festival festival) {
        festivalRepository.save(festival);
    }

    public List<Festival> findFestival() { //아래 getFestivals랑 동일해서 필요 없을 듯
        return festivalRepository.findAll();
    }

    public Festival findOne(Long festivalId) {
        return festivalRepository.findOne(festivalId);
    }

    public List<Festival> getFestivals() {
        return festivalRepository.findAll();
    }

}
