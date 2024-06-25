package rs.ac.uns.acs.nais.ColumnarDatabaseService.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rs.ac.uns.acs.nais.ColumnarDatabaseService.dto.WorkshopDateDTO;
import rs.ac.uns.acs.nais.ColumnarDatabaseService.entity.Workshop;

import java.util.List;

@Repository
public interface WorkshopRepository extends CassandraRepository<Workshop, Long> {
    @Query("SELECT * from workshops WHERE workshop_id = :id")
    Workshop getById(@Param("id")Long id);

    @Query("SELECT name, date FROM workshops WHERE hallId = :hall_id ALLOW FILTERING")
    List<WorkshopDateDTO> getByHall(@Param("hall_id")Long hall_id);
    @Query("SELECT workshop_id FROM workshops WHERE category in ('Anxiety', 'Depression') and is_online = true ALLOW FILTERING")
    List<Long> getWorkshopsByCategory();


}
//    select workshop_id, count(*) from nais.user_workshop where workshop_id in (1, 2, 6, 15) group by workshop_id;