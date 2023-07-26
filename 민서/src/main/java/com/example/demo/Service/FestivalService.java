//package com.example.demo.Service;
//
//import com.example.demo.domain.Festival;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import com.example.demo.repository.FestivalRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class FestivalService {
//    private final FestivalRepository festivalRepository;
//
//    @Transactional
//    public void saveFestival(Festival festival) {
//        festivalRepository.save(festival);
//    }
//
//    public List<Festival> findFestival() { //아래 getFestivals랑 동일해서 필요 없을 듯
//        return festivalRepository.findAll();
//    }
//
//    public Optional<Festival> findOne(Long festivalId) {
//        return festivalRepository.findOne(festivalId);
//    }
//
//    public List<Festival> getFestivals() {
//        return festivalRepository.findAll();
//    }
//
//
//}
