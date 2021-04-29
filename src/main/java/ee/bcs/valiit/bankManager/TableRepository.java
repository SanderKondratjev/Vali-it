package ee.bcs.valiit.bankManager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<LoginRequestTable, String> {
}
