package fr.armida.aomame.domain.catver


import javax.persistence.*
import javax.persistence.CascadeType.MERGE
import javax.persistence.CascadeType.PERSIST
import javax.validation.constraints.NotBlank

/**
 * @author gfouquet
 */
@Entity
class Genre(
    @field: [
    Id
    GeneratedValue(strategy = GenerationType.IDENTITY)
    ]
    val id: Long? = null,

    @field:NotBlank
    val name: String,

    @field: [
    ManyToOne(cascade = [PERSIST, MERGE])
    JoinTable(name = "cat_genre", joinColumns = [JoinColumn(name = "genre_id")])
    ]
    val category: Cat
) {
    init {
        category.addGenre(this)
    }
}
