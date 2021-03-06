package com.wiltech.health.check.servers;

import lombok.*;
import org.springframework.hateoas.Link;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
