package ch.hickmann.isobar.fm.bff.Controllers;

import ch.hickmann.isobar.fm.bff.domains.Band;
import ch.hickmann.isobar.fm.bff.domains.Order;
import ch.hickmann.isobar.fm.bff.services.IsobarfmService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"bands/v1"})
public class BandsController {

    private final IsobarfmService isobarfmService;

    public BandsController(IsobarfmService isobarfmService) {
        this.isobarfmService = isobarfmService;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"","/", "/order/{order}"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Band> allBands(@PathVariable(value = "order", required = false) Order order) {
        return isobarfmService.getBands(order);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Band> searchBand(@RequestParam(value="name") String bandName) {
        return isobarfmService.searchBand(bandName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{bandId}")
    @ResponseStatus(HttpStatus.OK)
    public Band band(@PathVariable(value = "bandId") String bandId) {
        return isobarfmService.getBand(bandId);
    }
}
