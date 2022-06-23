package com.example.memoproject.controller;

import com.example.memoproject.Service.MemoService;
import com.example.memoproject.domain.Memo;
import com.example.memoproject.domain.MemoRepository;
import com.example.memoproject.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto memoRequestDto){

        Memo memo = new Memo(memoRequestDto);

        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> readMemo(){

        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){

        memoRepository.deleteById(id);

        return id;
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto memoRequestDto){

        memoService.update(id, memoRequestDto);

        return id;
    }
}
