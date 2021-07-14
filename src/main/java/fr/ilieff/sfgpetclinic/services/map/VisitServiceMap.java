package fr.ilieff.sfgpetclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import fr.ilieff.sfgpetclinic.model.Visit;
import fr.ilieff.sfgpetclinic.services.VisitService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {



  private final VisitService visitService;

  @Override
  public Set<Visit> findAll() {

    return super.findAll();
  }

  @Override
  public Visit findById(Long id) {

    return super.findById(id);
  }

  @Override
  public Visit save(Visit visit) {
    if (visit.getPet() == null || visit.getPet().getOwner() == null
        || visit.getPet().getId() == null) {
      throw new RuntimeException("Invalid vist");
    }

    return super.save(visit);
  }

  @Override
  public void delete(Visit object) {
    super.delete(object);

  }

  @Override
  public void deleteByID(Long id) {
    super.deleteByID(id);

  }

}
