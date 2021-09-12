package com.example.yourssu2.dao

import java.util.HashMap
import com.example.yourssu2.model.Memo
import com.fasterxml.jackson.annotation.JsonBackReference
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.ArrayList

@Repository
open class MemoDao {
    companion object {
        var memos: HashMap<String, Any?>? = null
            //get() = Companion.field
        @JsonBackReference
        var memolist: MutableList<Memo>? = null

        init {
            memos = HashMap()
            memolist = ArrayList()
            memos!!["memo"] = memolist
        }
    }

    fun getAllMemos(): HashMap<String, Any?>? {
        return memos
    }

    fun getMemoByMemoId(id: Int?): Memo {
        return memolist!!.stream()
            .filter { memo: Memo -> memo.id === id }
            .findAny()
            .orElse(Memo(null, null, null, null, null))
    }

    fun insertMemo(memo1: Memo): Memo {
        memo1.createdDate = LocalDateTime.now()
        memo1.modifiedDate = LocalDateTime.now()
        memolist!!.add(memo1)
        return memo1
    }

    fun updateMemo(id: Int?, memo1: Memo) {
        val m: Memo = memolist!!.stream()
            .filter { curMemo: Memo -> curMemo.id === id }
            .findAny()
            .orElse(Memo(null, null, null, null, null))
        m.title = memo1.title
        m.text = memo1.text
        m.modifiedDate = LocalDateTime.now()
    }

    fun deleteMemo(id: Int?) {
        memolist!!.removeIf { memo: Memo -> memo.id === id }
    }
}