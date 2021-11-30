package de.tekup.rst.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.rst.dto.models.MetDTO;
import de.tekup.rst.entities.ClientEntity;
import de.tekup.rst.entities.MetEntity;
import de.tekup.rst.entities.Plat;
import de.tekup.rst.entities.TicketEntity;
import de.tekup.rst.repositories.ClientRepository;
import de.tekup.rst.repositories.MetRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatService {
	
	private MetRepository metRepository;
	private ClientRepository clientRepository;
	
	public MetDTO platPlusAcheter(LocalDate deb, LocalDate fin) {
		ModelMapper mapper = new ModelMapper();
		
		List<MetEntity> metEntities = metRepository.findAll();
		//filter only Plat
		metEntities.removeIf( met -> !(met instanceof Plat));
		// the same as
//		for (MetEntity met: metEntities) {
//			if(!(met instanceof Plat))
//				metEntities.remove(met);
//		}
		
		// filter ticket by Date
		for (MetEntity metEntity : metEntities) {
			metEntity.getTickets()
			.removeIf(t-> t.getDateTime().toLocalDate().isBefore(deb)
					|| t.getDateTime().toLocalDate().isAfter(fin));
		}
		MetEntity plat = null;
		int max = -1;
	
		for (MetEntity metEntity : metEntities) {
			if(metEntity.getTickets().size()> max) {
				max = metEntity.getTickets().size();
				plat = metEntity;
			}
		}
		
		// second solution
//		MetEntity plat2 = metRepository.findAll().stream()
//						.filter(met ->!(met instanceof Plat))
//						.peek(met -> met.getTickets().removeIf((t-> t.getDateTime().toLocalDate().isBefore(deb)
//					|| t.getDateTime().toLocalDate().isAfter(fin))))
//						.max(Comparator.comparing(met ->  met.getTickets().size()))
//						.get();
		
		return mapper.map(plat, MetDTO.class);
	}
	
	public String clientJour(int clientId) {
		ClientEntity client = clientRepository.findById(clientId).get();
		List<TicketEntity> tickets = client.getTickets();
		List<LocalDateTime> dateTimes = tickets.stream()
										.map(t-> t.getDateTime())
										.collect(Collectors.toList());
		System.out.println(dateTimes);
		List<DayOfWeek> days = dateTimes.stream()
						.map(dt -> dt.getDayOfWeek())
						.collect(Collectors.toList());
		System.out.println(days);
		
		Map<DayOfWeek, Long> map = days.stream()
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
		
		DayOfWeek day = map.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.get().getKey();
		
		return day.getDisplayName(TextStyle.FULL, new Locale("ar"));
	}

}
