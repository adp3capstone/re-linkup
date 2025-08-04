package za.ac.cput.linkup.controller;

/* PreferenceController.java
Author: SH Kgomokaboya (222152672)
Date: .
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.linkup.domain.Preference;
import za.ac.cput.linkup.service.PreferenceService;

@RestController
@RequestMapping("/Preference")
public class PreferenceController {
   private PreferenceService preferenceService;

   @Autowired
    public PreferenceController(PreferenceService preferenceService) {
       this.preferenceService = preferenceService;
   }
   @PostMapping("/create")
    public Preference createPreference(@RequestBody Preference preference) {
       return preferenceService.save(preference);
   }
   @GetMapping("/read/{preferredGender}")
   public Preference readBySmokingPreference(@PathVariable boolean smokingPreference) {
       return preferenceService.findBySmokingPreference(smokingPreference).orElse(null);
   }
    @PostMapping("/update")
    public Preference updatePreference(@RequestBody Preference preference) {
       return preferenceService.save(preference);
    }

}
