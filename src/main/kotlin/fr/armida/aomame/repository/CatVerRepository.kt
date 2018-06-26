package fr.armida.aomame.repository


import fr.armida.aomame.domain.catver.CatVer
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * @author gfouquet
 */
interface CatVerRepository : PagingAndSortingRepository<CatVer, Long> {
    fun countByName(name: String): Int
}
