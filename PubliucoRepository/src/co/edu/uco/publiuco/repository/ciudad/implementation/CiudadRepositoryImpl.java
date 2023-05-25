package co.edu.uco.publiuco.repository.ciudad.implementation;

import co.edu.uco.publiuco.crosscutting.helper.UUIDHelper;
import co.edu.uco.publiuco.entity.CiudadEntity;
import co.edu.uco.publiuco.repository.ciudad.CiudadRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.internal.util.StringHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CiudadRepositoryImpl implements CiudadRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CiudadEntity> findCustom(CiudadEntity ciudadEntity) {
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<CiudadEntity> query = criteriaBuilder.createQuery(CiudadEntity.class);
            Root<CiudadEntity> ciudadRoot = query.from(CiudadEntity.class);
            List<Predicate> predicates = new ArrayList<>();

            if (!Objects.isNull(ciudadEntity)){
                if (!UUIDHelper.isDefaultUUID(ciudadEntity.getCodigo())){
                    predicates.add(criteriaBuilder.equal(ciudadRoot.get("codigo"),ciudadEntity.getCodigo()));
                }
                if (StringHelper.isNotEmpty(ciudadEntity.getNombre())){
                    predicates.add(criteriaBuilder.equal(ciudadRoot.get("nombre"),ciudadEntity.getNombre()));
                }
                if (!UUIDHelper.isDefaultUUID(ciudadEntity.getDepartamento().getCodigo())){
                    predicates.add(criteriaBuilder.equal(ciudadRoot.get("departamento"),ciudadEntity.getDepartamento()));
                }
            }

            query.select(ciudadRoot).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

            return entityManager.createQuery(query).getResultList();

        }catch (Exception e){
            //TODO: Hacer las otras excepciones (SQL por ejemplo)}
            System.out.println(e.getMessage());
        }
        return null;
    }
}
