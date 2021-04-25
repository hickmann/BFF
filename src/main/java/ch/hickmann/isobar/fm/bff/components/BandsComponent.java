package ch.hickmann.isobar.fm.bff.components;

import ch.hickmann.isobar.fm.bff.domains.Band;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.stream.Collectors;

@Component
public class BandsComponent {

    private final IsobarfmClientController isobarfmClientController;
    private static final Logger logger = LoggerFactory.getLogger(BandsComponent.class);

    public BandsComponent(IsobarfmClientController isobarfmClientController) {
        this.isobarfmClientController = isobarfmClientController;
    }

    public Band getBand(String bandId) {
        return isobarfmClientController.getBandsFromClient().stream()
                .filter(band -> band.getId().equalsIgnoreCase(bandId))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "entity not found"
                ));
    }

    public Iterable<Band> getBandListByName() {
        return isobarfmClientController.getBandsFromClient().stream()
                .sorted(Comparator.comparing(Band::getName))
                .map(band -> Band.builder()
                        .id(band.getId())
                        .name(band.getName())
                        .numPlays(band.getNumPlays())
                        .image(band.getImage())
                        .build())
                .collect(Collectors.toList());
    }

    public Iterable<Band> getBandListByPopularity() {
        return isobarfmClientController.getBandsFromClient().stream()
                .sorted(Comparator.comparing(Band::getNumPlays).reversed())
                .map(band -> Band.builder()
                        .id(band.getId())
                        .name(band.getName())
                        .numPlays(band.getNumPlays())
                        .build())
                .collect(Collectors.toList());
    }
}
