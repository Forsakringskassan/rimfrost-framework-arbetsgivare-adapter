package se.fk.rimfrost.framework.arbetsgivare.adapter.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableLoneradDto.class)
@JsonDeserialize(as = ImmutableLoneradDto.class)
public interface LoneradDto
{
   String typ();

   String beskrivning();

   double belopp();
}
