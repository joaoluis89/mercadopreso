public interface CartRepository extends JpaRepository<Cart, String> {
    Optional<Cart> findByUserId(String userId);
}