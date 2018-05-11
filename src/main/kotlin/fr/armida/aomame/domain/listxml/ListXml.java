package fr.armida.aomame.domain.listxml;

import com.fasterxml.jackson.annotation.JsonView;
import fr.armida.aomame.domain.view.View;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

/**
 * Created by gregory on 13/01/2017.
 */
@Entity
public class ListXml {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_list_xml")
    @SequenceGenerator(name = "seq_list_xml", sequenceName = "seq_list_xml", allocationSize = 1)
    @JsonView(View.Summary.class)
    private Long id;

    @NotBlank
    @JsonView(View.Summary.class)
    private String name;

    @OneToOne(cascade = ALL)
    @PrimaryKeyJoinColumn
    private Mame mame;

    public ListXml() {
        super();
    }

    public ListXml(Mame mame) {
        this.mame = mame;
        mame.listXml = this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mame getMame() {
        return mame;
    }

    public void setMame(Mame mame) {
        this.mame = mame;
        mame.listXml = this;
    }
}
