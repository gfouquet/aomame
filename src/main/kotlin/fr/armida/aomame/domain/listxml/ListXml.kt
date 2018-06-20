package fr.armida.aomame.domain.listxml

import com.fasterxml.jackson.annotation.JsonView
import fr.armida.aomame.domain.view.View
import javax.persistence.*
import javax.persistence.CascadeType.ALL
import javax.validation.constraints.NotBlank

/**
 * Created by gregory on 13/01/2017.
 */
@Entity
class ListXml(
    @field: [
    Id
    GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_list_xml")
    SequenceGenerator(name = "seq_list_xml", sequenceName = "seq_list_xml", allocationSize = 1)
    JsonView(View.Summary::class)
    ]
    val id: Long? = null

) {
    @field: [
    NotBlank
    JsonView(View.Summary::class)
    ]
    lateinit var name: String

    @field: [
    OneToOne(cascade = [ALL])
    PrimaryKeyJoinColumn
    ]
    lateinit var mame: Mame

    constructor() : this(null)

    constructor(mame: Mame) : this() {
        this.mame = mame
        mame.listXml = this
    }

}
