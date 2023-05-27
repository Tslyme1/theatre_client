package org.nsu.fit.theatre_client.repositories;

import org.nsu.fit.theatre_client.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface QueryRepository extends CrudRepository<EmployeeEntity, Integer> {
//1
    @Query(value = "select ep.first_name, ep.last_name, ep.patronymic_name\n" +
            "from \"employee\" e\n" +
            "inner join \"employeeprofile\" ep on e.\"id\" = ep.id \n" +
            "where extract (year from AGE(NOW()::date, e.dt_joined::date)) = 10", nativeQuery = true)
    List<Object> find1ByWorkedTime();

    @Query(value = "select ep.first_name, ep.last_name, ep.patronymic_name, ep.gender\n" +
            "from \"employee\" e\n" +
            "inner join \"employeeprofile\" ep on e.\"id\" = ep.id \n" +
            "where ep.gender = ?1", nativeQuery = true)
    List<Object> find1(String gender);

    @Query(value = "select ep.first_name, ep.last_name, ep.patronymic_name, ep.birth_dt\n" +
            "from \"employee\" e\n" +
            "inner join \"employeeprofile\" ep on e.\"id\" = ep.id\n" +
            "where extract(year from ep.birth_dt::date) = ?1", nativeQuery = true)
    List<Object> find1ByYear(Integer year);
//2
    @Query(value = "select count(*) from \"employee\"", nativeQuery = true)
    Object findWorkersCount();


    //3
    @Query(value = "select p.*, e.start_dt, e.end_dt\n" +
            "from \"play\" p\n" +
            "inner join \"event\" e ON e.play_id = p.id", nativeQuery = true)
    List<Object> findAllPlays();

    //4
    @Query(value = "select distinct ON (a.id) a.first_name, a.last_name, a.patronymic_name\n" +
            "from \"author\" a\n" +
            "inner join \"playauthormap\" pam ON pam.author_id = a.id \n" +
            "inner join \"play\" p on pam.play_id = p.id \n" +
            "inner join \"event\" e ON e.play_id = p.id", nativeQuery = true)
    List<Object> findAllAuthors();

    //5
    @Query(value = "select p.*\n" +
            "from \"play\" p\n" +
            "where p.genre = ?1", nativeQuery = true)
    List<Object> findAllPlayByGenre(String genre);

    //6
    @Query(value = "select ep.first_name, ep.last_name, ep.patronymic_name\n" +
            "from \"actor\" a\n" +
            "inner join \"employee\" e ON a.employee_id = e.\"id\"\n" +
            "inner join \"employeeprofile\" ep on e.\"id\" = ep.id \n" +
            "inner join \"quality\" q on a.quality_id = q.id\n" +
            "where q.id = (select quality_id from \"role\" r where r.id = ?1)", nativeQuery = true)
    List<Object> findActorsToRole(Integer roleId);

    //7
    @Query(value = "select count(*) from \"actor\"", nativeQuery = true)
    List<Object> findActorsCount();

    //8
    @Query(value = "with tour_act_pr as (\n" +
            "    select distinct on (pr.id)\n" +
            "    pr.id, t.start_dt, t.end_dt, pl.id as play_id, 'producer' as employee_type\n" +
            "    from \"tour\" t\n" +
            "    inner join \"play\" pl on t.play_id = pl.id \n" +
            "    inner join \"playproducermap\" ppm on ppm.play_id = pl.id\n" +
            "    inner join \"producer\" pr on pr.id = ppm.producer_id\n" +
            "    union\n" +
            "    select distinct on (a.id)\n" +
            "    a.id, t.start_dt, t.end_dt, pl.id as play_id, 'actor' as employee_type\n" +
            "    from \"tour\" t\n" +
            "    inner join \"play\" pl on t.play_id = pl.id \n" +
            "    inner join \"roleplaymap\" rpm on rpm.play_id = pl.id\n" +
            "    inner join \"role\" r ON rpm.role_id = r.id\n" +
            "    inner join \"actor\" a on r.actor_id = a.id\n" +
            ")\n" +
            "\n" +
            "select * from tour_act_pr\n" +
            "where start_dt > ?1 and end_dt < ?2", nativeQuery = true)
    List<Object> findListActorsAndProducers(Date start, Date end);

    //9
    @Query(value = "select e.start_dt\n" +
            "from \"event\" e\n" +
            "where e.play_id = ?1\n" +
            "and e.premiere is true", nativeQuery = true)
    List<Object> findPremiereDate(Integer play_id);

    //10
    @Query(value = "select count(distinct r.id)\n" +
            "from \"role\" r\n" +
            "inner join \"roleplaymap\" rpm on rpm.role_id = r.id\n" +
            "inner join \"play\" p on p.id = rpm.play_id\n" +
            "inner join \"event\" e on e.play_id = p.id\n" +
            "where r.actor_id = ?1 and e.end_dt < NOW()::DATE", nativeQuery = true)
    Object findCountActorRoles(Integer actor_id);

    //11
    @Query(value = "select count(*) from \"ticket\" t  ", nativeQuery = true)
    Object findSoldTickets();

    //12
    @Query(value = "select SUM(t.price) \n" +
            "from \"ticket\" t \n" +
            "join \"event\" e on t.event_id = e.id\n" +
            "where e.play_id = ?1", nativeQuery = true)
    Object findPlayRevenue(Integer playId);

    //13
    @Query(value = "select e.id, e.seats_left \n" +
            "from \"event\" e \n" +
            "where e.start_dt > NOW()::date", nativeQuery = true)
    Object findFreeSeats();
}
