package fr.armida.aomame.domain.catver


import com.fasterxml.jackson.annotation.JsonView
import fr.armida.aomame.domain.view.View
import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType.ALL
import javax.validation.constraints.NotBlank

/**
 * @author gfouquet
 */
@Entity
class CatVer(
    @field:[
    Id
    GeneratedValue(strategy = GenerationType.IDENTITY)
    JsonView(View.Summary::class)
    ]
    val id: Long? = null,

    @field:[
    NotBlank
    JsonView(View.Summary::class)
    ]
    val name: String,

    @field:[
    OneToMany(cascade = [ALL])
    JoinTable(name = "cat_ver_cat", inverseJoinColumns = [(JoinColumn(name = "cat_id"))])
    ]
    val categories: Set<Cat> = HashSet(),

    @field:[
    OneToMany(cascade = [ALL])
    JoinTable(name = "cat_ver_cat_rom_binding", inverseJoinColumns = [JoinColumn(name = "binding_id")])
    ]
    var bindings: Set<CatRomBinding> = HashSet()
)
