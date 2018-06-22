package fr.armida.aomame.domain.catver


import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType.ALL
import javax.validation.constraints.NotBlank

/**
 * @author gfouquet
 */
@Entity
class Cat (
    @field: [
    Id
    GeneratedValue(strategy = GenerationType.IDENTITY)
    ]
    var id: Long? = null,

    @field:NotBlank
    val name: String,

    // TODO gentes en private ?
    @field:OneToMany(mappedBy = "category", cascade = [ALL])
    val genres: MutableSet<Genre> = HashSet<Genre>()) {

    fun addGenre(genre: Genre) {
        genres.add(genre)
    }
}
