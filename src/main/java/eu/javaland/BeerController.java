package eu.javaland;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/beer")
public class BeerController {
    @Autowired
    private BeerRepository beerRepository;

    @GetMapping
    public List<Beer> listBeers() {
        List<Beer> beerList = new ArrayList<>();

        beerRepository.findAll().forEach(beerList::add);
        return beerList;
    }

    @PutMapping
    public void addBeer(@RequestBody Beer beer) {
        beerRepository.save(beer);
    }

    @DeleteMapping
    public void deleteBeer(@RequestParam Long beerId) {
        beerRepository.delete(beerId);
    }

    @PostMapping
    public void updateBeer(@RequestBody Beer beer) {
        beerRepository.save(beer);
    }
}
