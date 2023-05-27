package org.nsu.fit.theatre_client.services;

import lombok.RequiredArgsConstructor;
import org.nsu.fit.theatre_client.dto.ActorDTO;
import org.nsu.fit.theatre_client.dto.EmployeeDTO;
import org.nsu.fit.theatre_client.dto.FullNameDTO;
import org.nsu.fit.theatre_client.entities.*;
import org.nsu.fit.theatre_client.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeProfileRepository employeeProfileRepository;
    private final EmployeeAttributeRepository employeeAttributeRepository;
    private final AttributeRepository attributeRepository;
    private final EmployeeCategoryRepository employeeCategoryRepository;
    private final CategoryRepository categoryRepository;
    private final ActorRepository actorRepository;
    private final MusicianRepository musicianRepository;
    private final DirectorRepository directorRepository;
    private final ProducerRepository producerRepository;
    private final QualityRepository qualityRepository;
    private final StaffRepository staffRepository;
    private final ActorContestMapRepository actorContestMapRepository;
    private final RoleRepository roleRepository;
    private final PlayMusicianMapRepository playMusicianMapRepository;
    private final PlayDirectorMapRepository playDirectorMapRepository;
    private final PlayProducerMapRepository playProducerMapRepository;


    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        for(EmployeeEntity employeeEntity : employeeEntities){
            employeeDTOS.add(createDTO(employeeEntity));
        }
        return employeeDTOS;
    }

    public EmployeeEntity saveEmployee(EmployeeDTO employeeDTO){
        EmployeeprofileEntity EmployeeprofileEntity = new EmployeeprofileEntity();
        EmployeeprofileEntity.setFirstName(employeeDTO.getFirstName());
        EmployeeprofileEntity.setLastName(employeeDTO.getLastName());
        EmployeeprofileEntity.setPatronymicName(employeeDTO.getPatronymicName());
        EmployeeprofileEntity.setGender(employeeDTO.getGender());
        EmployeeprofileEntity.setKidsCount(employeeDTO.getKidsCount());
        EmployeeprofileEntity.setBirthDt(employeeDTO.getBirthDate());

        var profile = employeeProfileRepository.save(EmployeeprofileEntity);

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setEmployeeprofileByProfile(profile);
        employeeEntity.setSalary(employeeDTO.getSalary());
        employeeEntity.setInvitedBy(employeeDTO.getInvitedBy());

        EmployeeEntity newEmployee = employeeRepository.save(employeeEntity);
        for(Pair<String, String> attribute : employeeDTO.getAttributes()){
            var attributeId = attributeRepository.findByName(attribute.getFirst()).get();
            EmployeeattributeEntity EmployeeattributeEntity = new EmployeeattributeEntity();
            EmployeeattributeEntity.setEmployeeByEmployeeId(newEmployee);
            EmployeeattributeEntity.setAttributeByAttributeId(attributeId);
            EmployeeattributeEntity.setValue(attribute.getSecond());

            employeeAttributeRepository.save(EmployeeattributeEntity);
        }
        return newEmployee;
    }

    public List<EmployeeEntity> findByFullName(FullNameDTO fullNameDTO){
        List<EmployeeprofileEntity> entities = employeeProfileRepository.findByFirstNameAndLastNameAndPatronymicName(fullNameDTO.getFirstName(), fullNameDTO.getLastName(), fullNameDTO.getPatronymicName());
        List<Integer> ids = new ArrayList<>();
        for(EmployeeprofileEntity entity : entities){
            ids.add(entity.getId());
        }

        return employeeRepository.findAllById(ids);
    }
    public List<ActorDTO> getActors(){
        List<ActorEntity> actorEntities = actorRepository.findAll();
        List<ActorDTO> actorDTOS = new ArrayList<>();
        for(ActorEntity actor : actorEntities){
            ActorDTO actorDTO = new ActorDTO();

            EmployeeEntity employeeEntity = employeeRepository.getReferenceById(actor.getEmployeeId());
            EmployeeDTO employeeDTO = createDTO(employeeEntity);

            actorDTO.setId(employeeEntity.getId());
            actorDTO.setEmployeeDTO(employeeDTO);

            QualityEntity qualityEntity = actor.getQualityByQualityId();
            actorDTO.setVoice(qualityEntity.getVoice());
            actorDTO.setHeight(qualityEntity.getHeight());
            actorDTO.setAge(qualityEntity.getAge());
            actorDTO.setGender(qualityEntity.getGender());

            actorDTOS.add(actorDTO);
        }
        return actorDTOS;
    }
    public List<EmployeeDTO> getMusicians(){
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        List<MusicianEntity> musicianEntities = musicianRepository.findAll();
        for(MusicianEntity musicianEntity : musicianEntities){
            EmployeeEntity employeeEntity = employeeRepository.getReferenceById(musicianEntity.getEmployeeId());
            employeeDTOS.add(createDTO(employeeEntity));
        }

        return employeeDTOS;
    }
    public EmployeeDTO getMusician(Integer id){
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        Optional<MusicianEntity> musicianEntity = musicianRepository.findById(id);
        if(musicianEntity.isEmpty()){
            throw new RuntimeException("No musician with id: " + id);
        }
        return createDTO(employeeRepository.getReferenceById(musicianEntity.get().getEmployeeId()));
    }
    public ActorDTO getActor(Integer id){
        ActorDTO actorDTO = new ActorDTO();
        Optional<ActorEntity> actorEntity = actorRepository.findById(id);
        if(actorEntity.isEmpty()){
            throw new RuntimeException("No actor with id: " + id);
        }
        actorDTO.setId(actorEntity.get().getId());
        actorDTO.setEmployeeDTO(createDTO(employeeRepository.getReferenceById(actorEntity.get().getEmployeeId())));
        actorDTO.setHonored_artist(actorEntity.get().isHonoredArtist());
        actorDTO.setNational_artist(actorEntity.get().isNationalArtist());
        actorDTO.setStudent(actorEntity.get().isStudent());

        QualityEntity qualityEntity = actorEntity.get().getQualityByQualityId();
        actorDTO.setVoice(qualityEntity.getVoice());
        actorDTO.setHeight(qualityEntity.getHeight());
        actorDTO.setAge(qualityEntity.getAge());
        actorDTO.setGender(qualityEntity.getGender());

        return actorDTO;
    }
    public List<EmployeeDTO> getDirectors(){
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        List<DirectorEntity> directorEntities = directorRepository.findAll();
        for(DirectorEntity directorEntity : directorEntities){
            EmployeeEntity employeeEntity = employeeRepository.getReferenceById(directorEntity.getEmployeeId());
            employeeDTOS.add(createDTO(employeeEntity));
        }

        return employeeDTOS;
    }
    public EmployeeDTO getDirector(Integer id){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Optional<DirectorEntity> directorEntity = directorRepository.findById(id);
        if(directorEntity.isEmpty()){
            throw new RuntimeException("no director with id: " + id);
        }

        return createDTO(employeeRepository.getReferenceById(directorEntity.get().getEmployeeId()));
    }
    public List<EmployeeDTO> getProducers(){
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        List<ProducerEntity> producerEntities = producerRepository.findAll();
        for(ProducerEntity producerEntity : producerEntities){
            EmployeeEntity employeeEntity = employeeRepository.getReferenceById(producerEntity.getEmployeeId());
            employeeDTOS.add(createDTO(employeeEntity));
        }
        return employeeDTOS;
    }
    public EmployeeDTO getProducer(Integer id){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Optional<ProducerEntity> producerEntity = producerRepository.findById(id);
        if(producerEntity.isEmpty()){
            throw new RuntimeException("no director with id: " + id);
        }

        return createDTO(employeeRepository.getReferenceById(producerEntity.get().getEmployeeId()));
    }
    public ActorEntity saveActor(ActorDTO actorDTO){
        int employeeId  = saveEmployee(actorDTO.getEmployeeDTO()).getId();

        QualityEntity qualityEntity = new QualityEntity();
        qualityEntity.setGender(actorDTO.getGender());
        qualityEntity.setAge(actorDTO.getAge());
        qualityEntity.setHeight(actorDTO.getHeight());
        qualityEntity.setVoice(actorDTO.getVoice());
        var qualityId = qualityRepository.save(qualityEntity);

        ActorEntity actorEntity = new ActorEntity();
        actorEntity.setEmployeeId(employeeId);
        actorEntity.setQualityByQualityId(qualityId);
        actorEntity.setHonoredArtist(actorDTO.getHonored_artist());
        actorEntity.setNationalArtist(actorDTO.getNational_artist());
        actorEntity.setStudent(actorDTO.getStudent());

        return actorRepository.save(actorEntity);
    }
    public void deleteActor(Integer id){
        Optional<ActorEntity> actorEntity = actorRepository.findByEmployeeId(id);
        if(actorEntity.isEmpty()){
            throw new RuntimeException("Actor does not exists");
        }
        EmployeeEntity employeeEntity = employeeRepository.getReferenceById(actorEntity.get().getEmployeeId());
        employeeRepository.deleteById(id);
        employeeProfileRepository.deleteById(id);
        employeeAttributeRepository.deleteByEmployeeByEmployeeId(employeeEntity);
        employeeCategoryRepository.deleteByEmployeeByEmployeeId(employeeEntity);

        actorRepository.deleteByEmployeeId(id);
        actorContestMapRepository.deleteByActorByActorId(actorEntity.get());

        List<RoleEntity> roleEntities = roleRepository.findAllByActorByActorId(actorEntity.get());
        for(RoleEntity entity : roleEntities){
            entity.setActorByActorId(null);
            roleRepository.save(entity);
        }

        List<RoleEntity> roleEntities1 = roleRepository.findAllByActorByBackup(actorEntity.get());
        for(RoleEntity entity : roleEntities1){
            entity.setActorByBackup(null);
            roleRepository.save(entity);
        }
    }
    //TODO delete/update musician director producer


    public MusicianEntity saveMusician(EmployeeDTO employeeDTO){
        int employeeId = saveEmployee(employeeDTO).getId();
        MusicianEntity musicianEntity = new MusicianEntity();
        musicianEntity.setEmployeeId(employeeId);
        return musicianRepository.save(musicianEntity);
    }
    public void deleteMusician(Integer id){
        Optional<MusicianEntity> musicianEntity = musicianRepository.findByEmployeeId(id);
        if(musicianEntity.isEmpty()){
            throw new RuntimeException("no musician with employee id: " + id);
        }
        EmployeeEntity employeeEntity = employeeRepository.getReferenceById(id);
        musicianRepository.deleteByEmployeeId(id);
        employeeAttributeRepository.deleteByEmployeeByEmployeeId(employeeRepository.getReferenceById(id));
        employeeCategoryRepository.deleteByEmployeeByEmployeeId(employeeEntity);
        employeeRepository.deleteById(id);
        playMusicianMapRepository.deleteAllByMusicianByMusicianId(musicianEntity.get());
    }
    public StaffEntity saveStaff(EmployeeDTO employeeDTO){
        int employeeId = saveEmployee(employeeDTO).getId();
        StaffEntity staffEntity = new StaffEntity();
        staffEntity.setEmployeeId(employeeId);
        return staffRepository.save(staffEntity);
    }
    public void deleteStaff(Integer id){
        Optional<StaffEntity> staffEntity = staffRepository.findByEmployeeId(id);
        if(staffEntity.isEmpty()){
            throw new RuntimeException("no staff with employee id: " + id);
        }

        staffRepository.deleteById(staffEntity.get().getId());
        employeeRepository.deleteById(id);
        employeeAttributeRepository.deleteByEmployeeByEmployeeId(employeeRepository.getReferenceById(id));
        employeeCategoryRepository.deleteByEmployeeByEmployeeId(employeeRepository.getReferenceById(id));
    }

    public EmployeeDTO createDTO(EmployeeEntity employeeEntity){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        List<Pair<String, String>> attributes = new ArrayList<>();
        List<EmployeeattributeEntity> employeeAttributeEntities = employeeAttributeRepository.findAllByEmployeeByEmployeeId(employeeEntity);
        for(EmployeeattributeEntity employeeattributeEntity : employeeAttributeEntities){
            attributes.add(Pair.of(employeeattributeEntity.getValue(), employeeattributeEntity.getAttributeByAttributeId().getName()));
        }
        employeeDTO.setAttributes(attributes);

        employeeDTO.setCategories(new ArrayList<>());
        List<EmployeecategoryEntity> employeeCategoryEntities = employeeCategoryRepository.findAllByEmployeeByEmployeeId(employeeEntity);
        for(EmployeecategoryEntity entity : employeeCategoryEntities){
            employeeDTO.getCategories().add(entity.getCategoryByCategoryId().getName());
        }
        EmployeeprofileEntity EmployeeprofileEntity = employeeEntity.getEmployeeprofileByProfile();
        employeeDTO.setGender(EmployeeprofileEntity.getGender());

        employeeDTO.setKidsCount(EmployeeprofileEntity.getKidsCount());

        employeeDTO.setId(employeeEntity.getId());
        employeeDTO.setFirstName(EmployeeprofileEntity.getFirstName());
        employeeDTO.setLastName(EmployeeprofileEntity.getLastName());
        employeeDTO.setPatronymicName(EmployeeprofileEntity.getPatronymicName());
        employeeDTO.setBirthDate(EmployeeprofileEntity.getBirthDt());
        employeeDTO.setInvitedBy(employeeEntity.getInvitedBy());

        employeeDTO.setSalary(employeeEntity.getSalary());
        return employeeDTO;
    }
}
