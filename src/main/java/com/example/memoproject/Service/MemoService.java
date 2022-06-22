package com.example.memoproject.Service;

import com.example.memoproject.domain.Memo;
import com.example.memoproject.domain.MemoRepository;
import com.example.memoproject.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional //DB에 반영이 되어야 함을 알림
    public Long update(Long id, MemoRequestDto memoRequestDto){

        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id가 존재하지 않습니다.")
        );

        memo.update(memoRequestDto);

        return memo.getId();
    }
}
