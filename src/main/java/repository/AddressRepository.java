package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.Address;
import org.springframework.stereotype.Repository;


/**
 * @author kingflag
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
