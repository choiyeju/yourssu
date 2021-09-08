package com.example.yourssu2.dao;

import com.example.yourssu2.model.Memo;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MemoDao {
    public static HashMap<String,Object> memos;
    public static List<Memo> memolist;

    static {
        memos = new HashMap<String,Object>();
        memolist = new ArrayList<Memo>();
        /*memo.add(new Memo(1,"testName1", "1234"));
        memo.add(new Memo(2,"testName2", "1234"));
        memo.add(new Memo(3,"testName3", "1234"));
        memo.add(new Memo(4,"testName4", "1234"));
        memo.add(new Memo(5,"testName5", "1234"));*/
        memos.put("memo", memolist);
    }

    public HashMap<String,Object> getAllMemos() {
        return memos;
    }

    public Memo getMemoByMemoId(Long id) {
        return memolist
                .stream()
                .filter(memo -> memo.getId() == (id))
                .findAny()
                .orElse(new Memo());
    }

    public Memo insertMemo(Memo memo1) {
        memo1.setCreatedDate(LocalDateTime.now());
        memo1.setModifiedDate(LocalDateTime.now());
        memolist.add(memo1);
        return memo1;
    }

    public void updateMemo(Long id, Memo memo1) {
        Memo m = memolist.stream()
                .filter(curMemo -> curMemo.getId() == (id))
                .findAny()
                .orElse(new Memo());
            m.setTitle(memo1.getTitle());
            m.setText(memo1.getText());
            m.setModifiedDate(LocalDateTime.now());
    }

    public void deleteMemo(Long id) {
        memolist.removeIf(memo -> memo.getId() == (id));
    }
}
