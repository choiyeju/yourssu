package com.example.yourssu2.model

import com.fasterxml.jackson.annotation.JsonFilter
import lombok.Getter
import lombok.Setter
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*


@Getter
@Setter
@MappedSuperclass
@JsonFilter("MemoFilter")
@EntityListeners(AuditingEntityListener::class)
open class Memo(
    @Id
    @GeneratedValue
    var id: Int,
    var title: String?,
    var text: String?,
    var createdAt: String?,
    var updatedAt: String?
)