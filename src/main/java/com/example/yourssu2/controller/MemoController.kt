package com.example.yourssu2.controller

import org.springframework.beans.factory.annotation.Autowired
import com.example.yourssu2.service.MemoService
import java.util.HashMap
import com.example.yourssu2.model.Memo
import com.fasterxml.jackson.databind.ser.FilterProvider
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("")
open class MemoController {
    @Autowired
    private val memoService: MemoService? = null

    @GetMapping("/GET/memos")
    fun getMemoByDatePage2(@RequestParam(required = false)date :String?, @RequestParam(required = false)page: Int?): MappingJacksonValue {
        if(date.equals(null))
            return memoService!!.getAllMemos()
        else
            return memoService!!.getMemoByDatePage(date, page)
            //return memoService!!.getMemoByDatePage()
    }

    @GetMapping("/GET/memos/{memoId}")
    fun getMemoByMemoId(@PathVariable memoId: Int?): MappingJacksonValue {
        return memoService!!.getMemoByMemoId(memoId)
    }

    @PostMapping("/POST/memos")
    fun registerUser(@RequestBody memo: Memo): MappingJacksonValue {
        return memoService!!.registerMemo(memo)
    }

    @PutMapping("/PUT/memos/{memoId}")
    fun modifyUser(@PathVariable memoId: Int?, @RequestBody memo: Memo): MappingJacksonValue {
        return memoService!!.modifyMemo(memoId, memo)
    }

    @DeleteMapping("/DELETE/memos/{memoId}")
    fun removeUser(@PathVariable memoId: Int?) {
        memoService!!.removeMemo(memoId)
    }
}