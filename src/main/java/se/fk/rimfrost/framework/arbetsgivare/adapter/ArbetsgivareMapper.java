package se.fk.rimfrost.framework.arbetsgivare.adapter;

import jakarta.enterprise.context.ApplicationScoped;
import se.fk.rimfrost.framework.arbetsgivare.adapter.dto.ArbetsgivareResponse;
import se.fk.rimfrost.framework.arbetsgivare.adapter.dto.ImmutableArbetsgivareResponse;
import se.fk.rimfrost.api.arbetsgivare.jaxrsspec.controllers.generatedsource.model.Anstallning;
import se.fk.rimfrost.api.arbetsgivare.jaxrsspec.controllers.generatedsource.model.GetArbetsgivare200Response;

@ApplicationScoped
public class ArbetsgivareMapper
{

   public ArbetsgivareResponse toArbetsgivareResponse(GetArbetsgivare200Response apiResponse)
   {

      if (apiResponse.getAnstallningar().isEmpty())
      {
         return ImmutableArbetsgivareResponse.builder()
               .organisationsNr(null)
               .arbetstid(null)
               .startdag(null)
               .slutdag(null)
               .build();
      }
      Anstallning anstallning = apiResponse.getAnstallningar().getLast();
      return ImmutableArbetsgivareResponse.builder()
            .organisationsNr(anstallning.getOrganisation().getNummer())
            .arbetstid(anstallning.getArbetstid())
            .startdag(anstallning.getStartdag())
            .slutdag(anstallning.getSlutdag())
            .build();
   }
}
