package com.example.SARST.repository

import com.example.SARST.entity.Place
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaceRepository : JpaRepository<Place, Long> {

}
