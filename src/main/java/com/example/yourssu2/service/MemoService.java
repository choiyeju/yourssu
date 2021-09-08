package com.example.yourssu2.service;

import com.example.yourssu2.dao.MemoDao;
import com.example.yourssu2.model.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MemoService {
    @Autowired
    MemoDao memoDao;

    public HashMap<String,Object> getAllMemos() {
        return memoDao.getAllMemos();
    }

    public Memo getMemoByMemoId(Long id) {
        return memoDao.getMemoByMemoId(id);
    }

    public Memo registerMemo(Memo memo) {
        return memoDao.insertMemo(memo);
    }

    public void modifyMemo(Long id, Memo memo) {
        memoDao.updateMemo(id, memo);
    }

    public void removeMemo(Long id) {
        memoDao.deleteMemo(id);
    }
}
