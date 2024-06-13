package rs.in.staleksit.template.goose.persistence.geo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Converter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.annotations.Type;
import rs.in.staleksit.template.goose.persistence.AbstractAuditingEntity;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "tbl_country")
public class JpaCountry extends AbstractAuditingEntity<Long> implements Serializable {

    @Serial
    private static final long serialVersionUID = -4398802976318185828L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Size(max = 256)
    @Column(name = "name", length = 256)
    private String name;

    @Getter
    @Size(max = 2)
    @Column(name = "alpha2", length = 2)
    private String alpha2;

    @Getter
    @Size(max = 3)
    @Column(name = "alpha3", length = 3)
    private String alpha3;

    @Getter
    @Column(name = "visible", columnDefinition = "TINYINT")
    private boolean visible;

    @Getter
    @Column(name = "deleted", columnDefinition = "TINYINT")
    private boolean deleted;

    @Override
    public Long getId() {
        return id;
    }

}
