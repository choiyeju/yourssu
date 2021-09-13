package com.example.yourssu2.service

import org.springframework.beans.factory.annotation.Autowired
import com.example.yourssu2.dao.MemoDao
import java.util.HashMap
import com.example.yourssu2.model.Memo
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.stereotype.Service

@Service
open class MemoService {
    @Autowired
    var memoDao: MemoDao? = null

    fun getAllMemos(): MappingJacksonValue {
        return memoDao!!.getAllMemos()
    }

    fun getMemoByDatePage(date: String?, page: Int?): MappingJacksonValue {
        return memoDao!!.getMemoByDatePage(date, page)
    }

    fun getMemoByMemoId(id: Int?): MappingJacksonValue {
        return memoDao!!.getMemoByMemoId(id)
    }

    fun registerMemo(memo: Memo): MappingJacksonValue {
        return memoDao!!.insertMemo(memo)
    }

    fun modifyMemo(id: Int?, memo: Memo): MappingJacksonValue {
        return memoDao!!.updateMemo(id, memo)
    }

    fun removeMemo(id: Int?) {
        memoDao!!.deleteMemo(id)
    }
}