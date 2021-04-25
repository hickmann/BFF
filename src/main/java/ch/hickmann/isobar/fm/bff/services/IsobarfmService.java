package ch.hickmann.isobar.fm.bff.services;

import ch.hickmann.isobar.fm.bff.components.BandsComponent;
import ch.hickmann.isobar.fm.bff.components.SearchComponent;
import ch.hickmann.isobar.fm.bff.domains.Band;
import ch.hickmann.isobar.fm.bff.domains.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IsobarfmService {

    private final BandsComponent bandsComponent;
    private final SearchComponent searchComponent;
    private static final Logger logger = LoggerFactory.getLogger(IsobarfmService.class);

    public IsobarfmService(BandsComponent bandsComponent, SearchComponent searchComponent) {
        this.bandsComponent = bandsComponent;
        this.searchComponent = searchComponent;
    }

    public Band getBand(String bandId) {
        logger.info("Band request received (id:{})",bandId);
        return bandsComponent.getBand(bandId);
    }

    public Iterable<Band> getBands(Order order) {
        logger.info("Band List request received (order:{})",order);

        switch ((order != null) ? order : Order.ALPHABETICAL) {
            case POPULARITY:
                return bandsComponent.getBandListByPopularity();
            case ALPHABETICAL:
            default:
                return bandsComponent.getBandListByName();

        }

    }

    public Iterable<Band> searchBand(String bandName) {
        logger.info("Search Bands request received (name:{})",bandName);
        return searchComponent.searchBandsByName(bandName);
    }
}
