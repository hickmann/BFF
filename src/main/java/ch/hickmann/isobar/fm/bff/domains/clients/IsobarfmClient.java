package ch.hickmann.isobar.fm.bff.domains.clients;

import ch.hickmann.isobar.fm.bff.domains.Band;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "isobarfm", url = "${isobarUrl}")
public interface  IsobarfmClient {

    @RequestMapping(method = RequestMethod.GET, value = "/", consumes = "application/json")
    List<Band> getBands();

}
