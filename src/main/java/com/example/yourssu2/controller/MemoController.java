package com.example.yourssu2.controller;

import com.example.yourssu2.model.Memo;
import com.example.yourssu2.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/memos")
public class MemoController {
    @Autowired
    private MemoService memoService;

    @GetMapping("")
    public HashMap<String,Object> getAllMemos() {
        return memoService.getAllMemos();
    }

    @GetMapping("/{id}")
    public Memo getMemoByUMemoId(@PathVariable  Long id) {
        return memoService.getMemoByMemoId(id);
    }

    @PostMapping("")
    public Memo registerUser(@RequestBody Memo memo) {
        return memoService.registerMemo(memo);
    }

    @PutMapping("/{id}")
    public void modifyUser(@PathVariable Long id, @RequestBody Memo memo) {
        memoService.modifyMemo(id, memo);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable Long id) {
        memoService.removeMemo(id);
    }
}
