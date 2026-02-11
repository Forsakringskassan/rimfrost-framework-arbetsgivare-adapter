package se.fk.rimfrost.framework.arbetsgivare.adapter.dto;

import jakarta.annotation.Nullable;
import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDate;

@Value.Immutable
@JsonSerialize(as = ImmutableArbetsgivareResponse.class)
@JsonDeserialize(as = ImmutableArbetsgivareResponse.class)
public interface ArbetsgivareResponse
{
   String organisationsnummer();

   String organisationsnamn();

   int arbetstidProcent();

   LocalDate anstallningsdag();

   @Nullable
   LocalDate sistaAnstallningsdag();

}
