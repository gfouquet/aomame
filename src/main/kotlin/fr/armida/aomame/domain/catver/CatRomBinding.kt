package fr.armida.aomame.domain.catver


import javax.persistence.*
import javax.persistence.CascadeType.MERGE
import javax.persistence.CascadeType.PERSIST
import javax.validation.constraints.NotBlank

/**
 * @author gfouquet
 */
@Entity
class CatRomBinding(
    @field:[
    Id
    GeneratedValue(strategy = GenerationType.IDENTITY)
    ]
    val id: Long? = null,

    @field:NotBlank
    val rom: String,

    val mature: Boolean = false,

    @field:[
    ManyToOne(cascade = [PERSIST, MERGE])
    JoinColumn
    ]
    val genre: Genre? = null
)
