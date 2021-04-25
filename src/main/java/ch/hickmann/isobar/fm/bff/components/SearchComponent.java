package ch.hickmann.isobar.fm.bff.components;

import ch.hickmann.isobar.fm.bff.domains.Band;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SearchComponent {

    private final IsobarfmClientController isobarfmClientController;
    private static final Logger logger = LoggerFactory.getLogger(SearchComponent.class);

    public SearchComponent(IsobarfmClientController isobarfmClientController) {
        this.isobarfmClientController = isobarfmClientController;
    }

    public Iterable<Band> searchBandsByName(String bandName) {
        return isobarfmClientController.getBandsFromClient().stream()
                .filter(p-> p.getName().contains((bandName)))
                .map(band -> Band.builder()
                        .id(band.getId())
                        .name(band.getName())
                        .numPlays(band.getNumPlays())
                        .image(band.getImage())
                        .build())
                .collect(Collectors.toList());
    }
}
