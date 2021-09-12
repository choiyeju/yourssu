package com.example.yourssu2.controller
/*
import com.example.yourssu2.service.MemoService.allMemos
import com.example.yourssu2.service.MemoService.getMemoByMemoId
import com.example.yourssu2.service.MemoService.registerMemo
import com.example.yourssu2.service.MemoService.modifyMemo
import com.example.yourssu2.service.MemoService.removeMemo

 */
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import com.example.yourssu2.service.MemoService
import org.springframework.web.bind.annotation.GetMapping
import java.util.HashMap
import org.springframework.web.bind.annotation.PathVariable
import com.example.yourssu2.model.Memo
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
@RequestMapping("/memos")
open class MemoController {
    @Autowired
    private val memoService: MemoService? = null

    @get:GetMapping("")
    val allMemos: HashMap<String, Any?>?
        get() = memoService!!.getAllMemos()

    @GetMapping("/{id}")
    fun getMemoByUMemoId(@PathVariable id: Int?): Memo {
        return memoService!!.getMemoByMemoId(id)
    }

    @PostMapping("")
    fun registerUser(@RequestBody memo: Memo): Memo {
        return memoService!!.registerMemo(memo)
    }

    @PutMapping("/{id}")
    fun modifyUser(@PathVariable id: Int?, @RequestBody memo: Memo) {
        memoService!!.modifyMemo(id, memo)
    }

    @DeleteMapping("/{id}")
    fun removeUser(@PathVariable id: Int?) {
        memoService!!.removeMemo(id)
    }
}