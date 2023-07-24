package com.example.Reto2Web.Controllers;

import com.example.Reto2Web.Model.Gadget;
import com.example.Reto2Web.Services.GadgetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*",methods ={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api/gadget")
public class GadgetController {
    @Autowired
    private GadgetServices gadgetServices;

    @GetMapping("/all")
    public List<Gadget> getAllGadgets(){
        return gadgetServices.getAllGadgets();
    }

    @GetMapping("/category/{category}")
    public List<Gadget> getGadgetsByCategory(@PathVariable("category") String category){
        return gadgetServices.getGadgetsByCategory(category);
    }

    @GetMapping("/name/{name}")
    public List<Gadget> getGadgetsByName(@PathVariable("name") String name){
        return gadgetServices.getGadgetsByName(name);
    }

    @GetMapping("/description/{keyword}")
    public List<Gadget> getGadgetsByDescription(@PathVariable("keyword") String keyword){
        return gadgetServices.getGadgetsByDescription(keyword);
    }

    @GetMapping("/price/{maxPrice}")
    public List<Gadget> getGadgetsByMaxPrice(@PathVariable("maxPrice") Double maxPrice){
        return gadgetServices.getGadgetsByMaxPrice(maxPrice);
    }

    @GetMapping("/price/{minPrice}/{maxPrice}")
    public List<Gadget> getGadgetsByPriceRange(@PathVariable("minPrice") Double minPrice, @PathVariable("maxPrice") Double maxPrice){
        return gadgetServices.getGadgetsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/availability/{availability}")
    public List<Gadget> getGadgetsByAvailability(@PathVariable("availability") Boolean availability){
        return gadgetServices.getGadgetsByAvailability(availability);
    }

    @GetMapping("/{gadgetId}")
    public Optional<Gadget> getGadgetById(@PathVariable("gadgetId") Integer gadgetId){
        return gadgetServices.getGadgetById(gadgetId);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget insertGadget(@RequestBody Gadget gadget){
        return gadgetServices.insertGadget(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gadget updateGadget(@RequestBody Gadget gadget){
        return gadgetServices.updateGadget(gadget);
    }

    @DeleteMapping("/{gadgetId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGadget(@PathVariable("gadgetId") Integer gadgetId){
        gadgetServices.deleteGadget(gadgetId);
    }

}
