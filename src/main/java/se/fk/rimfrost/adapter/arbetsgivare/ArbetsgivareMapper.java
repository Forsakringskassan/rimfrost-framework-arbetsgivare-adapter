package se.fk.rimfrost.adapter.arbetsgivare;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.adapter.arbetsgivare.dto.ArbetsgivareResponse;
import se.fk.rimfrost.adapter.arbetsgivare.dto.ImmutableArbetsgivareResponse;
import se.fk.rimfrost.adapter.arbetsgivare.dto.SpecificeradLonResponse;
import se.fk.rimfrost.adapter.arbetsgivare.dto.ImmutableSpecificeradLonResponse;
import se.fk.rimfrost.adapter.arbetsgivare.dto.LoneradDto;
import se.fk.rimfrost.adapter.arbetsgivare.dto.ImmutableLoneradDto;
import se.fk.rimfrost.api.arbetsgivare.jaxrsspec.controllers.generatedsource.model.Anstallning;
import se.fk.rimfrost.api.arbetsgivare.jaxrsspec.controllers.generatedsource.model.GetArbetsgivare200Response;
import se.fk.rimfrost.api.arbetsgivare.jaxrsspec.controllers.generatedsource.model.SpecificeradLon;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ArbetsgivareMapper
{

   public ArbetsgivareResponse toArbetsgivareResponse(GetArbetsgivare200Response apiResponse)
   {
      if (apiResponse.getAnstallningar().isEmpty())
      {
         return null;
      }

      Anstallning anstallning = apiResponse.getAnstallningar().getLast();
      return ImmutableArbetsgivareResponse.builder()
            .organisationsnamn(anstallning.getOrganisation().getNamn())
            .organisationsnummer(anstallning.getOrganisation().getNummer())
            .arbetstidProcent(anstallning.getArbetstid())
            .anstallningsdag(anstallning.getStartdag())
            .sistaAnstallningsdag(anstallning.getSlutdag())
            .build();
   }

   public SpecificeradLonResponse toSpecificeradLonResponse(SpecificeradLon apiResponse)
   {
      List<LoneradDto> lonerader = apiResponse.getLonerader().stream()
            .map(lonerad -> {
               LoneradDto dto = ImmutableLoneradDto.builder()
                     .typ(lonerad.getTyp().name())
                     .beskrivning(lonerad.getBeskrivning())
                     .belopp(lonerad.getBelopp())
                     .build();
               return dto;
            })
            .collect(Collectors.toList());

      return ImmutableSpecificeradLonResponse.builder()
            .lonesumma(apiResponse.getLonesumma())
            .organisationsnamn(apiResponse.getOrganisation().getNamn())
            .organisationsnummer(apiResponse.getOrganisation().getNummer())
            .lonerader(lonerader)
            .build();
   }
}
