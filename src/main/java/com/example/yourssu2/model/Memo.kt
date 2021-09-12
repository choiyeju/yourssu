package com.example.yourssu2.model

import lombok.Getter
import lombok.Setter
import org.springframework.context.annotation.Bean
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class Memo(

    //@JsonManagedReference
    var id: Int?,
    var title: String?,
    var text: String?,
    var createdDate: LocalDateTime?,
    var modifiedDate: LocalDateTime?

)
{
    /*
    private var id: Int? = 0
    private var title: String? = null
    private var text: String? = null

    @CreatedDate
    @Column(updatable = false)
    private var createdDate: LocalDateTime? = null

    @LastModifiedDate
    private var modifiedDate: LocalDateTime? = null



    constructor() {
    }


    constructor(id: Int?, title: String?, text: String?) {
        this.id = id;
        this.title = title;
        this.text = text;
        createdDate = LocalDateTime.now();
        modifiedDate = LocalDateTime.now();
    }


     */

}