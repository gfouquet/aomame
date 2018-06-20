package fr.armida.aomame.repository


import fr.armida.aomame.domain.listxml.ListXml
import org.springframework.data.repository.PagingAndSortingRepository

/**
 * @author gfouquet
 * @since 0.1.0
 */
interface ListXmlRepository : PagingAndSortingRepository<ListXml, String> {
    fun countByName(name: String): Int
}
