package repository;

import entity.EscrowAddressPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author kingflag
 */
@Repository
public interface EscrowAddressPoRepository extends JpaRepository<EscrowAddressPo, String> {
}
