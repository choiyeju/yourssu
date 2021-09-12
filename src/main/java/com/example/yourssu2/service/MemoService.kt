package com.example.yourssu2.service

import org.springframework.beans.factory.annotation.Autowired
import com.example.yourssu2.dao.MemoDao
import java.util.HashMap
import com.example.yourssu2.model.Memo
import org.springframework.stereotype.Service

@Service
open class MemoService {
    @Autowired
    var memoDao: MemoDao? = null

    fun getAllMemos(): HashMap<String, Any?>? {
        return memoDao!!.getAllMemos()
    }
        //get() = memoDao!!.memos

    fun getMemoByMemoId(id: Int?): Memo {
        return memoDao!!.getMemoByMemoId(id)
    }

    fun registerMemo(memo: Memo): Memo {
        return memoDao!!.insertMemo(memo)
    }

    fun modifyMemo(id: Int?, memo: Memo) {
        memoDao!!.updateMemo(id, memo)
    }

    fun removeMemo(id: Int?) {
        memoDao!!.deleteMemo(id)
    }
}