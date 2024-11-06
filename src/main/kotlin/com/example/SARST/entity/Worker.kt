package com.example.SARST.entity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "worker")
class Worker {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column (name="name")
    var name: String? = null   //description_one en la base de datos
    var workstation: String? = null
    var lastAssignment : LocalDate? = null
    var skill : String? = null
    @OneToMany(mappedBy = "worker", cascade = [CascadeType.ALL])
    val place: List<Place> = listOf()
}