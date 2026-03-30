package se.fk.rimfrost.adapter.arbetsgivare.dto;

import org.immutables.value.Value;
import java.time.LocalDate;

@Value.Immutable
public interface SpecificeradLonRequest
{
   String personnummer();

   LocalDate fromDatum();

   LocalDate tomDatum();
}
