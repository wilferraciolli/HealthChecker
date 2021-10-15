package com.wiltech.health.check.servers;

import lombok.*;
import org.springframework.hateoas.Link;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * The type Server description.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServerDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    private String deployment;

    @Transient
    private Boolean primaryDeployment;

    private Integer currentStatus;

    @Transient
    private List<Link> customLinks;

    /**
     * Add link.
     *
     * @param link the link
     */
    public void addLink(Link link) {
        if (Objects.isNull(this.customLinks)) {
            customLinks = new ArrayList<>();
        }
        customLinks.add(link);

    }
}
