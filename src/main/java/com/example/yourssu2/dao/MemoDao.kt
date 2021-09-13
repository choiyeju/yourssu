package com.example.yourssu2.dao

import com.example.yourssu2.model.Memo
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ser.FilterProvider
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Repository
open class MemoDao {

    companion object {
        var memos: HashMap<String, Any?>? = null
        var memos3: HashMap<String, Any?>? = null
        var memo: Memo? = null

        @JsonBackReference
        var memolist: MutableList<Memo>? = null

        init {
            memos = HashMap()
            memos3 = HashMap()
            memolist = ArrayList()
            memos3!!["memolist"] = memolist
        }
    }

    fun getAllMemos(): MappingJacksonValue {
        var filter: SimpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "title", "text", "createdAt", "updatedAt")
        val filters: FilterProvider = SimpleFilterProvider().addFilter("MemoFilter", filter)
        val mapping = MappingJacksonValue(memos3)
        mapping.filters = filters

        return mapping
    }

    fun getMemoByDatePage(date: String?, page: Int?): MappingJacksonValue {
        var filter: SimpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "title", "createdAt", "updatedAt")
        val filters: FilterProvider = SimpleFilterProvider().addFilter("MemoFilter", filter)

        var memos2: HashMap<String, Any?>? = null
        var memolist2: MutableList<Memo>? = null
        var memolist3: MutableList<Memo>? = null
        memos2 = HashMap()
        memolist2 = ArrayList()
        memolist3 = ArrayList()

        for(i in 0..memolist!!.size-1)
            if (date!!.equals(memolist!![i].createdAt!!.substring(0, 10)))
                memolist2!!.add(memolist!![i])

        memolist2!!.reverse()
        if(page != null) {
            val A:Int = (page -1)*5+1
            if (memolist2!!.size >= A) {
                for(i in A-1..memolist2!!.size-1){
                    if(i >= page*5) break
                    memolist3!!.add(memolist2!![i])
                }
            }
        }
        memos2!!["memos"] = memolist3!!
        val mapping = MappingJacksonValue(memos2)
        mapping.filters = filters

        return mapping
    }

    fun getMemoByMemoId(id: Int?): MappingJacksonValue {
        var filter: SimpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "title", "text", "createdAt", "updatedAt")
        val filters: FilterProvider = SimpleFilterProvider().addFilter("MemoFilter", filter)

        var m:Memo = memolist!!.stream()
            .filter { memo: Memo -> memo.id === id }
            .findAny()
            .orElse(Memo(0, null, null, null, null))
        memo = m
        memos!!["memo"] = memo
        val mapping = MappingJacksonValue(m)
        mapping.filters = filters

        return mapping
    }

    fun insertMemo(memo1: Memo): MappingJacksonValue {
        var filter: SimpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "title", "text", "createdAt", "updatedAt")
        val filters: FilterProvider = SimpleFilterProvider().addFilter("MemoFilter", filter)

        var T: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        memo1.createdAt = T
        memo1.updatedAt = T
        memolist!!.add(memo1)

        memo = memo1
        memos!!["memo"] = memo
        val mapping = MappingJacksonValue(memo1)
        mapping.filters = filters

        return mapping
    }

    fun updateMemo(id: Int?, memo1: Memo): MappingJacksonValue {
        var filter: SimpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "title", "createdAt", "updatedAt")
        val filters: FilterProvider = SimpleFilterProvider().addFilter("MemoFilter", filter)

        var T: String = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        val m: Memo = memolist!!.stream()
            .filter { curMemo: Memo -> curMemo.id === id }
            .findAny()
            .orElse(Memo(0, null, null, null, null))

        m.title = memo1.title
        m.text = memo1.text
        m.updatedAt = T

        memo = m
        memos!!["memo"] = memo
        val mapping = MappingJacksonValue(m)
        mapping.filters = filters

        return mapping
    }

    fun deleteMemo(id: Int?) {
        memolist!!.removeIf { memo: Memo -> memo.id === id }
    }
}