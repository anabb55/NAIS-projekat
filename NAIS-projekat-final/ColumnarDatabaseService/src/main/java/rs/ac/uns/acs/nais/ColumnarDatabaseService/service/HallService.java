package rs.ac.uns.acs.nais.ColumnarDatabaseService.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.uns.acs.nais.ColumnarDatabaseService.dto.HallDTO;
import rs.ac.uns.acs.nais.ColumnarDatabaseService.dto.WorkshopDTO;
import rs.ac.uns.acs.nais.ColumnarDatabaseService.entity.Hall;
import rs.ac.uns.acs.nais.ColumnarDatabaseService.entity.Workshop;
import rs.ac.uns.acs.nais.ColumnarDatabaseService.repository.HallRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private ModelMapper mapper;
    private Hall mapToEntity(HallDTO hallDTO){
        Hall hall = mapper.map(hallDTO, Hall.class);
        return hall;
    }

    private HallDTO mapToDTO(Hall hall){
        HallDTO hallDTO= mapper.map(hall, HallDTO.class);
        return hallDTO;
    }

    public HallDTO createHall(HallDTO hallDTO){
        Hall hall = mapToEntity(hallDTO);

        return mapToDTO(hallRepository.save(hall));
    }

    public HallDTO deleteHall(Long id){
        Hall hall= hallRepository.getById(id);
        hallRepository.delete(hall);
        return mapToDTO(hall);
    }

    public List<HallDTO> getAll(){
        List<Hall> halls = hallRepository.findAll();
        return halls.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }


    public HallDTO update(HallDTO hallDTO, Long id){
        Hall hall = hallRepository.getById(id);
        hall.setHallId(hallDTO.getHallId());
        hall.setHallId(hallDTO.getHallId());
        hall.setCapacity(hallDTO.getCapacity());
        hall.setBookingFee(hallDTO.getBookingFee());
        hall.setName(hallDTO.getName());
        hall.setEventsCount(hallDTO.getEventsCount());
        hall.setLocation(hallDTO.getLocation());
        return mapToDTO(hallRepository.save(hall));
    }
}