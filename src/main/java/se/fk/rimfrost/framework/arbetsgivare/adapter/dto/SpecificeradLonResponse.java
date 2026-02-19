package se.fk.rimfrost.framework.arbetsgivare.adapter.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
@JsonSerialize(as = ImmutableSpecificeradLonResponse.class)
@JsonDeserialize(as = ImmutableSpecificeradLonResponse.class)
public interface SpecificeradLonResponse
{
   double lonesumma();

   String organisationsnamn();

   String organisationsnummer();

   List<LoneradDto> lonerader();
}
