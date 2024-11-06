package com.example.SARST.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "place")
class Place {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="name")
    var name: String? = null
    var location: String? = null
    var assignmentDate : LocalDate? = null
    var requiredSkill: String? = null
    @ManyToOne
    @JoinColumn(name = "worker_id")
    var worker: Worker? = null
}