package ch.hickmann.isobar.fm.bff.components;

import ch.hickmann.isobar.fm.bff.domains.Band;
import ch.hickmann.isobar.fm.bff.domains.clients.IsobarfmClient;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@CacheConfig(cacheNames={"IsobarfmClientController"})
@Transactional(readOnly=true)
public class IsobarfmClientController {

    private final IsobarfmClient isobarfmClient;

    public IsobarfmClientController(IsobarfmClient isobarfmClient) {
        this.isobarfmClient = isobarfmClient;
    }

    @Cacheable("getBandsFromClient")
    public List<Band> getBandsFromClient() {
        return isobarfmClient.getBands();
    }

    @CacheEvict(value = "getBandsFromClient", allEntries = true)
    @Scheduled(fixedRate = 60000)
    public void evictAllcachesAtIntervals() {
    }
}
